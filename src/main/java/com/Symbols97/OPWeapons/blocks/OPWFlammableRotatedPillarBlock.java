package com.Symbols97.OPWeapons.blocks;

import javax.annotation.Nullable;

import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.common.ToolAction;

public class OPWFlammableRotatedPillarBlock extends RotatedPillarBlock {

	public OPWFlammableRotatedPillarBlock(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return true;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 5;
	}
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	Mirror mirror;
	@Nullable
	@Override
	public BlockState getToolModifiedState(BlockState state, UseOnContext context,
			ToolAction toolAction, boolean simulate) {
		if (context.getItemInHand().getItem() instanceof AxeItem) {

			if (state.is(OPWBlocks.demon_wood.get())) {
				return OPWBlocks.demon_statue.get().defaultBlockState();
			}
			if (state.is(OPWBlocks.demon_log.get())) {
				return OPWBlocks.stripped_demon_log.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
			}
			
			if (state.is(OPWBlocks.frost_log.get())) {
				return OPWBlocks.stripped_frost_log.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
			}
			
		}

		return super.getToolModifiedState(state, context, toolAction, simulate);
	}


	
}
