package com.Symbols97.OPWeapons.items.weapons;

import java.util.List;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;

public class ReaperScythe extends HoeItem {

	public ReaperScythe(Tier p_41336_, int p_41337_, float p_41338_, Properties p_41339_) {
		super(p_41336_, p_41337_, p_41338_, p_41339_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 100), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 0), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 600, 10), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 0), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.HUNGER, 600, 100), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 0), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 1), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 1), attacker);
		target.addEffect(new MobEffectInstance(MobEffects.JUMP, 600, 200), attacker);
		return super.hurtEnemy(stack, target, attacker);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void appendHoverText(ItemStack itemstack, Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
		int timesUsed = OPWItems.reaper_scythe.get().getDamage(itemstack);
		int totalUses = OPWItems.reaper_scythe.get().getMaxDamage();
		String tooltip1 = String.format("§7The Reaper's Scythe inflicts 9 torturous ailments.");
		String durability = String.format("§7Times Used: %d / Total: %d", timesUsed, totalUses);
		tooltip.add(new TextComponent(String.format("%s", tooltip1)));
		tooltip.add(new TextComponent(String.format("%s", durability)));

		if (Screen.hasShiftDown()) {
			tooltip.add(new TextComponent("§7Slownesss"));
			tooltip.add(new TextComponent("§7Weakness"));
			tooltip.add(new TextComponent("§7Blindness"));
			tooltip.add(new TextComponent("§7Fatigue"));
			tooltip.add(new TextComponent("§7Hunger"));
			tooltip.add(new TextComponent("§7Poison"));
			tooltip.add(new TextComponent("§7Wither"));
			tooltip.add(new TextComponent("§7Confusion"));
			tooltip.add(new TextComponent("§7Grounding"));
		} else {
			tooltip.add(new TextComponent("§7Hold §fSHIFT §7for more info"));
		}

		super.appendHoverText(itemstack, p_41422_, tooltip, p_41424_);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand p_41434_) {
		if (!player.isCrouching()) {
			if (!level.isClientSide) {
				LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
				entityCapability.ifPresent(capability -> {
					if (capability.isWearingReaperArmor()) {
						if (player.level.dimension() == Level.OVERWORLD) {
							ServerLevel world = (ServerLevel) level;
							world.setDayTime((long) 18000);
						} else {
							player.displayClientMessage(new TextComponent("§7Only the Earth sky may be manipulated."), false);
						}

					} else {
						player.displayClientMessage(new TextComponent("§7Only The Reaper may manipulate the sky."), false);
					}

				});
			}
		}
		return super.use(level, player, p_41434_);
	}

	int damage = 0;
	@Override
	public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
		if (entity instanceof Player) {
			Player player = (Player) entity;
			if (!level.isClientSide) {
				LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
				entityCapability.ifPresent(capability -> {
					if (capability.isWearingReaperArmor() && OPWeaponsCommonConfig.canRepair.get() == true) {
						if (level.isNight()) {
							if (itemstack.getDamageValue() > 0) {
								capability.setRepairTickReaperArmor(capability.getRepairTickReaperArmor() + 1);
								if (capability.getRepairTickReaperArmor() > OPWeaponsCommonConfig.repairCooldown.get() * 20) {
									damage = itemstack.getDamageValue() - OPWeaponsCommonConfig.repairAmount.get();
									itemstack.setDamageValue(damage);
									capability.setRepairTickReaperArmor(0);
								}
							} else {
								capability.setRepairTickReaperArmor(0);
							}
						}
					} else {
						capability.setRepairTickReaperArmor(0);
					}
				});
				super.inventoryTick(itemstack, level, entity, p_41407_, p_41408_);
			}
		}
	}

}
