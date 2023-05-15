package com.Symbols97.OPWeapons.world.generation;

import java.util.List;

import com.Symbols97.OPWeapons.world.biome.OPWBiomes;
import com.Symbols97.OPWeapons.world.features.PlacedFeatures;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class TreeGeneration {

	  public static void generateTrees(final BiomeLoadingEvent event) {
	      //  ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
	      //  Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

	        if(event.getName().equals(OPWBiomes.DEAD_ZONE.location())) {
	            List<Holder<PlacedFeature>> base =
	                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

	            base.add(PlacedFeatures.DEMON_TREE_PLACED);
	        }
	        
	        if(event.getName().equals(OPWBiomes.FROST_ZONE.location())) {
	            List<Holder<PlacedFeature>> base =
	                    event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION);

	            base.add(PlacedFeatures.FROST_TREE_PLACED);
	        }
	    }
	
}
