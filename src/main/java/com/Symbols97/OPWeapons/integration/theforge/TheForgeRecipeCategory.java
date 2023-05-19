package com.Symbols97.OPWeapons.integration.theforge;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.integration.JEIOPWeaponsModePlugin;
import com.Symbols97.OPWeapons.recipe.theforge.TheForgeRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class TheForgeRecipeCategory implements IRecipeCategory<TheForgeRecipe> {
	
	public final static ResourceLocation UID = new ResourceLocation(OPWeapons.MOD_ID, "2the_forge");
	public final static ResourceLocation TEXTURE = new ResourceLocation(OPWeapons.MOD_ID, "textures/gui/nei_gui/theforgegui.png");
	public static final int width = 176;
	public static final int height = 85;

	private final IDrawable background;
	private final IDrawable icon;
	private final Component localizedName;
	

	public TheForgeRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = TEXTURE;
		background = guiHelper.createDrawable(location, 0, 0, width, height);
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(OPWBlocks.the_forge.get()));
		localizedName = Component.literal("The Forge");
		
	}

//	@Override
//	public ResourceLocation getUid() {
//		return UID;
//	}
//
//	@Override
//	public Class<? extends TheForgeRecipe> getRecipeClass() {
//		return TheForgeRecipe.class;
//	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, TheForgeRecipe recipe, IFocusGroup focuses) {

		for (int i = 0; i < recipe.width; ++i) {
			for (int j = 0; j < recipe.height; ++j) {
				int k = i;
				int l = j;

				if (k >= 0 && l >= 0 && k < recipe.width && l < recipe.height) {
					builder.addSlot(RecipeIngredientRole.INPUT, 30 + i * 18, 17 + j * 18).addIngredients((Ingredient) recipe.getIngredients().get(recipe.width - k - 1 + l * recipe.width));
				} else {
					builder.addSlot(RecipeIngredientRole.INPUT, 30 + i * 18, 17 + j * 18).addIngredients((Ingredient) recipe.getIngredients().get(i + j * 3));
				} 
					
				
	
			}
		}
		builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 35).addItemStack(recipe.getResultItem());

	}

	@Override
	public RecipeType<TheForgeRecipe> getRecipeType() {
		return JEIOPWeaponsModePlugin.Forge_Crafting;
	}

}