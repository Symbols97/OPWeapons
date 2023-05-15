package com.Symbols97.OPWeapons.armor;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.managment.management;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FrostArmor extends ItemArmor {

	public static boolean iswearingFrostArmor = false;

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList,
			boolean useAdvancedItemTooltips) {
		if (itemStack.getItem().equals(OPWeapons.frostHelmet)) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "Helmet grants Night Vision");
		}
		if (itemStack.getItem().equals(OPWeapons.frostChestplate)) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "Chestplate grants Strength");
		}
		if (itemStack.getItem().equals(OPWeapons.frostLeggings)) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "Leggings grant Speed 2");
		}
		if (itemStack.getItem().equals(OPWeapons.frostBoots)) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "Boots grant Fall Damage Negation");
		}

		if (GuiScreen.isShiftKeyDown()) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "Full set grants:");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + " - Water Breathing");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + " - Frost Immunity");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + " * Immunity to:");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "      - Slowness");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "      - Weakness");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "      - Fatigue");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "      - Blindness");
		} else {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.BLUE + "Hold Shift for more info");
		}

	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	public FrostArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		super(armorMaterial, renderIndex, armorType);
		this.setMaxDamage(25000);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (this.armorType == 2) {
			return "opweapons:textures/models/armor/FrostArmor2.png";
		}
		return "opweapons:textures/models/armor/FrostArmor1.png";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(OPWeapons.frostHelmet)) {
			player.addPotionEffect(new PotionEffect(16, 220, 100));
		} // 220/20 = Time left when armor is taken off
		if (player.getCurrentArmor(2) != null
				&& player.getCurrentArmor(2).getItem().equals(OPWeapons.frostChestplate)) {
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 20, 0));
		}
		if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.frostLeggings)) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 1));
		}
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.frostBoots)) {
			player.fallDistance = 0;
		}
		// when wearing the full armor set
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(OPWeapons.frostHelmet)
			&& player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(OPWeapons.frostChestplate)
			&& player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.frostLeggings)
			&& player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.frostBoots)) {
			player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 20, 1000));
			iswearingFrostArmor = true;
			management.frostImmunity(player);

			if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == (OPWeapons.frostAxe)) {

				player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 20, 3));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20, 3));
			}

		} else {
			iswearingFrostArmor = false;
		}
	}
}