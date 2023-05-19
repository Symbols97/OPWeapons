package com.Symbols97.OPWeapons.armors;

import java.util.List;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.management.IDamageHandlingArmor;
import com.Symbols97.OPWeapons.management.Management;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

public class DemonArmor extends ArmorItem implements IDamageHandlingArmor {

	public static boolean isWearingDemonArmorClient = false;
	public static float durabilityPercent = 0;
	public static int durabilityNumeric1 = 0;
	public static int durabilityNumeric2 = 0;

	public DemonArmor(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
		super(p_40386_, p_40387_, p_40388_);
	}

	@Override
	public boolean isFoil(ItemStack p_41453_) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
		if (itemStack.getItem().equals(OPWItems.demon_helmet.get())) {
			list.add(Component.literal("§cHead grants Night Vision"));
		}
		if (itemStack.getItem().equals(OPWItems.demon_helmet_shaded.get())) {
			list.add(Component.literal("§7Shades only activate in the Dead Zone"));
			list.add(Component.literal("§cHead grants Night Vision"));
		}
		if (itemStack.getItem().equals(OPWItems.demon_chestplate.get())) {
			list.add(Component.literal("§cChestplate grants Strength"));
		}
		if (itemStack.getItem().equals(OPWItems.demon_leggings.get())) {
			list.add(Component.literal("§cLeggings grant Speed 2"));
		}
		if (itemStack.getItem().equals(OPWItems.demon_boots.get())) {
			list.add(Component.literal("§cBoots grant Fall Damage Negation"));
		}
		list.add(Component.literal("§cFull set grants Fire Resistance"));
	}

	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {

		boolean fullSet = (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.demon_helmet.get() ||  
				player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.demon_helmet_shaded.get() )
				&& player.getItemBySlot(EquipmentSlot.CHEST).getItem() == OPWItems.demon_chestplate.get()
				&& player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.demon_leggings.get()
				&& player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.demon_boots.get();

		if (!level.isClientSide) {
			LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
			entityCapability.ifPresent(capability -> {
			if (fullSet) {
				player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 3, false, false, true));
				if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == OPWItems.demon_hammer.get()
						|| player.getItemInHand(InteractionHand.OFF_HAND).getItem() == OPWItems.demon_hammer.get()) {
					Management.flightenable(player);
				} else {
					Management.flightdisable(player);
				}
				capability.setWearingDemonArmor(true) ;
			} else {
				Management.flightdisable(player);
				capability.setWearingDemonArmor(false);
			}
			});
			if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.demon_helmet.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, -1, false, false, true));
			}
			if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.demon_helmet_shaded.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, -1, false, false, true));
			}
			if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == OPWItems.demon_chestplate.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 25, 0, false, false, true));
			}
			if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.demon_leggings.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25, 1, false, false, true));
			}
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.demon_boots.get()) {
				player.fallDistance = 0;
			}

		} else if (level.isClientSide) { // ONLY USED FOR CLIENT HUD
			if (fullSet) {
				DemonArmor.isWearingDemonArmorClient = true;
			
				durabilityPercent = ((float) stack.getMaxDamage() - (float) stack.getDamageValue()) * (float) 100
						/ (float) stack.getMaxDamage();

				durabilityNumeric1 = stack.getMaxDamage() - stack.getDamageValue();
				durabilityNumeric2 = stack.getMaxDamage();

				
			} else {
				DemonArmor.isWearingDemonArmorClient = false;
			}
		}
	}
	
	int damage = 0;
	@Override
	public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int p_41407_, boolean p_41408_) {

		if (entity instanceof Player) {
			Player player = (Player) entity;
			if (!level.isClientSide) {
				LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
				entityCapability.ifPresent(capability -> {

					if (capability.isWearingDemonArmor() && OPWeaponsCommonConfig.canRepair.get() == true) {
						if (player.isInLava()) {
							if (itemstack.getDamageValue() > 0) {
								capability.setRepairTickDemonArmor(capability.getRepairTickDemonArmor() + 1);
								if (capability.getRepairTickDemonArmor() > (OPWeaponsCommonConfig.repairCooldown.get() * 20)) {
									damage = itemstack.getDamageValue() - OPWeaponsCommonConfig.repairAmount.get();
									itemstack.setDamageValue(damage);
									capability.setRepairTickDemonArmor(0);
								}
							}
						}
					} else {
						capability.setRepairTickDemonArmor(0);
					}

				});

			}
		}

	}

}
