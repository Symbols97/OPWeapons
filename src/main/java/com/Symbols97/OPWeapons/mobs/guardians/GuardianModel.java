package com.Symbols97.OPWeapons.mobs.guardians;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GuardianModel extends ModelBiped {
//    public ModelRenderer Head1;
//    public ModelRenderer Body1;
//    public ModelRenderer LeftArm;
//    public ModelRenderer RightArm;
//    public ModelRenderer LeftLeg;
//    public ModelRenderer RightLeg;
    public ModelRenderer RightHorn1;
    public ModelRenderer RightHorn2;
    public ModelRenderer LeftHorn1;
    public ModelRenderer LeftHorn2;
    public ModelRenderer Gem1;
    public ModelRenderer Gem2;
    public ModelRenderer Gem3;
    public ModelRenderer Gem4;
    public ModelRenderer LeftSpike1;
    public ModelRenderer LeftSpike2;
    public ModelRenderer RightSpike1;
    public ModelRenderer RightSpike2;

    	public GuardianModel(float expand) {
        
       	super(expand,0,64,64);
       	
//        this.Body1 = new ModelRenderer(this, 16, 16);
//        this.Body1.setRotationPoint(-4.0F, 0.0F, -2.0F);
//        this.Body1.addBox(0.0F, 0.0F, 0.0F, 8, 12, 4, 0.0F);
//        this.LeftArm = new ModelRenderer(this, 40, 16);
//        this.LeftArm.mirror = true;
//        this.LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
//        this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RightHorn2 = new ModelRenderer(this, 12, 41);
        this.RightHorn2.setRotationPoint(-5.4F, -11.5F, -2.0F);
        this.RightHorn2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
//        this.RightLeg = new ModelRenderer(this, 0, 16);
//        this.RightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
//        this.RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
//        this.RightArm = new ModelRenderer(this, 40, 16);
//        this.RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
//        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
//        this.LeftLeg = new ModelRenderer(this, 0, 16);
//        this.LeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
//        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
//        this.Head1 = new ModelRenderer(this, 0, 0);
//        this.Head1.setRotationPoint(0.0F, 0.0F, 0.0F);
//        this.Head1.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Gem3 = new ModelRenderer(this, 51, 44);
        this.Gem3.setRotationPoint(-2.0F, 3.0F, -2.7F);
        this.Gem3.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
        this.RightHorn1 = new ModelRenderer(this, 1, 42);
        this.RightHorn1.setRotationPoint(-5.0F, -9.0F, -2.5F);
        this.RightHorn1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.RightSpike2 = new ModelRenderer(this, 3, 49);
        this.RightSpike2.setRotationPoint(-2.9F, -4.8F, -0.5F);
        this.RightSpike2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(RightSpike2, 0.0F, 0.0F, 0.015707963267948967F);
        this.LeftSpike2 = new ModelRenderer(this, 20, 49);
        this.LeftSpike2.setRotationPoint(1.9F, -4.8F, -0.5F);
        this.LeftSpike2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(LeftSpike2, 0.0F, 0.0F, 0.015707963267948967F);
        this.RightSpike1 = new ModelRenderer(this, 1, 53);
        this.RightSpike1.setRotationPoint(-3.5F, -3.3F, -1.0F);
        this.RightSpike1.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(RightSpike1, 0.0F, 0.0F, -0.15707963267948966F);
        this.Gem2 = new ModelRenderer(this, 44, 42);
        this.Gem2.setRotationPoint(-1.0F, 1.8F, -2.6F);
        this.Gem2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.LeftHorn1 = new ModelRenderer(this, 1, 35);
        this.LeftHorn1.setRotationPoint(3.0F, -9.0F, -2.5F);
        this.LeftHorn1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.LeftHorn2 = new ModelRenderer(this, 12, 34);
        this.LeftHorn2.setRotationPoint(3.4F, -11.5F, -2.0F);
        this.LeftHorn2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.Gem4 = new ModelRenderer(this, 36, 36);
        this.Gem4.setRotationPoint(-0.5F, 1.5F, -2.4F);
        this.Gem4.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Gem4, 0.0F, 0.0F, -0.02775073510670984F);
        this.Gem1 = new ModelRenderer(this, 35, 43);
        this.Gem1.setRotationPoint(-1.5F, 1.5F, -1.8F);
        this.Gem1.addBox(0.0F, 1.0F, -1.0F, 3, 3, 1, 0.0F);
        this.LeftSpike1 = new ModelRenderer(this, 18, 53);
        this.LeftSpike1.setRotationPoint(3.5F, -3.3F, -1.0F);
        this.LeftSpike1.addBox(-2.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(LeftSpike1, 0.0F, 0.0F, 0.15707963267948966F);
    
        
        
        
        
        this.bipedBody.addChild(Gem1);
        this.bipedBody.addChild(Gem2);
        this.bipedBody.addChild(Gem3);
        this.bipedBody.addChild(Gem4);
        
        this.bipedHead.addChild(LeftHorn1);
        this.bipedHead.addChild(LeftHorn2);
        this.bipedHead.addChild(RightHorn1);
        this.bipedHead.addChild(RightHorn2);
        
        this.bipedLeftArm.addChild(LeftSpike1);
        this.bipedLeftArm.addChild(LeftSpike2);
        
        this.bipedRightArm.addChild(RightSpike1);
        this.bipedRightArm.addChild(RightSpike2);
        
        
        
        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
