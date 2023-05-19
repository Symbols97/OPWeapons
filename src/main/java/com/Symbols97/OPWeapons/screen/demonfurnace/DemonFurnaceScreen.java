package com.Symbols97.OPWeapons.screen.demonfurnace;


import com.Symbols97.OPWeapons.screen.helpscreens.FuelScreen;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.gui.widget.ExtendedButton;

public class DemonFurnaceScreen extends AbstractContainerScreen<DemonFurnaceMenu> {

	protected Component playerInventoryTitle;

	private static ResourceLocation TEXTURE = new ResourceLocation("opweapons:textures/gui/demonfurnacegui.png");

	public DemonFurnaceScreen(DemonFurnaceMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
		this.playerInventoryTitle = Component.literal("§fInventory");
	}

	@Override
	protected void init() {
		 int x = (width - imageWidth) / 2;
	     int y = (height - imageHeight) / 2;

	        this.addRenderableWidget(new ExtendedButton(x + 155,y + 5,16, 16, Component.literal("?"), (button) -> {
	            Minecraft.getInstance().setScreen(new FuelScreen(Component.literal(""), 2));
	        }));

		super.init();
	}

	@Override
	protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - imageWidth) / 2;
		int y = (height - imageHeight) / 2;
		this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

		if (menu.isBurning()) {
			int l1 = menu.getBurnTimeRemainingScaled(13);
			blit(pPoseStack, x + 56, y + 48 - l1, 176, 12 - l1, 14, l1 + 1);
			l1 = menu.getCookProgressScaled(24);
			blit(pPoseStack, x + 79, y + 34, 176, 14, l1 + 1, 16);
		}

	}

	@Override
	public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
		renderBackground(pPoseStack);
		super.render(pPoseStack, mouseX, mouseY, delta);
		renderTooltip(pPoseStack, mouseX, mouseY);

	}

	@Override
	protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
		this.font.draw(p_97808_, this.title, (float) this.titleLabelX + 40, (float) this.titleLabelY, 4210752);
		this.font.draw(p_97808_, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY,
				4210752);

		int percent = 0;
		if (menu.isBurning()) {
			percent = menu.percentDisplay();
		}

		String percentdisplay = String.format("§fFuel: %d" + "%%", percent);
		this.font.draw(p_97808_, percentdisplay, 6, 176 - 135, 0x000000);

	}

}
