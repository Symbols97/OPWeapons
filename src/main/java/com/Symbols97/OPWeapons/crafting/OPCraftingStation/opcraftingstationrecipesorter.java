package com.Symbols97.OPWeapons.crafting.OPCraftingStation;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class opcraftingstationrecipesorter implements Comparator {
	
	final opcraftingstationcraftingmanager workSurface;

	public opcraftingstationrecipesorter(opcraftingstationcraftingmanager opcraftingstationcraftingmanager) {
		this.workSurface = opcraftingstationcraftingmanager;
	}

	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof opcraftingstationShaplessRecipes && irecipe2 instanceof opcraftingstationShapedRecipes ? 1
				: (irecipe2 instanceof opcraftingstationShaplessRecipes && irecipe1 instanceof opcraftingstationShapedRecipes
						? -1
						: (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1
								: (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe) o1, (IRecipe) o2);
	}

}