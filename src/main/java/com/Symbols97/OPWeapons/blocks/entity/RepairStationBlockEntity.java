package com.Symbols97.OPWeapons.blocks.entity;

import java.util.Optional;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.init.BlockEntities;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.recipe.repairstation.RepairStationRecipe;
import com.Symbols97.OPWeapons.recipe.repairstation.RepairStationTier4Recipe;
import com.Symbols97.OPWeapons.screen.repairstation.RepairStationMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class RepairStationBlockEntity extends BlockEntity implements MenuProvider {

	private static boolean changed = false;
	
	public RepairStationBlockEntity getBlockEntity() {
		return this;
	}

	private Mode mode;

	public Mode getMode() {
		return mode;
	}

	public static enum Mode {
		MODULE, STAR;

		public Mode next() {
			int nextOrd = ordinal() + 1;
			if (nextOrd >= values().length) {
				nextOrd = 0;
			}
			changed = true;
			return values()[nextOrd];
		}
		
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
		@Override
		protected void onContentsChanged(int slot) {
			setChanged();
		}
	};

	private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

	public RepairStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(BlockEntities.repair_station_block_entity.get(), pWorldPosition, pBlockState);
		if (mode != Mode.MODULE || mode != Mode.STAR) {
			mode = Mode.MODULE;
		}
	}

	@Override
	public Component getDisplayName() {
		return new TextComponent("§0Repair Station");
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
		return new RepairStationMenu(pContainerId, pInventory, this);
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return lazyItemHandler.cast();
		}

		return super.getCapability(cap, side);
	}

	@Override
	public void onLoad() {
		super.onLoad();
		lazyItemHandler = LazyOptional.of(() -> itemHandler);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		lazyItemHandler.invalidate();
	}

	@Override
	protected void saveAdditional(@NotNull CompoundTag tag) {
		tag.put("inventory", itemHandler.serializeNBT());
		tag.putInt("RepariStationV1Mode", this.mode.ordinal());	
		super.saveAdditional(tag);
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		itemHandler.deserializeNBT(nbt.getCompound("inventory"));
		nbt.putInt("RepariStationV1Mode", this.mode.ordinal());	
	}

	public void drops() {
		SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			inventory.setItem(i, itemHandler.getStackInSlot(i));
		}

		Containers.dropContents(this.level, this.worldPosition, inventory);
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, RepairStationBlockEntity pBlockEntity) {

		if (!pBlockEntity.level.isClientSide()) {
			if (hasRecipe(pBlockEntity)) {

				setChanged(pLevel, pPos, pState);

				craftItem(pBlockEntity);
			}
		}
		if (RepairStationBlockEntity.changed) {
			setChanged(pLevel, pPos, pState);
			changed = false;
			OPWeapons.LOGGER.info("working1");
		}
	}

	public static boolean hasRecipe(RepairStationBlockEntity entity) {
		Level level = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}

		if (entity.mode == Mode.MODULE) {
			Optional<RepairStationRecipe> match = level.getRecipeManager()
					.getRecipeFor(RepairStationRecipe.Type.INSTANCE, inventory, level);

			return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
					&& canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())
					&& hasToolsInToolSlot(entity);

		} else if (entity.mode == Mode.STAR) {
			Optional<RepairStationTier4Recipe> match = level.getRecipeManager()
					.getRecipeFor(RepairStationTier4Recipe.Type.INSTANCE, inventory, level);

			return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
					&& canInsertItemIntoOutputSlot(inventory, match.get().getResultItem())
					&& hasToolsInToolSlot(entity);
		}

		return false;

	}

	public static boolean hasToolsInToolSlot(RepairStationBlockEntity entity) {

		if (entity.mode == Mode.MODULE) {
			return entity.itemHandler.getStackInSlot(0).getItem() == OPWItems.repair_module.get();
		} else if (entity.mode == Mode.STAR) {
			return entity.itemHandler.getStackInSlot(0).getItem() == OPWItems.ultimate_nether_star.get();
		}

		return false;
	}

	public static void craftItem(RepairStationBlockEntity entity) {
		Level level = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}

		if (entity.mode == Mode.MODULE) {
			Optional<RepairStationRecipe> match = level.getRecipeManager()
					.getRecipeFor(RepairStationRecipe.Type.INSTANCE, inventory, level);

			if (match.isPresent()) {
				entity.itemHandler.getStackInSlot(0).hurt(1, new Random(), null);
				entity.itemHandler.extractItem(1, 1, false);
				entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
						entity.itemHandler.getStackInSlot(2).getCount() + 1));

			}

		} else if (entity.mode == Mode.STAR) {
			Optional<RepairStationTier4Recipe> match = level.getRecipeManager()
					.getRecipeFor(RepairStationTier4Recipe.Type.INSTANCE, inventory, level);

			if (match.isPresent()) {
				entity.itemHandler.extractItem(0, 1, false);
				entity.itemHandler.extractItem(1, 1, false);
				entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
						entity.itemHandler.getStackInSlot(2).getCount() + 1));

			}
		}

	}

	private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
		return inventory.getItem(2).getItem() == output.getItem() || inventory.getItem(2).isEmpty();
	}

	private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
		return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
	}


}