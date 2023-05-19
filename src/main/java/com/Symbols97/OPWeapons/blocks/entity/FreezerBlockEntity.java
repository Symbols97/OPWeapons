package com.Symbols97.OPWeapons.blocks.entity;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.Symbols97.OPWeapons.blocks.Freezer;
import com.Symbols97.OPWeapons.blocks.init.BlockEntities;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.recipe.freezer.CoolerRecipe;
import com.Symbols97.OPWeapons.recipe.freezer.FreezerRecipe;
import com.Symbols97.OPWeapons.screen.freezer.FreezerMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class FreezerBlockEntity extends BlockEntity implements MenuProvider {
	
	protected final ContainerData data;
	public int litTime; // how long the furnace has been lit for
	public int litDuration; // how long the furnace will stay lit
	public int cookingProgress; // how long the item has been burning for
	public int cookingTotalTime = 300; // furnace speed
	private static boolean changed = false;
	
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
			}  else if (i == 2) {
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
	           
	            if((slot == 0 && getStackInSlot(slot).is(Items.BUCKET))){
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

	            if(slot != 0 && isItemValid(slot, stack) ){
	                return itemHandler.insertItem(slot, stack, simulate);
	            }
	            if (slot == 0 && !isFuel(stack) || stack.is(Items.ICE)) {
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

	
	
	private Mode mode;

	public Mode getMode() {
		return mode;
	}

	public static enum Mode {
		FREEZER, COOLER;

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

	
	

	public FreezerBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
		super(BlockEntities.freezer_block_entity.get(), pWorldPosition, pBlockState);
		
		if (mode != Mode.FREEZER || mode != Mode.COOLER) {
			mode = Mode.FREEZER;
		}
		
		this.data = new ContainerData() {
			public int get(int index) {
				switch (index) {
				case 0:
					return FreezerBlockEntity.this.litTime;
				case 1:
					return FreezerBlockEntity.this.litDuration;
				case 2:
					return FreezerBlockEntity.this.cookingProgress;
				case 3:
					return FreezerBlockEntity.this.cookingTotalTime;
				default:
					return 0;
				}
			}

			public void set(int index, int value) {
				switch (index) {
				case 0:
					FreezerBlockEntity.this.litTime = value;
					break;
				case 1:
					FreezerBlockEntity.this.litDuration = value;
					break;
				case 2:
					FreezerBlockEntity.this.cookingProgress = value;
					break;
				case 3:
					FreezerBlockEntity.this.cookingTotalTime = value;
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
		return Component.literal("§fFreezer");
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
		return new FreezerMenu(pContainerId, pInventory, this, this.data);
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
		nbt.putInt("FeezerMode", this.mode.ordinal());	
		}

	
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		itemHandler.deserializeNBT(nbt.getCompound("inventory"));
		this.litTime = nbt.getInt("BurnTime");
		this.cookingProgress = nbt.getInt("CookTime");
		this.cookingTotalTime = nbt.getInt("CookTimeTotal");
		this.litDuration = nbt.getInt("litDuration");
		this.mode = Mode.values()[nbt.getInt("FeezerMode")];
		this.setChanged();
	}

	public void drops() {
		SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			inventory.setItem(i, itemHandler.getStackInSlot(i));
		}

		Containers.dropContents(this.level, this.worldPosition, inventory);
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, FreezerBlockEntity blockentity) {
		ItemStack itemstack = blockentity.itemHandler.getStackInSlot(1);
		boolean flag = blockentity.isLit();
		boolean flag1 = false;
		if (blockentity.isLit()) {
			blockentity.litTime--;
		}

		if (!pLevel.isClientSide()) {
			if (blockentity.litTime == 0 && canSmelt(blockentity)) {
				blockentity.litDuration = blockentity.litTime = fuelBurnDuration(itemstack);

				if (blockentity.isLit()) {
					flag1 = true;
					if (itemstack.hasCraftingRemainingItem())
						blockentity.items.set(1, itemstack.getCraftingRemainingItem());
					else if (!itemstack.isEmpty()) {
						// Item item = itemstack.getItem();
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							blockentity.items.set(1, itemstack.getCraftingRemainingItem());
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
				pState = pState.setValue(Freezer.LIT, Boolean.valueOf(blockentity.isLit()));
				pLevel.setBlock(pPos, pState, 3);

			}

		}
		if (flag1) {
			setChanged(pLevel, pPos, pState);
		}
		
		if (FreezerBlockEntity.changed) {
			setChanged(pLevel, pPos, pState);
			changed = false;
		}
				
		
		
	}

	public static boolean isFuel(ItemStack itemstack) {
		return fuelBurnDuration(itemstack) > 0;
	}
	
	public static int fuelBurnDuration(ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		} else {
			Item item = itemstack.getItem();

			if (item == Items.SNOWBALL) {
				return 19;
			}
			if (item == Items.SNOW_BLOCK) {
				return 76;
			}
			if (item == Items.ICE) {
				return 608;
			}
			if (item == Items.PACKED_ICE) {
				return 5472;
			}
			if (item == OPWItems.ultimate_nether_star.get()) {
				return 10000000;
			}
			if (item == OPWItems.frost_vial.get()) {
				return 20000000;
			}
			//ult nether star 10000000
			//frost vial 20000000

		}
		return 0;
	}

	private static boolean canSmelt(FreezerBlockEntity entity) {
		Level level = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}

		if (entity.mode == Mode.FREEZER) {
			Optional<FreezerRecipe> match = level.getRecipeManager().getRecipeFor(FreezerRecipe.Type.INSTANCE, inventory, level);
			return match.isPresent() && canInsertAmountIntoOutputSlot(inventory, match.get().getResultItem())
					&& canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
		} else if (entity.mode == Mode.COOLER) {
			Optional<CoolerRecipe> match = level.getRecipeManager().getRecipeFor(CoolerRecipe.Type.INSTANCE, inventory, level);
			return match.isPresent() && canInsertAmountIntoOutputSlot(inventory, match.get().getResultItem())
					&& canInsertItemIntoOutputSlot(inventory, match.get().getResultItem());
		}
		
		return false;
	}

	private static void smeltItem(FreezerBlockEntity entity) {
		Level level = entity.level;
		SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
		for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
			inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
		}

		
		if (entity.mode == Mode.FREEZER) {
			Optional<FreezerRecipe> match = level.getRecipeManager().getRecipeFor(FreezerRecipe.Type.INSTANCE,inventory, level);
			if (match.isPresent()) {
				entity.itemHandler.extractItem(0, 1, false);
				entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
						entity.itemHandler.getStackInSlot(2).getCount()  + match.get().getResultItem().getCount()));

				if (entity.itemHandler.getStackInSlot(0).isEmpty()) {
					if (entity.itemHandler.getStackInSlot(2).equals(new ItemStack(Items.ICE), true)) {
						entity.itemHandler.setStackInSlot(0, new ItemStack(Items.BUCKET,entity.itemHandler.getStackInSlot(0).getCount() + 1));
					}
				}
			}
			
		} else if (entity.mode == Mode.COOLER){
			Optional<CoolerRecipe> match = level.getRecipeManager().getRecipeFor(CoolerRecipe.Type.INSTANCE,inventory, level);
	
			if (match.isPresent()) {
				entity.itemHandler.extractItem(0, 1, false);
				entity.itemHandler.setStackInSlot(2, new ItemStack(match.get().getResultItem().getItem(),
						entity.itemHandler.getStackInSlot(2).getCount()  + match.get().getResultItem().getCount()));

				if (entity.itemHandler.getStackInSlot(0).isEmpty()) {
					
						entity.itemHandler.setStackInSlot(0, new ItemStack(Items.BUCKET, entity.itemHandler.getStackInSlot(0).getCount() + 1));
					
				}
			}
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
		if (cap == ForgeCapabilities.ITEM_HANDLER) {
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
	    
	    @Override
	    public Packet<ClientGamePacketListener> getUpdatePacket() {
	        return ClientboundBlockEntityDataPacket.create(this);
	    }
	    
	    @Override
	    public CompoundTag getUpdateTag() {
	        return serializeNBT();
	    }
	    
	    @Override
	    public void handleUpdateTag(CompoundTag tag) {
	        super.handleUpdateTag(tag);
	        load(tag);
	    }
	    
	    @Override
	    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
	        super.onDataPacket(net, pkt);
	        handleUpdateTag(pkt.getTag());
	    }
	    
	    public void update() {
	        setChanged();
	        if (this.level != null) {
	            this.level.setBlockAndUpdate(this.worldPosition, getBlockState());
	        }
	    }
	   
}