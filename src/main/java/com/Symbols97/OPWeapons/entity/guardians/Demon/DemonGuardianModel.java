package com.Symbols97.OPWeapons.entity.guardians.Demon;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DemonGuardianModel extends AnimatedGeoModel<DemonGuardianEntity> {
	
    @Override
    public ResourceLocation getModelResource(DemonGuardianEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/guardians.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DemonGuardianEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/guardians/op_guardian.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DemonGuardianEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/guardians.animation.json");
    }
}