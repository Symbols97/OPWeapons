package com.Symbols97.OPWeapons.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;

public class opFlintandSteel extends ItemFlintAndSteel {
	
	public opFlintandSteel()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(256);
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
	
	@Override
	public boolean hasContainerItem(ItemStack itemstack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemstack) {
		itemstack.attemptDamageItem(1, itemRand);
		return itemstack;
	}
}
