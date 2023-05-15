package com.Symbols97.OPWeapons.weapons_tools;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class frostSlayer extends ItemSword{

	public frostSlayer(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		// TODO Auto-generated constructor stub
	}
	@Override
    public boolean hasEffect(ItemStack par1ItemStack)
    {
	    return true;
    }
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity)
	{
	stack.damageItem(1, attackingEntity);
	hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 100));
	hitEntity.addPotionEffect(new PotionEffect(Potion.weakness.id, 200, 3));
	hitEntity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 200, 3));
	hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 200, 0));
	hitEntity.addPotionEffect(new PotionEffect(Potion.jump.id, 600, 200));
	return true;
	}
	
	
	protected boolean canRepair = false;
	public boolean isRepairable()
    {
        return canRepair;
    }
;
	public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
        return false;
    }
	public Item setNoRepair()
    {
        canRepair = false;
        return this;
    }
	
		 
	
}

