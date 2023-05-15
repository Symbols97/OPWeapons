package com.Symbols97.OPWeapons.proxy;


import java.util.HashMap;
import java.util.Map;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.TileEntity.TileEntityFreezer;
import com.Symbols97.OPWeapons.TileEntity.TileEntityRepairStation;
import com.Symbols97.OPWeapons.TileEntity.TileEntityRepairStationV2;
import com.Symbols97.OPWeapons.TileEntity.TileEntityTheForge;
import com.Symbols97.OPWeapons.gui.GUIDemonBook;
import com.Symbols97.OPWeapons.gui.GUIFoodBook;
import com.Symbols97.OPWeapons.gui.GUIFrostBook;
import com.Symbols97.OPWeapons.gui.GUILoreBookComplete;
import com.Symbols97.OPWeapons.gui.GUILoreBookIncomplete;
import com.Symbols97.OPWeapons.gui.GUIOPBook;
import com.Symbols97.OPWeapons.mobs.DeadWolf.DeadWolfModel;
import com.Symbols97.OPWeapons.mobs.DeadWolf.EntityDeadWolf;
import com.Symbols97.OPWeapons.mobs.DeadWolf.RenderDeadWolf;
import com.Symbols97.OPWeapons.mobs.Demon.DemonModel;
import com.Symbols97.OPWeapons.mobs.Demon.EntityDemon;
import com.Symbols97.OPWeapons.mobs.Demon.RenderDemon;
import com.Symbols97.OPWeapons.mobs.Reaper.EntityReaper;
import com.Symbols97.OPWeapons.mobs.Reaper.RenderReaper;
import com.Symbols97.OPWeapons.mobs.frostdragon.EntityFrostDragon;
import com.Symbols97.OPWeapons.mobs.frostdragon.FrostDragonModel;
import com.Symbols97.OPWeapons.mobs.frostdragon.RenderFrostDragon;
import com.Symbols97.OPWeapons.mobs.guardians.EntityDemonGuardian;
import com.Symbols97.OPWeapons.mobs.guardians.EntityFrostGuardian;
import com.Symbols97.OPWeapons.mobs.guardians.EntityOPGuardian;
import com.Symbols97.OPWeapons.mobs.guardians.GuardianModel;
import com.Symbols97.OPWeapons.mobs.guardians.RenderDemonGuardian;
import com.Symbols97.OPWeapons.mobs.guardians.RenderFrostGuardian;
import com.Symbols97.OPWeapons.mobs.guardians.RenderOPGuardian;
import com.Symbols97.OPWeapons.models.Armors.ReaperModel;
import com.Symbols97.OPWeapons.projectiles.EntityLapizArrow;
import com.Symbols97.OPWeapons.renderer.ItemRenderFreezer;
import com.Symbols97.OPWeapons.renderer.ItemRenderRepairStation;
import com.Symbols97.OPWeapons.renderer.ItemRenderRepairStationV2;
import com.Symbols97.OPWeapons.renderer.ItemRenderTheForge;
import com.Symbols97.OPWeapons.renderer.RenderFreezer;
import com.Symbols97.OPWeapons.renderer.RenderRepairStation;
import com.Symbols97.OPWeapons.renderer.RenderRepairStationV2;
import com.Symbols97.OPWeapons.renderer.RenderTheForge;
import com.Symbols97.OPWeapons.renderer.items_tools_weapons.RenderDemonHammerModel;
import com.Symbols97.OPWeapons.renderer.items_tools_weapons.RenderFrostAxeModel;
import com.Symbols97.OPWeapons.renderer.items_tools_weapons.RenderOPClubModel;
import com.Symbols97.OPWeapons.renderer.items_tools_weapons.RenderReaperScytheModel;
import com.Symbols97.OPWeapons.renderer.projectiles.RenderLapizArrow;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;


public class ClientProxy extends CommonProxy{

	public static final Map<Item, ModelBiped> reaperArmorModel = new HashMap<Item, ModelBiped>();
	

	public void registerRenderThings() {
	
		
		
		//Reaper Armor Model
		ReaperModel reaper_armor = new ReaperModel(0.01F);
		ReaperModel reaper_legs = new ReaperModel(0.1F);
		
		reaperArmorModel.put(OPWeapons.reaperHead, reaper_armor);
		reaperArmorModel.put(OPWeapons.reaperChest, reaper_armor);
		reaperArmorModel.put(OPWeapons.reaperLeggings, reaper_legs);
		reaperArmorModel.put(OPWeapons.reaperBoots, reaper_armor);
		
		
		//RepairStation
		TileEntitySpecialRenderer render = new RenderRepairStation();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRepairStation.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(OPWeapons.repairstation), new ItemRenderRepairStation(render, new TileEntityRepairStation()));
			
		//RepairStationV2
		TileEntitySpecialRenderer render1 = new RenderRepairStationV2();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRepairStationV2.class, render1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(OPWeapons.repairstationV2), new ItemRenderRepairStationV2(render1, new TileEntityRepairStationV2()));

		//Armor Forge
		TileEntitySpecialRenderer render2 = new RenderTheForge();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTheForge.class, render2);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(OPWeapons.TheForge), new ItemRenderTheForge(render2, new TileEntityTheForge()));

		//Freezer
		TileEntitySpecialRenderer render3 = new RenderFreezer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFreezer.class, render3);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(OPWeapons.freezer), new ItemRenderFreezer(render3, new TileEntityFreezer()));
		
	
		//ReaperScythe
		MinecraftForgeClient.registerItemRenderer(OPWeapons.reaperscythe, (IItemRenderer) new RenderReaperScytheModel());
		//Demon Hammer
		MinecraftForgeClient.registerItemRenderer(OPWeapons.demonHammer, (IItemRenderer) new RenderDemonHammerModel());
		//OP Club
		MinecraftForgeClient.registerItemRenderer(OPWeapons.opClub, (IItemRenderer) new RenderOPClubModel());
		//Frost Axe
		MinecraftForgeClient.registerItemRenderer(OPWeapons.frostAxe, (IItemRenderer) new RenderFrostAxeModel());
		
		
		//DeadWolf
		RenderingRegistry.registerEntityRenderingHandler(EntityDeadWolf.class, new RenderDeadWolf(new DeadWolfModel(), 0));
		//OP Demon
		RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, new RenderDemon(new DemonModel(0), 0.5F));
		//Reaper
		RenderingRegistry.registerEntityRenderingHandler(EntityReaper.class, new RenderReaper(new ReaperModel(0), 0.5F));
		
		//Frost Dragon
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostDragon.class, new RenderFrostDragon(new FrostDragonModel(), 1.0F));
		
		//OP Guardian
		RenderingRegistry.registerEntityRenderingHandler(EntityOPGuardian.class, new RenderOPGuardian(new GuardianModel(0), 0.5F));
		
		//Demon Guardian
		RenderingRegistry.registerEntityRenderingHandler(EntityDemonGuardian.class, new RenderDemonGuardian(new GuardianModel(0), 0.5F));
		
		//Demon Guardian
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostGuardian.class, new RenderFrostGuardian(new GuardianModel(0), 0.5F));
		
		
		EntityRegistry.registerModEntity(EntityLapizArrow.class, "LapizArrow", 1, OPWeapons.instance, 64, 20, true);
		RenderingRegistry.registerEntityRenderingHandler(EntityLapizArrow.class, new RenderLapizArrow());
	}	
	@Override
	void openGUIOPBook()
	{
	     Minecraft.getMinecraft().displayGuiScreen(new GUIOPBook());
	}
	@Override
	void openGUIDemonBook()
	{
	     Minecraft.getMinecraft().displayGuiScreen(new GUIDemonBook());
	}
	@Override
	void openGUIFrostBook()
	{
	     Minecraft.getMinecraft().displayGuiScreen(new GUIFrostBook());
	}
	@Override
	void openGUIFoodBook()
	{
	     Minecraft.getMinecraft().displayGuiScreen(new GUIFoodBook());
	}
	@Override
	void openGUILoreBookIncomplete()
	{
	     Minecraft.getMinecraft().displayGuiScreen(new GUILoreBookIncomplete());
	}
	@Override
	void openGUILoreBookComplete()
	{
	     Minecraft.getMinecraft().displayGuiScreen(new GUILoreBookComplete());
	}
	public void registerTileEntitySpecialRenderer() {
		
	}
}
