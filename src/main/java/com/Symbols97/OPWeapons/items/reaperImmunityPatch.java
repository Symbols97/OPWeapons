package com.Symbols97.OPWeapons.items;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class reaperImmunityPatch extends Item {
	
	public reaperImmunityPatch() {
		this.maxStackSize = 8;
		
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
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {		
		
	
     textList.add("§cReaper Immunity Patch");
    
		
	 }
	
	
	

}
