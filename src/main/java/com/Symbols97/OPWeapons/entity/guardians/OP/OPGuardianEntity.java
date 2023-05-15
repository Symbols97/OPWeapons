package com.Symbols97.OPWeapons.entity.guardians.OP;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.entity.guardians.BaseGuardianEntity;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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

public class OPGuardianEntity extends BaseGuardianEntity {

	public OPGuardianEntity(EntityType<? extends Monster> p_21368_, Level p_21369_) {
		super(p_21368_, p_21369_);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new OPGuardianEntity.OPGuadianTargetGoal<>(this, Player.class));
	}

	static class OPGuadianTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {

		public OPGuadianTargetGoal(OPGuardianEntity opGuardianEntity, Class<T> mobTarget) {
			super(opGuardianEntity, mobTarget, true);
		}

		boolean wearingArmor = false;

		public boolean canUse() {
			if (this.targetType == Player.class) {
				this.target = this.mob.level.getNearestPlayer(this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());

				if (this.target instanceof Player player) {

					LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
					entityCapability.ifPresent(capability -> {
						wearingArmor = capability.isWearingOPArmor();
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
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0), this);
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0), this);
			}
			return true;
		} else {
			return false;
		}
	}
}
