package com.Symbols97.OPWeapons.world.biome;

import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class OPWSurfaceRule {
	
	
	    private static final SurfaceRules.RuleSource DZ_TOP_BLOCK = makeStateRule(OPWBlocks.block_of_demon_gem.get()); 
	    private static final SurfaceRules.RuleSource DZ_SECOND_LAYER = makeStateRule(OPWBlocks.block_of_op_gem.get());
	    
	    private static final SurfaceRules.RuleSource FZ_TOP_BLOCK = makeStateRule(OPWBlocks.block_of_frost_gem.get()); 
	    private static final SurfaceRules.RuleSource FZ_SECOND_LAYER = makeStateRule(OPWBlocks.block_of_op_gem.get());

	    public static SurfaceRules.RuleSource makeRules()
	    {
	        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
	        SurfaceRules.RuleSource dz_surface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, DZ_TOP_BLOCK), DZ_SECOND_LAYER);
	        SurfaceRules.RuleSource fz_surface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, FZ_TOP_BLOCK), FZ_SECOND_LAYER);

	        return SurfaceRules.sequence(

	        		SurfaceRules.ifTrue(SurfaceRules.isBiome(OPWBiomes.DEAD_ZONE), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, dz_surface)),
	        		SurfaceRules.ifTrue(SurfaceRules.isBiome(OPWBiomes.FROST_ZONE), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, fz_surface))
	        		
	        );
	    }

	    private static SurfaceRules.RuleSource makeStateRule(Block block)
	    {
	        return SurfaceRules.state(block.defaultBlockState());
	    }
}
