package com.Symbols97.OPWeapons.screen.theforge;

import java.util.Optional;

import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.recipe.theforge.TheForgeRecipe;
import com.Symbols97.OPWeapons.screen.MenuTypes;
import com.Symbols97.OPWeapons.screen.resultslot.TheForgeResultSlot;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.RecipeBookMenu;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;

public class TheForgeMenu extends RecipeBookMenu<CraftingContainer> {
	   
	   public final static int width = 3;
	   public final static int height = 3;
	   private final CraftingContainer craftSlots = new CraftingContainer(this, width, height);
	   private final ResultContainer resultSlots = new ResultContainer();
	   private final ContainerLevelAccess access;
	   private final Player player;

	   public TheForgeMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
			this(pContainerId, inv);
		}
	   
	   public TheForgeMenu(int p_39353_, Inventory p_39354_) {
	      this(p_39353_, p_39354_, ContainerLevelAccess.NULL);
	   }

	   public TheForgeMenu(int p_39356_, Inventory p_39357_, ContainerLevelAccess p_39358_) {
	      super(MenuTypes.theforge_menu.get(), p_39356_);
	      this.access = p_39358_;
	      this.player = p_39357_.player;
	      this.addSlot(new TheForgeResultSlot(p_39357_.player, this.craftSlots, this.resultSlots, 0, 124, 35));

	      for(int i = 0; i < 3; ++i) {
	         for(int j = 0; j < 3; ++j) {
	            this.addSlot(new Slot(this.craftSlots, j + i * 3, 30 + j * 18, 17 + i * 18));
	         }
	      }

	      for(int k = 0; k < 3; ++k) {
	         for(int i1 = 0; i1 < 9; ++i1) {
	            this.addSlot(new Slot(p_39357_, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
	         }
	      }

	      for(int l = 0; l < 9; ++l) {
	         this.addSlot(new Slot(p_39357_, l, 8 + l * 18, 142));
	      }

	   }

	   protected static void slotChangedCraftingGrid(AbstractContainerMenu abContainer, Level level, Player player, CraftingContainer container, ResultContainer result) {
	      if (!level.isClientSide) {
	         ServerPlayer serverplayer = (ServerPlayer)player;
	         ItemStack itemstack = ItemStack.EMPTY;
	         Optional<TheForgeRecipe> optional = level.getServer().getRecipeManager().getRecipeFor(TheForgeRecipe.Type.INSTANCE, container, level);
	         if (optional.isPresent()) {
	        	 TheForgeRecipe craftingrecipe = optional.get();
	            if (result.setRecipeUsed(level, serverplayer, craftingrecipe)) {
	               itemstack = craftingrecipe.assemble(container);
	            }
	         }

	         result.setItem(0, itemstack);
	         abContainer.setRemoteSlot(0, itemstack);
	         serverplayer.connection.send(new ClientboundContainerSetSlotPacket(abContainer.containerId, abContainer.incrementStateId(), 0, itemstack));
	      }
	   }

	   public void slotsChanged(Container container) {
	      this.access.execute((p_39386_, p_39387_) -> {
	         slotChangedCraftingGrid(this, p_39386_, this.player, this.craftSlots, this.resultSlots);
	      });
	   }

	   public void fillCraftSlotsStackedContents(StackedContents contents) {
	      this.craftSlots.fillStackedContents(contents);
	   }

	   public void clearCraftingContent() {
	      this.craftSlots.clearContent();
	      this.resultSlots.clearContent();
	   }

	   public boolean recipeMatches(Recipe<? super CraftingContainer> container) {
	      return container.matches(this.craftSlots, this.player.level);
	   }

	   public void removed(Player player) {
	      super.removed(player);
	      this.access.execute((p_39371_, p_39372_) -> {
	         this.clearContainer(player, this.craftSlots);
	      });
	   }

	   public boolean stillValid(Player player) {
	      return stillValid(this.access, player, OPWBlocks.the_forge.get());
	   }

	   public ItemStack quickMoveStack(Player player, int num) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.slots.get(num);
	      if (slot != null && slot.hasItem()) {
	         ItemStack itemstack1 = slot.getItem();
	         itemstack = itemstack1.copy();
	         if (num == 0) {
	            this.access.execute((p_39378_, p_39379_) -> {
	               itemstack1.getItem().onCraftedBy(itemstack1, p_39378_, player);
	            });
	            if (!this.moveItemStackTo(itemstack1, 10, 46, true)) {
	               return ItemStack.EMPTY;
	            }

	            slot.onQuickCraft(itemstack1, itemstack);
	         } else if (num >= 10 && num < 46) {
	            if (!this.moveItemStackTo(itemstack1, 1, 10, false)) {
	               if (num < 37) {
	                  if (!this.moveItemStackTo(itemstack1, 37, 46, false)) {
	                     return ItemStack.EMPTY;
	                  }
	               } else if (!this.moveItemStackTo(itemstack1, 10, 37, false)) {
	                  return ItemStack.EMPTY;
	               }
	            }
	         } else if (!this.moveItemStackTo(itemstack1, 10, 46, false)) {
	            return ItemStack.EMPTY;
	         }

	         if (itemstack1.isEmpty()) {
	            slot.set(ItemStack.EMPTY);
	         } else {
	            slot.setChanged();
	         }

	         if (itemstack1.getCount() == itemstack.getCount()) {
	            return ItemStack.EMPTY;
	         }

	         slot.onTake(player, itemstack1);
	         if (num == 0) {
	        	 player.drop(itemstack1, false);
	         }
	      }

	      return itemstack;
	   }

	   public boolean canTakeItemForPickAll(ItemStack p_39381_, Slot p_39382_) {
	      return p_39382_.container != this.resultSlots && super.canTakeItemForPickAll(p_39381_, p_39382_);
	   }

	   public int getResultSlotIndex() {
	      return 0;
	   }

	   public int getGridWidth() {
	      return this.craftSlots.getWidth();
	   }

	   public int getGridHeight() {
	      return this.craftSlots.getHeight();
	   }

	   public int getSize() {
	      return (TheForgeMenu.width * TheForgeMenu.height) + 1;
	   }

	   public RecipeBookType getRecipeBookType() {
	      return null;
	   }

	   public boolean shouldMoveToInventory(int num) {
	      return num != this.getResultSlotIndex();
	   }
	}