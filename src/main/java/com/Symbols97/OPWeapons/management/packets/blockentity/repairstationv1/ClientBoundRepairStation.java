package com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv1;

import java.util.function.Supplier;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.entity.RepairStationBlockEntity;
import com.Symbols97.OPWeapons.screen.repairstation.RepairStationMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class ClientBoundRepairStation {
	
	public BlockPos repairstationpos;
	private RepairStationBlockEntity.Mode mode;

	public ClientBoundRepairStation(RepairStationBlockEntity.Mode mode, BlockPos pos) {
		this.repairstationpos = pos;
		this.mode = mode;
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBlockPos(repairstationpos);
		buffer.writeShort(mode.ordinal());
	}

	public ClientBoundRepairStation(FriendlyByteBuf buffer) {
		repairstationpos = buffer.readBlockPos();
		short ordinal = buffer.readShort();
		mode = RepairStationBlockEntity.Mode.values()[ordinal];
	}

	 @SuppressWarnings("resource")
	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	        NetworkEvent.Context context = supplier.get();
	        context.enqueueWork( () -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
	            if(Minecraft.getInstance().level.getBlockEntity(repairstationpos) instanceof RepairStationBlockEntity blockEntity) {
	            	  blockEntity.setMode(mode);
	            	  OPWeapons.LOGGER.info("working2");
	                if(Minecraft.getInstance().player.containerMenu instanceof RepairStationMenu menu &&
	                    menu.getBlockEntity().getBlockPos().equals(repairstationpos)) {
	                	  blockEntity.setMode(mode);
	                	  OPWeapons.LOGGER.info("working3");
	                }
	            }
	        }));
	        return true;
	    }
	}