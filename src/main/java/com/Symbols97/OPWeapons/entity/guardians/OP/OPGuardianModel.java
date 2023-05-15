package com.Symbols97.OPWeapons.entity.guardians.OP;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class OPGuardianModel extends AnimatedGeoModel<OPGuardianEntity> {
	
    @Override
    public ResourceLocation getModelLocation(OPGuardianEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/guardians.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(OPGuardianEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/guardians/op_guardian.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(OPGuardianEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/guardians.animation.json");
    }
}