package com.Symbols97.OPWeapons.blocks.trees;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class OPW_WoodItemBlocks extends ItemBlock{

	
	
	public OPW_WoodItemBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= OPW_Wood.WoodTypes.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + OPW_Wood.WoodTypes[i];
	}
	

	public int getMetadata (int meta) {
		return meta;
	}
	
}
