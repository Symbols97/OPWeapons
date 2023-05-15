package com.Symbols97.OPWeapons.mobs.guardians;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armor.OPArmor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityOPGuardian extends BaseEntityGuardians{

	public EntityOPGuardian(World p_i1738_1_) {
		super(p_i1738_1_);
		this.addRandomArmor();
		this.findPlayerToAttack();
	}

	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(OPWeapons.opClub));
        this.setCurrentItemOrArmor(1, null);
        this.setCurrentItemOrArmor(2, null);
        this.setCurrentItemOrArmor(3, null);
        this.setCurrentItemOrArmor(4, null);
        this.setEquipmentDropChance(0, 0);
        this.entityDropItem(new ItemStack(OPWeapons.opGem), 0.0F);
    }
	
	protected Entity findPlayerToAttack()
    {
       if (OPArmor.iswearingOPArmor == true) {
    	   
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
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 0));
         
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.blindness.id, 60, 0));
         
          ((EntityLivingBase)p_70652_1_).addPotionEffect(new PotionEffect(Potion.confusion.id, 60, 0));
            return true;
        }
        else
        {
            return false;
        }
    }
	
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
        Item item = OPWeapons.opGem;

        if (item != null)
        {
            int j = this.rand.nextInt(6) + 1;

            this.dropItem(item, j);
            
        }
    }

    protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(2))
        {
            case 0:
                this.dropItem(OPWeapons.OPVial, 1);
                break;
            case 1:
                this.dropItem(OPWeapons.opClub, 1);
                break;
         
        }
    }
	
}
