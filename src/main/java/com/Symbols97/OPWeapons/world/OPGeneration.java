package com.Symbols97.OPWeapons.world;

import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.Dimension.DimensionRegistry;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OPGeneration implements IWorldGenerator {


	
	WorldGenerator DemonTree = new WorldGenDemonTree();
	WorldGenerator FrostTree = new WorldGenFrostTree();
	WorldGenerator DemonLightSky = new WorldGenDemonLightSky();
	WorldGenerator FrostLightSky = new WorldGenFrostLightSky();
	WorldGenerator OasisStructureDZ = new OasisStructureDZ();
	WorldGenerator OasisStructureFZ = new OasisStructureFZ();
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,	IChunkProvider chunkProvider) {
	
		int FrostZone = DimensionRegistry.FZdimensionId; //(-999999999)
		int DeadZone = DimensionRegistry.DZdimensionId;
		
		switch (world.provider.dimensionId) {

		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
			
		case DimensionRegistry.DZdimensionId :
			generateDeadZone(world, random, chunkX, chunkZ);
			break;
		
		case DimensionRegistry.FZdimensionId :
			generateFrostZone(world, random, chunkX, chunkZ);
			break;
		}
		
		
		if (world.provider.dimensionId != FrostZone && world.provider.dimensionId != DeadZone && world.provider.dimensionId != -1 && world.provider.dimensionId != 1) {
			generateOverworld(world, random, chunkX, chunkZ);
		}
	}


	public void generateOverworld(World world, Random rand, int x, int z) {
		generateOre(OPWeapons.opgemOre, world, rand, x,z, 5,15, 5, 1,50, Blocks.stone);
		generateOre(OPWeapons.steelScrapOre, world, rand, x,z, 3,5, 15, 30,60, Blocks.stone);
		
	}

	public void generateNether(World world, Random rand, int x, int z) {
		generateOre(OPWeapons.opgemOre, world, rand, x,z,1,15, 60, 1,110, Blocks.netherrack);
	}
	public void generateDeadZone(World world, Random rand, int x, int z) {
		generateOre(OPWeapons.soulBlock, world, rand, x,z,1,4, 25, 1,10, Blocks.stone);
		generateOre(OPWeapons.opgemOre, world, rand, x,z,1,15, 70, 1,110, Blocks.stone);
		generateOre(OPWeapons.demonGoldOre, world, rand, x,z,1,4, 30, 1,10, Blocks.stone);
		generateStructure(world, rand, x * 16, z * 16, 1, 32, DemonTree);
		
		generateStructure(world, rand, x * 16, z * 16, 5, 32, DemonLightSky);
		generateStructure(world, rand, x * 16, z * 16 , 1, 16, OasisStructureDZ);
		
	}
	public void generateFrostZone(World world, Random rand, int x, int z) {
		generateOre(OPWeapons.frostGoldOre, world, rand, x,z,1,4, 30, 1,10, Blocks.stone);
		generateOre(OPWeapons.opgemOre, world, rand, x,z,1,15, 70, 1,110, Blocks.stone);
		generateOre(OPWeapons.frozensoulBlock, world, rand, x,z,1,4, 25, 1,10, Blocks.stone);
		generateStructure(world, rand, x * 16, z * 16, 5, 32, FrostLightSky);
		generateStructure(world, rand, x*16, z*16, 5, 16, FrostTree);
		generateStructure(world, rand, x * 16, z * 16 , 1, 16, OasisStructureFZ);
		
	}
	
	public void generateStructure(World world, Random random, int x, int z, int spawnChance, int spacing, WorldGenerator structure) {
	
			for (int a = 0; a < spawnChance; a++) {
				int chunkX = x + random.nextInt(spacing);
				int chunkZ = z + random.nextInt(spacing);
				int chunkY = world.getHeightValue(chunkX, chunkZ);
				structure.generate(world, random, chunkX, chunkY, chunkZ);
			}
		
		
	}
	

	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generationIn) {

		int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
		int heightrange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, vienSize, generationIn);
		for (int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightrange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
}
