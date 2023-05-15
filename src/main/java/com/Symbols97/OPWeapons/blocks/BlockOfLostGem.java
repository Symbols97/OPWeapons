package com.Symbols97.OPWeapons.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOfLostGem extends Block {
	
	public BlockOfLostGem(Material material) {
		super(material);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeMetal);
}
}