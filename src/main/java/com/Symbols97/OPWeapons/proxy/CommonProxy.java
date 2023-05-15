package com.Symbols97.OPWeapons.proxy;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.block.Block;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class CommonProxy {

	public EntityPlayer getPlayer() {
	    return null;
	  }
	  
	  public boolean isClientPlayer(EntityPlayer player) {
	    return false;
	  }
	
	public void registerRenderThings() {
		
	}
	
	public void registerTileEntitySpecialRenderer() {
		
	}
	
	void openGUIOPBook()
	{
		
	}
	void openGUIDemonBook()
	{
		
	}
	void openGUIFrostBook()
	{
		
	}
	void openGUIFoodBook()
	{
		
	}
	void openGUILoreBookIncomplete()
	{
		
	}
	void openGUILoreBookComplete()
	{
		
	}
	public boolean onBlockActivated(World parWorld, Block parBlockPos, 
	      IBlockSource parIBlockState, EntityPlayer parPlayer, EnumFacing parSide, 
	      float hitX, float hitY, float hitZ)
	{
	    if (!parWorld.isRemote)
	    {
	        OPWeapons.Proxy.openGUIOPBook(); 
	    }
	    {
	        OPWeapons.Proxy.openGUIDemonBook(); 
	    }
	    {
	        OPWeapons.Proxy.openGUIFrostBook(); 
	    }
	    {
	        OPWeapons.Proxy.openGUIFoodBook(); 
	    }
	    {
	        OPWeapons.Proxy.openGUILoreBookIncomplete(); 
	    }  
	    {
	        OPWeapons.Proxy.openGUILoreBookComplete(); 
	    }  
	    return true;
	}


}
