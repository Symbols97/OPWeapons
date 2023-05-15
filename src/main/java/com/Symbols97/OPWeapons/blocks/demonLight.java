package com.Symbols97.OPWeapons.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class demonLight extends Block {

	public demonLight(Material material) {
		super(material);
		this.setHardness(0.5F);
		this.setHarvestLevel("hand", 0);
		this.setStepSound(soundTypeGlass);
		this.setLightLevel(1.0F);
		
	}

	 public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	        return null;
	    }
	
}
