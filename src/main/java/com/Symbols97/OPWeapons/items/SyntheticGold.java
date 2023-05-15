package com.Symbols97.OPWeapons.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class syntheticGold extends Item {
	
	public syntheticGold()
    {
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
	
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GOLD + "Wrap around Iron Ingots to get a stack of Gold Ingots");
		// textList.add(com.mojang.realmsclient.gui.ChatFormatting.ITALIC + "");
	 }
}