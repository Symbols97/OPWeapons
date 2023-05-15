package com.Symbols97.OPWeapons.entity.projectile.lapizarrow;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LapizArrowRenderer extends ArrowRenderer<LapizArrow>{

	public LapizArrowRenderer(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResourceLocation getTextureLocation(LapizArrow entity) {
		return new ResourceLocation(OPWeapons.MOD_ID, "textures/projectiles/lapiz_arrow_entity.png");
	}

}
