package com.Symbols97.OPWeapons.entity.guardians.Frost;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FrostGuardianModel extends AnimatedGeoModel<FrostGuardianEntity> {
	
    @Override
    public ResourceLocation getModelLocation(FrostGuardianEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/guardians.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(FrostGuardianEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/guardians/op_guardian.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FrostGuardianEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/guardians.animation.json");
    }
}