package com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import com.Symbols97.OPWeapons.blocks.entity.RepairStationBlockEntity;
import com.Symbols97.OPWeapons.management.packets.PacketHandler;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

public class ServerBoundRepairStation {

	public BlockPos repairstationpos;
	private RepairStationBlockEntity.Mode mode;

	public ServerBoundRepairStation(RepairStationBlockEntity tile) {
		repairstationpos = tile.getBlockPos();
		mode = tile.getMode();
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBlockPos(repairstationpos);
		buffer.writeShort(mode.ordinal());
	}

	public ServerBoundRepairStation(FriendlyByteBuf buffer) {
		repairstationpos = buffer.readBlockPos();
		short ordinal = buffer.readShort();
		mode = RepairStationBlockEntity.Mode.values()[ordinal];
	}

	public boolean handle(Supplier<NetworkEvent.Context> ctx) {
		final var success = new AtomicBoolean(false);
		ctx.get().enqueueWork(() -> {
			final BlockEntity blockentity = ctx.get().getSender().level.getBlockEntity(repairstationpos);
			if (blockentity instanceof RepairStationBlockEntity) {
				RepairStationBlockEntity repairstation = (RepairStationBlockEntity) blockentity;
				repairstation.setMode(mode);
				PacketHandler.Instance.send(PacketDistributor.ALL.noArg(), new ClientBoundRepairStation(mode, repairstationpos));
				success.set(true);
			}
		});
		
		ctx.get().setPacketHandled(true);
		return success.get();
	}
}
