package com.Symbols97.OPWeapons.items.init;

import java.util.List;

import com.Symbols97.OPWeapons.util.OPWTags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

public class weapon_tooltiers {

	// Mining Level, Durability, Speed, AttackDamage (+1), Enchantment Value
	public static final ForgeTier opSword = new ForgeTier(5, 4000, 10.0F, 74.0F, 400, BlockTags.NEEDS_DIAMOND_TOOL,
			() -> Ingredient.of(/* repair me with */));

	public static final Tier opTool = TierSortingRegistry.registerTier(new ForgeTier(5, 6000, 100.0F, 3.0F, 400, OPWTags.Blocks.NEEDS_OP_TOOL,
			() -> Ingredient.of(/* repair me with */)), new ResourceLocation("op_tool"), List.of(Tiers.DIAMOND), List.of());
	
	public static final Tier lostTool = TierSortingRegistry.registerTier(new ForgeTier(100, 64, 70.0F, 3.0F, 0, OPWTags.Blocks.NEEDS_LOST_TOOL,
			() -> Ingredient.of(/* repair me with */)), new ResourceLocation("lost_tool"), List.of(weapon_tooltiers.opTool), List.of());
	
	public static final ForgeTier tier2Sword = new ForgeTier(5, 5000, 10.0F, 124.0F, 0, BlockTags.NEEDS_DIAMOND_TOOL,
			() -> Ingredient.of(/* repair me with */));
	
	public static final ForgeTier scythe = new ForgeTier(0, 50, 0.0F, 0.0F, 0, BlockTags.NEEDS_DIAMOND_TOOL,
			() -> Ingredient.of(/* repair me with */));
	
	public static final ForgeTier slayer = new ForgeTier(4, 6000,70.0F, 999.0F, 0, BlockTags.NEEDS_DIAMOND_TOOL,
			() -> Ingredient.of(/* repair me with */));
	
	public static final ForgeTier tier4 = new ForgeTier(4, 200, 10.0F, 274.0F, 0, BlockTags.NEEDS_DIAMOND_TOOL,
			() -> Ingredient.of(/* repair me with */));

}
