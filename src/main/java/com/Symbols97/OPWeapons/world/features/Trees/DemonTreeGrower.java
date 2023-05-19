package com.Symbols97.OPWeapons.world.features.Trees;

import com.Symbols97.OPWeapons.world.features.Features;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class DemonTreeGrower extends AbstractTreeGrower{

	@Override
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_204307_, boolean p_204308_) {
		// TODO Auto-generated method stub
		return Features.DEMON_TREE.getHolder().get();
	}

}
