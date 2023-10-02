package com.Symbols97.OPWeapons.armors;

import java.util.List;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.management.IDamageHandlingArmor;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
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
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.util.LazyOptional;

public class OPArmor extends ArmorItem implements IDamageHandlingArmor {

	public static boolean isWearingOPArmorClient = false;
	public static float durabilityPercent = 0;
	public static int durabilityNumeric1 = 0;
	public static int durabilityNumeric2 = 0;

	int damage;
	public OPArmor(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
		this.damage = 0;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level p_41422_, List<Component> textList, TooltipFlag p_41424_) {
		if (itemStack.getItem().equals(OPWItems.op_leggings.get())) {
			textList.add(new TextComponent("§aLegging grants Speed"));
		}
		if (itemStack.getItem().equals(OPWItems.op_boots.get())) {
			textList.add(new TextComponent("§aBoots grant Fall Damage Negation"));
		}
	}

	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {

		boolean fullSet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.op_helmet.get()
				&& player.getItemBySlot(EquipmentSlot.CHEST).getItem() == OPWItems.op_chestplate.get()
				&& player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.op_leggings.get()
				&& player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.op_boots.get();

		if (!level.isClientSide) {
			LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
			entityCapability.ifPresent(capability -> {
				if (fullSet) {

					capability.setWearingOPArmor(true);

					// isWearingOPArmor = true;
				} else {

					capability.setWearingOPArmor(false);

				}
			});
			if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.op_leggings.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25, 0, false, false, true));
			}
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.op_boots.get()) {
				player.fallDistance = 0;
			}

		} else if (level.isClientSide) {
			if (fullSet) {
				OPArmor.isWearingOPArmorClient = true;
				durabilityPercent = ((float) stack.getMaxDamage() - (float) stack.getDamageValue()) * (float) 100 / (float) stack.getMaxDamage();

				durabilityNumeric1 = stack.getMaxDamage() - stack.getDamageValue();
				durabilityNumeric2 = stack.getMaxDamage();

			} else {
				OPArmor.isWearingOPArmorClient = false;
			}
		}

	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int p_41407_, boolean p_41408_) {

		if (entity instanceof Player) {
			Player player = (Player) entity;
			if (!level.isClientSide) {
				LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
				entityCapability.ifPresent(capability -> {
					BlockPos pos = entity.blockPosition();

					Biome biome = level.getBiome(pos).value();

					if (capability.isWearingOPArmor() && OPWeaponsCommonConfig.canRepair.get() == true) {
						if (biome.getRegistryName().equals(Biomes.PLAINS.location()) || biome.getRegistryName().equals(Biomes.MEADOW.location())) {
							if (itemstack.getDamageValue() > 0) {
								capability.setRepairTickOPArmor(capability.getRepairTickOPArmor() + 1);
								if (capability.getRepairTickOPArmor() > (OPWeaponsCommonConfig.repairCooldown.get() * 20 * 3)) {
									damage = itemstack.getDamageValue() - OPWeaponsCommonConfig.repairAmount.get();
									itemstack.setDamageValue(damage);
									capability.setRepairTickOPArmor(0);
								}
							}
						} else {
							capability.setRepairTickOPArmor(0);
						}
					} else {
						capability.setRepairTickOPArmor(0);
					}

				});

			}
		}

	}

}