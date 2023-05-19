package com.Symbols97.OPWeapons.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class RepairModule extends Item{

	public RepairModule(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {

		tooltip.add(Component.literal("§7Repair your tools and weapons"));

		super.appendHoverText(stack, level, tooltip, flag);
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
