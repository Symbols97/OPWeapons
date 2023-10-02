package com.Symbols97.OPWeapons.entity.guardians;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class BaseGuardianEntity extends Monster implements IAnimatable, ILoopType {

	private AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public BaseGuardianEntity(EntityType<? extends Monster> p_21368_, Level p_21369_) {
		super(p_21368_, p_21369_);
	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMobAttributes()
				.add(Attributes.FOLLOW_RANGE, 50.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.4F)
				.add(Attributes.MAX_HEALTH, 12500.0D)
				.add(Attributes.ATTACK_SPEED, 1.0D)
				.add(Attributes.ATTACK_DAMAGE, 400.0D).build();
	}

	@Override
	public int getExperienceReward() {
		return 75;
	}
	

	@Override
	protected void checkFallDamage(double p_20990_, boolean p_20991_, BlockState p_20992_, BlockPos p_20993_) {

	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.guardians.walking", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}

		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.guardians.idle", EDefaultLoopTypes.LOOP));
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
		// "attackController",
		// 0, this::attackPredicate));

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
