package com.Symbols97.OPWeapons.containers;

import com.Symbols97.OPWeapons.TileEntity.TileEntityDemonFurnace;
import com.Symbols97.OPWeapons.crafting.DemonFurnace.DemonFurnaceRecipes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class ContainerDemonFurnace extends Container {

private TileEntityDemonFurnace demonfurnace;
	
	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;
	
	public ContainerDemonFurnace(InventoryPlayer inventory, TileEntityDemonFurnace tileentity) {
		this.demonfurnace = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters (ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.demonfurnace.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.demonfurnace.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.demonfurnace.currentItemBurnTime);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.demonfurnace.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.demonfurnace.cookTime);
			}
			
			if(this.lastBurnTime != this.demonfurnace.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.demonfurnace.burnTime);
			}
			
			if(this.lastCurrentItemBurnTime != this.demonfurnace.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.demonfurnace.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.demonfurnace.cookTime;
		this.lastBurnTime = this.demonfurnace.burnTime;
		this.lastCurrentItemBurnTime = this.demonfurnace.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0) {
            this.demonfurnace.cookTime = par2;
        }

        if (par1 == 1) {
            this.demonfurnace.burnTime = par2;
        }

        if (par1 == 2) {
            this.demonfurnace.currentItemBurnTime = par2;
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
                if (DemonFurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }else if (TileEntityDemonFurnace.isItemFuel(itemstack1)) {
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
