package com.Symbols97.OPWeapons.integration.freezer;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.recipe.freezer.FreezerRecipe;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class FreezerRecipeCategory implements IRecipeCategory<FreezerRecipe> {
	
	public final static ResourceLocation UID = new ResourceLocation(OPWeapons.MOD_ID, "5freezer");
	public final static ResourceLocation TEXTURE = new ResourceLocation(OPWeapons.MOD_ID, "textures/gui/nei_gui/freezergui.png");
	public static final int width = 149;
	public static final int height = 65;

	private final IDrawable background;
	private final IDrawable icon;
	private final Component localizedName;
	

	public FreezerRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = TEXTURE;
		background = guiHelper.createDrawable(location, 8, 26, width, height);
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(OPWBlocks.freezer.get()));
		localizedName = new TextComponent("Freezer");
		
	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<? extends FreezerRecipe> getRecipeClass() {
		return FreezerRecipe.class;
	}

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
	public void setRecipe(IRecipeLayoutBuilder builder, FreezerRecipe recipe, IFocusGroup focuses) {

		
		builder.addSlot(RecipeIngredientRole.INPUT, 40 , 9).addIngredients((Ingredient) recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 14 , 45).addIngredients(Ingredient.of((Items.SNOW_BLOCK).getDefaultInstance()));
		
		builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 9).addItemStack(recipe.getResultItem());

	}
}
