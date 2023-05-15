package com.Symbols97.OPWeapons.food;

import net.minecraft.item.ItemFood;

public class PetFood extends ItemFood {

	
	public PetFood(int a, boolean b) {
		super(a,b);
		this.setAlwaysEdible();
		this.isWolfsFavoriteMeat();
		
	}
	public boolean isWolfsFavoriteMeat()
    {
        return true;
    }
	

}
