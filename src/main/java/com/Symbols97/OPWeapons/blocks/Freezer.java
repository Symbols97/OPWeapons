package com.Symbols97.OPWeapons.blocks;

import javax.annotation.Nullable;

import com.Symbols97.OPWeapons.blocks.entity.FreezerBlockEntity;
import com.Symbols97.OPWeapons.blocks.init.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

public class Freezer extends BaseEntityBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;

	public Freezer(BlockBehaviour.Properties p_53627_) {
		super(p_53627_);
		this.registerDefaultState(
				this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, Boolean.valueOf(false)));
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new FreezerBlockEntity(pPos, pState);
	}

	private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 22.4, 16);

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPE;
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, LIT);
	}

	 
	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {

		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
		// TODO Auto-generated method stub
		return state.getValue(LIT) ? 0 : 0;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext p_49820_) {
		// TODO Auto-generated method stub
		return this.defaultBlockState().setValue(FACING, p_49820_.getHorizontalDirection().getOpposite());
	}

	@Override
	public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
		// TODO Auto-generated method stub
		super.setPlacedBy(level, pos, state, entity, stack);
		if (stack.hasCustomHoverName()) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if (blockentity instanceof FreezerBlockEntity) {
				((FreezerBlockEntity) blockentity).setCustomName(stack.getHoverName());
			}
		}

	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState p_60457_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
		return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
	}

//	@Override
//	@OnlyIn(Dist.CLIENT)
//	public void animateTick(BlockState p_53635_, Level p_53636_, BlockPos p_53637_, Random p_53638_) {
//		if (p_53635_.getValue(LIT)) {
//		
//			double d0 = (double) p_53637_.getX() + 0.5D;
//			double d1 = (double) p_53637_.getY();
//			double d2 = (double) p_53637_.getZ() + 0.5D;
//			if (p_53638_.nextDouble() < 0.1D) {
//				p_53636_.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F,
//						false);
//			}
//
//			Direction direction = p_53635_.getValue(FACING);
//			Direction.Axis direction$axis = direction.getAxis();
//			//double d3 = 0.52D;
//			double d4 = p_53638_.nextDouble() * 0.6D - 0.3D;
//			double d5 = direction$axis == Direction.Axis.X ? (double) direction.getStepX() * 0.52D : d4;
//			double d6 = p_53638_.nextDouble() * 6.0D / 16.0D;
//			double d7 = direction$axis == Direction.Axis.Z ? (double) direction.getStepZ() * 0.52D : d4;
//			p_53636_.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
//			p_53636_.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
//		}
//	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		if (level != null && !level.isClientSide) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if (blockentity instanceof FreezerBlockEntity) {
				NetworkHooks.openScreen(((ServerPlayer) player), (FreezerBlockEntity) blockentity, pos);
			}
		}
		return InteractionResult.sidedSuccess(level.isClientSide());
	}

	@Override
	public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean p_48717_) {
		if (!state.is(newState.getBlock())) {
			BlockEntity blockentity = level.getBlockEntity(pos);
			if (blockentity instanceof FreezerBlockEntity) {
				if (level instanceof ServerLevel) {
					((FreezerBlockEntity) blockentity).drops();
				}

				level.updateNeighbourForOutputSignal(pos, this);
			}
		}

		if (state.hasBlockEntity() && state.getBlock() != newState.getBlock()) {
			level.removeBlockEntity(pos);
		}
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
			BlockEntityType<T> pBlockEntityType) {
		return createTickerHelper(pBlockEntityType, BlockEntities.freezer_block_entity.get(), FreezerBlockEntity::tick);
	}

}