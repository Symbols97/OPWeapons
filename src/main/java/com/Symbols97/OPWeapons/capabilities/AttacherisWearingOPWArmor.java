package com.Symbols97.OPWeapons.capabilities;

import org.jetbrains.annotations.NotNull;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

public class AttacherisWearingOPWArmor {
	// Every entity will hold their own instance of FSCapabilityProvider.
    // Their instances will hold a lazy that holds the cap.
    private static class OPArmorCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

        public static final ResourceLocation IDENTIFIER = new ResourceLocation(OPWeapons.MOD_ID, "iswearingopwarmor");
        private final isWearingOPWArmor backend = new isWearingOPWArmor();
        private final LazyOptional<isWearingOPWArmor> optionalData = LazyOptional.of(() -> backend);

        @Override
        public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, Direction side) {
            return Capabilities.WEARING_OPW_ARMOR_CAPABILITY.orEmpty(cap, this.optionalData);
        }

        @Override
        public CompoundTag serializeNBT() {
            return this.backend.serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.backend.deserializeNBT(nbt);
        }
    }

    // attach only to living entities
    public static void attach(final AttachCapabilitiesEvent<Entity> event) {
        Entity entity = event.getObject();
        if (entity instanceof Player) {
            final OPArmorCapabilityProvider provider = new OPArmorCapabilityProvider();
            event.addCapability(OPArmorCapabilityProvider.IDENTIFIER, provider);
        }
    }
}
