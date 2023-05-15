package com.Symbols97.OPWeapons.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public class blockoenchanting extends Block {

	public blockoenchanting(Material material) {

		super(material);
		this.setHardness(10.0F);
		this.setHarvestLevel("pickaxe", 100);
		this.setStepSound(soundTypeMetal);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return null;

	}

	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune) {
		// THE RETURN VALUE IS HOW MANY XP ORBS IT WILL DROP WHEN THE BLOCK IS BROKEN.
		return 100000;
	}
}
//}
//private Random rand = new Random();
//@Override
//public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_)
//{
//    if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
//    {
//        int j1 = 0;
//                        //This is your mod and then the block
//        if (this == charcoalblockmod.Anthracite_Ore)
//        {             
//                //the 0 is minimum xp and the 2 is the max xp orbs it can drop 
//            j1 = MathHelper.getRandomIntegerInRange(rand, 0, 2);
//        }
//        
//
//        return j1;
//    }
//    return 0;
//}