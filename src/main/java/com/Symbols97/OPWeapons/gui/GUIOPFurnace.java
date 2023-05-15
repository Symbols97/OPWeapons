package com.Symbols97.OPWeapons.gui;

import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.TileEntity.TileEntityOPFurnace;
import com.Symbols97.OPWeapons.containers.ContainerOPFurnace;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIOPFurnace extends GuiContainer {
	
	public static final ResourceLocation bground = new ResourceLocation("opweapons:textures/gui/OPFurnaceGUI.png");
	
	public TileEntityOPFurnace opfurnace;

	public GUIOPFurnace(InventoryPlayer inventoryPlayer, TileEntityOPFurnace entity) {
		super(new ContainerOPFurnace(inventoryPlayer, entity));
		
		this.opfurnace = entity;
		
		this.xSize = 176;
		this.ySize = 166; 
	}


	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		String name = this.opfurnace.hasCustomInventoryName() ? this.opfurnace.getInventoryName() : I18n.format(this.opfurnace.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 0x000000);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 0x000000);
		
		int percent = 0;
		
		if (this.opfurnace.isBurning() == true) {
		
		percent = this.opfurnace.burnTime * 100 / this.opfurnace.currentItemBurnTime;


		}
		
		String percentdisplay = String.format("Fuel: %d" + "%%" , percent);
		
		this.fontRendererObj.drawString(percentdisplay, 6, this.ySize - 96 - 30, 0x000000);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(bground);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

	        if (this.opfurnace.isBurning())
	        {
	            int i1 = this.opfurnace.getBurnTimeRemainingScaled(13);
	            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
	            i1 = this.opfurnace.getCookProgressScaled(24);
	            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	        }
	}

}
