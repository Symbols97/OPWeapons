package com.Symbols97.OPWeapons.entity.frosty_ostrich;

import java.util.UUID;

import javax.annotation.Nullable;

import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PlayerRideable;
import net.minecraft.world.entity.PlayerRideableJumping;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class FrostyOstrichEntity extends TamableAnimal implements IAnimatable, ILoopType, PlayerRideable, PlayerRideableJumping {

	private AnimationFactory factory = new AnimationFactory(this);

	static double baseHealth = 10000.0;
	static double tamedHealth = 50000.0;
	protected boolean isJumping;
	protected float playerJumpPendingScale;
	private boolean allowStandSliding;

	public FrostyOstrichEntity(EntityType<? extends TamableAnimal> entity, Level level) {
		super(entity, level);
		this.setTame(false);
	}

	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes().add(Attributes.MOVEMENT_SPEED, (double) 0.5F).add(Attributes.MAX_HEALTH, baseHealth).add(Attributes.JUMP_STRENGTH, 1.0D)
				.add(Attributes.ATTACK_DAMAGE, 2.0D).build();
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.5D, 6.0F, 10.0F, true));
		this.goalSelector.addGoal(5, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1, 5));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));

	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("isSitting", this.getIsSitting());

	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		setIsSitting(tag.getBoolean("isSitting"));
	}

	public void setIsSitting(boolean isSitting) {
		this.entityData.set(SITTING, isSitting);
	}

	public boolean getIsSitting() {
		return this.entityData.get(SITTING).booleanValue();
	}

	@Override
	public float getStepHeight() {
		return 1;
	}

	@Override
	protected void checkFallDamage(double p_20990_, boolean p_20991_, BlockState p_20992_, BlockPos p_20993_) {
	}

	private static final EntityDataAccessor<Boolean> SITTING = SynchedEntityData.defineId(FrostyOstrichEntity.class, EntityDataSerializers.BOOLEAN);

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SITTING, false);
	}

	@Override
	public void setTame(boolean p_30443_) {
		super.setTame(p_30443_);
		if (p_30443_) {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(tamedHealth);
			this.setHealth((float) tamedHealth);
		} else {
			this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(baseHealth);
		}

		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	@Override
	public boolean isFood(ItemStack pStack) {
		return pStack.getItem() == OPWItems.snow_cone.get() || pStack.getItem() == OPWItems.pet_food.get();
	}
	@Override
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		// Item item = itemstack.getItem();
		Item tameableItem = OPWItems.snow_cone.get();
		Item petFood = OPWItems.pet_food.get();

		if (this.level.isClientSide) {
			boolean flag = this.isOwnedBy(player) || this.isTame() || itemstack.is(tameableItem) && !this.isTame();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {

				if (itemstack.is(tameableItem) && !this.isInLove()) {
					return super.mobInteract(player, hand);
				}

				if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
					this.heal((float) itemstack.getFoodProperties(this).getNutrition());
					if (itemstack.is(petFood)) {
						this.setHealth((float) tamedHealth);
					}
					if (!player.getAbilities().instabuild) {
						itemstack.shrink(1);
					}

					this.gameEvent(GameEvent.MOB_INTERACT, this.eyeBlockPosition());
					return InteractionResult.SUCCESS;
				}

				if (!player.isCrouching() && player.getMainHandItem().isEmpty() && !this.isBaby() && !this.isSitting()) {

					player.startRiding(this, true);
					setSitting(!isSitting());

				} else {
					super.mobInteract(player, hand);
				}

				if (player.isCrouching() && hand == InteractionHand.MAIN_HAND && !this.isSitting()) {
					setSitting(!isSitting());
				} else if (this.isSitting()) {
					setSitting(!isSitting());
				}

			} else if (itemstack.is(tameableItem)) {
				if (!player.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
					this.tame(player);
					this.navigation.stop();

					this.setTarget((LivingEntity) null);
					this.setOrderedToSit(true);
					this.level.broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level.broadcastEntityEvent(this, (byte) 6);
				}
				return InteractionResult.SUCCESS;
			}

			return super.mobInteract(player, hand);
		}
	}

	public void setSitting(boolean sitting) {
		this.entityData.set(SITTING, sitting);
		this.setOrderedToSit(sitting);
	}

	public boolean isSitting() {
		return this.entityData.get(SITTING);
	}

	@Override
	public Vec3 getLeashOffset() {
		if (this.isSitting()) {
			return new Vec3(0.0D, (double) this.getEyeHeight() - 2.0D, (double) (this.getBbWidth() * 0.8F));
		} else {
			return new Vec3(0.0D, (double) this.getEyeHeight() - 0.5D, (double) (this.getBbWidth() * 0.8F));
		}
	}

	@Override
	public FrostyOstrichEntity getBreedOffspring(ServerLevel p_149088_, AgeableMob p_149089_) {
		FrostyOstrichEntity ostrich = OPWEntities.FROSTYOSTRICH.get().create(p_149088_);
		UUID uuid = this.getOwnerUUID();
		if (uuid != null) {
			ostrich.setOwnerUUID(uuid);
			ostrich.setTame(true);
		}

		return ostrich;
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frosty_ostrich.walking", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}

		if (this.isSitting()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frosty_ostrich.sitting2", EDefaultLoopTypes.HOLD_ON_LAST_FRAME)
					.addAnimation("animation.frosty_ostrich.sitting", EDefaultLoopTypes.LOOP));
			// event.getController().setAnimation(new
			// AnimationBuilder().addAnimation("animation.frosty_ostrich.sitting2",
			// EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		} else if (!event.isMoving() && !this.isSitting()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.frosty_ostrich.idle", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		return PlayState.CONTINUE;

	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));

	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public boolean isRepeatingAfterEnd() {
		return false;
	}

	public boolean canBeControlledByRider() {
		return this.getControllingPassenger() instanceof LivingEntity;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getFirstPassenger();
	}

	public boolean isJumping() {
		return this.isJumping;
	}
	public void setIsJumping(boolean p_30656_) {
		this.isJumping = p_30656_;
	}
	public double getCustomJump() {
		return this.getAttributeValue(Attributes.JUMP_STRENGTH);
	}

	public void travel(Vec3 p_30633_) {
		if (this.isAlive()) {
			if (this.isVehicle() && this.canBeControlledByRider()) {
				LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
				this.setYRot(livingentity.getYRot());
				this.yRotO = this.getYRot();
				this.setXRot(livingentity.getXRot() * 0.5F);
				this.setRot(this.getYRot(), this.getXRot());
				this.yBodyRot = this.getYRot();
				this.yHeadRot = this.yBodyRot;
				float f = livingentity.xxa * 0.5F;
				float f1 = livingentity.zza;
				if (f1 <= 0.0F) {
					f1 *= 0.25F;

				}

				if (this.onGround && this.playerJumpPendingScale == 0.0F && !this.allowStandSliding) {
					f = 0.0F;
					f1 = 0.0F;
				}

				if (this.playerJumpPendingScale > 0.0F && !this.isJumping() && this.onGround) {
					double d0 = this.getCustomJump() * (double) this.playerJumpPendingScale * (double) this.getBlockJumpFactor();
					double d1 = d0 + this.getJumpBoostPower();
					Vec3 vec3 = this.getDeltaMovement();
					this.setDeltaMovement(vec3.x, d1, vec3.z);
					this.setIsJumping(true);
					this.hasImpulse = true;
					net.minecraftforge.common.ForgeHooks.onLivingJump(this);
					if (f1 > 0.0F) {
						float f2 = Mth.sin(this.getYRot() * ((float) Math.PI / 180F));
						float f3 = Mth.cos(this.getYRot() * ((float) Math.PI / 180F));
						this.setDeltaMovement(
								this.getDeltaMovement().add((double) (-0.4F * f2 * this.playerJumpPendingScale), 0.0D, (double) (0.4F * f3 * this.playerJumpPendingScale)));
					}

					this.playerJumpPendingScale = 0.0F;
				}

				this.flyingSpeed = this.getSpeed() * 0.1F;
				if (this.isControlledByLocalInstance()) {
					this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					super.travel(new Vec3((double) f, p_30633_.y, (double) f1));
				} else if (livingentity instanceof Player) {
					this.setDeltaMovement(Vec3.ZERO);
				}

				if (this.onGround) {
					this.playerJumpPendingScale = 0.0F;
					this.setIsJumping(false);
				}

				this.calculateEntityAnimation(this, false);
				this.tryCheckInsideBlocks();
			} else {
				this.flyingSpeed = 0.02F;
				super.travel(p_30633_);
			}
		}
	}

	@Override
	public double getPassengersRidingOffset() {
		// TODO Auto-generated method stub
		return 1.8F;
	}

	@Override
	public Vec3 getDismountLocationForPassenger(LivingEntity pLivingEntity) {
		Direction direction = this.getMotionDirection();
		if (direction.getAxis() == Direction.Axis.Y) {
			return super.getDismountLocationForPassenger(pLivingEntity);
		} else {
			int[][] aint = DismountHelper.offsetsForDirection(direction);
			BlockPos blockpos = this.blockPosition();
			BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

			for (Pose pose : pLivingEntity.getDismountPoses()) {
				AABB axisalignedbb = pLivingEntity.getLocalBoundsForPose(pose);

				for (int[] aint1 : aint) {
					blockpos$mutable.set(blockpos.getX() + aint1[0], blockpos.getY(), blockpos.getZ() + aint1[1]);
					double d0 = this.level.getBlockFloorHeight(blockpos$mutable);
					if (DismountHelper.isBlockFloorValid(d0)) {
						Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos$mutable, d0);
						if (DismountHelper.canDismountTo(this.level, pLivingEntity, axisalignedbb.move(vec3))) {
							pLivingEntity.setPose(pose);
							return vec3;
						}
					}
				}
			}

			return super.getDismountLocationForPassenger(pLivingEntity);
		}
	}

	@Override
	public void onPlayerJump(int p_30591_) {

		if (p_30591_ < 0) {
			p_30591_ = 0;
		} else {
			this.allowStandSliding = true;
		}

		if (p_30591_ >= 90) {
			this.playerJumpPendingScale = 1.0F;
		} else {
			this.playerJumpPendingScale = 0.4F + 0.4F * (float) p_30591_ / 90.0F;
		}

	}

	@Override
	public boolean canJump() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void handleStartJump(int p_21695_) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleStopJump() {
		// TODO Auto-generated method stub

	}

}