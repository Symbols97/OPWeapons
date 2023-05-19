package com.Symbols97.OPWeapons.items;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class SoulHarvester extends Item{

	public SoulHarvester(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
		// TODO Auto-generated method stub
		
		tooltip.add(Component.literal("§7Warning! : Use one at a time!"));
		tooltip.add(Component.literal("§7Having multiple in your inventory will consume them all."));
		super.appendHoverText(p_41421_, p_41422_, tooltip, p_41424_);
	}

}
