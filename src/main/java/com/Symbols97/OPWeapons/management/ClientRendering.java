package com.Symbols97.OPWeapons.management;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armors.ReaperArmor;
import com.Symbols97.OPWeapons.armors.models.ReaperArmorRenderer;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.entity.deadwolf.DeadWolfRenderer;
import com.Symbols97.OPWeapons.entity.demon.DemonRenderer;
import com.Symbols97.OPWeapons.entity.frosty_ostrich.FrostyOstrichRenderer;
import com.Symbols97.OPWeapons.entity.goblins.Demon.DemonGoblinRenderer;
import com.Symbols97.OPWeapons.entity.goblins.Frost.FrostGoblinRenderer;
import com.Symbols97.OPWeapons.entity.goblins.OP.OPGoblinRenderer;
import com.Symbols97.OPWeapons.entity.guardians.Demon.DemonGuardianRenderer;
import com.Symbols97.OPWeapons.entity.guardians.Frost.FrostGuardianRenderer;
import com.Symbols97.OPWeapons.entity.guardians.OP.OPGuardianRenderer;
import com.Symbols97.OPWeapons.entity.projectile.lapizarrow.LapizArrowRenderer;
import com.Symbols97.OPWeapons.entity.reaper.ReaperRenderer;
import com.Symbols97.OPWeapons.screen.MenuTypes;
import com.Symbols97.OPWeapons.screen.PlayerHUD;
import com.Symbols97.OPWeapons.screen.demonfurnace.DemonFurnaceScreen;
import com.Symbols97.OPWeapons.screen.freezer.FreezerScreen;
import com.Symbols97.OPWeapons.screen.opcraftingstation.OPCraftingStationScreen;
import com.Symbols97.OPWeapons.screen.opfurnace.OPFurnaceScreen;
import com.Symbols97.OPWeapons.screen.repairstation.RepairStationScreen;
import com.Symbols97.OPWeapons.screen.repairstationv2.RepairStationV2Screen;
import com.Symbols97.OPWeapons.screen.theforge.TheForgeScreen;
import com.Symbols97.OPWeapons.util.OPWItemProperties;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = OPWeapons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRendering {

	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.AddLayers event) {
		GeoArmorRenderer.registerArmorRenderer(ReaperArmor.class, () -> new ReaperArmorRenderer());
	}
	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent event) {

		MenuScreens.register(MenuTypes.opcs_menu.get(), OPCraftingStationScreen::new);
		MenuScreens.register(MenuTypes.rps_menu.get(), RepairStationScreen::new);
		MenuScreens.register(MenuTypes.rpsv2_menu.get(), RepairStationV2Screen::new);
		MenuScreens.register(MenuTypes.theforge_menu.get(), TheForgeScreen::new);
		MenuScreens.register(MenuTypes.opfurnace_menu.get(), OPFurnaceScreen::new);
		MenuScreens.register(MenuTypes.demonfurnace_menu.get(), DemonFurnaceScreen::new);
		MenuScreens.register(MenuTypes.freezer_menu.get(), FreezerScreen::new);
		
		ItemBlockRenderTypes.setRenderLayer(OPWBlocks.freezer.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(OPWBlocks.demon_statue.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(OPWBlocks.dead_zone_portal_block.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(OPWBlocks.frost_zone_portal_block.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(OPWBlocks.frost_sapling.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(OPWBlocks.demon_sapling.get(), RenderType.cutout());
		
		OverlayRegistry.registerOverlayAbove(ForgeIngameGui.ARMOR_LEVEL_ELEMENT, "durability", PlayerHUD.HUD_DURABILITY);
		OverlayRegistry.registerOverlayAbove(ForgeIngameGui.HOTBAR_ELEMENT, "name", PlayerHUD.safety);

		EntityRenderers.register(OPWEntities.DEADWOLF.get(), DeadWolfRenderer::new);
		EntityRenderers.register(OPWEntities.REAPER.get(), ReaperRenderer::new);
		EntityRenderers.register(OPWEntities.DEMON.get(), DemonRenderer::new);
		EntityRenderers.register(OPWEntities.OPGUARDIAN.get(), OPGuardianRenderer::new);
		EntityRenderers.register(OPWEntities.DEMONGUARDIAN.get(), DemonGuardianRenderer::new);
		EntityRenderers.register(OPWEntities.FROSTGUARDIAN.get(), FrostGuardianRenderer::new);
		EntityRenderers.register(OPWEntities.FROSTYOSTRICH.get(), FrostyOstrichRenderer::new);
		EntityRenderers.register(OPWEntities.OPGOBLIN.get(), OPGoblinRenderer::new);
		EntityRenderers.register(OPWEntities.DEMONGOBLIN.get(), DemonGoblinRenderer::new);
		EntityRenderers.register(OPWEntities.FROSTGOBLIN.get(), FrostGoblinRenderer::new);
		
		EntityRenderers.register(OPWEntities.LAPIZARROW.get(), LapizArrowRenderer::new);
		
		OPWItemProperties.addCustomItemProperties();
		
	}


}