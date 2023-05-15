package com.Symbols97.OPWeapons.weapons_tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class iceSword extends ItemSword {

	public iceSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO Auto-generated constructor stub
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity) {
		hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 400, 1));
		hitEntity.addPotionEffect(new PotionEffect(Potion.weakness.id, 400, 1));
		return super.hitEntity(stack, hitEntity, attackingEntity);
	}
}
