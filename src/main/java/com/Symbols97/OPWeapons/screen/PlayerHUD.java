package com.Symbols97.OPWeapons.screen;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armors.DemonArmor;
import com.Symbols97.OPWeapons.armors.FrostArmor;
import com.Symbols97.OPWeapons.armors.LostArmor;
import com.Symbols97.OPWeapons.armors.OPArmor;
import com.Symbols97.OPWeapons.armors.ReaperArmor;
import com.Symbols97.OPWeapons.config.OPWeaponsClientConfig;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.world.dimension.OPWDimensions;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class PlayerHUD extends ForgeGui {

	public PlayerHUD(Minecraft mc) {
		super(mc);
		// TODO Auto-generated constructor stub
	}

	static ResourceLocation texture = new ResourceLocation(OPWeapons.MOD_ID, "textures/gui/shades.png");

	public static String color = "§2";

	@Override
	protected void renderTextureOverlay(ResourceLocation p_168709_, float p_168710_) {

	}

	@SuppressWarnings("resource")
	public static final IGuiOverlay safety = (gui, poseStack, partialTicks, width, height) -> {
		int left = width;
		int top = height;
		Player player = Minecraft.getInstance().player;
		// ItemStack item = player.getMainHandItem();

		if (Minecraft.getInstance().options.getCameraType().isFirstPerson()
				&& player.getItemBySlot(EquipmentSlot.HEAD).getItem().equals(OPWItems.demon_helmet_shaded.get())
				&& player.level.dimension() == OPWDimensions.DZ_KEY) {
			// renderTextureOverlay
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 2F);
			RenderSystem.setShaderTexture(0, texture);
			Tesselator tesselator = Tesselator.getInstance();
			BufferBuilder bufferbuilder = tesselator.getBuilder();
			bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
			bufferbuilder.vertex(0.0D, (double) top, -90.0D).uv(0.0F, 1.0F).endVertex();
			bufferbuilder.vertex((double) left, (double) top, -90.0D).uv(1.0F, 1.0F).endVertex();
			bufferbuilder.vertex((double) left, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
			bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
			tesselator.end();
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		}

	};

	@SuppressWarnings("resource")
	public static final IGuiOverlay HUD_DURABILITY = (gui, poseStack, partialTicks, width, height) -> {

		boolean displayItemDurability = OPWeaponsClientConfig.displayItemDurability.get();
		boolean displayArmorDurability = OPWeaponsClientConfig.displayArmorDurability.get();

		boolean displayItemPercent = OPWeaponsClientConfig.displayItemPercent.get();
		boolean displayArmorPercent = OPWeaponsClientConfig.displayArmorPercent.get();

		float durabilityPercent = 0;
		int durabilityNumeric1 = 0;
		int durabilityNumeric2 = 0;

		int left = width / 2 - 91;
		int top = height - 39;
		Player player = Minecraft.getInstance().player;
		ItemStack item = player.getMainHandItem();

		if (OPArmor.isWearingOPArmorClient) {
			durabilityPercent = OPArmor.durabilityPercent;
			durabilityNumeric1 = OPArmor.durabilityNumeric1;
			durabilityNumeric2 = OPArmor.durabilityNumeric2;
		}
		// Lost
		if (LostArmor.isWearingLostArmorClient) {
			durabilityPercent = LostArmor.durabilityPercent;
			durabilityNumeric1 = LostArmor.durabilityNumeric1;
			durabilityNumeric2 = LostArmor.durabilityNumeric2;

		}
		if (DemonArmor.isWearingDemonArmorClient) {
			durabilityPercent = DemonArmor.durabilityPercent;
			durabilityNumeric1 = DemonArmor.durabilityNumeric1;
			durabilityNumeric2 = DemonArmor.durabilityNumeric2;

		}
		if (FrostArmor.isWearingFrostArmorClient) {
			durabilityPercent = FrostArmor.durabilityPercent;
			durabilityNumeric1 = FrostArmor.durabilityNumeric1;
			durabilityNumeric2 = FrostArmor.durabilityNumeric2;

		}
		if (ReaperArmor.isWearingReaperArmorClient) {
			durabilityPercent = ReaperArmor.durabilityPercent;
			durabilityNumeric1 = ReaperArmor.durabilityNumeric1;
			durabilityNumeric2 = ReaperArmor.durabilityNumeric2;

		}

		if (OPWeaponsClientConfig.displayColor.get().equals("Dark Green")) {
			color = "§2";
		}

		if (OPWeaponsClientConfig.displayColor.get().equals("Green")) {
			color = "§a";
		}

		if (OPWeaponsClientConfig.displayColor.get().equals("Blue")) {
			color = "§9";
		}

		if (OPWeaponsClientConfig.displayColor.get().equals("Aqua")) {
			color = "§b";
		}

		if (OPWeaponsClientConfig.displayColor.get().equals("Yellow")) {
			color = "§e";
		}

		// Display Armor Durability
		if (displayArmorDurability) {
			if ((OPArmor.isWearingOPArmorClient || LostArmor.isWearingLostArmorClient
					|| DemonArmor.isWearingDemonArmorClient || FrostArmor.isWearingFrostArmorClient
					|| ReaperArmor.isWearingReaperArmorClient) && !player.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
				int yaxis = 10;

				if (player.isUnderWater()) {
					yaxis = 20;
				}

				if (displayArmorPercent) {

					String durability_percent = String.format(color + "Armor: %.2f%%", durabilityPercent);
					String low_durability_percent = String.format("§cArmor: %.2f%%", durabilityPercent);

					if (durabilityPercent <= 50.00) {

						gui.getFont().draw(poseStack, low_durability_percent, left + 105, top - yaxis, 0xffffffff);
					} else {

						gui.getFont().draw(poseStack, durability_percent, left + 105, top - yaxis, 0xffffffff);
					}

				} else if (!displayArmorPercent) {

					String durability_numeric = String.format(color + "Armor: %d/%d", durabilityNumeric1,
							durabilityNumeric2);
					String low_durability_numeric = String.format("§cArmor: %d/%d", durabilityNumeric1,
							durabilityNumeric2);
					if (durabilityNumeric1 <= (durabilityNumeric2 / 2)) {

						gui.getFont().draw(poseStack, low_durability_numeric, left + 90, top - yaxis, 0xffffffff);
					} else {

						gui.getFont().draw(poseStack, durability_numeric, left + 90, top - yaxis, 0xffffffff);
					}

				}
			}

		}

		// Display Item Durability
		if (displayItemDurability) {
			if (!item.isEmpty() && item.isDamageableItem()) {

				if (displayItemPercent) {
					float durability_percent = ((float) item.getMaxDamage() - (float) item.getDamageValue())
							* (float) 100 / (float) item.getMaxDamage();

					String percent_display = String.format(color + "Durability: %.2f%%", durability_percent);
					String low_percent_display = String.format("§cDurability: %.2f%%", durability_percent);

					if (durability_percent <= 15.00) {
						gui.getFont().draw(poseStack, low_percent_display, left - 95, top + 5, 0xffffffff);
					} else {
						gui.getFont().draw(poseStack, percent_display, left - 95, top + 5, 0xffffffff);
					}

				} else if (!displayItemPercent) {

					int durability_numeric1 = item.getMaxDamage() - item.getDamageValue();
					int durability_numeric2 = item.getMaxDamage();

					String numeric_display = String.format(color + "Durability: %d/%d", durability_numeric1,
							durability_numeric2);
					String low_numeric_display = String.format("§cDurability: %d/%d", durability_numeric1,
							durability_numeric2);

					if (durability_numeric1 <= (durability_numeric2 / 6)) {
						gui.getFont().draw(poseStack, low_numeric_display, left - 115, top + 5, 0xffffffff);
					} else {
						gui.getFont().draw(poseStack, numeric_display, left - 115, top + 5, 0xffffffff);
					}
				}

			}
		}

	};

}
