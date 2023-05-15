package com.Symbols97.OPWeapons.world;

import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFrostTree extends WorldGenAbstractTree {

	public WorldGenFrostTree() {
		super(false);
		
	}

	
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		while (world.isAirBlock(x, y, z) && y > 2){
			y--;
		}
		Block block = world.getBlock(x, y, z);
		
		if (block != OPWeapons.BlockofFrostGem) {
			return false;
		} else {
			for (int i = -2; i <= 2; i++) {
				for (int j = -2; j <= 2; j++) {
					if (world.isAirBlock(x + i, y - 1, z + j) && world.isAirBlock(x + i, y - 2, z + j) && !world.isAirBlock(x + i, y, z + j)) {
						return false;
					}
				}
			}
			
			int baseLength = 2 + random.nextInt(4);
			int branches = 1 + random.nextInt(2);
			
			int h = 1;
			
			block.onPlantGrow(world, x, y - 1, z, x, y, z);
			
			for (int i = 0; i < baseLength; i++) {
				buildBlock(world, x, y + h, z, OPWeapons.OPWLogBlocks, 1);
				h++;
			}
			
			int c = 1;
			for (int i = 0; i < branches; i++) {
				generateBranchBase(world, random, x, y + h, z, c);
				
				c++;
				h+=1;
			}
			for (int i = 0; i < branches; i++) {
				
				generateBranchMid(world, random, x, y + h, z, c);
				c++;
				h+=1;
			}
			
			generateTop(world, random, x, y + h, z);
			return true;
		}
		
		
	}
	
	public void generateTop(World world, Random random, int x, int y, int z) {
		
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				buildBlock(world, x + i, y, z + j, OPWeapons.OPWLeafBlocks, 1);
				
			}
		}
		
	
		
		
		buildBlock(world, x, y + 1, z, OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x + 1, y + 1, z, OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x, y + 1, z + 1, OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x - 1, y + 1, z, OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x, y + 1, z - 1, OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x + 2, y, z, OPWeapons.OPWLeafBlocks, 1);

	} 
	
	public void generateBranchMid(World world, Random random, int x, int y, int z, int p) {
		for (int i = -2; i < 3; i++) { // i = width
			for (int j = -2; j < 3; j++) { // j = length
				buildBlock(world, x + i, y , z + j, OPWeapons.OPWLeafBlocks, 1);
			}
		
		}
		
		buildBlock(world, x, y , z, OPWeapons.OPWLogBlocks, 1);
		buildBlock(world, x, y + 1 , z, OPWeapons.OPWLogBlocks, 1);
		
		buildBlock(world, x - 2, y, z - 2, Blocks.air, 0);
		buildBlock(world, x + 2, y, z + 2, Blocks.air, 0);
		buildBlock(world, x - 2, y, z + 1, Blocks.air, 0);
		buildBlock(world, x - 2, y, z + 2, Blocks.air, 0);
		
	}
	
	public void generateBranchBase(World world, Random random, int x, int y, int z, int p) {
		for (int i = -2; i < 4; i++) { // i = width
			for (int j = -2; j < 2; j++) { // j = length
				buildBlock(world, x + i, y, z + j, OPWeapons.OPWLeafBlocks, 1);
			}
		
		}
		
		buildBlock(world, x, y , z, OPWeapons.OPWLogBlocks, 1);
		buildBlock(world, x, y + 1 , z, OPWeapons.OPWLogBlocks, 1);
		
		
		buildBlock(world, x + 3, y, z + 1, Blocks.air, 0);
		buildBlock(world, x - 2, y, z - 2, Blocks.air, 0);
		buildBlock(world, x, y, z - 3, OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x - 3, y, z , OPWeapons.OPWLeafBlocks, 1);
		
		buildBlock(world, x, y, z + 2 , OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x + 1, y, z + 2 , OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x - 1, y, z + 2 , OPWeapons.OPWLeafBlocks, 1);
		buildBlock(world, x, y, z + 3 , OPWeapons.OPWLeafBlocks, 1);
	
	}
	public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
		if (world.isAirBlock(x, y, z) || world.getBlock(x, y, z).isLeaves(world, x, y, z)) {
			world.setBlock(x, y, z, block, meta, 2);
		}
	}

}
