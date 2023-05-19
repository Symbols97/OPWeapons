package com.Symbols97.OPWeapons.datagen.server;

import java.util.function.Consumer;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class OPWRecipeProvider extends RecipeProvider {

	public OPWRecipeProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

		// Shaped Recipes
		ShapedRecipeBuilder.shaped(OPWItems.guide_book.get())
		.define('g', OPWItems.op_gem_chunk.get().asItem())
		.define('b', Items.BOOK.asItem())
		.pattern("ggg")
		.pattern("gbg")
		.pattern("ggg")
		.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(OPWItems.op_gem_chunk.get()).getPath(),
				has(OPWItems.op_gem_chunk.get().asItem()))
		.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
				ForgeRegistries.ITEMS.getKey(OPWItems.guide_book.get()).getPath() + "_ct"));
		
		// OP Gem Core
		ShapedRecipeBuilder.shaped(OPWItems.op_gem_core.get()).define('c', OPWItems.op_gem_chunk.get().asItem())
				.define('i', Items.IRON_INGOT.asItem()).define('d', Items.DIAMOND.asItem())
				.define('r', Blocks.REDSTONE_BLOCK.asItem()).pattern("cic").pattern("drd").pattern("ccc")
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey( OPWItems.op_gem_chunk.get()).getPath(),
						has(OPWItems.op_gem_chunk.get().asItem()))
				.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
						ForgeRegistries.ITEMS.getKey(OPWItems.op_gem_core.get()).getPath() + "_ct"));

		ShapedRecipeBuilder.shaped(OPWBlocks.op_crafting_station.get()).define('w', Blocks.CRAFTING_TABLE.asItem())
				.define('i', Items.IRON_INGOT.asItem()).define('c', OPWItems.op_gem_core.get().asItem())
				.define('b', Blocks.IRON_BLOCK.asItem()).pattern(" w ").pattern("ici").pattern("bbb")
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(OPWItems.op_gem_core.get()).getPath(),
						has(OPWItems.op_gem_core.get().asItem()))
				.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
						ForgeRegistries.ITEMS.getKey(OPWBlocks.op_crafting_station.get().asItem()).getPath() + "_ct"));

		ShapedRecipeBuilder.shaped(OPWBlocks.block_of_op_gem.get()).define('g', OPWItems.op_gem.get().asItem())
				.pattern("ggg").pattern("ggg").pattern("ggg")
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(OPWItems.op_gem.get()).getPath(),
						has(OPWItems.op_gem.get().asItem()))
				.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
						ForgeRegistries.ITEMS.getKey(OPWBlocks.block_of_op_gem.get().asItem()).getPath() + "_ct"));

		ShapedRecipeBuilder.shaped(OPWItems.encapsulated_flame.get())
				.define('f', OPWItems.op_flint_and_steel.get().asItem()).define('n', Blocks.NETHERRACK.asItem())
				.define('c', OPWItems.capsule.get().asItem()).pattern("f  ").pattern(" n " ).pattern("  c")
				.unlockedBy("has_" + ForgeRegistries.ITEMS.getKey(OPWItems.capsule.get()).getPath(),
						has(OPWItems.capsule.get().asItem()))
				.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
						ForgeRegistries.ITEMS.getKey(OPWItems.encapsulated_flame.get()).getPath() + "_ct"));

		// Shapeless Recipe
		ShapelessRecipeBuilder.shapeless(OPWItems.op_gem.get().asItem(), 9).requires(OPWBlocks.block_of_op_gem.get())
				.unlockedBy("has_" +  ForgeRegistries.ITEMS.getKey(OPWBlocks.block_of_op_gem.get().asItem()).getPath(),
						has(OPWBlocks.block_of_op_gem.get()))
				.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
						 ForgeRegistries.ITEMS.getKey(OPWItems.op_gem.get()).getPath() + "_bti_ct"));
		
		ShapelessRecipeBuilder.shapeless(OPWBlocks.repair_station.get().asItem(), 1).requires(OPWBlocks.repair_station_v2.get())
		.unlockedBy("has_" +  ForgeRegistries.ITEMS.getKey(OPWBlocks.repair_station_v2.get().asItem()).getPath(),
				has(OPWBlocks.repair_station_v2.get()))
		.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
				 ForgeRegistries.ITEMS.getKey(OPWBlocks.repair_station.get().asItem()).getPath() + "_v1_ct"));
		
		ShapelessRecipeBuilder.shapeless(OPWBlocks.repair_station_v2.get().asItem(), 1).requires(OPWBlocks.repair_station.get())
		.unlockedBy("has_" +  ForgeRegistries.ITEMS.getKey(OPWBlocks.repair_station.get().asItem()).getPath(),
				has(OPWBlocks.repair_station.get()))
		.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
				 ForgeRegistries.ITEMS.getKey(OPWBlocks.repair_station_v2.get().asItem()).getPath() + "_v2_ct"));

		// Cooking Recipe
		// OP Chunk
		SimpleCookingRecipeBuilder
				.smelting(Ingredient.of(OPWBlocks.op_gem_ore.get().asItem()), OPWItems.op_gem_chunk.get(), 1f, 100)
				.unlockedBy("has_" +  ForgeRegistries.ITEMS.getKey(OPWBlocks.op_gem_ore.get().asItem()).getPath(),
						has(OPWBlocks.op_gem_ore.get().asItem()))
				.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
						 ForgeRegistries.ITEMS.getKey(OPWItems.op_gem_chunk.get()).getPath() + "_furnace"));

		// Nether Shard
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.NETHER_STAR), OPWItems.nether_shard.get(), 1f, 100)
				.unlockedBy("has_" +  ForgeRegistries.ITEMS.getKey(Items.NETHER_STAR).getPath(), has(Items.NETHER_STAR))
				.save(consumer, new ResourceLocation(OPWeapons.MOD_ID,
						 ForgeRegistries.ITEMS.getKey(OPWItems.nether_shard.get()).getPath() + "_furnace"));

		
	}

}
