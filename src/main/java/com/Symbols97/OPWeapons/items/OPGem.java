package com.Symbols97.OPWeapons.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class OPGem extends Item{

	public OPGem(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {

		tooltip.add(new TextComponent("§aUsed to create the OP Sword and Tools"));

		super.appendHoverText(stack, level, tooltip, flag);
	}


}
