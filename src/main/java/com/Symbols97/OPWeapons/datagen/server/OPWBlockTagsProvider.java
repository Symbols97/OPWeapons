package com.Symbols97.OPWeapons.datagen.server;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.util.OPWTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OPWBlockTagsProvider extends BlockTagsProvider {

	public OPWBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, OPWeapons.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		
		tag(BlockTags.ANIMALS_SPAWNABLE_ON).add(OPWBlocks.block_of_demon_gem.get());
		tag(BlockTags.ANIMALS_SPAWNABLE_ON).add(OPWBlocks.block_of_frost_gem.get());
		
		//Tool to mine
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.op_gem_ore.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.block_of_op_gem.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.block_of_demon_gem.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.block_of_frost_gem.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.block_of_lost_gem.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.kysanite_scrap_ore.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.condensedbodg.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.condensedbofg.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.the_forge.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.op_furnace.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.demon_furnace.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.freezer.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.soul_ore.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.frozen_soul_ore.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.block_o_enchanting.get());
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.demon_gold_ore.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.frost_gold_ore.get());
		
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.demon_light.get());
		tag(BlockTags.MINEABLE_WITH_PICKAXE).add(OPWBlocks.frost_light.get());
		
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.op_crafting_station.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.repair_station.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.repair_station_v2.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.demon_log.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.stripped_demon_log.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.demon_wood.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.demon_planks.get());
		
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.frost_log.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.stripped_frost_log.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.frost_wood.get());
		tag(BlockTags.MINEABLE_WITH_AXE).add(OPWBlocks.frost_planks.get());
		
		
		
		tag(BlockTags.LEAVES).add(OPWBlocks.demon_leaves.get());
		tag(BlockTags.LEAVES).add(OPWBlocks.frost_leaves.get());
		
		tag(BlockTags.LOGS).add(OPWBlocks.demon_log.get());
		tag(BlockTags.LOGS).add(OPWBlocks.demon_wood.get());
		
		tag(BlockTags.LOGS_THAT_BURN).add(OPWBlocks.demon_log.get());
		tag(BlockTags.LOGS_THAT_BURN).add(OPWBlocks.demon_wood.get());
		
		tag(BlockTags.LOGS).add(OPWBlocks.frost_log.get());
		tag(BlockTags.LOGS).add(OPWBlocks.frost_wood.get());
		
		tag(BlockTags.LOGS_THAT_BURN).add(OPWBlocks.frost_log.get());
		tag(BlockTags.LOGS_THAT_BURN).add(OPWBlocks.frost_wood.get());
		
		//Type of tool
		tag(OPWTags.Blocks.NEEDS_LOST_TOOL).add(OPWBlocks.block_o_enchanting.get());
		
		tag(OPWTags.Blocks.NEEDS_OP_TOOL).add(OPWBlocks.soul_ore.get());
		tag(OPWTags.Blocks.NEEDS_OP_TOOL).add(OPWBlocks.frozen_soul_ore.get());
		
		tag(OPWTags.Blocks.NEEDS_OP_TOOL).add(OPWBlocks.demon_gold_ore.get());
		tag(OPWTags.Blocks.NEEDS_OP_TOOL).add(OPWBlocks.frost_gold_ore.get());
		
		tag(OPWTags.Blocks.NEEDS_NETHERITE_TOOL).add(OPWBlocks.op_gem_ore.get());
		tag(BlockTags.NEEDS_DIAMOND_TOOL).add(OPWBlocks.block_of_op_gem.get());
		tag(BlockTags.NEEDS_DIAMOND_TOOL).add(OPWBlocks.block_of_demon_gem.get());
		tag(BlockTags.NEEDS_DIAMOND_TOOL).add(OPWBlocks.block_of_frost_gem.get());
		tag(BlockTags.NEEDS_DIAMOND_TOOL).add(OPWBlocks.block_of_lost_gem.get());
		tag(BlockTags.NEEDS_DIAMOND_TOOL).add(OPWBlocks.condensedbodg.get());
		tag(BlockTags.NEEDS_DIAMOND_TOOL).add(OPWBlocks.condensedbofg.get());
		
		tag(OPWTags.Blocks.NEEDS_OP_TOOL).add(OPWBlocks.kysanite_scrap_ore.get());
	
		
		
		
		
	}

}
