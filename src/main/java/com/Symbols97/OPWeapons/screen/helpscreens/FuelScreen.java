package com.Symbols97.OPWeapons.screen.helpscreens;

import com.Symbols97.OPWeapons.blocks.entity.DemonFurnaceBlockEntity;
import com.Symbols97.OPWeapons.blocks.entity.FreezerBlockEntity;
import com.Symbols97.OPWeapons.blocks.entity.OPFurnaceBlockEntity;
import com.Symbols97.OPWeapons.management.Management;
import com.Symbols97.OPWeapons.util.OPWTags;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;

public class FuelScreen extends Screen{

	private static ResourceLocation TEXTURE = new ResourceLocation("opweapons:textures/gui/fuelscreen/fuelscreen.png");
	int num = 0;
	public FuelScreen(Component p_96550_, int x) {
		super(p_96550_);
		this.num = x;

	}
	
	@Override
	public boolean isPauseScreen() {
		return false;
	}
	
	@Override
	public void renderBackground(PoseStack pPoseStack) {
		ITag<Item> fuel = null;

		switch (num) {
			case 1: fuel = ForgeRegistries.ITEMS.tags().getTag(OPWTags.Items.IS_OPFURNACEFUEL);
					TEXTURE = new ResourceLocation("opweapons:textures/gui/fuelscreen/fuelscreen.png");
					break;
			case 2: fuel = ForgeRegistries.ITEMS.tags().getTag(OPWTags.Items.IS_DEMONFURNACEFUEL);
					TEXTURE = new ResourceLocation("opweapons:textures/gui/fuelscreen/demonfuelscreen.png");
					break;
			case 3: fuel = ForgeRegistries.ITEMS.tags().getTag(OPWTags.Items.IS_FCFUEL);
					TEXTURE = new ResourceLocation("opweapons:textures/gui/fuelscreen/freezerfuelscreen.png");
					break;
		}
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - 256) / 2;
		int y = (height - 170) / 2;
		this.blit(pPoseStack, x, y, 0, 0, 256, 256);
		
		this.font.draw(pPoseStack, new TextComponent("Fuel Items"), x + 12, y + 5, 0xffffff);
		this.font.draw(pPoseStack, new TextComponent("Fuel Times / 1 Item"), x + 140, y + 5, 0xffffff);
		this.font.draw(pPoseStack, new TextComponent("------------------------------------------"), x + 2, y + 12, 0xffffff);
		

		String name = null;
		float fuel_duration = 0;
		int k = 0;
		for (Item element : fuel) {
			switch(num) {
				case 1: fuel_duration = OPFurnaceBlockEntity.fuelBurnDuration(new ItemStack (element));
						break;
					
				case 2: fuel_duration = DemonFurnaceBlockEntity.fuelBurnDuration(new ItemStack (element));
						break;
				case 3: fuel_duration = FreezerBlockEntity.fuelBurnDuration(new ItemStack (element));
						break;
			}
			

			name = element.toString().replace("_", " ");
			name = Management.capatilize(name);
			fuel_duration = fuel_duration / 20 ;
			this.font.draw(pPoseStack, new TextComponent("|"), x + 5, (y + 20) + k, 0xffffff);
			this.font.draw(pPoseStack, new TextComponent(String.format("%s", name)), x + 12, (y + 20) + k, 0xffffff);
			this.font.draw(pPoseStack, new TextComponent(String.format("| %.2f seconds", fuel_duration)), x + 140, (y + 20) + k, 0xffffff);
			this.font.draw(pPoseStack, new TextComponent("------------------------------------------"), x + 2, (y + 30) + k, 0xffffff);
			k += 20;
		}

		
		
	}
	
	@Override
	public void render(PoseStack p_96562_, int p_96563_, int p_96564_, float p_96565_) {
		renderBackground(p_96562_);
		super.render(p_96562_, p_96563_, p_96564_, p_96565_);
	}
}
