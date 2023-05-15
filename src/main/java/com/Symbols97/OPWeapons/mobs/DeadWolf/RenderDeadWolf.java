package com.Symbols97.OPWeapons.mobs.DeadWolf;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

public class RenderDeadWolf extends RenderWolf{

	
	private static final ResourceLocation deadwolfTextures = new ResourceLocation("opweapons:textures/entity/DeadWolf/DeadWolf.png");
	private static final ResourceLocation anrgydeadWolfTextures = new ResourceLocation("opweapons:textures/entity/DeadWolf/DeadWolf_angry.png");
	private static final ResourceLocation tameddeadWolfTextures = new ResourceLocation("opweapons:textures/entity/DeadWolf/DeadWolf.png");
	private static final ResourceLocation deadwolfCollarTextures = new ResourceLocation("opweapons:textures/entity/DeadWolf/DeadWolf_Collar.png");
	private static final String __OBFID = "CL_00000984";
	
	public RenderDeadWolf(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par1ModelBase, par2);
		
	}
	protected void preRenderCallback(EntityLivingBase entity, float f){
    	GL11.glScalef(2F, 2F, 2F);
    	
    	
    }
	 protected int shouldRenderPass(EntityWolf p_77032_1_, int p_77032_2_, float p_77032_3_)
	    {
	        if (p_77032_2_ == 0 && p_77032_1_.getWolfShaking())
	        {
	            float f1 = p_77032_1_.getBrightness(p_77032_3_) * p_77032_1_.getShadingWhileShaking(p_77032_3_);
	            this.bindTexture(deadwolfTextures);
	            GL11.glColor3f(f1, f1, f1);
	            return 1;
	        }
	        else if (p_77032_2_ == 1 && p_77032_1_.isTamed())
	        {
	            this.bindTexture(deadwolfCollarTextures);
	            int j = p_77032_1_.getCollarColor();
	            GL11.glColor3f(EntitySheep.fleeceColorTable[j][0], EntitySheep.fleeceColorTable[j][1], EntitySheep.fleeceColorTable[j][2]);
	            return 1;
	        }
	        else
	        {
	            return -1;
	        }
	    }
	protected ResourceLocation getEntityTexture(EntityDeadWolf entity){
		return entity.isTamed() ? tameddeadWolfTextures : (entity.isAngry() ? anrgydeadWolfTextures : deadwolfTextures);
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityDeadWolf)entity);
	}

}

