package com.Symbols97.OPWeapons.items;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class LostPickaxe extends PickaxeItem{

	public LostPickaxe(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
		super(p_42961_, p_42962_, p_42963_, p_42964_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
		tooltip.add(new TextComponent("§7Used to mine the Block O' Enchanting"));
		tooltip.add(new TextComponent("§7Used for nothing else"));
		super.appendHoverText(p_41421_, p_41422_, tooltip, p_41424_);
	}

}
