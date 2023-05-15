package com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv2;

import java.util.function.Supplier;

import com.Symbols97.OPWeapons.blocks.entity.RepairStationV2BlockEntity;
import com.Symbols97.OPWeapons.screen.repairstationv2.RepairStationV2Menu;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class ClientBoundRepairStationV2 {
	
	public BlockPos repairstationv2pos;
	private RepairStationV2BlockEntity.Mode mode;

	public ClientBoundRepairStationV2(RepairStationV2BlockEntity.Mode mode, BlockPos pos) {
		this.repairstationv2pos = pos;
		this.mode = mode;
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBlockPos(repairstationv2pos);
		buffer.writeShort(mode.ordinal());
	}

	public ClientBoundRepairStationV2(FriendlyByteBuf buffer) {
		repairstationv2pos = buffer.readBlockPos();
		short ordinal = buffer.readShort();
		mode = RepairStationV2BlockEntity.Mode.values()[ordinal];
	}

	 @SuppressWarnings("resource")
	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	        NetworkEvent.Context context = supplier.get();
	        context.enqueueWork( () -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
	            if(Minecraft.getInstance().level.getBlockEntity(repairstationv2pos) instanceof RepairStationV2BlockEntity blockEntity) {
	            	  blockEntity.setMode(mode);
	                if(Minecraft.getInstance().player.containerMenu instanceof RepairStationV2Menu menu &&
	                    menu.getBlockEntity().getBlockPos().equals(repairstationv2pos)) {
	                	  blockEntity.setMode(mode);
	                }
	            }
	        }));
	        return true;
	    }
	}