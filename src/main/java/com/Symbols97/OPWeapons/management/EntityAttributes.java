package com.Symbols97.OPWeapons.management;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.entity.OPWEntities;
import com.Symbols97.OPWeapons.entity.deadwolf.DeadWolfEntity;
import com.Symbols97.OPWeapons.entity.demon.DemonEntity;
import com.Symbols97.OPWeapons.entity.frosty_ostrich.FrostyOstrichEntity;
import com.Symbols97.OPWeapons.entity.goblins.GoblinEntity;
import com.Symbols97.OPWeapons.entity.guardians.BaseGuardianEntity;
import com.Symbols97.OPWeapons.entity.reaper.ReaperEntity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OPWeapons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributes {


	@SubscribeEvent
	public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
		event.put(OPWEntities.DEADWOLF.get(), DeadWolfEntity.setAttributes());
		event.put(OPWEntities.REAPER.get(), ReaperEntity.setAttributes());
		event.put(OPWEntities.DEMON.get(), DemonEntity.setAttributes());
		
		event.put(OPWEntities.OPGUARDIAN.get(), BaseGuardianEntity.setAttributes());
		event.put(OPWEntities.DEMONGUARDIAN.get(), BaseGuardianEntity.setAttributes());
		event.put(OPWEntities.FROSTGUARDIAN.get(), BaseGuardianEntity.setAttributes());
		
		event.put(OPWEntities.FROSTYOSTRICH.get(), FrostyOstrichEntity.setAttributes());
		
		event.put(OPWEntities.OPGOBLIN.get(), GoblinEntity.setAttributes());
		event.put(OPWEntities.DEMONGOBLIN.get(), GoblinEntity.setAttributes());
		event.put(OPWEntities.FROSTGOBLIN.get(), GoblinEntity.setAttributes());
	}
	
	
}
