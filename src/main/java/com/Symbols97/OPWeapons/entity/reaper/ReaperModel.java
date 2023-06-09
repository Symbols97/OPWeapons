package com.Symbols97.OPWeapons.entity.reaper;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ReaperModel extends AnimatedGeoModel<ReaperEntity> {
	
    @Override
    public ResourceLocation getModelResource(ReaperEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/reaper_mob.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ReaperEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/reaper_mob.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ReaperEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/reaper_mob.animation.json");
    }
}