package com.Symbols97.OPWeapons;

import java.util.Random;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class OPUtils {
	
	public static Random rand = new Random();

	/**
	 * Given x,y,z coordinates of center block, checks all blocks in square with length (2 * radius) + 1.
	 * @param x x-coordinate
	 * @param y layer 0 y-coordinate
	 * @param z z-coordinate
	 * @param keyBlock block to search for
	 * @param radius distance outward to check, centering on (x,y,z)
	 * @param layers number of times to check a square area, then increment y (min 1)
	 * @return True if block is found, else false
	 */
	public static boolean isBlockNearby(World world, int x, int y, int z, Block keyBlock, int radius, int layers) 
	{
		Block curBlock;
		int rows = (radius * 2) + 1;
		int cols = rows;
		int xPos;
		int yPos;
		int zPos;
		if(radius < 1) radius = 1;
		if(layers < 1) layers = 1;

		for(int i = 0; i < layers; i++)	//check layers
		{
			for(int j = 0; j < cols; j++)	//check each column (Cartesian plane)
			{
				for(int k = 0; k < rows; k++)	//check each row
				{
					xPos = x + radius - k;
					yPos = y + i;
					zPos = z + radius - j;
					curBlock = world.getBlock(xPos,yPos,zPos);
					if(curBlock == keyBlock)
						return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks the six blocks this block is touching, looking for Block keyBlock
	 * Args: this blocks world,x,y,z and the block to check for
	 * @return true if keyBlock is found, else false
	 */
	public static boolean isTouchingBlock(World worldIn, int x, int y, int z, Block keyBlock)
	{
		return 	(worldIn.getBlock(x+1, y, z) == keyBlock) || (worldIn.getBlock(x-1, y, z) == keyBlock) || 
				(worldIn.getBlock(x, y+1, z) == keyBlock) || (worldIn.getBlock(x, y-1, z) == keyBlock) || 
				(worldIn.getBlock(x, y, z+1) == keyBlock) || (worldIn.getBlock(x, y, z-1) == keyBlock);
	}
	
	public static boolean isBlockTouchingAir(World world, int x, int y, int z)
	{
		return isTouchingBlock(world, x, y, z, Blocks.air);
	}
	
	public static boolean setBlockIfAir(World worldIn, int x, int y, int z, Block newBlock)
	{
		return worldIn.getBlock(x, y, z).getMaterial() == Material.air && worldIn.setBlock(x, y, z, newBlock);
	}

	/**
	 * Starts at y == 1 and checks each block above it until it detects air.
	 * @return y-value of the first air block it detects; if none, returns 0.
	 */
	public static int getFirstAirBlockFromBelow(World worldIn, int x, int z) 
	{
		int y = 1;
		
		while(!worldIn.isAirBlock(x, y, z) && y < 256)
		{
			++y;		
		}
		
		return y < 256 ? y : 0;
	}

	/*
	 * Model Utils
	 */

}