package com.Symbols97.OPWeapons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Symbols97.OPWeapons.blocks.init.BlockEntities;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.config.OPWeaponsClientConfig;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;
import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.management.packets.PacketHandler;
import com.Symbols97.OPWeapons.recipe.RecipeSerializers;
import com.Symbols97.OPWeapons.screen.MenuTypes;
import com.Symbols97.OPWeapons.world.OPWPOIs;
import com.Symbols97.OPWeapons.world.biome.OPWRegion;
import com.Symbols97.OPWeapons.world.biome.OPWSurfaceRule;
import com.Symbols97.OPWeapons.world.dimension.OPWDimensions;
import com.Symbols97.OPWeapons.world.structures.OPWStructures;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("opweapons")
public class OPWeapons {

	public static final String MOD_ID = "opweapons";
	public static final String ModVersion = "1.1.9";
	
	public static final Logger LOGGER = LogManager.getLogger();
	  
	public OPWeapons() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		OPWBlocks.register(bus);
		BlockEntities.register(bus);
		OPWItems.register(bus);
		MenuTypes.register(bus);
		RecipeSerializers.register(bus);
		bus.addListener(this::setup);
		OPWDimensions.register();
		OPWPOIs.register(bus);
		OPWEntities.register(bus);
		
		
		OPWStructures.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
		GeckoLib.initialize();
		Capabilities.setupCapabilities();
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, OPWeaponsClientConfig.SPEC, "OPWeapons/opweapons-client.toml");
	    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OPWeaponsCommonConfig.SPEC, "OPWeapons/opweapons-common.toml");

	}

	public static final CreativeModeTab tabOPWeapons = new CreativeModeTab(MOD_ID) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(OPWItems.op_gem.get());
		}
		
	};
	


	protected static void replaceAttributeValue(RangedAttribute attribute, double maxValue) {
	    attribute.maxValue = maxValue;
	}

	
	private void setup(final FMLCommonSetupEvent event) {
	
		event.enqueueWork(PacketHandler::init);
		
		event.enqueueWork(() ->
		{
			
			replaceAttributeValue((RangedAttribute) Attributes.MAX_HEALTH, 200000);
            // Given we only add two biomes, we should keep our weight relatively low.
            Regions.register(new OPWRegion(new ResourceLocation(MOD_ID, "custom"), 100));

            // Register our surface rules
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, OPWSurfaceRule.makeRules());
            
            SpawnPlacements.register(OPWEntities.DEADWOLF.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            
            SpawnPlacements.register(OPWEntities.FROSTYOSTRICH.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules);
            
            SpawnPlacements.register(OPWEntities.OPGOBLIN.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            
            SpawnPlacements.register(OPWEntities.DEMONGOBLIN.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            
            SpawnPlacements.register(OPWEntities.FROSTGOBLIN.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            
            SpawnPlacements.register(OPWEntities.REAPER.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            
            SpawnPlacements.register(OPWEntities.DEMON.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            
            SpawnPlacements.register(OPWEntities.OPGUARDIAN.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            
            SpawnPlacements.register(OPWEntities.DEMONGUARDIAN.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            
            SpawnPlacements.register(OPWEntities.FROSTGUARDIAN.get(),
                    SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);
            
        });
		
			
	}

}
