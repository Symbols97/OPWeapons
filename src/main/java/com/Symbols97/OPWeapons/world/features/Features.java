package com.Symbols97.OPWeapons.world.features;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class Features {
	  public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
	            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, OPWeapons.MOD_ID);

		
	 public static final RegistryObject<ConfiguredFeature<?, ?>> DEMON_TREE =
	            CONFIGURED_FEATURES.register("demon_tree", () ->
	                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
	                            BlockStateProvider.simple(OPWBlocks.demon_log.get()),
	                            new StraightTrunkPlacer(5, 6, 3),
	                            BlockStateProvider.simple(OPWBlocks.demon_leaves.get()),
	                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
	                            new TwoLayersFeatureSize(1, 0, 2)).build()));

	  public static final RegistryObject<ConfiguredFeature<?, ?>> DEMON_TREE_SPAWN =
	            CONFIGURED_FEATURES.register("demon_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
	                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
	                    		PlacedFeatures.DEMON_TREE_CHECKED.getHolder().get(),
	                            0.5F)), PlacedFeatures.DEMON_TREE_CHECKED.getHolder().get())));
	  
	  
	  
	  public static final RegistryObject<ConfiguredFeature<?, ?>> FROST_TREE =
	            CONFIGURED_FEATURES.register("frost_tree", () ->
	                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
	                            BlockStateProvider.simple(OPWBlocks.frost_log.get()),
	                            new StraightTrunkPlacer(5, 6, 3),
	                            BlockStateProvider.simple(OPWBlocks.frost_leaves.get()),
	                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
	                            new TwoLayersFeatureSize(1, 0, 2)).build()));

	  public static final RegistryObject<ConfiguredFeature<?, ?>> FROST_TREE_SPAWN =
	            CONFIGURED_FEATURES.register("frost_tree_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
	                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
	                    		PlacedFeatures.FROST_TREE_CHECKED.getHolder().get(),
	                            0.5F)), PlacedFeatures.FROST_TREE_CHECKED.getHolder().get())));
	
	
	// Registry
	 public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ORES = Suppliers.memoize(() -> List.of(
	            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.op_gem_ore.get().defaultBlockState())));
	 
	 public static final Supplier<List<OreConfiguration.TargetBlockState>> RARE_OVERWORLD_ORES = Suppliers.memoize(() -> List.of(
	            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, OPWBlocks.kysanite_scrap_ore.get().defaultBlockState())));
	 
	 public static final Supplier<List<OreConfiguration.TargetBlockState>> DEAD_ZONE_ORES = Suppliers.memoize(() -> List.of(
	            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.soul_ore.get().defaultBlockState()),
	            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.demon_gold_ore.get().defaultBlockState())));
	 
	 public static final Supplier<List<OreConfiguration.TargetBlockState>> FROST_ZONE_ORES = Suppliers.memoize(() -> List.of(
	            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.frozen_soul_ore.get().defaultBlockState()),
	            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.frost_gold_ore.get().defaultBlockState())));

	           

	 //Gen
	 public static final RegistryObject<ConfiguredFeature<?, ?>> OVERWORLD_ORE_GEN = CONFIGURED_FEATURES.register("overworld_ore_gen",
	            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ORES.get(),4)));
	 
	 public static final RegistryObject<ConfiguredFeature<?, ?>> RARE_OVERWORLD_ORE_GEN = CONFIGURED_FEATURES.register("rare_overworld_ore_gen",
	            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(RARE_OVERWORLD_ORES.get(),5)));
	 
	 public static final RegistryObject<ConfiguredFeature<?, ?>> DEAD_ZONE_ORE_GEN = CONFIGURED_FEATURES.register("dead_zone_ore_gen",
	            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DEAD_ZONE_ORES.get(), 5)));
	 
	 public static final RegistryObject<ConfiguredFeature<?, ?>> FROST_ZONE_ORE_GEN = CONFIGURED_FEATURES.register("frost_zone_ore_gen",
	            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(FROST_ZONE_ORES.get(), 4)));

	 public static void register(IEventBus eventBus) {
		 CONFIGURED_FEATURES.register(eventBus);
	}
	 

}
