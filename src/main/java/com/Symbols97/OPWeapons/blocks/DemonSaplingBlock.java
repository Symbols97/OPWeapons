package com.Symbols97.OPWeapons.blocks;

import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class DemonSaplingBlock extends SaplingBlock{

	public DemonSaplingBlock(AbstractTreeGrower p_55978_, Properties p_55979_) {
		super(p_55978_, p_55979_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
		// TODO Auto-generated method stub
		return p_51042_.is(OPWBlocks.block_of_demon_gem.get());
	}
	
	@Override
	public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
		BlockPos blockpos = p_51030_.below();
		
		return this.mayPlaceOn(p_51029_.getBlockState(blockpos), p_51029_, blockpos);
	}
	
}
