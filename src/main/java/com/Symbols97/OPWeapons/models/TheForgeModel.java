package com.Symbols97.OPWeapons.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ArmorForge - Symbols97
 * Created using Tabula 4.1.1
 */
public class TheForgeModel extends ModelBase {
    public ModelRenderer base;
    public ModelRenderer monitor;
    public ModelRenderer stand;
    public ModelRenderer pivot;
    public ModelRenderer stand2;
    public ModelRenderer handle;

    public TheForgeModel() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.monitor = new ModelRenderer(this, 0, 61);
        this.monitor.setRotationPoint(0.0F, -1.0F, 0.7F);
        this.monitor.addBox(-5.0F, -5.0F, -1.0F, 10, 10, 1, 0.0F);
        this.stand2 = new ModelRenderer(this, 0, 0);
        this.stand2.setRotationPoint(0.0F, -2.6F, 4.199999999999999F);
        this.stand2.addBox(-1.0F, -1.0F, -1.0F, 2, 9, 2, 0.0F);
        this.stand = new ModelRenderer(this, 0, 0);
        this.stand.setRotationPoint(0.0F, 9.0F, 0.7F);
        this.stand.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(stand, 0.6829473363053812F, 0.0F, 0.0F);
        this.pivot = new ModelRenderer(this, 0, 0);
        this.pivot.setRotationPoint(-0.5F, 6.0F, 4.199999999999999F);
        this.pivot.addBox(-1.0F, -1.0F, -1.0F, 3, 2, 2, 0.0F);
        this.base = new ModelRenderer(this, 0, 23);
        this.base.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.base.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F);
        this.handle = new ModelRenderer(this, 0, 0);
        this.handle.setRotationPoint(0.0F, -2.6F, 1.7000000000000006F);
        this.handle.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.monitor.render(f5);
        this.stand2.render(f5);
        this.stand.render(f5);
        this.pivot.render(f5);
        this.base.render(f5);
        this.handle.render(f5);
    }
    public void renderModel(float f) {
    	this.monitor.render(f);
        this.stand2.render(f);
        this.stand.render(f);
        this.pivot.render(f);
        this.base.render(f);
        this.handle.render(f);
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
