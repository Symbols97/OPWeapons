package com.Symbols97.OPWeapons.screen.repairstation;

import com.Symbols97.OPWeapons.blocks.entity.RepairStationBlockEntity.Mode;
import com.Symbols97.OPWeapons.management.packets.PacketHandler;
import com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv1.ServerBoundRepairStation;
import com.Symbols97.OPWeapons.screen.helpscreens.TierHelpScreen;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.client.gui.widget.ExtendedButton;

public class RepairStationScreen extends AbstractContainerScreen<RepairStationMenu> {

	protected Component playerInventoryTitle;


	private static ResourceLocation TEXTURE = new ResourceLocation("opweapons:textures/gui/repairstationgui_default.png");
	private static ResourceLocation ICON = new ResourceLocation("opweapons:textures/gui/uns_icon.png");

	public RepairStationScreen(RepairStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
		this.playerInventoryTitle = new TextComponent("§0Inventory");

	}

	

	@Override
	protected void init() {

		int x = (width - imageWidth) / 2;
		int y = (height - imageHeight) / 2;
		
		this.addRenderableWidget(new ExtendedButton(x + 155, y + 5, 16, 16, new TextComponent("?"), button -> {
			Minecraft.getInstance().setScreen(new TierHelpScreen(new TextComponent("")));
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

		this.addRenderableWidget(new ImageButton(x + 5, y + 35, 20, 18, 0, 0, 19, ICON, (p_98484_) -> {
			((ImageButton) p_98484_).setPosition(x + 5, y + 35);

			menu.getBlockEntity().setMode(menu.getBlockEntity().getMode().next());
			
			PacketHandler.Instance.sendToServer(new ServerBoundRepairStation(menu.getBlockEntity()));
			
			
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
		this.font.draw(p_97808_, this.title, (float) this.titleLabelX + 45, (float) this.titleLabelY + 10, 4210752);
		this.font.draw(p_97808_, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY, 4210752);
		if (menu.getBlockEntity().getMode() == Mode.MODULE) {
			ICON = new ResourceLocation("opweapons:textures/gui/uns_icon.png");
			TEXTURE = new ResourceLocation("opweapons:textures/gui/repairstationgui_default.png");
		} else if (menu.getBlockEntity().getMode() == Mode.STAR) {

			ICON = new ResourceLocation("opweapons:textures/gui/repair_module_icon.png");
			TEXTURE = new ResourceLocation("opweapons:textures/gui/repairstationgui_changed.png");
		}
	}

}
