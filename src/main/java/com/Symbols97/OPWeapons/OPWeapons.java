package com.Symbols97.OPWeapons;

import com.Symbols97.OPWeapons.Commands.spawnArmor;
import com.Symbols97.OPWeapons.Dimension.DimensionRegistry;
import com.Symbols97.OPWeapons.TileEntity.TileEntityDemonFurnace;
import com.Symbols97.OPWeapons.TileEntity.TileEntityFreezer;
import com.Symbols97.OPWeapons.TileEntity.TileEntityOPFurnace;
import com.Symbols97.OPWeapons.TileEntity.TileEntityRepairStation;
import com.Symbols97.OPWeapons.TileEntity.TileEntityRepairStationV2;
import com.Symbols97.OPWeapons.TileEntity.TileEntityTheForge;
import com.Symbols97.OPWeapons.armor.DemonArmor;
import com.Symbols97.OPWeapons.armor.FrostArmor;
import com.Symbols97.OPWeapons.armor.LostArmor;
import com.Symbols97.OPWeapons.armor.OPArmor;
import com.Symbols97.OPWeapons.armor.ReaperArmor;
import com.Symbols97.OPWeapons.biome.BiomeRegistry;
import com.Symbols97.OPWeapons.biome.DeadZone.WorldTypeDeadZone;
import com.Symbols97.OPWeapons.blocks.BlockOfLostGem;
import com.Symbols97.OPWeapons.blocks.BlockofFrostGem;
import com.Symbols97.OPWeapons.blocks.DeadZonePortal;
import com.Symbols97.OPWeapons.blocks.DemonGoldOre;
import com.Symbols97.OPWeapons.blocks.FrostGoldOre;
import com.Symbols97.OPWeapons.blocks.FrostZonePortal;
import com.Symbols97.OPWeapons.blocks.OPWStairs;
import com.Symbols97.OPWeapons.blocks.SteelScrapOre;
import com.Symbols97.OPWeapons.blocks.blockoenchanting;
import com.Symbols97.OPWeapons.blocks.blockofdemongem;
import com.Symbols97.OPWeapons.blocks.blockofopGem;
import com.Symbols97.OPWeapons.blocks.condensedbodg;
import com.Symbols97.OPWeapons.blocks.condensedbofg;
import com.Symbols97.OPWeapons.blocks.demonLight;
import com.Symbols97.OPWeapons.blocks.frostLight;
import com.Symbols97.OPWeapons.blocks.frozensoulBlock;
import com.Symbols97.OPWeapons.blocks.opcraftingstation;
import com.Symbols97.OPWeapons.blocks.opgemOre;
import com.Symbols97.OPWeapons.blocks.repairstation;
import com.Symbols97.OPWeapons.blocks.repairstationV2;
import com.Symbols97.OPWeapons.blocks.soulBlock;
import com.Symbols97.OPWeapons.blocks.theforge;
import com.Symbols97.OPWeapons.blocks.machines.DemonFurnace;
import com.Symbols97.OPWeapons.blocks.machines.Freezer;
import com.Symbols97.OPWeapons.blocks.machines.OPFurnace;
import com.Symbols97.OPWeapons.blocks.trees.OPWLeafItemBlocks;
import com.Symbols97.OPWeapons.blocks.trees.OPWLeaves;
import com.Symbols97.OPWeapons.blocks.trees.OPWLogItemBlocks;
import com.Symbols97.OPWeapons.blocks.trees.OPWLogs;
import com.Symbols97.OPWeapons.blocks.trees.OPWSaplingItemBlocks;
import com.Symbols97.OPWeapons.blocks.trees.OPWSaplings;
import com.Symbols97.OPWeapons.blocks.trees.OPW_Wood;
import com.Symbols97.OPWeapons.blocks.trees.OPW_WoodItemBlocks;
import com.Symbols97.OPWeapons.books.OPDemonBook;
import com.Symbols97.OPWeapons.books.OPFoodBook;
import com.Symbols97.OPWeapons.books.OPFrostBook;
import com.Symbols97.OPWeapons.books.OPLoreBookComplete;
import com.Symbols97.OPWeapons.books.OPLoreBookIncomplete;
import com.Symbols97.OPWeapons.books.OPWeaponsBook;
import com.Symbols97.OPWeapons.books.OPWeaponsBook2;
import com.Symbols97.OPWeapons.crafting.NEI.NEIIntergration;
import com.Symbols97.OPWeapons.food.HotCoffee;
import com.Symbols97.OPWeapons.food.IceCoffee;
import com.Symbols97.OPWeapons.food.MagicFood;
import com.Symbols97.OPWeapons.food.PetFood;
import com.Symbols97.OPWeapons.food.SpicyChicken;
import com.Symbols97.OPWeapons.food.cookedMutton;
import com.Symbols97.OPWeapons.food.magicMutton;
import com.Symbols97.OPWeapons.food.mutton;
import com.Symbols97.OPWeapons.food.snowCone;
import com.Symbols97.OPWeapons.items.AxeBlade;
import com.Symbols97.OPWeapons.items.AxeHandle;
import com.Symbols97.OPWeapons.items.ClubHandle;
import com.Symbols97.OPWeapons.items.ClubHead;
import com.Symbols97.OPWeapons.items.DemonGemCore;
import com.Symbols97.OPWeapons.items.DemonGold;
import com.Symbols97.OPWeapons.items.DemonRing;
import com.Symbols97.OPWeapons.items.DemonVial;
import com.Symbols97.OPWeapons.items.FrostGold;
import com.Symbols97.OPWeapons.items.FrostRing;
import com.Symbols97.OPWeapons.items.FrostVial;
import com.Symbols97.OPWeapons.items.HammerHandle;
import com.Symbols97.OPWeapons.items.HammerHead;
import com.Symbols97.OPWeapons.items.HandleBase;
import com.Symbols97.OPWeapons.items.HandleGrip;
import com.Symbols97.OPWeapons.items.HandleHilt;
import com.Symbols97.OPWeapons.items.HellStick;
import com.Symbols97.OPWeapons.items.NetherShard;
import com.Symbols97.OPWeapons.items.OPVial;
import com.Symbols97.OPWeapons.items.RepairModule;
import com.Symbols97.OPWeapons.items.UltimateNetherStar;
import com.Symbols97.OPWeapons.items.capsule;
import com.Symbols97.OPWeapons.items.crimsonblade;
import com.Symbols97.OPWeapons.items.deathEssence;
import com.Symbols97.OPWeapons.items.defrostedSoul;
import com.Symbols97.OPWeapons.items.demonGem;
import com.Symbols97.OPWeapons.items.firecapsule;
import com.Symbols97.OPWeapons.items.frostBlade;
import com.Symbols97.OPWeapons.items.frostGem;
import com.Symbols97.OPWeapons.items.frostgemcore;
import com.Symbols97.OPWeapons.items.froststick;
import com.Symbols97.OPWeapons.items.frozenSoul;
import com.Symbols97.OPWeapons.items.goldParticle;
import com.Symbols97.OPWeapons.items.lapizArrow;
import com.Symbols97.OPWeapons.items.lostPages;
import com.Symbols97.OPWeapons.items.lostgem;
import com.Symbols97.OPWeapons.items.miniSoul;
import com.Symbols97.OPWeapons.items.neutralcore;
import com.Symbols97.OPWeapons.items.opFlintandSteel;
import com.Symbols97.OPWeapons.items.opGem;
import com.Symbols97.OPWeapons.items.opGemChunk;
import com.Symbols97.OPWeapons.items.opGemCore;
import com.Symbols97.OPWeapons.items.reaperImmunityPatch;
import com.Symbols97.OPWeapons.items.soulHarvester;
import com.Symbols97.OPWeapons.items.steelIngot;
import com.Symbols97.OPWeapons.items.steelPipe;
import com.Symbols97.OPWeapons.items.steelScrap;
import com.Symbols97.OPWeapons.items.syntheticGold;
import com.Symbols97.OPWeapons.items.torturedSoul;
import com.Symbols97.OPWeapons.items.triplePipe;
import com.Symbols97.OPWeapons.items.vent;
import com.Symbols97.OPWeapons.managment.GUIHandler;
import com.Symbols97.OPWeapons.managment.ModLoadedChecker;
import com.Symbols97.OPWeapons.managment.management;
import com.Symbols97.OPWeapons.managment.packets.PacketHandler;
import com.Symbols97.OPWeapons.mobs.EntityOPWeapons;
import com.Symbols97.OPWeapons.proxy.CommonProxy;
import com.Symbols97.OPWeapons.weapons_tools.DZStaff;
import com.Symbols97.OPWeapons.weapons_tools.FZStaff;
import com.Symbols97.OPWeapons.weapons_tools.OPHoe;
import com.Symbols97.OPWeapons.weapons_tools.OPPickaxe;
import com.Symbols97.OPWeapons.weapons_tools.OPShovel;
import com.Symbols97.OPWeapons.weapons_tools.OPSword;
import com.Symbols97.OPWeapons.weapons_tools.demonHammer;
import com.Symbols97.OPWeapons.weapons_tools.demonSlayer;
import com.Symbols97.OPWeapons.weapons_tools.fireSword;
import com.Symbols97.OPWeapons.weapons_tools.frostAxe;
import com.Symbols97.OPWeapons.weapons_tools.frostSlayer;
import com.Symbols97.OPWeapons.weapons_tools.iceSword;
import com.Symbols97.OPWeapons.weapons_tools.lostPickaxe;
import com.Symbols97.OPWeapons.weapons_tools.neutralStaff;
import com.Symbols97.OPWeapons.weapons_tools.opBow;
import com.Symbols97.OPWeapons.weapons_tools.opClub;
import com.Symbols97.OPWeapons.weapons_tools.opaxe;
import com.Symbols97.OPWeapons.weapons_tools.reaperscythe;
import com.Symbols97.OPWeapons.world.OPGeneration;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = "opweapons", name = "OPWeapons", version = OPWeapons.ModVersion)
public class OPWeapons {

	public final static String ModVersion = "8.2";
	
	// Items
	public static Item opGem;
	public static Item opGemChunk;
	public static Item hellStick;
	public static Item nethershard;
	public static Item ultimatenetherstar;
	public static Item demonGem;
	public static Item repairModule;
	public static Item opGemCore;
	public static Item DemonGemCore;
	public static Item lostgem;
	public static Item goldParticle;
	public static Item syntheticGold;
	public static Item capsule;
	public static Item firecapsule;
	public static Item neutralCore;
	public static Item crimsonBlade;
	public static Item frostgemcore;
	public static Item frostGem;
	public static Item frostBlade;
	public static Item froststick;
	public static Item miniSoul;
	public static Item torturedSoul;
	public static Item soulHarvester;
	public static Item lostPages;
	public static Item reaperImmunityPatch;
	public static Item deathEssence;
	public static Item HammerHead;
	public static Item HammerHandle;
	public static Item HandleBase;
	public static Item HandleGrip;
	public static Item HandleHilt;
	public static Item ClubHead;
	public static Item ClubHandle;
	public static Item AxeBlade;
	public static Item AxeHandle;
	public static Item lapizArrow;
	public static Item demonGold;
	public static Item frostGold;
	public static Item demonRing;
	public static Item frostRing;
	public static Item frozenSoul;
	public static Item defrostedSoul;
	public static Item steelScrap;
	public static Item steelIngot;
	public static Item steelPipe;
	public static Item triplePipe;
	public static Item vent;
	public static Item opFlintandSteel;
	
	
	public static Item OPVial;
	public static Item DemonVial;
	public static Item FrostVial;
	
	
	
	//Food
	public static Item mutton;
	public static Item cookedMutton;
	public static Item magicFood;
	public static Item magicMutton;
	public static Item spicyChicken;
	public static Item HotCoffee;
	public static Item snowCone;
	public static Item IceCoffee;
	public static Item petFood;
	
	//Books
	public static Item opWeaponsBook;
	public static Item opWeaponsBook2;
	public static Item opDemonBook;
	public static Item opFrostBook;
	public static Item opLoreBookIncomplete;
	public static Item opLoreBookComplete;
	public static Item opFoodBook;
	
	
	// Weapons
	public static Item opSword;
	public static Item demonSlayer;
	public static Item frostSlayer;
	public static Item fireSword;
	public static Item iceSword;
	public static Item reaperscythe;
	public static Item demonHammer;
	public static Item opClub;
	public static Item frostAxe;
	public static Item opBow;
	
	// Tools
	public static Item opPickaxe;
	public static Item opAxe;
	public static Item opHoe;
	public static Item opShovel;
	public static Item lostPickaxe;
	public static Item neutralStaff;
	public static Item DZStaff;
	public static Item FZStaff;
	
	
	

	// Blocks
	public static Block blockofopGem;
	public static Block blockofdemongem;
	public static Block condensedbodg;
	public static Block opgemOre;
	public static Block BlockofFrostGem;
	public static Block soulBlock;
	public static Block BlockOfLostGem;
	public static Block condensedbofg;
	public static Block demonGoldOre;
	public static Block frostGoldOre;
	public static Block frozensoulBlock;
	public static Block demonLight;
	public static Block frostLight;
	public static Block steelScrapOre;
	//Crafting
	public static Block repairstation;
	public static Block repairstationV2;
	public static Block OPcraftingstation;
	public static Block blockoenchanting;
	public static Block TheForge;
	//Machines
	public static Block OPFurnaceIdle;
	public static Block OPFurnaceActive;
	public static Block DemonFurnaceIdle;
	public static Block DemonFurnaceActive;
	public static Block freezer;
	
	
	
	
	//Stairs
	public static Block DemonStairs;
	public static Block FrostStairs;
	
	//Trees
	
	public static Block OPWLogBlocks;
	public static Block OPWLeafBlocks;
	public static Block OPWSaplingBlocks;
	public static Block OPW_Wood;
	
	//Portal Blocks
	public static Block DeadZonePortal;
	public static Block FrostZonePortal;
	
	
	// GUI
	public static final int GUIRepairStation = 1;
	public static final int GUIRepairStationV2 = 2;
	public static final int GUIOPCraftingStation = 3;
	public static final int GUIOPFurnace = 4;
	public static final int GUITheForge = 5;
	public static final int GUIDemonFurnace = 6;
	public static final int GUIFreezer = 7;

	// Armors
	public static Item opHelmet;
	public static Item opChestplate;
	public static Item opLeggings;
	public static Item opBoots;
	public static Item demonHead;
	public static Item demonChest;
	public static Item demonLeggings;
	public static Item demonBoots;
	public static Item frostHelmet;
	public static Item frostChestplate;
	public static Item frostLeggings;
	public static Item frostBoots;
	public static Item lostHelmet;
	public static Item lostChestplate;
	public static Item lostLeggings;
	public static Item lostBoots;
	public static Item reaperHead;
	public static Item reaperChest;
	public static Item reaperLeggings;
	public static Item reaperBoots;


	
	
	

	// Durability stuff
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	
	@Instance
	public static OPWeapons instance;

	@SidedProxy(clientSide= "com.Symbols97.OPWeapons.proxy.ClientProxy", serverSide= "com.Symbols97.OPWeapons.proxy.CommonProxy")
	public static CommonProxy Proxy;
	public static ModLoadedChecker modloadedchecker;

	// Tool Properties
	public static final Item.ToolMaterial opSwordMaterial = EnumHelper.addToolMaterial("opSwordMaterial", 4, 4000, 10.0F, 71.0F,400);
	public static final Item.ToolMaterial opToolMaterial = EnumHelper.addToolMaterial("opToolMaterial", 4, 6000, 100.0F, 3.0F, 400);
	public static final Item.ToolMaterial opLostToolMaterial = EnumHelper.addToolMaterial("opLostToolMaterial", 100, 64, 70.0F, 3.0F,0);
	
	public static final Item.ToolMaterial SlayerMaterial = EnumHelper.addToolMaterial("opSlayerMaterial", 4, 6000,70.0F, 996.0F, 0);
	public static final Item.ToolMaterial tier2SwordMaterial = EnumHelper.addToolMaterial("tier2SwordMaterial", 4, 5000, 70.0F, 121.0F, 0);
	public static final Item.ToolMaterial ReaperMaterial = EnumHelper.addToolMaterial("ReaperMaterial", 4, 50, 70.0F, 0.0F, 0);
	public static final Item.ToolMaterial DemonHammer = EnumHelper.addToolMaterial("demonhammer", 4, 200, 10.0F, 276F, 0);
	public static final Item.ToolMaterial OPClub = EnumHelper.addToolMaterial("OPClub", 4, 200, 10.0F, 271F, 0);
	public static final Item.ToolMaterial FrostAxe = EnumHelper.addToolMaterial("OPClub", 4, 200, 60.0F, 282F, 0);
	
	
	// Armor Properties
	public static final ItemArmor.ArmorMaterial opArmorMaterial = EnumHelper.addArmorMaterial("OPArmor", 100,new int[] { 100, 100, 100, 100 }, 400);
	public static final ItemArmor.ArmorMaterial opDemonMaterial = EnumHelper.addArmorMaterial("DemonArmor", 100,new int[] { 100, 100, 100, 100 }, 0);
	public static final ItemArmor.ArmorMaterial opFrostMaterial = EnumHelper.addArmorMaterial("FrostArmor", 100,new int[] { 100, 100, 100, 100 }, 0);
	public static final ItemArmor.ArmorMaterial opLostMaterial = EnumHelper.addArmorMaterial("LostArmor", 100,new int[] { 100, 100, 100, 100 }, 0);
	public static final ItemArmor.ArmorMaterial opReaperMaterial = EnumHelper.addArmorMaterial("ReaperArmor", 100,new int[] { 100, 100, 100, 100 }, 0);
	// Durability = X * 11 (Helmet) X * 16 (Chestplate) X * 15 (Leggings) X * 13 (Boots) //Default{2,7,5,3}


	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		// **init**
		MinecraftForge.EVENT_BUS.register(new management());
		FMLCommonHandler.instance().bus().register(new management());
		
	
		

		//System.out.println("Event Handler Initialized");
		// Block
		opgemOre = new opgemOre(Material.rock).setBlockName("OP_Gem_Ore").setBlockTextureName("opweapons:opgemOre").setCreativeTab(tabOPWeapons);
		blockofopGem = new blockofopGem(Material.iron).setBlockName("Block_of_OP_Gem").setBlockTextureName("opweapons:blockofopgem").setCreativeTab(tabOPWeapons);
		blockofdemongem = new blockofdemongem(Material.iron).setBlockName("Block_of_Demon_Gem").setBlockTextureName("opweapons:blockofdemongem").setCreativeTab(tabOPWeapons);
		condensedbodg = new condensedbodg(Material.iron).setBlockName("Condensed_Block_of_Demon_Gem").setBlockTextureName("opweapons:condensedbodg").setCreativeTab(tabOPWeapons);
		repairstation = new repairstation(Material.wood).setBlockName("Repair_Station").setCreativeTab(tabOPWeapons);
		repairstationV2 = new repairstationV2(Material.wood).setBlockName("Repair_StationV2").setCreativeTab(tabOPWeapons);
		OPcraftingstation = new opcraftingstation(Material.wood).setBlockName("OP_Crafting_Station").setCreativeTab(tabOPWeapons);
		blockoenchanting = new blockoenchanting(Material.iron).setBlockName("Block_o'_Enchanting").setBlockTextureName("opweapons:Blocko'Enchanting").setCreativeTab(tabOPWeapons);
		TheForge = new theforge(Material.iron).setBlockName("The_Forge").setCreativeTab(tabOPWeapons);
		BlockofFrostGem = new BlockofFrostGem(Material.iron).setBlockName("Block_of_Frost_Gem").setBlockTextureName("opweapons:blockoffrostgem").setCreativeTab(tabOPWeapons);
		soulBlock = new soulBlock(Material.iron).setBlockName("Soul_Block").setBlockTextureName("opweapons:soulblock").setCreativeTab(tabOPWeapons);
		BlockOfLostGem = new BlockOfLostGem(Material.iron).setBlockName("Block_of_Lost_Gem").setBlockTextureName("opweapons:blockoflostgem").setCreativeTab(tabOPWeapons);
		condensedbofg = new condensedbofg(Material.iron).setBlockName("Condensed_Block_of_Frost_Gem").setBlockTextureName("opweapons:condensedbofg").setCreativeTab(tabOPWeapons);
		demonGoldOre = new DemonGoldOre(Material.iron).setBlockName("Demon_Gold_Ore").setBlockTextureName("opweapons:demon_gold_ore").setCreativeTab(tabOPWeapons);
		frostGoldOre = new FrostGoldOre(Material.iron).setBlockName("Frost_Gold_Ore").setBlockTextureName("opweapons:frost_gold_ore").setCreativeTab(tabOPWeapons);
		frozensoulBlock = new frozensoulBlock(Material.iron).setBlockName("Frozen_Soul_Block").setBlockTextureName("opweapons:frozen_soul_block").setCreativeTab(tabOPWeapons);
		demonLight = new demonLight(Material.glass).setBlockName("Demon_Light").setBlockTextureName("opweapons:demonlight").setCreativeTab(tabOPWeapons);
		frostLight = new frostLight(Material.glass).setBlockName("Frost_Light").setBlockTextureName("opweapons:frostlight").setCreativeTab(tabOPWeapons);
		steelScrapOre = new SteelScrapOre(Material.rock).setBlockName("Steel_Scrap_Ore").setBlockTextureName("opweapons:steelscrapore").setCreativeTab(tabOPWeapons);
		OPW_Wood = new OPW_Wood().setBlockName("wood").setCreativeTab(tabOPWeapons);
		
		//Stairs
		DemonStairs = new OPWStairs(0, OPWeapons.OPW_Wood, 0).setBlockName("Demon_Stairs").setCreativeTab(tabOPWeapons);
		FrostStairs = new OPWStairs(1, OPWeapons.OPW_Wood, 1).setBlockName("Frost_Stairs").setCreativeTab(tabOPWeapons);
		
		//Trees
		
		OPWLogBlocks = new OPWLogs().setBlockName("log").setCreativeTab(tabOPWeapons);
		OPWLeafBlocks = new OPWLeaves().setBlockName("leaf").setCreativeTab(tabOPWeapons);
		OPWSaplingBlocks = new OPWSaplings().setBlockName("sapling").setCreativeTab(tabOPWeapons);
		
		
		//Portal Blocks
		DeadZonePortal = new DeadZonePortal().setCreativeTab(null);
		FrostZonePortal = new FrostZonePortal().setCreativeTab(null);
		
		//Machine Blocks
		OPFurnaceIdle = new OPFurnace(false).setBlockName("OP_Furnace_Idle").setCreativeTab(tabOPWeapons);
		OPFurnaceActive = new OPFurnace(true).setBlockName("OP_Furnace_Active").setLightLevel(0.625F).setCreativeTab(null);
		DemonFurnaceIdle = new DemonFurnace(false).setBlockName("Demon_Furnace_Idle").setCreativeTab(tabOPWeapons);
		DemonFurnaceActive = new DemonFurnace(true).setBlockName("Demon_Furnace_Active").setLightLevel(0.625F).setCreativeTab(null);
		freezer = new Freezer().setBlockName("Freezer").setCreativeTab(tabOPWeapons);
		
		
		
		// Weapons
		opSword = new OPSword(opSwordMaterial).setUnlocalizedName("OP_Sword").setTextureName("opweapons:opsword");
		demonSlayer = new demonSlayer(SlayerMaterial).setUnlocalizedName("Demon_Slayer").setTextureName("opweapons:demonSlayer");
		fireSword = new fireSword(tier2SwordMaterial).setUnlocalizedName("Fire_Sword").setTextureName("opweapons:firesword");
		iceSword = new iceSword(tier2SwordMaterial).setUnlocalizedName("Ice_Sword").setTextureName("opweapons:icesword");
		frostSlayer = new frostSlayer(SlayerMaterial).setUnlocalizedName("Frost_Slayer").setTextureName("opweapons:frostSlayer");
		reaperscythe = new reaperscythe(ReaperMaterial).setUnlocalizedName("reaperscythe").setTextureName("opweapons:reaperscythe");
		demonHammer = new demonHammer(DemonHammer).setUnlocalizedName("Demon_Hammer").setTextureName("opweapons:demon_hammer").setCreativeTab(CreativeTabs.tabCombat).setFull3D();
		opClub = new opClub(OPClub).setUnlocalizedName("OP_Club").setTextureName("opweapons:opclub").setCreativeTab(CreativeTabs.tabCombat);
		frostAxe = new frostAxe(FrostAxe).setUnlocalizedName("Frost_Axe").setTextureName("opweapons:frostaxe").setCreativeTab(CreativeTabs.tabCombat);
		opBow = new opBow().setUnlocalizedName("OP_Bow").setFull3D();
		
		

		// Tools
		opPickaxe = new OPPickaxe(opToolMaterial).setUnlocalizedName("OP_Pickaxe").setTextureName("opweapons:oppickaxe");
		opAxe = new opaxe(opToolMaterial).setUnlocalizedName("OP_Axe").setTextureName("opweapons:opaxe");
		opHoe = new OPHoe(opToolMaterial).setUnlocalizedName("OP_Hoe").setTextureName("opweapons:ophoe");
		opShovel = new OPShovel(opToolMaterial).setUnlocalizedName("OP_Shovel").setTextureName("opweapons:opshovel");
		lostPickaxe = new lostPickaxe(opLostToolMaterial).setUnlocalizedName("Lost_Pickaxe").setTextureName("opweapons:Lost Pickaxe");
		neutralStaff = new neutralStaff().setUnlocalizedName("Neutral_Staff").setTextureName("opweapons:neutral_staff").setCreativeTab(tabOPWeapons).setFull3D();
		DZStaff = new DZStaff().setUnlocalizedName("Dead_Zone_Staff").setTextureName("opweapons:Dead_Zone_Staff").setCreativeTab(tabOPWeapons).setFull3D();
		FZStaff = new FZStaff().setUnlocalizedName("Frost_Zone_Staff").setTextureName("opweapons:Frost_Zone_Staff").setCreativeTab(tabOPWeapons).setFull3D();
		
		// Armors
		opHelmet = new OPArmor(opArmorMaterial, 0, 0).setUnlocalizedName("OP_Helmet").setTextureName("opweapons:OPHelmet");
		opChestplate = new OPArmor(opArmorMaterial, 0, 1).setUnlocalizedName("OP_Chestplate").setTextureName("opweapons:OPChestplate");
		opLeggings = new OPArmor(opArmorMaterial, 0, 2).setUnlocalizedName("OP_Leggings").setTextureName("opweapons:OPLeggings");
		opBoots = new OPArmor(opArmorMaterial, 0, 3).setUnlocalizedName("OP_Boots").setTextureName("opweapons:OPBoots");

		demonHead = new DemonArmor(opDemonMaterial, 0, 0).setUnlocalizedName("Demon_Head").setTextureName("opweapons:Demon Head");
		demonChest = new DemonArmor(opDemonMaterial, 0, 1).setUnlocalizedName("Demon_Chest").setTextureName("opweapons:Demon Chest");
		demonLeggings = new DemonArmor(opDemonMaterial, 0, 2).setUnlocalizedName("Demon_Leggings").setTextureName("opweapons:Demon Leggings");
		demonBoots = new DemonArmor(opDemonMaterial, 0, 3).setUnlocalizedName("Demon_Boots").setTextureName("opweapons:Demon Boots");

		frostHelmet = new FrostArmor(opFrostMaterial, 0, 0).setUnlocalizedName("Frost_Helmet").setTextureName("opweapons:Frost Helmet");
		frostChestplate = new FrostArmor(opFrostMaterial, 0, 1).setUnlocalizedName("Frost_Chestplate").setTextureName("opweapons:Frost Chestplate");
		frostLeggings = new FrostArmor(opFrostMaterial, 0, 2).setUnlocalizedName("Frost_Leggings").setTextureName("opweapons:Frost Leggings");
		frostBoots = new FrostArmor(opFrostMaterial, 0, 3).setUnlocalizedName("Frost_Boots").setTextureName("opweapons:Frost Boots");
		
		lostHelmet = new LostArmor(opLostMaterial, 0, 0).setUnlocalizedName("Lost_Helmet").setTextureName("opweapons:Lost Helmet");
		lostChestplate = new LostArmor(opLostMaterial, 0, 1).setUnlocalizedName("Lost_Chestplate").setTextureName("opweapons:Lost Chestplate");
		lostLeggings = new LostArmor(opLostMaterial, 0, 2).setUnlocalizedName("Lost_Leggings").setTextureName("opweapons:Lost Leggings");
		lostBoots = new LostArmor(opLostMaterial, 0, 3).setUnlocalizedName("Lost_Boots").setTextureName("opweapons:Lost Boots");

		reaperHead = new ReaperArmor(opReaperMaterial,0,0).setUnlocalizedName("Reaper_Head").setTextureName("opweapons:Reaper Head");
		reaperChest = new ReaperArmor(opReaperMaterial,0,1).setUnlocalizedName("Reaper_Chest").setTextureName("opweapons:Reaper Chest");
		reaperLeggings = new ReaperArmor(opReaperMaterial,0,2).setUnlocalizedName("Reaper_Leggings").setTextureName("opweapons:Reaper Leggings");
		reaperBoots = new ReaperArmor(opReaperMaterial,0,3).setUnlocalizedName("Reaper_Boots").setTextureName("opweapons:Reaper Boots");
		
		
		
		// items
		demonGem = new demonGem().setUnlocalizedName("Demon_Gem").setTextureName("opweapons:demongem").setCreativeTab(tabOPWeapons);
		hellStick = new HellStick().setFull3D().setUnlocalizedName("Hell_Stick").setTextureName("opweapons:hellstick").setCreativeTab(tabOPWeapons);
		opGem = new opGem().setUnlocalizedName("OP_Gem").setTextureName("opweapons:opgem").setCreativeTab(tabOPWeapons);
		opGemChunk = new opGemChunk().setUnlocalizedName("OP_Gem_Chunk").setTextureName("opweapons:opGemchunk").setCreativeTab(tabOPWeapons);
		nethershard = new NetherShard().setUnlocalizedName("Nether_Shard").setTextureName("opweapons:Nether_Shard").setCreativeTab(tabOPWeapons);
		ultimatenetherstar = new UltimateNetherStar().setUnlocalizedName("Ultimate_Nether_Star").setTextureName("opweapons:ultimate_nether_star").setCreativeTab(tabOPWeapons);
		repairModule = new RepairModule().setUnlocalizedName("Repair_Module").setTextureName("opweapons:RepairModule").setCreativeTab(tabOPWeapons);
		opGemCore = new opGemCore().setUnlocalizedName("OP_Gem_Core").setTextureName("opweapons:OP Gem Core").setCreativeTab(tabOPWeapons);
		DemonGemCore = new DemonGemCore().setUnlocalizedName("Demon_Gem_Core").setTextureName("opweapons:Demon Gem Core").setCreativeTab(tabOPWeapons);				
		lostgem = new lostgem().setUnlocalizedName("Lost_Gem").setTextureName("opweapons:lostgem").setCreativeTab(tabOPWeapons);
		goldParticle = new goldParticle().setUnlocalizedName("Gold_Particle").setTextureName("opweapons:gold_particle");
		syntheticGold = new syntheticGold().setUnlocalizedName("Synthetic_Gold").setTextureName("opweapons:synthetic_gold");
		capsule = new capsule().setUnlocalizedName("Capsule").setTextureName("opweapons:capsule").setCreativeTab(tabOPWeapons);
		firecapsule = new firecapsule().setUnlocalizedName("Fire_Capsule").setTextureName("opweapons:firecapsule").setCreativeTab(tabOPWeapons);
		neutralCore = new neutralcore().setUnlocalizedName("Neutral_Core").setTextureName("opweapons:Neutral Core").setCreativeTab(tabOPWeapons);
		crimsonBlade = new crimsonblade().setUnlocalizedName("Crimson_Blade").setTextureName("opweapons:crimsonblade").setCreativeTab(tabOPWeapons);
		frostgemcore = new frostgemcore().setUnlocalizedName("Frost_Gem_Core").setTextureName("opweapons:Frost Gem Core").setCreativeTab(tabOPWeapons);
		frostGem = new frostGem().setUnlocalizedName("Frost_Gem").setTextureName("opweapons:frostgem").setCreativeTab(tabOPWeapons);
		froststick = new froststick().setUnlocalizedName("Frost_Stick").setTextureName("opweapons:froststick").setCreativeTab(tabOPWeapons);
		frostBlade = new frostBlade().setUnlocalizedName("Frost_Blade").setTextureName("opweapons:frostblade").setCreativeTab(tabOPWeapons);
		miniSoul = new miniSoul().setUnlocalizedName("Mini_Soul").setTextureName("opweapons:minisoul").setCreativeTab(tabOPWeapons);
		torturedSoul = new torturedSoul().setUnlocalizedName("Tortured_Soul").setTextureName("opweapons:torturedsoul").setCreativeTab(tabOPWeapons);
		soulHarvester = new soulHarvester().setUnlocalizedName("Soul_Harvester").setTextureName("opweapons:soulharvester").setCreativeTab(tabOPWeapons);
		lostPages = new lostPages().setUnlocalizedName("Lost_Pages").setTextureName("opweapons:lostpages").setCreativeTab(tabOPWeapons);
		reaperImmunityPatch = new reaperImmunityPatch().setUnlocalizedName("Reaper_Immunity_Patch").setTextureName("opweapons:reaperImmunityPatch").setCreativeTab(tabOPWeapons);
		deathEssence = new deathEssence().setUnlocalizedName("Death_Essence").setTextureName("opweapons:Death_Essence").setCreativeTab(tabOPWeapons);
		HammerHead = new HammerHead().setUnlocalizedName("Hammer_Head").setTextureName("opweapons:Hammer_Head").setCreativeTab(tabOPWeapons);
		HammerHandle = new HammerHandle().setUnlocalizedName("Hammer_Handle").setTextureName("opweapons:Hammer_Handle").setCreativeTab(tabOPWeapons);
		HandleBase = new HandleBase().setUnlocalizedName("Hammer_Handle_Base").setTextureName("opweapons:Hammer_Handle_Base").setCreativeTab(tabOPWeapons);
		HandleGrip = new HandleGrip().setUnlocalizedName("Hammer_Handle_Grip").setTextureName("opweapons:Hammer_Handle_Grip").setCreativeTab(tabOPWeapons);
		HandleHilt = new HandleHilt().setUnlocalizedName("Hammer_Handle_Hilt").setTextureName("opweapons:Hammer_Handle_Hilt").setCreativeTab(tabOPWeapons);
		ClubHead = new ClubHead().setUnlocalizedName("Club_Head").setTextureName("opweapons:clubhead").setCreativeTab(tabOPWeapons);
		ClubHandle = new ClubHandle().setUnlocalizedName("Club_Handle").setTextureName("opweapons:clubhandle").setCreativeTab(tabOPWeapons);
		AxeBlade = new AxeBlade().setUnlocalizedName("Frost_Axe_Blade").setTextureName("opweapons:frostaxeblade").setCreativeTab(tabOPWeapons);
		AxeHandle = new AxeHandle().setUnlocalizedName("Frost_Axe_Handle").setTextureName("opweapons:frostaxehandle").setCreativeTab(tabOPWeapons);
		lapizArrow = new lapizArrow().setUnlocalizedName("Lapiz_Arrow").setTextureName("opweapons:lapizarrow").setCreativeTab(CreativeTabs.tabCombat);
		demonGold = new DemonGold().setUnlocalizedName("Demon_Gold").setTextureName("opweapons:demon_gold").setCreativeTab(tabOPWeapons);
		frostGold = new FrostGold().setUnlocalizedName("Frost_Gold").setTextureName("opweapons:frost_gold").setCreativeTab(tabOPWeapons);
		demonRing = new DemonRing().setUnlocalizedName("Demon_Ring").setTextureName("opweapons:demon_ring").setCreativeTab(tabOPWeapons);
		frostRing = new FrostRing().setUnlocalizedName("Frost_Ring").setTextureName("opweapons:frost_ring").setCreativeTab(tabOPWeapons);
		frozenSoul = new frozenSoul().setUnlocalizedName("Frozen_Soul").setTextureName("opweapons:frozen_soul").setCreativeTab(tabOPWeapons);
		defrostedSoul = new defrostedSoul().setUnlocalizedName("Defrosted_Soul").setTextureName("opweapons:defrosted_soul").setCreativeTab(tabOPWeapons);
		steelScrap = new steelScrap().setUnlocalizedName("Steel_Scrap").setTextureName("opweapons:steelscrap").setCreativeTab(tabOPWeapons);
		steelIngot = new steelIngot().setUnlocalizedName("Steel_Ingot").setTextureName("opweapons:steelingot").setCreativeTab(tabOPWeapons);
		steelPipe = new steelPipe().setUnlocalizedName("Steel_Pipe").setTextureName("opweapons:steelpipe").setCreativeTab(tabOPWeapons);
		triplePipe = new triplePipe().setUnlocalizedName("Triple_Steel_Pipe").setTextureName("opweapons:triplepipe").setCreativeTab(tabOPWeapons);
		vent = new vent().setUnlocalizedName("Vent").setTextureName("opweapons:vent").setCreativeTab(tabOPWeapons);
		opFlintandSteel = new opFlintandSteel().setUnlocalizedName("OP_Flint_and_Steel").setTextureName("opweapons:op_flint_and_steel").setCreativeTab(tabOPWeapons);
		
		
		OPVial = new OPVial().setUnlocalizedName("OP_Vial").setTextureName("opweapons:OPVial").setCreativeTab(tabOPWeapons);
		DemonVial = new DemonVial().setUnlocalizedName("Demon_Vial").setTextureName("opweapons:DemonVial").setCreativeTab(tabOPWeapons);;
		FrostVial = new FrostVial().setUnlocalizedName("Frost_Vial").setTextureName("opweapons:FrostVial").setCreativeTab(tabOPWeapons);;
		
		//Food
		mutton = new mutton(2, false).setUnlocalizedName("mutton").setTextureName("opweapons:mutton");
		cookedMutton = new cookedMutton(6, false).setUnlocalizedName("cooked_mutton").setTextureName("opweapons:cooked_mutton");
		magicFood = new MagicFood(20, true).setUnlocalizedName("Magic_Food").setTextureName("opweapons:magicfood");
		magicMutton = new magicMutton(20, false).setUnlocalizedName("Magic_Mutton").setTextureName("opweapons:magicmutton");
		spicyChicken = new SpicyChicken(20, false).setUnlocalizedName("Spicy_Chicken").setTextureName("opweapons:spicy_chicken");
		HotCoffee = new HotCoffee(20,false).setUnlocalizedName("Hot_Coffee").setTextureName("opweapons:hot_coffee");
		snowCone = new snowCone(20,false).setUnlocalizedName("Snow_Cone").setTextureName("opweapons:snow_cone");
		IceCoffee = new IceCoffee(20, false).setUnlocalizedName("Ice_Coffee").setTextureName("opweapons:ice_coffee");
		petFood = new PetFood(500000, false).setUnlocalizedName("Pet_Food").setTextureName("opweapons:petFood");
		
		
		
		
		//Books
		opWeaponsBook = new OPWeaponsBook().setUnlocalizedName("OP_Weapons_Book_Vol_1").setTextureName("opweapons:OPWeaponsBook").setCreativeTab(tabOPWeaponsBooks);
		opWeaponsBook2 = new OPWeaponsBook2().setUnlocalizedName("OP_Weapons_Book_Vol_2").setTextureName("opweapons:OPWeaponsBook").setCreativeTab(tabOPWeaponsBooks);
		opDemonBook = new OPDemonBook().setUnlocalizedName("Demon_Book").setTextureName("opweapons:demonbook").setCreativeTab(tabOPWeaponsBooks);
		opFrostBook = new OPFrostBook().setUnlocalizedName("Frost_Book").setTextureName("opweapons:frostbook").setCreativeTab(tabOPWeaponsBooks);
		opLoreBookIncomplete = new OPLoreBookIncomplete().setUnlocalizedName("Lore_Book_Incomplete").setTextureName("opweapons:lorebook").setCreativeTab(tabOPWeaponsBooks);
		opLoreBookComplete = new OPLoreBookComplete().setUnlocalizedName("Lore_Book_Complete").setTextureName("opweapons:lorebook").setCreativeTab(tabOPWeaponsBooks);
		opFoodBook = new OPFoodBook().setUnlocalizedName("Food_Book").setTextureName("opweapons:OPFoodBook").setCreativeTab(tabOPWeaponsBooks);
		
		
		
		// **Registering**
		// Weapons
		GameRegistry.registerItem(opSword, opSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fireSword, fireSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(iceSword, iceSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demonSlayer, demonSlayer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostSlayer, frostSlayer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demonHammer, demonHammer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opClub, opClub.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostAxe, frostAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opBow, opBow.getUnlocalizedName().substring(5));
		

		// Blocks
		GameRegistry.registerBlock(opgemOre, opgemOre.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(steelScrapOre, steelScrapOre.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(frostGoldOre, frostGoldOre.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(demonGoldOre, demonGoldOre.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OPcraftingstation, OPcraftingstation.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockofopGem, blockofopGem.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockofdemongem, blockofdemongem.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(condensedbodg, condensedbodg.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(BlockofFrostGem, BlockofFrostGem.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(condensedbofg, condensedbofg.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(BlockOfLostGem, BlockOfLostGem.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockoenchanting, blockoenchanting.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(repairstation, repairstation.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(repairstationV2, repairstationV2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(TheForge, TheForge.getUnlocalizedName().substring(5));
	    GameRegistry.registerBlock(DeadZonePortal, DeadZonePortal.getUnlocalizedName().substring(5));
	    GameRegistry.registerBlock(FrostZonePortal, FrostZonePortal.getUnlocalizedName().substring(5));
	    GameRegistry.registerBlock(soulBlock, soulBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(frozensoulBlock, frozensoulBlock.getUnlocalizedName().substring(5));
	    GameRegistry.registerBlock(demonLight, demonLight.getUnlocalizedName().substring(5));
	    GameRegistry.registerBlock(frostLight, frostLight.getUnlocalizedName().substring(5));
	    
		//Machine Blocks
		GameRegistry.registerBlock(OPFurnaceIdle, OPFurnaceIdle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OPFurnaceActive, OPFurnaceActive.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(DemonFurnaceIdle, DemonFurnaceIdle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(DemonFurnaceActive, DemonFurnaceActive.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(freezer, freezer.getUnlocalizedName().substring(5));
		
		//Trees
		GameRegistry.registerBlock(OPWLogBlocks, OPWLogItemBlocks.class, OPWLogBlocks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OPWLeafBlocks, OPWLeafItemBlocks.class, OPWLeafBlocks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OPWSaplingBlocks, OPWSaplingItemBlocks.class, OPWSaplingBlocks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OPW_Wood, OPW_WoodItemBlocks.class, OPW_Wood.getUnlocalizedName().substring(5));
		
		//Stairs
		GameRegistry.registerBlock(DemonStairs, DemonStairs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(FrostStairs, FrostStairs.getUnlocalizedName().substring(5));
		
		// items
		GameRegistry.registerItem(opGemChunk, opGemChunk.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opGem, opGem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demonGem, demonGem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostGem, frostGem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lostgem, lostgem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steelScrap, steelScrap.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steelIngot, steelIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steelPipe, steelPipe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(triplePipe, triplePipe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(vent, vent.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demonGold, demonGold.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostGold, frostGold.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opGemCore, opGemCore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(DemonGemCore, DemonGemCore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostgemcore, frostgemcore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(neutralCore, neutralCore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(crimsonBlade, crimsonBlade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(hellStick, hellStick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostBlade, frostBlade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(froststick, froststick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(nethershard, nethershard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ultimatenetherstar, ultimatenetherstar.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(repairModule, repairModule.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opFlintandSteel, opFlintandSteel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(capsule, capsule.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(firecapsule, firecapsule.getUnlocalizedName().substring(5));	
		GameRegistry.registerItem(goldParticle, goldParticle.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(syntheticGold, syntheticGold.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lostPages, lostPages.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(deathEssence, deathEssence.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(miniSoul, miniSoul.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torturedSoul, torturedSoul.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frozenSoul, frozenSoul.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(defrostedSoul, defrostedSoul.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(soulHarvester, soulHarvester.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(reaperImmunityPatch, reaperImmunityPatch.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demonRing, demonRing.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostRing, frostRing.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(HammerHead, HammerHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(HammerHandle, HammerHandle.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(HandleBase, HandleBase.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(HandleGrip, HandleGrip.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(HandleHilt, HandleHilt.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ClubHead, ClubHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ClubHandle, ClubHandle.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(AxeBlade, AxeBlade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(AxeHandle, AxeHandle.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lapizArrow, lapizArrow.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(OPVial, OPVial.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(DemonVial, DemonVial.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(FrostVial, FrostVial.getUnlocalizedName().substring(5));
		
		
		//Books
		GameRegistry.registerItem(opWeaponsBook, opWeaponsBook.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opWeaponsBook2, opWeaponsBook2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opDemonBook, opDemonBook.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opFrostBook, opFrostBook.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opLoreBookIncomplete, opLoreBookIncomplete.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opLoreBookComplete, opLoreBookComplete.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opFoodBook, opFoodBook.getUnlocalizedName().substring(5));
		
		// Armors
		GameRegistry.registerItem(opHelmet, opHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opChestplate, opChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opLeggings, opLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opBoots, opBoots.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(demonHead, demonHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demonChest, demonChest.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demonLeggings, demonLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(demonBoots, demonBoots.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(frostHelmet, frostHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostChestplate, frostChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostLeggings, frostLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frostBoots, frostBoots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(lostHelmet, lostHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lostChestplate, lostChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lostLeggings, lostLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lostBoots, lostBoots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(reaperHead, reaperHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(reaperChest, reaperChest.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(reaperLeggings, reaperLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(reaperBoots, reaperBoots.getUnlocalizedName().substring(5));
		
		
		// Tools
		GameRegistry.registerItem(opShovel, opShovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opPickaxe, opPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opAxe, opAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(opHoe, opHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lostPickaxe, lostPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(reaperscythe, reaperscythe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(neutralStaff, neutralStaff.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(DZStaff, DZStaff.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(FZStaff, FZStaff.getUnlocalizedName().substring(5));
		
		// Food
		GameRegistry.registerItem(mutton, mutton.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(cookedMutton, cookedMutton.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(magicFood, magicFood.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(magicMutton, magicMutton.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(spicyChicken, spicyChicken.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(HotCoffee, HotCoffee.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(snowCone, snowCone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(IceCoffee, IceCoffee.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(petFood, petFood.getUnlocalizedName().substring(5));
		
		
		// World Generation
		GameRegistry.registerWorldGenerator(new OPGeneration(), 0);
		
		//BiomeRegistry
		BiomeRegistry.mainRegsitry();
		//Dim Registry
		DimensionRegistry.mainRegistry();
		//Entity
		EntityOPWeapons.mainRegistry();
	
		
	}
	//public static boolean isblocksthere;
	@EventHandler
	public void init(FMLInitializationEvent event) {
		// Proxy, TitleEntity, entity, GUI and Packet Register
		
		// GUI
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
		// Packets
		PacketHandler.initPackets();
		
		
		
			
		
		
		
		// Tile Entity
		GameRegistry.registerTileEntity(TileEntityRepairStation.class, "TileEntityRepairStation");
		GameRegistry.registerTileEntity(TileEntityRepairStationV2.class, "TileEntityRepairStationV2");
		GameRegistry.registerTileEntity(TileEntityOPFurnace.class, "OPFurnace");
		GameRegistry.registerTileEntity(TileEntityTheForge.class, "TileEntityTheForge");
		GameRegistry.registerTileEntity(TileEntityDemonFurnace.class, "DemonFurnace");
		GameRegistry.registerTileEntity(TileEntityFreezer.class, "Freezer");
		
		
		
		// Renders
		Proxy.registerRenderThings();
		
		// CRAFTING RECIPES

		// Gem Core
		GameRegistry.addRecipe(new ItemStack(opGemCore), new Object[] { "gig", "drd", "ggg", 'g', OPWeapons.opGemChunk, 'i',Items.iron_ingot, 'd', Items.diamond, 'r', Blocks.redstone_block });

		// OP Book
		GameRegistry.addRecipe(new ItemStack(opWeaponsBook),new Object[] { "ccc", "cbc", "ccc", 'c', opGemChunk, 'b', Items.book });

		// OP Crafting Station
		GameRegistry.addRecipe(new ItemStack(OPcraftingstation), new Object[] { " w ", "ici", "bbb", 'w',Blocks.crafting_table, 'i', Items.iron_ingot, 'c', opGemCore, 'b', Blocks.iron_block });

		// Block of Ultimate Diamond (Item to block)
		GameRegistry.addShapedRecipe(new ItemStack(blockofdemongem),new Object[] { "uuu", "uuu", "uuu", 'u', demonGem });

		// Block of Green Gem (Item to block)
		GameRegistry.addShapedRecipe(new ItemStack(blockofopGem),new Object[] { "ggg", "ggg", "ggg", 'g', opGem });

		// Green Gem (Block to Item)
		GameRegistry.addShapelessRecipe(new ItemStack(opGem, 9), new Object[] { blockofopGem });

		// Ultimate Diamond (Block to Item)
		GameRegistry.addShapelessRecipe(new ItemStack(demonGem, 9), new Object[] { blockofdemongem });

		// condensedboud (block to item)
		GameRegistry.addShapelessRecipe(new ItemStack(blockofdemongem, 9), new Object[] { condensedbodg });

		// Wood To Planks
		GameRegistry.addShapelessRecipe(new ItemStack(OPWeapons.OPW_Wood,1,0), new Object[] {new ItemStack(OPWeapons.OPWLogBlocks,1,0)});
		GameRegistry.addShapelessRecipe(new ItemStack(OPWeapons.OPW_Wood,1,1), new Object[] {new ItemStack(OPWeapons.OPWLogBlocks,1,1)});
		
		GameRegistry.addShapedRecipe(new ItemStack(OPWeapons.DemonStairs,1), new Object [] {"w  ","ww ","www" , 'w', new ItemStack(OPWeapons.OPW_Wood,1,0)});
		GameRegistry.addShapedRecipe(new ItemStack(OPWeapons.FrostStairs,1), new Object [] {"w  ","ww ","www" , 'w', new ItemStack(OPWeapons.OPW_Wood,1,1)});
		
		//Lost Gem Block (Item To Block)
		GameRegistry.addShapedRecipe(new ItemStack(BlockOfLostGem,1), new Object[] {"lll","lll","lll",'l', lostgem});
		//Lost Gem (Block to Item)
		GameRegistry.addShapelessRecipe(new ItemStack(lostgem,9), new Object[] {BlockOfLostGem});
		
		
		// RepairStations
		GameRegistry.addShapelessRecipe(new ItemStack(repairstationV2, 1), new Object[] { repairstation });
		GameRegistry.addShapelessRecipe(new ItemStack(repairstation, 1), new Object[] { repairstationV2 });
		
		
		
		//BlockofFrostGem item to block
		GameRegistry.addShapedRecipe(new ItemStack(BlockofFrostGem), new Object [] {"fff","fff","fff",'f', frostGem});
		//BlockofFrostGem block to item
		GameRegistry.addShapelessRecipe(new ItemStack(frostGem, 9), new Object [] {BlockofFrostGem});
		
		// Smelting
		// Green Gem Ore
		GameRegistry.addSmelting(opgemOre, new ItemStack(opGemChunk, 2), 0.0F);
		GameRegistry.addSmelting(Items.nether_star, new ItemStack(nethershard, 5), 500.0F);
		GameRegistry.addSmelting(mutton, new ItemStack(cookedMutton, 1), 0.0F);
		
		
		
		
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(OPWeapons.lostPages), 1, 1,2));
		

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		
		if (ModLoadedChecker.isneiLoaded) {
		NEIIntergration.registerNEIRecipes();
		}
		
		
		{	    	
			WorldType DEADZONE = new WorldTypeDeadZone(3, "Dead_Zone");
			WorldType FROSTZONE = new WorldTypeDeadZone(3, "Frost_Zone");
	    }
	}

	//Commands Register
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new spawnArmor());
		
	}
	
	
	// **Creative Tabs**
	public static CreativeTabs tabOPWeapons = new CreativeTabs("tabOPWeapons") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(opGem).getItem();
		}
	};
	
	public static CreativeTabs tabOPWeaponsBooks = new CreativeTabs("tabOPWeaponsBooks") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(opWeaponsBook).getItem();
		}
	};
	
	

}