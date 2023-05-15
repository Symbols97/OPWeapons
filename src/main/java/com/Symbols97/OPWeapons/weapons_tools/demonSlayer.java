package com.Symbols97.OPWeapons.weapons_tools;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class demonSlayer extends ItemSword {

	protected boolean canRepair = false;

	public boolean isRepairable() {
		return canRepair;
	};

	public boolean getIsRepairable(ItemStack p_82789_1_, ItemStack p_82789_2_) {
		return false;
	}

	public Item setNoRepair() {
		canRepair = false;
		return this;
	}

	public demonSlayer(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;

	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

		DamageSource ds = DamageSource.onFire;

		target.attackEntityFrom(ds, 1F);

		target.setFire(10);
		return super.hitEntity(stack, target, attacker);
	}

}
