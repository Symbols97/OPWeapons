package com.Symbols97.OPWeapons.entity.deadwolf;

import java.util.UUID;

import javax.annotation.Nullable;

import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DeadWolfEntity extends Wolf implements IAnimatable, ILoopType {

	private AnimationFactory factory = new AnimationFactory(this);

	static double baseHealth = 10000.0;
	static double tamedHealth = 50000.0;

	public DeadWolfEntity(EntityType<? extends Wolf> entity, Level level) {
		super(entity, level);
		this.fallDistance = 0F;
		this.getStepHeight();
	}

	public static AttributeSupplier setAttributes() {
		return Animal.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, (double) 0.4F)
				.add(Attributes.MAX_HEALTH, baseHealth)
				.add(Attributes.ATTACK_DAMAGE, 2.0D).build();
	}

	@Override
	public float getStepHeight() {
		return 1;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	protected void checkFallDamage(double p_20990_, boolean p_20991_, BlockState p_20992_, BlockPos p_20993_) {
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
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		// Item item = itemstack.getItem();
		Item tameableItem = OPWItems.spicy_chicken.get();
		Item petFood = OPWItems.pet_food.get();

		if (this.level.isClientSide) {
			boolean flag = this.isOwnedBy(player) || this.isTame() || itemstack.is(tameableItem) && !this.isTame() && !this.isAngry();
			return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
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

				// if (!(item instanceof DyeItem)) {
				// InteractionResult interactionresult =
				// super.mobInteract(player, hand);
				// if ((!interactionresult.consumesAction() || this.isBaby()) &&
				// this.isOwnedBy(player)) {
				// this.setOrderedToSit(!this.isOrderedToSit());
				// this.jumping = false;
				// this.navigation.stop();
				// this.setTarget((LivingEntity)null);
				// return InteractionResult.SUCCESS;
				// }
				//
				// return interactionresult;
				// }

				// DyeColor dyecolor = ((DyeItem) item).getDyeColor();
				// if (dyecolor != this.getCollarColor()) {
				// this.setCollarColor(dyecolor);
				// if (!player.getAbilities().instabuild) {
				// itemstack.shrink(1);
				// }
				//
				// return InteractionResult.SUCCESS;
				// }

				if (!this.isInSittingPose() && !player.isCrouching() && player.getMainHandItem().isEmpty() && !this.isBaby()) {

					player.startRiding(this, true);

					this.setOrderedToSit(!this.isOrderedToSit());

				}
				if (player.isCrouching() && hand == InteractionHand.MAIN_HAND && !this.isInSittingPose()) {
					this.setOrderedToSit(this.isOrderedToSit());;
				}

			} else if (itemstack.is(tameableItem) && !this.isAngry()) {
				if (!player.getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				if (this.random.nextInt(15) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
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

	@Override
	public DeadWolfEntity getBreedOffspring(ServerLevel p_149088_, AgeableMob p_149089_) {
		DeadWolfEntity wolf = OPWEntities.DEADWOLF.get().create(p_149088_);
		UUID uuid = this.getOwnerUUID();
		if (uuid != null) {
			wolf.setOwnerUUID(uuid);
			wolf.setTame(true);
		}

		return wolf;
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dead_wolf.walking", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}

		if (this.isInSittingPose()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dead_wolf.sitting", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}

		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dead_wolf.idle", EDefaultLoopTypes.LOOP));
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
		return true;
	}

	public boolean canBeControlledByRider() {
		return this.getControllingPassenger() instanceof LivingEntity;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getFirstPassenger();
	}

	public double getCustomJump() {
		return this.getAttributeValue(Attributes.JUMP_STRENGTH);
	}

	public void travel(Vec3 pTravelVector) {
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

				if (this.isControlledByLocalInstance()) {
					this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					super.travel(new Vec3((double) f, pTravelVector.y, (double) f1));
				} else if (livingentity instanceof Player) {
					this.setDeltaMovement(Vec3.ZERO);
				}

				this.calculateEntityAnimation(this, false);
				this.tryCheckInsideBlocks();
			} else {
				super.travel(pTravelVector);
			}
		}
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

}
