package com.Symbols97.OPWeapons.integration;

import java.util.List;
import java.util.Objects;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.integration.demonfurnace.DemonFurnaceRecipeCategory;
import com.Symbols97.OPWeapons.integration.freezer.CoolerRecipeCategory;
import com.Symbols97.OPWeapons.integration.freezer.FreezerRecipeCategory;
import com.Symbols97.OPWeapons.integration.opcraftingstation.OPCSRecipeCategory;
import com.Symbols97.OPWeapons.integration.opfurnace.OPFurnaceRecipeCategory;
import com.Symbols97.OPWeapons.integration.theforge.TheForgeRecipeCategory;
import com.Symbols97.OPWeapons.recipe.demonfurnace.DemonFurnaceRecipe;
import com.Symbols97.OPWeapons.recipe.freezer.CoolerRecipe;
import com.Symbols97.OPWeapons.recipe.freezer.FreezerRecipe;
import com.Symbols97.OPWeapons.recipe.opcraftingstation.OPCSRecipe;
import com.Symbols97.OPWeapons.recipe.opfurnace.OPFurnaceRecipe;
import com.Symbols97.OPWeapons.recipe.theforge.TheForgeRecipe;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

@JeiPlugin
public class JEIOPWeaponsModePlugin implements IModPlugin {

	public static RecipeType<OPCSRecipe> OP_Crafting = new RecipeType<>(OPCSRecipeCategory.UID, OPCSRecipe.class);
	public static RecipeType<TheForgeRecipe> Forge_Crafting = new RecipeType<>(TheForgeRecipeCategory.UID,TheForgeRecipe.class);
	public static RecipeType<OPFurnaceRecipe> OP_Furnace = new RecipeType<>(OPFurnaceRecipeCategory.UID,OPFurnaceRecipe.class);
	public static RecipeType<DemonFurnaceRecipe> Demon_Furnace = new RecipeType<>(DemonFurnaceRecipeCategory.UID,DemonFurnaceRecipe.class);
	public static RecipeType<FreezerRecipe> Freezer = new RecipeType<>(FreezerRecipeCategory.UID, FreezerRecipe.class);
	public static RecipeType<CoolerRecipe> Cooler = new RecipeType<>(CoolerRecipeCategory.UID, CoolerRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {

		return new ResourceLocation(OPWeapons.MOD_ID, "jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {

		registration.addRecipeCategories(new OPCSRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new TheForgeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

		registration.addRecipeCategories(new OPFurnaceRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new DemonFurnaceRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new FreezerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new CoolerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@SuppressWarnings("resource")
	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

		List<OPCSRecipe> OPCS = rm.getAllRecipesFor(OPCSRecipe.Type.INSTANCE);
		registration.addRecipes(OP_Crafting, OPCS);

		List<TheForgeRecipe> forge = rm.getAllRecipesFor(TheForgeRecipe.Type.INSTANCE);
		registration.addRecipes(Forge_Crafting, forge);

		List<OPFurnaceRecipe> OPFurnace = rm.getAllRecipesFor(OPFurnaceRecipe.Type.INSTANCE);
		registration.addRecipes(OP_Furnace, OPFurnace);

		List<DemonFurnaceRecipe> DemonFurnace = rm.getAllRecipesFor(DemonFurnaceRecipe.Type.INSTANCE);
		registration.addRecipes(Demon_Furnace, DemonFurnace);

		List<FreezerRecipe> FreezerMachine = rm.getAllRecipesFor(FreezerRecipe.Type.INSTANCE);
		registration.addRecipes(Freezer, FreezerMachine);

		List<CoolerRecipe> CoolerMachine = rm.getAllRecipesFor(CoolerRecipe.Type.INSTANCE);
		registration.addRecipes(Cooler, CoolerMachine);
	}
}
