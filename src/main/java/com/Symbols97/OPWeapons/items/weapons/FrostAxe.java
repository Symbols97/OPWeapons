package com.Symbols97.OPWeapons.items.weapons;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.LazyOptional;

public class FrostAxe extends AxeItem {

	public FrostAxe(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
		super(p_40521_, p_40522_, p_40523_, p_40524_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		if (!world.isClientSide) {
			LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
			entityCapability.ifPresent(capability -> {
				ItemStack item = player.getItemInHand(hand);
				// RAY END POINT - TO WHERE IT WILL TRAVEL TO
				Double rayLength = (double) 200;
				Vec3 playerRotation = player.getViewVector(0);
				Vec3 rayPath = playerRotation.scale(rayLength);

				// RAY START AND END POINTS
				Vec3 from = player.getEyePosition(0);
				Vec3 to = from.add(rayPath);

				// CREATE THE RAY
				ClipContext rayCtx = new ClipContext(from, to, ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, null);
				// CAST THE RAY
				BlockHitResult rayHit = world.clip(rayCtx);

				// CHECK THE RESULTS
				if (rayHit.getType() == HitResult.Type.MISS) {
					// IF RAY MISSED
				} else {
					// IF RAY HIT SOMETHING
					// Vec3 hitLocation = rayHit.getLocation();
					BlockPos pos = rayHit.getBlockPos();

					if (!player.isCrouching()) {

						if (player.level.dimensionType().hasSkyLight()) {
							if (player.level instanceof ServerLevel serverlevel) {

								System.out.print("working");
								if (serverlevel.isRaining()) {
									serverlevel.setWeatherParameters(0, 0, false, false);
								} else {
									serverlevel.setWeatherParameters(0, 6000, true, true);
								}
							}
						}

						if (!item.isEnchanted() && item.isEnchantable()) {
							item.enchant(Enchantments.SILK_TOUCH, 5);
						}

						if (!capability.isWearingFrostArmor()) {
							item.hurtAndBreak(2, player, null);
						}
					} else {

						world.setBlockAndUpdate(pos.above(), Blocks.ICE.defaultBlockState());

						if (!capability.isWearingFrostArmor()) {
							item.hurtAndBreak(4, player, null);
						}
					}
				}
			});
		}
		return super.use(world, player, hand);
	}

	int damage = 0;

	@Override
	public void inventoryTick(ItemStack itemstack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
		if (entity instanceof Player) {
			Player player = (Player) entity;
			if (!level.isClientSide) {
				LazyOptional<isWearingOPWArmor> entityCapability = player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
				entityCapability.ifPresent(capability -> {
					if (capability.isWearingFrostArmor() && OPWeaponsCommonConfig.canRepair.get() == true) {
						if (itemstack.getDamageValue() > 0) {
							capability.setRepairTickFrostArmor(capability.getRepairTickFrostArmor() + 1);
							if (capability.getRepairTickFrostArmor() > (OPWeaponsCommonConfig.repairCooldown.get() * 20)) {
								damage = itemstack.getDamageValue() - OPWeaponsCommonConfig.repairAmount.get();
								itemstack.setDamageValue(damage);
								capability.setRepairTickFrostArmor(0);
							}
						}
					} else {
						capability.setRepairTickFrostArmor(0);
					}
				});
			}
		}

	}

}
