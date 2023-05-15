package com.Symbols97.OPWeapons.screen.freezer;

import com.Symbols97.OPWeapons.blocks.entity.FreezerBlockEntity;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.screen.MenuTypes;
import com.Symbols97.OPWeapons.screen.resultslot.OPWResultSlot;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class FreezerMenu extends AbstractContainerMenu {
	
    public FreezerBlockEntity blockEntity;
    private Level level;
    private final ContainerData data;

    public FreezerMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(4));
    }

    
    public FreezerMenu(int pContainerId, Inventory inv, BlockEntity entity , ContainerData data) {
        super(MenuTypes.freezer_menu.get(), pContainerId);
        checkContainerSize(inv, 3);
        blockEntity = (FreezerBlockEntity) entity;
        this.level = inv.player.level;
     
        this.data = data;
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        this.blockEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> {
        	this.addSlot(new SlotItemHandler(handler, 0, 48, 3));
        	this.addSlot(new SlotItemHandler(handler, 1, 22, 39));
            this.addSlot(new OPWResultSlot(handler, 2, 124, 3));
        });
        
        addDataSlots(data);
    }

    public FreezerBlockEntity getBlockEntity() {
        return this.blockEntity;
    }
    
    public boolean isBurning() {
    	return data.get(0) > 0;
    }
    
    public int percentDisplay() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);  // Max Progress
        
        if (maxProgress < 1) {
        	return 0;
  		}
        
        return progress * 100 / maxProgress;
    }
    
    public int getBurnTimeRemainingScaled(int i) {
    	
    	int progress = data.get(0);
    	int maxProgress = data.get(1);
    	int totalCookTime = data.get(3);
    	
  		if (maxProgress == 0) {
  			maxProgress = totalCookTime;
  		}

  		return maxProgress > 0 ? progress * i / maxProgress : 0;
  	}

  	public int getCookProgressScaled(int i) {
  		int cookingProgress = data.get(2);
    	int totalCookTime = data.get(3);
  		return totalCookTime > 0 ? cookingProgress * i / totalCookTime : 0;
  	}

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 3;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, OPWBlocks.freezer.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
            	this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 94 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
        	this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 152));
        }
    }
}