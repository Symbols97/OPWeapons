package com.Symbols97.OPWeapons.crafting.TheForge;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class theforgerecipesorter implements Comparator {
	
	final theforgecraftingmanager workSurface;

	public theforgerecipesorter(theforgecraftingmanager theforgecraftingmanager) {
		this.workSurface = theforgecraftingmanager;
	}

	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof theforgeShapelessRecipes && irecipe2 instanceof theforgeShapedRecipes ? 1
				: (irecipe2 instanceof theforgeShapelessRecipes && irecipe1 instanceof theforgeShapedRecipes
						? -1
						: (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1
								: (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe) o1, (IRecipe) o2);
	}

}