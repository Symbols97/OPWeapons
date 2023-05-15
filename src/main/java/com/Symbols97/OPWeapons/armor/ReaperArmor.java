package com.Symbols97.OPWeapons.armor;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.managment.management;
import com.Symbols97.OPWeapons.proxy.ClientProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ReaperArmor extends ItemArmor {

	public static boolean iswearingReaperArmor = false;
	
	public ReaperArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		
		super(armorMaterial, renderIndex, armorType);
		this.setMaxDamage(50000);
	}
	
	//Player Model
	//@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel (EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot){
		
		
		
		ModelBiped armorModel = ClientProxy.reaperArmorModel.get(this);		
		if(armorModel != null) {
    		armorModel.bipedHead.showModel = armorSlot == 0;
    		armorModel.bipedHeadwear.showModel = false;
    		armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
    		armorModel.bipedRightArm.showModel = armorSlot == 1;
    		armorModel.bipedLeftArm.showModel = armorSlot == 1;
    		armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
    		armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;    		
    		armorModel.isSneak = entityLiving.isSneaking();
    		armorModel.isRiding = entityLiving.isRiding();
    		armorModel.isChild = entityLiving.isChild();    		
    		armorModel.heldItemRight = 0;
    		armorModel.aimedBow = false;    		
    		EntityPlayer player = (EntityPlayer)entityLiving;   		
    		ItemStack held_item = player.getEquipmentInSlot(0);  		
    		if (held_item != null){
    			armorModel.heldItemRight = 1;  			
    			if (player.getItemInUseCount() > 0){ 				
    				EnumAction enumaction = held_item.getItemUseAction(); 				
    				if (enumaction == EnumAction.bow){
    					armorModel.aimedBow = true;
    				}else if (enumaction == EnumAction.block){
    					armorModel.heldItemRight = 3;
    				}   				
    			}    			
    		}   		
		}
		return armorModel;
	
	}
	
	//Armor Texture
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(slot == 2)
		{
			return "opweapons:textures/models/armor/reapermodelarmor_2.png"; //reaperarmor 2
		} 

		return "opweapons:textures/models/armor/reapermodelarmor_1.png"; // reaperarmor1
		
		
	}

	
	//ToolTips
	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips) {
		
		if(itemStack.getItem().equals(OPWeapons.reaperHead)) {
			 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Head grants Night Vision");
		}
		
		if(itemStack.getItem().equals(OPWeapons.reaperLeggings)) {
			 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Leggings grant Speed 2");
		}
		if(itemStack.getItem().equals(OPWeapons.reaperBoots)) {
			 textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Boots grant Fall Damage Negation");
		}
		textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "The Reaper has flight, Vacuum Adaptaion,");
		textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "and Fire Resistance.");
	}
	
	//Armor abilities
	int tick = 0;	
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		//Head
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(OPWeapons.reaperHead) ) {
			player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(),220, -1));
		}	
		//Leggings
		if (player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.reaperLeggings)) {
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),20,1));
		}
		//Boots
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.reaperBoots)){
			player.fallDistance = 0;
		}
		//Whole Set
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(OPWeapons.reaperHead) 
				&&player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(OPWeapons.reaperChest) 
				&&player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(OPWeapons.reaperLeggings)
				&&player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(OPWeapons.reaperBoots))
			{
			
			player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20,3));
			management.reaperImmunity(player);
			management.flightenable(player);
			tick++;				
			player.setAir(300);
			iswearingReaperArmor = true;
	
			if (player.inventory.hasItem(OPWeapons.soulHarvester)) {			
				player.inventory.consumeInventoryItem(OPWeapons.soulHarvester);	
				
				player.inventory.consumeInventoryItem(OPWeapons.reaperscythe);
				player.inventory.addItemStackToInventory(new ItemStack(OPWeapons.reaperscythe));
			
				player.setCurrentItemOrArmor(4, new ItemStack(OPWeapons.reaperHead));
				player.setCurrentItemOrArmor(3, new ItemStack(OPWeapons.reaperChest));
				player.setCurrentItemOrArmor(2, new ItemStack(OPWeapons.reaperLeggings));
				player.setCurrentItemOrArmor(1, new ItemStack(OPWeapons.reaperBoots));
				
				player.setHealth(100);				
				player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1, 500));
				//reaperTransform = false;
				if (tick > 1) {						
					player.addChatMessage(new ChatComponentText(String.format("§7The Reaper is now reborn!")));
					
					tick = 0;
				}				
			  }
			}
		else {
			management.flightdisable(player);
			iswearingReaperArmor = false;
		}
	}
}
