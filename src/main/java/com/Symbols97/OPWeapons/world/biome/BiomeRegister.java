package com.Symbols97.OPWeapons.world.biome;

import java.util.function.Supplier;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeRegister {
	
	public static DeferredRegister<Biome> BIOME_REGISTER = DeferredRegister.create(Registry.BIOME_REGISTRY, OPWeapons.MOD_ID);
	
    public static void registerBiomes()
    {
        
        register(OPWBiomes.DEAD_ZONE, OPWBiomesBuilder::dead_zone_builder);
        register(OPWBiomes.FROST_ZONE, OPWBiomesBuilder::frost_zone_builder);
        
    }
    
    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier)
    {
        return BIOME_REGISTER.register(key.location().getPath(), biomeSupplier);
    }
}