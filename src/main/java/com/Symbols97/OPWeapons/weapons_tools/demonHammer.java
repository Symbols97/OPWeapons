package com.Symbols97.OPWeapons.weapons_tools;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.Dimension.DeadZone.DeadZoneTeleporter;
import com.Symbols97.OPWeapons.armor.DemonArmor;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class demonHammer extends ItemSword {



	
	
	public demonHammer(ToolMaterial demonhammer) {
		super(demonhammer);
	}

	//Start of Lighting on right click code
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) 
	{
		
		
		
	if (!player.isSneaking()) {
		
		
		if(!world.isRemote)
		{
			MovingObjectPosition objectMouseOver = getDistanceFromPlayer(world, player, true);

			if (objectMouseOver != null && objectMouseOver.typeOfHit == MovingObjectType.BLOCK) 
			{
				int x = objectMouseOver.blockX;
				int y = objectMouseOver.blockY;
				int z = objectMouseOver.blockZ;
				world.addWeatherEffect(new EntityLightningBolt(world, x, y, z));
				
				
				
				if (DemonArmor.iswearingDemonArmor == true) {
					itemStack.damageItem(0, player);
				} else {
					itemStack.damageItem(2, player);
				}
				
			}
		}
	} else {
			
			MovingObjectPosition objectMouseOver = getDistanceFromPlayer(world, player, true);

			if (objectMouseOver != null && objectMouseOver.typeOfHit == MovingObjectType.BLOCK) 
			{
				int x = objectMouseOver.blockX;
				int y = objectMouseOver.blockY;
				int z = objectMouseOver.blockZ;
				
				
				
			
				
				
				world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				world.setBlock(x, y+1, z, Blocks.flowing_lava);
				
				if (DemonArmor.iswearingDemonArmor == true) {
					itemStack.damageItem(0, player);
				} else {
					itemStack.damageItem(4, player);
				}
			}
		}
		
		return itemStack;
	
	}

	protected MovingObjectPosition getDistanceFromPlayer(World p_77621_1_, EntityPlayer p_77621_2_, boolean p_77621_3_)
	    {
	        float f = 1.0F;
	        float f1 = p_77621_2_.prevRotationPitch + (p_77621_2_.rotationPitch - p_77621_2_.prevRotationPitch) * f;
	        float f2 = p_77621_2_.prevRotationYaw + (p_77621_2_.rotationYaw - p_77621_2_.prevRotationYaw) * f;
	        double d0 = p_77621_2_.prevPosX + (p_77621_2_.posX - p_77621_2_.prevPosX) * (double)f;
	        double d1 = p_77621_2_.prevPosY + (p_77621_2_.posY - p_77621_2_.prevPosY) * (double)f + (double)(p_77621_1_.isRemote ? p_77621_2_.getEyeHeight() - p_77621_2_.getDefaultEyeHeight() : p_77621_2_.getEyeHeight()); // isRemote check to revert changes to ray trace position due to adding the eye height clientside and player yOffset differences
	        double d2 = p_77621_2_.prevPosZ + (p_77621_2_.posZ - p_77621_2_.prevPosZ) * (double)f;
	        Vec3 vec3 = Vec3.createVectorHelper(d0, d1, d2);
	        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
	        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
	        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
	        float f6 = MathHelper.sin(-f1 * 0.017453292F);
	        float f7 = f4 * f5;
	        float f8 = f3 * f5;
	        double reachDistance = 200.0D;
	    
	        Vec3 vec31 = vec3.addVector((double)f7 * reachDistance, (double)f6 * reachDistance, (double)f8 * reachDistance);
	        return p_77621_1_.func_147447_a(vec3, vec31, p_77621_3_, !p_77621_3_, false);
	    }
	
	
	//End of lightning on right click code
	
}
