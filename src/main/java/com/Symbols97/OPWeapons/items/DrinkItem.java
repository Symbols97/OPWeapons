package com.Symbols97.OPWeapons.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class DrinkItem extends Item{

	public DrinkItem(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public UseAnim getUseAnimation(ItemStack p_41452_) {
		// TODO Auto-generated method stub
		return UseAnim.DRINK;
	}
	
}
