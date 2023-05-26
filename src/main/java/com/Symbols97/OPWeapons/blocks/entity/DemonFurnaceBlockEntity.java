package com.Symbols97.OPWeapons.blocks.entity;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.Symbols97.OPWeapons.blocks.DemonFurnace;
import com.Symbols97.OPWeapons.blocks.init.BlockEntities;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.recipe.demonfurnace.DemonFurnaceRecipe;
import com.Symbols97.OPWeapons.screen.demonfurnace.DemonFurnaceMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class DemonFurnaceBlockEntity extends BlockEntity implements MenuProvider {
	protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
	private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
		@Override
		protected void onContentsChanged(int slot) {
			setChanged();
		}
		
		@Override
		public boolean isItemValid(int i, ItemStack itemstack) {

			if (i == 1) {
				return isFuel(itemstack);//itemstack.is(OPWTags.Items.IS_OPFURNACEFUEL);
			} else if (i == 0) {
				return !isFuel(itemstack);//itemstack.is(OPWTags.Items.IS_OPFURNACEFUEL);

			} else if (i == 2) {
				return false;
			} else {
				return super.isItemValid(i, itemstack);
			}

		}
	};

	private IItemHandler hopperHandler = new IItemHandler() {
		
		 @Override
	        public int getSlots() {
	            return itemHandler.getSlots();
	        }

	        @NotNull
	        @Override
	        public ItemStack getStackInSlot(int slot) {
	            return itemHandler.getStackInSlot(slot);
	        }

	        @NotNull
	        @Override
	        public ItemStack extractItem(int slot, int amount, boolean simulate) {

	            if((slot == 2)){
	                return itemHandler.extractItem(slot, amount, simulate);
	            }
	            return ItemStack.EMPTY;
	        }
	        
	        @NotNull
	        @Override
	        public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
	            if(stack.isEmpty()){
	                return stack;
	            }

	            if(slot != 0 && isItemValid(slot, stack)){
	                return itemHandler.insertItem(slot, stack, simulate);
	            }
	            if(slot == 0 && !isFuel(stack)){
	                return itemHandler.insertItem(slot, stack, simulate);
	            }
	            return stack;
	        }

	        @Override
	        public int getSlotLimit(int slot) {
	            return itemHandler.getSlotLimit(slot);
	        }

	        @Override
	        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
	            return itemHandler.isItemValid(slot, stack);
	        }
	    };

	    private LazyOptional<IItemHandler> lazyItemHandlerOptional = LazyOptional.of(() -> itemHandler);
	    private LazyOptional<IItemHandler> hopperHandlerOptional = LazyOptional.of(() -> hopperHandler);
		

	protected final ContainerData data;
	public int litTime; // how long the furnace has been lit for
	public int litDuration; // how long the furnace will stay lit
	public int cookingProgress; // how long the item has been burning for
	public int cookingTotalTime = 3; // furnace speed

	public DemonFurnaceBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(BlockEntities.demon_furnace_block_entity.get(), pWorldPosition, pBlockState);
		this.data = new ContainerData() {
			public int get(int index) {
				switch (index) {
				case 0:
					return DemonFurnaceBlockEntity.this.litTime;
				case 1:
					return DemonFurnaceBlockEntity.this.litDuration;
				case 2:
					return DemonFurnaceBlockEntity.this.cookingProgress;
				case 3:
					return DemonFurnaceBlockEntity.this.cookingTotalTime;
				default:
					return 0;
				}
			}

			public void set(int index, int value) {
				switch (index) {
				case 0:
					DemonFurnaceBlockEntity.this.litTime = value;
					break;
				case 1:
					DemonFurnaceBlockEntity.this.litDuration = value;
					break;
				case 2:
					DemonFurnaceBlockEntity.this.cookingProgress = value;
					break;
				case 3:
					DemonFurnaceBlockEntity.this.cookingTotalTime = value;
					break;
				}
			}

			public int getCount() {
				return 4;
			}
		};
	}

	@Override
	public Component getDisplayName() {
		return new TextComponent("§fDemon Furnace");
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
		return new DemonFurnaceMenu(pContainerId, pInventory, this, this.data);
	}

	public boolean isLit() {
		return this.litTime > 0;
	}

	@Override
	protected void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		nbt.putInt("BurnTime", this.litTime);
		nbt.putInt("CookTime", this.cookingProgress);
		nbt.putInt("CookTimeTotal", this.cookingTotalTime);
		nbt.putInt("litDuration", this.litDuration);
		nbt.put("inventory", itemHandler.serializeNBT());
		CompoundTag compoundtag = new CompoundTag();
		nbt.put("RecipesUsed", compoundtag);
	}
	
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		itemHandler.deserializeNBT(nbt.getCompound("inventory"));
		this.litTime = nbt.getInt("BurnTime");
		this.cookingProgress = nbt.getInt("CookTime");
		this.cookingTotalTime = nbt.getInt("CookTimeTotal");
		this.litDuration = nbt.getInt("litDuration");

	}

	public void drops() {
		SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			inventory.setItem(i, itemHandler.getStackInSlot(i));
		}

		Containers.dropContents(this.level, this.worldPosition, inventory);
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, DemonFurnaceBlockEntity blockentity) {
		ItemStack itemstack = blockentity.itemHandler.getStackInSlot(1);
		boolean flag = blockentity.isLit();
		boolean flag1 = false;
		if (blockentity.isLit()) {
			blockentity.litTime--;
		}

		if (!pLevel.isClientSide) {
			if (blockentity.litTime == 0 && canSmelt(blockentity)) {
				blockentity.litDuration = blockentity.litTime = fuelBurnDuration(itemstack);

				if (blockentity.isLit()) {
					flag1 = true;
					if (itemstack.hasContainerItem())
						blockentity.items.set(1, itemstack.getContainerItem());
					else if (!itemstack.isEmpty()) {
						// Item item = itemstack.getItem();
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							blockentity.items.set(1, itemstack.getContainerItem());
						}
					}

				}

			}
			if (blockentity.isLit() && canSmelt(blockentity)) {
				blockentity.cookingProgress++;
				if (blockentity.cookingProgress == blockentity.cookingTotalTime) {
					blockentity.cookingProgress = 0;
					smeltItem(blockentity);
					flag1 = true;
				}
			} else {
				blockentity.cookingProgress = 0;
			}

			if (flag != blockentity.isLit()) {
				flag1 = true;
				pState = pState.setValue(DemonFurnace.LIT, Boolean.valueOf(blockentity.isLit()));
				pLevel.setBlock(pPos, pState, 3);

			}

		}
		if (flag1) {
			setChanged(pLevel, pPos, pState);
		}
	}

	private static boolean isFuel(ItemStack itemstack) {
		return fuelBurnDuration(itemstack) > 0;
	}

	public static int fuelBurnDuration(ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		} else {
			Item item = itemstack.getItem();

			if (item == Items.COPPER_INGOT) {
				return 1667;
			}
			
			if (item == Items.COPPER_BLOCK) {
				return 15000;
			}
			
			if (item == Items.IRON_INGOT) {
				return 3333;
			}
			if (item == Items.LAVA_BUCKET) {
				return 20000;
			}
			if (item == Items.IRON_BLOCK) {
				return 30000;
			}
			if (item == OPWItems.ultimate_nether_star.get()) {
				return 10000000;
			}
			if (item == OPWItems.demon_vial.get()) {
				return 20000000;
			}

		}
		return 0;
	}

	private static boolean canSmelt(DemonFurnaceBlockEntity entity) {
		Level level = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}

		Optional<DemonFurnaceRecipe> match = level.getRecipeManager().getRecipeFor(DemonFurnaceRecipe.Type.INSTANCE,
				inventory, level);

		return match.isPresent() && canInsertAmountIntoOutputSlot(inventory, match.get().getResultItem())
				&& canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
	}

	private static void smeltItem(DemonFurnaceBlockEntity entity) {
		Level level = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}

		Optional<DemonFurnaceRecipe> match = level.getRecipeManager().getRecipeFor(DemonFurnaceRecipe.Type.INSTANCE,
				inventory, level);

		if (match.isPresent()) {
			entity.itemHandler.extractItem(0, 1, false);
			entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
					entity.itemHandler.getStackInSlot(2).getCount() + match.get().getResultItem().getCount()));

		}
	}

	private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
		return inventory.getItem(2).getItem() == output.getItem() || inventory.getItem(2).isEmpty();
	}

	private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory, ItemStack output) {
		return inventory.getItem(2).getMaxStackSize() >= (inventory.getItem(2).getCount() + output.getCount());
	}

	public void setCustomName(Component hoverName) {
		// TODO Auto-generated method stub

	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (side == null) {
                return lazyItemHandlerOptional.cast();
            } else{
                return hopperHandlerOptional.cast();
            }

        }

        return super.getCapability(cap, side);
    }

	 @Override
	    public void onLoad() {
	        super.onLoad();
	        lazyItemHandlerOptional = LazyOptional.of(() -> itemHandler);
	        hopperHandlerOptional = LazyOptional.of(() -> hopperHandler);

	    }

	    @Override
	    public void invalidateCaps()  {
	        super.invalidateCaps();
	        lazyItemHandlerOptional.invalidate();
	        hopperHandlerOptional.invalidate();
	    }
	
}