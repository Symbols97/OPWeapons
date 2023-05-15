package com.Symbols97.OPWeapons.models.items_tools_weapons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class FrostAxeModel extends ModelBase {
    public ModelRenderer Handle1;
    public ModelRenderer Handle2;
    public ModelRenderer Handle3;
    public ModelRenderer AxeHead1;

    public FrostAxeModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.AxeHead1 = new ModelRenderer(this, 23, 0);
        this.AxeHead1.setRotationPoint(0.0F, -7.3F, -9.0F);
        this.AxeHead1.addBox(0.0F, 0.0F, 0.0F, 0, 8, 17, 0.0F);
        this.Handle3 = new ModelRenderer(this, 0, 36);
        this.Handle3.setRotationPoint(-1.5F, 17.0F, -1.3F);
        this.Handle3.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.Handle1 = new ModelRenderer(this, 0, 0);
        this.Handle1.setRotationPoint(-1.0F, -8.3F, -1.3F);
        this.Handle1.addBox(0.0F, 0.0F, 0.0F, 2, 18, 3, 0.0F);
        this.Handle2 = new ModelRenderer(this, 0, 23);
        this.Handle2.setRotationPoint(-1.0F, 9.5F, -1.8F);
        this.Handle2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.AxeHead1.render(f5);
        this.Handle3.render(f5);
        this.Handle1.render(f5);
        this.Handle2.render(f5);
    }

    public void renderModel(float f5) {
    	  this.AxeHead1.render(f5);
          this.Handle3.render(f5);
          this.Handle1.render(f5);
          this.Handle2.render(f5);
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