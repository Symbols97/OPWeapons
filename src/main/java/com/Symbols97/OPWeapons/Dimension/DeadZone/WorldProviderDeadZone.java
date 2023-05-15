package com.Symbols97.OPWeapons.Dimension.DeadZone;

import com.Symbols97.OPWeapons.Dimension.DimensionRegistry;
import com.Symbols97.OPWeapons.biome.BiomeRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderDeadZone extends WorldProvider{

	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeRegistry.biomeDeadZone, 0F);
		this.dimensionId = DimensionRegistry.DZdimensionId;
	}
	
	public IChunkProvider createChunkProvider(){
		
		
		return new DeadZoneChunkProvider();
	}
	
	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(DimensionRegistry.DZdimensionId);
	}
	
	@SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_)
    {
        float f2 = MathHelper.cos(p_76562_1_ * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        float f3 = 0.7529412F;
        float f4 = 0.84705883F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        
        return worldObj.getSkyColor(Minecraft.getMinecraft().renderViewEntity, f5);
    }
	
	
	@Override
	public String getDimensionName() {
		
		return "Dead Zone";
	}
	
	
	@Override
	public boolean canRespawnHere(){
		return true;
	}
}
