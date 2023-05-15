package com.Symbols97.OPWeapons.models.items_tools_weapons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class OPClubModel extends ModelBase {
    public ModelRenderer Handle1;
    public ModelRenderer Knobbottom1;
    public ModelRenderer Knobbottom2;
    public ModelRenderer ThickClub1;
    public ModelRenderer ThickClub2;
    public ModelRenderer ThickClub3;
    public ModelRenderer ThickClubTop;
    public ModelRenderer Knobbottom3;

    public OPClubModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Handle1 = new ModelRenderer(this, 0, 0);
        this.Handle1.setRotationPoint(-1.0F, 0.0F, -1.0F);
        this.Handle1.addBox(0.0F, 0.0F, 0.0F, 2, 17, 2, 0.0F);
        this.ThickClub2 = new ModelRenderer(this, 29, 18);
        this.ThickClub2.setRotationPoint(-1.0F, -2.0F, -2.5F);
        this.ThickClub2.addBox(0.0F, 0.0F, 0.0F, 2, 6, 5, 0.0F);
        this.Knobbottom3 = new ModelRenderer(this, 10, 4);
        this.Knobbottom3.setRotationPoint(-2.0F, 14.0F, 1.0F);
        this.Knobbottom3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(Knobbottom3, 0.0F, 1.5707963267948966F, 0.0F);
        this.Knobbottom1 = new ModelRenderer(this, 10, 11);
        this.Knobbottom1.setRotationPoint(-1.5F, 13.5F, -1.5F);
        this.Knobbottom1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
        this.Knobbottom2 = new ModelRenderer(this, 10, 4);
        this.Knobbottom2.setRotationPoint(-1.0F, 14.0F, -2.0F);
        this.Knobbottom2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4, 0.0F);
        this.ThickClub1 = new ModelRenderer(this, 10, 18);
        this.ThickClub1.setRotationPoint(-2.0F, -2.5F, -2.0F);
        this.ThickClub1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 4, 0.0F);
        this.ThickClubTop = new ModelRenderer(this, 30, 5);
        this.ThickClubTop.setRotationPoint(-1.0F, -3.0F, -1.0F);
        this.ThickClubTop.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.ThickClub3 = new ModelRenderer(this, 40, 10);
        this.ThickClub3.setRotationPoint(-2.5F, -2.0F, -1.0F);
        this.ThickClub3.addBox(0.0F, 0.0F, 0.0F, 5, 6, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Handle1.render(f5);
        this.ThickClub2.render(f5);
        this.Knobbottom3.render(f5);
        this.Knobbottom1.render(f5);
        this.Knobbottom2.render(f5);
        this.ThickClub1.render(f5);
        this.ThickClubTop.render(f5);
        this.ThickClub3.render(f5);
    }
    
    public void renderModel(float f5) {
    	 this.Handle1.render(f5);
         this.ThickClub2.render(f5);
         this.Knobbottom3.render(f5);
         this.Knobbottom1.render(f5);
         this.Knobbottom2.render(f5);
         this.ThickClub1.render(f5);
         this.ThickClubTop.render(f5);
         this.ThickClub3.render(f5);
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
