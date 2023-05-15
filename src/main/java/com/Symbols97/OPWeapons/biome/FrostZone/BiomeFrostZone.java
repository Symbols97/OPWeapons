package com.Symbols97.OPWeapons.biome.FrostZone;

import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.mobs.guardians.EntityFrostGuardian;
import com.Symbols97.OPWeapons.world.WorldGenOPWTrees;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeFrostZone extends BiomeGenBase{

	public BiomeFrostZone(int id){
		super(id);
		
		this.topBlock = OPWeapons.BlockofFrostGem;
		this.fillerBlock = OPWeapons.blockofopGem;
		//this.heightVariation = 55;
		
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityFrostGuardian.class,35,2,5));
		
		
		
		this.enableSnow = true;
		//this.waterColorMultiplier = 8194570;
		//this.setDisableRain();
		this.temperature = 0.1F;
		this.rainfall = 0.1F;
		this.setTemperatureRainfall(temperature, rainfall);
		
		
	}
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float temp)
	{
	return 10281968;
	}
	
	
	
	
}