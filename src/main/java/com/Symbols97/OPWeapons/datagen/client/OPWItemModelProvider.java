package com.Symbols97.OPWeapons.datagen.client;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OPWItemModelProvider extends ItemModelProvider {

	public OPWItemModelProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, OPWeapons.MOD_ID, helper);
	}

	protected void blocks(Item item) {
		getBuilder(item.getRegistryName().toString())
				.parent(getExistingFile(modLoc("block/" + item.getRegistryName().getPath())));
	}

	protected void items(Item item, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/generated")))
					.texture("layer0", itemTexture);
		} else {
			System.out.println(
					"Texture for " + item.getRegistryName().toString() + " not present at " + itemTexture.toString());
		}
	}
	
	protected void tools_weapons(Item item, ResourceLocation texture) {
		ResourceLocation itemTexture = new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath());
		if (existingFileHelper.exists(itemTexture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
			getBuilder(item.getRegistryName().getPath()).parent(getExistingFile(mcLoc("item/handheld")))
					.texture("layer0", itemTexture);
		} else {
			System.out.println(
					"Texture for " + item.getRegistryName().toString() + " not present at " + itemTexture.toString());
		}
	}

	
	protected void items(Item item) {
		items(item, item.getRegistryName());
	}
	
	protected void tools_weapons(Item item) {
		tools_weapons(item, item.getRegistryName());
	}

	@Override
	protected void registerModels() {
		
		// Blocks
		blocks(OPWBlocks.op_gem_ore.get().asItem());
		blocks(OPWBlocks.op_crafting_station.get().asItem());
		blocks(OPWBlocks.block_of_op_gem.get().asItem());
		blocks(OPWBlocks.kysanite_scrap_ore.get().asItem());
		blocks(OPWBlocks.repair_station.get().asItem());
		blocks(OPWBlocks.repair_station_v2.get().asItem());
		blocks(OPWBlocks.the_forge.get().asItem());
		blocks(OPWBlocks.block_of_demon_gem.get().asItem());
		blocks(OPWBlocks.block_of_frost_gem.get().asItem());
		blocks(OPWBlocks.block_of_lost_gem.get().asItem());
		blocks(OPWBlocks.op_furnace.get().asItem());
		blocks(OPWBlocks.demon_furnace.get().asItem());
		blocks(OPWBlocks.freezer.get().asItem());
		blocks(OPWBlocks.condensedbodg.get().asItem());
		blocks(OPWBlocks.condensedbofg.get().asItem());
		blocks(OPWBlocks.soul_ore.get().asItem());
		blocks(OPWBlocks.block_o_enchanting.get().asItem());
		blocks(OPWBlocks.frozen_soul_ore.get().asItem());
		blocks(OPWBlocks.demon_light.get().asItem());
		blocks(OPWBlocks.frost_light.get().asItem());
		blocks(OPWBlocks.demon_gold_ore.get().asItem());
		blocks(OPWBlocks.frost_gold_ore.get().asItem());
		
		blocks(OPWBlocks.demon_log.get().asItem());
		blocks(OPWBlocks.stripped_demon_log.get().asItem());
		blocks(OPWBlocks.demon_wood.get().asItem());
		blocks(OPWBlocks.demon_planks.get().asItem());
		blocks(OPWBlocks.demon_leaves.get().asItem());
		blocks(OPWBlocks.demon_sapling.get().asItem());
		
		blocks(OPWBlocks.demon_statue.get().asItem());
		
		blocks(OPWBlocks.frost_log.get().asItem());
		blocks(OPWBlocks.stripped_frost_log.get().asItem());
		blocks(OPWBlocks.frost_wood.get().asItem());
		blocks(OPWBlocks.frost_planks.get().asItem());
		blocks(OPWBlocks.frost_leaves.get().asItem());
		blocks(OPWBlocks.frost_sapling.get().asItem());
		
		// Items
		items(OPWItems.op_gem_chunk.get());
		items(OPWItems.op_gem.get());
		items(OPWItems.op_gem_core.get());
		items(OPWItems.nether_shard.get());
		items(OPWItems.capsule.get());
		items(OPWItems.op_flint_and_steel.get());
		items(OPWItems.encapsulated_flame.get());
		items(OPWItems.kysanite_scrap.get());
		items(OPWItems.kysanite_ingot.get());
		items(OPWItems.demon_gem.get());
		items(OPWItems.repair_module.get());
		items(OPWItems.ultimate_nether_star.get());
		items(OPWItems.demon_gem_core.get());
		items(OPWItems.frost_gem.get());
		items(OPWItems.lost_gem.get());
		items(OPWItems.frost_gem_core.get());
		items(OPWItems.neutral_core.get());
		items(OPWItems.crimson_blade.get());
		items(OPWItems.hell_stick.get());
		items(OPWItems.frost_blade.get());
		items(OPWItems.frost_stick.get());
		items(OPWItems.lost_pages.get());
		items(OPWItems.death_essence.get());
		items(OPWItems.mini_soul.get());
		items(OPWItems.tortured_soul.get());
		items(OPWItems.frozen_soul.get());
		items(OPWItems.defrosted_soul.get());
		items(OPWItems.soul_harvester.get());
		items(OPWItems.reaper_immunity_patch.get());
		items(OPWItems.kysanite_pipe.get());
		items(OPWItems.triple_kysanite_pipe.get());
		items(OPWItems.vent.get());
		items(OPWItems.gold_particle.get());
		items(OPWItems.synthetic_gold.get());
		items(OPWItems.demon_ring.get());
		items(OPWItems.frost_ring.get());
		items(OPWItems.club_head.get());
		items(OPWItems.club_handle.get());
		items(OPWItems.op_vial.get());
		items(OPWItems.demon_vial.get());
		items(OPWItems.frost_vial.get());
		items(OPWItems.demon_gold.get());
		items(OPWItems.frost_gold.get());
		items(OPWItems.lapiz_arrow.get());
		items(OPWItems.op_club.get());
		items(OPWItems.demon_hammer.get());
		items(OPWItems.hammer_head.get());
		items(OPWItems.hammer_handle.get());
		items(OPWItems.hammer_handle_base.get());
		items(OPWItems.hammer_handle_grip.get());
		items(OPWItems.hammer_handle_hilt.get());
		items(OPWItems.frost_axe_blade.get());
		items(OPWItems.frost_axe_handle.get());
		items(OPWItems.guide_book.get());
		
		//Foods
		items(OPWItems.magic_food.get());
		items(OPWItems.magic_mutton.get());
		items(OPWItems.pet_food.get());
		items(OPWItems.spicy_chicken.get());
		items(OPWItems.snow_cone.get());
		items(OPWItems.hot_coffee.get());
		items(OPWItems.ice_coffee.get());
		
		
		
		//Armors
		items(OPWItems.op_helmet.get());
		items(OPWItems.op_chestplate.get());
		items(OPWItems.op_leggings.get());
		items(OPWItems.op_boots.get());
		
		items(OPWItems.demon_helmet.get());
		items(OPWItems.demon_helmet_shaded.get());
		items(OPWItems.demon_chestplate.get());
		items(OPWItems.demon_leggings.get());
		items(OPWItems.demon_boots.get());
		
		items(OPWItems.frost_helmet.get());
		items(OPWItems.frost_chestplate.get());
		items(OPWItems.frost_leggings.get());
		items(OPWItems.frost_boots.get());
		
		items(OPWItems.reaper_helmet.get());
		items(OPWItems.reaper_chestplate.get());
		items(OPWItems.reaper_leggings.get());
		items(OPWItems.reaper_boots.get());
		
		items(OPWItems.lost_helmet.get());
		items(OPWItems.lost_chestplate.get());
		items(OPWItems.lost_leggings.get());
		items(OPWItems.lost_boots.get());
		
		//Tools / Weapons
		tools_weapons(OPWItems.op_sword.get());
		tools_weapons(OPWItems.op_pickaxe.get());
		tools_weapons(OPWItems.op_axe.get());
		tools_weapons(OPWItems.op_shovel.get());
		tools_weapons(OPWItems.op_hoe.get());
		tools_weapons(OPWItems.fire_sword.get());
		tools_weapons(OPWItems.ice_sword.get());
		tools_weapons(OPWItems.reaper_scythe.get());
		tools_weapons(OPWItems.neutral_staff.get());
		tools_weapons(OPWItems.dead_zone_staff.get());
		tools_weapons(OPWItems.frost_zone_staff.get());
		tools_weapons(OPWItems.lost_pickaxe.get());
		tools_weapons(OPWItems.demon_slayer.get());
		tools_weapons(OPWItems.frost_slayer.get());
		tools_weapons(OPWItems.frost_axe.get());


	}

}
