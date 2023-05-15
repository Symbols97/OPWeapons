package com.Symbols97.OPWeapons.world;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.world.generation.EntityGeneration;
import com.Symbols97.OPWeapons.world.generation.OreGeneration;
import com.Symbols97.OPWeapons.world.generation.TreeGeneration;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OPWeapons.MOD_ID)
public class WorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(BiomeLoadingEvent event) {
        OreGeneration.generateOres(event);
        EntityGeneration.onEntitySpawn(event);
        TreeGeneration.generateTrees(event);
    }
}