package com.Symbols97.OPWeapons.world.biome;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class OPWBiomes {
	
	public static final ResourceKey<Biome> DEAD_ZONE = register("dead_zone_biome");
	public static final ResourceKey<Biome> FROST_ZONE = register("frost_zone_biome");

	private static ResourceKey<Biome> register(String name) {
		return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(OPWeapons.MOD_ID, name));
	}
	
}
