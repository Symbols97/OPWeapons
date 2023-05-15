package com.Symbols97.OPWeapons.blocks;

import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class blockofdemongem extends Block {

	public blockofdemongem(Material material) {
		super(material);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeMetal);
		
	}

}