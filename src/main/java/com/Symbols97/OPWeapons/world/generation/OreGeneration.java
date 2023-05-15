package com.Symbols97.OPWeapons.world.generation;

import java.util.List;

import com.Symbols97.OPWeapons.world.biome.OPWBiomes;
import com.Symbols97.OPWeapons.world.features.PlacedFeatures;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

	 public static void generateOres(BiomeLoadingEvent event) {
	        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

	        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
	        	 base.add(PlacedFeatures.op_gem_ore_placed);
	        } else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
		        
		    } else if (event.getName().equals(OPWBiomes.DEAD_ZONE.location())) {
	        	base.add(PlacedFeatures.soul_block_placed);
	        	base.add(PlacedFeatures.demon_gold_ore_block_placed);
	        	
	        	
	        } else if (event.getName().equals(OPWBiomes.FROST_ZONE.location())){
	        	base.add(PlacedFeatures.frozen_soul_block_placed);
	        	base.add(PlacedFeatures.frost_gold_ore_block_placed);
	        } else {
	        	 base.add(PlacedFeatures.op_gem_ore_placed);
	        	 base.add(PlacedFeatures.steel_scrap_ore_placed);
	        
	        }
	       
	    }
	
}
