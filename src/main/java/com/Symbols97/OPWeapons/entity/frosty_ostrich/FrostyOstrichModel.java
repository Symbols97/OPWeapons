package com.Symbols97.OPWeapons.entity.frosty_ostrich;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FrostyOstrichModel extends AnimatedGeoModel<FrostyOstrichEntity> {
	
    @Override
    public ResourceLocation getModelLocation(FrostyOstrichEntity object) {
        return new ResourceLocation(OPWeapons.MOD_ID, "geo/frosty_ostrich.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(FrostyOstrichEntity object) {
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/frosty_ostrich.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FrostyOstrichEntity animatable) {
        return new ResourceLocation(OPWeapons.MOD_ID, "animations/frosty_ostrich.animation.json");
    }
}
