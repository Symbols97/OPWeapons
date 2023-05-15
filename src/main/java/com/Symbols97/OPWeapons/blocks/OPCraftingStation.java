package com.Symbols97.OPWeapons.blocks;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.TileEntity.TileEntityOPCraftingStation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class opcraftingstation extends BlockContainer {

	public opcraftingstation(Material material) {
		super(material);
		this.setHardness(2.0F);
		this.setHarvestLevel("hand", 0);
		this.setStepSound(soundTypeWood);
		
}
	
	@SideOnly(Side.CLIENT)
		private IIcon OPCTTop;
	@SideOnly(Side.CLIENT)
		private IIcon OPCTBottom;
		
		@SideOnly(Side.CLIENT)
		public IIcon getIcon (int side, int metadata) {
			return side == 0 && side == 3 ? this.blockIcon : side == 1 ? this.OPCTTop : (side == 0 ? this.OPCTBottom : (side == metadata ? this.blockIcon : this.blockIcon));
			
			//return side == 1 ? this.repairstationTop : this.blockIcon;
			
		}
		
			//Full Block Textures
		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister iconRegister) {
			//this.blockIcon = iconRegister.registerIcon("opweapons:Repair_Station");
			this.blockIcon = iconRegister.registerIcon("OPWeapons:OPCTSide");
			this.OPCTTop = iconRegister.registerIcon("OPWeapons:OPCTTop");
			this.OPCTBottom = iconRegister.registerIcon("OPWeapons:OPCTBottom");}
		
			public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
		    {
			    if (!player.isSneaking())
		   {
		    player.openGui(OPWeapons.instance, OPWeapons.GUIOPCraftingStation, var1, var2, var3, var4);
		    return true;
		   }
		   else
		   {
		    return false;
		   } 
		    }

			@Override
			public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
				// TODO Auto-generated method stub
				return null;
			}


		}