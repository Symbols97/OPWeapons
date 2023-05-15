package com.Symbols97.OPWeapons.items;

import com.Symbols97.OPWeapons.Dimension.DimensionRegistry;
import com.Symbols97.OPWeapons.Dimension.DeadZone.DeadZoneTeleporter;
import com.Symbols97.OPWeapons.managment.management;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class DemonRing extends Item {

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entity) {
		
		
		
		if (entity instanceof EntityPlayerMP) {
			WorldServer worldserver = (WorldServer) world;
            EntityPlayerMP player = (EntityPlayerMP) entity;
            
            if (!management.isinDZ) {
            
            player.mcServer.getConfigurationManager().transferPlayerToDimension(player, DimensionRegistry.DZdimensionId, new DeadZoneTeleporter(worldserver));
            player.addChatMessage(new ChatComponentText(String.format("§cYou have been teleported to the Dead Zone")));
            
           
          
           
            } else if (management.isinDZ){
            	
             player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new DeadZoneTeleporter(worldserver));
             player.addChatMessage(new ChatComponentText(String.format("§fYou have been teleported to the Overworld")));
            }
            
             entity.posY = 150D;
 	}
		
		return itemStack;
	}
	
}
