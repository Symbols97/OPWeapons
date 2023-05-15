package com.Symbols97.OPWeapons.entity.guardians.Frost;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.entity.guardians.BaseGuardianEntity;

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

public class FrostGuardianEntity extends BaseGuardianEntity{

	public FrostGuardianEntity(EntityType<? extends Monster> p_21368_, Level p_21369_) {
		super(p_21368_, p_21369_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new FrostGuardianEntity.FrostGuadianTargetGoal<>(this, Player.class));
	}
	
	 static class FrostGuadianTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
	      public FrostGuadianTargetGoal(FrostGuardianEntity p_33832_, Class<T> p_33833_) {
	         super(p_33832_, p_33833_, true);
	      }

			boolean wearingArmor = false;

			public boolean canUse() {
				if (this.targetType == Player.class) {
					this.target = this.mob.level.getNearestPlayer(this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());

					if (this.target instanceof Player player) {

						LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
						entityCapability.ifPresent(capability -> {
							wearingArmor = capability.isWearingFrostArmor();
						});
					}
				}
				return wearingArmor ? false : super.canUse();
			}
		}

}
