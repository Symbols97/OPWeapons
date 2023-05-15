package com.Symbols97.OPWeapons.blocks;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.TileEntity.TileEntityRepairStationV2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class repairstationV2 extends BlockContainer {

	public repairstationV2(Material material) {
		super(material);
		this.setHardness(2.0F);
		this.setHarvestLevel("hand", 0);
		this.setStepSound(soundTypeWood);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.875F, 1.0F);
}

	//@SideOnly(Side.CLIENT)
	//private IIcon repairstationTop;
	
	
	//@SideOnly(Side.CLIENT)
	//public IIcon getIcon (int side, int metadata) {
	//	return side == 1 ? this.repairstationTop : this.blockIcon;
	//}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("opweapons:Repair_Station");
		
	}

		//Full Block Textures
		//this.blockIcon = iconRegister.registerIcon("OPWeapons:repairstationSide");
		//this.repairstationTop = iconRegister.registerIcon("OPWeapons:repairstationTop");
	
	
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
    {
	    if (!player.isSneaking())
   {
    player.openGui(OPWeapons.instance, OPWeapons.GUIRepairStationV2, var1, var2, var3, var4);
    return true;
   }
   else
   {
    return false;
   } 
	    
	    
    }
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityRepairStationV2();
	}
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack) {
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;
		
		if(l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		}
		
		if(l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 1, 2);
		}
		
		if(l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		
		if(l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		
	}
}
