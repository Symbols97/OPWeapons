package com.Symbols97.OPWeapons.entity.goblins.Frost;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.entity.goblins.GoblinEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FrostGoblinModel extends AnimatedGeoModel<GoblinEntity> {
	
    @Override
    public ResourceLocation getModelResource(GoblinEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/frost_goblin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoblinEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/goblins/frost_goblin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoblinEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/goblins.animation.json");
    }
}