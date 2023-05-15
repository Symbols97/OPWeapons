package com.Symbols97.OPWeapons.armor;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class OPArmor extends ItemArmor {
	 
	public static boolean iswearingOPArmor = false;
	 

	
	
	public OPArmor(ArmorMaterial oparmormaterial, int renderIndex, int armorType) {
		super(oparmormaterial, renderIndex, armorType);
		
		this.setMaxDamage(7500);

	}
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer player, List textList, boolean useAdvancedItemTooltips)
	 {
		if(itemStack.getItem().equals(OPWeapons.opLeggings)){
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GREEN + "Legging grants Speed");
		}
		if(itemStack.getItem().equals(OPWeapons.opBoots)){
		 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GREEN + "Boots grant Fall Damage Negation");
		}
	 }
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(this.armorType == 2)
		{
			return "opweapons:textures/models/armor/Armor Layer2.png";
		}
		return "opweapons:textures/models/armor/Armor Layer1.png";
	}
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if(player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.opLeggings)){
		    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),20,0));
			}
		if(player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.opBoots)){
			player.fallDistance = 0;	
		}
		
		//when wearing the full armor set
				if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(OPWeapons.opHelmet) 
					&&player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(OPWeapons.opChestplate) 
					&&player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.opLeggings)
					&&player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.opBoots))
				{
					iswearingOPArmor = true;
				} else {
					iswearingOPArmor = false;
				}
		
		
		
	}
}
