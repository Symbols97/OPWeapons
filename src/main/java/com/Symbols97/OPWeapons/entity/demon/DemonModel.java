package com.Symbols97.OPWeapons.entity.demon;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DemonModel extends AnimatedGeoModel<DemonEntity> {
	
    @Override
    public ResourceLocation getModelResource(DemonEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/demon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DemonEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/demon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DemonEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/demon.animation.json");
    }

}
