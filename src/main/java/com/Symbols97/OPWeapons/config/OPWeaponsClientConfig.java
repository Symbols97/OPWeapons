package com.Symbols97.OPWeapons.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OPWeaponsClientConfig {

	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> displayItemDurability;
	public static final ForgeConfigSpec.ConfigValue<Boolean> displayArmorDurability;

	public static final ForgeConfigSpec.ConfigValue<Boolean> displayItemPercent;
	public static final ForgeConfigSpec.ConfigValue<Boolean> displayArmorPercent;

	public static final ForgeConfigSpec.ConfigValue<String> displayColor;

	public static final ForgeConfigSpec.ConfigValue<Integer> xItemValue;
	public static final ForgeConfigSpec.ConfigValue<Integer> yItemValue;

	public static final ForgeConfigSpec.ConfigValue<Integer> xArmorValue;
	public static final ForgeConfigSpec.ConfigValue<Integer> yArmorValue;

	static {
		BUILDER.push("OPWeapons Client Config");

		displayItemDurability = BUILDER.comment("Display item durability next to the hotbar. Default: true").define("Display Item Durability:", true);

		displayItemPercent = BUILDER.comment("\n\nDisplay item durability as a percentage. Default: true").define("Display item durability percent:", true);

		xItemValue = BUILDER.comment("\n\nChange the X position of the Item Durability HUD. Default: 0").define("Item X Value:", 0);
		yItemValue = BUILDER.comment("\n\nChange the Y position of the Item Durability HUD. Default: 0").define("Item Y Value:", 0);

		displayArmorDurability = BUILDER.comment("\n\nDisplay Armor durability above the hunger bar. Default: true").define("Display Armor Durability:", true);

		displayArmorPercent = BUILDER.comment("\n\nDisplay armor durability as a percentage. Default: true").define("Display armor durability as percent:", true);

		xArmorValue = BUILDER.comment("\nChanging either X or Y values lock the Hud in place\nChange the X position of the Armor Durability HUD. Default: 0")
				.define("Armor X Value:", 0);
		yArmorValue = BUILDER.comment("\n\nChange the Y position of the Armor Durability HUD. Default: 0").define("Armor Y Value:", 0);

		displayColor = BUILDER.comment("\n\nChange the color of the HUD text (Case Sensitive)\nDark Green\nGreen\nBlue\nAqua\nYellow\nDefault: Dark Green")
				.define("HUD Text Color:", "Dark Green");

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
