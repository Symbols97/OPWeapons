package com.Symbols97.OPWeapons.blocks;

import java.util.Random;

import com.Symbols97.OPWeapons.OPUtils;
import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.Dimension.DimensionRegistry;
import com.Symbols97.OPWeapons.Dimension.FrostZone.FrostZoneTeleporter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class FrostZonePortal extends BlockPortal
{	
	/** location of portal frame blocks relative to the lower left portal block (omitting z-coords) */
	private static int[][] frameLocs = {{-1,0},{-1,1},{-1,2},{0,3},{1,3},{2,2},{2,1},{2,0},{1,-1},{0,-1}};
	/** location of portal blocks relative to the lower left portal block (omitting z-coords) */
	private static int[][] portalLocs = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2}};
	private static Block frameBlock = OPWeapons.condensedbofg;

	public FrostZonePortal() 
	{
		super();//(Material.portal);
		this.setHardness(-1F);
		this.setBlockName("Frost_Zone_Portal");
		//this.setBlockTextureName("opweapons:textures/models/RepairStationModel.png");
	}

	@Override
	public void updateTick(World worldIn, int x, int y, int z, Random rand)
	{
		super.updateTick(worldIn, x, y, z, rand);
	}
	
	 /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
	@Override
    public void onBlockAdded(World worldIn, int x, int y, int z) 
    {
		// if it's not touching another portal, try to make a portal -- if that fails, remove this block
    	if(!OPUtils.isTouchingBlock(worldIn, x, y, z, this) && !this.tryAddPortalBlocks(worldIn, x, y, z))
    	{
    		worldIn.setBlockToAir(x, y, z);
    	}
    }

	@Override
	public void onEntityCollidedWithBlock(World worldIn, int x, int y, int z, Entity entity)
	{
		if (entity.ridingEntity == null && entity.riddenByEntity == null && (entity instanceof EntityPlayerMP))
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
			MinecraftServer mcServer = MinecraftServer.getServer();
			int dimID = DimensionRegistry.FZdimensionId;

			if(thePlayer.timeUntilPortal > 0)
			{
				thePlayer.timeUntilPortal = 10;
			}
			else if(thePlayer.dimension != dimID)
			{
				thePlayer.timeUntilPortal = 10;
				mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, dimID, new FrostZoneTeleporter(mcServer.worldServerForDimension(dimID)));
			}
			else if(thePlayer.dimension == dimID)
			{
				thePlayer.timeUntilPortal = 10;
				mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new FrostZoneTeleporter(mcServer.worldServerForDimension(0)));
			}
		}
	}
	
	public boolean tryAddPortalBlocks(World worldIn, int x, int y, int z)
	{
		if(this.isFrameValid(worldIn, x, y, z))
		{
			boolean isXAligned = worldIn.getBlock(x - 1, y, z) == this.frameBlock || worldIn.getBlock(x + 1, y, z) == this.frameBlock;
			int offsetY = getOffsetY(worldIn, x, y, z);
			int offsetXZ = getOffsetXZ(worldIn, x, y, z);
			for(int i = 0, j = portalLocs.length; i < j; ++i)
			{
				if(isXAligned)
				{
					OPUtils.setBlockIfAir(worldIn, x + offsetXZ + portalLocs[i][0], y + offsetY + portalLocs[i][1], z, this);
				}
				else
				{
					OPUtils.setBlockIfAir(worldIn, x, y + offsetY + portalLocs[i][1], z + offsetXZ + portalLocs[i][0], this);
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor Block
	 */
	@Override
	public void onNeighborBlockChange(World worldIn, int x, int y, int z, Block block)
	{	
		if(!this.isFrameValid(worldIn, x, y, z))
		{
			worldIn.setBlockToAir(x, y, z);
		}
	}
	
	/**
	 * Checks that there are 10 blocks in the correct spots for a portal frame
	 * X,Y,Z passed is where the portal block should appear if the frame IS valid
	 */
	public boolean isFrameValid(World worldIn, int x, int y, int z)
	{
		boolean isXAligned = worldIn.getBlock(x - 1, y, z) == this.frameBlock || worldIn.getBlock(x + 1, y, z) == this.frameBlock;
		int offsetY = this.getOffsetY(worldIn, x, y, z);
		int offsetXZ = this.getOffsetXZ(worldIn, x, y, z);
		int xPos = x;
		int yPos = y;
		int zPos = z;
		
		if(offsetY == 8 || offsetXZ == 8) return false; // if a value still equals the default value, return

		for(int i = 0, j = frameLocs.length; i < j; i++)
		{
			// first checks on x-axis
			if(!(worldIn.getBlock(x + offsetXZ + frameLocs[i][0], y + offsetY + frameLocs[i][1], z) == this.frameBlock))
			{
				// next checks on z-axis
				if(!(worldIn.getBlock(x, y + offsetY + frameLocs[i][1], z + offsetXZ + frameLocs[i][0]) == this.frameBlock))
				{
					// debug: System.out.print("\nFrame is not valid at " + xPos + ", " + yPos + ", " + zPos + " (This block is at " + x + ", " + y + ", " + z + ")");
					return false;
				}
			}
		}
		return true;
	}
	
	private int getOffsetY(World worldIn, int x, int y, int z)
	{
		int offsetY = 8; //default value -- will be checked to see if it never found a frame block

		for(int i = 0; i < 3; i++)
		{
			if(worldIn.getBlock(x, y - 1 - i, z) == this.frameBlock)
			{
				offsetY = -i;
			}
		}
		return offsetY;
	}

	private int getOffsetXZ(World worldIn, int x, int y, int z)
	{	
		if(worldIn.getBlock(x - 1, y, z) == this.frameBlock || worldIn.getBlock(x, y, z - 1) == this.frameBlock)
		{
			return 0;
		}
		else if(worldIn.getBlock(x + 1, y, z) == this.frameBlock || worldIn.getBlock(x, y, z + 1) == this.frameBlock)
		{
			return -1;
		}
		else return 8;
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess iaccess, int x, int y, int z)
	{
		int l = metaFunction(iaccess.getBlockMetadata(x, y, z));

		if (l == 0)
		{
			if (iaccess.getBlock(x - 1, y, z) != this && iaccess.getBlock(x + 1, y, z) != this)
			{
				l = 2;
			}
			else
			{
				l = 1;
			}

			if (iaccess instanceof World && !((World)iaccess).isRemote)
			{
				((World)iaccess).setBlockMetadataWithNotify(x, y, z, l, 2);
			}
		}

		float f = 0.125F;
		float f1 = 0.125F;

		if (l == 1)
		{
			f = 0.5F;
		}

		if (l == 2)
		{
			f1 = 0.5F;
		}

		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
	 * cleared to be reused)
	 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World worldIn, int x, int y, int z)
	{
		return Item.getItemById(0);
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass()
	{
		return 1;
	}

	public static int metaFunction(int i)
	{
		return i & 3;
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	 * coordinates.  Args: blockAccess, x, y, z, side
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess iaccess, int x, int y, int z, int side)
	{
		int i1 = 0;

		if (iaccess.getBlock(x, y, z) == this)
		{
			i1 = metaFunction(iaccess.getBlockMetadata(x, y, z));

			if (i1 == 0)
			{
				return false;
			}

			if (i1 == 2 && side != 5 && side != 4)
			{
				return false;
			}

			if (i1 == 1 && side != 3 && side != 2)
			{
				return false;
			}
		}

		boolean flag = iaccess.getBlock(x - 1, y, z) == this && iaccess.getBlock(x - 2, y, z) != this;
		boolean flag1 = iaccess.getBlock(x + 1, y, z) == this && iaccess.getBlock(x + 2, y, z) != this;
		boolean flag2 = iaccess.getBlock(x, y, z - 1) == this && iaccess.getBlock(x, y, z - 2) != this;
		boolean flag3 = iaccess.getBlock(x, y, z + 1) == this && iaccess.getBlock(x, y, z + 2) != this;
		boolean flag4 = flag || flag1 || i1 == 1;
		boolean flag5 = flag2 || flag3 || i1 == 2;
		return flag4 && side == 4 ? true : (flag4 && side == 5 ? true : (flag5 && side == 2 ? true : flag5 && side == 3));
	}
	
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random p_149745_1_)
	{
		return 0;
	}	
}