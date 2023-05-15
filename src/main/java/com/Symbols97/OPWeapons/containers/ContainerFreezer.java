package com.Symbols97.OPWeapons.containers;

import com.Symbols97.OPWeapons.TileEntity.TileEntityFreezer;
import com.Symbols97.OPWeapons.crafting.Freezer.FreezerRecipes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerFreezer extends Container {

private TileEntityFreezer freezer;
	
	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;
	
	public ContainerFreezer(InventoryPlayer inventory, TileEntityFreezer tileentity) {
		this.freezer = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 48, 35)); // input
		this.addSlotToContainer(new Slot(tileentity, 1, 22, 71)); // fuel
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 124, 35)); // output
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 126 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 184));
		}
	}
	
	public void addCraftingToCrafters (ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.freezer.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.freezer.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.freezer.currentItemBurnTime);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.freezer.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.freezer.cookTime);
			}
			
			if(this.lastBurnTime != this.freezer.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.freezer.burnTime);
			}
			
			if(this.lastCurrentItemBurnTime != this.freezer.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.freezer.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.freezer.cookTime;
		this.lastBurnTime = this.freezer.burnTime;
		this.lastCurrentItemBurnTime = this.freezer.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0) {
            this.freezer.cookTime = par2;
        }

        if (par1 == 1) {
            this.freezer.burnTime = par2;
        }

        if (par1 == 2) {
            this.freezer.currentItemBurnTime = par2;
        }
    }
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0) {
                if (FreezerRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }else if (TileEntityFreezer.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }else if (par2 >= 3 && par2 < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                }else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }


	
	
	
	
	
	
	
	
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
