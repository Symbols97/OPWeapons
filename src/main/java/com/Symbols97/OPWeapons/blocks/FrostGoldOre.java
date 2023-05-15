package com.Symbols97.OPWeapons.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FrostGoldOre extends Block {

	public FrostGoldOre(Material material) {
		super(material);
		this.setHardness(7.0F);
		this.setHarvestLevel("pickaxe", 4);
		this.setStepSound(soundTypeStone);
		this.setLightLevel(0.5F);
}
}
