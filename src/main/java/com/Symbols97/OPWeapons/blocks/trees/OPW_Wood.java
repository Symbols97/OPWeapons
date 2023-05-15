package com.Symbols97.OPWeapons.blocks.trees;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class OPW_Wood extends BlockWood{
	
	public static final String[] WoodTypes = new String[] {"Demon", "Frost"};
	@SideOnly(Side.CLIENT)
	private IIcon[] field_150095_b;
	
	
	public OPW_Wood() {
		super();
		this.setHardness(2.0F);
	}
	
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        if (p_149691_2_ < 0 || p_149691_2_ >= this.field_150095_b.length)
        {
            p_149691_2_ = 0;
        }

        return this.field_150095_b[p_149691_2_];
    }

	@SideOnly(Side.CLIENT)
	public void getSubBlocks (Item item, CreativeTabs tabs, List list) {
		for (int i = 0; i < WoodTypes.length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.field_150095_b = new IIcon[WoodTypes.length];
		
		for (int i = 0; i < this.field_150095_b.length; i++) {
			this.field_150095_b[i] = iconRegister.registerIcon("opweapons:" + WoodTypes[i] + "_plank");
			
		}
	}

}