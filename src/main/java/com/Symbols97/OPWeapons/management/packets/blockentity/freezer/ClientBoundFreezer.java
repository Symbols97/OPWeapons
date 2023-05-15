package com.Symbols97.OPWeapons.management.packets.blockentity.freezer;

import java.util.function.Supplier;

import com.Symbols97.OPWeapons.blocks.entity.FreezerBlockEntity;
import com.Symbols97.OPWeapons.screen.freezer.FreezerMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class ClientBoundFreezer {

	public BlockPos freezerpos;
	private FreezerBlockEntity.Mode mode;

	public ClientBoundFreezer(FreezerBlockEntity.Mode mode, BlockPos pos) {
		this.freezerpos = pos;
		this.mode = mode;
	}

	public void encode(FriendlyByteBuf buffer) {
		buffer.writeBlockPos(freezerpos);
		buffer.writeShort(mode.ordinal());
	}

	public ClientBoundFreezer(FriendlyByteBuf buffer) {
		freezerpos = buffer.readBlockPos();
		short ordinal = buffer.readShort();
		mode = FreezerBlockEntity.Mode.values()[ordinal];
	}

	 @SuppressWarnings("resource")
	public boolean handle(Supplier<NetworkEvent.Context> supplier) {
	        NetworkEvent.Context context = supplier.get();
	        context.enqueueWork( () -> DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
	            if(Minecraft.getInstance().level.getBlockEntity(freezerpos) instanceof FreezerBlockEntity blockEntity) {
	            	  blockEntity.setMode(mode);
	                if(Minecraft.getInstance().player.containerMenu instanceof FreezerMenu menu &&
	                    menu.getBlockEntity().getBlockPos().equals(freezerpos)) {
	                	  blockEntity.setMode(mode);
	                }
	            }
	        }));
	        return true;
	    }
	}