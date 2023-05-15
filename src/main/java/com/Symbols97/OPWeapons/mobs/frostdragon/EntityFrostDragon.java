package com.Symbols97.OPWeapons.mobs.frostdragon;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.armor.FrostArmor;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFrostDragon extends EntityTameable{
	
	
	public EntityFrostDragon(World p_i1738_1_) {
		super(p_i1738_1_);
		
		
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.setSize(1.5F, 2.0F);
		this.experienceValue = 100;
		this.findPlayerToAttack();
		this.setTamed(false);
		
	}
	
	

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(3D);
        //this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        
       
    }
	
	protected Entity findPlayerToAttack()
    {
       if (FrostArmor.iswearingFrostArmor == true) {
    
    	   return null;
       } else {
    	   double d0 = 16.0D;
           return this.worldObj.getClosestVulnerablePlayerToEntity(this, d0);
       }
    }
	
	
	
	protected String getLivingSound()
    {
        return "mob.enderdragon.growl";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.enderdragon.hit";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.8F;
    }

    
    @Override
    public double getMountedYOffset() {
        return 3.0D;
    }
    
    public void setTamed(boolean p_70903_1_)
    {
        super.setTamed(p_70903_1_);

        if (p_70903_1_)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(500000.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(100000.0D);
        }
    }
    public boolean interact(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();
        
        if (this.isTamed())
        {
            if (itemstack != null)
            {
                if (itemstack.getItem() instanceof ItemFood)
                {
                    ItemFood itemfood = (ItemFood)itemstack.getItem();

                    if (itemfood == OPWeapons.petFood && this.getHealth() < 500000.0F)
                    {
                        if (!player.capabilities.isCreativeMode)
                        {
                            --itemstack.stackSize;
                        }

                        this.heal((float)itemfood.func_150905_g(itemstack));

                        if (itemstack.stackSize <= 0)
                        {
                            player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }
                }
              
            }

//            if (this.func_152114_e(player) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
//            {
//                this.aiSit.setSitting(!this.isSitting());
//                this.isJumping = false;
//                this.setPathToEntity((PathEntity)null);
//                this.setTarget((Entity)null);
//                this.setAttackTarget((EntityLivingBase)null);
//            }
            
            if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == player) && !this.isSitting() && !player.isSneaking() && player.inventory.getCurrentItem() == null && !this.isChild())
            {
                player.mountEntity(this);
                this.aiSit.setSitting(false);
                return true;
            }
            
        }
        else if (itemstack != null && itemstack.getItem() == OPWeapons.magicFood)
        {
            if (!player.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0)
            {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            }

            if (!this.worldObj.isRemote)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);
                    this.setHealth(500000.0F);
                    this.func_152115_b(player.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }

            return true;
        }

        return super.interact(player);
    }
	
    
    
    public boolean canBeSteered() {
        return (getOwner() != null && this.riddenByEntity == getOwner() && getOwner() instanceof EntityPlayer );
      }
      
      public void moveEntityWithHeading(float moveStrafing, float moveForward) {
  
        if (this.riddenByEntity != null && canBeSteered()) {
          this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
          this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
          setRotation(this.rotationYaw, this.rotationPitch);
          this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
          moveStrafing = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
          moveForward = ((EntityLivingBase)this.riddenByEntity).moveForward;
          if (moveForward <= 0.0F)
            moveForward *= 0.15F; 
          if (this.riddenByEntity.rotationPitch > 0.0F)
            this.motionY -= 0.1D; 
          if (this.riddenByEntity.rotationPitch < 0.0F)
            this.motionY += 0.2D; 
          if (moveForward > 0.0F) {
            float f2 = MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F);
            float f3 = MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F);
            this.motionX += (this.onGround ? -0.01F : (-0.05F * f2));
            this.motionZ += (this.onGround ? 0.01F : (0.05F * f3));
          } 
          this.stepHeight = 1.0F;
          this.jumpMovementFactor = getAIMoveSpeed() * 0.1F;
          if (!this.worldObj.isRemote) {
        	  setAIMoveSpeed((float)getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
            super.moveEntityWithHeading(moveStrafing, moveForward);
          } 
          if (this.onGround)
        	  setJumping(false); 
        } else {
          this.stepHeight = 1.0F;
          this.jumpMovementFactor = 0.02F;
          super.moveEntityWithHeading(moveStrafing, moveForward);
        } 
      }



	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
