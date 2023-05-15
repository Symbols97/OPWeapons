package com.Symbols97.OPWeapons.entity.goblins.Frost;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.entity.goblins.GoblinEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FrostGoblinRenderer extends GeoEntityRenderer<GoblinEntity>  {
    public FrostGoblinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FrostGoblinModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinEntity instance) {
    	
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/goblins/frost_goblin.png");
    	
    }

    @Override
    public RenderType getRenderType(GoblinEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
    	
 
    		stack.scale(0.75F, 0.75F, 0.75F);
    	
    

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    
}