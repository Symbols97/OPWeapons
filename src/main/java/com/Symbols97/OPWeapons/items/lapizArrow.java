package com.Symbols97.OPWeapons.items;

import com.Symbols97.OPWeapons.projectiles.EntityLapizArrow;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class lapizArrow extends Item {

	public static DamageSource causeLapizArrowDamage (EntityLapizArrow par0EntityOreArrow, Entity par1Entity)
	{
		return (new EntityDamageSourceIndirect("LapizArrow", par0EntityOreArrow, par1Entity)).setProjectile();
	}
}
