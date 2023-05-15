package com.Symbols97.OPWeapons.recipe;


import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.recipe.demonfurnace.DemonFurnaceRecipe;
import com.Symbols97.OPWeapons.recipe.freezer.CoolerRecipe;
import com.Symbols97.OPWeapons.recipe.freezer.FreezerRecipe;
import com.Symbols97.OPWeapons.recipe.opcraftingstation.OPCSRecipe;
import com.Symbols97.OPWeapons.recipe.opfurnace.OPFurnaceRecipe;
import com.Symbols97.OPWeapons.recipe.repairstation.RepairStationRecipe;
import com.Symbols97.OPWeapons.recipe.repairstation.RepairStationTier4Recipe;
import com.Symbols97.OPWeapons.recipe.theforge.TheForgeRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeSerializers {
	
	 public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
	            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, OPWeapons.MOD_ID);

	    public static final RegistryObject<RecipeSerializer<OPCSRecipe>> OPCSSerializer =
	            SERIALIZERS.register("opcsserializer", () -> OPCSRecipe.Serializer.INSTANCE);
	    
	    public static final RegistryObject<RecipeSerializer<RepairStationRecipe>> RepairStationSerializer =
	            SERIALIZERS.register("repairstationserializer", () -> RepairStationRecipe.Serializer.INSTANCE);
 
	    public static final RegistryObject<RecipeSerializer<RepairStationTier4Recipe>> RepairStationTier4Serializer =
	            SERIALIZERS.register("repairstationtier4serializer", () -> RepairStationTier4Recipe.Serializer.INSTANCE);
	    
	    public static final RegistryObject<RecipeSerializer<TheForgeRecipe>> TheForgeRecipeSerializer =
	            SERIALIZERS.register("theforgerecipeserializer", () -> TheForgeRecipe.Serializer.INSTANCE);
	    
	   
	    
	    public static final RegistryObject<RecipeSerializer<OPFurnaceRecipe>> OPFurnaceRecipeSerializer =
	            SERIALIZERS.register("opfurnacerecipeserializer", () -> OPFurnaceRecipe.Serializer.INSTANCE);
	    
	    public static final RegistryObject<RecipeSerializer<DemonFurnaceRecipe>> DemonFurnaceRecipeSerializer =
	            SERIALIZERS.register("demonfurnacerecipeserializer", () -> DemonFurnaceRecipe.Serializer.INSTANCE);
	    
	    public static final RegistryObject<RecipeSerializer<FreezerRecipe>> FreezerRecipeSerializer =
	            SERIALIZERS.register("freezerrecipeserializer", () -> FreezerRecipe.Serializer.INSTANCE);
	    
	    public static final RegistryObject<RecipeSerializer<CoolerRecipe>> CoolerRecipeSerializer =
	            SERIALIZERS.register("coolerrecipeserializer", () -> CoolerRecipe.Serializer.INSTANCE);

	    public static void register(IEventBus eventBus) {
	        SERIALIZERS.register(eventBus);
	    }
	}