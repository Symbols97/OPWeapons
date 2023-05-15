package com.Symbols97.OPWeapons.blocks.trees;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class OPWLogs extends BlockLog{
	
	public static final String[] LogTypes = new String[] {"Demon", "Frost"};
	
	
	public OPWLogs() {
		super();
		this.setHardness(2.0F);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks (Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < LogTypes.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.field_150167_a = new IIcon[LogTypes.length];
		this.field_150166_b = new IIcon[LogTypes.length];
		
		for (int i = 0; i < this.field_150167_a.length; i++) {
			this.field_150167_a[i] = iconRegister.registerIcon("opweapons:" + LogTypes[i] + "_Log_Side");
			this.field_150166_b[i] = iconRegister.registerIcon("opweapons:" + LogTypes[i] + "_Log_Top");
		}
	}

}
