package com.Symbols97.OPWeapons.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Freezer - Undefined
 * Created using Tabula 4.1.1
 */
public class FreezerModel extends ModelBase {
    public ModelRenderer freezerbase;
    public ModelRenderer glass;
    public ModelRenderer ice;
    public ModelRenderer keypad;
    public ModelRenderer coil1base;
    public ModelRenderer coil1shaft;
    public ModelRenderer coil1top;
    public ModelRenderer coil1connector;
    public ModelRenderer coil2base;
    public ModelRenderer coil2shaft;
    public ModelRenderer coil2top;
    public ModelRenderer coil2connector;
    public ModelRenderer coil3base;
    public ModelRenderer coil3base_1;
    public ModelRenderer coil3top;
    public ModelRenderer coil3connector;

    public FreezerModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.coil1connector = new ModelRenderer(this, 0, 55);
        this.coil1connector.setRotationPoint(2.0F, 5.53F, 5.15F);
        this.coil1connector.addBox(0.0F, 0.0F, -1.5F, 1, 1, 2, 0.0F);
        this.freezerbase = new ModelRenderer(this, 0, 28);
        this.freezerbase.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.freezerbase.addBox(-6.0F, -6.0F, -6.0F, 12, 14, 12, 0.0F);
        this.keypad = new ModelRenderer(this, 20, 0);
        this.keypad.setRotationPoint(0.0F, 14.0F, -6.0F);
        this.keypad.addBox(-4.0F, 0.0F, -4.0F, 8, 1, 4, 0.0F);
        this.setRotateAngle(keypad, 0.7853981633974483F, 0.0F, 0.0F);
        this.coil2top = new ModelRenderer(this, 0, 55);
        this.coil2top.setRotationPoint(0.0F, 6.59F, 6.71F);
        this.coil2top.addBox(-0.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(coil2top, -0.7853981633974483F, 0.0F, 0.0F);
        this.coil3base_1 = new ModelRenderer(this, 0, 55);
        this.coil3base_1.setRotationPoint(-3.0F, 7.65F, 7.27F);
        this.coil3base_1.addBox(0.0F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
        this.glass = new ModelRenderer(this, 0, 12);
        this.glass.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.glass.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
        this.ice = new ModelRenderer(this, 0, 0);
        this.ice.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.ice.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(ice, 0.0F, 0.7853981633974483F, 0.0F);
        this.coil3base = new ModelRenderer(this, 0, 55);
        this.coil3base.setRotationPoint(-3.0F, 16.0F, 6.0F);
        this.coil3base.addBox(0.0F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(coil3base, 0.7853981633974483F, 0.0F, 0.0F);
        this.coil1top = new ModelRenderer(this, 0, 55);
        this.coil1top.setRotationPoint(2.0F, 6.59F, 6.71F);
        this.coil1top.addBox(0.0F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(coil1top, -0.7853981633974483F, 0.0F, -0.0017453292519943296F);
        this.coil2connector = new ModelRenderer(this, 0, 55);
        this.coil2connector.setRotationPoint(-0.5F, 5.53F, 5.15F);
        this.coil2connector.addBox(0.0F, 0.0F, -1.5F, 1, 1, 2, 0.0F);
        this.coil3top = new ModelRenderer(this, 0, 55);
        this.coil3top.setRotationPoint(-3.0F, 6.59F, 6.71F);
        this.coil3top.addBox(0.0F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(coil3top, -0.7853981633974483F, 0.0F, 0.0F);
        this.coil2shaft = new ModelRenderer(this, 0, 55);
        this.coil2shaft.setRotationPoint(-0.5F, 7.65F, 7.27F);
        this.coil2shaft.addBox(0.0F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
        this.coil3connector = new ModelRenderer(this, 0, 55);
        this.coil3connector.setRotationPoint(-3.0F, 5.53F, 5.15F);
        this.coil3connector.addBox(0.0F, 0.0F, -1.5F, 1, 1, 2, 0.0F);
        this.coil1base = new ModelRenderer(this, 0, 55);
        this.coil1base.setRotationPoint(2.0F, 16.0F, 6.0F);
        this.coil1base.addBox(0.0F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(coil1base, 0.7853981633974483F, 0.0F, 0.0F);
        this.coil2base = new ModelRenderer(this, 0, 55);
        this.coil2base.setRotationPoint(-0.5F, 16.0F, 6.0F);
        this.coil2base.addBox(0.0F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
        this.setRotateAngle(coil2base, 0.7853981633974483F, 0.0F, 0.0F);
        this.coil1shaft = new ModelRenderer(this, 0, 55);
        this.coil1shaft.setRotationPoint(2.0F, 7.65F, 7.27F);
        this.coil1shaft.addBox(0.0F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.coil1connector.render(f5);
        this.freezerbase.render(f5);
        this.keypad.render(f5);
        this.coil2top.render(f5);
        this.coil3base_1.render(f5);
        this.glass.render(f5);
        this.ice.render(f5);
        this.coil3base.render(f5);
        this.coil1top.render(f5);
        this.coil2connector.render(f5);
        this.coil3top.render(f5);
        this.coil2shaft.render(f5);
        this.coil3connector.render(f5);
        this.coil1base.render(f5);
        this.coil2base.render(f5);
        this.coil1shaft.render(f5);
    }
    public void renderModel(float f) {
    	this.coil1connector.render(f);
        this.freezerbase.render(f);
        this.keypad.render(f);
        this.coil2top.render(f);
        this.coil3base_1.render(f);
        this.glass.render(f);
        this.ice.render(f);
        this.coil3base.render(f);
        this.coil1top.render(f);
        this.coil2connector.render(f);
        this.coil3top.render(f);
        this.coil2shaft.render(f);
        this.coil3connector.render(f);
        this.coil1base.render(f);
        this.coil2base.render(f);
        this.coil1shaft.render(f);
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
