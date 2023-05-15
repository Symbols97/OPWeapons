package com.Symbols97.OPWeapons.crafting.RepairStation;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class repairstationRecipeSorter implements Comparator {

	final repairstationCraftingManager workSurface;

	public repairstationRecipeSorter(repairstationCraftingManager repairstationCraftingManager) {
		this.workSurface = repairstationCraftingManager;
	}

	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof repairstationShapelessRecipes && irecipe2 instanceof repairstationShapedRecipes ? 1
				: (irecipe2 instanceof repairstationShapelessRecipes && irecipe1 instanceof repairstationShapedRecipes
						? -1
						: (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1
								: (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe) o1, (IRecipe) o2);
	}

}
