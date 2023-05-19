package com.Symbols97.OPWeapons.armors;

import java.util.List;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.management.IDamageHandlingArmor;
import com.Symbols97.OPWeapons.management.Management;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

public class LostArmor extends ArmorItem implements IDamageHandlingArmor{

	public static boolean isWearingLostArmorClient = false;
	public static float durabilityPercent = 0;
	public static int durabilityNumeric1 = 0;
	public static int durabilityNumeric2 = 0;
	
	public LostArmor(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
		super(material, slot, properties);
	}

	
	@Override
	public void appendHoverText(ItemStack itemStack, Level p_41422_, List<Component> textList, TooltipFlag p_41424_) {
		if(itemStack.getItem().equals(OPWItems.op_leggings.get())){
		textList.add(Component.literal("§7Legging grants Speed"));
		}
		if(itemStack.getItem().equals(OPWItems.op_boots.get())){
		textList.add(Component.literal("§7Boots grant Fall Damage Negation"));
		}
	}
	
	int tick = 0;
	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {
		
		boolean fullSet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.lost_helmet.get()
				&& player.getItemBySlot(EquipmentSlot.CHEST).getItem() == OPWItems.lost_chestplate.get()
				&& player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.lost_leggings.get()
				&& player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.lost_boots.get();

		
		if(!level.isClientSide) {
			LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
			entityCapability.ifPresent(capability -> {

			if (fullSet) {
				tick++;
				
				if (player.getInventory().contains(new ItemStack (OPWItems.soul_harvester.get()))) {
					Management.removeItems(player, new ItemStack(OPWItems.soul_harvester.get()));
					
					Management.removeItems(player, new ItemStack(OPWItems.reaper_scythe.get()));
					player.addItem(new ItemStack(OPWItems.reaper_scythe.get()));
					
					player.getInventory().armor.set(3, new ItemStack(OPWItems.reaper_helmet.get()));
					player.getInventory().armor.set(2, new ItemStack(OPWItems.reaper_chestplate.get()));
					player.getInventory().armor.set(1, new ItemStack(OPWItems.reaper_leggings.get()));
					player.getInventory().armor.set(0, new ItemStack(OPWItems.reaper_boots.get()));
					
					player.setHealth(100);
					player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1,500,false,false,true));
					
					
					if (tick > 1) {
						String playername = null;
						playername =  player.getScoreboardName();
						player.displayClientMessage(Component.literal(String.format("§7%s is now a Reaper!" , playername)), false);
						tick = 0;
					}
				}
				
				capability.setWearingLostArmor(true);
			} else {
				capability.setWearingLostArmor(false);
			}
			});
			if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.op_leggings.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25,0,false,false,true));
			}
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.op_boots.get()) {
				player.fallDistance = 0;
			}

		}else  if (level.isClientSide){
			if(fullSet) {
				LostArmor.isWearingLostArmorClient = true;
				durabilityPercent = ((float) stack.getMaxDamage() - (float) stack.getDamageValue()) * (float) 100 / (float) stack.getMaxDamage();
				durabilityNumeric1 = stack.getMaxDamage() - stack.getDamageValue();
				durabilityNumeric2 = stack.getMaxDamage();
				
			} else {
				LostArmor.isWearingLostArmorClient = false;
			}
		}
	}
}
