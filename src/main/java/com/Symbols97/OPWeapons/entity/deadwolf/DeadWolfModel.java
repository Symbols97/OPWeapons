package com.Symbols97.OPWeapons.entity.deadwolf;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DeadWolfModel extends AnimatedGeoModel<DeadWolfEntity> {
	
    @Override
    public ResourceLocation getModelLocation(DeadWolfEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/dead_wolf.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DeadWolfEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/dead_wolf/dead_wolf.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DeadWolfEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/dead_wolf.animation.json");
    }
}
