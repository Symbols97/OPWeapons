package com.Symbols97.OPWeapons.Dimension;

import com.Symbols97.OPWeapons.Dimension.DeadZone.WorldProviderDeadZone;
import com.Symbols97.OPWeapons.Dimension.FrostZone.WorldProviderFrostZone;

import net.minecraftforge.common.DimensionManager;

public class DimensionRegistry {
	
	public static void mainRegistry(){
		registerDimension();
	}
	
	public static final int DZdimensionId = 999999999;
	
	public static final int FZdimensionId = -999999999;
	
	public static void registerDimension(){
		DimensionManager.registerProviderType(DZdimensionId, WorldProviderDeadZone.class, false);
		DimensionManager.registerDimension(DZdimensionId, DZdimensionId);
		
		DimensionManager.registerProviderType(FZdimensionId, WorldProviderFrostZone.class, false);
		DimensionManager.registerDimension(FZdimensionId, FZdimensionId);
		
		
	}

}
