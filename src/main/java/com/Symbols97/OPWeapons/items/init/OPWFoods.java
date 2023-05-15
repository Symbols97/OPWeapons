package com.Symbols97.OPWeapons.items.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class OPWFoods {

	public static final FoodProperties magic_food = (new FoodProperties.Builder()).nutrition(20).saturationMod(100F)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6000, 5), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 5), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 6000, 5), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 5), 1F)
			.alwaysEat().fast().meat().build();

	
	public static final FoodProperties magic_mutton = (new FoodProperties.Builder()).nutrition(20).saturationMod(100F)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 3), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 6000, 3), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 6000, 4), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 6000, 2), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 6000, 5), 1F)
			.alwaysEat().fast().meat().build();

	public static final FoodProperties pet_food = (new FoodProperties.Builder()).nutrition(0).saturationMod(0F)
			.alwaysEat().meat().build();
	
	public static final FoodProperties spicy_chicken = (new FoodProperties.Builder()).nutrition(20).saturationMod(100F)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 1), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1800, 0), 1F)
			.alwaysEat().fast().meat().build();
	
	public static final FoodProperties snow_cone = (new FoodProperties.Builder()).nutrition(20).saturationMod(100F)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 1), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1800, 0), 1F)
			.alwaysEat().fast().build();
	
	public static final FoodProperties hot_coffee = (new FoodProperties.Builder()).nutrition(20).saturationMod(100F)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6000, 3), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 6000, 1), 1F)
			.alwaysEat().fast().build();
	
	public static final FoodProperties ice_coffee = (new FoodProperties.Builder()).nutrition(20).saturationMod(100F)
			.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 6000, 1), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 6000, 1), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 6000, 3), 1F)
			.effect(() -> new MobEffectInstance(MobEffects.JUMP, 6000, 1), 1F)
			.alwaysEat().fast().build();

	
}
