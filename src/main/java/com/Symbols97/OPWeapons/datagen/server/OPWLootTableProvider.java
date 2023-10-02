package com.Symbols97.OPWeapons.datagen.server;

import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.datagen.BaseLootTableProvider;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class OPWLootTableProvider extends BaseLootTableProvider {

	public OPWLootTableProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void addTables() {
		dropSelf(OPWBlocks.op_gem_ore.get());
		dropSelf(OPWBlocks.block_of_op_gem.get());
		dropSelf(OPWBlocks.block_of_demon_gem.get());
		dropSelf(OPWBlocks.block_of_frost_gem.get());
		dropSelf(OPWBlocks.block_of_lost_gem.get());
		dropSelf(OPWBlocks.condensedbodg.get());
		dropSelf(OPWBlocks.condensedbofg.get());
		dropSelf(OPWBlocks.op_crafting_station.get());
		dropSelf(OPWBlocks.kysanite_scrap_ore.get());
		dropSelf(OPWBlocks.repair_station.get());
		dropSelf(OPWBlocks.repair_station_v2.get());
		dropSelf(OPWBlocks.the_forge.get());
		dropSelf(OPWBlocks.op_furnace.get());
		dropSelf(OPWBlocks.demon_furnace.get());
		dropSelf(OPWBlocks.freezer.get());
		dropSelf(OPWBlocks.demon_gold_ore.get());
		dropSelf(OPWBlocks.frost_gold_ore.get());
		dropSelf(OPWBlocks.demon_log.get());
		dropSelf(OPWBlocks.stripped_demon_log.get());
		dropSelf(OPWBlocks.demon_wood.get());
		dropSelf(OPWBlocks.demon_planks.get());
		dropSelf(OPWBlocks.demon_sapling.get());
		dropSelf(OPWBlocks.demon_statue.get());
		dropSelf(OPWBlocks.frost_log.get());
		dropSelf(OPWBlocks.stripped_frost_log.get());
		dropSelf(OPWBlocks.frost_wood.get());
		dropSelf(OPWBlocks.frost_planks.get());
		
//		dropSelf(OPWBlocks.demon_leaves.get());
//		dropSelf(OPWBlocks.frost_leaves.get());
		
		silkTouch(OPWBlocks.soul_ore.get(), OPWItems.mini_soul.get(),0,1);
		silkTouch(OPWBlocks.frozen_soul_ore.get(), OPWItems.frozen_soul.get(),0,1);
		
		
		silkTouchBlock(OPWBlocks.demon_light.get(), Blocks.AIR,0,0);
		silkTouchBlock(OPWBlocks.frost_light.get(), Blocks.AIR,0,0);
	}

	protected void silkTouchBlock(Block block, Block silk, int min, int max) {
		add(block, createSilkTouchTableBlock(block.getRegistryName().getPath(), block, silk, min, max));
	}
	
	protected void silkTouch(Block block, Item silk, int min, int max) {
		add(block, createSilkTouchTable(block.getRegistryName().getPath(), block, silk, min, max));
	}

	protected void dropSelf(Block block) {
		add(block, createSimpleTable(block.getRegistryName().getPath(), block));
	}
}
