package com.Symbols97.OPWeapons.renderer.items_tools_weapons;

import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.models.items_tools_weapons.DemonHammerModel;
import com.Symbols97.OPWeapons.models.items_tools_weapons.ReaperScytheModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

public class RenderDemonHammerModel implements IItemRenderer{

	private static final ResourceLocation texture = new ResourceLocation ("opweapons:textures/models/items_tools_weapons/Demon_Hammer.png");
	
	private DemonHammerModel DemonHammer;
	
	public RenderDemonHammerModel() {
		this.DemonHammer = new DemonHammerModel();
	}
	
	
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		 switch (type) {
	      case INVENTORY:
	        return true;
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		case FIRST_PERSON_MAP:
			break;
		default:
			break;
	    } 
	    return false;
	  
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
	    float scale, scale1, scale211, scale2;
	    //Minecraft mc = Minecraft.func_71410_x();
	    switch (type) {
	      case EQUIPPED:
	        GL11.glPushMatrix();
	        scale = 1F;
	        GL11.glScalef(scale, scale, scale);
	        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	        GL11.glRotatef(200.0F, 1.0F, -0.2F, 0.0F);
	        GL11.glRotatef(-235.0F, 1.0F, 1.0F, 0.0F);
	        GL11.glRotatef(-70.0F, 0.0F, 1.0F, 1.0F);
	        GL11.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glTranslatef(0.05F, -0.6F, -0.7F); 
	        this.DemonHammer.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        break;
	      case EQUIPPED_FIRST_PERSON:
	        GL11.glPushMatrix();
	        scale1 = 1F;
	        GL11.glScalef(scale1, scale1, scale1);
	        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	        GL11.glRotatef(200.0F, 1.0F, -0.2F, 0.0F);
	        GL11.glRotatef(-235.0F, 1.0F, 1.0F, 0.0F);
	        GL11.glRotatef(-70.0F, 0.0F, 1.0F, 1.0F);
	        GL11.glRotatef(-180.0F, 0.0F, 1.0F, 0.0F);
	        GL11.glTranslatef(0.05F, -0.7F, -0.9F);
	        this.DemonHammer.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        break;
	      case ENTITY:
	        GL11.glPushMatrix();
	        scale211 = 2F;
	        GL11.glScalef(scale211, scale211, scale211);
	        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	        GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
	        GL11.glTranslatef(0.0F, -0.15F, 0.0F);
	        this.DemonHammer.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        break;
	      case INVENTORY:
	        GL11.glPushMatrix();
	        scale2 = 1F;
	        GL11.glScalef(scale2, scale2, scale2);
	        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	        GL11.glRotatef(150.0F, 1.0F, 0.0F, -0.5F);
	        GL11.glRotatef(-75.0F, 0.0F, 25.0F, 1.8F);
	        GL11.glRotatef(35.0F, 1.0F, 0.0F, 0.0F);
	        GL11.glTranslatef(2F, -0.3F, 0F);
	        this.DemonHammer.renderModel(0.0625F);
	        GL11.glPopMatrix();
	        break;
		case FIRST_PERSON_MAP:
			break;
		default:
			break;
	    } 
	  }

}