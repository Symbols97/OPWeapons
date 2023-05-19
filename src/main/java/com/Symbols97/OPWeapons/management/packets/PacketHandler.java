package com.Symbols97.OPWeapons.management.packets;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.management.packets.blockentity.freezer.ClientBoundFreezer;
import com.Symbols97.OPWeapons.management.packets.blockentity.freezer.ServerBoundFreezer;
import com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv1.ClientBoundRepairStation;
import com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv1.ServerBoundRepairStation;
import com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv2.ClientBoundRepairStationV2;
import com.Symbols97.OPWeapons.management.packets.blockentity.repairstationv2.ServerBoundRepairStationV2;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public final class PacketHandler {

	private PacketHandler() {

	}

	private static final String PROTOCOL_VERSION = "1";

	public static final SimpleChannel Instance = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(OPWeapons.MOD_ID, "packets"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void init() {

		int index = 0;
		//Repair Station
		Instance.messageBuilder(ServerBoundRepairStation.class, index++, NetworkDirection.PLAY_TO_SERVER)
				.encoder(ServerBoundRepairStation::encode)
				.decoder(ServerBoundRepairStation::new)
				.consumerMainThread(ServerBoundRepairStation::handle)
				.add();
		Instance.messageBuilder(ClientBoundRepairStation.class, index++, NetworkDirection.PLAY_TO_CLIENT)
		.encoder(ClientBoundRepairStation::encode)
		.decoder(ClientBoundRepairStation::new)
		.consumerMainThread(ClientBoundRepairStation::handle)
		.add();
		
		//RepairStation V2
		Instance.messageBuilder(ServerBoundRepairStationV2.class, index++, NetworkDirection.PLAY_TO_SERVER)
				.encoder(ServerBoundRepairStationV2::encode)
				.decoder(ServerBoundRepairStationV2::new)
				.consumerMainThread(ServerBoundRepairStationV2::handle)
				.add();
		
		Instance.messageBuilder(ClientBoundRepairStationV2.class, index++, NetworkDirection.PLAY_TO_CLIENT)
		.encoder(ClientBoundRepairStationV2::encode)
		.decoder(ClientBoundRepairStationV2::new)
		.consumerMainThread(ClientBoundRepairStationV2::handle)
		.add();
		
		
		//Freezer
		Instance.messageBuilder(ServerBoundFreezer.class, index++, NetworkDirection.PLAY_TO_SERVER)
				.encoder(ServerBoundFreezer::encode)
				.decoder(ServerBoundFreezer::new)
				.consumerMainThread(ServerBoundFreezer::handle)
				.add();

		Instance.messageBuilder(ClientBoundFreezer.class, index++, NetworkDirection.PLAY_TO_CLIENT)
				.encoder(ClientBoundFreezer::encode)
				.decoder(ClientBoundFreezer::new)
				.consumerMainThread(ClientBoundFreezer::handle)
				.add();

	}
}
