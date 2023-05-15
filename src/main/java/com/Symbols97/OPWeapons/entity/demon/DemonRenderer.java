package com.Symbols97.OPWeapons.entity.demon;

import com.Symbols97.OPWeapons.OPWeapons;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DemonRenderer extends GeoEntityRenderer<DemonEntity>  {
	
    public DemonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DemonModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(DemonEntity instance) {
    	
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/demon.png");
    	
    }

    @Override
    public RenderType getRenderType(DemonEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
    	
 
    		stack.scale(1.5F, 1.5F, 1.5F);
    	
    

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

}
