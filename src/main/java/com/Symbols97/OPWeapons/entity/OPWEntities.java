package com.Symbols97.OPWeapons.entity;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.entity.deadwolf.DeadWolfEntity;
import com.Symbols97.OPWeapons.entity.demon.DemonEntity;
import com.Symbols97.OPWeapons.entity.frosty_ostrich.FrostyOstrichEntity;
import com.Symbols97.OPWeapons.entity.goblins.GoblinEntity;
import com.Symbols97.OPWeapons.entity.guardians.Demon.DemonGuardianEntity;
import com.Symbols97.OPWeapons.entity.guardians.Frost.FrostGuardianEntity;
import com.Symbols97.OPWeapons.entity.guardians.OP.OPGuardianEntity;
import com.Symbols97.OPWeapons.entity.projectile.lapizarrow.LapizArrow;
import com.Symbols97.OPWeapons.entity.reaper.ReaperEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class OPWEntities {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, OPWeapons.MOD_ID);

	public static final RegistryObject<EntityType<DeadWolfEntity>> DEADWOLF = ENTITY_TYPES.register("dead_wolf",
			() -> EntityType.Builder.of(DeadWolfEntity::new, MobCategory.CREATURE).sized(1.5f, 2.0f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "dead_wolf").toString()));

	public static final RegistryObject<EntityType<ReaperEntity>> REAPER = ENTITY_TYPES.register("reaper",
			() -> EntityType.Builder.of(ReaperEntity::new, MobCategory.MONSTER).sized(1.0f, 2.0f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "reaper").toString()));

	public static final RegistryObject<EntityType<DemonEntity>> DEMON = ENTITY_TYPES.register("demon",
			() -> EntityType.Builder.of(DemonEntity::new, MobCategory.MONSTER).sized(1.0f, 2.0f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "demon").toString()));

	public static final RegistryObject<EntityType<OPGuardianEntity>> OPGUARDIAN = ENTITY_TYPES.register("op_guardian",
			() -> EntityType.Builder.of(OPGuardianEntity::new, MobCategory.MONSTER).sized(1.0f, 4.0f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "op_guardian").toString()));

	public static final RegistryObject<EntityType<DemonGuardianEntity>> DEMONGUARDIAN = ENTITY_TYPES.register("demon_guardian",
			() -> EntityType.Builder.of(DemonGuardianEntity::new, MobCategory.MONSTER).sized(1.0f, 4.0f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "demon_guardian").toString()));

	public static final RegistryObject<EntityType<FrostGuardianEntity>> FROSTGUARDIAN = ENTITY_TYPES.register("frost_guardian",
			() -> EntityType.Builder.of(FrostGuardianEntity::new, MobCategory.MONSTER).sized(1.0f, 4.0f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "frost_guardian").toString()));
	
	public static final RegistryObject<EntityType<FrostyOstrichEntity>> FROSTYOSTRICH = ENTITY_TYPES.register("frosty_ostrich",
			() -> EntityType.Builder.of(FrostyOstrichEntity::new, MobCategory.CREATURE).sized(1.0f, 4.0f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "frosty_ostrich").toString()));

	
	public static final RegistryObject<EntityType<GoblinEntity>> OPGOBLIN = ENTITY_TYPES.register("op_goblin",
			() -> EntityType.Builder.of(GoblinEntity::new, MobCategory.MONSTER).sized(1.0f, 1.65f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "op_goblin").toString()));

	
	public static final RegistryObject<EntityType<GoblinEntity>> DEMONGOBLIN = ENTITY_TYPES.register("demon_goblin",
			() -> EntityType.Builder.of(GoblinEntity::new, MobCategory.MONSTER).sized(1.0f, 1.65f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "demon_goblin").toString()));

	
	public static final RegistryObject<EntityType<GoblinEntity>> FROSTGOBLIN = ENTITY_TYPES.register("frost_goblin",
			() -> EntityType.Builder.of(GoblinEntity::new, MobCategory.MONSTER).sized(1.0f, 1.65f) // Hitbox
					.build(new ResourceLocation(OPWeapons.MOD_ID, "frost_goblin").toString()));

	//Projectile
	public static final RegistryObject<EntityType<LapizArrow>> LAPIZARROW = ENTITY_TYPES.register("lapiz_arrow",
			() -> EntityType.Builder.<LapizArrow>of(LapizArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20)
					.build(new ResourceLocation(OPWeapons.MOD_ID, "lapiz_arrow").toString()));

	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}

}
