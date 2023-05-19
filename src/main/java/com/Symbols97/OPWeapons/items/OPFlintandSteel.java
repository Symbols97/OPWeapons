package com.Symbols97.OPWeapons.items;

import net.minecraft.util.RandomSource;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ItemStack;

public class OPFlintandSteel extends FlintAndSteelItem {
	
	public OPFlintandSteel(Properties p_41383_) {
		super(p_41383_);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack itemstack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack stack) {
		ItemStack result = stack.copy();
		result.hurt(1, RandomSource.create(), null);

		return result;
	}
	
}