package com.Symbols97.OPWeapons.renderer;

import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.TileEntity.TileEntityFreezer;
import com.Symbols97.OPWeapons.blocks.machines.Freezer;
import com.Symbols97.OPWeapons.gui.GUIFreezer;
import com.Symbols97.OPWeapons.models.Blocks.FreezerModel;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderFreezer extends TileEntitySpecialRenderer{

	private static final ResourceLocation textureidle = new ResourceLocation ("opweapons:textures/models/Freezeridle.png");
	private static final ResourceLocation textureactive = new ResourceLocation ("opweapons:textures/models/Freezeractive.png");
	private FreezerModel model;
	public TileEntityFreezer freezer;
	public RenderFreezer() {
		this.model = new FreezerModel();
	}

	
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		this.freezer = (TileEntityFreezer) tileentity;
		int i;
        if (tileentity.getWorldObj() == null)
        {
                i = 0;
        } else {
                Block block = tileentity.getBlockType();
                i = tileentity.getBlockMetadata();
                if (block != null && i == 0)
                {
                        i = tileentity.getBlockMetadata();
                }
        }
			GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		    
		    this.bindTexture(textureidle);
		    if (tileentity instanceof TileEntityFreezer) {
		    	TileEntityFreezer gen = (TileEntityFreezer)tileentity;
		        if (gen.getWorldObj().getBlock(gen.xCoord, gen.yCoord, gen.zCoord) == OPWeapons.freezer ) {
		        	
		        	if ( (this.freezer.currentItemBurnTime > 1) && this.freezer.canSmelt() || this.freezer.isBurning()){
		        	
		        		this.bindTexture(textureactive);

		   		          GL11.glPushMatrix();
		   		          GL11.glRotatef((float)(System.currentTimeMillis() / 1L % 359L), 0.0F, -1.0F, 0.0F);
		   		          GL11.glTranslatef(0.0F, 1.5F, 0.0F);
		   		          
		   		          GL11.glPopMatrix();
		   		          
		   		          
		        	}    
		        } 
		       
		      } 

		   
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			int j = 0;
            if(i == 3) {
                j = 270;
            }
            if(i == 2) {
                j = 180;
            }
            if(i == 1) {
                j = 90;
            }
            if(i == 0) {
            	j = 360;
            }
            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	}

}
