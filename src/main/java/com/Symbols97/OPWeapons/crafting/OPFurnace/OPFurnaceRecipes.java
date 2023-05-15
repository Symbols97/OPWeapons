package com.Symbols97.OPWeapons.crafting.OPFurnace;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.Symbols97.OPWeapons.OPWeapons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class OPFurnaceRecipes {
	
    private static final OPFurnaceRecipes smeltingBase = new OPFurnaceRecipes();
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static OPFurnaceRecipes smelting()
    {
        return smeltingBase;
    }

    private OPFurnaceRecipes()
    {
    	
    	
    	
    
        //Items to items / blocks
        this.func_151396_a(Items.coal, new ItemStack(Items.diamond), 0.35F);
        this.func_151396_a(Items.diamond, new ItemStack(Items.emerald), 0.35F);
        this.func_151396_a(Items.emerald, new ItemStack(OPWeapons.opGem), 0.35F);
        this.func_151396_a(OPWeapons.opGem, new ItemStack(Items.coal), 0.35F);      
        this.func_151396_a(Items.nether_star, new ItemStack(OPWeapons.nethershard, 5), 500.0F);
        this.func_151396_a(OPWeapons.mutton, new ItemStack(OPWeapons.cookedMutton, 2), 0.0F);

        //Blocks to items or blocks
        this.func_151393_a(Blocks.coal_block, new ItemStack(Blocks.diamond_block), 0.35F);
        this.func_151393_a(Blocks.diamond_block, new ItemStack(Blocks.emerald_block), 0.35F);
        this.func_151393_a(Blocks.emerald_block, new ItemStack(OPWeapons.blockofopGem), 0.35F);
        this.func_151393_a(OPWeapons.blockofopGem, new ItemStack(Blocks.coal_block), 0.35F);   
         
        this.func_151393_a(OPWeapons.opgemOre, new ItemStack(OPWeapons.opGemChunk, 8), 0.0F);

		

    //EXPLOITS
        this.func_151396_a(Items.blaze_rod, new ItemStack(Items.blaze_powder,9), 0.35F);  
        this.func_151396_a(Items.gold_nugget, new ItemStack(OPWeapons.goldParticle,2), 0.35F);   
        
        //Items that have item variants
    	this.func_151394_a(new ItemStack(Items.skull,1,2), new ItemStack(Items.skull), 0.35F);
        this.func_151394_a(new ItemStack(Items.skull), new ItemStack(Items.skull,1,1), 0.35F);
        
        
//        this.func_151393_a(Blocks.coal_ore, new ItemStack(Items.coal), 0.1F);
//        this.func_151393_a(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7F);
//        this.func_151393_a(Blocks.lapis_ore, new ItemStack(Items.dye, 1, 4), 0.2F);
//        this.func_151393_a(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2F);
    }

    public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
    {
        this.func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
    {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }

    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}
