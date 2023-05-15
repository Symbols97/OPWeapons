package com.Symbols97.OPWeapons.models.items_tools_weapons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ReaperScytheModel extends ModelBase {
    
	public ModelRenderer Handle1;
    public ModelRenderer Blade1;
    public ModelRenderer Blade2;
    public ModelRenderer Blade3;
    public ModelRenderer Blade4;
    public ModelRenderer Skulltop1;

    public ReaperScytheModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Blade2 = new ModelRenderer(this, 26, 1);
        this.Blade2.setRotationPoint(5.1F, -0.8F, 0.5F);
        this.Blade2.addBox(0.0F, 0.0F, 0.0F, 7, 4, 1, 0.0F);
        this.setRotateAngle(Blade2, 0.0F, 0.0F, 0.22689280275926282F);
        this.Skulltop1 = new ModelRenderer(this, 11, 12);
        this.Skulltop1.setRotationPoint(-0.5F, -2.6F, -0.5F);
        this.Skulltop1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.Blade3 = new ModelRenderer(this, 10, 7);
        this.Blade3.setRotationPoint(9.0F, 0.5F, 0.5F);
        this.Blade3.addBox(0.0F, 0.0F, 0.0F, 6, 3, 1, 0.0F);
        this.setRotateAngle(Blade3, 0.0F, 0.0F, 0.3647738136668149F);
        this.Blade4 = new ModelRenderer(this, 27, 7);
        this.Blade4.setRotationPoint(11.5F, 1.6F, 0.5F);
        this.Blade4.addBox(0.0F, 0.0F, 0.0F, 7, 2, 1, 0.0F);
        this.setRotateAngle(Blade4, 0.0F, 0.0F, 0.5462880558742251F);
        this.Handle1 = new ModelRenderer(this, 0, 0);
        this.Handle1.setRotationPoint(-1.0F, -5.0F, 0.5F);
        this.Handle1.addBox(0.0F, 0.0F, 0.0F, 2, 30, 2, 0.0F);
        this.setRotateAngle(Handle1, 0.0F, 1.5707963267948966F, 0.0F);
        this.Blade1 = new ModelRenderer(this, 9, 1);
        this.Blade1.setRotationPoint(-1.5F, 0.0F, 0.5F);
        this.Blade1.addBox(0.0F, 0.0F, 0.0F, 7, 4, 1, 0.0F);
        this.setRotateAngle(Blade1, 0.0F, 0.0F, -0.09075712110370514F);
        this.Handle1.addChild(this.Blade2);
        this.Handle1.addChild(this.Skulltop1);
        this.Handle1.addChild(this.Blade3);
        this.Handle1.addChild(this.Blade4);
        this.Handle1.addChild(this.Blade1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Handle1.render(f5);
    }

    
    
    public void renderModel(float f5) {
    	this.Handle1.render(f5);
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
