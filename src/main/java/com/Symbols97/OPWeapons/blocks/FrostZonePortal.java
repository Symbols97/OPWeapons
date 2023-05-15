package com.Symbols97.OPWeapons.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.world.dimension.OPWDimensions;
import com.Symbols97.OPWeapons.world.dimension.portal.FZTeleporter;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class FrostZonePortal extends Block {
	public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
	protected static final VoxelShape X_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape Z_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

	public FrostZonePortal() {
		super(Properties.of(Material.PORTAL).strength(-1F).noCollission().lightLevel((state) -> 10).noDrops());
		registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch (state.getValue(AXIS)) {
		case Z:
			return Z_AABB;
		case X:
		default:
			return X_AABB;
		}
	}

	public boolean trySpawnPortal(LevelAccessor worldIn, BlockPos pos) {
		FrostZonePortal.Size FrostZonePortal$size = this.isPortal(worldIn, pos);
		if (FrostZonePortal$size != null && !onTrySpawnPortal(worldIn, pos, FrostZonePortal$size)) {
			FrostZonePortal$size.placePortalBlocks();
			return true;
		} else {
			return false;
		}
	}
	//**CHANGE PORTAL
	public static boolean onTrySpawnPortal(LevelAccessor world, BlockPos pos, FrostZonePortal.Size size) {
		return MinecraftForge.EVENT_BUS.post(new PortalSpawnEvent(world, pos, world.getBlockState(pos), size));
	}
	//**CHANGE PORTAL
	@Cancelable
	public static class PortalSpawnEvent extends BlockEvent {
		private final FrostZonePortal.Size size;

		public PortalSpawnEvent(LevelAccessor world, BlockPos pos, BlockState state, FrostZonePortal.Size size) {
			super(world, pos, state);
			this.size = size;
		}

		public FrostZonePortal.Size getPortalSize() {
			return size;
		}
	}
	//**CHANGE PORTAL
	@Nullable
	public FrostZonePortal.Size isPortal(LevelAccessor worldIn, BlockPos pos) {
		FrostZonePortal.Size FrostZonePortal$size = new Size(worldIn, pos, Direction.Axis.X);
		if (FrostZonePortal$size.isValid() && FrostZonePortal$size.portalBlockCount == 0) {
			return FrostZonePortal$size;
		} else {
			FrostZonePortal.Size FrostZonePortal$size1 = new Size(worldIn, pos, Direction.Axis.Z);
			return FrostZonePortal$size1.isValid() && FrostZonePortal$size1.portalBlockCount == 0
					? FrostZonePortal$size1
					: null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		Direction.Axis direction$axis = facing.getAxis();
		Direction.Axis direction$axis1 = stateIn.getValue(AXIS);
		boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
		return !flag && facingState.getBlock() != this
				&& !(new Size(worldIn, currentPos, direction$axis1)).validatePortal() ? Blocks.AIR.defaultBlockState()
						: super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entity) {
		if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions()) {
			if (entity.isOnPortalCooldown()) {
				entity.setPortalCooldown();
			} else {
				if (!entity.level.isClientSide && !pos.equals(entity.portalEntrancePos)) {
					entity.portalEntrancePos = pos.immutable();
				}
				Level entityWorld = entity.level;
				if (entityWorld != null) {
					MinecraftServer minecraftserver = entityWorld.getServer();
					//**CHANGE DIMENSION KEY
					ResourceKey<Level> destination = entity.level.dimension() == OPWDimensions.FZ_KEY ? Level.OVERWORLD
							: OPWDimensions.FZ_KEY;
					if (minecraftserver != null) {
						ServerLevel destinationWorld = minecraftserver.getLevel(destination);
						if (destinationWorld != null && minecraftserver.isNetherEnabled() && !entity.isPassenger()) {
							entity.level.getProfiler().push("fz_portal");
							entity.setPortalCooldown();
							//**CHANGE TELEPORTER
							entity.changeDimension(destinationWorld, new FZTeleporter(destinationWorld));
							entity.level.getProfiler().pop();
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("unused")
	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(100) == 0) {
			worldIn.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D,
					SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
		}

		for (int i = 0; i < 4; ++i) {
			double x = (double) pos.getX() + rand.nextDouble();
			double y = (double) pos.getY() + rand.nextDouble();
			double z = (double) pos.getZ() + rand.nextDouble();
			double xSpeed = ((double) rand.nextFloat() - 0.5D) * 0.5D;
			double ySpeed = ((double) rand.nextFloat() - 0.5D) * 0.5D;
			double zSpeed = ((double) rand.nextFloat() - 0.5D) * 0.5D;
			int j = rand.nextInt(2) * 2 - 1;
			if (!worldIn.getBlockState(pos.west()).is(this) && !worldIn.getBlockState(pos.east()).is(this)) {
				x = (double) pos.getX() + 0.5D + 0.25D * (double) j;
				xSpeed = rand.nextFloat() * 2.0F * (float) j;
			} else {
				z = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
				zSpeed = rand.nextFloat() * 2.0F * (float) j;
			}

			// TODO: Particles
			// worldIn.addParticle(PARTICLE_TYPE, x, y, z, xSpeed, ySpeed, zSpeed);
		}
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
		return ItemStack.EMPTY;
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		switch (rot) {
		case COUNTERCLOCKWISE_90:
		case CLOCKWISE_90:
			switch (state.getValue(AXIS)) {
			case Z:
				return state.setValue(AXIS, Direction.Axis.X);
			case X:
				return state.setValue(AXIS, Direction.Axis.Z);
			default:
				return state;
			}
		default:
			return state;
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AXIS);
	}

	public static class Size {
		private final LevelAccessor level;
		private final Direction.Axis axis;
		private final Direction rightDir;
		private final Direction leftDir;
		private int portalBlockCount;
		@Nullable
		private BlockPos bottomLeft;
		private int height;
		private int width;

		public Size(LevelAccessor level, BlockPos pos, Direction.Axis axis) {
			this.level = level;
			this.axis = axis;
			if (axis == Direction.Axis.X) {
				this.leftDir = Direction.EAST;
				this.rightDir = Direction.WEST;
			} else {
				this.leftDir = Direction.NORTH;
				this.rightDir = Direction.SOUTH;
			}

			for (BlockPos blockpos = pos; pos.getY() > blockpos.getY() - 21 && pos.getY() > 0
					&& this.canConnect(level.getBlockState(pos.below())); pos = pos.below()) {
			}

			int i = this.getDistanceUntilEdge(pos, this.leftDir) - 1;
			if (i >= 0) {
				this.bottomLeft = pos.relative(this.leftDir, i);
				this.width = this.getDistanceUntilEdge(this.bottomLeft, this.rightDir);
				if (this.width < 2 || this.width > 21) {
					this.bottomLeft = null;
					this.width = 0;
				}
			}

			if (this.bottomLeft != null) {
				this.height = this.calculatePortalHeight();
			}

		}

		protected int getDistanceUntilEdge(BlockPos pos, Direction directionIn) {
			int i;
			for (i = 0; i < 22; ++i) {
				BlockPos blockpos = pos.relative(directionIn, i);
				if (!this.canConnect(this.level.getBlockState(blockpos))
						//**CHANGE BLOCK
						|| !(this.level.getBlockState(blockpos.below()).is(OPWBlocks.condensedbofg.get()))) {
					break;
				}
			}

			BlockPos framePos = pos.relative(directionIn, i);
			//**CHANGE BLOCK
			return this.level.getBlockState(framePos).is(OPWBlocks.condensedbofg.get()) ? i : 0;
		}

		public int getHeight() {
			return this.height;
		}

		public int getWidth() {
			return this.width;
		}

		protected int calculatePortalHeight() {
			label56: for (this.height = 0; this.height < 21; ++this.height) {
				for (int i = 0; i < this.width; ++i) {
					BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
					BlockState blockstate = this.level.getBlockState(blockpos);
					if (!this.canConnect(blockstate)) {
						break label56;
					}

					Block block = blockstate.getBlock();
					//**CHANGE PORTAL BLOCK
					if (block == OPWBlocks.frost_zone_portal_block.get()) {
						++this.portalBlockCount;
					}

					if (i == 0) {
						BlockPos framePos = blockpos.relative(this.leftDir);
						//**CHANGE BLOCK
						if (!(this.level.getBlockState(framePos).is(OPWBlocks.condensedbofg.get()))) {
							break label56;
						}
					} else if (i == this.width - 1) {
						BlockPos framePos = blockpos.relative(this.rightDir);
						//**CHANGE BLOCK
						if (!(this.level.getBlockState(framePos).is(OPWBlocks.condensedbofg.get()))) {
							break label56;
						}
					}
				}
			}

			for (int j = 0; j < this.width; ++j) {
				BlockPos framePos = this.bottomLeft.relative(this.rightDir, j).above(this.height);
				//**CHANGE BLOCK
				if (!(this.level.getBlockState(framePos).is(OPWBlocks.condensedbofg.get()))) {
					this.height = 0;
					break;
				}
			}

			if (this.height <= 21 && this.height >= 3) {
				return this.height;
			} else {
				this.bottomLeft = null;
				this.width = 0;
				this.height = 0;
				return 0;
			}
		}

		protected boolean canConnect(BlockState pos) {
			Block block = pos.getBlock();
			//**CHANGE PORTAL BLOCK
			return pos.isAir() || block == OPWBlocks.frost_zone_portal_block.get();
		}

		public boolean isValid() {
			return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3
					&& this.height <= 21;
		}

		public void placePortalBlocks() {
			for (int i = 0; i < this.width; ++i) {
				BlockPos blockpos = this.bottomLeft.relative(this.rightDir, i);

				for (int j = 0; j < this.height; ++j) {
					//**CHANGE PORTAL BLOCK
					this.level.setBlock(blockpos.above(j), OPWBlocks.frost_zone_portal_block.get().defaultBlockState()
							.setValue(FrostZonePortal.AXIS, this.axis), 18);
				}
			}

		}

		private boolean isPortalCountValidForSize() {
			return this.portalBlockCount >= this.width * this.height;
		}

		public boolean validatePortal() {
			return this.isValid() && this.isPortalCountValidForSize();
		}
	}
}
