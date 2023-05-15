package com.Symbols97.OPWeapons.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class snowCone extends ItemFood {

	public snowCone(int a, boolean b) {
		super(a,b);
		this.setAlwaysEdible();
		
		
	}
	 
		@Override
	        public void onFoodEaten(ItemStack i, World w, EntityPlayer e){
	                // Add Potion Effects
	             e.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1800, 1));
	             e.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 1800,0));
		}
	              
	              
	               	 										//Time = X / 20 = Seconds. amp
	

}