package com.Symbols97.OPWeapons.mobs.Demon;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armor.DemonArmor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityDemon extends EntityMob
{
	  public EntityDemon(World p_i1745_1_) {
			super(p_i1745_1_);
			this.isImmuneToFire = true;
			this.findPlayerToAttack();
			this.experienceValue = 50;
			this.setSize(1.0F, 3.2F);
			
		}

		protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(150.0D);
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10000.0D);
	        
	        
	    }
		
		protected Entity findPlayerToAttack()
	    {
	       if (DemonArmor.iswearingDemonArmor == true) {
	    	   
	    	   return null;
	       } else {
	    	   double d0 = 16.0D;
	           return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
	       }
	    }
		
		
		
		protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
	    {
	        Item item = OPWeapons.demonGem;

	        if (item != null)
	        {
	            int j = this.rand.nextInt(3) + 1;

	            this.dropItem(item, j);
	            
	        }
	    }


		
	    protected void dropRareDrop(int p_70600_1_)
	    {
	        switch (this.rand.nextInt(2))
	        {
	            case 0:
	                this.dropItem(OPWeapons.demonGold, 1);
	                break;
	            case 1:
	                this.dropItem(OPWeapons.DemonGemCore, 1);
	                break;
	         
	        }
	    }
		
}