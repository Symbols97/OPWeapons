package com.Symbols97.OPWeapons.items.weapons;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

public class OPClub extends SwordItem {

	public OPClub(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hurtEnemy(ItemStack p_43278_, LivingEntity target, LivingEntity attacker) {

		target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0));
		target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0));
		target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 0));
		return super.hurtEnemy(p_43278_, target, attacker);
	}

	int damage = 0;
	@Override
	public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int p_41407_, boolean p_41408_) {

		if (entity instanceof Player) {
			Player player = (Player) entity;
			if (!level.isClientSide) {
				LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
				entityCapability.ifPresent(capability -> {
					if (capability.isWearingOPArmor() && OPWeaponsCommonConfig.canRepair.get() == true) {
						if (itemstack.getDamageValue() > 0) {
							capability.setRepairTickOPArmor(capability.getRepairTickOPArmor() + 1);
							if (capability.getRepairTickOPArmor() > (OPWeaponsCommonConfig.repairCooldown.get() * 20)) {
								damage = itemstack.getDamageValue() - OPWeaponsCommonConfig.repairAmount.get();
								itemstack.setDamageValue(damage);
								capability.setRepairTickOPArmor(0);
							}
						}
					} else {
						capability.setRepairTickOPArmor(0);
					}
				});
			}
		}
	}

}
