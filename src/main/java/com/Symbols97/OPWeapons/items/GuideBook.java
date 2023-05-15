package com.Symbols97.OPWeapons.items;

import com.Symbols97.OPWeapons.screen.helpscreens.BookSplashScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import vazkii.patchouli.api.PatchouliAPI;

public class GuideBook extends Item {

	public GuideBook(Properties p_40643_) {
		super(p_40643_);
		// TODO Auto-generated constructor stub
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

		if (level.isClientSide()) {
			if(!ModList.get().isLoaded("patchouli")) {
				Minecraft.getInstance().setScreen(new BookSplashScreen(new TextComponent("")));
			} else {
				PatchouliAPI.get().openBookGUI(new ResourceLocation("opweapons:guide_book"));
			}
			
			
		}
		return super.use(level, player, hand);
	}

}
