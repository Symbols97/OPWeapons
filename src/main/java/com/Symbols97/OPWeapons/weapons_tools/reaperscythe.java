package com.Symbols97.OPWeapons.weapons_tools;

import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.XRandR.Screen;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armor.DemonArmor;
import com.Symbols97.OPWeapons.armor.ReaperArmor;
import com.Symbols97.OPWeapons.managment.management;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class reaperscythe extends ItemHoe {
	
	
	public reaperscythe(ToolMaterial p_i45343_1_) {
		super(p_i45343_1_);
		// TODO Auto-generated constructor stub
	}

	@Override
	 public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List textList, boolean useAdvancedItemTooltips) {
		int timesUsed = OPWeapons.reaperscythe.getDamage(itemStack);
		int totalUses = OPWeapons.reaperscythe.getMaxDamage();
		String tooltip = String.format("§7The Reaper's Scythe inflicts 9 torturous ailments.");
		String durability = String.format("§7Times Used: %d / Total: %d" , timesUsed , totalUses);
		textList.add(tooltip);
		textList.add(durability);
		if (GuiScreen.isShiftKeyDown()) {
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Slowness");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Weakness");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Blindness");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Fatigue");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Hunger");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Poison");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Wither");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Confusion");
			textList.add(com.mojang.realmsclient.gui.ChatFormatting.GRAY + "Grounding");
		} else {
			
			String info = String.format("§7Hold §fSHIFT §7for more info");
			
			textList.add(info);
		}
		
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity)
	{
	stack.damageItem(1, attackingEntity);
	hitEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 100));
	hitEntity.addPotionEffect(new PotionEffect(Potion.weakness.id, 600, 0));
	hitEntity.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 600, 10));
	hitEntity.addPotionEffect(new PotionEffect(Potion.blindness.id, 600, 0));
	hitEntity.addPotionEffect(new PotionEffect(Potion.hunger.id, 600, 100));
	hitEntity.addPotionEffect(new PotionEffect(Potion.poison.id, 600, 0));
	hitEntity.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 1));
	hitEntity.addPotionEffect(new PotionEffect(Potion.confusion.id, 600, 1));
	hitEntity.addPotionEffect(new PotionEffect(Potion.jump.id, 600, 200));
	return true;
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) 
	{
		
		
		
	if (!player.isSneaking()) {
		
		
		if(!world.isRemote)
		{

				

				if (ReaperArmor.iswearingReaperArmor == true) {
					itemStack.damageItem(0, player);
					world.setWorldTime(18000);
				} else {
					player.addChatMessage(new ChatComponentText(String.format("§7Only The Reaper may manipulate the sky.")));
				}
			
		}
	} 
		
		return itemStack;
	
	}
	
	protected boolean canRepair = false;
	public boolean isRepairable()
    {
        return canRepair;
    }
;
	public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_)
    {
        return false;
    }
	public Item setNoRepair()
    {
        canRepair = false;
        return this;
    }
	
	
}
