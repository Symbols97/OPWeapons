package com.Symbols97.OPWeapons.blocks.trees;

import java.util.List;
import java.util.Random;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.world.WorldGenDemonTree;
import com.Symbols97.OPWeapons.world.WorldGenFrostTree;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OPWSaplings extends BlockSapling {
	
	 public static final String[] saplings = new String[] {"Demon", "Frost"};
	 private static final IIcon[] iconlength = new IIcon[saplings.length];
	

	    public OPWSaplings()
	    {
	        float f = 0.4F;
	        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	       // this.setCreativeTab(CreativeTabs.tabDecorations);
	    }

	    /**
	     * Ticks the block if it's been scheduled
	     */
	    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
	    {
	        if (!p_149674_1_.isRemote)
	        {
	            super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

	            if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9 && p_149674_5_.nextInt(7) == 0)
	            {
	                this.func_149879_c(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);
	            }
	        }
	    }
	    
	    @Override
	    public boolean canPlaceBlockOn(Block block)
	    {
	    	
	    	
			return block == OPWeapons.blockofdemongem || block == OPWeapons.BlockofFrostGem;
	
	    }

	    /**
	     * Gets the block's texture. Args: side, meta
	     */
	    @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	    {
	        p_149691_2_ &= 7;
	        return iconlength[MathHelper.clamp_int(p_149691_2_, 0, saplings.length - 1)];
	    }

	    public void func_149879_c(World p_149879_1_, int p_149879_2_, int p_149879_3_, int p_149879_4_, Random p_149879_5_)
	    {
	        int l = p_149879_1_.getBlockMetadata(p_149879_2_, p_149879_3_, p_149879_4_);

	        if ((l & 8) == 0)
	        {
	            p_149879_1_.setBlockMetadataWithNotify(p_149879_2_, p_149879_3_, p_149879_4_, l | 8, 4);
	        }
	        else
	        {
	            this.func_149878_d(p_149879_1_, p_149879_2_, p_149879_3_, p_149879_4_, p_149879_5_);
	        }
	    }

	    public void func_149878_d(World p_149878_1_, int p_149878_2_, int p_149878_3_, int p_149878_4_, Random p_149878_5_)
	    {
	        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(p_149878_1_, p_149878_5_, p_149878_2_, p_149878_3_, p_149878_4_)) return;
	        int l = p_149878_1_.getBlockMetadata(p_149878_2_, p_149878_3_, p_149878_4_) & 7;
	        Object object = p_149878_5_.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
	        int i1 = 0;
	        int j1 = 0;
	        boolean flag = false;

	        switch (l)
	        {
	            case 0:
	            	object = new WorldGenDemonTree();
	            	//object = new WorldGenOPWTrees(OPWeapons.OPWLogBlocks, OPWeapons.OPWLeafBlocks, 0, 0, false, 5, 10, false);
	            	break;
	            case 1:
	            	object = new WorldGenFrostTree();
	                break;
	            case 2:
	                break;
	            case 3:
	                break;
	            case 4:
	               
	                break;
	            case 5:
	            	break;
	            default:
	                break;
	        }

	        Block block = Blocks.air;

	        if (flag)
	        {
	            p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, block, 0, 4);
	            p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, block, 0, 4);
	            p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, block, 0, 4);
	            p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, block, 0, 4);
	        }
	        else
	        {
	            p_149878_1_.setBlock(p_149878_2_, p_149878_3_, p_149878_4_, block, 0, 4);
	        }

	        if (!((WorldGenerator)object).generate(p_149878_1_, p_149878_5_, p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1))
	        {
	            if (flag)
	            {
	                p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1, this, l, 4);
	                p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1, this, l, 4);
	                p_149878_1_.setBlock(p_149878_2_ + i1, p_149878_3_, p_149878_4_ + j1 + 1, this, l, 4);
	                p_149878_1_.setBlock(p_149878_2_ + i1 + 1, p_149878_3_, p_149878_4_ + j1 + 1, this, l, 4);
	            }
	            else
	            {
	                p_149878_1_.setBlock(p_149878_2_, p_149878_3_, p_149878_4_, this, l, 4);
	            }
	        }
	    }

	    public boolean func_149880_a(World world, int x, int y, int z, int par1)
	    {
	        return world.getBlock(x, y, z) == this && (world.getBlockMetadata(x, y, z) & 7) == par1;
	    }

	    /**
	     * Determines the damage on the item the block drops. Used in cloth and wood.
	     */
	    public int damageDropped(int p_149692_1_)
	    {
	        return MathHelper.clamp_int(p_149692_1_ & 7, 0, saplings.length - 1);
	    }

	    /**
	     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	     */
	    @SideOnly(Side.CLIENT)
	    public void getSubBlocks(Item item, CreativeTabs creativetabs, List list) {	
	    	for (int i = 0; i < saplings.length; i++) {
	    
			list.add(new ItemStack(item, 1, i));
		
	    	}
	    }

	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister p_149651_1_)
	    {
	        for (int i = 0; i < iconlength.length; ++i)
	        {
	        	iconlength[i] = p_149651_1_.registerIcon("opweapons:" + "Sapling_" + saplings[i]);
	        }
	    }

	    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
	    {
	        return true;
	    }

	    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
	    {
	        return (double)p_149852_1_.rand.nextFloat() < 0.45D;
	    }

	    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
	    {
	        this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
	    }
	}