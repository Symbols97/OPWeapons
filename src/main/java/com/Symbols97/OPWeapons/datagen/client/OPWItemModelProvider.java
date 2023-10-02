package com.Symbols97.OPWeapons.datagen.client;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class OPWItemModelProvider extends ItemModelProvider {

	public OPWItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, OPWeapons.MOD_ID, helper);
	}

	protected void blocks(RegistryObject<Block> item) {
		getBuilder(item.getId().toString())
				.parent(getExistingFile(modLoc("block/" + item.getId().getPath())));
	}

	protected void items(RegistryObject<Item> item, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/generated")))
					.texture("layer0", itemTexture);
		} else {
			System.out.println(
					"Texture for " + item.getId().toString() + " not present at " + itemTexture.toString());
		}
	}
	
	protected void tools_weapons(RegistryObject<Item> item, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/handheld")))
					.texture("layer0", itemTexture);
		} else {
			System.out.println(
					"Texture for " + item.getId().toString() + " not present at " + itemTexture.toString());
		}
	}

	
	protected void items(RegistryObject<Item> item) {
		items(item, item.getId());
	}
	
	protected void tools_weapons(RegistryObject<Item> item) {
		tools_weapons(item, item.getId());
	}

	@Override
	protected void registerModels() {
		
		// Blocks
		blocks(OPWBlocks.op_gem_ore);
		blocks(OPWBlocks.op_crafting_station);
		blocks(OPWBlocks.block_of_op_gem);
		blocks(OPWBlocks.kysanite_scrap_ore);
		blocks(OPWBlocks.repair_station);
		blocks(OPWBlocks.repair_station_v2);
		blocks(OPWBlocks.the_forge);
		blocks(OPWBlocks.block_of_demon_gem);
		blocks(OPWBlocks.block_of_frost_gem);
		blocks(OPWBlocks.block_of_lost_gem);
		blocks(OPWBlocks.op_furnace);
		blocks(OPWBlocks.demon_furnace);
		blocks(OPWBlocks.freezer);
		blocks(OPWBlocks.condensedbodg);
		blocks(OPWBlocks.condensedbofg);
		blocks(OPWBlocks.soul_ore);
		blocks(OPWBlocks.block_o_enchanting);
		blocks(OPWBlocks.frozen_soul_ore);
		blocks(OPWBlocks.demon_light);
		blocks(OPWBlocks.frost_light);
		blocks(OPWBlocks.demon_gold_ore);
		blocks(OPWBlocks.frost_gold_ore);
		
		blocks(OPWBlocks.demon_log);
		blocks(OPWBlocks.stripped_demon_log);
		blocks(OPWBlocks.demon_wood);
		blocks(OPWBlocks.demon_planks);
		blocks(OPWBlocks.demon_leaves);
		blocks(OPWBlocks.demon_sapling);
		
		blocks(OPWBlocks.demon_statue);
		
		blocks(OPWBlocks.frost_log);
		blocks(OPWBlocks.stripped_frost_log);
		blocks(OPWBlocks.frost_wood);
		blocks(OPWBlocks.frost_planks);
		blocks(OPWBlocks.frost_leaves);
		blocks(OPWBlocks.frost_sapling);
		
		// Items
		items(OPWItems.op_gem_chunk);
		items(OPWItems.op_gem);
		items(OPWItems.op_gem_core);
		items(OPWItems.nether_shard);
		items(OPWItems.capsule);
		items(OPWItems.op_flint_and_steel);
		items(OPWItems.encapsulated_flame);
		items(OPWItems.kysanite_scrap);
		items(OPWItems.kysanite_ingot);
		items(OPWItems.demon_gem);
		items(OPWItems.repair_module);
		items(OPWItems.ultimate_nether_star);
		items(OPWItems.demon_gem_core);
		items(OPWItems.frost_gem);
		items(OPWItems.lost_gem);
		items(OPWItems.frost_gem_core);
		items(OPWItems.neutral_core);
		items(OPWItems.crimson_blade);
		items(OPWItems.hell_stick);
		items(OPWItems.frost_blade);
		items(OPWItems.frost_stick);
		items(OPWItems.lost_pages);
		items(OPWItems.death_essence);
		items(OPWItems.mini_soul);
		items(OPWItems.tortured_soul);
		items(OPWItems.frozen_soul);
		items(OPWItems.defrosted_soul);
		items(OPWItems.soul_harvester);
		items(OPWItems.reaper_immunity_patch);
		items(OPWItems.kysanite_pipe);
		items(OPWItems.triple_kysanite_pipe);
		items(OPWItems.vent);
		items(OPWItems.gold_particle);
		items(OPWItems.synthetic_gold);
		items(OPWItems.demon_ring);
		items(OPWItems.frost_ring);
		items(OPWItems.club_head);
		items(OPWItems.club_handle);
		items(OPWItems.op_vial);
		items(OPWItems.demon_vial);
		items(OPWItems.frost_vial);
		items(OPWItems.demon_gold);
		items(OPWItems.frost_gold);
		items(OPWItems.lapiz_arrow);
		items(OPWItems.op_club);
		items(OPWItems.demon_hammer);
		items(OPWItems.hammer_head);
		items(OPWItems.hammer_handle);
		items(OPWItems.hammer_handle_base);
		items(OPWItems.hammer_handle_grip);
		items(OPWItems.hammer_handle_hilt);
		items(OPWItems.frost_axe_blade);
		items(OPWItems.frost_axe_handle);
		items(OPWItems.guide_book);
		
		//Foods
		items(OPWItems.magic_food);
		items(OPWItems.magic_mutton);
		items(OPWItems.pet_food);
		items(OPWItems.spicy_chicken);
		items(OPWItems.snow_cone);
		items(OPWItems.hot_coffee);
		items(OPWItems.ice_coffee);
		
		
		
		//Armors
		items(OPWItems.op_helmet);
		items(OPWItems.op_chestplate);
		items(OPWItems.op_leggings);
		items(OPWItems.op_boots);
		
		items(OPWItems.demon_helmet);
		items(OPWItems.demon_helmet_shaded);
		items(OPWItems.demon_chestplate);
		items(OPWItems.demon_leggings);
		items(OPWItems.demon_boots);
		
		items(OPWItems.frost_helmet);
		items(OPWItems.frost_chestplate);
		items(OPWItems.frost_leggings);
		items(OPWItems.frost_boots);
		
		items(OPWItems.reaper_helmet);
		items(OPWItems.reaper_chestplate);
		items(OPWItems.reaper_leggings);
		items(OPWItems.reaper_boots);
		
		items(OPWItems.lost_helmet);
		items(OPWItems.lost_chestplate);
		items(OPWItems.lost_leggings);
		items(OPWItems.lost_boots);
		
		//Tools / Weapons
		tools_weapons(OPWItems.op_sword);
		tools_weapons(OPWItems.op_pickaxe);
		tools_weapons(OPWItems.op_axe);
		tools_weapons(OPWItems.op_shovel);
		tools_weapons(OPWItems.op_hoe);
		tools_weapons(OPWItems.fire_sword);
		tools_weapons(OPWItems.ice_sword);
		tools_weapons(OPWItems.reaper_scythe);
		tools_weapons(OPWItems.neutral_staff);
		tools_weapons(OPWItems.dead_zone_staff);
		tools_weapons(OPWItems.frost_zone_staff);
		tools_weapons(OPWItems.lost_pickaxe);
		tools_weapons(OPWItems.demon_slayer);
		tools_weapons(OPWItems.frost_slayer);
		tools_weapons(OPWItems.frost_axe);


	}

}
