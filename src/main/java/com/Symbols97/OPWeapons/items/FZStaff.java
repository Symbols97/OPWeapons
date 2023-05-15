package com.Symbols97.OPWeapons.items;

import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.blocks.FrostZonePortal;
import com.Symbols97.OPWeapons.blocks.init.OPWBlocks;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.management.Management;
import com.Symbols97.OPWeapons.world.dimension.OPWDimensions;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class FZStaff extends Item {
	public FZStaff() {
		super(new Properties().tab(OPWeapons.tabOPWeapons).stacksTo(1));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		if (context.getPlayer() != null) {
			if (context.getPlayer().level.dimension() == OPWDimensions.FZ_KEY
					|| context.getPlayer().level.dimension() == Level.OVERWORLD) {
				for (Direction direction : Direction.Plane.VERTICAL) {
					BlockPos framePos = context.getClickedPos().relative(direction);
					if (((FrostZonePortal) OPWBlocks.frost_zone_portal_block.get()).trySpawnPortal(context.getLevel(),
							framePos)) {
						context.getLevel().playSound(context.getPlayer(), framePos, SoundEvents.PORTAL_TRIGGER,
								SoundSource.BLOCKS, 1.0F, 1.0F);

						if (!context.getPlayer().getAbilities().instabuild) {
							Management.removeItems(context.getPlayer(), new ItemStack(OPWItems.frost_zone_staff.get()));
							context.getPlayer().getInventory().add(new ItemStack(OPWItems.neutral_staff.get()));
						}

						return InteractionResult.CONSUME;
					} else
						return InteractionResult.FAIL;
				}
			}

		}

		return InteractionResult.FAIL;
	}

	@Override
	public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> tooltip, TooltipFlag p_41424_) {
		tooltip.add(new TextComponent("§9Ignites the Frost Zone Portal"));
		super.appendHoverText(p_41421_, p_41422_, tooltip, p_41424_);
	}

}