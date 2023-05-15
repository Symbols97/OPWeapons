package com.Symbols97.OPWeapons.mobs.guardians;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderFrostGuardian extends RenderBiped {

	
	

	public RenderFrostGuardian(GuardianModel p_i1257_1_, float p_i1257_2_) {
		super(p_i1257_1_, p_i1257_2_);
		// TODO Auto-generated constructor stub
	}

	private static final ResourceLocation mobTextures = new ResourceLocation("opweapons:textures/entity/guardians/frostguardian.png");
	private static final String __OBFID = "CL_00000984";
	

	protected void preRenderCallback(EntityLivingBase entity, float f){
    	GL11.glScalef(2.0F, 2.0F, 2.0F);
    }
	
	protected ResourceLocation getEntityTexture(EntityFrostGuardian entity){
		return mobTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityFrostGuardian)entity);
	}

}
