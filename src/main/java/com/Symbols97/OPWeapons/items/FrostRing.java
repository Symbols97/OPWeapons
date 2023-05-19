package com.Symbols97.OPWeapons.items;

import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.world.dimension.OPWDimensions;
import com.Symbols97.OPWeapons.world.dimension.portal.BasicTeleporter;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FrostRing extends Item {

	public FrostRing(Properties p_41383_) {
		super(p_41383_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		int x = player.blockPosition().getX();
		int y = player.blockPosition().getY();
		int z = player.blockPosition().getZ();
		player.teleportTo(x, y + 100, z);

		if (player instanceof Player) {
			if (player.level instanceof ServerLevel serverlevel) {
				
				//if (!Management.isinDZ) {
					Level playerWorld = player.level;
					if (playerWorld != null) {
						MinecraftServer minecraftserver = playerWorld.getServer();
						ResourceKey<Level> destination = player.level.dimension() == OPWDimensions.FZ_KEY ? Level.OVERWORLD : OPWDimensions.FZ_KEY;
						if (minecraftserver != null) {
							ServerLevel destinationWorld = minecraftserver.getLevel(destination);
							if (destinationWorld != null && minecraftserver.isNetherEnabled() && !player.isPassenger()) {
								
								
								 player.changeDimension(destinationWorld, new BasicTeleporter(destinationWorld));
								 
								 String destinationString = player.level.dimension() == OPWDimensions.FZ_KEY ? "§bFrost Zone" : "§fOverworld";
								 
								 player.displayClientMessage(Component.literal(String.format("You have been teleported to the: %s", destinationString)), false);
							}
						}
					}

				//}

			}
		}
		
		
		return super.use(level, player, hand);
	}
	
	
	@Override
	public void inventoryTick(ItemStack item, Level p_41405_, Entity entity, int p_41407_, boolean p_41408_) {
	
		if (entity instanceof Player) {
			Player player = (Player) entity;
			
			if(player.getMainHandItem().getItem().equals(OPWItems.frost_ring.get()) || player.getOffhandItem().getItem().equals(OPWItems.frost_ring.get())) {
				player.fallDistance = 0;
			}
			
		}
		
		super.inventoryTick(item, p_41405_, entity, p_41407_, p_41408_);
	}

}