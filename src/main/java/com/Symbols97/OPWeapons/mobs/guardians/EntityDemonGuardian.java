package com.Symbols97.OPWeapons.mobs.guardians;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armor.DemonArmor;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDemonGuardian extends BaseEntityGuardians{

	public EntityDemonGuardian(World p_i1738_1_) {
		super(p_i1738_1_);
		this.isImmuneToFire = true;
		this.addRandomArmor();
		this.findPlayerToAttack();
	}

	
	protected void addRandomArmor()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(OPWeapons.demonHammer));
        this.setCurrentItemOrArmor(1, null);
        this.setCurrentItemOrArmor(2, null);
        this.setCurrentItemOrArmor(3, null);
        this.setCurrentItemOrArmor(4, null);
        this.setEquipmentDropChance(0, 0);
        this.entityDropItem(new ItemStack(OPWeapons.HammerHead), 0.0F);
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
            int j = this.rand.nextInt(6) + 1;

            this.dropItem(item, j);
            
        }
    }

    protected void dropRareDrop(int p_70600_1_)
    {
        switch (this.rand.nextInt(2))
        {
            case 0:
                this.dropItem(OPWeapons.DemonVial, 1);
                break;
            case 1:
                this.dropItem(OPWeapons.demonHammer, 1);
                break;
         
        }
    }
	
}
