package com.Symbols97.OPWeapons.armors.models;

import com.Symbols97.OPWeapons.armors.ReaperArmor;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ReaperArmorRenderer extends GeoArmorRenderer<ReaperArmor> {

	public ReaperArmorRenderer() {
		super(new ReaperArmorModel());
		// TODO Auto-generated constructor stub

		this.headBone = "Head";
		this.bodyBone = "Body";
		this.rightArmBone = "RightArm";
		this.leftArmBone = "LeftArm";
		this.rightLegBone = "RightLeg";
		this.leftLegBone = "LeftLeg";
		this.rightBootBone = null;
		this.leftBootBone = null;
	}
}
