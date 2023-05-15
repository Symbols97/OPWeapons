package com.Symbols97.OPWeapons.mobs.Reaper;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armor.ReaperArmor;
import com.Symbols97.OPWeapons.items.reaperImmunityPatch;
import com.Symbols97.OPWeapons.managment.management;

import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityReaper extends EntityMob{


    public EntityReaper(World p_i1745_1_) {
		super(p_i1745_1_);
		this.addRandomArmor();
		
		this.experienceValue = 100;		
		this.isImmuneToFire = false;
		this.setAir(300);
		
		
		this.tasks.addTask(0, new EntityAIWander(this, 0.5D));
		this.findPlayerToAttack();
	}
    
    
	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15000.0D);    
    }
	
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	protected Entity findPlayerToAttack()
    {
       if (ReaperArmor.iswearingReaperArmor == true) {
    	   
    	   return null;
       } else {
    	   double d0 = 16.0D;
           return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
       }
    }
	
	
	public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        if (super.attackEntityAsMob(p_70652_1_))
        {
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 100));
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.weakness.id, 600, 0));
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 600, 10));
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.blindness.id, 600, 0));
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.hunger.id, 600, 100));
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.poison.id, 600, 0));
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.wither.id, 100, 1));
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.confusion.id, 600, 1));
            return true;
        }
        else
        {
            return false;
        }
    }
	
	protected void fall(float distance) {}
	
	protected Item getDropItem()
    {
        return OPWeapons.deathEssence;
    }

	
    protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(2))
        {
            case 0:
                this.dropItem(OPWeapons.lostPages, 1);
                break;
            case 1:
                this.dropItem(OPWeapons.reaperImmunityPatch, 1);
                break;
         
        }
    }
 
	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(OPWeapons.reaperscythe));
        this.setCurrentItemOrArmor(1, null);
        this.setCurrentItemOrArmor(2, null);
        this.setCurrentItemOrArmor(3, null);
        this.setCurrentItemOrArmor(4, null);
        this.setEquipmentDropChance(0, 0);
        this.entityDropItem(new ItemStack(OPWeapons.torturedSoul), 0.0F);
    }

	
}