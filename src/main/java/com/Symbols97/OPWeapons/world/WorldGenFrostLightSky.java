package com.Symbols97.OPWeapons.world;

import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFrostLightSky extends WorldGenerator {

	public WorldGenFrostLightSky() {
		super(false);
		
	}

	
	public boolean generate(World world, Random random, int x, int y, int z) {
		
		while (world.isAirBlock(x, y, z) && y > 2){
			y--;
		}
		Block block = world.getBlock(x, y, z);
	
			for (int i = -2; i <= 2; i++) {
				for (int j = -2; j <= 2; j++) {
					if (world.isAirBlock(x + i, y - 1, z + j) && world.isAirBlock(x + i, y - 2, z + j) && !world.isAirBlock(x + i, y, z + j)) {
						return false;
					}
				}
			}
			
			
			generateSkyLights(world, random, x, y , z);
			return true;
		
		
		
	}
	
	
	
	public void generateSkyLights(World world, Random random, int x, int y, int z) {
		
		buildBlock(world, x, y + 35, z + 3 , OPWeapons.frostLight, 0);
	
	}
	public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
		if (world.isAirBlock(x, y, z) || world.getBlock(x, y, z).isLeaves(world, x, y, z)) {
			world.setBlock(x, y, z, block, meta, 2);
		}
	}

}