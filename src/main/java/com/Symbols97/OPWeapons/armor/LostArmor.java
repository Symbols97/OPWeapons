package com.Symbols97.OPWeapons.armor;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class LostArmor extends ItemArmor {

	public LostArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		super(armorMaterial, renderIndex, armorType);
		this.setMaxDamage(1000);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (this.armorType == 2) {
			return "opweapons:textures/models/armor/lostarmor2.png";
		}
		return "opweapons:textures/models/armor/lostarmor1.png";
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List textList,
			boolean useAdvancedItemTooltips) {
		if (itemStack.getItem().equals(OPWeapons.lostLeggings)) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Legging grants Speed");
		}
		if (itemStack.getItem().equals(OPWeapons.lostBoots)) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Boots grant Fall Damage Negation");
		}

	}

	int tick = 0;

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		// Leggings and Boots
		if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.lostLeggings)) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 0));
		}
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.lostBoots)) {
			player.fallDistance = 0;
		}
		// Whole Set

		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(OPWeapons.lostHelmet)
				&& player.getCurrentArmor(2) != null
				&& player.getCurrentArmor(2).getItem().equals(OPWeapons.lostChestplate)
				&& player.getCurrentArmor(1) != null
				&& player.getCurrentArmor(1).getItem().equals(OPWeapons.lostLeggings)
				&& player.getCurrentArmor(0) != null
				&& player.getCurrentArmor(0).getItem().equals(OPWeapons.lostBoots)) {
			tick++;

			if (player.inventory.hasItem(OPWeapons.soulHarvester)
					&& player.inventory.hasItem(OPWeapons.opLoreBookComplete)) {
				player.inventory.consumeInventoryItem(OPWeapons.soulHarvester);
				player.inventory.consumeInventoryItem(OPWeapons.opLoreBookComplete);
				player.inventory.consumeInventoryItem(OPWeapons.reaperscythe);
				player.inventory.addItemStackToInventory(new ItemStack(OPWeapons.reaperscythe));

				player.setCurrentItemOrArmor(4, new ItemStack(OPWeapons.reaperHead));
				player.setCurrentItemOrArmor(3, new ItemStack(OPWeapons.reaperChest));
				player.setCurrentItemOrArmor(2, new ItemStack(OPWeapons.reaperLeggings));
				player.setCurrentItemOrArmor(1, new ItemStack(OPWeapons.reaperBoots));

				player.setHealth(100);
				player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1, 500));
				// ReaperArmor.reaperTransform = false;
				if (tick > 1) {
					String playerName = null;
					playerName = player.getDisplayName();
					player.addChatMessage(new ChatComponentText(String.format("§7%s is now a Reaper!", playerName)));
					// ReaperArmor.reaperTransform = false;
					tick = 0;

				}

			}

		}
	}

}
