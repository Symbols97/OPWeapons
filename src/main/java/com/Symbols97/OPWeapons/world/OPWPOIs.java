package com.Symbols97.OPWeapons.world;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OPWPOIs {

	public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES,
			OPWeapons.MOD_ID);

	
	
	
	public static final RegistryObject<PoiType> DZ_Portal = POI.register("dz_portal_poi", () -> new PoiType(
            ImmutableSet.copyOf(OPWBlocks.dead_zone_portal_block.get().getStateDefinition().getPossibleStates())
            , 0, 1));


	public static final RegistryObject<PoiType> FZ_Portal = POI.register("fz_portal_poi", () -> new PoiType(
            ImmutableSet.copyOf(OPWBlocks.frost_zone_portal_block.get().getStateDefinition().getPossibleStates())
            , 0, 1));
	
	public static void register(IEventBus eventBus) {
		POI.register(eventBus);
	}

}
