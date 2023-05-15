package com.Symbols97.OPWeapons.blocks.trees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class OPWLogItemBlocks extends ItemBlock{

	
	
	public OPWLogItemBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= OPWLogs.LogTypes.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + OPWLogs.LogTypes[i];
	}
	

	public int getMetadata (int meta) {
		return meta;
	}
	
}
