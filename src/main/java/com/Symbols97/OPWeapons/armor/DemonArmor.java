package com.Symbols97.OPWeapons.armor;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.managment.management;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class DemonArmor extends ItemArmor {
	
	public static boolean iswearingDemonArmor = false;
	public static boolean canFly = false;
	
	@Override
	    public boolean hasEffect(ItemStack par1ItemStack)
	    {
		    return true;
	    }
	
	public DemonArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		super(armorMaterial, renderIndex, armorType);
		this.setMaxDamage(25000);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(slot == 2 )
		{
			return "opweapons:textures/models/armor/DemonArmor2.png"; //reaperarmor 2
		} 
		return "opweapons:textures/models/armor/DemonArmor1.png";
	}
	
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips)
	 {
		if(itemStack.getItem().equals(OPWeapons.demonHead)){
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.RED + "Head grants Night Vision");
		}
		if(itemStack.getItem().equals(OPWeapons.demonChest)) {
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.RED + "Chestplate grants Strength");
		}
		if(itemStack.getItem().equals(OPWeapons.demonLeggings)) {
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.RED + "Leggings grant Speed 2");
		}
		if(itemStack.getItem().equals(OPWeapons.demonBoots)) {
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.RED + "Boots grant Fall Damage Negation");
		}
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.RED + "Full set grants Fire Resistance");
	 }
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		if(player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(OPWeapons.demonHead)){
			player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(),220, -1));
		}             							  //   220/20 = Time left when armor is taken off
		if(player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(OPWeapons.demonChest)){
		    player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(),20,0));
		}
		if(player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.demonLeggings)){
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),20,1));
		}	
		if(player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.demonBoots)){
			player.fallDistance = 0;
		}
		//when wearing the full armor set
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(OPWeapons.demonHead) 
			&&player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(OPWeapons.demonChest) 
			&&player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.demonLeggings)
			&&player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.demonBoots))
		{
		player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(),20,3));
		iswearingDemonArmor = true;
		
		int hotbarcheck;
		for (hotbarcheck = 0; hotbarcheck < 9; hotbarcheck ++) {
			
			if (player.inventory.getStackInSlot(hotbarcheck) != null && player.inventory.getStackInSlot(hotbarcheck).getItem().equals(OPWeapons.demonHammer) ) {
		
				if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == OPWeapons.demonHammer) {
					player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(),2,2));
					
					management.flightenable(player);
				
					} else {
						management.flightdisable(player);
					}
				}
			}
		}

		else {
			iswearingDemonArmor = false;
			canFly = false;
			//management.flightdisable(player);
		}
	}
	
	
	
	
			/*if(boots.getItem() == OPWeapons.demonBoots && legs.getItem() == OPWeapons.demonLeggings && chest.getItem() == OPWeapons.demonChest && helmet.getItem() == OPWeapons.demonHead){
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(),220,1000));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),220,1));
				player.addPotionEffect(new PotionEffect(16,220, 100));*/
	}													//   220/20 = Time left when armor is taken off
					
			
			
		




