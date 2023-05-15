package com.Symbols97.OPWeapons.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DemonGemCore extends Item {
	
	 @Override
	    public boolean hasEffect(ItemStack par1ItemStack)
	    {
		    return true;
	    }
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {
		// textList.add(com.mojang.realmsclient.gui.ChatFormatting.RED + "Used to create the OP Furnace");
		// textList.add(com.mojang.realmsclient.gui.ChatFormatting.ITALIC + "");
	 }
}
