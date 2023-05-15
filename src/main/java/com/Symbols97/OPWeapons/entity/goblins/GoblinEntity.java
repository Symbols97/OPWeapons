package com.Symbols97.OPWeapons.entity.goblins;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
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

public class GoblinEntity extends Monster implements IAnimatable, ILoopType {

	private AnimationFactory factory = new AnimationFactory(this);

	public GoblinEntity(EntityType<? extends Monster> p_21368_, Level p_21369_) {
		super(p_21368_, p_21369_);
		this.fallDistance = 0;
	}

	public static AttributeSupplier setAttributes() {
		return Monster.createMobAttributes()
				.add(Attributes.FOLLOW_RANGE, 8.0D)
				.add(Attributes.MOVEMENT_SPEED, (double) 0.5F)
				.add(Attributes.MAX_HEALTH, 300.0D)
				.add(Attributes.ATTACK_SPEED, 1.0D)
				.add(Attributes.ATTACK_DAMAGE, 30.0D).build();
	}

	@Override
	protected int getExperienceReward(Player p_21511_) {
		return 5;
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
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblins.walking", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}

		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.goblins.idle", EDefaultLoopTypes.LOOP));
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
