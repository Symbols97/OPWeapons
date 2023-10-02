package com.Symbols97.OPWeapons.world.features;

import java.util.List;

import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
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
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class Features {

	//Build tree
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> DEMON_TREE = FeatureUtils.register("demon", Feature.TREE,
			new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(OPWBlocks.demon_log.get()), new StraightTrunkPlacer(5, 6, 3),
					BlockStateProvider.simple(OPWBlocks.demon_leaves.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4), new TwoLayersFeatureSize(1, 0, 2))
					.dirt(BlockStateProvider.simple(OPWBlocks.block_of_demon_gem.get())).build());

	//check if the tree can spawn
	public static final Holder<PlacedFeature> DEMON_TREE_CHECKED = PlacementUtils.register("demon_tree_checked", DEMON_TREE,
			PlacementUtils.filteredByBlockSurvival(OPWBlocks.demon_sapling.get()));

	//spawn the tree
	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> DEMON_TREE_SPAWN = FeatureUtils.register("demon_tree_spawn", Feature.RANDOM_SELECTOR,
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(DEMON_TREE_CHECKED, 0.5F)), DEMON_TREE_CHECKED));

	
	public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FROST_TREE = FeatureUtils.register("frost", Feature.TREE,
			new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(OPWBlocks.frost_log.get()), new StraightTrunkPlacer(5, 6, 3),
					BlockStateProvider.simple(OPWBlocks.frost_leaves.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4), new TwoLayersFeatureSize(1, 0, 2))
					.dirt(BlockStateProvider.simple(OPWBlocks.block_of_frost_gem.get())).build());

	public static final Holder<PlacedFeature> FROST_TREE_CHECKED = PlacementUtils.register("frost_tree_checked", FROST_TREE,
			PlacementUtils.filteredByBlockSurvival(OPWBlocks.frost_sapling.get()));

	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> FROST_TREE_SPAWN = FeatureUtils.register("frost_tree_spawn", Feature.RANDOM_SELECTOR,
			new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FROST_TREE_CHECKED, 0.5F)), FROST_TREE_CHECKED));

	
	// Registry
	public static final List<OreConfiguration.TargetBlockState> op_gem_ore_block = List
			.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.op_gem_ore.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> kysanite_scrap_ore_block = List
			.of(OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, OPWBlocks.kysanite_scrap_ore.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> soul_block = List
			.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.soul_ore.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> frozen_soul_block = List
			.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.frozen_soul_ore.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> demon_gold_ore_block = List
			.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.demon_gold_ore.get().defaultBlockState()));

	public static final List<OreConfiguration.TargetBlockState> frost_gold_ore_block = List
			.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, OPWBlocks.frost_gold_ore.get().defaultBlockState()));

	// Setup
	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> op_gem_ore_gen = FeatureUtils.register("op_gem_ore_gen", Feature.ORE,
			new OreConfiguration(op_gem_ore_block, 4)); // Vein Size

	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> kysanite_scrap_ore_gen = FeatureUtils.register("kysanite_scrap_ore_gen", Feature.ORE,
			new OreConfiguration(kysanite_scrap_ore_block, 5)); // Vein Size

	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> soul_block_gen = FeatureUtils.register("soul_block_gen", Feature.ORE, new OreConfiguration(soul_block, 4)); // Vein
																																													// Size

	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> frozen_soul_block_gen = FeatureUtils.register("frozen_soul_block_gen", Feature.ORE,
			new OreConfiguration(frozen_soul_block, 4)); // Vein Size

	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> demon_gold_ore_block_gen = FeatureUtils.register("demon_gold_ore_block_gen", Feature.ORE,
			new OreConfiguration(demon_gold_ore_block, 5)); // Vein Size

	public static final Holder<ConfiguredFeature<OreConfiguration, ?>> frost_gold_ore_block_gen = FeatureUtils.register("frost_gold_ore_block_gen", Feature.ORE,
			new OreConfiguration(frost_gold_ore_block, 5)); // Vein Size

}
