package com.Symbols97.OPWeapons.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.TileEntity.TileEntityFreezer;
import com.Symbols97.OPWeapons.TileEntity.TileEntityFreezer.Mode;
import com.Symbols97.OPWeapons.containers.ContainerFreezer;
import com.Symbols97.OPWeapons.managment.packets.PacketFreezerCooler;
import com.Symbols97.OPWeapons.managment.packets.PacketHandler;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;

public class GUIFreezer extends GuiContainer implements GuiYesNoCallback {

	public static final ResourceLocation bground = new ResourceLocation("opweapons:textures/gui/freezergui.png");

	public TileEntityFreezer freezer;

	private GuiButton coolerButton;

	String name;

	public GUIFreezer(InventoryPlayer inventoryPlayer, TileEntityFreezer entity) {
		super(new ContainerFreezer(inventoryPlayer, entity));

		this.freezer = entity;

		this.xSize = 176;
		this.ySize = 208;

	}

	public void drawGuiContainerForegroundLayer(int par1, int par2) {

		// String name = this.freezer.hasCustomInventoryName() ?
		// this.freezer.getInventoryName() :
		// I18n.format(this.freezer.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2,
				0xFFFFFF);

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				0xFFFFFF);

		int percent = 0;
		if (freezer.isBurning()) {

			percent = this.freezer.burnTime * 100 / this.freezer.currentItemBurnTime;
		}
		String percentdisplay = String.format("Fuel Remaining: %d" + "%%", percent);
		this.fontRendererObj.drawString(percentdisplay, 50, this.ySize - 96 - 24, 0xFFFFFF);

	}

	@Override
	protected void actionPerformed(GuiButton parButton) {

		if (parButton == coolerButton) {

			if (freezer.isBurning()) {
				this.mc.thePlayer.closeScreen();

				if (freezer.getMode() == Mode.COOLER) {
					this.mc.thePlayer.addChatMessage(new ChatComponentText(
							String.format("§cCannot switch to Freezer mode while Cooler is active.")));
				} else {
					this.mc.thePlayer.addChatMessage(new ChatComponentText(
							String.format("§cCannot switch to Cooler mode while Freezer is active.")));
				}

			} else {
				freezer.getTileEntity().setMode(freezer.getTileEntity().getMode().next());
				// System.out.println(freezer.getTileEntity().getMode());

				PacketHandler.net.sendToServer(new PacketFreezerCooler(freezer.getTileEntity()));

			}

		} else {
			super.actionPerformed(parButton);
		}

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(bground);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		Keyboard.enableRepeatEvents(true);
		buttonList.clear();

		if (freezer.getMode() == Mode.FREEZER) {
			name = "Freezer";
			coolerButton = (new GuiButton(1, k + 5, l + 5, 50, 20, "Cooler"));
		} else {
			name = "Cooler";
			coolerButton = (new GuiButton(1, k + 5, l + 5, 50, 20, "Freezer"));
		}

		buttonList.add(coolerButton);

		if (this.freezer.isBurning()) {

			int i1 = this.freezer.getBurnTimeRemainingScaled(95); // bar
			this.drawTexturedModalRect(k + 48, l + 73, 0, 209, i1 + 1, 9);
			i1 = this.freezer.getCookProgressScaled(24); // arrow
			this.drawTexturedModalRect(k + 82, l + 35, 176, 14, i1 + 1, 16);

		}

	}

}
