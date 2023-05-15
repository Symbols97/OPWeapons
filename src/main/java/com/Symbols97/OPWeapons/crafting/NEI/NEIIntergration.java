package com.Symbols97.OPWeapons.crafting.NEI;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.managment.ModLoadedChecker;

import codechicken.nei.api.API;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.item.ItemStack;

public class NEIIntergration {
	public static void registerNEIRecipes() {
		
		if (ModLoadedChecker.isneiLoaded) {
			
			
			
		//Freezer	
		TemplateRecipeHandler FreezerNEI = new FreezerNEI();
		API.registerUsageHandler(FreezerNEI);
		API.registerRecipeHandler(FreezerNEI);
		//Cooler
		TemplateRecipeHandler CoolerNEI = new CoolerNEI();
		API.registerUsageHandler(CoolerNEI);
		API.registerRecipeHandler(CoolerNEI);
		//OPFurnace
		TemplateRecipeHandler OPFurnaceNEI = new OPFurnaceNEI();
		API.registerUsageHandler(OPFurnaceNEI);
		API.registerRecipeHandler(OPFurnaceNEI);
		//Demon Furnace
		TemplateRecipeHandler DemonFurnaceNEI = new DemonFurnaceNEI();
		API.registerUsageHandler(DemonFurnaceNEI);
		API.registerRecipeHandler(DemonFurnaceNEI);
		//OP Crafting Station
		TemplateRecipeHandler OPCraftingStationNEI = new OPCraftingStationNEI();
		API.registerUsageHandler(OPCraftingStationNEI);
		API.registerRecipeHandler(OPCraftingStationNEI);
		//The Forge
		TemplateRecipeHandler TheForgeNEI = new TheForgeNEI();
		API.registerUsageHandler(TheForgeNEI);
		API.registerRecipeHandler(TheForgeNEI);

		//Hidden Items
		API.hideItem(new ItemStack (OPWeapons.OPFurnaceActive));
		API.hideItem(new ItemStack (OPWeapons.DemonFurnaceActive));
		API.hideItem(new ItemStack (OPWeapons.DeadZonePortal));
		API.hideItem(new ItemStack (OPWeapons.FrostZonePortal));
		}
	}
}