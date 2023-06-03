package com.Symbols97.OPWeapons.world.features;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class PlacedFeatures {
	
	 public static final Holder<PlacedFeature> op_gem_ore_placed = PlacementUtils.register("op_gem_ore",
	            Features.op_gem_ore_gen, OrePlacement.commonOrePlacement(15, // VeinsPerChunk
	                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(25))));
	 
	 public static final Holder<PlacedFeature> steel_scrap_ore_placed = PlacementUtils.register("steel_scrap_ore",
	            Features.steel_scrap_ore_gen, OrePlacement.commonOrePlacement(20, // VeinsPerChunk
	                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
	 
	 public static final Holder<PlacedFeature> soul_block_placed = PlacementUtils.register("soul_block",
	            Features.soul_block_gen, OrePlacement.commonOrePlacement(5, // VeinsPerChunk
	                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(15))));
	 
	 public static final Holder<PlacedFeature> frozen_soul_block_placed = PlacementUtils.register("frozen_soul_block",
	            Features.frozen_soul_block_gen, OrePlacement.commonOrePlacement(5, // VeinsPerChunk
	                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(15))));
	 
	 public static final Holder<PlacedFeature> demon_gold_ore_block_placed = PlacementUtils.register("demon_gold_ore_block",
	            Features.demon_gold_ore_block_gen, OrePlacement.commonOrePlacement(7, // VeinsPerChunk
	                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(45))));
	 
	 public static final Holder<PlacedFeature> frost_gold_ore_block_placed = PlacementUtils.register("frost_gold_ore_block",
	            Features.frost_gold_ore_block_gen, OrePlacement.commonOrePlacement(7, // VeinsPerChunk
	                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(45))));
	 
	 //place and spawn the tree
	 public static final Holder<PlacedFeature> DEMON_TREE_PLACED = PlacementUtils.register("demon_tree_placed",
	            Features.DEMON_TREE_SPAWN, VegetationPlacements.treePlacement(
	                    PlacementUtils.countExtra(3, 0.1f, 2)));//chunk , chance, num
	 
	 public static final Holder<PlacedFeature> FROST_TREE_PLACED = PlacementUtils.register("frost_tree_placed",
	            Features.FROST_TREE_SPAWN, VegetationPlacements.treePlacement(
	                    PlacementUtils.countExtra(3, 0.1f, 2)));//chunk , chance, num

}
