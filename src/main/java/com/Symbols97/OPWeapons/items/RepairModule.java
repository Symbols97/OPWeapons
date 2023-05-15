package com.Symbols97.OPWeapons.items;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;


public class RepairModule extends Item {

	public RepairModule() {
		this.setMaxDamage(24);
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
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Repair your tools and weapons");
		// textList.add(com.mojang.realmsclient.gui.ChatFormatting.ITALIC + "");
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