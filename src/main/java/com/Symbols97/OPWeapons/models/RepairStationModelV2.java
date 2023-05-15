package com.Symbols97.OPWeapons.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * NewProject - Undefined
 * Created using Tabula 4.1.1
 */
public class RepairStationModelV2 extends ModelBase {
    public ModelRenderer paper;
    public ModelRenderer hand_stand;
    public ModelRenderer hand_base;
    public ModelRenderer ball_joint;
    public ModelRenderer arm;
    public ModelRenderer hand_palm;
    public ModelRenderer finger1;
    public ModelRenderer finger2;
    public ModelRenderer Leg1;
    public ModelRenderer Leg2;
    public ModelRenderer Leg3;
    public ModelRenderer Leg4;
    public ModelRenderer TableTop;
    public ModelRenderer TableBottom;
    public ModelRenderer TableMid;
    public ModelRenderer hammerhandle;
    public ModelRenderer hammerhead;

    public RepairStationModelV2() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.ball_joint = new ModelRenderer(this, 0, 0);
        this.ball_joint.setRotationPoint(-17.0F, -1.0F, 3.0F);
        this.ball_joint.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.hammerhandle = new ModelRenderer(this, 0, 9);
        this.hammerhandle.setRotationPoint(3.0F, 18.8F, 0.0F);
        this.hammerhandle.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
        this.setRotateAngle(hammerhandle, 0.0F, -2.5830872929516078F, 0.0F);
        this.Leg3 = new ModelRenderer(this, 0, 0);
        this.Leg3.setRotationPoint(-17.0F, 11.0F, 5.0F);
        this.Leg3.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.setRotateAngle(Leg3, 0.0F, 0.0F, 1.5707963267948966F);
        this.TableBottom = new ModelRenderer(this, 0, 4);
        this.TableBottom.setRotationPoint(-20.0F, 20.0F, -8.0F);
        this.TableBottom.addBox(0.0F, 0.0F, 0.0F, 40, 1, 16, 0.0F);
        this.Leg2 = new ModelRenderer(this, 0, 0);
        this.Leg2.setRotationPoint(-17.0F, 11.0F, -7.0F);
        this.Leg2.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.setRotateAngle(Leg2, 0.0F, 0.0F, 1.5707963267948966F);
        this.Leg4 = new ModelRenderer(this, 0, 0);
        this.Leg4.setRotationPoint(19.0F, 11.0F, 5.0F);
        this.Leg4.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.setRotateAngle(Leg4, 0.0F, 0.0F, 1.5707963267948966F);
        this.hand_base = new ModelRenderer(this, 0, 0);
        this.hand_base.setRotationPoint(-15.0F, 9.0F, 3.0F);
        this.hand_base.addBox(-1.5F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(hand_base, 0.0F, -0.7853981633974483F, 0.0F);
        this.paper = new ModelRenderer(this, 30, 0);
        this.paper.setRotationPoint(15.0F, 9.7F, 1.0F);
        this.paper.addBox(0.0F, 0.0F, 0.0F, 4, 1, 3, 0.0F);
        this.setRotateAngle(paper, 0.0F, 2.0943951023931953F, 0.0F);
        this.TableMid = new ModelRenderer(this, 0, 11);
        this.TableMid.setRotationPoint(-20.0F, 15.0F, -1.0F);
        this.TableMid.addBox(0.0F, 0.0F, 0.0F, 40, 1, 9, 0.0F);
        this.TableTop = new ModelRenderer(this, 0, 4);
        this.TableTop.setRotationPoint(-20.0F, 10.0F, -8.0F);
        this.TableTop.addBox(0.0F, 0.0F, 0.0F, 40, 1, 16, 0.0F);
        this.Leg1 = new ModelRenderer(this, 0, 0);
        this.Leg1.setRotationPoint(19.0F, 11.0F, -7.0F);
        this.Leg1.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.setRotateAngle(Leg1, 0.0F, 0.0F, 1.5707963267948966F);
        this.hand_palm = new ModelRenderer(this, 2, 0);
        this.hand_palm.setRotationPoint(-13.5F, 3.2F, 1.18F);
        this.hand_palm.addBox(0.1F, 0.2F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(hand_palm, 0.0F, 0.0F, 0.31869712141416456F);
        this.hammerhead = new ModelRenderer(this, 9, 1);
        this.hammerhead.setRotationPoint(3.7F, 18.8F, -0.8F);
        this.hammerhead.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.setRotateAngle(hammerhead, 0.0F, -2.5830872929516078F, 0.0F);
        this.hand_stand = new ModelRenderer(this, 0, 18);
        this.hand_stand.setRotationPoint(-15.0F, 3.4F, 3.0F);
        this.hand_stand.addBox(-2.4F, 0.7F, 0.4F, 8, 1, 1, 0.0F);
        this.setRotateAngle(hand_stand, 0.0F, 0.0F, 1.5707963267948966F);
        this.arm = new ModelRenderer(this, 13, 18);
        this.arm.setRotationPoint(-16.1F, -1.4F, 3.8F);
        this.arm.addBox(0.2F, 0.6F, -0.6F, 6, 1, 1, 0.0F);
        this.setRotateAngle(arm, 0.8196066167365371F, 0.4553564018453205F, 0.9105382707654417F);
        this.finger1 = new ModelRenderer(this, 2, 0);
        this.finger1.setRotationPoint(-13.5F, 3.2F, -0.1F);
        this.finger1.addBox(0.3F, 0.2F, 0.3F, 2, 1, 1, 0.0F);
        this.setRotateAngle(finger1, 0.0F, 0.0F, 0.31869712141416456F);
        this.finger2 = new ModelRenderer(this, 2, 0);
        this.finger2.setRotationPoint(-12.8F, 3.43F, 2.0F);
        this.finger2.addBox(-0.2F, 0.2F, -0.3F, 2, 1, 1, 0.0F);
        this.setRotateAngle(finger2, 0.0F, 0.0F, 0.31869712141416456F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.ball_joint.render(f5);
        this.hammerhandle.render(f5);
        this.Leg3.render(f5);
        this.TableBottom.render(f5);
        this.Leg2.render(f5);
        this.Leg4.render(f5);
        this.hand_base.render(f5);
        this.paper.render(f5);
        this.TableMid.render(f5);
        this.TableTop.render(f5);
        this.Leg1.render(f5);
        this.hand_palm.render(f5);
        this.hammerhead.render(f5);
        this.hand_stand.render(f5);
        this.arm.render(f5);
        this.finger1.render(f5);
        this.finger2.render(f5);
    }
	public void renderModel(float f) {
 	this.TableBottom.render(f);
        this.finger2.render(f);
        this.arm.render(f);
        this.Leg2.render(f);
        this.hammerhandle.render(f);
        this.Leg4.render(f);
        this.hand_base.render(f);
        this.finger1.render(f);
        this.hand_palm.render(f);
        this.TableMid.render(f);
        this.Leg3.render(f);
        this.TableTop.render(f);
        this.paper.render(f);
        this.ball_joint.render(f);
        this.hammerhead.render(f);
        this.Leg1.render(f);
        this.hand_stand.render(f);
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
