package com.Symbols97.OPWeapons.gui;

import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.TileEntity.TileEntityRepairStation;
import com.Symbols97.OPWeapons.containers.RepairStationContainerV2;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GUIRepairStation extends GuiContainer{

private ResourceLocation texture = new ResourceLocation("opweapons:textures/gui/repairstationgui.png");
	
	public GUIRepairStation(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new RepairStationContainerV2(invPlayer, world, x, y, z));
		
		this.xSize = 176;
		this.ySize = 165;
		
	}

	
	


	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Repair Station"), 32, 20, 0x000000);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 7, 73, 0x000000);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
	}

}
