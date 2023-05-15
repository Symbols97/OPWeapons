package com.Symbols97.OPWeapons.books;

import java.util.List;

import com.Symbols97.OPWeapons.gui.GUIOPBook;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;
public class OPWeaponsBook extends ItemEditableBook {

	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return false;
	}

	public OPWeaponsBook(){
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(world.isRemote)
			FMLCommonHandler.instance().showGuiScreen(new GUIOPBook());

		return stack;
	}

	
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {
		
		if (GuiScreen.isShiftKeyDown()) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GREEN + "Volume 1 teaches you ");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GREEN + "the start of the mod.");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GREEN + "However I can only fit");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GREEN + "so many pages to a book.");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GREEN + "To continue, make Vol 2.");
			
		} else {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "By Symbols97");
			String info = String.format("§fHold §aSHIFT §ffor more info");
			
			textList.add(info);
		}
	 }
	
}