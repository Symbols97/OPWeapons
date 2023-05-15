package com.Symbols97.OPWeapons.mobs;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.mobs.DeadWolf.EntityDeadWolf;
import com.Symbols97.OPWeapons.mobs.Demon.EntityDemon;
import com.Symbols97.OPWeapons.mobs.Reaper.EntityReaper;
import com.Symbols97.OPWeapons.mobs.frostdragon.EntityFrostDragon;
import com.Symbols97.OPWeapons.mobs.guardians.EntityDemonGuardian;
import com.Symbols97.OPWeapons.mobs.guardians.EntityFrostGuardian;
import com.Symbols97.OPWeapons.mobs.guardians.EntityOPGuardian;
import com.Symbols97.OPWeapons.projectiles.EntityLapizArrow;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityOPWeapons {
	
	public static void mainRegistry() {
		registerEntity();
		
	}
	public static void registerEntity() {
		createEntity(EntityDeadWolf.class, "Dead Wolf", 0x514F4F, 0x8E0000);
		createEntity(EntityDemon.class, "Demon", 0x8E0000, 0xce1919);
		createEntity(EntityReaper.class, "Reaper", 0x000000, 0x6d6d6d);
		
		
		//createEntity(EntityFrostDragon.class, "Frost Dragon", 0x0578be, 0x00afff);
	
	    
		createEntity(EntityOPGuardian.class, "OP Guardian", 0x45ef56, 0x45ef56);
		createEntity(EntityDemonGuardian.class, "Demon Guardian", 0xf31c1c, 0xf31c1c);
		createEntity(EntityFrostGuardian.class, "Frost Guardian", 0x00b0ff, 0x00b0ff);
		
		EntityRegistry.registerModEntity(EntityLapizArrow.class, "LapizArrow", 0, OPWeapons.instance, 64, 20, false);
		
	}

	
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor){
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, OPWeapons.instance, 100, 1, true);
		
		EntityRegistry.addSpawn(EntityReaper.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntityReaper.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach);
		EntityRegistry.addSpawn(EntityReaper.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.birchForest);
		EntityRegistry.addSpawn(EntityReaper.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.birchForestHills);
		EntityRegistry.addSpawn(EntityReaper.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.extremeHills);
		EntityRegistry.addSpawn(EntityReaper.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityReaper.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.forestHills);
		EntityRegistry.addSpawn(EntityReaper.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.jungle);
		
		EntityRegistry.addSpawn(EntityDemon.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);

		EntityRegistry.addSpawn(EntityOPGuardian.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.plains);
		EntityRegistry.addSpawn(EntityOPGuardian.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.beach);
		EntityRegistry.addSpawn(EntityOPGuardian.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.birchForest);
		EntityRegistry.addSpawn(EntityOPGuardian.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.birchForestHills);
		EntityRegistry.addSpawn(EntityOPGuardian.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.extremeHills);
		EntityRegistry.addSpawn(EntityOPGuardian.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityOPGuardian.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.forestHills);
		EntityRegistry.addSpawn(EntityOPGuardian.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.jungle);
		
		
		
		createEgg(randomId, solidColor, spotColor);
	}
	
	
	private static void createEgg(int randomId, int solidColor, int spotColor){
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
		
	}

}