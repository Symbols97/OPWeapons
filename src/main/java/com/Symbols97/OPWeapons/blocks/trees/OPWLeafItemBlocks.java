package com.Symbols97.OPWeapons.blocks.trees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class OPWLeafItemBlocks extends ItemBlock{

	
	
	public OPWLeafItemBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= OPWLeaves.leaves.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + OPWLeaves.leaves[i];
	}
	

	public int getMetadata (int meta) {
		return meta;
	}
	
}