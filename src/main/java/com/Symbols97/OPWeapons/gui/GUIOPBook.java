package com.Symbols97.OPWeapons.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.resources.I18n;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ResourceLocation;

public class GUIOPBook extends GuiScreen{

	static String page = "opweapons:textures/gui/opbook/";
	
	private final int bookImageHeight = 256;
	private final int bookImageWidth = 256;
	private int currPage = 0;
	private static final int bookTotalPages = 42;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static ResourceLocation bookPageButtonTextures = new ResourceLocation("opweapons:textures/gui/Buttons.png");
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone;
	private NextPageButton buttonNextPage;
	private NextPageButton buttonPreviousPage;
	
	

	public GUIOPBook() {

		bookPageTextures[0] = new ResourceLocation(page + "TitlePage.png");
		bookPageTextures[1] = new ResourceLocation(page + "OPGemC.png");
		bookPageTextures[2] = new ResourceLocation(page + "opbook.png");
		bookPageTextures[3] = new ResourceLocation(page + "OPGemCore.png");
		bookPageTextures[4] = new ResourceLocation(page + "OPGem.png");
		bookPageTextures[5] = new ResourceLocation(page + "OPCT.png");
		bookPageTextures[6] = new ResourceLocation(page + "opsword.png");
		bookPageTextures[7] = new ResourceLocation(page + "opaxe.png");
		bookPageTextures[8] = new ResourceLocation(page + "oppickaxe.png");
		bookPageTextures[9] = new ResourceLocation(page + "opshovel.png");
		bookPageTextures[10] = new ResourceLocation(page + "ophoe.png");
		bookPageTextures[11] = new ResourceLocation(page + "OPHelm.png");// op armor
		bookPageTextures[12] = new ResourceLocation(page + "OPChest.png");// op armor
		bookPageTextures[13] = new ResourceLocation(page + "OPLeg.png");// op armor
		bookPageTextures[14] = new ResourceLocation(page + "OPBoot.png");// op armor
		bookPageTextures[15] = new ResourceLocation(page + "NS.png"); 
		bookPageTextures[16] = new ResourceLocation(page + "Shardtostar.png"); // +Nether shard to star
		bookPageTextures[17] = new ResourceLocation(page + "Capsule.png");
		bookPageTextures[18] = new ResourceLocation(page + "firecapsule.png");
		bookPageTextures[19] = new ResourceLocation(page + "firesword.png");	
		bookPageTextures[20] = new ResourceLocation(page + "icesword.png");
		bookPageTextures[21] = new ResourceLocation(page + "demongem.png");
		bookPageTextures[22] = new ResourceLocation(page + "repairmodule.png");
		bookPageTextures[23] = new ResourceLocation(page + "RepairV1.png");
		bookPageTextures[24] = new ResourceLocation(page + "V1TV2Back.png");// tables back and forth
		bookPageTextures[25] = new ResourceLocation(page + "UNS.png");	
		bookPageTextures[26] = new ResourceLocation(page + "demongemcore.png");
		
		bookPageTextures[27] = new ResourceLocation(page + "frostgem.png");
		bookPageTextures[28] = new ResourceLocation(page + "lostgem.png");
		
		bookPageTextures[29] = new ResourceLocation(page + "frostgemcore.png");
		bookPageTextures[30] = new ResourceLocation(page + "neutralcore.png");
		bookPageTextures[31] = new ResourceLocation(page + "theforge.png");
		bookPageTextures[32] = new ResourceLocation(page + "demonbook.png");
		bookPageTextures[33] = new ResourceLocation(page + "frostbook.png");
		bookPageTextures[34] = new ResourceLocation(page + "lorebookincomplete.png");
		bookPageTextures[35] = new ResourceLocation(page + "foodbook.png");
		bookPageTextures[36] = new ResourceLocation(page + "Blockofopg.png");
		bookPageTextures[37] = new ResourceLocation(page + "Blockofdg.png");		
		bookPageTextures[38] = new ResourceLocation(page + "blockoffg.png");
		bookPageTextures[39] = new ResourceLocation(page + "blockoflostgem.png");
		bookPageTextures[40] = new ResourceLocation(page + "OPFurnace.png");
		bookPageTextures[41] = new ResourceLocation(page + "DemonFurnace.png");
		
		
		
		stringPageText[0] = "     Volume 1\n\nWelcome to the OP Weapons mod. The Mod Was created by Symbols97, designs by Cathynightingale. This mod adds in overpowered weapons, armors, and foods!";
		stringPageText[1] = "This is the start of the Mod. Smelt the Ore (Which spawn between y:1 and y:50) To get the OP Gem Chunk. Use this to craft the OP Gem which is used for everything in the mod.";
		stringPageText[2] = "Nothing really to say besides how redundant this page is. The recipe for this book is in NEI but if you don't have that I would memorize this recipe before throwing this out.";
		stringPageText[3] = "This OP Gem Core is used to make the OP Crafting Station. In order to make anything in the mod you MUST make this and the OP Crafting Station.";
		stringPageText[4] = "This is the OP Gem. Use this to make everything in the mod from weapons to armor! Surround a diamond with OP Gem Chunks and be on your way!";
		stringPageText[5] = "The OP Crafting Station is the mod's own crafting bench. In order to make anything that will allow you to demolish your enimies you have to start here.";
		stringPageText[6] = "The OP Sword is crafted in the OP Crafting Station. This weapon does +10 Attack Damage.";
		stringPageText[7] = "The OP Axe is crafted in the OP Crafting Station. This tool does +6 Attack Damage and can cut down trees extremely fast.";
		stringPageText[8] = "The OP Pickaxe is crafted in the OP Crafting Station. This tool does +5 Attack Damage. Mine fast but watch out, the speed will catch up to you and you'll need to make another.";
		stringPageText[9] = "The OP Shovel is crafted in the OP Crafting Station. This tool does +4 damage but is best used for the incredible shoveling speed. Why is this in the mod?";
		stringPageText[10] = "The OP Hoe is crafted in the OP Crafting Station. It does NOT do any damage (Are you surprised?). This is only good for farming, for a long time, and not needing to constantly make more hoes.";
		stringPageText[11] = "OP Armor is a BIG step up from regular Diamond Armor. Protect yourself from danger with this armor! You wont regret it.";
		stringPageText[12] = "OP Armor is a BIG step up from regular Diamond Armor. Protect yourself from danger with this armor! You wont regret it.";
		stringPageText[13] = "OP Armor is a BIG step up from regular Diamond Armor. Protect yourself from danger with this armor! You wont regret it.";
		stringPageText[14] = "OP Armor is a BIG step up from regular Diamond Armor. Protect yourself from danger with this armor! You wont regret it.";
		stringPageText[15] = "A Nether Shard is used to create the next teir of weaponry. Break down a Nether Star to create 5 shards.";
		stringPageText[16] = "If by chance you decide you don't need Nether Shards you can go back and create a Nether Star with Nether Shards.";
		stringPageText[17] = "The Capsule is used to hold fire creating the Encapsulated Flame. Crafted from Obsidian and Glass Panes";
		stringPageText[18] = "With Minecraft's flames harnessed in this capsule, you can create the Demon Gem.";
		stringPageText[19] = "A slight upgrade from the base OP Sword. This sword does +15 damage and grants Fire Aspect 2 on creation. You do not get the enchantment if taken from the Creative Tab.";
		stringPageText[20] = "A slight upgrade from the base OP Sword. This sword does +15 damage. With every hit inflict cold temperatures causing the player to be weakened and move slower.";
		stringPageText[21] = "Demon Gems are the next step from the OP Gem. These will be used for the Repair Module and anything Demon related.";
		stringPageText[22] = "Nothing comes easy. In order to continue you must create a repair module. Use it on OP Items to make the next teir of armor and tools. Only 24 uses per module.";
		stringPageText[23] = "The Repair Station is what you will use to make the next items. You can use the Repair Module to repair your tools and armor in order to upgrade them.";
		stringPageText[24] = "If you don't like the original Repair Station design you can place it in the crafting bench (or OP Crafting Station) and get the second version. or Vice Versa (Nothing is different).";
		stringPageText[25] = "The Ultimate Nether Star is to gain the strength to create more powerful weapons and stations, a very useful and key item.";
		stringPageText[26] = "The Demon Gem Core is the core for all the demon variants in the mod.";
		
		stringPageText[27] = "The Frost Gem is an alternative to the Demon Gem. This is used in anything Frost related.";
		stringPageText[28] = "Purpose:\n- Crafting.\nReason:\n- Unknown\nOrigin:\n- Unknown.";
		
		stringPageText[29] = "The Frost Gem Core is the core for all the frost variants in the mod.";
		stringPageText[30] = "The Neutral Core is the core that bring balance. Used to create The Forge. It holds no faction, it is neutral in this war.";
		stringPageText[31] = "The Forge. The other faction items are made here. This is the hub for all high tier armor and weapons.";
		stringPageText[32] = "If you make this book, you choose the Demon Faction. The way of the Flame";
		stringPageText[33] = "If you make this book, you choose the Frost Faction. The way of the Ice";	
		stringPageText[34] = "\nWhat is the story of OPWeapons? What is the story of the factions?\nThis book is incomplete. We do not know what happened to the rest of it.";
		stringPageText[35] = "Learn the different types of foods for the factions.";
		stringPageText[36] = "Just a simple storage block for the OP Gem.";
	    stringPageText[37] = "Just a simple storage block for the Demon Gem. OH! And also used to create the Condensed Demon Gem block.";    
	    stringPageText[38] = "Just a simple storage block for the Frost Gem. OH! And also used to create the Condensed Frost Gem block.";
	    stringPageText[39] = "Just a simple storage block for the Lost Gem.";
	    stringPageText[40] = "This furnace runs on iron. Place coal in the burner and get diamonds. However this can do so much more! (Block variants are supported).";
	    stringPageText[41] = "This furnace runs on iron, similar to the OP Furnace however, this can do so much more! (Block variants are supported).";
	
	
	
	
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
		} else if (currPage == 17) {
			mc.getTextureManager().bindTexture(bookPageTextures[17]);
		} else if (currPage == 18) {
			mc.getTextureManager().bindTexture(bookPageTextures[18]);
		} else if (currPage == 19) {
			mc.getTextureManager().bindTexture(bookPageTextures[19]);
		} else if (currPage == 20) {
			mc.getTextureManager().bindTexture(bookPageTextures[20]);
		} else if (currPage == 21) {
			mc.getTextureManager().bindTexture(bookPageTextures[21]);
		} else if (currPage == 22) {
			mc.getTextureManager().bindTexture(bookPageTextures[22]);
		} else if (currPage == 23) {
			mc.getTextureManager().bindTexture(bookPageTextures[23]);
		} else if (currPage == 24) {
			mc.getTextureManager().bindTexture(bookPageTextures[24]);
     	} else if (currPage == 25) {
     		mc.getTextureManager().bindTexture(bookPageTextures[25]);
	    } else if (currPage == 26) {
	    	mc.getTextureManager().bindTexture(bookPageTextures[26]);
	    } else if (currPage == 27) {
	    	mc.getTextureManager().bindTexture(bookPageTextures[27]);
		} else if (currPage == 28) {
	    	mc.getTextureManager().bindTexture(bookPageTextures[28]);
		} else if (currPage == 29) {
			mc.getTextureManager().bindTexture(bookPageTextures[29]); 
		} else if (currPage == 30) {
			mc.getTextureManager().bindTexture(bookPageTextures[30]);
		} else if (currPage == 31) {
			mc.getTextureManager().bindTexture(bookPageTextures[31]);
		} else if (currPage == 32) {
			mc.getTextureManager().bindTexture(bookPageTextures[32]);
		} else if (currPage == 33) {
			mc.getTextureManager().bindTexture(bookPageTextures[33]);
		} else if (currPage == 34) {
			mc.getTextureManager().bindTexture(bookPageTextures[34]);
		} else if (currPage == 35) {
			mc.getTextureManager().bindTexture(bookPageTextures[35]);
		} else if (currPage == 36) {
			mc.getTextureManager().bindTexture(bookPageTextures[36]);
		} else if (currPage == 37) {
			mc.getTextureManager().bindTexture(bookPageTextures[37]);
		} else if (currPage == 38) {
			mc.getTextureManager().bindTexture(bookPageTextures[38]);
		} else if (currPage == 39) {
			mc.getTextureManager().bindTexture(bookPageTextures[39]);
		} else if (currPage == 40) {
			mc.getTextureManager().bindTexture(bookPageTextures[40]);
		} else if (currPage == 41) {
			mc.getTextureManager().bindTexture(bookPageTextures[41]);
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