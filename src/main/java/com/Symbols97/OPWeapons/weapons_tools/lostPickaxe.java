package com.Symbols97.OPWeapons.weapons_tools;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class lostPickaxe extends ItemPickaxe {

	public lostPickaxe(ToolMaterial material) {
		super(material);
		
	}
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Used to mine the Block o' Enchanting");
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.ITALIC + "Used for nothing else");
	 }
}
