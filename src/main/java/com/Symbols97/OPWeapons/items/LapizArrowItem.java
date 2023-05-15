package com.Symbols97.OPWeapons.items;

import com.Symbols97.OPWeapons.entity.projectile.lapizarrow.LapizArrow;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LapizArrowItem extends ArrowItem {

	public final float damage;
	
	public LapizArrowItem(Properties p_40512_, Float damage) {
		super(p_40512_);
		this.damage = damage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public AbstractArrow createArrow(Level level, ItemStack itemstack, LivingEntity entity) {
		LapizArrow arrow = new LapizArrow(entity, level, itemstack.getItem());
		arrow.setBaseDamage(this.damage);
		return arrow;
	}

	@Override
	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
		int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
		return enchant <= 0 ? false : this.getClass() == LapizArrowItem.class;
	}

}
