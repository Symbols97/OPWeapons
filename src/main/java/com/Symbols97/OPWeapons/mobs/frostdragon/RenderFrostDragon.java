package com.Symbols97.OPWeapons.mobs.frostdragon;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderFrostDragon extends RenderLiving {

	public RenderFrostDragon(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);
		this.setRenderPassModel(p_i1262_1_);
		// TODO Auto-generated constructor stub
	}

	private static final ResourceLocation FrostDragonTextures = new ResourceLocation("opweapons:textures/entity/frostdragon/FrostDragon.png");
	private static final ResourceLocation saddledFDTextures = new ResourceLocation("opweapons:textures/entity/frostdragon/FrostDragon_saddle.png");
	private static final String __OBFID = "CL_00000984";
	

	protected void preRenderCallback(EntityLivingBase entity, float f){
    	GL11.glScalef(1.5F, 1.5F, 1.5F);
    }
	
	
	
	
	protected ResourceLocation getEntityTexture(EntityFrostDragon entity){
		return FrostDragonTextures;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity){
		return this.getEntityTexture((EntityFrostDragon)entity);
	}

}
