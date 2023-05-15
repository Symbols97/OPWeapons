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
	
	
	static {
		BUILDER.push("OPWeapons Client Config");
		
		displayItemDurability = BUILDER.comment("Display item durability next to the hotbar. Default: true")
				.define("Display Item Durability:", true);
		
		displayItemPercent = BUILDER.comment("\n\nDisplay item durability as a percentage. Default: true")
				.define("Display item durability percent:", true);
		
		displayArmorDurability = BUILDER.comment("\n\nDisplay Armor durability above the hunger bar. Default: true")
				.define("Display Armor Durability:", true);
		
		displayArmorPercent = BUILDER.comment("\n\nDisplay armor durability as a percentage. Default: true")
				.define("Display armor durability as percent:", true);

		displayColor = BUILDER.comment("\n\nChange the color of the HUD text (Case Sensitive)\nDark Green\nGreen\nBlue\nAqua\nYellow\nDefault: Dark Green")
				.define("HUD Text Color:", "Dark Green");
		

		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}
