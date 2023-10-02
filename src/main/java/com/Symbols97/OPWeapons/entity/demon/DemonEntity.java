package com.Symbols97.OPWeapons.entity.demon;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.state.BlockState;
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

public class DemonEntity extends Monster implements IAnimatable, ILoopType{

	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	
	public DemonEntity(EntityType<? extends Monster> p_21368_, Level p_21369_) {
		super(p_21368_, p_21369_);
		this.fallDistance = 0;
		
	}
	
	public static AttributeSupplier setAttributes() {
	      return Monster.createMobAttributes()
	    		  .add(Attributes.FOLLOW_RANGE, 400.0D)
	    		  .add(Attributes.MOVEMENT_SPEED, (double)0.3F)
	    		  .add(Attributes.MAX_HEALTH, 10000.0D)//10000.0D)
	    		  .add(Attributes.ATTACK_SPEED, 0.5D)
	    		  .add(Attributes.ATTACK_DAMAGE, 80.0D).build();
	   }

	@Override
	public int getExperienceReward() {
		return 50;
	}
	
	@Override
	public boolean fireImmune() {

		return true;
	}

	@Override
	protected void checkFallDamage(double p_20990_, boolean p_20991_, BlockState p_20992_, BlockPos p_20993_) {
	}
	
	@Override
	protected void registerGoals() {   
		 this.goalSelector.addGoal(1, new FloatGoal(this));
	     this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
	     this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	     this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
	     this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
	     this.targetSelector.addGoal(2, new DemonEntity.DemonTargetGoal<>(this, Player.class));
	   }

	 static class DemonTargetGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
	      public DemonTargetGoal(DemonEntity p_33832_, Class<T> p_33833_) {
	         super(p_33832_, p_33833_, true);
	      }
			boolean wearingArmor = false;

			public boolean canUse() {
				if (this.targetType == Player.class) {
					this.target = this.mob.level.getNearestPlayer(this.targetConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());

					if (this.target instanceof Player player) {

						LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
						entityCapability.ifPresent(capability -> {
							wearingArmor = capability.isWearingDemonArmor();
						});
					}
				}
				return wearingArmor ? false : super.canUse();
			}
		}


	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.demon.walking", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}

		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.demon.idle", EDefaultLoopTypes.LOOP));
		return PlayState.CONTINUE;
	}

	

//	private <E extends IAnimatable> PlayState attackPredicate(AnimationEvent<E> event) {
//        if(event.getController().getAnimationState().equals(AnimationState.Stopped)) {
//            event.getController().markNeedsReload();
//            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.reaper_mob.idle", false));
//        }
//        return PlayState.CONTINUE;
//	
//	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller1", 0, this::predicate));
		//data.addAnimationController(new AnimationController(this, "attackController", 0, this::attackPredicate));

	   
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public boolean isRepeatingAfterEnd() {
		// TODO Auto-generated method stub
		return true;
	}

}
