package com.Symbols97.OPWeapons.crafting.TheForge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.Symbols97.OPWeapons.OPWeapons;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class theforgecraftingmanager {
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
    /** The static instance of this class */
    private static final theforgecraftingmanager instance = new theforgecraftingmanager();
    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";

    /**
     * Returns the static instance of this class
     */
    public static final theforgecraftingmanager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    private theforgecraftingmanager()
    {
        recipes = new ArrayList();
    
		//TOOLS/WEAPONS
    	//Demon Slayer
        this.addRecipe(new ItemStack(OPWeapons.demonSlayer), new Object[] {"ucu","fdf","uhu",'u', OPWeapons.demonGem, 'c', OPWeapons.crimsonBlade, 'f', new ItemStack(OPWeapons.firecapsule.setContainerItem(OPWeapons.capsule)), 'd', OPWeapons.DemonGemCore, 'h', OPWeapons.hellStick});
		
        //Frost Slayer
        this.addRecipe(new ItemStack(OPWeapons.frostSlayer), new Object [] {"fbf","pcp","fhf",'f', OPWeapons.frostGem,'b',OPWeapons.frostBlade,'p',Blocks.packed_ice,'c',OPWeapons.frostgemcore,'h',OPWeapons.froststick});
        
        //Lost Pickaxe
      	this.addRecipe(new ItemStack(OPWeapons.lostPickaxe), new Object [] {"lll"," s "," s ", 'l',OPWeapons.lostgem, 's',Items.stick});
        
      	//Demon Hammer
      	this.addRecipe(new ItemStack(OPWeapons.demonHammer), new Object [] {"h","d","b",'h', OPWeapons.HammerHead, 'd', OPWeapons.DemonGemCore, 'b', OPWeapons.HammerHandle});
      	
      	
        //Club
      	this.addRecipe(new ItemStack(OPWeapons.opClub), new Object [] {"h","c","b",'h', OPWeapons.ClubHead, 'c', OPWeapons.opGemCore, 'b', OPWeapons.ClubHandle});
      	
      	//Frost Axe
      	this.addRecipe(new ItemStack(OPWeapons.frostAxe), new Object [] {"b","c","h", 'b', OPWeapons.AxeBlade, 'c', OPWeapons.frostgemcore, 'h', OPWeapons.AxeHandle});
      	
		//ITEMS
		//Hell Stick
		this.addRecipe(new ItemStack(OPWeapons.hellStick), new Object[] {"uuu","ubu","uuu", 'u',OPWeapons.demonGem,'b', Items.blaze_rod });
		//Frost Stick
		this.addRecipe(new ItemStack(OPWeapons.froststick), new Object [] {"fff","fbf","fff",'f', OPWeapons.frostGem, 'b',Items.blaze_rod});
		//Demon Infused Gem Core
		this.addRecipe(new ItemStack(OPWeapons.DemonGemCore, 1), new Object [] {"uuu", "ucu", "uuu" , 'u', OPWeapons.demonGem, 'c', OPWeapons.opGemCore});
		//Crimson Blade
		this.addRecipe(new ItemStack(OPWeapons.crimsonBlade,1), new Object[] {"sus","nfn","sas", 's', OPWeapons.nethershard, 'u', OPWeapons.demonGem,'n', Blocks.netherrack, 'f', OPWeapons.fireSword, 'a', OPWeapons.ultimatenetherstar});
		//Frost Blade
		this.addRecipe(new ItemStack(OPWeapons.frostBlade), new Object [] {"sfs","pip","sas", 's', OPWeapons.nethershard, 'f', OPWeapons.frostGem,'p', Blocks.packed_ice, 'i', OPWeapons.iceSword, 'a', OPWeapons.ultimatenetherstar});
		// Tortured Soul
		this.addRecipe(new ItemStack(OPWeapons.torturedSoul), new Object[] {"dsd","sbs","dsd", 's', OPWeapons.miniSoul,'b', Blocks.soul_sand, 'd', OPWeapons.defrostedSoul});
		//RIP
		this.addRecipe(new ItemStack(OPWeapons.reaperImmunityPatch), new Object [] {"tst","sds","tst",'t', OPWeapons.torturedSoul, 's', Blocks.soul_sand, 'd', OPWeapons.deathEssence});
		// Soul Harvester
		this.addRecipe(new ItemStack(OPWeapons.soulHarvester), new Object [] {" h ","drd"," t ",'t', OPWeapons.torturedSoul,'h', OPWeapons.opHoe,'d',OPWeapons.deathEssence, 'r', OPWeapons.reaperImmunityPatch});
		//Dead Zone Staff
		this.addRecipe(new ItemStack(OPWeapons.DZStaff), new Object [] {"ddd","dsd","ddd", 'd', OPWeapons.demonGem, 's', new ItemStack(OPWeapons.neutralStaff,1,WILDCARD_VALUE)});
		//Frost Zone Staff
		this.addRecipe(new ItemStack(OPWeapons.FZStaff), new Object [] {"fff","fsf","fff",'f', OPWeapons.frostGem, 's', new ItemStack(OPWeapons.neutralStaff,1,WILDCARD_VALUE)});
		
		//Demon Ring
		this.addRecipe(new ItemStack(OPWeapons.demonRing), new Object [] {" d ", "g g", " g ", 'd', OPWeapons.demonGem, 'g', OPWeapons.demonGold});
		//Frost Ring
		this.addRecipe(new ItemStack(OPWeapons.frostRing), new Object [] {" f ", "g g", " g ", 'f', OPWeapons.frostGem, 'g', OPWeapons.frostGold});
		
		
		
		//Armor
		this.addRecipe(new ItemStack(OPWeapons.demonHead), new Object[] {"uuu","ugu","uuu", 'u', OPWeapons.demonGem, 'g',OPWeapons.opHelmet});
		this.addRecipe(new ItemStack(OPWeapons.demonChest), new Object[] {"uuu","ugu","uuu", 'u', OPWeapons.demonGem, 'g',OPWeapons.opChestplate});
		this.addRecipe(new ItemStack(OPWeapons.demonLeggings), new Object[] {"uuu","ugu","uuu", 'u', OPWeapons.demonGem, 'g', OPWeapons.opLeggings});
		this.addRecipe(new ItemStack(OPWeapons.demonBoots), new Object[] {"uuu","ugu","uuu", 'u', OPWeapons.demonGem, 'g', OPWeapons.opBoots});
		
		
		this.addRecipe(new ItemStack(OPWeapons.frostHelmet), new Object[] {"fff","fgf","fff", 'f', OPWeapons.frostGem, 'g',OPWeapons.opHelmet});
		this.addRecipe(new ItemStack(OPWeapons.frostChestplate), new Object[] {"fff","fgf","fff", 'f', OPWeapons.frostGem, 'g',OPWeapons.opChestplate});
		this.addRecipe(new ItemStack(OPWeapons.frostLeggings), new Object[] {"fff","fgf","fff", 'f', OPWeapons.frostGem, 'g', OPWeapons.opLeggings});
		this.addRecipe(new ItemStack(OPWeapons.frostBoots), new Object[] {"fff","fgf","fff", 'f', OPWeapons.frostGem, 'g', OPWeapons.opBoots});
		
		this.addRecipe(new ItemStack(OPWeapons.lostHelmet), new Object[] {"lll","lgl","lll", 'l', OPWeapons.lostgem, 'g',OPWeapons.opHelmet});
		this.addRecipe(new ItemStack(OPWeapons.lostChestplate), new Object[] {"lll","lgl","lll", 'l', OPWeapons.lostgem, 'g',OPWeapons.opChestplate});
		this.addRecipe(new ItemStack(OPWeapons.lostLeggings), new Object[] {"lll","lgl","lll", 'l', OPWeapons.lostgem, 'g', OPWeapons.opLeggings});
		this.addRecipe(new ItemStack(OPWeapons.lostBoots), new Object[] {"lll","lgl","lll", 'l', OPWeapons.lostgem, 'g', OPWeapons.opBoots});
		
		
		
		//Lost Gem Block (Item To Block)
		this.addRecipe(new ItemStack(OPWeapons.BlockOfLostGem,1), new Object[] {"lll","lll","lll",'l', OPWeapons.lostgem});
		//Lost Gem (Block to Item)
		this.addShapelessRecipe(new ItemStack(OPWeapons.lostgem,9), new Object[] {OPWeapons.BlockOfLostGem});
		//Block of Demon Gem (Item to block)
		this.addRecipe(new ItemStack(OPWeapons.blockofdemongem,1), new Object[] {"uuu","uuu","uuu",'u', OPWeapons.demonGem});
		//Block of Green Gem (Item to block)
		this.addRecipe(new ItemStack(OPWeapons.blockofopGem), new Object[] { "ggg", "ggg", "ggg", 'g', OPWeapons.opGem });
		//condensedbodg (Item to block)
		this.addRecipe(new ItemStack(OPWeapons.condensedbodg), new Object[] {"bbb","bbb","bbb", 'b' , OPWeapons.blockofdemongem});
		//condensedbodg (block to item)
		this.addShapelessRecipe(new ItemStack(OPWeapons.blockofdemongem,9), new Object[] {OPWeapons.condensedbodg});
						
		//Block o' XP
		this.addRecipe(new ItemStack(OPWeapons.blockoenchanting,64), new Object[] {"xxx","xex","xxx",'x', OPWeapons.lostgem, 'e' , Items.experience_bottle});		
		//BlockofFrostGem item to block
		this.addRecipe(new ItemStack(OPWeapons.BlockofFrostGem), new Object [] {"fff","fff","fff",'f', OPWeapons.frostGem});
		//BlockofFrostGem block to item
		this.addShapelessRecipe(new ItemStack(OPWeapons.frostGem, 9), new Object [] {OPWeapons.BlockofFrostGem});
		//Condensed Frost Block
		this.addRecipe(new ItemStack(OPWeapons.condensedbofg), new Object [] {"bbb","bbb","bbb", 'b', OPWeapons.BlockofFrostGem});
		this.addShapelessRecipe(new ItemStack(OPWeapons.BlockofFrostGem,9), new Object [] {OPWeapons.condensedbofg});

		// LoreBook - Complete
		this.addRecipe(new ItemStack(OPWeapons.opLoreBookComplete,1), new Object[] {"bp ","pp ","   ",'p',OPWeapons.lostPages,'b',OPWeapons.opLoreBookIncomplete});
		
        //Invisibility Remote
		//this.addRecipe(new ItemStack(OPWeapons.invisRemote), new Object [] {"rgs","sps","sgs",'r', Blocks.redstone_torch,'g', OPWeapons.lostgem,'s', OPWeapons.steelIngot, 'p', new ItemStack(Items.potionitem,1,8270)});
		
		 Collections.sort(this.recipes, new theforgerecipesorter(this));
    } 
    
    public theforgeShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
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

        theforgeShapedRecipes shapedrecipes = new theforgeShapedRecipes(j, k, aitemstack, par1ItemStack);
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