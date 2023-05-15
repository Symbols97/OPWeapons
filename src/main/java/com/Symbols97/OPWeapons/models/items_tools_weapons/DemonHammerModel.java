package com.Symbols97.OPWeapons.models.items_tools_weapons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DemonHammerModel extends ModelBase {
    public ModelRenderer Handle1;
    public ModelRenderer HammerHead1;
    public ModelRenderer Knotch1;
    public ModelRenderer Handgrip1;

    public DemonHammerModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Handle1 = new ModelRenderer(this, 17, 0);
        this.Handle1.setRotationPoint(-1.0F, 0.0F, -1.0F);
        this.Handle1.addBox(0.0F, 0.0F, 0.0F, 2, 19, 2, 0.0F);
        this.Handgrip1 = new ModelRenderer(this, 0, 9);
        this.Handgrip1.setRotationPoint(-1.5F, 11.0F, -1.5F);
        this.Handgrip1.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.HammerHead1 = new ModelRenderer(this, 27, 0);
        this.HammerHead1.setRotationPoint(-3.5F, 0.5F, -5.5F);
        this.HammerHead1.addBox(0.0F, 0.0F, 0.0F, 7, 5, 11, 0.0F);
        this.Knotch1 = new ModelRenderer(this, 0, 0);
        this.Knotch1.setRotationPoint(-2.0F, 18.5F, -2.0F);
        this.Knotch1.addBox(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Handle1.render(f5);
        this.Handgrip1.render(f5);
        this.HammerHead1.render(f5);
        this.Knotch1.render(f5);
    }
    
    
    public void renderModel(float f5) {
    	this.Handle1.render(f5);
        this.Handgrip1.render(f5);
        this.HammerHead1.render(f5);
        this.Knotch1.render(f5);
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