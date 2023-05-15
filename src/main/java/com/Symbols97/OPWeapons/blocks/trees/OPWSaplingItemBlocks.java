package com.Symbols97.OPWeapons.blocks.trees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class OPWSaplingItemBlocks extends ItemBlockWithMetadata{

	
	
	public OPWSaplingItemBlocks(Block block) {
		super(block, block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= OPWSaplings.saplings.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + OPWSaplings.saplings[i];
	}
	

	public int getMetadata (int meta) {
		return meta;
	}
	
}