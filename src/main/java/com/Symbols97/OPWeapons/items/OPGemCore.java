package com.Symbols97.OPWeapons.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class OPGemCore extends Item{

	public OPGemCore(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {

		tooltip.add(Component.literal("§aThe core that starts it all"));

		super.appendHoverText(stack, level, tooltip, flag);
	}

}
