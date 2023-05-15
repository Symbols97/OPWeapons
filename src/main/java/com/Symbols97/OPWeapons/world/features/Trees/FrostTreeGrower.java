package com.Symbols97.OPWeapons.world.features.Trees;

import java.util.Random;

import com.Symbols97.OPWeapons.world.features.Features;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class FrostTreeGrower extends AbstractTreeGrower {

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
		// TODO Auto-generated method stub
		return Features.FROST_TREE;
	}

}
