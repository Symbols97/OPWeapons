package com.Symbols97.OPWeapons.items;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class soulHarvester extends Item {
	
	public soulHarvester()
    {
        this.maxStackSize = 1;
  
    }
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips) {
	
		textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Warning! : Use one at a time!");
		textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Having multiple in your inventory will consume them all."); 
	}

}
