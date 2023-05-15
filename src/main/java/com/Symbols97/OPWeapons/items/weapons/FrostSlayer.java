package com.Symbols97.OPWeapons.items.weapons;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class FrostSlayer extends SwordItem{

	public FrostSlayer(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFoil(ItemStack p_41453_) {
		return true;
	}
	
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 100));
		target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 3));
		target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 3));
		target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0));
		target.addEffect(new MobEffectInstance(MobEffects.JUMP, 600, 200));

		return super.hurtEnemy(stack, target, attacker);
	}

}
