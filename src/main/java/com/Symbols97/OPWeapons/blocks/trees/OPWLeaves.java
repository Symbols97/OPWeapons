package com.Symbols97.OPWeapons.blocks.trees;

import java.util.List;
import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OPWLeaves extends BlockLeaves
{
    public static final String[][] leaftypes = new String[][] {{"Leaves_Demon", "Leaves_Frost"}, {"Leaves_Demon_Opaque", "Leaves_Frost_Opaque"}};
    public static final String[] leaves = new String[] {"Demon", "Frost"};
   

    protected void func_150124_c(World world, int x, int y, int z, int side, int meta)
    {
        if ((side & 3) == 1 && world.rand.nextInt(meta) == 0)
        {
            //this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.apple, 1, 0));
        }
    }
    
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int i)
    {
        return super.damageDropped(i);
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(OPWeapons.OPWSaplingBlocks);
    }
    /**
     * Get the block's damage value (for use with pick block).
     */
    public int getDamageValue(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_)
    {
        return p_149643_1_.getBlockMetadata(p_149643_2_, p_149643_3_, p_149643_4_) & 3;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1] : this.field_150129_M[this.field_150127_b][0];
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativetabs, List list) {	
    	for (int i = 0; i < leaves.length; i++) {
    
		list.add(new ItemStack(item, 1, i));
	
    	}
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
    {
        for (int i = 0; i < leaftypes.length; ++i)
        {
            this.field_150129_M[i] = new IIcon[leaftypes[i].length];

            for (int j = 0; j < leaftypes[i].length; ++j)
            {
                this.field_150129_M[i][j] = iconregister.registerIcon("opweapons:" + leaftypes[i][j]);
            }
        }
    }

    public String[] func_150125_e()
    {
        return leaves;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
		return false;
    	
    }
    @Override
    public boolean isOpaqueCube() {
    	return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side) {
		return true;
    	
    }
}
