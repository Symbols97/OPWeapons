package com.Symbols97.OPWeapons.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class OPWStairs extends BlockStairs { 
	
	public OPWStairs(int par1, Block par2Block, int par3) {
		super(par2Block, par3);
		this.setHardness(2.0F);
		this.setLightOpacity(0);
	} 
	
	public boolean isOpaqueCube(){ 
		return false; 
		}

}