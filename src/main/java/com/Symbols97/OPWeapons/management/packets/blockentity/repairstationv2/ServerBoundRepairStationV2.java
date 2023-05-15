package com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import com.Symbols97.OPWeapons.blocks.entity.RepairStationV2BlockEntity;
import com.Symbols97.OPWeapons.management.packets.PacketHandler;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

public class ServerBoundRepairStationV2 {
	
	public BlockPos repairstationv2pos;
	private RepairStationV2BlockEntity.Mode mode;

	public ServerBoundRepairStationV2(RepairStationV2BlockEntity tile) {
		repairstationv2pos = tile.getBlockPos();
		mode = tile.getMode();
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBlockPos(repairstationv2pos);
		buffer.writeShort(mode.ordinal());
	}

	public ServerBoundRepairStationV2(FriendlyByteBuf buffer) {
		repairstationv2pos = buffer.readBlockPos();
		short ordinal = buffer.readShort();
		mode = RepairStationV2BlockEntity.Mode.values()[ordinal];
	}

	public boolean handle(Supplier<NetworkEvent.Context> ctx) {
		final var success = new AtomicBoolean(false);
		ctx.get().enqueueWork(() -> {
			final BlockEntity blockentity = ctx.get().getSender().level.getBlockEntity(repairstationv2pos);
			if (blockentity instanceof RepairStationV2BlockEntity) {
				RepairStationV2BlockEntity repairstationv2 = (RepairStationV2BlockEntity) blockentity;
				PacketHandler.Instance.send(PacketDistributor.ALL.noArg(), new ClientBoundRepairStationV2(mode, repairstationv2pos));
				repairstationv2.setMode(mode);
				success.set(true);
			}
		});
		
		ctx.get().setPacketHandled(true);
		return success.get();
	}
}