package com.Symbols97.OPWeapons.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * RepairStationModel - Undefined
 * Created using Tabula 4.1.1
 */
public class RepairStationModel extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;

    public RepairStationModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape4 = new ModelRenderer(this, 0, 0);
        this.shape4.setRotationPoint(7.0F, 11.0F, 5.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.setRotateAngle(shape4, 0.0F, 0.0F, 1.5707963267948966F);
        this.shape5 = new ModelRenderer(this, 0, 8);
        this.shape5.setRotationPoint(-8.0F, 10.0F, -8.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 0);
        this.shape2.setRotationPoint(-5.0F, 11.0F, -7.0F);
        this.shape2.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.setRotateAngle(shape2, 0.0F, 0.0F, 1.5707963267948966F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(7.0F, 11.0F, -7.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.setRotateAngle(shape1, 0.0F, 0.0F, 1.5707963267948966F);
        this.shape3 = new ModelRenderer(this, 0, 0);
        this.shape3.setRotationPoint(-5.0F, 11.0F, 5.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
        this.setRotateAngle(shape3, 0.0F, 0.0F, 1.5707963267948966F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape4.render(f5);
        this.shape5.render(f5);
        this.shape2.render(f5);
        this.shape1.render(f5);
        this.shape3.render(f5);
    }
    public void renderModel(float f) {
    	this.shape4.render(f);
        this.shape5.render(f);
        this.shape2.render(f);
        this.shape1.render(f);
        this.shape3.render(f);
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
