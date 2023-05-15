package com.Symbols97.OPWeapons.entity.guardians.OP;

import com.Symbols97.OPWeapons.OPWeapons;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class OPGuardianRenderer extends GeoEntityRenderer<OPGuardianEntity>  {
    public OPGuardianRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OPGuardianModel());
        this.shadowRadius = 1.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(OPGuardianEntity instance) {
    	
    	return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/guardians/op_guardian.png");
    	
    }

    @Override
    public RenderType getRenderType(OPGuardianEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
    	
 
    		stack.scale(2F, 2F, 2F);
    	
    

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }

    
}