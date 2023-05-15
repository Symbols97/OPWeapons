package com.Symbols97.OPWeapons.containers;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.crafting.RepairStation.repairstationCraftingManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RepairStationContainer extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public RepairStationContainer(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		craftMatrix = new InventoryCrafting(this, 1, 2);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		//output
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 124, 35));
		//grid
		for (int i = 0; i < 1; ++i) {
			for(int k = 0; k < 2; ++k) {
				this.addSlotToContainer(new Slot(this.craftMatrix, k + i * 3, 48 + k * 18, 35 + i * 18));
			}
		}
		//inv
		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}
		//hotbar
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
		
		onCraftMatrixChanged(craftMatrix);
	}
	
	
	


	public void onCraftMatrixChanged(IInventory iiventory) {
		craftResult.setInventorySlotContents(0, repairstationCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if(worldObj.getBlock(posX, posY, posZ) != OPWeapons.repairstation) {
			return false;
		}else{
			return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
		}

	}
	
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        super.onContainerClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
        	//rows multiplied together = i < #
            for (int i = 0; i < 2; ++i)
           {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

               if (itemstack != null)
                {
                    par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }

	  public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
	    {
	        ItemStack itemstack = null;
	        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

	        if (slot != null && slot.getHasStack())
	        {
	            ItemStack itemstack1 = slot.getStack();
	            itemstack = itemstack1.copy();

	            if (p_82846_2_ == 0)
	            {
	                if (!this.mergeItemStack(itemstack1, 3, 39, true))
	                {
	                    return null;
	                }

	                slot.onSlotChange(itemstack1, itemstack);
	            }
	            else if (p_82846_2_ >= 3 && p_82846_2_ < 30)
	            {
	                if (!this.mergeItemStack(itemstack1, 30, 39, false))
	                {
	                    return null;
	                }
	            }
	            else if (p_82846_2_ >= 30 && p_82846_2_ < 39)
	            {
	                if (!this.mergeItemStack(itemstack1, 3, 30, false))
	                {
	                    return null;
	                }
	            }
	            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
	            {
	                return null;
	            }

	            if (itemstack1.stackSize == 0)
	            {
	                slot.putStack((ItemStack)null);
	            }
	            else
	            {
	                slot.onSlotChanged();
	            }

	            if (itemstack1.stackSize == itemstack.stackSize)
	            {
	                return null;
	            }

	            slot.onPickupFromSlot(p_82846_1_, itemstack1);
	        }

	        return itemstack;
	    }

	    public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_)
	    {
	        return p_94530_2_.inventory != this.craftResult && super.func_94530_a(p_94530_1_, p_94530_2_);
	    }
	}