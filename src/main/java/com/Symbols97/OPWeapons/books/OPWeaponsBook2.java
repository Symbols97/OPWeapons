package com.Symbols97.OPWeapons.books;

import java.util.List;

import com.Symbols97.OPWeapons.gui.GUIOPBook;
import com.Symbols97.OPWeapons.gui.GUIOPBook2;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OPWeaponsBook2 extends ItemEditableBook {

	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return false;
	}

	public OPWeaponsBook2(){
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(world.isRemote)
			FMLCommonHandler.instance().showGuiScreen(new GUIOPBook2());

		return stack;
	}

	
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {
		
	
			String subtitle = String.format("§f\"§aAdvanced Weapon Parts§f\"");
			textList.add(subtitle);
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "By Symbols97");
			
			
		
	 }
	
}