package com.Symbols97.OPWeapons.blocks.init;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.entity.DemonFurnaceBlockEntity;
import com.Symbols97.OPWeapons.blocks.entity.FreezerBlockEntity;
import com.Symbols97.OPWeapons.blocks.entity.OPFurnaceBlockEntity;
import com.Symbols97.OPWeapons.blocks.entity.RepairStationBlockEntity;
import com.Symbols97.OPWeapons.blocks.entity.RepairStationV2BlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntities {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITY_TYPES, OPWeapons.MOD_ID);

    public static final RegistryObject<BlockEntityType<RepairStationBlockEntity>> repair_station_block_entity =
            BLOCK_ENTITIES.register("repair_station_block_entity", () ->
                    BlockEntityType.Builder.of(RepairStationBlockEntity::new,
                            OPWBlocks.repair_station.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<RepairStationV2BlockEntity>> repair_station_v2_block_entity =
            BLOCK_ENTITIES.register("repair_station_v2_block_entity", () ->
                    BlockEntityType.Builder.of(RepairStationV2BlockEntity::new,
                            OPWBlocks.repair_station_v2.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<OPFurnaceBlockEntity>> op_furnace_block_entity =
            BLOCK_ENTITIES.register("op_furnace_block_entity", () ->
                    BlockEntityType.Builder.of(OPFurnaceBlockEntity::new,
                            OPWBlocks.op_furnace.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<DemonFurnaceBlockEntity>> demon_furnace_block_entity =
            BLOCK_ENTITIES.register("demon_furnace_block_entity", () ->
                    BlockEntityType.Builder.of(DemonFurnaceBlockEntity::new,
                            OPWBlocks.demon_furnace.get()).build(null));
    
    public static final RegistryObject<BlockEntityType<FreezerBlockEntity>> freezer_block_entity =
            BLOCK_ENTITIES.register("freezer_block_entity", () ->
                    BlockEntityType.Builder.of(FreezerBlockEntity::new,
                            OPWBlocks.freezer.get()).build(null));

	public static void register(IEventBus eventBus) {
		BLOCK_ENTITIES.register(eventBus);
	}

}