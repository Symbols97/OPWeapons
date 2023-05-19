package com.Symbols97.OPWeapons.screen.helpscreens;

import org.jetbrains.annotations.NotNull;

import com.Symbols97.OPWeapons.management.Management;
import com.Symbols97.OPWeapons.util.OPWTags;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.widget.ExtendedButton;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;

@OnlyIn(Dist.CLIENT)
public class TierHelpScreen extends Screen {
	private static ResourceLocation TEXTURE = new ResourceLocation("opweapons:textures/gui/tierscreen.png");
	private static ResourceLocation TEXTURE2 = new ResourceLocation("opweapons:textures/gui/tierscreen2.png");
	public TierHelpScreen(Component text) {
		super(text);

	}

	@Override
	public boolean isPauseScreen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void renderBackground(PoseStack pPoseStack) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - 384) / 2;
		int y = (height - 172) / 2;
		this.blit(pPoseStack, x, y, 0, 0, 256, 256);
		RenderSystem.setShaderTexture(0, TEXTURE2);
		int x2 = (width - 128) / 2;
		int y2 = (height - 172) / 2;
		this.blit(pPoseStack, x2, y2, 0, 0, 256, 256);
		this.font.draw(pPoseStack, Component.literal("Repair Item"), x + 5, y + 5, 0xffffff);
		int xvalue = 0;
		for (int i = 1; i <=4; i++) {
			this.font.draw(pPoseStack, Component.literal(String.format("| Tier %s", i)), (x + 96) + xvalue, y + 5, 0xffffff);
			xvalue += 62;
			if (i == 2) {
				xvalue += 5;
			}
			if (i == 3) {
				xvalue += 13;
			}
		}
//		this.font.draw(pPoseStack, Component.literal("| Tier 1"), x + 96, y + 5, 0xffffff);
//		this.font.draw(pPoseStack, Component.literal("| Tier 2"), x + 158, y + 5, 0xffffff);
//		this.font.draw(pPoseStack, Component.literal("| Tier 3"), x + 220, y + 5, 0xffffff);
//		this.font.draw(pPoseStack, Component.literal("| Tier 4"), x + 295, y + 5, 0xffffff);
		this.font.draw(pPoseStack, Component.literal("-------------------------------"), x + 0, y + 12, 0xffffff);
		this.font.draw(pPoseStack, Component.literal("---------------------------------"), x + 186, y + 12, 0xffffff);
		
		
		@NotNull
		ITag<Item> t1 = ForgeRegistries.ITEMS.tags().getTag(OPWTags.Items.IS_TIER1);
		ITag<Item> t2 = ForgeRegistries.ITEMS.tags().getTag(OPWTags.Items.IS_TIER2);
		ITag<Item> t3 = ForgeRegistries.ITEMS.tags().getTag(OPWTags.Items.IS_TIER3);
		ITag<Item> t4 = ForgeRegistries.ITEMS.tags().getTag(OPWTags.Items.IS_TIER4);
		String name = null;
		int k = 0;
		int j = 0;
		String item = null;
		for (int i = 1; i <= 4; i++) {
			this.font.draw(pPoseStack, Component.literal(String.format("Tier %s:", i)), x + 5, (y + 20) + k, 0xffffff);
			k += 20;
			if (i <= 3) {
				item = "Repair Module";
			} else if (i >= 4) {
				item = "Ult Nether Star";
			}
			this.font.draw(pPoseStack, Component.literal(String.format(" -" + item, i)), x + 5, (y + 30) + j, 0xffffff);
			j += 20;
		}
		
		k = 0;
		for (Item element : t1) {
			name = element.toString().replace("_", " ");
			name = Management.capatilize(name);
			this.font.draw(pPoseStack, Component.literal("|"), x + 96, (y + 20) + k, 0xffffff);
			this.font.draw(pPoseStack, Component.literal(String.format("%s", name)), x + 103, (y + 20) + k, 0xffffff);
			this.font.draw(pPoseStack, Component.literal("|"), x + 158, (y + 20) + k, 0xffffff);
			k += 10;
		}
		k = 0;
		for (Item element : t2) {
			name = element.toString().replace("_", " ");
			name = Management.capatilize(name);
			this.font.draw(pPoseStack, Component.literal(String.format("%s", name)), x + 163, (y + 20) + k, 0xffffff);
			this.font.draw(pPoseStack, Component.literal("|"), x + 158, (y + 20) + k, 0xffffff);
			k += 10;
		}
		k = 0;
		for (Item element : t3) {
			name = element.toString().replace("_", " ");
			name = Management.capatilize(name);
			this.font.draw(pPoseStack, Component.literal(String.format("%s", name)), x + 230, (y + 20) + k, 0xffffff);
			this.font.draw(pPoseStack, Component.literal("|"), x + 225, (y + 20) + k, 0xffffff);
			k += 10;
		}
		k = 0;
		for (Item element : t4) {
			name = element.toString().replace("_", " ");
			name = Management.capatilize(name);
			this.font.draw(pPoseStack, Component.literal(String.format("%s", name)), x + 305, (y + 20) + k, 0xffffff);
			this.font.draw(pPoseStack, Component.literal("|"), x + 300, (y + 20) + k, 0xffffff);
			k += 10;
		}

		this.addRenderableWidget(
				new ExtendedButton(x + 365, y  + 2, 12, 12, Component.literal("X"), button -> {
					this.onClose();	
				}));
		
	}

	@Override
	public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
		renderBackground(pPoseStack);
		super.render(pPoseStack, mouseX, mouseY, delta);
		// renderTooltip(pPoseStack, mouseX, mouseY);

	}

}
