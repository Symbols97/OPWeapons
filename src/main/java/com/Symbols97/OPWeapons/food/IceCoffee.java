package com.Symbols97.OPWeapons.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class IceCoffee extends ItemFood {

	public IceCoffee(int a, boolean b) {
		super(a,b);
		this.setAlwaysEdible();
		
		
	}
	 
		@Override
	        public void onFoodEaten(ItemStack i, World w, EntityPlayer e){
	                // Add Potion Effects
	             e.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 6000, 1));
	             e.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 6000,1)); //Absorption
	             e.addPotionEffect(new PotionEffect(Potion.regeneration.id, 6000, 3));
	             e.addPotionEffect(new PotionEffect(Potion.jump.id, 6000, 1));
	              
	              
	               	 										//Time = X / 20 = Seconds. amp
	}
		public EnumAction getItemUseAction(ItemStack item)
	    {
	        return EnumAction.drink;
	    }
}