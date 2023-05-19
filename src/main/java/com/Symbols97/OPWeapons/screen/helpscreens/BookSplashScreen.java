package com.Symbols97.OPWeapons.screen.helpscreens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.Util;
import net.minecraft.client.gui.screens.ConfirmLinkScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.widget.ExtendedButton;

public class BookSplashScreen extends Screen{

	private static ResourceLocation TEXTURE = new ResourceLocation("opweapons:textures/gui/bookspashscreen.png");
	
	public BookSplashScreen(Component p_96550_) {
		super(p_96550_);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void renderBackground(PoseStack pPoseStack) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - 256) / 2;
		int y = (height - 170) / 2;
		this.blit(pPoseStack, x, y, 0, 0, 256, 256);
		this.font.draw(pPoseStack, Component.literal("Due to the complexity of the mod this book's full"), x + 5, y + 12, 0xffffff);
		this.font.draw(pPoseStack, Component.literal("potential is accessible using the mod Patchouli."), x + 5, y + 22, 0xffffff);
		this.font.draw(pPoseStack, Component.literal("Patchouli is §eHighly Recommended §fby not required."), x + 5, y + 32, 0xffffff);
		
		this.font.draw(pPoseStack, Component.literal("Both the server and client must agree to both"), x + 5, y + 47, 0xffffff);
		this.font.draw(pPoseStack, Component.literal("have or not have Patchouli in order to work."), x + 5, y + 57, 0xffffff);
		
		this.font.draw(pPoseStack, Component.literal("Recipe info is handled by JEI"), x + 55, y + 73, 0xffffff);
		
		this.font.draw(pPoseStack, Component.literal("These links will take you directly to Curseforge"), x + 5, y + 93, 0xffffff);
		this.font.draw(pPoseStack, Component.literal("to download these mods if you so choose"), x + 5, y + 103, 0xffffff);
		
		this.addRenderableWidget(
				new ExtendedButton(x + 55, y + 123, 32, 16, Component.literal("JEI"), button -> {
					String jei = "https://www.curseforge.com/minecraft/mc-mods/jei";
					this.minecraft.setScreen(new ConfirmLinkScreen((p_169339_) -> {
			            if (p_169339_) {
			               Util.getPlatform().openUri(jei);
			            }

			            this.minecraft.setScreen(this);
			         }, jei, true));
				     
					
//					URL jei = null;
//					try {
//						jei = new URL("https://www.curseforge.com/minecraft/mc-mods/jei");
//					} catch (MalformedURLException e) {
//						
//						e.printStackTrace();
//					}
//					
//					Util.getPlatform().openUrl(jei);
						
				}));
		this.addRenderableWidget(
				new ExtendedButton(x + 145, y + 123, 64, 16, Component.literal("Patchouli"), button -> {
					String patchouli = "https://www.curseforge.com/minecraft/mc-mods/patchouli";
					this.minecraft.setScreen(new ConfirmLinkScreen((p_169339_) -> {
			            if (p_169339_) {
			               Util.getPlatform().openUri(patchouli);
			            }

			            this.minecraft.setScreen(this);
			         }, patchouli, true));
					
//					URL patchouli = null;
//					try {
//						patchouli = new URL("https://www.curseforge.com/minecraft/mc-mods/patchouli");
//					} catch (MalformedURLException e) {
//						
//						e.printStackTrace();
//					}
//				
//					Util.getPlatform().openUrl(patchouli);
					
				}));
	}
	
	@Override
	public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
		renderBackground(p_96562_);
		super.render(p_96562_, p_96563_, p_96564_, p_96565_);
	}

}
