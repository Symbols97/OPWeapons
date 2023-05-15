package com.Symbols97.OPWeapons.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OPWeaponsCommonConfig {

	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> canRepair;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> repairCooldown;
	public static final ForgeConfigSpec.ConfigValue<Integer> repairAmount;

	static {
		BUILDER.push("OPWeapons Common Config");

		canRepair = BUILDER.comment("Allow OP Added Armors / Weapons to repair over time. Default: true")
				.define("Allowing Duration Repairing:", true);
		
		repairCooldown = BUILDER.comment("\nAdjust the cooldown for repairing OPWeapons tools and Armors. Default: 10")
				.defineInRange("Cooldown in seconds:", 10, 5, 20);
		
		repairAmount = BUILDER.comment("\nAdjust the repair amount. Default: 1")
				.defineInRange("Repair Amount:", 1, 1, 5);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}
}