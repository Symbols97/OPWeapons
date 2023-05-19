package com.Symbols97.OPWeapons.world.features;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PlacedFeatures {

	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister
			.create(Registry.PLACED_FEATURE_REGISTRY, OPWeapons.MOD_ID);

	  public static final RegistryObject<PlacedFeature> OVERWORLD_ORE_PLACED = PLACED_FEATURES.register("overworld_ore_placed",
	            () -> new PlacedFeature(Features.OVERWORLD_ORE_GEN.getHolder().get(),
	                    commonOrePlacement(15, // VeinsPerChunk
	                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(60)))));
	  
	  
	  public static final RegistryObject<PlacedFeature> RARE_OVERWORLD_ORE_PLACED = PLACED_FEATURES.register("rare_overworld_ore_placed",
	            () -> new PlacedFeature(Features.RARE_OVERWORLD_ORE_GEN.getHolder().get(),
	                    commonOrePlacement(20, // VeinsPerChunk
	                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(0)))));
	  
	  
	  public static final RegistryObject<PlacedFeature> DEAD_ZONE_ORE_PLACED = PLACED_FEATURES.register("dead_zone_ore_placed",
	            () -> new PlacedFeature(Features.DEAD_ZONE_ORE_GEN.getHolder().get(),
	                    commonOrePlacement(7, // VeinsPerChunk
	                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(45)))));
	  
	  
	  public static final RegistryObject<PlacedFeature> FROST_ZONE_ORE_PLACED = PLACED_FEATURES.register("frost_zone_ore_placed",
	            () -> new PlacedFeature(Features.FROST_ZONE_ORE_GEN.getHolder().get(),
	                    commonOrePlacement(7, // VeinsPerChunk
	                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(0), VerticalAnchor.aboveBottom(45)))));

	  
	  
	  
	  public static final RegistryObject<PlacedFeature> DEMON_TREE_CHECKED = PLACED_FEATURES.register("demon_tree_checked",
	            () -> new PlacedFeature(Features.DEMON_TREE.getHolder().get(),
	                    List.of(PlacementUtils.filteredByBlockSurvival(OPWBlocks.demon_sapling.get()))));

	   public static final RegistryObject<PlacedFeature> DEMON_TREE_PLACED = PLACED_FEATURES.register("demon_tree_placed",
	            () -> new PlacedFeature(Features.DEMON_TREE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
	                    PlacementUtils.countExtra(3, 0.1f, 2))));
	   
	   
	   
	   
	   
	   public static final RegistryObject<PlacedFeature> FROST_TREE_CHECKED = PLACED_FEATURES.register("frost_tree_checked",
	            () -> new PlacedFeature(Features.FROST_TREE.getHolder().get(),
	                    List.of(PlacementUtils.filteredByBlockSurvival(OPWBlocks.frost_sapling.get()))));

	   public static final RegistryObject<PlacedFeature> FROST_TREE_PLACED = PLACED_FEATURES.register("frost_tree_placed",
	            () -> new PlacedFeature(Features.FROST_TREE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
	                    PlacementUtils.countExtra(3, 0.1f, 2))));

	    
	    

	
	
	public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
	}

	public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		return orePlacement(CountPlacement.of(p_195344_), p_195345_);
	}

	public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
	}

	
	public static void register(IEventBus eventBus) {
		PLACED_FEATURES.register(eventBus);
	}

}
