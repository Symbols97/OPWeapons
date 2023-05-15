package com.Symbols97.OPWeapons.world.generation;

import java.util.Arrays;
import java.util.List;

import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.world.biome.OPWBiomes;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class EntityGeneration {
	 public static void onEntitySpawn(final BiomeLoadingEvent event) {
		 
		 addEntityToSpecificBiomes(event, OPWEntities.DEADWOLF.get(), 85, 5, 10, OPWBiomes.DEAD_ZONE);
		 addEntityToSpecificBiomes(event, OPWEntities.DEMON.get(), 15, 2, 6, OPWBiomes.DEAD_ZONE);
		 addEntityToSpecificBiomes(event, OPWEntities.DEMON.get(), 7, 1, 3, Biomes.NETHER_WASTES);
		 addEntityToSpecificBiomes(event, OPWEntities.DEMONGUARDIAN.get(), 10, 1, 4, OPWBiomes.DEAD_ZONE);
		 
		 addEntityToSpecificBiomes(event, OPWEntities.OPGUARDIAN.get(), 30, 1, 4, Biomes.PLAINS);
		 
		 addEntityToSpecificBiomes(event, OPWEntities.FROSTYOSTRICH.get(), 19, 3, 4, OPWBiomes.FROST_ZONE);
		 addEntityToSpecificBiomes(event, OPWEntities.FROSTGUARDIAN.get(), 1, 1, 2, OPWBiomes.FROST_ZONE);
		 
		 addEntityToSpecificBiomes(event, OPWEntities.REAPER.get(), 20, 1, 1, Biomes.JUNGLE, Biomes.DARK_FOREST);
		
		 addEntityToSpecificBiomes(event, OPWEntities.OPGOBLIN.get(), 45, 3, 3, Biomes.PLAINS, Biomes.MEADOW);
		 addEntityToSpecificBiomes(event, OPWEntities.FROSTGOBLIN.get(), 40, 3, 3, Biomes.ICE_SPIKES, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_SLOPES);
		 addEntityToSpecificBiomes(event, OPWEntities.DEMONGOBLIN.get(), 45, 3, 3, Biomes.BADLANDS, Biomes.NETHER_WASTES);
		 
	    }

	    @SuppressWarnings("unused")
		@SafeVarargs
		private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type,
	                                                        int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
	        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
	        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
	                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

	        if(!isBiomeSelected) {
	            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
	        }
	    }

	   
	    @SafeVarargs
		private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
	                                                  int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
	        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
	        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
	                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

	        if(isBiomeSelected) {
	            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
	        }
	    }

	    @SuppressWarnings("unused")
		private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type,
	                                                      int weight, int minCount, int maxCount) {
	        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
	            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
	        }
	    }

	    @SuppressWarnings("unused")
		private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type,
	                                                     int weight, int minCount, int maxCount) {
	        if(!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
	            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
	            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
	        }
	    }

	    @SuppressWarnings("unused")
		private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type,
	                                                  int weight, int minCount, int maxCount) {
	        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
	            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
	            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
	        }
	    }

	    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type,
	                                             int weight, int minCount, int maxCount) {
	        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
	        base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
	    }
	}