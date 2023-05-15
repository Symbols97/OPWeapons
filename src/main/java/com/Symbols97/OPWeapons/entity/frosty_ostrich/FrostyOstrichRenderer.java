package com.Symbols97.OPWeapons.entity.frosty_ostrich;

import com.Symbols97.OPWeapons.OPWeapons;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FrostyOstrichRenderer extends GeoEntityRenderer<FrostyOstrichEntity> {
	public FrostyOstrichRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FrostyOstrichModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public ResourceLocation getTextureLocation(FrostyOstrichEntity instance) {
		if (instance.isTame()) {
			return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/frosty_ostrich_tamed.png");
		} else {
			return new ResourceLocation(OPWeapons.MOD_ID, "textures/models/entity/frosty_ostrich.png");
		}
	}

	@Override
	public RenderType getRenderType(FrostyOstrichEntity animatable, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder,
			int packedLightIn, ResourceLocation textureLocation) {

		if (animatable.isBaby()) {
			stack.scale(0.5F, 0.5F, 0.5F);
		} else {
			stack.scale(1F, 1F, 1F);
		}

		return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
	}

}
