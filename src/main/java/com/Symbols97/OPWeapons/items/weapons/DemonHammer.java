package com.Symbols97.OPWeapons.items.weapons;

import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsCommonConfig;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.LazyOptional;

public class DemonHammer extends SwordItem {

	public DemonHammer(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
		super(p_43269_, p_43270_, p_43271_, p_43272_);
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
					Vec3 hitLocation = rayHit.getLocation();
					BlockPos pos = rayHit.getBlockPos();

					if (!player.isCrouching()) {
						LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
						bolt.setPos(hitLocation);
						world.addFreshEntity(bolt);

						// DeadWolfEntity deadwolf = new
						// DeadWolfEntity(OPWEntities.DEADWOLF.get(), world);
						// deadwolf.setPos(hitLocation);
						// deadwolf.setBaby(true);
						// deadwolf.tame(player);
						// world.addFreshEntity(deadwolf);

						if (!capability.isWearingDemonArmor()) {
							item.hurtAndBreak(2, player, null);
						}
					} else {

						if (player.getMainHandItem().getItem() == OPWItems.demon_hammer.get()) {
							world.setBlockAndUpdate(pos.above(), Blocks.LAVA.defaultBlockState());
						} else if (player.getOffhandItem().getItem() == OPWItems.demon_hammer.get()) {
							world.setBlockAndUpdate(pos, Blocks.LAVA.defaultBlockState());
						}

						if (!capability.isWearingDemonArmor()) {
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
					if (capability.isWearingDemonArmor() && OPWeaponsCommonConfig.canRepair.get() == true) {
						if (itemstack.getDamageValue() > 0) {
							capability.setRepairTickDemonArmor(capability.getRepairTickDemonArmor() + 1);
							if (capability.getRepairTickDemonArmor() > (OPWeaponsCommonConfig.repairCooldown.get() * 20)) {
								damage = itemstack.getDamageValue() - OPWeaponsCommonConfig.repairAmount.get();
								itemstack.setDamageValue(damage);
								capability.setRepairTickDemonArmor(0);
							}
						}
					} else {
						capability.setRepairTickDemonArmor(0);
					}
				});
			}
		}

	}

}
