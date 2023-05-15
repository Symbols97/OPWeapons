package com.Symbols97.OPWeapons.world.biome;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BiomeRegister {
    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event)
    {
        IForgeRegistry<Biome> registry = event.getRegistry();
        registry.register(OPWBiomesBuilder.dead_zone_builder().setRegistryName(OPWBiomes.DEAD_ZONE.location()));
        registry.register(OPWBiomesBuilder.frost_zone_builder().setRegistryName(OPWBiomes.FROST_ZONE.location()));
        
    }
}