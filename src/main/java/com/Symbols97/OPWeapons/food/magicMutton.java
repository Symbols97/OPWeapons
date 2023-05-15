package com.Symbols97.OPWeapons.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class magicMutton extends ItemFood {

	public magicMutton(int a, boolean b) {
		super(a,b);
		this.setAlwaysEdible();
		
		
	}
	 
		@Override
	        public void onFoodEaten(ItemStack i, World w, EntityPlayer e){
	                // Add Potion Effects
			
	              e.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 6000, 3));
	              e.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 6000, 3));
	              e.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 6000, 4)); //Saturation	           
	              e.addPotionEffect(new PotionEffect(Potion.jump.id, 6000, 2));
	              e.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 6000,5));
               	 										//Time = X / 20 = Seconds. amp
	}

}