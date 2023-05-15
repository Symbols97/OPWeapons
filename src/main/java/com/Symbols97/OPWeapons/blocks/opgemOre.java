package com.Symbols97.OPWeapons.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class opgemOre extends Block {

	public opgemOre(Material material) {
		super(material);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeStone);
		this.setLightLevel(0.5F);
}
}
