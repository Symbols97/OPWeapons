package com.Symbols97.OPWeapons.mobs.DeadWolf;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

/**
 * ModelWolf - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class DeadWolfModel extends ModelBase {
	public ModelRenderer frontleft;
    public ModelRenderer chest;
    public ModelRenderer body;
    public ModelRenderer backleft;
    public ModelRenderer backright;
    public ModelRenderer frontright;
    public ModelRenderer head;
    public ModelRenderer earright;
    public ModelRenderer earleft;
    public ModelRenderer mouth;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    public ModelRenderer Spikerightlower;
    public ModelRenderer Spikeleftlower;
    public ModelRenderer Spikerightmid;
    public ModelRenderer Spikeleftmid;
    public ModelRenderer Spikerightupper;
    public ModelRenderer Spikeleftupper;
    public ModelRenderer SpikerightMane;
    public ModelRenderer SpikeleftMane;

    public DeadWolfModel() {
    	this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(-1.3877787807814457E-16F, 13.5F, -7.0F);
        this.head.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4, 0.6F);
        this.Spikerightlower = new ModelRenderer(this, 47, 0);
        this.Spikerightlower.setRotationPoint(-0.4F, 8.6F, 7.4F);
        this.Spikerightlower.addBox(0.6F, 0.0F, 0.0F, 1, 2, 1, 0.4F);
        this.setRotation(Spikerightlower, 0.0F, 0.0F, 0.7853981633974483F);
        this.SpikeleftMane = new ModelRenderer(this, 47, 0);
        this.SpikeleftMane.setRotationPoint(-1.1F, 9.4F, -3.1F);
        this.SpikeleftMane.addBox(0.6F, 0.0F, 0.0F, 1, 2, 1, 0.8F);
        this.setRotation(SpikeleftMane, 0.0F, 0.0F, -0.7853981633974483F);
        this.Spikeleftlower = new ModelRenderer(this, 47, 0);
        this.Spikeleftlower.setRotationPoint(-1.1F, 10.1F, 7.4F);
        this.Spikeleftlower.addBox(0.6F, 0.0F, 0.0F, 1, 2, 1, 0.4F);
        this.setRotation(Spikeleftlower, 0.0F, 0.0F, -0.7853981633974483F);
        this.SpikerightMane = new ModelRenderer(this, 47, 0);
        this.SpikerightMane.setRotationPoint(-0.4F, 7.9F, -3.1F);
        this.SpikerightMane.addBox(0.6F, 0.0F, 0.0F, 1, 2, 1, 0.8F);
        this.setRotation(SpikerightMane, 0.0F, 0.0F, 0.7853981633974483F);
        this.earleft = new ModelRenderer(this, 16, 14);
        this.earleft.setRotationPoint(0F, 0F, 0F);
        this.earleft.addBox(1.0F, -5.0F, 0.0F, 2, 2, 1, 0.6F);
        this.mouth = new ModelRenderer(this, 0, 10);
        this.mouth.setRotationPoint(0F, 0F, 0F);
        this.mouth.addBox(-1.5F, 0.0F, -5.0F, 3, 3, 4, 0.6F);
        this.Spikerightmid = new ModelRenderer(this, 47, 0);
        this.Spikerightmid.setRotationPoint(-0.4F, 8.6F, 4.5F);
        this.Spikerightmid.addBox(0.6F, 0.0F, 0.0F, 1, 2, 1, 0.4F);
        this.setRotation(Spikerightmid, 0.0F, 0.0F, 0.7853981633974483F);
        this.tail1 = new ModelRenderer(this, 9, 18);
        this.tail1.setRotationPoint(-0.9999999999999992F, 13.0F, 8.8F);
        this.tail1.addBox(-1.0F, 0.0F, -1.0F, 1, 8, 2, 0.6F);
        this.setRotation(tail1, 0.7155849933176751F, 0.0F, 0.0F);
        this.frontright = new ModelRenderer(this, 0, 18);
        this.frontright.setRotationPoint(-1.899999999999999F, 16.0F, -4.0F);
        this.frontright.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.6F);
        this.Spikeleftmid = new ModelRenderer(this, 47, 0);
        this.Spikeleftmid.setRotationPoint(-1.1F, 10.1F, 4.5F);
        this.Spikeleftmid.addBox(0.6F, 0.0F, 0.0F, 1, 2, 1, 0.4F);
        this.setRotation(Spikeleftmid, 0.0F, 0.0F, -0.7853981633974483F);
        this.frontleft = new ModelRenderer(this, 0, 18);
        this.frontleft.setRotationPoint(1.9000000000000008F, 16.0F, -4.0F);
        this.frontleft.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.6F);
        this.Spikerightupper = new ModelRenderer(this, 47, 0);
        this.Spikerightupper.setRotationPoint(-0.4F, 8.6F, 1.6F);
        this.Spikerightupper.addBox(0.6F, 0.0F, 0.0F, 1, 2, 1, 0.4F);
        this.setRotation(Spikerightupper, 0.0F, 0.0F, 0.7853981633974483F);
        this.Spikeleftupper = new ModelRenderer(this, 47, 0);
        this.Spikeleftupper.setRotationPoint(-1.1F, 10.1F, 1.6F);
        this.Spikeleftupper.addBox(0.6F, 0.0F, 0.0F, 1, 2, 1, 0.4F);
        this.setRotation(Spikeleftupper, 0.0F, 0.0F, -0.7853981633974483F);
        this.backright = new ModelRenderer(this, 0, 18);
        this.backright.setRotationPoint(-1.899999999999999F, 16.0F, 7.0F);
        this.backright.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.6F);
        this.tail2 = new ModelRenderer(this, 9, 18);
        this.tail2.setRotationPoint(2.000000000000001F, 13.0F, 8.8F);
        this.tail2.addBox(-1.0F, 0.0F, -1.0F, 1, 8, 2, 0.6F);
        this.setRotation(tail2, 0.7155849933176751F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 18, 14);
        this.body.setRotationPoint(0.9999999999999999F, 14.0F, 2.0F);
        this.body.addBox(-4.0F, -2.0F, -3.0F, 6, 9, 6, 0.6F);
        this.setRotation(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.earright = new ModelRenderer(this, 16, 14);
        this.earright.setRotationPoint(0F, 0F, 0F);
        this.earright.addBox(-3.0F, -5.0F, 0.0F, 2, 2, 1, 0.6F);
        this.chest = new ModelRenderer(this, 21, 0);
        this.chest.setRotationPoint(-1.3877787807814457E-16F, 14.0F, -3.0F);
        this.chest.addBox(-4.0F, -3.0F, -3.0F, 8, 6, 7, 0.6F);
        this.setRotation(chest, 1.5707963267948966F, 0.0F, 0.0F);
        this.backleft = new ModelRenderer(this, 0, 18);
        this.backleft.setRotationPoint(1.9000000000000008F, 16.0F, 7.0F);
        this.backleft.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.6F);
          
          //its updated
          this.head.addChild(mouth);
          this.head.addChild(earleft);
          this.head.addChild(earright);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
    
	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		
		
		if (this.isChild)
	    {
			float f6 = 2.0F;
	        GL11.glPushMatrix();
	        GL11.glTranslatef(0.0F, 5.0F * f5, 4.0F * f5);
	        GL11.glPopMatrix();
	        GL11.glPushMatrix();
	        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
	        GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
	        
	        
	        this.head.render(f5);
	        this.Spikerightlower.render(f5);
	        this.SpikeleftMane.render(f5);
	        this.Spikeleftlower.render(f5);
	        this.SpikerightMane.render(f5);
	       // this.earleft.render(f5);
	       // this.mouth.render(f5);
	        this.Spikerightmid.render(f5);
	        this.tail1.render(f5);
	        this.frontright.render(f5);
	        this.Spikeleftmid.render(f5);
	        this.frontleft.render(f5);
	        this.Spikerightupper.render(f5);
	        this.Spikeleftupper.render(f5);
	        this.backright.render(f5);
	        this.tail2.render(f5);
	        this.body.render(f5);
	       // this.earright.render(f5);
	        this.chest.render(f5);
	        this.backleft.render(f5);
	        GL11.glPopMatrix();
	    } else {
		
        
       
	    	this.head.render(f5);
	        this.Spikerightlower.render(f5);
	        this.SpikeleftMane.render(f5);
	        this.Spikeleftlower.render(f5);
	        this.SpikerightMane.render(f5);
	       // this.earleft.render(f5);
	       // this.mouth.render(f5);
	        this.Spikerightmid.render(f5);
	        this.tail1.render(f5);
	        this.frontright.render(f5);
	        this.Spikeleftmid.render(f5);
	        this.frontleft.render(f5);
	        this.Spikerightupper.render(f5);
	        this.Spikeleftupper.render(f5);
	        this.backright.render(f5);
	        this.tail2.render(f5);
	        this.body.render(f5);
	        //this.earright.render(f5);
	        this.chest.render(f5);
	        this.backleft.render(f5);
	    }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_)
    {
        EntityDeadWolf entitydeadwolf = (EntityDeadWolf)p_78086_1_;

        if (entitydeadwolf.isAngry())
        {
            this.tail1.rotateAngleY = 0.0F;
            this.tail2.rotateAngleY = 0.0F;
        }
        else
        {
            this.tail1.rotateAngleY = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
            this.tail2.rotateAngleY = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
        }

        if (entitydeadwolf.isSitting())
        {
            this.chest.setRotationPoint(-1.3877787807814457E-16F, 16.0F, -3.0F);
            this.chest.rotateAngleX = ((float)Math.PI * 2F / 5F);
            this.chest.rotateAngleY = 0.0F;
            this.body.setRotationPoint(0.9999999999999999F, 18.0F, 0.0F);
            this.body.rotateAngleX = ((float)Math.PI / 4F);
           
            this.SpikerightMane.setRotationPoint(-0.4F, 9.9F, -3.1F);//
            this.SpikeleftMane.setRotationPoint(-1.1F, 11.4F, -3.1F);//
            
            this.Spikerightupper.setRotationPoint(-0.4F, 13.6F, 1.6F);
            this.Spikeleftupper.setRotationPoint(-1.1F, 15.1F, 1.6F);
            
            this.Spikerightmid.setRotationPoint(-0.4F, 15.6F, 3.5F);
            this.Spikeleftmid.setRotationPoint(-1.1F, 17.1F, 3.5F);
            
            this.Spikerightlower.setRotationPoint(-0.4F, 18.0F, 6.0F);
            this.Spikeleftlower.setRotationPoint(-1.1F, 19.5F, 6.0F);
          
            this.tail1.setRotationPoint(-0.9999999999999992F, 23.0F, 6.0F);
            this.tail2.setRotationPoint(2.000000000000001F, 23.0F, 6.0F);           
            this.backright.setRotationPoint(-1.899999999999999F, 22.0F, 2.0F);
            this.backright.rotateAngleX = ((float)Math.PI * 3F / 2F);           
            this.backleft.setRotationPoint(1.9000000000000008F, 22.0F, 2.0F);
            this.backleft.rotateAngleX = ((float)Math.PI * 3F / 2F);            
            this.frontright.rotateAngleX = 5.811947F;
            this.frontright.setRotationPoint(-1.899999999999999F, 17.0F, -4.0F);           
            this.frontleft.rotateAngleX = 5.811947F;
            this.frontleft.setRotationPoint(1.9000000000000008F, 17.0F, -4.0F);
        }
        else
        {
            this.body.setRotationPoint(0.9999999999999999F, 14.0F, 2.0F);
            this.body.rotateAngleX = ((float)Math.PI / 2F);
            
            this.SpikerightMane.setRotationPoint(-0.4F, 7.9F, -3.1F);
            this.SpikeleftMane.setRotationPoint(-1.1F, 9.4F, -3.1F);
            
            this.Spikerightupper.setRotationPoint(-0.4F, 8.6F, 1.6F);
            this.Spikeleftupper.setRotationPoint(-1.1F, 10.1F, 1.6F);
            
            this.Spikerightmid.setRotationPoint(-0.4F, 8.6F, 4.5F);
            this.Spikeleftmid.setRotationPoint(-1.1F, 10.1F, 4.5F);
            
            this.Spikerightlower.setRotationPoint(-0.4F, 8.6F, 7.4F);
            this.Spikeleftlower.setRotationPoint(-1.1F, 10.1F, 7.4F);
            
            this.chest.setRotationPoint(-1.3877787807814457E-16F, 14.0F, -3.0F);
            this.chest.rotateAngleX = this.body.rotateAngleX;
            this.tail1.setRotationPoint(-0.9999999999999992F, 13.0F, 8.8F);
            this.tail2.setRotationPoint(2.000000000000001F, 13.0F, 8.8F);          
            this.backright.setRotationPoint(-1.899999999999999F, 16.0F, 7.0F);
            this.backleft.setRotationPoint(1.9000000000000008F, 16.0F, 7.0F);
            this.frontright.setRotationPoint(-1.899999999999999F, 16.0F, -4.0F);
            this.frontleft.setRotationPoint(1.9000000000000008F, 16.0F, -4.0F);
            this.backright.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
            this.backleft.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_78086_3_;
            this.frontright.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + (float)Math.PI) * 1.4F * p_78086_3_;
            this.frontleft.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
        }
//UPDATED
        this.head.rotateAngleZ = entitydeadwolf.getInterestedAngle(p_78086_4_) + entitydeadwolf.getShakeAngle(p_78086_4_, 0.0F);
        this.chest.rotateAngleZ = entitydeadwolf.getShakeAngle(p_78086_4_, -0.08F);
        this.body.rotateAngleZ = entitydeadwolf.getShakeAngle(p_78086_4_, -0.16F);
        this.tail1.rotateAngleZ = entitydeadwolf.getShakeAngle(p_78086_4_, -0.2F);
        this.tail2.rotateAngleZ = entitydeadwolf.getShakeAngle(p_78086_4_, -0.2F);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        this.head.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
        this.head.rotateAngleY = p_78087_4_ / (180F / (float)Math.PI);
        this.tail1.rotateAngleX = p_78087_3_;
        this.tail2.rotateAngleX = p_78087_3_;
    }
}
