package com.Symbols97.OPWeapons.managment;

import cpw.mods.fml.common.Loader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class ModLoadedChecker {
	
	public static boolean isneiLoaded = Loader.isModLoaded("NotEnoughItems");
	
	public static void successMessage(EntityPlayer player) {
		
		if (isneiLoaded) {
			player.addChatMessage(new ChatComponentText(String.format("§bNEI has been detected. Hooray, no books!")));
		} else {
			player.addChatMessage(new ChatComponentText(String.format("§4NEI has NOT been detected. Consider installing for easier")));
			player.addChatMessage(new ChatComponentText(String.format("§4access to recipes.")));
		}
		
	}

}
