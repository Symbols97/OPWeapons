package com.Symbols97.OPWeapons.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UltimateNetherStar extends Item {
	 @Override
	    public boolean hasEffect(ItemStack par1ItemStack)
	    {
		    return true;
	    }
	 
	 
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Has various uses. Can also repair special weapons");
		// textList.add(com.mojang.realmsclient.gui.ChatFormatting.ITALIC + "");
	 }
	 
}
