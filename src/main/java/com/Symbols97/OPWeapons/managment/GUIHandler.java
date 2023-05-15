package com.Symbols97.OPWeapons.managment;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.TileEntity.TileEntityDemonFurnace;
import com.Symbols97.OPWeapons.TileEntity.TileEntityFreezer;
import com.Symbols97.OPWeapons.TileEntity.TileEntityOPFurnace;
import com.Symbols97.OPWeapons.TileEntity.TileEntityRepairStation;
import com.Symbols97.OPWeapons.TileEntity.TileEntityRepairStationV2;
import com.Symbols97.OPWeapons.TileEntity.TileEntityTheForge;
import com.Symbols97.OPWeapons.containers.ContainerDemonFurnace;
import com.Symbols97.OPWeapons.containers.ContainerFreezer;
import com.Symbols97.OPWeapons.containers.ContainerOPFurnace;
import com.Symbols97.OPWeapons.containers.ContainerTheForge;
import com.Symbols97.OPWeapons.containers.OPCraftingStationContainer;
import com.Symbols97.OPWeapons.containers.RepairStationContainer;
import com.Symbols97.OPWeapons.containers.RepairStationContainerV2;
import com.Symbols97.OPWeapons.gui.GUIDemonFurnace;
import com.Symbols97.OPWeapons.gui.GUIFreezer;
import com.Symbols97.OPWeapons.gui.GUIOPCraftingStation;
import com.Symbols97.OPWeapons.gui.GUIOPFurnace;
import com.Symbols97.OPWeapons.gui.GUIRepairStation;
import com.Symbols97.OPWeapons.gui.GUIRepairStationV2;
import com.Symbols97.OPWeapons.gui.GUITheForge;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler {
	
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case OPWeapons.GUIRepairStationV2:
				if (entity instanceof TileEntityRepairStationV2) {
					return ID == OPWeapons.GUIRepairStationV2 && world.getBlock(x, y, z) == OPWeapons.repairstationV2 ? new RepairStationContainerV2(player.inventory, world, x, y, z) : null;
				}
				return null;
				
			case OPWeapons.GUIRepairStation:
				if (entity instanceof TileEntityRepairStation) {
					return ID == OPWeapons.GUIRepairStation && world.getBlock(x, y, z) == OPWeapons.repairstation ? new RepairStationContainer(player.inventory, world, x, y, z) : null;
				}
			case OPWeapons.GUIOPFurnace:
				if (entity instanceof TileEntityOPFurnace) {
					return new ContainerOPFurnace(player.inventory, (TileEntityOPFurnace) entity);
				}
			case OPWeapons.GUITheForge:
				if (entity instanceof TileEntityTheForge) {
					return ID == OPWeapons.GUITheForge && world.getBlock(x, y, z) == OPWeapons.TheForge ? new ContainerTheForge(player.inventory, world, x, y, z) : null;
				}
			case OPWeapons.GUIDemonFurnace:
				if (entity instanceof TileEntityDemonFurnace) {
					return new ContainerDemonFurnace(player.inventory, (TileEntityDemonFurnace) entity);
				}
			case OPWeapons.GUIFreezer:
				if (entity instanceof TileEntityFreezer) {
					return new ContainerFreezer(player.inventory, (TileEntityFreezer) entity);
				}
				
				
				//return null;
			}
			}
		if(ID == OPWeapons.GUIOPCraftingStation) {
			return ID == OPWeapons.GUIOPCraftingStation && world.getBlock(x, y, z) == OPWeapons.OPcraftingstation ? new OPCraftingStationContainer(player.inventory, world, x, y, z) : null;
		}
		
		return null;
		
	}


	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case OPWeapons.GUIRepairStationV2:
				if (entity instanceof TileEntityRepairStationV2) {
					return ID == OPWeapons.GUIRepairStationV2 && world.getBlock(x, y, z) == OPWeapons.repairstationV2 ? new GUIRepairStationV2(player.inventory, world, x, y, z) : null;
				}
				return null;
				
			case OPWeapons.GUIRepairStation:
				if (entity instanceof TileEntityRepairStation) {
					return ID == OPWeapons.GUIRepairStation && world.getBlock(x, y, z) == OPWeapons.repairstation ? new GUIRepairStation(player.inventory, world, x, y, z) : null;
				}
			case OPWeapons.GUIOPFurnace:
				if (entity instanceof TileEntityOPFurnace) {
					return new GUIOPFurnace(player.inventory, (TileEntityOPFurnace) entity);

				}
			case OPWeapons.GUITheForge:
				if (entity instanceof TileEntityTheForge) {
					return ID == OPWeapons.GUITheForge && world.getBlock(x, y, z) == OPWeapons.TheForge ? new GUITheForge(player.inventory, world, x, y, z) : null;
				}
				
			case OPWeapons.GUIDemonFurnace:
				if (entity instanceof TileEntityDemonFurnace) {
					return new GUIDemonFurnace(player.inventory, (TileEntityDemonFurnace) entity);
				}
			case OPWeapons.GUIFreezer:
				if (entity instanceof TileEntityFreezer) {
					return new GUIFreezer(player.inventory, (TileEntityFreezer) entity);
				}
				
				//return null;
			}
			}
		if(ID == OPWeapons.GUIOPCraftingStation) {
			return ID == OPWeapons.GUIOPCraftingStation && world.getBlock(x, y, z) == OPWeapons.OPcraftingstation ? new GUIOPCraftingStation(player.inventory, world, x, y, z) : null;
		}
		
		return null;
	}

}
