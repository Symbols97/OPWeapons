package com.Symbols97.OPWeapons.gui;

import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.TileEntity.TileEntityDemonFurnace;
import com.Symbols97.OPWeapons.TileEntity.TileEntityOPFurnace;
import com.Symbols97.OPWeapons.blocks.machines.DemonFurnace;
import com.Symbols97.OPWeapons.blocks.machines.Freezer;
import com.Symbols97.OPWeapons.containers.ContainerDemonFurnace;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIDemonFurnace extends GuiContainer {
	
	public static final ResourceLocation bground = new ResourceLocation("opweapons:textures/gui/DemonFurnaceGUI.png");
	
	public TileEntityDemonFurnace demonfurnace;

	public GUIDemonFurnace(InventoryPlayer inventoryPlayer, TileEntityDemonFurnace entity) {
		super(new ContainerDemonFurnace(inventoryPlayer, entity));
		
		this.demonfurnace = entity;
		
		this.xSize = 176;
		this.ySize = 166; 
	}


	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		String name = this.demonfurnace.hasCustomInventoryName() ? this.demonfurnace.getInventoryName() : I18n.format(this.demonfurnace.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 0xFFFFFF);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 0xFFFFFF);

		int percent = 0;
		
		if (this.demonfurnace.isBurning() == true) {
			
			percent = this.demonfurnace.burnTime * 100 / this.demonfurnace.currentItemBurnTime;

			
			}
		String percentdisplay = String.format("Fuel: %d" + "%%" , percent);
			
		this.fontRendererObj.drawString(percentdisplay, 6, this.ySize - 96 - 30, 0xFFFFFF);
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(bground);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

	        if (this.demonfurnace.isBurning())
	        {
	            int i1 = this.demonfurnace.getBurnTimeRemainingScaled(13);
	            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
	            i1 = this.demonfurnace.getCookProgressScaled(24);
	            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	        }
	}

}
