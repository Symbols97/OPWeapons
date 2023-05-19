package com.Symbols97.OPWeapons.screen.freezer;

import com.Symbols97.OPWeapons.blocks.entity.FreezerBlockEntity.Mode;
import com.Symbols97.OPWeapons.management.packets.PacketHandler;
import com.Symbols97.OPWeapons.management.packets.blockentity.freezer.ServerBoundFreezer;
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

public class FreezerScreen extends AbstractContainerScreen<FreezerMenu> {
	protected Component screentitle  = Component.literal("");
	private Component button_label = Component.literal("");
	protected Component playerInventoryTitle;
	private static ResourceLocation TEXTURE = new ResourceLocation("opweapons:textures/gui/freezergui.png");
	

	public FreezerScreen(FreezerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
		
		
			
		this.playerInventoryTitle = Component.literal("§fInventory");
	}

	@Override
	protected void init() {
		 int x = (width - imageWidth) / 2;
	     int y = (height - imageHeight) / 2;
		this.addRenderableWidget(
				new ExtendedButton(x + 155, y - 25, 16, 16, Component.literal("?"), button -> {
					Minecraft.getInstance().setScreen(new FuelScreen(Component.literal(""), 3));		
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
		this.blit(pPoseStack, x, y - 32, 0, 0, imageWidth, 208);

		if (menu.isBurning()) {
			int l1 = menu.getBurnTimeRemainingScaled(95);
			blit(pPoseStack, x + 48, y + 41, 0, 209, l1 + 1, 9);
			l1 = menu.getCookProgressScaled(24);
			blit(pPoseStack, x + 82, y + 3, 176, 14, l1 + 1, 16);
		}

		
		this.addRenderableWidget(new ExtendedButton(x + 5, y - 25, 49, 16, button_label, button -> {
			
			if (menu.isBurning()) {
				this.minecraft.player.clientSideCloseContainer();

				if (menu.getBlockEntity().getMode() == Mode.FREEZER) {
					this.minecraft.player.displayClientMessage(Component.literal("§cCannot switch to Cooler mode while Freezer is active."), false);
				} else {
					this.minecraft.player.displayClientMessage(Component.literal("§cCannot switch to Freezer mode while Cooler is active."), false);
				}

			} else {
				menu.getBlockEntity().setMode(menu.getBlockEntity().getMode().next());
			
				PacketHandler.Instance.sendToServer(new ServerBoundFreezer(menu.getBlockEntity()));
			
			}
			
		}));


	}

	@Override
	public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
		renderBackground(pPoseStack);
		super.render(pPoseStack, mouseX, mouseY, delta);
		renderTooltip(pPoseStack, mouseX, mouseY);

	}

	@Override
	protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
		if (menu.getBlockEntity().getMode() == Mode.FREEZER) {
			screentitle = Component.literal("§fFreezer");
			button_label = Component.literal("§fCooler");
		
		} else if (menu.getBlockEntity().getMode() == Mode.COOLER) {
			screentitle = Component.literal("§fCooler");
			button_label = Component.literal("§fFreezer");
			
		}
		
		this.font.draw(p_97808_, this.screentitle, (float) this.titleLabelX + 60, (float) this.titleLabelY - 25,
				4210752);
		this.font.draw(p_97808_, this.playerInventoryTitle, (float) this.inventoryLabelX,
				(float) this.inventoryLabelY + 10, 4210752);

		int percent = 0;
		if (menu.isBurning()) {
			percent = menu.percentDisplay();
		}

		String percentdisplay = String.format("§fFuel Remaining: %d" + "%%", percent);
		this.font.draw(p_97808_, percentdisplay, 50, 55, 0x000000);

	}

}