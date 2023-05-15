package com.Symbols97.OPWeapons.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class condensedbodg extends Block {

	public condensedbodg(Material material) {

			super(material);
			this.setHardness(5.0F);
			this.setHarvestLevel("pickaxe", 3);
			this.setStepSound(soundTypeMetal);
	}
	

	    public void addInformation(ItemStack itemstack, EntityPlayer player, List textList, boolean par4)
	    {
	    	textList.add("Here goes your Information you want to add");
	    }
	}
	

