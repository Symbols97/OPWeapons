package com.Symbols97.OPWeapons.entity.projectile.lapizarrow;

import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LapizArrow extends AbstractArrow{

	private final Item referenceItem;
	
	public LapizArrow(EntityType<? extends AbstractArrow> type, Level level) {
		super(type, level);
		this.referenceItem = OPWItems.lapiz_arrow.get();
	}

	public LapizArrow(LivingEntity shooter, Level level, Item referenceItem) {
		super(OPWEntities.LAPIZARROW.get(), shooter, level);
		this.referenceItem = referenceItem;
	}

	@Override
	public ItemStack getPickupItem() {
		return new ItemStack(this.referenceItem);
	}

}
