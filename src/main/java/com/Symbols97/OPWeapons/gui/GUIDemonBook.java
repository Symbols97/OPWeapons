package com.Symbols97.OPWeapons.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class GUIDemonBook extends GuiScreen {

	static String page = "opweapons:textures/gui/demonbook/";
	
	private final int bookImageHeight = 256;
	private final int bookImageWidth = 256;
	private int currPage = 0;
	private static final int bookTotalPages = 11;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static ResourceLocation bookPageButtonTextures = new ResourceLocation("opweapons:textures/gui/Buttons.png");
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone;
	private NextPageButton buttonNextPage;
	private NextPageButton buttonPreviousPage;


	public GUIDemonBook() {

		bookPageTextures[0] = new ResourceLocation(page + "TitlePageDemon.png");
		bookPageTextures[1] = new ResourceLocation(page + "DemonHelm.png");
		bookPageTextures[2] = new ResourceLocation(page + "DemonChest.png");
		bookPageTextures[3] = new ResourceLocation(page + "DemonLeg.png");
		bookPageTextures[4] = new ResourceLocation(page + "Demonboot.png");
		bookPageTextures[5] = new ResourceLocation(page + "crimsonblade.png");
		bookPageTextures[6] = new ResourceLocation(page + "Hellstick.png");
		bookPageTextures[7] = new ResourceLocation(page + "demonslayer.png");
		bookPageTextures[8] = new ResourceLocation(page + "conddg.png");
		bookPageTextures[9] = new ResourceLocation(page + "dead_zone_staff.png");
		bookPageTextures[10] = new ResourceLocation(page + "demon_hammer.png");
		
		
		
		stringPageText[0] = "All items are made in: The Forge.\n\nThe Book of the Demon will guide you in the way of the Demon Faction";
		stringPageText[1] = "\"The way of the Demon\"        Demon Armor will protect you from almost anything you can think of. You wont ever need another pair of armor. *Grants many abilities*";
		stringPageText[2] = "\"The way of the Demon\"        Demon Armor will protect you from almost anything you can think of. You wont ever need another pair of armor. *Grants many abilities*";
		stringPageText[3] = "\"The way of the Demon\"        Demon Armor will protect you from almost anything you can think of. You wont ever need another pair of armor. *Grants many abilities*";
		stringPageText[4] = "\"The way of the Demon\"        Demon Armor will protect you from almost anything you can think of. You wont ever need another pair of armor. *Grants many abilities*";
		stringPageText[5] = "This blade is forged from the Fire Sword. The blade is then used to make the Demon Slayer.";
		stringPageText[6] = "The Hell Stick is forged from a blaze rod and Demon Gem. The Stick is then used to make the Demon Slayer.";
		stringPageText[7] = "\"The way of the Demon\"            This weapon does +10,000 attack damage. Fire Aspect 2 is given upon creation. You do not get the enchantment if taken from the Creative Tab.";;
		stringPageText[8] = "These are the blocks used to make the portal frame for the Dead Zone! Arranged just like a Nether Portal.";
	    stringPageText[9] = "The Dead Zone Staff is used ignite the portal for the Dead Zone.";
	    stringPageText[10] = "Right Click to Strike Lightning. Shift Right Click to spawn Lava. Grants Fire Resistance. With Demon Armor increased Speed, Strength, and Flight.";
	
	
	
	
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