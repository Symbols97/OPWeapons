package com.Symbols97.OPWeapons.biome.DeadZone;

import com.Symbols97.OPWeapons.biome.OPGenLayerBiome;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeDeadZone extends WorldType{
	
	public WorldTypeDeadZone(int par1, String name){
		super(name);
	}
	
	
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer)
    {
        GenLayer ret = new OPGenLayerBiome(200L, parentLayer, this);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }

}
