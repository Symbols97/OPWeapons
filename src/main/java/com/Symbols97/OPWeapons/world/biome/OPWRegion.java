package com.Symbols97.OPWeapons.world.biome;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;


public class OPWRegion extends Region {
	
	//For Overworld generation
	     public OPWRegion(ResourceLocation name, int weight)
	     {
	         super(name, RegionType.OVERWORLD, weight);
	     }

	     @Override
	     public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
	     {
	         this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
	             // Simple example:
	             // Replace the Vanilla desert with our hot_red biome
	             //builder.replaceBiome(Biomes.DESERT, OPWBiomes.DEAD_ZONE);

	         });
	     }

}
