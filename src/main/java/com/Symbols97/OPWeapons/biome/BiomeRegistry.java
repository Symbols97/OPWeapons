package com.Symbols97.OPWeapons.biome;

import com.Symbols97.OPWeapons.biome.DeadZone.BiomeDeadZone;
import com.Symbols97.OPWeapons.biome.FrostZone.BiomeFrostZone;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {
	
	
	public static void mainRegsitry(){
		initializeBiome();
		registerBiome();
	}
	
	public static BiomeGenBase biomeDeadZone;
	public static BiomeGenBase biomeFrostZone;
	
	public static void initializeBiome(){
		
		biomeDeadZone = new BiomeDeadZone(199).setBiomeName("Dead_Zone");
		biomeFrostZone = new BiomeFrostZone(200).setBiomeName("Frost_Zone");
		
	}
	
	public static void registerBiome(){
		BiomeDictionary.registerBiomeType(biomeDeadZone, Type.PLAINS);
		BiomeManager.addSpawnBiome(biomeDeadZone);
		
		BiomeDictionary.registerBiomeType(biomeFrostZone, Type.PLAINS);
		BiomeManager.addSpawnBiome(biomeFrostZone);
		
		
	}

}
