package com.Symbols97.OPWeapons.world.biome;

import javax.annotation.Nullable;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class OPWBiomesBuilder {

	@Nullable
	private static final Music NORMAL_MUSIC = null;

	protected static int calculateSkyColor(float color) {
		float $$1 = color / 3.0F;
		$$1 = Mth.clamp($$1, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
	}

	private static Biome deadzonebiome(Biome.Precipitation precipitation,
			float temperature, float downfall, MobSpawnSettings.Builder spawnBuilder,
			BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
		
		return deadzonebiome(precipitation, temperature, downfall, 4159204, 329011, spawnBuilder,
				biomeBuilder, music);
	}

	private static Biome deadzonebiome(Biome.Precipitation precipitation,
			float temperature, float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder,
			BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
		
		return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(8194570).waterFogColor(8194570)
						.fogColor(8397346).skyColor(8397346).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
						.backgroundMusic(music).build())
				.mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
	}

	private static Biome frostzonebiome(Biome.Precipitation precipitation, float temperature,
			float downfall, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder,
			@Nullable Music music) {
		
		return frostzonebiome(precipitation, temperature, downfall, 4159204, 329011, spawnBuilder, biomeBuilder,
				music);
	}

	private static Biome frostzonebiome(Biome.Precipitation precipitation, float temperature,
			float downfall, int waterColor, int waterFogColor, MobSpawnSettings.Builder spawnBuilder,
			BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
		
		return (new Biome.BiomeBuilder()).precipitation(precipitation).temperature(temperature)
				.downfall(downfall)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(waterColor).waterFogColor(waterFogColor)
						.fogColor(12638463).skyColor(10281968)
						.ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).backgroundMusic(music).build())
				.mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
	}

	private static void globalGeneration(BiomeGenerationSettings.Builder builder) {
		BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
		// BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
		// BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
		BiomeDefaultFeatures.addDefaultSprings(builder);
		// BiomeDefaultFeatures.addSurfaceFreezing(builder);
		BiomeDefaultFeatures.addDefaultOres(builder);
		BiomeDefaultFeatures.addExtraEmeralds(builder);
	}

	public static Biome dead_zone_builder() {

		//MobSpawnSettings.Builder dz_spawns = new MobSpawnSettings.Builder();
		MobSpawnSettings.Builder dz_spawns = new MobSpawnSettings.Builder();
		//dz_spawns.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(OPWEntities.DEMON.get(),100, 1, 50));
        
		
		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();

		globalGeneration(biomeBuilder);


		return deadzonebiome(Biome.Precipitation.NONE, 2.0F, 0.0F, dz_spawns, biomeBuilder, NORMAL_MUSIC);
	}
	
	public static Biome frost_zone_builder() {

		MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
		

		BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder();
		BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);
		globalGeneration(biomeBuilder);
		BiomeDefaultFeatures.addBlueIce(biomeBuilder);
		BiomeDefaultFeatures.addFrozenSprings(biomeBuilder);
		

		return frostzonebiome(Biome.Precipitation.RAIN, -0.7F, 5.0F, spawnBuilder, biomeBuilder, NORMAL_MUSIC);
	}


}
