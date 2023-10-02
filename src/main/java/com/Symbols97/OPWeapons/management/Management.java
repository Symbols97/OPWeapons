package com.Symbols97.OPWeapons.management;

import org.apache.maven.artifact.versioning.ComparableVersion;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.capabilities.Capabilities;
import com.Symbols97.OPWeapons.capabilities.isWearingOPWArmor;
import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.world.dimension.OPWDimensions;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.VersionChecker;
import net.minecraftforge.fml.VersionChecker.Status;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.IModInfo;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Management {

	@SubscribeEvent
	public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event) {
		event.register(OPWEntities.DEADWOLF.get(), 
				SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, 
				Animal::checkAnimalSpawnRules,
				SpawnPlacementRegisterEvent.Operation.OR);
		
		event.register(OPWEntities.FROSTYOSTRICH.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules,
                SpawnPlacementRegisterEvent.Operation.OR);
		
		 event.register(OPWEntities.OPGOBLIN.get(),
                 SpawnPlacements.Type.ON_GROUND,
                 Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                 Monster::checkMonsterSpawnRules,
 				SpawnPlacementRegisterEvent.Operation.OR);
         
		 event.register(OPWEntities.DEMONGOBLIN.get(),
                 SpawnPlacements.Type.ON_GROUND,
                 Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                 Monster::checkMonsterSpawnRules,
 				SpawnPlacementRegisterEvent.Operation.OR);
         
		 event.register(OPWEntities.FROSTGOBLIN.get(),
                 SpawnPlacements.Type.ON_GROUND,
                 Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                 Monster::checkMonsterSpawnRules,
 				SpawnPlacementRegisterEvent.Operation.OR);
         
		 event.register(OPWEntities.REAPER.get(),
                 SpawnPlacements.Type.ON_GROUND,
                 Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                 Monster::checkMonsterSpawnRules,
 				SpawnPlacementRegisterEvent.Operation.OR);
         
		 event.register(OPWEntities.DEMON.get(),
                 SpawnPlacements.Type.ON_GROUND,
                 Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                 Monster::checkMonsterSpawnRules,
 				SpawnPlacementRegisterEvent.Operation.OR);
         
		 event.register(OPWEntities.OPGUARDIAN.get(),
                 SpawnPlacements.Type.ON_GROUND,
                 Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                 Monster::checkMonsterSpawnRules,
 				SpawnPlacementRegisterEvent.Operation.OR);
         
		 event.register(OPWEntities.DEMONGUARDIAN.get(),
                 SpawnPlacements.Type.ON_GROUND,
                 Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                 Monster::checkMonsterSpawnRules,
 				SpawnPlacementRegisterEvent.Operation.OR);
         
		 event.register(OPWEntities.FROSTGUARDIAN.get(),
                 SpawnPlacements.Type.ON_GROUND,
                 Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                 Monster::checkMonsterSpawnRules,
 				SpawnPlacementRegisterEvent.Operation.OR);
	}

	@SubscribeEvent
	public static void armorAttackHandler(LivingDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			LazyOptional<isWearingOPWArmor> entityCapability = player
					.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
			entityCapability.ifPresent(capability -> {
				if ((capability.isWearingOPArmor() || capability.isWearingLostArmor()) && player.getAirSupply() > 0) {
					event.setCanceled(true);
					return;
				}
				if (capability.isWearingDemonArmor() && !player.isUnderWater()) {
					event.setCanceled(true);
					return;
				}
				if (capability.isWearingFrostArmor()) {
					event.setCanceled(true);
					return;
				}
				if (capability.isWearingReaperArmor()) {
					event.setCanceled(true);
					return;
				}
				
				if(player.getItemBySlot(EquipmentSlot.HEAD).isEmpty()
						|| player.getItemBySlot(EquipmentSlot.CHEST).isEmpty()
						|| player.getItemBySlot(EquipmentSlot.LEGS).isEmpty()
						|| player.getItemBySlot(EquipmentSlot.FEET).isEmpty()) {
					
					player.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY).invalidate();
					
				}
				
			});
			
			
			
		}
	}

	public static void removeItems(Player player, ItemStack itemstack) {
		IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
		for (int i = 0; i < inventory.getSlots(); i++)
			if (inventory.getStackInSlot(i).getItem() == itemstack.getItem()) {
				inventory.extractItem(i, inventory.getSlotLimit(i), false);
			}
	}

	public static String capatilize(String string) {

		String[] words = string.split(" ");
		// capitalize each word
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
		}
		// rejoin back into a sentence
		string = String.join(" ", words);
		return string;

	}

	public static final String KEY = "opweapons.joinedBefore";

	@SubscribeEvent
	public static void firstJoin(PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			CompoundTag data = player.getPersistentData();

			if (!data.getBoolean(KEY)) {
				data.putBoolean(KEY, true);
				player.getInventory().add(new ItemStack(OPWItems.guide_book.get()));
			}

		}
	}

	@SubscribeEvent
	public static void onJoin(PlayerLoggedInEvent event) {

		if (event.getEntity() instanceof Player) {
			Player player = (Player) event.getEntity();
			ModContainer modContainer = ModList.get().getModContainerById(OPWeapons.MOD_ID).get();
			IModInfo info = modContainer.getModInfo();
			ComparableVersion updatedVersion = VersionChecker.getResult(info).target();

			if (VersionChecker.getResult(info).status() == Status.OUTDATED) {
				player.displayClientMessage(
						Component.literal(String.format("OPWeapons is §cOUTDATED§f. Installed: §c%s §fLatest: §a%s",
								OPWeapons.ModVersion, updatedVersion)),
						false);
			}
			if (VersionChecker.getResult(info).status() == Status.BETA_OUTDATED) {
				player.displayClientMessage(Component
						.literal(String.format("OPWeapons Beta is §cOUTDATED§f. Installed: §c%s §fLatest: §a%s",
								OPWeapons.ModVersion, updatedVersion)),
						false);
			}
			if (VersionChecker.getResult(info).status() == Status.UP_TO_DATE) {
				player.displayClientMessage(
						Component.literal(
								String.format("OPWeapons is §aUp to Date§f. Installed: §a%s", OPWeapons.ModVersion)),
						false);
			}
			if (VersionChecker.getResult(info).status() == Status.BETA) {
				player.displayClientMessage(Component
						.literal(String.format("OPWeapons Beta is §aUp to Date§f. Installed: §a%s §fLatest: §a%s",
								OPWeapons.ModVersion, updatedVersion)),
						false);
			}
			if (VersionChecker.getResult(info).status() == Status.FAILED) {
				player.displayClientMessage(
						Component.literal(String.format("OPWeapons §cfailed§f to check for an update. Try again later",
								OPWeapons.ModVersion, updatedVersion)),
						false);
			}

			player.displayClientMessage(Component.literal("§6Join the OPWeapons Discord! §9https://discord.gg/qcqAA98"),
					false);

		}
	}

//	@SubscribeEvent
//	public static void armorCheck(PlayerTickEvent event) {
//
//		if (event.player instanceof Player) {
//			Player player = (Player) event.player;
//
//			if (player.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
//				if (OPArmor.isWearingOPArmor) {
//					OPArmor.isWearingOPArmor = false;
//				} else if (LostArmor.isWearingLostArmor) {
//					LostArmor.isWearingLostArmor = false;
//				} else if (DemonArmor.isWearingDemonArmor) {
//					DemonArmor.isWearingDemonArmor = false;
//				} else if (FrostArmor.isWearingFrostArmor) {
//					FrostArmor.isWearingFrostArmor = false;
//				} else if (ReaperArmor.isWearingReaperArmor) {
//					ReaperArmor.isWearingReaperArmor = false;
//				}
//			}
//
//		}
//	}

	public static void flightenable(Player player) {
		player.getAbilities().mayfly = true;
		player.onUpdateAbilities();
	}

	public static void flightdisable(Player player) {
		if (!player.getAbilities().instabuild) {
			player.getAbilities().flying = false;
			player.getAbilities().mayfly = false;
			player.onUpdateAbilities();
		}
	}

	// Immunity to Reaper Effects
	public static void reaperImmunity(Player player) {
		player.removeEffect(MobEffects.POISON);
		player.removeEffect(MobEffects.WITHER);
		player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		player.removeEffect(MobEffects.WEAKNESS);
		player.removeEffect(MobEffects.DIG_SLOWDOWN);
		player.removeEffect(MobEffects.BLINDNESS);
		player.removeEffect(MobEffects.HUNGER);
		player.removeEffect(MobEffects.CONFUSION);
	}

	// Immunity to Frost effects.
	public static void frostImmunity(Player player) {
		player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		player.removeEffect(MobEffects.WEAKNESS);
		player.removeEffect(MobEffects.DIG_SLOWDOWN);
		player.removeEffect(MobEffects.BLINDNESS);
	}

	// If the player has the R.I.P. -> give player reaper immunity.
	@SubscribeEvent
	public static void RIPgiveReaperImmunity(PlayerTickEvent event) {

		if (event.player instanceof Player) {
			Player player = (Player) event.player;
			if (player.getInventory().contains(new ItemStack(OPWItems.reaper_immunity_patch.get()))) {
				reaperImmunity(player);
			}
		}
	}

	@SubscribeEvent
	public static void dimensionCheck(PlayerTickEvent event) {

		if (event.player instanceof Player) {
			Player player = (Player) event.player;
			LazyOptional<isWearingOPWArmor> entityCapability = player
					.getCapability(Capabilities.WEARING_OPW_ARMOR_CAPABILITY);
			entityCapability.ifPresent(capability -> {
				if (player.level.dimension() == OPWDimensions.FZ_KEY) {
					if (!capability.isWearingFrostArmor() && !player.getAbilities().instabuild
							&& !player.getMainHandItem().getItem().equals(OPWItems.frost_axe.get())
							&& !player.getOffhandItem().getItem().equals(OPWItems.frost_axe.get())) {
						player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 3));
						player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 10, 3));
						player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 10, 3));
					}

				}
			});
		}
	}

	@SubscribeEvent
	public static void hammercheck(PlayerTickEvent event) {
		if (event.player instanceof Player) {
			Player player = (Player) event.player;

			if (player.getMainHandItem().getItem() == OPWItems.demon_hammer.get()
					|| player.getOffhandItem().getItem() == OPWItems.demon_hammer.get()) {
				player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 1000));
			}
		}
	}

	@SubscribeEvent
	public static void frostaxecheck(PlayerTickEvent event) {

		if (event.player instanceof Player) {
			Player player = (Player) event.player;

			if (player.getMainHandItem().getItem() == OPWItems.frost_axe.get()
					|| player.getOffhandItem().getItem() == OPWItems.frost_axe.get()) {
				frostImmunity(player);

				if (player.isInWater()) {
					player.resetFallDistance();
					CollisionContext collisioncontext = CollisionContext.of(player);
					if (collisioncontext.isAbove(LiquidBlock.STABLE_SHAPE, player.blockPosition(), true)
							&& !player.level.getFluidState(player.blockPosition().above()).is(FluidTags.WATER)) {
						player.setOnGround(true);
					} else {
						player.setDeltaMovement(player.getDeltaMovement().scale(0.5D).add(0.0D, 0.05D, 0.0D));
					}
				}

			}
		}
	}

	@SubscribeEvent
	public static void customPunches(AttackEntityEvent event) {

		LivingEntity attacker = (LivingEntity) event.getEntity();
		Entity checkedtarget = event.getTarget();

		boolean hasDemonRing = false;
		boolean hasFrostRing = false;
		boolean hasBoth = false;

		if (event.getEntity() == attacker && attacker instanceof Player && event.getTarget() == checkedtarget
				&& checkedtarget instanceof LivingEntity) {

			Player player = (Player) event.getEntity();
			LivingEntity target = (LivingEntity) event.getTarget();

			int hotbarcheck;
			for (hotbarcheck = 0; hotbarcheck < 9; hotbarcheck++) {

				if (player.getInventory().getItem(hotbarcheck).getItem().equals(OPWItems.demon_ring.get())
						|| player.getOffhandItem().getItem().equals(OPWItems.demon_ring.get())) {
					hasDemonRing = true;
				}
				if (player.getInventory().getItem(hotbarcheck).getItem().equals(OPWItems.frost_ring.get())
						|| player.getOffhandItem().getItem().equals(OPWItems.frost_ring.get())) {
					hasFrostRing = true;
				}

				if (hasDemonRing && hasFrostRing) {
					hasBoth = true;
				}
			}

			if (hasDemonRing && hasBoth == false) {
				if (attacker != null && attacker.getMainHandItem().isEmpty()) {
					DamageSource ds = DamageSource.ON_FIRE;

					target.hurt(ds, 1F);
					target.setSecondsOnFire(5);
				}
			}
			if (hasFrostRing && !hasBoth) {
				if (attacker != null && attacker.getMainHandItem().isEmpty()) {
					DamageSource ds = DamageSource.FREEZE;

					target.hurt(ds, 1F);

					target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 100));
					target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 3));
					target.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 3));
					target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0));
					target.addEffect(new MobEffectInstance(MobEffects.JUMP, 40, 200));

				}
			}

		}
	}

}
