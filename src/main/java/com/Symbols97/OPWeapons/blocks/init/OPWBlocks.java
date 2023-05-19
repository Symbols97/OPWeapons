package com.Symbols97.OPWeapons.blocks.init;

import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import javax.annotation.Nullable;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.DeadZonePortal;
import com.Symbols97.OPWeapons.blocks.DemonFurnace;
import com.Symbols97.OPWeapons.blocks.DemonSaplingBlock;
import com.Symbols97.OPWeapons.blocks.DemonStatue;
import com.Symbols97.OPWeapons.blocks.Freezer;
import com.Symbols97.OPWeapons.blocks.FrostSaplingBlock;
import com.Symbols97.OPWeapons.blocks.FrostZonePortal;
import com.Symbols97.OPWeapons.blocks.OPCraftingStation;
import com.Symbols97.OPWeapons.blocks.OPFurnace;
import com.Symbols97.OPWeapons.blocks.OPWFlammableRotatedPillarBlock;
import com.Symbols97.OPWeapons.blocks.RepairStation;
import com.Symbols97.OPWeapons.blocks.RepairStationv2;
import com.Symbols97.OPWeapons.blocks.TheForge;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.world.features.Trees.DemonTreeGrower;
import com.Symbols97.OPWeapons.world.features.Trees.FrostTreeGrower;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OPWBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OPWeapons.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = OPWItems.ITEMS;

	public static ToIntFunction<BlockState> orelightLevel = BlockState -> 6;

	public static ToIntFunction<BlockState> soulblocklightLevel = BlockState -> 9;

	public static ToIntFunction<BlockState> lamps = BlockState -> 14;

	public static final RegistryObject<Block> op_gem_ore = registerBlock("op_gem_ore", () -> new Block(
			BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(5.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel(orelightLevel)),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> steel_scrap_ore = registerBlock("steel_scrap_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(5.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> demon_gold_ore = registerBlock("demon_gold_ore", () -> new Block(
			BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(7.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel(orelightLevel)),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> frost_gold_ore = registerBlock("frost_gold_ore", () -> new Block(
			BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(7.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel(orelightLevel)),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> op_crafting_station = registerBlock("op_crafting_station",
			() -> new OPCraftingStation(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(2.0f).sound(SoundType.WOOD)), OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> block_of_op_gem = registerBlock("block_of_op_gem",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GREEN).strength(5.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> block_of_demon_gem = registerBlock("block_of_demon_gem",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(5.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> condensedbodg = registerBlock("condensedbodg",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> block_of_frost_gem = registerBlock("block_of_frost_gem",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).strength(5.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> condensedbofg = registerBlock("condensedbofg",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(3.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> block_of_lost_gem = registerBlock("block_of_lost_gem",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(5.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> block_o_enchanting = registerBlock("block_o_enchanting",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(10.0f).sound(SoundType.METAL).requiresCorrectToolForDrops(),
					UniformInt.of(100000, 100000)),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> repair_station = registerBlock("repair_station",
			() -> new RepairStation(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(2.0f).sound(SoundType.WOOD).noOcclusion()),
			OPWeapons.tabOPWeapons, "§7Repair your tools and weapons");

	public static final RegistryObject<Block> repair_station_v2 = registerBlock("repair_station_v2",
			() -> new RepairStationv2(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).strength(2.0f).sound(SoundType.WOOD).noOcclusion()),
			OPWeapons.tabOPWeapons, "§7Repair your tools and weapons");

	public static final RegistryObject<Block> the_forge = registerBlock("the_forge",
			() -> new TheForge(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(2.0f).sound(SoundType.STONE)), OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> soul_ore = registerBlock("soul_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY)
			.strength(5.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel(soulblocklightLevel)), OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> frozen_soul_ore = registerBlock("frozen_soul_ore", () -> new Block(BlockBehaviour.Properties
			.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(5.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel(soulblocklightLevel)),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> demon_light = registerBlock("demon_light",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(5.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel(lamps)),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> frost_light = registerBlock("frost_light",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(5.0f).sound(SoundType.STONE).requiresCorrectToolForDrops().lightLevel(lamps)),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> demon_log = registerBlock("demon_log",
			() -> new OPWFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(0.5f).sound(SoundType.WOOD)), OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> demon_wood = registerBlock("demon_wood",
			() -> new OPWFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(0.5f).sound(SoundType.WOOD)), OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> stripped_demon_log = registerBlock("stripped_demon_log",
			() -> new OPWFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(0.5f).sound(SoundType.WOOD)), OPWeapons.tabOPWeapons);

	 public static final RegistryObject<Block> demon_planks = registerBlock("demon_planks",
	            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(0.5f)) {
	                @Override
	                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
	                    return true;
	                }

	                @Override
	                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
	                    return 20;
	                }

	                @Override
	                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
	                    return 5;
	                }
	            }, OPWeapons.tabOPWeapons);
	 
	 public static final RegistryObject<Block> demon_leaves = registerBlock("demon_leaves",
	            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.3f)) {
	                @Override
	                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
	                    return true;
	                }

	                @Override
	                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
	                    return 60;
	                }

	                @Override
	                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
	                    return 30;
	                }
	            }, OPWeapons.tabOPWeapons);
	
	 public static final RegistryObject<Block> demon_sapling = registerBlock("demon_sapling",
				() -> new DemonSaplingBlock(new DemonTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), OPWeapons.tabOPWeapons);
	 
	 //Frost
	 public static final RegistryObject<Block> frost_log = registerBlock("frost_log",
				() -> new OPWFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(0.5f).sound(SoundType.WOOD)), OPWeapons.tabOPWeapons);

		public static final RegistryObject<Block> frost_wood = registerBlock("frost_wood",
				() -> new OPWFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(0.5f).sound(SoundType.WOOD)), OPWeapons.tabOPWeapons);

		public static final RegistryObject<Block> stripped_frost_log = registerBlock("stripped_frost_log",
				() -> new OPWFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(0.5f).sound(SoundType.WOOD)), OPWeapons.tabOPWeapons);

		 public static final RegistryObject<Block> frost_planks = registerBlock("frost_planks",
		            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(0.5f)) {
		                @Override
		                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		                    return true;
		                }

		                @Override
		                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		                    return 20;
		                }

		                @Override
		                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		                    return 5;
		                }
		            }, OPWeapons.tabOPWeapons);
		 
		 public static final RegistryObject<Block> frost_leaves = registerBlock("frost_leaves",
		            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(0.3f)) {
		                @Override
		                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		                    return true;
		                }

		                @Override
		                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		                    return 60;
		                }

		                @Override
		                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		                    return 30;
		                }
		            }, OPWeapons.tabOPWeapons);
		
		 public static final RegistryObject<Block> frost_sapling = registerBlock("frost_sapling",
					() -> new FrostSaplingBlock(new FrostTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), OPWeapons.tabOPWeapons);
	 
	 
	public static final RegistryObject<Block> demon_statue = registerBlock("demon_statue", () -> new DemonStatue(BlockBehaviour.Properties
			.of(Material.STONE, MaterialColor.COLOR_RED).strength(0.0f).sound(SoundType.STONE).noOcclusion()),
			OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> op_furnace = registerBlock("op_furnace",
			() -> new OPFurnace(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).strength(1.5f).sound(SoundType.STONE)), OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> demon_furnace = registerBlock("demon_furnace",
			() -> new DemonFurnace(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).strength(1.5f).sound(SoundType.STONE)), OPWeapons.tabOPWeapons);

	public static final RegistryObject<Block> freezer = registerBlock("freezer",
			() -> new Freezer(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_BLUE).strength(1.5f).sound(SoundType.METAL).noOcclusion()), OPWeapons.tabOPWeapons);

	// Portal Blocks
	public static final RegistryObject<Block> dead_zone_portal_block = registerBlockWithoutBlockItem("dead_zone_portal_block", DeadZonePortal::new);

	public static final RegistryObject<Block> frost_zone_portal_block = registerBlockWithoutBlockItem("frost_zone_portal_block", FrostZonePortal::new);

	private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltipKey) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab, tooltipKey);
		return toReturn;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, String tooltipKey) {
		return OPWItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)) {
			@Override
			public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
				pTooltip.add(Component.translatable(tooltipKey));
				
			}
		});
	}

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab);
		return toReturn;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
		return OPWItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
