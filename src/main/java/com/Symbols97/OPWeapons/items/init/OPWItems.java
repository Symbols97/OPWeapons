package com.Symbols97.OPWeapons.items.init;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armors.DemonArmor;
import com.Symbols97.OPWeapons.armors.FrostArmor;
import com.Symbols97.OPWeapons.armors.LostArmor;
import com.Symbols97.OPWeapons.armors.OPArmor;
import com.Symbols97.OPWeapons.armors.OPWArmorMaterial;
import com.Symbols97.OPWeapons.armors.ReaperArmor;
import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.items.DZStaff;
import com.Symbols97.OPWeapons.items.DemonRing;
import com.Symbols97.OPWeapons.items.DrinkItem;
import com.Symbols97.OPWeapons.items.FZStaff;
import com.Symbols97.OPWeapons.items.FrostRing;
import com.Symbols97.OPWeapons.items.GoldParticle;
import com.Symbols97.OPWeapons.items.GuideBook;
import com.Symbols97.OPWeapons.items.LapizArrowItem;
import com.Symbols97.OPWeapons.items.LostPickaxe;
import com.Symbols97.OPWeapons.items.NeutralStaff;
import com.Symbols97.OPWeapons.items.OPFlintandSteel;
import com.Symbols97.OPWeapons.items.OPGem;
import com.Symbols97.OPWeapons.items.OPGemChunk;
import com.Symbols97.OPWeapons.items.OPGemCore;
import com.Symbols97.OPWeapons.items.RIP;
import com.Symbols97.OPWeapons.items.RepairModule;
import com.Symbols97.OPWeapons.items.SoulHarvester;
import com.Symbols97.OPWeapons.items.SyntheticGold;
import com.Symbols97.OPWeapons.items.UltimateNetherStar;
import com.Symbols97.OPWeapons.items.weapons.DemonHammer;
import com.Symbols97.OPWeapons.items.weapons.DemonSlayer;
import com.Symbols97.OPWeapons.items.weapons.FireSword;
import com.Symbols97.OPWeapons.items.weapons.FrostAxe;
import com.Symbols97.OPWeapons.items.weapons.FrostSlayer;
import com.Symbols97.OPWeapons.items.weapons.IceSword;
import com.Symbols97.OPWeapons.items.weapons.OPBow;
import com.Symbols97.OPWeapons.items.weapons.OPClub;
import com.Symbols97.OPWeapons.items.weapons.ReaperScythe;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SimpleFoiledItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OPWItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OPWeapons.MOD_ID);

	// Items
	public static final RegistryObject<Item> op_gem_chunk = ITEMS.register("op_gem_chunk",
			() -> new OPGemChunk(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> op_gem = ITEMS.register("op_gem",
			() -> new OPGem(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> demon_gem = ITEMS.register("demon_gem",
			() -> new SimpleFoiledItem(new Item.Properties().fireResistant().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> frost_gem = ITEMS.register("frost_gem",
			() -> new SimpleFoiledItem(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> lost_gem = ITEMS.register("lost_gem",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> kysanite_scrap = ITEMS.register("kysanite_scrap",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> kysanite_ingot = ITEMS.register("kysanite_ingot",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	
	public static final RegistryObject<Item> kysanite_pipe = ITEMS.register("kysanite_pipe",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> triple_kysanite_pipe = ITEMS.register("triple_kysanite_pipe",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> vent = ITEMS.register("vent",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> demon_gold = ITEMS.register("demon_gold",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	
	public static final RegistryObject<Item> frost_gold = ITEMS.register("frost_gold",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	
	
	public static final RegistryObject<Item> op_gem_core = ITEMS.register("op_gem_core",
			() -> new OPGemCore(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> demon_gem_core = ITEMS.register("demon_gem_core",
			() -> new SimpleFoiledItem(new Item.Properties().fireResistant().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> frost_gem_core = ITEMS.register("frost_gem_core",
			() -> new SimpleFoiledItem(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> neutral_core = ITEMS.register("neutral_core",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> crimson_blade = ITEMS.register("crimson_blade",
			() -> new SimpleFoiledItem(new Item.Properties().tab(OPWeapons.tabOPWeapons)));	
	public static final RegistryObject<Item> hell_stick = ITEMS.register("hell_stick",
			() -> new SimpleFoiledItem(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> frost_blade = ITEMS.register("frost_blade",
			() -> new SimpleFoiledItem(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> frost_stick = ITEMS.register("frost_stick",
			() -> new SimpleFoiledItem(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> nether_shard = ITEMS.register("nether_shard",
			() -> new SimpleFoiledItem(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> ultimate_nether_star = ITEMS.register("ultimate_nether_star",
			() -> new UltimateNetherStar(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> repair_module = ITEMS.register("repair_module",
			() -> new RepairModule(new Item.Properties().durability(24).setNoRepair().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> op_flint_and_steel = ITEMS.register("op_flint_and_steel",
			() -> new OPFlintandSteel(new Item.Properties().durability(256).setNoRepair().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> capsule = ITEMS.register("capsule",
			() -> new Item(new Item.Properties().fireResistant().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> encapsulated_flame = ITEMS.register("encapsulated_flame",
			() -> new Item(new Item.Properties().fireResistant().craftRemainder(capsule.get()).tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> lost_pages = ITEMS.register("lost_pages",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> death_essence = ITEMS.register("death_essence",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> mini_soul = ITEMS.register("mini_soul",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> frozen_soul = ITEMS.register("frozen_soul",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> defrosted_soul = ITEMS.register("defrosted_soul",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> tortured_soul = ITEMS.register("tortured_soul",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> soul_harvester = ITEMS.register("soul_harvester",
			() -> new SoulHarvester(new Item.Properties().stacksTo(1).tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> reaper_immunity_patch = ITEMS.register("reaper_immunity_patch",
			() -> new RIP(new Item.Properties().stacksTo(8).tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> demon_ring = ITEMS.register("demon_ring",
			() -> new DemonRing(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> frost_ring = ITEMS.register("frost_ring",
			() -> new FrostRing(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> club_head = ITEMS.register("club_head",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> club_handle = ITEMS.register("club_handle",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	
	public static final RegistryObject<Item> hammer_head = ITEMS.register("hammer_head",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> hammer_handle = ITEMS.register("hammer_handle",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> hammer_handle_base = ITEMS.register("hammer_handle_base",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> hammer_handle_grip = ITEMS.register("hammer_handle_grip",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> hammer_handle_hilt = ITEMS.register("hammer_handle_hilt",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	
	public static final RegistryObject<Item> frost_axe_blade = ITEMS.register("frost_axe_blade",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> frost_axe_handle = ITEMS.register("frost_axe_handle",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	
	public static final RegistryObject<Item> gold_particle = ITEMS.register("gold_particle",
			() -> new GoldParticle(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	
	public static final RegistryObject<Item> synthetic_gold = ITEMS.register("synthetic_gold",
			() -> new SyntheticGold(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	
	
	public static final RegistryObject<Item> op_vial = ITEMS.register("op_vial",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> demon_vial = ITEMS.register("demon_vial",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	public static final RegistryObject<Item> frost_vial = ITEMS.register("frost_vial",
			() -> new Item(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	
	public static final RegistryObject<Item> neutral_staff = ITEMS.register("neutral_staff",
			() -> new NeutralStaff(new Item.Properties().durability(64).tab(OPWeapons.tabOPWeapons)));
	
	public static final RegistryObject<Item> dead_zone_staff = ITEMS.register("dead_zone_staff", DZStaff::new);
	public static final RegistryObject<Item> frost_zone_staff = ITEMS.register("frost_zone_staff", FZStaff::new);
	
	
	
	public static final RegistryObject<Item> guide_book = ITEMS.register("guide_book",
			() -> new GuideBook(new Item.Properties().tab(OPWeapons.tabOPWeapons)));
	
	
	// Tools / Weapons
	public static final RegistryObject<Item> op_shovel = ITEMS.register("op_shovel",
			() -> new ShovelItem(weapon_tooltiers.opTool, 2, 0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> op_pickaxe = ITEMS.register("op_pickaxe",
			() -> new PickaxeItem(weapon_tooltiers.opTool, 3, 0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> op_axe = ITEMS.register("op_axe",
			() -> new AxeItem(weapon_tooltiers.opTool, 6, 0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> op_hoe = ITEMS.register("op_hoe",
			() -> new HoeItem(weapon_tooltiers.opTool, 0, 0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> lost_pickaxe = ITEMS.register("lost_pickaxe",
			() -> new LostPickaxe(weapon_tooltiers.lostTool, 0, 0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> op_sword = ITEMS.register("op_sword",
			() -> new SwordItem(weapon_tooltiers.opSword, 0, 6f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> fire_sword = ITEMS.register("fire_sword",
			() -> new FireSword(weapon_tooltiers.tier2Sword, 0, 6f,new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> ice_sword = ITEMS.register("ice_sword",
			() -> new IceSword(weapon_tooltiers.tier2Sword, 0, 6f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> demon_slayer = ITEMS.register("demon_slayer",
			() -> new DemonSlayer(weapon_tooltiers.slayer, 0, 6f,new Item.Properties().fireResistant().craftRemainder(capsule.get()).tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> frost_slayer = ITEMS.register("frost_slayer",
			() -> new FrostSlayer(weapon_tooltiers.slayer, 0, 6f,new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	
	//Tier 4
	public static final RegistryObject<Item> op_club = ITEMS.register("op_club",
			() -> new OPClub(weapon_tooltiers.tier4, 0, 6f,new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> demon_hammer = ITEMS.register("demon_hammer",
			() -> new DemonHammer(weapon_tooltiers.tier4, 5, 6f,new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> frost_axe = ITEMS.register("frost_axe",
			() -> new FrostAxe(weapon_tooltiers.tier4, 10, 6f,new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	//Tier X
	public static final RegistryObject<Item> reaper_scythe = ITEMS.register("reaper_scythe",
			() -> new ReaperScythe(weapon_tooltiers.scythe, 0, 6f, new Item.Properties().setNoRepair().tab(CreativeModeTab.TAB_COMBAT)));

	
	public static final RegistryObject<Item> op_bow = ITEMS.register("op_bow",
			() -> new OPBow(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).durability(1000)));
	public static final RegistryObject<Item> lapiz_arrow = ITEMS.register("lapiz_arrow",
			() -> new LapizArrowItem(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT), 120.0F));
	
	// Armors
	public static final RegistryObject<Item> op_helmet = ITEMS.register("op_helmet",
			() -> new OPArmor(OPWArmorMaterial.OP, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> op_chestplate = ITEMS.register("op_chestplate",
			() -> new OPArmor(OPWArmorMaterial.OP, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> op_leggings = ITEMS.register("op_leggings",
			() -> new OPArmor(OPWArmorMaterial.OP, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> op_boots = ITEMS.register("op_boots",
			() -> new OPArmor(OPWArmorMaterial.OP, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

	public static final RegistryObject<Item> demon_helmet_shaded = ITEMS.register("demon_helmet_shaded",
			() -> new DemonArmor(OPWArmorMaterial.DEMON_SHADED, EquipmentSlot.HEAD,
					new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_COMBAT)));
	
	public static final RegistryObject<Item> demon_helmet = ITEMS.register("demon_helmet",
			() -> new DemonArmor(OPWArmorMaterial.DEMON, EquipmentSlot.HEAD,
					new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> demon_chestplate = ITEMS.register("demon_chestplate",
			() -> new DemonArmor(OPWArmorMaterial.DEMON, EquipmentSlot.CHEST,
					new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> demon_leggings = ITEMS.register("demon_leggings",
			() -> new DemonArmor(OPWArmorMaterial.DEMON, EquipmentSlot.LEGS,
					new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> demon_boots = ITEMS.register("demon_boots",
			() -> new DemonArmor(OPWArmorMaterial.DEMON, EquipmentSlot.FEET,
					new Item.Properties().fireResistant().tab(CreativeModeTab.TAB_COMBAT)));

	public static final RegistryObject<Item> frost_helmet = ITEMS.register("frost_helmet",
			() -> new FrostArmor(OPWArmorMaterial.FROST, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> frost_chestplate = ITEMS.register("frost_chestplate",
			() -> new FrostArmor(OPWArmorMaterial.FROST, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> frost_leggings = ITEMS.register("frost_leggings",
			() -> new FrostArmor(OPWArmorMaterial.FROST, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> frost_boots = ITEMS.register("frost_boots",
			() -> new FrostArmor(OPWArmorMaterial.FROST, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	
	public static final RegistryObject<Item> lost_helmet = ITEMS.register("lost_helmet",
			() -> new LostArmor(OPWArmorMaterial.LOST, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> lost_chestplate = ITEMS.register("lost_chestplate",
			() -> new LostArmor(OPWArmorMaterial.LOST, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> lost_leggings = ITEMS.register("lost_leggings",
			() -> new LostArmor(OPWArmorMaterial.LOST, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> lost_boots = ITEMS.register("lost_boots",
			() -> new LostArmor(OPWArmorMaterial.LOST, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	
	
	public static final RegistryObject<Item> reaper_helmet = ITEMS.register("reaper_helmet",
			() -> new ReaperArmor(OPWArmorMaterial.REAPER, EquipmentSlot.HEAD,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> reaper_chestplate = ITEMS.register("reaper_chestplate",
			() -> new ReaperArmor(OPWArmorMaterial.REAPER, EquipmentSlot.CHEST,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> reaper_leggings = ITEMS.register("reaper_leggings",
			() -> new ReaperArmor(OPWArmorMaterial.REAPER, EquipmentSlot.LEGS,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> reaper_boots = ITEMS.register("reaper_boots",
			() -> new ReaperArmor(OPWArmorMaterial.REAPER, EquipmentSlot.FEET,
					new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));


	//Foods
	public static final RegistryObject<Item> magic_food = ITEMS.register("magic_food",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(OPWFoods.magic_food)));
	
	public static final RegistryObject<Item> magic_mutton = ITEMS.register("magic_mutton",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(OPWFoods.magic_mutton)));
	
	public static final RegistryObject<Item> pet_food = ITEMS.register("pet_food",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(OPWFoods.pet_food)));
	
	public static final RegistryObject<Item> spicy_chicken = ITEMS.register("spicy_chicken",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(OPWFoods.spicy_chicken)));
	
	public static final RegistryObject<Item> snow_cone = ITEMS.register("snow_cone",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(OPWFoods.snow_cone)));
	
	public static final RegistryObject<Item> hot_coffee = ITEMS.register("hot_coffee",
			() -> new DrinkItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(OPWFoods.hot_coffee)));
	
	public static final RegistryObject<Item> ice_coffee = ITEMS.register("ice_coffee",
			() -> new DrinkItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(OPWFoods.ice_coffee)));
	
	//SpawnEggs
	  public static final RegistryObject<Item> dead_wolf_spawn_egg = ITEMS.register("dead_wolf_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.DEADWOLF,0x514F4F, 0x8E0000,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> demon_spawn_egg = ITEMS.register("demon_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.DEMON,0x8E0000, 0xce1919,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> reaper_spawn_egg = ITEMS.register("reaper_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.REAPER,0x000000, 0x6d6d6d,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> op_guardian_spawn_egg = ITEMS.register("op_guardian_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.OPGUARDIAN,0x45ef56, 0x45ef56,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> demon_guardian_spawn_egg = ITEMS.register("demon_guardian_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.DEMONGUARDIAN,0xf31c1c, 0xf31c1c,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> frost_guardian_spawn_egg = ITEMS.register("frost_guardian_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.FROSTGUARDIAN,0x00b0ff, 0x00b0ff,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> frosty_ostrich_spawn_egg = ITEMS.register("frosty_ostrich_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.FROSTYOSTRICH,0x84CDEE, 0xDFEEF4,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> op_goblin_spawn_egg = ITEMS.register("op_goblin_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.OPGOBLIN,0x12C361, 0x95A00,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> demon_goblin_spawn_egg = ITEMS.register("demon_goblin_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.DEMONGOBLIN,0xFF0000, 0x545050,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	  
	  public static final RegistryObject<Item> frost_goblin_spawn_egg = ITEMS.register("frost_goblin_spawn_egg",
	            () -> new ForgeSpawnEggItem(OPWEntities.FROSTYOSTRICH,0x41F4EC, 0xA5710F,
	                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
