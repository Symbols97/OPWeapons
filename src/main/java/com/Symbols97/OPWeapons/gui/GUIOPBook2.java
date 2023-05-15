package com.Symbols97.OPWeapons.gui;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.gui.GUIOPBook.NextPageButton;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class GUIOPBook2 extends GuiScreen{

	static String page = "opweapons:textures/gui/opbook2/";
	
	
	private final int bookImageHeight = 256;
	private final int bookImageWidth = 256;
	private int currPage = 0;
	private static final int bookTotalPages = 12;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static ResourceLocation bookPageButtonTextures = new ResourceLocation("opweapons:textures/gui/Buttons.png");
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone;
	private NextPageButton buttonNextPage;
	private NextPageButton buttonPreviousPage;
	
	


	public GUIOPBook2() {

		bookPageTextures[0] = new ResourceLocation(page + "TitlePage.png");
		bookPageTextures[1] = new ResourceLocation(page + "neutral_staff.png");
		
		bookPageTextures[2] = new ResourceLocation(page + "hammer_handle_base.png");
		bookPageTextures[3] = new ResourceLocation(page + "hammer_handle_hilt.png");
		bookPageTextures[4] = new ResourceLocation(page + "hammer_handle_grip.png");
		bookPageTextures[5] = new ResourceLocation(page + "hammer_handle.png");
		bookPageTextures[6] = new ResourceLocation(page + "hammer_head.png");
		
		bookPageTextures[7] = new ResourceLocation(page + "clubhandle.png");
		bookPageTextures[8] = new ResourceLocation(page + "clubhead.png");
		bookPageTextures[9] = new ResourceLocation(page + "opclub.png");
		bookPageTextures[10] = new ResourceLocation(page + "frostaxeblade.png");
		bookPageTextures[11] = new ResourceLocation(page + "frostaxehandle.png");
		
		
		String page4desc1  = StringUtils.center("*Note*", 20);
		String page4desc2 = "The recipe requires brown stained clay.";	
		String page4note = page4desc1+page4desc2;
		
		String page5desc1  = StringUtils.center("*Note*", 20);
		String page5desc2 = "The recipe requires brown stained clay and oak wood planks";	
		String page5note = page5desc1+page5desc2;
		
		String page8desc1  = StringUtils.center("*Note*", 20);
		String page8desc2 = "The recipe requires stone and oak wood planks";	
		String page8note = page8desc1+page8desc2;
		
		stringPageText[0] = "     Volume 2\n\n     Advanced \n  Weapon Parts\n\n\n  Parts in this        book, weapons \n  in their\n  respective \n  faction book.";
		stringPageText[1] = "To travel to other dimensions, you must first make the Neutral Staff. Then convert it into the faction who's portal you want to light. (See Faction Books)";
		stringPageText[2] = "";
		stringPageText[3] = page4note;
		stringPageText[4] = page5note;
		stringPageText[5] = "";
		stringPageText[6] = "";
		
		stringPageText[7] = page8note;
		stringPageText[8] = "";
		stringPageText[9] = "Due to it's blunt nature the club inflicts:\n* Confusion\n* Blindness\n* Slowness\nall for 3 seconds";
		stringPageText[10] = "";
		stringPageText[11] = "";
	
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
		} 
		else if (currPage == 7) {
			mc.getTextureManager().bindTexture(bookPageTextures[7]);
		} else if (currPage == 8) {
			mc.getTextureManager().bindTexture(bookPageTextures[8]);
		} else if (currPage == 9) {
			mc.getTextureManager().bindTexture(bookPageTextures[9]);
		} else if (currPage == 10) {
			mc.getTextureManager().bindTexture(bookPageTextures[10]);
		} else if (currPage == 11) {
			mc.getTextureManager().bindTexture(bookPageTextures[11]);
		} 
		// else if (currPage == 12) {
//			mc.getTextureManager().bindTexture(bookPageTextures[12]);
//		} else if (currPage == 13) {
//			mc.getTextureManager().bindTexture(bookPageTextures[13]);
//		} else if (currPage == 14) {
//			mc.getTextureManager().bindTexture(bookPageTextures[14]);
//		} else if (currPage == 15) {
//			mc.getTextureManager().bindTexture(bookPageTextures[15]);
//		} else if (currPage == 16) {
//			mc.getTextureManager().bindTexture(bookPageTextures[16]);
//		} else if (currPage == 17) {
//			mc.getTextureManager().bindTexture(bookPageTextures[17]);
//		} else if (currPage == 18) {
//			mc.getTextureManager().bindTexture(bookPageTextures[18]);
//		} else if (currPage == 19) {
//			mc.getTextureManager().bindTexture(bookPageTextures[19]);
//		} else if (currPage == 20) {
//			mc.getTextureManager().bindTexture(bookPageTextures[20]);
//		} else if (currPage == 21) {
//			mc.getTextureManager().bindTexture(bookPageTextures[21]);
//		} else if (currPage == 22) {
//			mc.getTextureManager().bindTexture(bookPageTextures[22]);
//		} else if (currPage == 23) {
//			mc.getTextureManager().bindTexture(bookPageTextures[23]);
//		} else if (currPage == 24) {
//			mc.getTextureManager().bindTexture(bookPageTextures[24]);
//     	} else if (currPage == 25) {
//     		mc.getTextureManager().bindTexture(bookPageTextures[25]);
//	    } else if (currPage == 26) {
//	    	mc.getTextureManager().bindTexture(bookPageTextures[26]);
//	    } else if (currPage == 27) {
//	    	mc.getTextureManager().bindTexture(bookPageTextures[27]);
//		} else if (currPage == 28) {
//	    	mc.getTextureManager().bindTexture(bookPageTextures[28]);
//		} else if (currPage == 29) {
//			mc.getTextureManager().bindTexture(bookPageTextures[29]); 
//		} else if (currPage == 30) {
//			mc.getTextureManager().bindTexture(bookPageTextures[30]);
//		} else if (currPage == 31) {
//			mc.getTextureManager().bindTexture(bookPageTextures[31]);
//		} else if (currPage == 32) {
//			mc.getTextureManager().bindTexture(bookPageTextures[32]);
//		} else if (currPage == 33) {
//			mc.getTextureManager().bindTexture(bookPageTextures[33]);
//		} else if (currPage == 34) {
//			mc.getTextureManager().bindTexture(bookPageTextures[34]);
//		} else if (currPage == 35) {
//			mc.getTextureManager().bindTexture(bookPageTextures[35]);
//		} else if (currPage == 36) {
//			mc.getTextureManager().bindTexture(bookPageTextures[36]);
//		} else if (currPage == 37) {
//			mc.getTextureManager().bindTexture(bookPageTextures[37]);
//		} else if (currPage == 38) {
//			mc.getTextureManager().bindTexture(bookPageTextures[38]);
//		} else if (currPage == 39) {
//			mc.getTextureManager().bindTexture(bookPageTextures[39]);
//		} else if (currPage == 40) {
//			mc.getTextureManager().bindTexture(bookPageTextures[40]);
//		}
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