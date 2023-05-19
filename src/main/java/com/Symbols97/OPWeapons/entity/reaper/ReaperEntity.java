package com.Symbols97.OPWeapons.entity.reaper;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ReaperEntity extends Monster implements IAnimatable, ILoopType {

	private AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public ReaperEntity(EntityType<? extends Monster> p_21368_, Level p_21369_) {
		super(p_21368_, p_21369_);
		this.setAirSupply(300);
	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMobAttributes().add(Attributes.FOLLOW_RANGE, 25.0D).add(Attributes.MOVEMENT_SPEED, (double) 0.3F).add(Attributes.MAX_HEALTH, 15000.0D)
				.add(Attributes.ATTACK_SPEED, 0.5D).add(Attributes.ATTACK_DAMAGE, 0.5D).build();
	}

	@Override
	public int getExperienceReward() {
		return 100;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new ReaperEntity.ReaperTargetGoal<>(this, Player.class));
	}

	static class ReaperTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
		public ReaperTargetGoal(ReaperEntity p_33832_, Class<T> p_33833_) {
			super(p_33832_, p_33833_, true);
		}

		boolean wearingArmor = false;

		public boolean canUse() {
			if (this.targetType == Player.class) {
				this.target = this.mob.level.getNearestPlayer(this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());

				if (this.target instanceof Player player) {

					LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
					entityCapability.ifPresent(capability -> {
						wearingArmor = capability.isWearingReaperArmor();
					});
				}
			}
			return wearingArmor ? false : super.canUse();
		}

	}

	@Override
	public boolean doHurtTarget(Entity entity) {
		if (super.doHurtTarget(entity)) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 100), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 0), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 600, 10), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 0), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.HUNGER, 600, 100), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, 600, 0), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, 600, 1), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 1), this);
			}
			return true;
		} else {
			return false;
		}
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.reaper_mob.walking", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}

		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.reaper_mob.idle", EDefaultLoopTypes.LOOP));
		return PlayState.CONTINUE;
	}

	// private <E extends IAnimatable> PlayState
	// attackPredicate(AnimationEvent<E> event) {
	// if(event.getController().getAnimationState().equals(AnimationState.Stopped))
	// {
	// event.getController().markNeedsReload();
	// event.getController().setAnimation(new
	// AnimationBuilder().addAnimation("animation.reaper_mob.attacking",
	// false));
	// }
	// return PlayState.CONTINUE;
	//
	// }
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
		// data.addAnimationController(new AnimationController(this,
		// "attackController", 0, this::attackPredicate));

	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public boolean isRepeatingAfterEnd() {
		return true;
	}

}
