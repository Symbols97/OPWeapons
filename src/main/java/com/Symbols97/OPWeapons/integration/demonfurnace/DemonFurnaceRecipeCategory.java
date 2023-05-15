package com.Symbols97.OPWeapons.integration.demonfurnace;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.recipe.demonfurnace.DemonFurnaceRecipe;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
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

public class DemonFurnaceRecipeCategory implements IRecipeCategory<DemonFurnaceRecipe> {
	
	public final static ResourceLocation UID = new ResourceLocation(OPWeapons.MOD_ID, "4demon_furnace");
	public final static ResourceLocation TEXTURE = new ResourceLocation(OPWeapons.MOD_ID, "textures/gui/nei_gui/demonfurnacegui.png");
	public static final int width = 176;
	public static final int height = 85;

	private final IDrawable background;
	private final IDrawable icon;
	private final Component localizedName;
	
	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedFlame;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

	public DemonFurnaceRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = TEXTURE;
		background = guiHelper.createDrawable(location, 0, 0, width, height);
		icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(OPWBlocks.demon_furnace.get()));
		localizedName = new TextComponent("Demon Furnace");
		this.staticFlame = guiHelper.createDrawable(TEXTURE, 176, 0, 14, 14);
		this.animatedFlame = guiHelper.createAnimatedDrawable(this.staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
		
		 this.cachedArrows = CacheBuilder.newBuilder().maximumSize(25L).build(new CacheLoader<Integer, IDrawableAnimated>() {
	          public IDrawableAnimated load(Integer cookTime) {
	            return guiHelper.drawableBuilder(TEXTURE, 176, 15, 24, 17)
	              .buildAnimated(cookTime.intValue(), IDrawableAnimated.StartDirection.LEFT, false);
	          }
	        });
	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<? extends DemonFurnaceRecipe> getRecipeClass() {
		return DemonFurnaceRecipe.class;
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
	public void draw(DemonFurnaceRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
		this.animatedFlame.draw(stack, 57, 37);
		IDrawableAnimated arrow = getArrow(recipe);
		arrow.draw(stack, 80, 35);
		// drawExperience(recipe, stack, 0);
		
		IRecipeCategory.super.draw(recipe, recipeSlotsView, stack, mouseX, mouseY);
	}

	protected IDrawableAnimated getArrow(DemonFurnaceRecipe recipe) {
	    int cookTime = 20;
	    if (cookTime <= 0)
	      cookTime = cookTime / 20; 
	    return (IDrawableAnimated)this.cachedArrows.getUnchecked(Integer.valueOf(cookTime));
	  }
	
	
	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, DemonFurnaceRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 56 , 17).addIngredients((Ingredient) recipe.getIngredients().get(0));
		
		builder.addSlot(RecipeIngredientRole.INPUT, 56 , 53).addIngredients(Ingredient.of((Items.IRON_BLOCK).getDefaultInstance()));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 35).addItemStack(recipe.getResultItem());

	}
}