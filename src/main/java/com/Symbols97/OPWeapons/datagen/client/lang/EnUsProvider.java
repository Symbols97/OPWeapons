package com.Symbols97.OPWeapons.datagen.client.lang;


import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class EnUsProvider extends LanguageProvider {

	public EnUsProvider(DataGenerator gen) {
		super(gen, OPWeapons.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		
		// Item Groups
		add("itemGroup.opweapons", "OPWeapons");
		
		add("entity.opweapons.dead_wolf", "Dead Wolf");
		add("entity.opweapons.reaper", "Reaper");
		add("entity.opweapons.demon", "Demon");
		
		add("entity.opweapons.op_guardian", "OP Guardian");
		add("entity.opweapons.demon_guardian", "Demon Guardian");
		add("entity.opweapons.frost_guardian", "Frost Guardian");
		
		add("entity.opweapons.op_goblin", "OP Goblin");
		add("entity.opweapons.demon_goblin", "Demon Goblin");
		add("entity.opweapons.frost_goblin", "Frost Goblin");
		
		add("entity.opweapons.frosty_ostrich", "Frosty Ostrich");
		
		//SpawnEggs
		add(OPWItems.dead_wolf_spawn_egg.get(), "Dead Wolf Spawn Egg");
		add(OPWItems.reaper_spawn_egg.get(), "Reaper Spawn Egg");
		add(OPWItems.demon_spawn_egg.get(), "Demon Spawn Egg");
		
		add(OPWItems.op_guardian_spawn_egg.get(), "OP Guardian Spawn Egg");
		add(OPWItems.demon_guardian_spawn_egg.get(), "Demon Guardian Spawn Egg");
		add(OPWItems.frost_guardian_spawn_egg.get(), "Frost Guardian Spawn Egg");
		add(OPWItems.frosty_ostrich_spawn_egg.get(), "Frosty Ostrich Spawn Egg");
		
		add(OPWItems.op_goblin_spawn_egg.get(), "OP Goblin Spawn Egg");
		add(OPWItems.demon_goblin_spawn_egg.get(), "Demon Goblin Spawn Egg");
		add(OPWItems.frost_goblin_spawn_egg.get(), "Frost Goblin Spawn Egg");
				
		//Foods
		add(OPWItems.magic_food.get(), "Magic Food");
		add(OPWItems.magic_mutton.get(), "Magic Mutton");
		add(OPWItems.pet_food.get(), "Pet Food");
		add(OPWItems.spicy_chicken.get(), "Spicy Chicken");
		add(OPWItems.snow_cone.get(), "Snow Cone");
		add(OPWItems.hot_coffee.get(), "Hot Coffee");
		add(OPWItems.ice_coffee.get(), "Ice Coffee");
		
		// Items
		add(OPWItems.op_gem_chunk.get(), "OP Gem Chunk");
		add(OPWItems.op_gem.get(), "OP Gem");
		add(OPWItems.op_gem_core.get(), "OP Gem Core");
		add(OPWItems.nether_shard.get(), "Nether Shard");
		add(OPWItems.capsule.get(), "Capsule");
		add(OPWItems.op_flint_and_steel.get(), "OP Flint and Steel");
		add(OPWItems.encapsulated_flame.get(), "Encapsulated Flame");
		add(OPWItems.steel_scrap.get(), "Steel Scrap");
		add(OPWItems.steel_ingot.get(), "Steel Ingot");
		add(OPWItems.demon_gem.get(), "Demon Gem");
		add(OPWItems.repair_module.get(), "Repair Module");
		add(OPWItems.ultimate_nether_star.get(), "Ultimate Nether Star");
		add(OPWItems.demon_gem_core.get(), "Demon Gem Core");
		add(OPWItems.frost_gem.get(), "Frost Gem");
		add(OPWItems.lost_gem.get(), "Lost Gem");
		add(OPWItems.frost_gem_core.get(), "Frost Gem Core");
		add(OPWItems.neutral_core.get(), "Neutral Core");
		add(OPWItems.crimson_blade.get(), "Cimson Blade");
		add(OPWItems.hell_stick.get(), "Hell Stick");
		add(OPWItems.frost_blade.get(), "Frost Blade");
		add(OPWItems.frost_stick.get(), "Frost Stick");
		add(OPWItems.lost_pages.get(), "Lost Pages");
		add(OPWItems.death_essence.get(), "Death Essence");
		add(OPWItems.mini_soul.get(), "Mini Soul");
		add(OPWItems.tortured_soul.get(), "Tortured Soul");
		add(OPWItems.frozen_soul.get(), "Frozen Soul");
		add(OPWItems.defrosted_soul.get(), "Defrosted Soul");
		add(OPWItems.soul_harvester.get(), "Soul Harvester");
		add(OPWItems.reaper_immunity_patch.get(), "R.I.P.");
		add(OPWItems.reaper_scythe.get(), "Reaper's Scythe");
		add(OPWItems.neutral_staff.get(), "Neutral Staff");
		add(OPWItems.dead_zone_staff.get(), "Dead Zone Staff");
		add(OPWItems.frost_zone_staff.get(), "Frost Zone Staff");
		add(OPWItems.steel_pipe.get(), "Steel Pipe");
		add(OPWItems.triple_steel_pipe.get(), "Triple Steel Pipe");
		add(OPWItems.vent.get(), "Vent");
		add(OPWItems.gold_particle.get(), "Gold Particle");
		add(OPWItems.synthetic_gold.get(), "Synthetic Gold");
		add(OPWItems.demon_ring.get(), "Demon Ring");
		add(OPWItems.frost_ring.get(), "Frost Ring");
		add(OPWItems.club_head.get(), "Club Head");
		add(OPWItems.club_handle.get(), "Club Handle");
		add(OPWItems.op_vial.get(), "OP Vial");
		add(OPWItems.demon_vial.get(), "Demon Vial");
		add(OPWItems.frost_vial.get(), "Frost Vial");
		add(OPWItems.demon_gold.get(), "Demon Gold");
		add(OPWItems.frost_gold.get(), "Frost Gold");
		add(OPWItems.lapiz_arrow.get(), "Lapiz Arrow");
		add(OPWItems.hammer_head.get(), "Hammer Head");
		add(OPWItems.hammer_handle.get(), "Hammer Handle");
		add(OPWItems.hammer_handle_base.get(), "Hammer Handle Base");
		add(OPWItems.hammer_handle_grip.get(), "Hammer Handle Grip");
		add(OPWItems.hammer_handle_hilt.get(), "Hammer Handle Hilt");
		add(OPWItems.frost_axe_blade.get(), "Frost Axe Blade");
		add(OPWItems.frost_axe_handle.get(), "Frost Axe Handle");
		add(OPWItems.guide_book.get(), "Guide Book");
		
		//Tools / Weapons
		add(OPWItems.op_sword.get(), "OP Sword");
		add(OPWItems.op_pickaxe.get(), "OP Pickaxe");
		add(OPWItems.op_axe.get(), "OP Axe");
		add(OPWItems.op_hoe.get(), "OP Hoe");
		add(OPWItems.op_shovel.get(), "OP Shovel");
		add(OPWItems.fire_sword.get(), "Fire Sword");
		add(OPWItems.ice_sword.get(), "Ice Sword");
		add(OPWItems.demon_slayer.get(), "Demon Slayer");
		add(OPWItems.frost_slayer.get(), "Frost Slayer");
		add(OPWItems.op_club.get(), "OP Club");
		add(OPWItems.demon_hammer.get(), "Demon Hammer");
		add(OPWItems.frost_axe.get(), "Frost Axe");
		add(OPWItems.op_bow.get(), "OP Bow");
		add(OPWItems.lost_pickaxe.get(), "Lost Pickaxe");
		
		//Armors
		add(OPWItems.op_helmet.get(), "OP Helmet");
		add(OPWItems.op_chestplate.get(), "OP Chestplate");
		add(OPWItems.op_leggings.get(), "OP Leggings");
		add(OPWItems.op_boots.get(), "OP Boots");
		
		add(OPWItems.demon_helmet.get(), "Demon Head");
		add(OPWItems.demon_helmet_shaded.get(), "Demon Head (Shaded)");
		add(OPWItems.demon_chestplate.get(), "Demon Chestplate");
		add(OPWItems.demon_leggings.get(), "Demon Leggings");
		add(OPWItems.demon_boots.get(), "Demon Boots");
		
		add(OPWItems.frost_helmet.get(), "Frost Helmet");
		add(OPWItems.frost_chestplate.get(), "Frost Chestplate");
		add(OPWItems.frost_leggings.get(), "Frost Leggings");
		add(OPWItems.frost_boots.get(), "Frost Boots");
		
		add(OPWItems.reaper_helmet.get(), "Reaper Head");
		add(OPWItems.reaper_chestplate.get(), "Reaper Chesplate");
		add(OPWItems.reaper_leggings.get(), "Reaper Leggings");
		add(OPWItems.reaper_boots.get(), "Reaper Boots");
		
		add(OPWItems.lost_helmet.get(), "Lost Helmet");
		add(OPWItems.lost_chestplate.get(), "Lost Chesplate");
		add(OPWItems.lost_leggings.get(), "Lost Leggings");
		add(OPWItems.lost_boots.get(), "Lost Boots");
		
		// Blocks
		add(OPWBlocks.op_gem_ore.get(), "OP Gem Ore");
		add(OPWBlocks.op_crafting_station.get(), "OP Crafting Station");
		add(OPWBlocks.block_of_op_gem.get(), "Block of OP Gem");
		add(OPWBlocks.steel_scrap_ore.get(), "Steel Scrap Ore");
		add(OPWBlocks.repair_station.get(), "Repair Station");
		add(OPWBlocks.repair_station_v2.get(), "Repair Station V2");
		add(OPWBlocks.the_forge.get(), "The Forge");
		add(OPWBlocks.block_of_demon_gem.get(), "Block of Demon Gem");
		add(OPWBlocks.block_of_frost_gem.get(), "Block of Frost Gem");
		add(OPWBlocks.block_of_lost_gem.get(), "Block of Lost Gem");
		add(OPWBlocks.op_furnace.get(), "OP Furnace");
		add(OPWBlocks.demon_furnace.get(), "Demon Furnace");
		add(OPWBlocks.freezer.get(), "§9Freezer");
		add(OPWBlocks.condensedbodg.get(), "Condensed Block of Demon Gem");
		add(OPWBlocks.condensedbofg.get(), "Condensed Block of Frost Gem");
		add(OPWBlocks.soul_ore.get(), "Soul Ore");
		add(OPWBlocks.block_o_enchanting.get(), "Block O' Enchanting");
		add(OPWBlocks.frozen_soul_ore.get(), "Frozen Soul Ore");
		add(OPWBlocks.demon_light.get(), "Demon Light");
		add(OPWBlocks.frost_light.get(), "Frost Light");
		add(OPWBlocks.demon_gold_ore.get(), "Demon Gold Ore");
		add(OPWBlocks.frost_gold_ore.get(), "Frost Gold Ore");
		add(OPWBlocks.demon_log.get(), "Demon Log");
		add(OPWBlocks.stripped_demon_log.get(), "Stripped Demon Log");
		add(OPWBlocks.demon_wood.get(), "Demon Wood");
		add(OPWBlocks.demon_planks.get(), "Demon Planks");
		add(OPWBlocks.demon_leaves.get(), "Demon Leaves");
		add(OPWBlocks.demon_sapling.get(), "Demon Sapling");
		add(OPWBlocks.demon_statue.get(), "Demon Statue");
		
		add(OPWBlocks.frost_log.get(), "Frost Log");
		add(OPWBlocks.stripped_frost_log.get(), "Stripped Frost Log");
		add(OPWBlocks.frost_wood.get(), "Frost Wood");
		add(OPWBlocks.frost_planks.get(), "Frost Planks");
		add(OPWBlocks.frost_leaves.get(), "Frost Leaves");
		add(OPWBlocks.frost_sapling.get(), "Frost Sapling");
		
	}

}
