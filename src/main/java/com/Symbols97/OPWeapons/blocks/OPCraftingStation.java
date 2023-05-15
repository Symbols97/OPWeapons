package com.Symbols97.OPWeapons.blocks;

import com.Symbols97.OPWeapons.screen.opcraftingstation.OPCraftingStationMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class OPCraftingStation extends Block {

	private static final Component CONTAINER_TITLE = new TextComponent("§0OP Crafting Station");

	public OPCraftingStation(Properties p_49224_) {
		super(p_49224_);
		
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	public InteractionResult use(BlockState p_52233_, Level p_52234_, BlockPos p_52235_, Player p_52236_,
			InteractionHand p_52237_, BlockHitResult p_52238_) {
		if (p_52234_.isClientSide) {
			return InteractionResult.SUCCESS;
		} else {
			p_52236_.openMenu(p_52233_.getMenuProvider(p_52234_, p_52235_));
			return InteractionResult.CONSUME;
		}
	}

	public MenuProvider getMenuProvider(BlockState p_52240_, Level p_52241_, BlockPos p_52242_) {
		return new SimpleMenuProvider((p_52229_, p_52230_, p_52231_) -> {
			return new OPCraftingStationMenu(p_52229_, p_52230_, ContainerLevelAccess.create(p_52241_, p_52242_));
		}, CONTAINER_TITLE);
	}

}