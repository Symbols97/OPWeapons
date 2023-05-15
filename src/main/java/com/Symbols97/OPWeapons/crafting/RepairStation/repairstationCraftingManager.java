package com.Symbols97.OPWeapons.crafting.RepairStation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class repairstationCraftingManager{
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
    /** The static instance of this class */
    private static final repairstationCraftingManager instance = new repairstationCraftingManager();
    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";

    /**
     * Returns the static instance of this class
     */
    public static final repairstationCraftingManager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    private repairstationCraftingManager()
    {
        recipes = new ArrayList();
        //Tools/weapons
        
        this.addShapelessRecipe(new ItemStack(OPWeapons.opSword), new ItemStack(OPWeapons.opSword, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(OPWeapons.opPickaxe), new ItemStack(OPWeapons.opPickaxe, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(OPWeapons.opAxe), new ItemStack(OPWeapons.opAxe, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(OPWeapons.opHoe), new ItemStack(OPWeapons.opHoe, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(OPWeapons.opShovel), new ItemStack(OPWeapons.opShovel, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
		this.addShapelessRecipe(new ItemStack(OPWeapons.fireSword), new ItemStack(OPWeapons.fireSword,1,WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule,1,WILDCARD_VALUE) );
		this.addShapelessRecipe(new ItemStack(OPWeapons.iceSword), new ItemStack(OPWeapons.iceSword, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
		
		
		
		//Slayers
		this.addShapelessRecipe(new ItemStack(OPWeapons.demonSlayer), new ItemStack(OPWeapons.demonSlayer,1,WILDCARD_VALUE), new ItemStack(OPWeapons.ultimatenetherstar));
		this.addShapelessRecipe(new ItemStack(OPWeapons.frostSlayer), new ItemStack(OPWeapons.frostSlayer,1,WILDCARD_VALUE), new ItemStack(OPWeapons.ultimatenetherstar));
		
		
		//Demon Hammer
		this.addShapelessRecipe(new ItemStack(OPWeapons.demonHammer), new ItemStack(OPWeapons.demonHammer,1,WILDCARD_VALUE), new ItemStack(OPWeapons.ultimatenetherstar));
		
		//Frost Axe
		this.addShapelessRecipe(new ItemStack(OPWeapons.frostAxe), new ItemStack(OPWeapons.frostAxe,1,WILDCARD_VALUE), new ItemStack(OPWeapons.ultimatenetherstar));
		
		//Club
		this.addShapelessRecipe(new ItemStack(OPWeapons.opClub), new ItemStack(OPWeapons.opClub, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        
		
		//armors	  
        this.addShapelessRecipe(new ItemStack(OPWeapons.opHelmet), new ItemStack(OPWeapons.opHelmet, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(OPWeapons.opChestplate), new ItemStack(OPWeapons.opChestplate, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(OPWeapons.opLeggings), new ItemStack(OPWeapons.opLeggings, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(OPWeapons.opBoots), new ItemStack(OPWeapons.opBoots, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
      
        //Vanilla Items
        this.addShapelessRecipe(new ItemStack(Items.diamond_sword), new ItemStack(Items.diamond_sword, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(Items.diamond_axe), new ItemStack(Items.diamond_axe, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(Items.diamond_hoe), new ItemStack(Items.diamond_hoe, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(Items.diamond_pickaxe), new ItemStack(Items.diamond_pickaxe, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(Items.diamond_shovel), new ItemStack(Items.diamond_shovel, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE)); 
        this.addShapelessRecipe(new ItemStack(Items.iron_sword), new ItemStack(Items.iron_sword, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(Items.iron_axe), new ItemStack(Items.iron_axe, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(Items.iron_hoe), new ItemStack(Items.iron_hoe, 1, WILDCARD_VALUE),new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(Items.iron_pickaxe), new ItemStack(Items.iron_pickaxe, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        this.addShapelessRecipe(new ItemStack(Items.iron_shovel), new ItemStack(Items.iron_shovel, 1, WILDCARD_VALUE), new ItemStack(OPWeapons.repairModule, 1, WILDCARD_VALUE));
        
        
        
        Collections.sort(this.recipes, new repairstationRecipeSorter(this));
    }

    public repairstationShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (par2ArrayOfObj[i] instanceof String[])
        {
            String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

            for (int l = 0; l < astring.length; ++l)
            {
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }
        else
        {
            while (par2ArrayOfObj[i] instanceof String)
            {
                String s2 = (String)par2ArrayOfObj[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < par2ArrayOfObj.length; i += 2)
        {
            Character character = (Character)par2ArrayOfObj[i];
            ItemStack itemstack1 = null;

            if (par2ArrayOfObj[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
            }
            else if (par2ArrayOfObj[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
            }
            else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        repairstationShapedRecipes shapedrecipes = new repairstationShapedRecipes(j, k, aitemstack, par1ItemStack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new ShapelessRecipes(par1ItemStack, arraylist));
    }

    public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }

        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(par1InventoryCrafting, par2World))
                {
                    return irecipe.getCraftingResult(par1InventoryCrafting);
                }
            }

            return null;
        }
    }

    /**
     * returns the List<> of all recipes
     */
    public List getRecipeList()
    {
        return this.recipes;
    }
}