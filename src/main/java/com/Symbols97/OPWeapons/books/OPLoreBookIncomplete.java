package com.Symbols97.OPWeapons.books;

import java.util.List;

import com.Symbols97.OPWeapons.gui.GUILoreBookIncomplete;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

public class OPLoreBookIncomplete extends ItemEditableBook {
	
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return false;
	}

	public OPLoreBookIncomplete(){
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(world.isRemote)
			FMLCommonHandler.instance().showGuiScreen(new GUILoreBookIncomplete());

		return stack;
	}

	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {
		
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "By Symbols97");
			
			
		
	 }
	}