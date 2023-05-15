package com.Symbols97.OPWeapons.blocks;

import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class soulBlock extends Block {

	public soulBlock(Material material) {
		super(material);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 4);
		this.setStepSound(soundTypeStone);
		this.setLightLevel(0.7F);
}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return OPWeapons.miniSoul;

	}

	@Override
	public int quantityDropped (Random rand) {
		return 0 + rand.nextInt(2);
	}
	
	
}
