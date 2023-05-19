package com.Symbols97.OPWeapons.armors.models;


import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armors.ReaperArmor;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ReaperArmorModel extends AnimatedGeoModel<ReaperArmor> {

	@Override
	public ResourceLocation getModelResource(ReaperArmor object) {
		return new ResourceLocation(OPWeapons.MOD_ID, "geo/reaper_armor_model.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ReaperArmor object) {
		return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/armor/reaperarmormodel.png");
	}

	@Override
	public ResourceLocation getAnimationResource(ReaperArmor animatable) {
		return new ResourceLocation(OPWeapons.MOD_ID, "animations/idle.animation.json");
	}

}
