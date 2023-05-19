package com.Symbols97.OPWeapons.world.dimension;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class OPWDimensions {
	
	public static final ResourceKey<Level>  DZ_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(OPWeapons.MOD_ID, "dead_zone"));
	
	public static final ResourceKey<DimensionType> DZ_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(OPWeapons.MOD_ID, "dead_zone"));

	
	public static final ResourceKey<Level>  FZ_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(OPWeapons.MOD_ID, "frost_zone"));
	
	public static final ResourceKey<DimensionType> FZ_TYPE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(OPWeapons.MOD_ID, "frost_zone"));

	
	public static void register() {
		
	}
}
