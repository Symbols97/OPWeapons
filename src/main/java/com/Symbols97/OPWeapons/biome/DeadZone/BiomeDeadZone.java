package com.Symbols97.OPWeapons.biome.DeadZone;

import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.mobs.DeadWolf.EntityDeadWolf;
import com.Symbols97.OPWeapons.mobs.Demon.EntityDemon;
import com.Symbols97.OPWeapons.mobs.guardians.EntityDemonGuardian;
import com.Symbols97.OPWeapons.world.WorldGenDemonTree;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeDeadZone extends BiomeGenBase{
	public final WorldGenerator DemonTree = new WorldGenDemonTree();
	public BiomeDeadZone(int id){
		super(id);
		
		this.topBlock = OPWeapons.blockofdemongem;
		this.fillerBlock = OPWeapons.blockofopGem;
		//this.heightVariation = 55;
		
		
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		//this.spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 10, 5, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDeadWolf.class, 50, 2, 8));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDemon.class, 45, 2, 8));
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityEnderman.class, 5, 2, 10));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDemonGuardian.class,35,2,5));
		
		this.waterColorMultiplier = 8194570;
		this.setDisableRain();
		
	
		
	}
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float temp)
	{
	return 6489349;
			//8194570;
	}

	
	
	public void generateStructure(World world, Random random, int x, int z, int spawnChance, WorldGenerator structure) {
		
		
		for (int a = 0; a < spawnChance; a++) {
			int i = x + random.nextInt(256);
			int k = z + random.nextInt(256);
			int j = world.getHeightValue(i, k);
			structure.generate(world, random, i, j, k);
		}
	
}
	
	
}