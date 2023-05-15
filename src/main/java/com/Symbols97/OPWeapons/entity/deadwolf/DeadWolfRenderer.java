package com.Symbols97.OPWeapons.entity.deadwolf;

import com.Symbols97.OPWeapons.OPWeapons;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DeadWolfRenderer extends GeoEntityRenderer<DeadWolfEntity> {
    public DeadWolfRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DeadWolfModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(DeadWolfEntity instance) {
    	if(instance.isAngry() && !instance.isTame()) {
    		return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/dead_wolf/dead_wolf_angry.png");
    	} else if(instance.isTame()){
    		if(instance.isAngry()) {
    			return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/dead_wolf/dead_wolf_tamed_angry.png");
    		}
    		return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/dead_wolf/dead_wolf_tamed.png");
    	} else {
    		return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/dead_wolf/dead_wolf.png");
    	}
    }
    
   
   

    @Override
    public RenderType getRenderType(DeadWolfEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
    	
    	if (animatable.isBaby()) {
    		stack.scale(1F, 1F, 1F);
    	} else {
    		stack.scale(2F, 2F, 2F);
    	}
    	

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    
}
