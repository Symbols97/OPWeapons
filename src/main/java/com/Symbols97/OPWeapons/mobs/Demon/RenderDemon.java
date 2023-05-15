package com.Symbols97.OPWeapons.mobs.Demon;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderDemon extends RenderBiped {

	
	public RenderDemon(DemonModel p_i1257_1_, float p_i1257_2_) {
		super(p_i1257_1_, p_i1257_2_);
		// TODO Auto-generated constructor stub
	}

	private static final ResourceLocation mobTextures = new ResourceLocation("opweapons:textures/entity/Demon.png");
	private static final String __OBFID = "CL_00000984";
	
	
	protected void preRenderCallback(EntityLivingBase entity, float f){
    	GL11.glScalef(1.5F, 1.5F, 1.5F);
    }
	
	protected ResourceLocation getEntityTexture(EntityDemon entity){
		return mobTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityDemon)entity);
	}

}

