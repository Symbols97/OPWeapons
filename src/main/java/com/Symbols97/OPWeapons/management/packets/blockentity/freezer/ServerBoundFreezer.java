package com.Symbols97.OPWeapons.management.packets.blockentity.freezer;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

import com.Symbols97.OPWeapons.blocks.entity.FreezerBlockEntity;
import com.Symbols97.OPWeapons.management.packets.PacketHandler;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

public class ServerBoundFreezer {
	
	public BlockPos freezerpos;
	private FreezerBlockEntity.Mode mode;

	public ServerBoundFreezer(FreezerBlockEntity tile) {
		freezerpos = tile.getBlockPos();
		mode = tile.getMode();
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBlockPos(freezerpos);
		buffer.writeShort(mode.ordinal());
	}

	public ServerBoundFreezer(FriendlyByteBuf buffer) {
		freezerpos = buffer.readBlockPos();
		short ordinal = buffer.readShort();
		mode = FreezerBlockEntity.Mode.values()[ordinal];
	}

	public boolean handle(Supplier<NetworkEvent.Context> ctx) {
		final var success = new AtomicBoolean(false);
		ctx.get().enqueueWork(() -> {
			final BlockEntity blockentity = ctx.get().getSender().level.getBlockEntity(freezerpos);
			if (blockentity instanceof FreezerBlockEntity) {
				FreezerBlockEntity freezer = (FreezerBlockEntity) blockentity;
				freezer.setMode(mode);
				PacketHandler.Instance.send(PacketDistributor.ALL.noArg(), new ClientBoundFreezer(mode, freezerpos));
				success.set(true);
			}
		});
		
		ctx.get().setPacketHandled(true);
		return success.get();
	}
}
