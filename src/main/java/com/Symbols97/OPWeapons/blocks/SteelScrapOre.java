package com.Symbols97.OPWeapons.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SteelScrapOre extends Block {

	public SteelScrapOre(Material material) {
		super(material);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeStone);
		
}

}
