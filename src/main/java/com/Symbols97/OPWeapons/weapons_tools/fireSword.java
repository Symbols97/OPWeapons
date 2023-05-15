package com.Symbols97.OPWeapons.weapons_tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;

public class fireSword extends ItemSword {

	public fireSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

		DamageSource ds = DamageSource.onFire;

		target.attackEntityFrom(ds, 1F);

		target.setFire(10);
		return super.hitEntity(stack, target, attacker);
	}

}
