package com.Symbols97.OPWeapons.items.weapons;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class IceSword extends SwordItem{

	public IceSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 1), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 400, 1), attacker);

		return super.hurtEnemy(stack, target, attacker);
	}

}
