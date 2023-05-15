package com.Symbols97.OPWeapons.screen;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.screen.demonfurnace.DemonFurnaceMenu;
import com.Symbols97.OPWeapons.screen.freezer.FreezerMenu;
import com.Symbols97.OPWeapons.screen.opcraftingstation.OPCraftingStationMenu;
import com.Symbols97.OPWeapons.screen.opfurnace.OPFurnaceMenu;
import com.Symbols97.OPWeapons.screen.repairstation.RepairStationMenu;
import com.Symbols97.OPWeapons.screen.repairstationv2.RepairStationV2Menu;
import com.Symbols97.OPWeapons.screen.theforge.TheForgeMenu;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuTypes {
	
	public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, OPWeapons.MOD_ID);

    public static final RegistryObject<MenuType<OPCraftingStationMenu>> opcs_menu =
            registerMenuType(OPCraftingStationMenu::new, "opcs_menu");
    
    public static final RegistryObject<MenuType<RepairStationMenu>> rps_menu =
            registerMenuType(RepairStationMenu::new, "rps_menu");
    
    public static final RegistryObject<MenuType<RepairStationV2Menu>> rpsv2_menu =
            registerMenuType(RepairStationV2Menu::new, "rpsv2_menu");
    
    public static final RegistryObject<MenuType<TheForgeMenu>> theforge_menu =
            registerMenuType(TheForgeMenu::new, "theforge_menu");
    
    public static final RegistryObject<MenuType<OPFurnaceMenu>> opfurnace_menu =
            registerMenuType(OPFurnaceMenu::new, "opfurnace_menu");
    
    public static final RegistryObject<MenuType<DemonFurnaceMenu>> demonfurnace_menu =
            registerMenuType(DemonFurnaceMenu::new, "demonfurnace_menu");
    
    public static final RegistryObject<MenuType<FreezerMenu>> freezer_menu =
            registerMenuType(FreezerMenu::new, "freezer_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}