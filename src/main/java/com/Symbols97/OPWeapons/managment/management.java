package com.Symbols97.OPWeapons.managment;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.Dimension.DimensionRegistry;
import com.Symbols97.OPWeapons.armor.FrostArmor;
import com.Symbols97.OPWeapons.weapons_tools.opBow;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class management {

	/*
	 * This methods checks if the player has joined the world before and if not
	 * gives them the OP Book, it also prints out the mod version and discord each
	 * time the player joins
	 */
	@SubscribeEvent
	public void firstJoin(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		NBTTagCompound entityData = player.getEntityData();
		if (!entityData.getBoolean("joinedBefore")) {
			entityData.setBoolean("joinedBefore", true);
			player.inventory.addItemStackToInventory(new ItemStack(OPWeapons.opWeaponsBook));
			// player.inventory.addItemStackToInventory(new ItemStack(OPWeapons.frostRing));
		}

		player.addChatMessage(new ChatComponentText(String.format("§aOPWeapons Version : %s", OPWeapons.ModVersion)));
		player.addChatMessage(new ChatComponentText(String.format("§6Join the Discord! §fhttps://discord.gg/qcqAA98")));
		ModLoadedChecker.successMessage(player);
	}

	// Enables flight
	public static void flightenable(EntityPlayer player) {
		player.capabilities.allowFlying = true;
	}

	// Disables flight
	public static void flightdisable(EntityPlayer player) {

		if (!player.capabilities.isCreativeMode) {
			player.capabilities.isFlying = false;
			player.capabilities.allowFlying = false;
		}

	}


	// adds mutton to sheep drops
	@SubscribeEvent
	public void onLivingDrop(LivingDropsEvent event) {
		if (event.entity instanceof EntitySheep) {
			ItemStack itemStackToDrop = new ItemStack(OPWeapons.mutton, 1);
			// event.drops.clear();
			event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY,
					event.entity.posZ, itemStackToDrop));
		}
	}

	// Immunity to Reaper Effects
	public static void reaperImmunity(EntityPlayer player) {
		player.removePotionEffect(Potion.poison.id);
		player.removePotionEffect(Potion.wither.id);
		player.removePotionEffect(Potion.moveSlowdown.id);
		player.removePotionEffect(Potion.weakness.id);
		player.removePotionEffect(Potion.digSlowdown.id);
		player.removePotionEffect(Potion.blindness.id);
		player.removePotionEffect(Potion.hunger.id);
		player.removePotionEffect(Potion.confusion.id);
	}

	// Immunity to Frost effects.
	public static void frostImmunity(EntityPlayer player) {
		player.removePotionEffect(Potion.moveSlowdown.id);
		player.removePotionEffect(Potion.weakness.id);
		player.removePotionEffect(Potion.digSlowdown.id);
		player.removePotionEffect(Potion.blindness.id);
	}

//	public static boolean invis = false;
//	@SubscribeEvent
//	public void reaperAbilities (PlayerTickEvent event) {
//		
//		if (event.player instanceof EntityPlayer) {
//			EntityPlayer player = (EntityPlayer) event.player;
//
//				if (invisRemote.active && !player.isSprinting() && player.getHeldItem() == null) {
//						player.addPotionEffect(new PotionEffect(Potion.invisibility.getId(),10,-1));
//						invis = true;
//						//player.addChatMessage(new ChatComponentText(String.format("On INVIS: "+invis)));
//						//player.addChatMessage(new ChatComponentText(String.format("On REMOTE: "+invisRemote.active)));
//									
//				} else {
//					invis = false;
//					//player.addChatMessage(new ChatComponentText(String.format("Off INVIS: "+invis)));
//					//player.addChatMessage(new ChatComponentText(String.format("Off REMOTE: "+invisRemote.active)));
//					}
//			
//				if (!ReaperArmor.iswearingReaperArmor) {
//						invisRemote.active = false;
//					}
//							
//					
//				}
//			}

	// If the player has the R.I.P. -> give player reaper immunity.
	@SubscribeEvent
	public void RIPgiveReaperImmunity(PlayerTickEvent event) {

		if (event.player instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.player;
			if (player.inventory.hasItemStack(new ItemStack(OPWeapons.reaperImmunityPatch))) {
				reaperImmunity(player);
			}
		}
	}

	public static boolean isinFZ;
	public static boolean isinDZ;
	public static boolean isinOverworld;

	// Checks if the player is in a specified dimension.
	@SubscribeEvent
	public void dimensionCheck(PlayerTickEvent event) {
		int FrostZone = DimensionRegistry.FZdimensionId; // (-999999999)
		int DeadZone = DimensionRegistry.DZdimensionId;

		if (event.player instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.player;
			// Frost ZOne
			if (player.worldObj.provider.dimensionId == FrostZone) {

				if (!FrostArmor.iswearingFrostArmor) {

					player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10, 3));
					player.addPotionEffect(new PotionEffect(Potion.weakness.id, 10, 3));
					player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 10, 3));

				}

				isinFZ = true;
			} else {
				isinFZ = false;
			}

			// Dead Zone
			if (player.worldObj.provider.dimensionId == DeadZone) {
				isinDZ = true;
			} else {
				isinDZ = false;
			}

			// Overworld
			if (player.worldObj.provider.dimensionId == 0) {
				isinOverworld = true;
			} else {
				isinOverworld = false;
			}

		}
	}

	@SubscribeEvent
	public void ringcheck(PlayerTickEvent event) {

		if (event.player instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.player;

			if (player.inventory.getCurrentItem() != null
					&& player.inventory.getCurrentItem().getItem() == (OPWeapons.frostRing)) {
				player.fallDistance = 0;
			} else if (player.inventory.getCurrentItem() != null
					&& player.inventory.getCurrentItem().getItem() == (OPWeapons.demonRing)) {
				player.fallDistance = 0;
			}
		}
	}

	// If the player has the Demon Hammer, grants effects
	@SubscribeEvent
	public void hammercheck(PlayerTickEvent event) {

		if (event.player instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.player;

			if (player.inventory.getCurrentItem() != null
					&& player.inventory.getCurrentItem().getItem() == (OPWeapons.demonHammer)) {
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 20, 1000));
			}
		}
	}

	// If the player has the Frost Axe, grants effects
	@SubscribeEvent
	public void frostaxecheck(PlayerTickEvent event) {

		if (event.player instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.player;

			if (player.inventory.getCurrentItem() != null
					&& player.inventory.getCurrentItem().getItem() == (OPWeapons.frostAxe)) {
				frostImmunity(player);

				World world = player.worldObj;
				int x = MathHelper.floor_double(player.posX);
				int y = MathHelper.floor_double(player.posY - 1);
				int z = MathHelper.floor_double(player.posZ);
				Material m = world.getBlock(x, y - 1, z).getMaterial();

				boolean flag = (m == Material.water);

				if (flag) {
					// player.posY += -player.motionY;
					player.motionY = 0.0D;

					// player.fallDistance = 0.0F;
				}

				if (flag && player.motionY == 0.0D) {
					if (!Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()) {
						player.motionY = 0.0D;
					} else if (Minecraft.getMinecraft().gameSettings.keyBindJump.getIsKeyPressed()) {
						player.motionY = 0.5D;
					}
					if (Minecraft.getMinecraft().gameSettings.keyBindSneak.getIsKeyPressed()) {

						player.motionY = -0.5D;

					}

				}
			}
		}
	}

	// Does the zoom effect for bows.
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onFOVUpdate(FOVUpdateEvent event) {
		if (event.entity.isUsingItem() && event.entity.getItemInUse() != null
				&& event.entity.getItemInUse().getItem() instanceof opBow) {
			float fovModifier = event.entity.getItemInUseDuration() / 20.0f;

			if (fovModifier > 1.0f) {
				fovModifier = 1.0f;
			} else {
				fovModifier *= fovModifier;
			}

			event.newfov = (event.fov * (1.0f - fovModifier * 0.15f));
		}
	}

	// Adds in custom Punches depending on if the player has a Faction Ring
	@SubscribeEvent
	public void customPunches(AttackEntityEvent event) {

		EntityLivingBase attacker = (EntityLivingBase) event.entityPlayer;
		Entity checkedtarget = event.target;

		boolean hasDemonRing = false;
		boolean hasFrostRing = false;
		boolean hasBoth = false;

		if (event.entityPlayer == attacker && attacker instanceof EntityPlayer && event.target == checkedtarget
				&& checkedtarget instanceof EntityLiving) {

			EntityPlayer player = (EntityPlayer) event.entityPlayer;
			EntityLivingBase target = (EntityLivingBase) event.target;

			int hotbarcheck;
			for (hotbarcheck = 0; hotbarcheck < 9; hotbarcheck++) {

				if (player.inventory.getStackInSlot(hotbarcheck) != null
						&& player.inventory.getStackInSlot(hotbarcheck).getItem().equals(OPWeapons.demonRing)) {
					hasDemonRing = true;
				}
				if (player.inventory.getStackInSlot(hotbarcheck) != null
						&& player.inventory.getStackInSlot(hotbarcheck).getItem().equals(OPWeapons.frostRing)) {
					hasFrostRing = true;
				}

				if (hasDemonRing && hasFrostRing) {
					hasBoth = true;
				}
			}

			if (hasDemonRing && hasBoth == false) {
				if (attacker != null && attacker.getHeldItem() == null) {
					DamageSource ds = DamageSource.magic;

					target.attackEntityFrom(ds, 1F);

					target.setFire(5);
				}
			}
			if (hasFrostRing && !hasBoth) {
				if (attacker != null && attacker.getHeldItem() == null) {
					DamageSource ds = DamageSource.magic;

					target.attackEntityFrom(ds, 1F);

					target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 100));
					target.addPotionEffect(new PotionEffect(Potion.weakness.id, 40, 3));
					target.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 40, 3));
					target.addPotionEffect(new PotionEffect(Potion.blindness.id, 40, 0));
					target.addPotionEffect(new PotionEffect(Potion.jump.id, 40, 200));

				}
			}
//			player.addChatMessage(new ChatComponentText(String.format("Has Both Rings = " + hasBoth)));
//			player.addChatMessage(new ChatComponentText(String.format("Has Demon Ring = " + hasDemonRing)));
//			player.addChatMessage(new ChatComponentText(String.format("Has Frost Ring = " + hasFrostRing)));

		}
	}

}
