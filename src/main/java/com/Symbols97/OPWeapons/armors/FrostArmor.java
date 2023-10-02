package com.Symbols97.OPWeapons.armors;

import java.util.List;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.management.IDamageHandlingArmor;
import com.Symbols97.OPWeapons.management.Management;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

public class FrostArmor extends ArmorItem implements IDamageHandlingArmor {

	public static boolean isWearingFrostArmorClient = false;
	public static float durabilityPercent = 0;
	public static int durabilityNumeric1 = 0;
	public static int durabilityNumeric2 = 0;
	
	public FrostArmor(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
		super(p_40386_, p_40387_, p_40388_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFoil(ItemStack p_41453_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level p_41422_, List<Component> textList, TooltipFlag p_41424_) {

		if (itemStack.getItem().equals(OPWItems.frost_helmet.get())) {
			textList.add(Component.literal("§9Helmet grants Night Vision"));
		}
		if (itemStack.getItem().equals(OPWItems.frost_chestplate.get())) {
			textList.add(Component.literal("§9Chestplate grants Strength"));
		}
		if (itemStack.getItem().equals(OPWItems.frost_leggings.get())) {
			textList.add(Component.literal("§9Leggings grant Speed 2"));
		}
		if (itemStack.getItem().equals(OPWItems.frost_boots.get())) {
			textList.add(Component.literal("§9Boots grant Fall Damage Negation"));
		}

		if (Screen.hasShiftDown()) {
			textList.add(Component.literal("§9Full set grants:"));
			textList.add(Component.literal("§9 - Conduit Power"));
			textList.add(Component.literal("§9 - Frost Immunity"));
			textList.add(Component.literal("§9 * Immunity to:"));
			textList.add(Component.literal("§9      - Slowness"));
			textList.add(Component.literal("§9      - Weakness"));
			textList.add(Component.literal("§9      - Fatigue"));
			textList.add(Component.literal("§9      - Blindness"));
		} else {
			textList.add(Component.literal("§9Hold §fSHIFT §9for more info"));
		}
	}
	
	@Override
	public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
		return true;
	}
	
	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {
		
		boolean fullSet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.frost_helmet.get()
				&& player.getItemBySlot(EquipmentSlot.CHEST).getItem() == OPWItems.frost_chestplate.get()
				&& player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.frost_leggings.get()
				&& player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.frost_boots.get();

	if (!level.isClientSide) {
		LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
		entityCapability.ifPresent(capability -> {
			if (fullSet) {
				player.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 25,3,false,false,true));
				capability.setWearingFrostArmor(true);
				Management.frostImmunity(player);
			} else {
				capability.setWearingFrostArmor(false);
			}
		});
			if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.frost_helmet.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220,-1,false,false,true));
			}
			if (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == OPWItems.frost_chestplate.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 25,0,false,false,true));
			}
			if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.frost_leggings.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25,1,false,false,true));
			}
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.frost_boots.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE,25,4,false,false,true));
				player.fallDistance = 0;
			}
		} else  if (level.isClientSide){
			if(fullSet) {
				FrostArmor.isWearingFrostArmorClient = true;
				durabilityPercent = ((float) stack.getMaxDamage() - (float) stack.getDamageValue()) * (float) 100 / (float) stack.getMaxDamage();

				durabilityNumeric1 = stack.getMaxDamage() - stack.getDamageValue();
				durabilityNumeric2 = stack.getMaxDamage();
				
			} else {
				FrostArmor.isWearingFrostArmorClient = false;
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

					if (capability.isWearingFrostArmor() && OPWeaponsCommonConfig.canRepair.get() == true) {
						if (player.isUnderWater() || player.isInWaterOrRain()) {
							if (itemstack.getDamageValue() > 0) {
								capability.setRepairTickFrostArmor(capability.getRepairTickFrostArmor() + 1);
								if (capability.getRepairTickFrostArmor() > (OPWeaponsCommonConfig.repairCooldown.get() * 20)) {
									damage = itemstack.getDamageValue() - OPWeaponsCommonConfig.repairAmount.get();
									itemstack.setDamageValue(damage);
									capability.setRepairTickFrostArmor(0);
								}
							}
						} else {
							capability.setRepairTickFrostArmor(0);
						}
					} else {
						capability.setRepairTickFrostArmor(0);
					}

				});

			}
		}

	}

}
