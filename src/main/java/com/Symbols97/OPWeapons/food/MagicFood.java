package com.Symbols97.OPWeapons.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MagicFood extends ItemFood {

	public MagicFood(int a, boolean b) {
		super(a,b);
		this.setAlwaysEdible();
		
		
	}
	 
		@Override
	        public void onFoodEaten(ItemStack i, World w, EntityPlayer player){
	                // Add Potion Effects
			
	              player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 6000, 5));
	              player.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 5));	           
	              player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 6000, 10));
	              player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 6000,3));
               	 										//Time = X / 20 = Seconds. amp
	}

}
