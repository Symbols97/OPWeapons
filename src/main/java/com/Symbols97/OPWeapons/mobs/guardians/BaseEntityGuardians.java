package com.Symbols97.OPWeapons.mobs.guardians;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class BaseEntityGuardians extends EntityMob{

	public BaseEntityGuardians(World p_i1738_1_) {
		super(p_i1738_1_);
		this.experienceValue = 75;
		this.setSize(1.5F, 4.0F);
		//this.tasks.addTask(0, new EntityAIWander(this, 0.5D));
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12500.0D);    
    }
	
	
}
