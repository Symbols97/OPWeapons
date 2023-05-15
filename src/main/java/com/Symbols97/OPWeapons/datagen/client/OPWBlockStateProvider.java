package com.Symbols97.OPWeapons.datagen.client;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OPWBlockStateProvider extends BlockStateProvider {

	public OPWBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, OPWeapons.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(OPWBlocks.op_gem_ore.get());
		simpleBlock(OPWBlocks.op_crafting_station.get());
		simpleBlock(OPWBlocks.block_of_op_gem.get());
		simpleBlock(OPWBlocks.steel_scrap_ore.get());
		simpleBlock(OPWBlocks.repair_station.get());
		simpleBlock(OPWBlocks.repair_station_v2.get());
		simpleBlock(OPWBlocks.the_forge.get());
		simpleBlock(OPWBlocks.block_of_demon_gem.get());
		simpleBlock(OPWBlocks.block_of_frost_gem.get());
		simpleBlock(OPWBlocks.block_of_lost_gem.get());
		simpleBlock(OPWBlocks.op_furnace.get());
		simpleBlock(OPWBlocks.demon_furnace.get());
		simpleBlock(OPWBlocks.freezer.get());
		simpleBlock(OPWBlocks.condensedbodg.get());
		simpleBlock(OPWBlocks.condensedbofg.get());
		simpleBlock(OPWBlocks.soul_ore.get());
		simpleBlock(OPWBlocks.block_o_enchanting.get());
		simpleBlock(OPWBlocks.frozen_soul_ore.get());
		simpleBlock(OPWBlocks.demon_light.get());
		simpleBlock(OPWBlocks.frost_light.get());
		simpleBlock(OPWBlocks.demon_gold_ore.get());
		simpleBlock(OPWBlocks.frost_gold_ore.get());
		
		simpleBlock(OPWBlocks.demon_wood.get());
		simpleBlock(OPWBlocks.demon_planks.get());
		simpleBlock(OPWBlocks.demon_leaves.get());
		simpleBlock(OPWBlocks.demon_sapling.get());
		
		simpleBlock(OPWBlocks.demon_statue.get());
		
		simpleBlock(OPWBlocks.frost_wood.get());
		simpleBlock(OPWBlocks.frost_planks.get());
		simpleBlock(OPWBlocks.frost_leaves.get());
		simpleBlock(OPWBlocks.frost_sapling.get());
		
	}
}
