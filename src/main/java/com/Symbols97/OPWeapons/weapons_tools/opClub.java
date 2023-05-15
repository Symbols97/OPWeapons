package com.Symbols97.OPWeapons.weapons_tools;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class opClub extends ItemSword {

	public opClub(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO Auto-generated constructor stub
	}

	
	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity)
	{
	stack.damageItem(1, attackingEntity);
	hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 0));
	
	hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
	
	hitEntity.addPotionEffect(new PotionEffect(Potion.confusion.id, 60, 0));

	return true;
	}
	
	
}
