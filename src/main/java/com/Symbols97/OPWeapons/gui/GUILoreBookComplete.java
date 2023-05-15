package com.Symbols97.OPWeapons.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.gui.GUILoreBookIncomplete.NextPageButton;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class GUILoreBookComplete extends GuiScreen implements GuiYesNoCallback {

	static String page = "opweapons:textures/gui/lorebook/";
	
	private final int bookImageHeight = 256;
	private final int bookImageWidth = 256;
	private int currPage = 0;
	private static final int bookTotalPages = 18;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static ResourceLocation bookPageButtonTextures = new ResourceLocation("opweapons:textures/gui/Buttons.png");
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone;
	private NextPageButton buttonNextPage;
	private NextPageButton buttonPreviousPage;
	private GuiButton webButton;
	


	public GUILoreBookComplete() {

		bookPageTextures[0] = new ResourceLocation(page + "TitlePageLoreBook.png");
		bookPageTextures[1] = new ResourceLocation(page + "fulllore.png");
		bookPageTextures[2] = new ResourceLocation(page + "lostpickaxe.png");
		bookPageTextures[3] = new ResourceLocation(page + "blockoenchanting.png");
		bookPageTextures[4] = new ResourceLocation(page + "losthelmet.png");
		bookPageTextures[5] = new ResourceLocation(page + "lostchestplate.png");
		bookPageTextures[6] = new ResourceLocation(page + "lostleggings.png");
		bookPageTextures[7] = new ResourceLocation(page + "lostboots.png");	
		bookPageTextures[8] = new ResourceLocation(page + "LostPages.png");
		bookPageTextures[9] = new ResourceLocation(page + "lorebookcomplete.png");
		bookPageTextures[10] = new ResourceLocation(page + "soulblock.png");
		bookPageTextures[11] = new ResourceLocation(page + "minisoul.png");
		bookPageTextures[12] = new ResourceLocation(page + "torturedsoul.png");
		
		bookPageTextures[13] = new ResourceLocation(page + "rip.png");
		bookPageTextures[14] = new ResourceLocation(page + "deathessence.png");
		
		bookPageTextures[15] = new ResourceLocation(page + "soulharvester.png");
		bookPageTextures[16] = new ResourceLocation(page + "thereaper.png");
		bookPageTextures[17] = new ResourceLocation(page + "reaperscythe.png");
		// Clipboard is the only working button. Hit ESC to leave prompt.
		
		stringPageText[0] = "      Complete\n\nAll items are made in: The Forge.\n\nThis book will tell you the story of OPWeapons.";
		stringPageText[1] = "Only the copy button works. Hit ESC to leave the prompt.\n\nThis will take you to the full lore website.";
		stringPageText[2] = "The Lost Pickaxe can mine anything. But there's only 64 uses on each pickaxe. It is also the only pickaxe that can mine the Block 'O XP.";
	    stringPageText[3] = "The Block o' Enchanting grants aproximently 70 experiences levels per block.";
	    stringPageText[4] = "Similar to OP Armor in damage reduction and durability but needed to get the Reaper Armor";
	    stringPageText[5] = "Similar to OP Armor in damage reduction and durability but needed to get the Reaper Armor";
	    stringPageText[6] = "Similar to OP Armor in damage reduction and durability but needed to get the Reaper Armor";
	    stringPageText[7] = "Similar to OP Armor in damage reduction and durability but needed to get the Reaper Armor";   
	    stringPageText[8] = "These pages have shown up in Jungle Temples. Some say that they are the mising pages to the Lore Book. Others are...dead.";
	    stringPageText[9] = "             Assuming you are able to find the missing pages, this is how you will complete the book. You won't find them though.";
	    stringPageText[10] = "Min vien size of 1, max of 4.\n15% chance of finding it.\nSpawns in the Dead Zone.\nY: 1-10.";
	    stringPageText[11] = "Mined from the Soul Block. This will start your journey for acquiring the Reaper Armor.";
	    stringPageText[12] = "The next step for getting the Reaper Armor.";
	    
	    stringPageText[13] = "The next step for getting the Reaper Armor. Dropped from the Reaper Mob. Grants immunity to Slowness, Weakness, Fatigue, Blindness, Hunger, Poison, Wither, Nausea.";
	    stringPageText[14] = "The next step for getting the Reaper Armor. Dropped fromt the Reaper Mob. Used to make the Soul Harvester.";
	    
	    stringPageText[15] = "While wearing the Lost Armor place this in your inventory to get the Reaper Armor. HAVING MORE IN YOUR INV WILL CONSUME THEM ALL.";
	    stringPageText[16] = "This armor is on the same teir as the Demon and Frost Armor. Grants Speed 2, Flight, Vaccumm Adaptation, Fire Resistance. Use the Soul Harvester to repair the armor and Scythe.";
	    stringPageText[17] = "The Reaper's Scythe inflicts 8 torturous ailments. Slowness, Weakness, Fatigue, Blindness, Hunger, Poison, Wither, Nausea, and grounds the player.";
	    
	
	
	
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui() {
		// DEBUG
		// System.out.println("GuiMysteriousStranger initGUI()");
		buttonList.clear();
		Keyboard.enableRepeatEvents(true);

		buttonDone = new GuiButton(0, width / 2 + 6, -56 + bookImageHeight, 98, 20,
				I18n.format("gui.done", new Object[0]));
		buttonList.add(buttonDone);
		webButton = new GuiButton(0, width / 2 + 25, -105 + bookImageHeight, 58, 20,
		I18n.format("LORE", new Object[0]));
		buttonList.add(webButton);
		int offsetFromScreenLeft = (width - bookImageWidth) / 2;
		buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 200, 176, true));
		buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft + 28, 176, false));
		
		
	}
	
   
	/**
	 * Called from the main game loop to update the screen.
	 */
	@Override
	public void updateScreen() {
		buttonDone.visible = (currPage == bookTotalPages - 1);
		buttonNextPage.visible = (currPage < bookTotalPages - 1);
		buttonPreviousPage.visible = currPage > 0;
		webButton.visible = currPage == 1;
		
		
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int parWidth, int parHeight, float p_73863_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		if (currPage == 0) {
			mc.getTextureManager().bindTexture(bookPageTextures[0]);
		} else if (currPage == 1) {
			mc.getTextureManager().bindTexture(bookPageTextures[1]);
		} else if (currPage == 2) {
			mc.getTextureManager().bindTexture(bookPageTextures[2]);
		} else if (currPage == 3) {
			mc.getTextureManager().bindTexture(bookPageTextures[3]);
		} else if (currPage == 4) {
			mc.getTextureManager().bindTexture(bookPageTextures[4]);
		} else if (currPage == 5) {
			mc.getTextureManager().bindTexture(bookPageTextures[5]);
		} else if (currPage == 6) {
			mc.getTextureManager().bindTexture(bookPageTextures[6]);
		} else if (currPage == 7) {
			mc.getTextureManager().bindTexture(bookPageTextures[7]);
		} else if (currPage == 8) {
			mc.getTextureManager().bindTexture(bookPageTextures[8]);
		} else if (currPage == 9) {
			mc.getTextureManager().bindTexture(bookPageTextures[9]);
		} else if (currPage == 10) {
			mc.getTextureManager().bindTexture(bookPageTextures[10]);
		} else if (currPage == 11) {
			mc.getTextureManager().bindTexture(bookPageTextures[11]);
		} else if (currPage == 12) {
			mc.getTextureManager().bindTexture(bookPageTextures[12]);
		} else if (currPage == 13) {
			mc.getTextureManager().bindTexture(bookPageTextures[13]);
		} else if (currPage == 14) {
			mc.getTextureManager().bindTexture(bookPageTextures[14]);
		} else if (currPage == 15) {
			mc.getTextureManager().bindTexture(bookPageTextures[15]);
		} else if (currPage == 16) {
			mc.getTextureManager().bindTexture(bookPageTextures[16]);
		}  else if (currPage == 17) {
			mc.getTextureManager().bindTexture(bookPageTextures[17]);
		}
		int offsetFromScreenLeft = (width - bookImageWidth) / 2;
		drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, bookImageHeight);
		int widthOfString;
		String stringPageIndicator = I18n.format("book.pageIndicator",new Object[] { Integer.valueOf(currPage + 1), bookTotalPages });
		widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
		fontRendererObj.drawString(stringPageIndicator, offsetFromScreenLeft - widthOfString + bookImageWidth - 158, 55,0);
		fontRendererObj.drawSplitString(stringPageText[currPage], offsetFromScreenLeft + 139, 75, 90, 0);

		super.drawScreen(parWidth, parHeight, p_73863_3_);

	}

	/**
	 * Called when a mouse button is pressed and the mouse is moved around.
	 * Parameters are : mouseX, mouseY, lastButtonClicked & timeSinceMouseClick.
	 */
	@Override
	protected void mouseClickMove(int parMouseX, int parMouseY, int parLastButtonClicked, long parTimeSinceMouseClick) {

	}

	@Override
	protected void actionPerformed(GuiButton parButton) {
		if (parButton == buttonDone) {
			// You can send a packet to server here if you need server to do
			// something
			mc.displayGuiScreen((GuiScreen) null);
		} else if (parButton == buttonNextPage) {
			if (currPage < bookTotalPages - 1) {
				++currPage;
			}
		} else if (parButton == buttonPreviousPage) {
			if (currPage > 0) {
				--currPage;
			} 
		
		}else if (parButton == webButton) {
			
			GuiConfirmOpenLink gui = new GuiConfirmOpenLink(this, "https://opweaponslore.weebly.com", 0, true);
			mc.displayGuiScreen(gui);
		}
	}

	/**
	 * Called when the screen is unloaded. Used to disable keyboard repeat events
	 */
	@Override
	public void onGuiClosed() {

	}

	/**
	 * Returns true if this GUI should pause the game when it is displayed in
	 * single-player
	 */
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	static class NextPageButton extends GuiButton {
		private final boolean isNextButton;

		public NextPageButton(int parButtonId, int parPosX, int parPosY, boolean parIsNextButton) {
			super(parButtonId, parPosX, parPosY, 23, 13, "");
			isNextButton = parIsNextButton;
		}

		/**
		 * Draws this button to the screen.
		 */
		@Override
		public void drawButton(Minecraft mc, int parX, int parY) {
			if (visible) {
				boolean isButtonPressed = (parX >= xPosition && parY >= yPosition && parX < xPosition + width
						&& parY < yPosition + height);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				mc.getTextureManager().bindTexture(bookPageButtonTextures);
				int textureX = 106;
				int textureY = 113;

				if (isButtonPressed) {
					textureX += 23;
				}

				if (!isNextButton) {
					textureY += 13;
				}

				drawTexturedModalRect(xPosition, yPosition, textureX, textureY, 19, 13);
			}
		}
	}
}