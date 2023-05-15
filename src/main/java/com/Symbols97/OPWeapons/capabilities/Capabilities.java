package com.Symbols97.OPWeapons.capabilities;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Capabilities {

	 public static final Capability<isWearingOPWArmor> WEARING_OPW_ARMOR_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
	

	    private Capabilities() {}

	    public static void setupCapabilities() {
	        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
	        modEventBus.addListener(Capabilities::registerCaps);

	        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
	        forgeBus.addGenericListener(Entity.class, AttacherisWearingOPWArmor::attach);
	    }

	    // make sure the caps classes are registered so they can be found
	    public static void registerCaps(RegisterCapabilitiesEvent event) {
	        event.register(isWearingOPWArmor.class);
	    }
}
