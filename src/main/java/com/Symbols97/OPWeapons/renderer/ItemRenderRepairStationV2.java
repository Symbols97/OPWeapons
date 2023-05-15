package com.Symbols97.OPWeapons.renderer;

import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.models.Blocks.RepairStationModelV2;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderRepairStationV2 implements IItemRenderer {
	private static final ResourceLocation textureidle = new ResourceLocation ("opweapons:textures/models/RepairStationModelV2.png");
	TileEntitySpecialRenderer render;
	private TileEntity entity;
	RepairStationModelV2 model;
	
	public ItemRenderRepairStationV2(TileEntitySpecialRenderer render, TileEntity entity) {
		this.entity = entity;
		this.render = render;
		this.model = new RepairStationModelV2();
	}
	
	
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
		float scale, scale1, scale211, scale2;
	    Minecraft mc = Minecraft.getMinecraft();
	    switch (type) {
	      case EQUIPPED:
	    	GL11.glPushMatrix();
		    scale2 = 2F;
		    GL11.glScalef(scale2, scale2, scale2);
		    mc.renderEngine.bindTexture(textureidle);
		    GL11.glRotatef(180.0F, -1.0F, 0.0F, 0.0F);
		    GL11.glRotatef(0.0F, 0.0F, -1.0F, 0.0F);
		    GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
		    GL11.glTranslatef(0F, -1.0F, 0F);
		    this.model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		    GL11.glPopMatrix();
		    break;
	      case EQUIPPED_FIRST_PERSON:
	        GL11.glPushMatrix();
	        scale211 = 1.5F;
	        GL11.glScalef(scale211, scale211, scale211);
	        mc.renderEngine.bindTexture(textureidle);
	        GL11.glRotatef(180.0F, -1.0F, 0.0F, 0.0F);
	        GL11.glRotatef(260.0F, 0.0F, -1.0F, 0.0F);
	        GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glTranslatef(0.5F, -1.0F, 0.5F);
	        this.model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        break;
	      case ENTITY:
	        GL11.glPushMatrix();
	        scale1 = 3F;
	        GL11.glScalef(scale1, scale1, scale1);
	        mc.renderEngine.bindTexture(textureidle);
	        GL11.glRotatef(180.0F, -1.0F, 0.0F, 0.0F);
	        GL11.glRotatef(50.0F, 0.0F, -1.0F, 0.0F);
	        GL11.glRotatef(50.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glTranslatef(0.0F, -1.5F, 0F);
	        this.model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        break;
	      case INVENTORY:
	        GL11.glPushMatrix();
	        scale = 0.7F;
	        GL11.glScalef(scale, scale, scale);
	        mc.renderEngine.bindTexture(textureidle);
	        GL11.glRotatef(180.0F, -1.0F, 0.0F, 0.0F);
	        GL11.glRotatef(0.0F, 0.0F, -1.0F, 0.0F);
	        GL11.glRotatef(-45.9F, 0.0F, 1.0F, 0.0F);
	        GL11.glTranslatef(0.0F, -0.25F, 1.0F);
	        this.model.renderModel(0.0625F);
	        GL11.glPopMatrix();
	        break;
		default:
			break;
	    } 
	  }
	}