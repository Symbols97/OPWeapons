package com.Symbols97.OPWeapons.mobs.Demon;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

/**
 * ModelZombie - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class DemonModel extends ModelBiped {
	
	
	 public ModelRenderer RightArm;
	 public ModelRenderer LeftLeg;
	 public ModelRenderer HairBack;
	 public ModelRenderer lefthorntop;
	 public ModelRenderer lefthornbottom;
	 public ModelRenderer righthorntop;
	 public ModelRenderer righthornbottom;

	 
	 public DemonModel(float expand) {
     
    	super(expand,0,64,64);
    	
    	this.HairBack = new ModelRenderer(this, 24, 0);
        this.HairBack.setRotationPoint(0.0F, -8.0F, 4.0F);
        this.HairBack.addBox(-4.0F, 0.0F, 0.0F, 8, 8, 0, 0.0F);
        this.setRotation(HairBack, 0.18151424220741028F, 0.0F, 0.0F);
     
        
        this.LeftLeg = new ModelRenderer(this, 0, 32);
        this.LeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        
        this.RightArm = new ModelRenderer(this, 40, 32);
        this.RightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
             
        this.righthorntop = new ModelRenderer(this, 0, 0);
        this.righthorntop.setRotationPoint(-4.5F, -10.2F, -1.0F);
        this.righthorntop.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotation(righthorntop, 0.01308996938995747F, 0.0F, 0.8726646259971648F);
        
        this.righthornbottom = new ModelRenderer(this, 0, 0);
        this.righthornbottom.setRotationPoint(-3.5F, -9.0F, -1.0F);
        this.righthornbottom.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotation(righthornbottom, 0.01308996938995747F, 0.0F, 0.6806784082777886F);
        
        this.lefthorntop = new ModelRenderer(this, 0, 0);
        this.lefthorntop.setRotationPoint(3.2F, -8.7F, -1.0F);
        this.lefthorntop.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotation(lefthorntop, 0.01308996938995747F, 0.0F, -0.8726646259971648F);
        
        this.lefthornbottom = new ModelRenderer(this, 0, 0);
        this.lefthornbottom.setRotationPoint(1.9F, -7.7F, -1.0F);
        this.lefthornbottom.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
        this.setRotation(lefthornbottom, 0.01308996938995747F, 0.0F, -0.6806784082777886F);
   
        this.bipedHead.addChild(HairBack);
        this.bipedLeftLeg.addChild(LeftLeg);
        this.bipedRightArm.addChild(RightArm);
        this.bipedHead.addChild(lefthornbottom);
        this.bipedHead.addChild(righthornbottom);
        this.bipedHead.addChild(lefthorntop);
        this.bipedHead.addChild(righthorntop);
     
    
     

     
 }

 public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     super.render(entity, f, f1, f2, f3, f4, f5);
     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
     
   }
   
   private void setRotation(ModelRenderer model, float x, float y, float z)
   {
     model.rotateAngleX = x;
     model.rotateAngleY = y;
     model.rotateAngleZ = z;
   }
}
