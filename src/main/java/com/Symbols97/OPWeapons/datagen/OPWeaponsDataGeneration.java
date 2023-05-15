package com.Symbols97.OPWeapons.datagen;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.datagen.client.OPWBlockStateProvider;
import com.Symbols97.OPWeapons.datagen.client.OPWItemModelProvider;
import com.Symbols97.OPWeapons.datagen.client.lang.EnUsProvider;
import com.Symbols97.OPWeapons.datagen.server.OPWBlockTagsProvider;
import com.Symbols97.OPWeapons.datagen.server.OPWItemTagsProvider;
import com.Symbols97.OPWeapons.datagen.server.OPWLootTableProvider;
import com.Symbols97.OPWeapons.datagen.server.OPWRecipeProvider;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = OPWeapons.MOD_ID, bus = Bus.MOD)
public class OPWeaponsDataGeneration {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if (event.includeClient()) {
			
			// Client Data Generation
			generator.addProvider(new OPWBlockStateProvider(generator, helper));
			generator.addProvider(new OPWItemModelProvider(generator, helper));
			generator.addProvider(new EnUsProvider(generator));
		}
		
		if (event.includeServer()) {
			
			OPWBlockTagsProvider blockTags = new OPWBlockTagsProvider(generator, helper);
			
			// Server Data Generation
			generator.addProvider(new OPWRecipeProvider(generator));
			generator.addProvider(blockTags);
			generator.addProvider(new OPWItemTagsProvider(generator, blockTags, helper));
			generator.addProvider(new OPWLootTableProvider(generator));
			
		}
	}
}
