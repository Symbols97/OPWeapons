package com.Symbols97.OPWeapons.armors;

import java.util.List;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.management.IDamageHandlingArmor;
import com.Symbols97.OPWeapons.management.Management;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ReaperArmor extends GeoArmorItem implements IDamageHandlingArmor, IAnimatable {

	private AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public static boolean isWearingReaperArmorClient = false;
	public static float durabilityPercent = 0;
	public static int durabilityNumeric1 = 0;
	public static int durabilityNumeric2 = 0;

	public ReaperArmor(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
		super(p_40386_, p_40387_, p_40388_);
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level p_41422_, List<Component> list, TooltipFlag p_41424_) {
		if (itemStack.getItem().equals(OPWItems.reaper_helmet.get())) {
			list.add(Component.literal("§7Head grants Night Vision"));
		}
		if (itemStack.getItem().equals(OPWItems.reaper_leggings.get())) {
			list.add(Component.literal("§7Leggings grant Speed 2"));
		}
		if (itemStack.getItem().equals(OPWItems.reaper_boots.get())) {
			list.add(Component.literal("§7Boots grant Fall Damage Negation"));
		}
		list.add(Component.literal("§7The Reaper has flight, Vacuum Adaptaion,"));
		list.add(Component.literal("§7and Fire Resistance."));
	}

	int tick = 0;

	@Override
	public void onArmorTick(ItemStack stack, Level level, Player player) {

		boolean fullSet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.reaper_helmet.get()
				&& player.getItemBySlot(EquipmentSlot.CHEST).getItem() == OPWItems.reaper_chestplate.get()
				&& player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.reaper_leggings.get()
				&& player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.reaper_boots.get();

		if (!level.isClientSide) {
			LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
			entityCapability.ifPresent(capability -> {
				if (fullSet) {
					player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 3, false, false, true));
					Management.reaperImmunity(player);
					Management.flightenable(player);
					tick++;
					player.setAirSupply(300);
					capability.setWearingLostArmor(true);
					if (player.getInventory().contains(new ItemStack(OPWItems.soul_harvester.get()))) {
						Management.removeItems(player, new ItemStack(OPWItems.soul_harvester.get()));
						Management.removeItems(player, new ItemStack(OPWItems.reaper_scythe.get()));
						player.addItem(new ItemStack(OPWItems.reaper_scythe.get()));

						Management.removeItems(player, new ItemStack(OPWItems.reaper_helmet.get()));
						Management.removeItems(player, new ItemStack(OPWItems.reaper_chestplate.get()));
						Management.removeItems(player, new ItemStack(OPWItems.reaper_leggings.get()));
						Management.removeItems(player, new ItemStack(OPWItems.reaper_boots.get()));

						player.getInventory().armor.set(3, new ItemStack(OPWItems.reaper_helmet.get()));
						player.getInventory().armor.set(2, new ItemStack(OPWItems.reaper_chestplate.get()));
						player.getInventory().armor.set(1, new ItemStack(OPWItems.reaper_leggings.get()));
						player.getInventory().armor.set(0, new ItemStack(OPWItems.reaper_boots.get()));

						player.setHealth(100);
						player.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 500, false, false, true));

						if (tick > 1) {
							player.displayClientMessage(Component.literal("§7The Reaper is now reborn!"), false);
							tick = 0;
						}
					}

				} else {
					Management.flightdisable(player);
					capability.setWearingLostArmor(false);
				}
			});
			if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == OPWItems.reaper_helmet.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, -1, false, false, true));

			}
			if (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == OPWItems.reaper_leggings.get()) {

				if (level.isNight()) {
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25, 10, false, false, true));
				} else {
					player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25, 1, false, false, true));
				}

			}
			if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == OPWItems.reaper_boots.get()) {
				player.fallDistance = 0;
			}

		} else if (level.isClientSide) {
			if (fullSet) {
				ReaperArmor.isWearingReaperArmorClient = true;
				durabilityPercent = ((float) stack.getMaxDamage() - (float) stack.getDamageValue()) * (float) 100 / (float) stack.getMaxDamage();

				durabilityNumeric1 = stack.getMaxDamage() - stack.getDamageValue();
				durabilityNumeric2 = stack.getMaxDamage();
			} else {
				ReaperArmor.isWearingReaperArmorClient = false;
			}
		}
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
							}
						}
					} else {
						capability.setRepairTickReaperArmor(0);
					}
				});
			}
		}
	}

	private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle"));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<ReaperArmor>(this, "controller", 20, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

}
