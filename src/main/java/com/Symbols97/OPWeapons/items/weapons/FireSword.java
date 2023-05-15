package com.Symbols97.OPWeapons.items.weapons;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class FireSword extends SwordItem {

	public FireSword(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		DamageSource ds = DamageSource.ON_FIRE;

		target.hurt(ds, 1F);

		target.setSecondsOnFire(10);

		return super.hurtEnemy(stack, target, attacker);
	}

}
