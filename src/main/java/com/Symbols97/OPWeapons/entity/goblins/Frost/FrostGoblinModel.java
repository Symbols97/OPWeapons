package com.Symbols97.OPWeapons.entity.goblins.Frost;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.entity.goblins.GoblinEntity;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FrostGoblinModel extends AnimatedGeoModel<GoblinEntity> {
	
    @Override
    public ResourceLocation getModelLocation(GoblinEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/frost_goblin.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/goblins/frost_goblin.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GoblinEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/goblins.animation.json");
    }
}