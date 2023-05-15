package com.Symbols97.OPWeapons.crafting.OPCraftingStation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

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

public class opcraftingstationcraftingmanager {
	
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
    /** The static instance of this class */
    private static final opcraftingstationcraftingmanager instance = new opcraftingstationcraftingmanager();
    /** A list of all the recipes added */
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";
    protected static Random itemRand = new Random();
    /**
     * Returns the static instance of this class
     */
    public static final opcraftingstationcraftingmanager getInstance()
    {
        /** The static instance of this class */
        return instance;
    }

    
    
    private opcraftingstationcraftingmanager()
    {
        recipes = new ArrayList();

	//TOOLS/WEAPONS
    	//OP Shovel
  		this.addRecipe(new ItemStack(OPWeapons.opShovel), new Object [] {"ggg","gbg","ggg",'g', OPWeapons.opGem, 'b', Items.diamond_shovel});
  		//OP Hoe
  		this.addRecipe(new ItemStack(OPWeapons.opHoe), new Object [] {"ggg","ghg","ggg",'g', OPWeapons.opGem, 'h', Items.diamond_hoe});
  		//OP Axe
  		this.addRecipe(new ItemStack(OPWeapons.opAxe), new Object [] {"ggg","gag", "ggg",'g', OPWeapons.opGem, 'a', Items.diamond_axe});
  		//OP Pickaxe
		this.addRecipe(new ItemStack(OPWeapons.opPickaxe), new Object [] {"ggg", "gpg", "ggg",'g', OPWeapons.opGem, 'p', Items.diamond_pickaxe});
		//OP Sword
		this.addRecipe(new ItemStack(OPWeapons.opSword), new Object[] {"ggg", "gsg", "ggg", 'g', OPWeapons.opGem, 's', Items.diamond_sword});	
		//Fire Sword
	    this.addRecipe(new ItemStack(OPWeapons.fireSword), new Object[] {"gfg","gfg","gsg",'g',OPWeapons.opGem, 'f', OPWeapons.firecapsule,'s',OPWeapons.opSword});
		//Ice Sword
	    this.addRecipe(new ItemStack(OPWeapons.iceSword), new Object[] {"gig","gig","gsg",'g', OPWeapons.opGem,'i', Blocks.packed_ice,'s', OPWeapons.opSword});
	    //Neutral Staff
	  	this.addRecipe(new ItemStack(OPWeapons.neutralStaff), new Object[] {"ici", "isi", "isi", 'i', Items.iron_ingot, 'c', OPWeapons.neutralCore, 's', Items.stick});
  
	//ITEMS
		//Demon Gem 
		this.addRecipe(new ItemStack(OPWeapons.demonGem,3),new Object [] {"gng","gsg","fff", 'g', OPWeapons.opGem,'n',Items.nether_wart ,'s', OPWeapons.nethershard, 'f', OPWeapons.firecapsule});
		//Demon Gem (Block to Item)
		this.addShapelessRecipe(new ItemStack(OPWeapons.demonGem, 9), new Object[] { OPWeapons.blockofdemongem }); 		
		//Green Gem
		this.addRecipe(new ItemStack(OPWeapons.opGem, 1), new Object[] { "ccc", "cdc", "ccc", 'c', OPWeapons.opGemChunk, 'd', Items.diamond });
		//Green Gem (Block to Item)
		this.addShapelessRecipe(new ItemStack(OPWeapons.opGem, 9), new Object[] { OPWeapons.blockofopGem });	
		//Nether Star
		this.addRecipe(new ItemStack(Items.nether_star, 1), new Object[] {" s ","sss"," s ",'s',OPWeapons.nethershard});
		//Ultimate Nether Star
		this.addRecipe(new ItemStack(OPWeapons.ultimatenetherstar, 1), new Object[] {"dsd","gng","dsd",'d', Items.diamond, 's', OPWeapons.nethershard, 'g', OPWeapons.opGem,'n',Items.nether_star});
		//Repair Module
		this.addRecipe(new ItemStack(OPWeapons.repairModule,1), new Object [] {"iri","igi","iri", 'i', Items.iron_ingot, 'g', OPWeapons.opGem,'r', Items.redstone});
		//Gem Core
		this.addRecipe(new ItemStack(OPWeapons.opGemCore),new Object[] {"gig","drd","ggg", 'g',OPWeapons.opGemChunk,'i', Items.iron_ingot, 'd', Items.diamond, 'r', Blocks.redstone_block});
		//Lost Gem
		this.addRecipe(new ItemStack(OPWeapons.lostgem,3), new Object [] {"dog", "fsf","bbb", 'd', OPWeapons.demonGem, 'o', OPWeapons.opGem, 'g', OPWeapons.frostGem, 'f', OPWeapons.firecapsule, 's', OPWeapons.nethershard, 'b', Blocks.obsidian });
		//Demon Infused Gem Core
		this.addRecipe(new ItemStack(OPWeapons.DemonGemCore, 1), new Object [] {"uuu", "ucu", "uuu" , 'u', OPWeapons.demonGem, 'c', OPWeapons.opGemCore});
		//Capsule
		this.addRecipe(new ItemStack(OPWeapons.capsule,3), new Object [] {"ooo","ggg","ogo",'o', Blocks.obsidian, 'g',Blocks.glass_pane});
		//Fire Capsule
		this.addRecipe(new ItemStack(OPWeapons.firecapsule), new Object [] {"f","n","c",'f',  new ItemStack(OPWeapons.opFlintandSteel, 1, WILDCARD_VALUE), 'n', Blocks.netherrack, 'c', OPWeapons.capsule});
		this.addRecipe(new ItemStack(OPWeapons.firecapsule), new Object [] {"#","n","c",'#',  new ItemStack(Items.flint_and_steel, 1, WILDCARD_VALUE), 'n', Blocks.netherrack, 'c', OPWeapons.capsule});
		//Neutral Core
		this.addRecipe(new ItemStack(OPWeapons.neutralCore), new Object[] {"bgb","bib","bdb", 'b', OPWeapons.lostgem, 'g', OPWeapons.opGemCore, 'i', OPWeapons.frostgemcore, 'd', OPWeapons.DemonGemCore});
		//Frost Core
		this.addRecipe(new ItemStack(OPWeapons.frostgemcore), new Object [] {"fff", "fcf", "fff" , 'f', OPWeapons.frostGem, 'c', OPWeapons.opGemCore});
		//Frost Gem
		this.addRecipe(new ItemStack(OPWeapons.frostGem,3),new Object [] {"gsg","gng","iii", 'g', OPWeapons.opGem,'s',Blocks.snow ,'n', OPWeapons.nethershard, 'i', Blocks.packed_ice});
		//Handle Base
		this.addRecipe(new ItemStack(OPWeapons.HandleBase), new Object[] {"i","i","i",'i', Items.iron_ingot});
		//Handle Grip
		this.addRecipe(new ItemStack(OPWeapons.HandleGrip), new Object [] {"wcl", "cic","lcw", 'w', new ItemStack(Blocks.planks,1,0), 'c', new ItemStack(Blocks.stained_hardened_clay,1,12),'l', Items.leather, 'i', Items.iron_ingot});
		//Handle Hilt
		this.addRecipe(new ItemStack(OPWeapons.HandleHilt), new Object [] {"lil","ccc", 'l', Items.leather, 'i', Items.iron_ingot, 'c', new ItemStack(Blocks.stained_hardened_clay,1,12)});
		//Handle
		this.addRecipe(new ItemStack(OPWeapons.HammerHandle), new Object[] {"gbg"," h ", 'g', OPWeapons.HandleGrip, 'b', OPWeapons.HandleBase, 'h', OPWeapons.HandleHilt});
		//Hammer Head
		this.addRecipe(new ItemStack(OPWeapons.HammerHead), new Object [] {"ini","lal","dod", 'i', Items.iron_ingot, 'n', OPWeapons.ultimatenetherstar, 'l', Items.lava_bucket, 'a', Blocks.anvil, 'd', OPWeapons.demonGem, 'o', Blocks.obsidian});	
		//Club Head
		this.addRecipe(new ItemStack(OPWeapons.ClubHead), new Object [] {"ggg","gsg", "ggg", 'g' , OPWeapons.opGem, 's', Blocks.stone});	
		//Club Handle
		this.addRecipe(new ItemStack(OPWeapons.ClubHandle), new Object [] {" s ", "nsn", "www", 's', Items.stick, 'n', Blocks.stone, 'w', new ItemStack(Blocks.planks,1,0)});	
		//Frost Axe Blade
		this.addRecipe(new ItemStack(OPWeapons.AxeBlade), new Object [] {"gp ", "psg", " gg", 'g', OPWeapons.frostGem, 'p', Blocks.packed_ice, 's', OPWeapons.ultimatenetherstar});
		//Frost Axe Handle
		this.addRecipe(new ItemStack(OPWeapons.AxeHandle), new Object [] {"lsl", " i ", " s ", 'l', Items.leather, 's', Items.stick, 'i', Items.iron_ingot});
		//Steel Ingot
		this.addRecipe(new ItemStack(OPWeapons.steelIngot), new Object [] {"sss","sii","ii ", 's', OPWeapons.steelScrap, 'i', Items.iron_ingot});
		//Steel Pipe
		this.addRecipe(new ItemStack(OPWeapons.steelPipe), new Object [] {"  s", " s ", "  s", 's', OPWeapons.steelIngot});
		//Triple Pipe
		this.addRecipe(new ItemStack(OPWeapons.triplePipe), new Object[] {"ppp", 'p', OPWeapons.steelPipe});
		//Vent
		this.addRecipe(new ItemStack(OPWeapons.vent), new Object [] {"iii", 'i', Blocks.iron_bars});
		//OP FLint and Steel
		this.addRecipe(new ItemStack(OPWeapons.opFlintandSteel), new Object [] {"bsb","sfs","bsb", 'b', OPWeapons.blockofopGem,'s', OPWeapons.steelIngot, 'f', Items.flint_and_steel});
		//OP Bow
		this.addRecipe(new ItemStack(OPWeapons.opBow), new Object [] {"ooo","obo","ooo",'o', OPWeapons.opGem, 'b', new ItemStack(Items.bow,1,WILDCARD_VALUE)});
		//Lapiz Arrow
		this.addRecipe(new ItemStack(OPWeapons.lapizArrow), new Object [] {"lll","lal","lll",'l',new ItemStack(Items.dye,1,4),'a',Items.arrow});
		
	//Books		
		//Demon Book
		this.addRecipe(new ItemStack(OPWeapons.opDemonBook), new Object [] {"ddd","dbd","ddd", 'd', OPWeapons.demonGem, 'b', OPWeapons.opWeaponsBook});
		//Frost Book
		this.addRecipe(new ItemStack(OPWeapons.opFrostBook), new Object [] {"fff","fbf","fff", 'f', OPWeapons.frostGem, 'b', OPWeapons.opWeaponsBook});
		//Lore Book - Incomplete
		this.addRecipe(new ItemStack(OPWeapons.opLoreBookIncomplete), new Object [] {"lll","lbl","lll",'l',OPWeapons.lostgem, 'b', OPWeapons.opWeaponsBook});
		//Food Book
		this.addRecipe(new ItemStack(OPWeapons.opFoodBook), new Object[] {"sss","sos","sss", 's', Items.cooked_beef, 'o', OPWeapons.opWeaponsBook});
		//OP Book 2
		this.addRecipe(new ItemStack(OPWeapons.opWeaponsBook2), new Object[] {"ggg","gog","ggg", 'g', OPWeapons.opGem, 'o', OPWeapons.opWeaponsBook});
	
	//Food
		//Magic Food
		this.addRecipe(new ItemStack(OPWeapons.magicFood, 2), new Object[] {"cgc","gbg", "cgc", 'c', OPWeapons.opGemChunk, 'b', Items.cooked_beef, 'g', OPWeapons.opGem});
		//Magic Mutton
		this.addRecipe(new ItemStack(OPWeapons.magicMutton,2), new Object[] {"cgc","gmg", "cgc", 'c', OPWeapons.opGemChunk, 'm', OPWeapons.cookedMutton, 'g', OPWeapons.opGem});
		//Spicy Chicken
		this.addRecipe(new ItemStack(OPWeapons.spicyChicken, 4), new Object[] { " f ", "fcf", "nnn", 'f', OPWeapons.firecapsule, 'c', Items.cooked_chicken, 'n', Blocks.netherrack});
		//Hot Coffee
		this.addRecipe(new ItemStack(OPWeapons.HotCoffee, 2), new Object[] {"cgc","gwg", "cgc", 'c', OPWeapons.firecapsule, 'w', Items.potionitem, 'g', OPWeapons.demonGem});
		//Snow Cone
		this.addRecipe(new ItemStack(OPWeapons.snowCone, 4), new Object[] { " s ", "sws", "iii", 's', Items.snowball, 'w', Items.potionitem, 'i', Blocks.packed_ice});
		//Ice Coffee
		this.addRecipe(new ItemStack(OPWeapons.IceCoffee, 2), new Object[] {"igi","gwg", "igi", 'i', Blocks.packed_ice, 'w', Items.potionitem, 'g', OPWeapons.frostGem});
		//Pet Food
		this.addRecipe(new ItemStack(OPWeapons.petFood), new Object [] {"sss","mmm"," b " , 's', OPWeapons.miniSoul, 'm', OPWeapons.magicFood, 'b', Items.bowl});
			
	//Armor
		this.addRecipe(new ItemStack(OPWeapons.opHelmet), new Object[] {"ggg","gdg","ggg", 'g', OPWeapons.opGem, 'd',new ItemStack(Items.diamond_helmet, 1, WILDCARD_VALUE)});
		this.addRecipe(new ItemStack(OPWeapons.opChestplate), new Object[]{"ggg","gdg","ggg", 'g', OPWeapons.opGem, 'd',new ItemStack(Items.diamond_chestplate, 1, WILDCARD_VALUE)});
		this.addRecipe(new ItemStack(OPWeapons.opLeggings), new Object[]{"ggg","gdg","ggg", 'g', OPWeapons.opGem, 'd',new ItemStack(Items.diamond_leggings, 1, WILDCARD_VALUE)});
		this.addRecipe(new ItemStack(OPWeapons.opBoots), new Object[] {"ggg","gdg","ggg", 'g', OPWeapons.opGem, 'd',new ItemStack(Items.diamond_boots, 1, WILDCARD_VALUE)});
		
	//BLOCKS
		//Lost Gem Block (Item To Block)
		this.addRecipe(new ItemStack(OPWeapons.BlockOfLostGem,1), new Object[] {"lll","lll","lll",'l', OPWeapons.lostgem});
		//Lost Gem (Block to Item)
		this.addShapelessRecipe(new ItemStack(OPWeapons.lostgem,9), new Object[] {OPWeapons.BlockOfLostGem});
		//Block of Demon Gem (Item to block)
		this.addRecipe(new ItemStack(OPWeapons.blockofdemongem,1), new Object[] {"uuu","uuu","uuu",'u', OPWeapons.demonGem});
		//Block of Green Gem (Item to block)
		this.addRecipe(new ItemStack(OPWeapons.blockofopGem), new Object[] { "ggg", "ggg", "ggg", 'g', OPWeapons.opGem });
		//OP Crafting Station
		this.addRecipe(new ItemStack(OPWeapons.OPcraftingstation), new Object[] {" w ","ici","bbb",'w', Blocks.crafting_table, 'i', Items.iron_ingot, 'c', OPWeapons.opGemCore,'b', Blocks.iron_block});	
		//condensedbodg (block to item)
		this.addShapelessRecipe(new ItemStack(OPWeapons.blockofdemongem,9), new Object[] {OPWeapons.condensedbodg});
		//RepairStations
		this.addRecipe(new ItemStack(OPWeapons.repairstation), new Object[] {" a ","ici","bbb", 'a', Blocks.anvil, 'i',Items.iron_ingot,'c', Blocks.crafting_table,'b',Blocks.iron_block});
		this.addShapelessRecipe(new ItemStack(OPWeapons.repairstationV2,1), new Object[] {OPWeapons.repairstation});
		this.addShapelessRecipe(new ItemStack(OPWeapons.repairstation,1), new Object[] {OPWeapons.repairstationV2});		
		//OP Furnace
		this.addRecipe(new ItemStack(OPWeapons.OPFurnaceIdle), new Object [] {"iii", "ici", "ifi", 'i', Blocks.iron_block, 'c', OPWeapons.opGemCore, 'f', Blocks.furnace});   
		//The Forge
		this.addRecipe(new ItemStack(OPWeapons.TheForge), new Object[] {"unu","rcr","usu", 'u', OPWeapons.opGem, 'n', OPWeapons.ultimatenetherstar,'r',OPWeapons.repairModule,'c',OPWeapons.neutralCore,'s',OPWeapons.OPcraftingstation});	
		//BlockofFrostGem item to block
		this.addRecipe(new ItemStack(OPWeapons.BlockofFrostGem), new Object [] {"fff","fff","fff",'f', OPWeapons.frostGem});
		//BlockofFrostGem block to item
		this.addShapelessRecipe(new ItemStack(OPWeapons.frostGem, 9), new Object [] {OPWeapons.BlockofFrostGem});
		this.addShapelessRecipe(new ItemStack(OPWeapons.BlockofFrostGem,9), new Object [] {OPWeapons.condensedbofg});
		//Demon Furnace
		this.addRecipe(new ItemStack(OPWeapons.DemonFurnaceIdle), new Object [] {"iii", "ici", "ifi", 'i', Blocks.iron_block, 'c', OPWeapons.DemonGemCore, 'f', Blocks.furnace});   
		//Freezer
		this.addRecipe(new ItemStack(OPWeapons.freezer), new Object [] {"ggg", "pir","vbc", 'g', Blocks.glass, 'p', OPWeapons.triplePipe, 'i', Blocks.packed_ice, 'r', Items.redstone, 'v', OPWeapons.vent, 'b', OPWeapons.condensedbofg, 'c', OPWeapons.frostgemcore});
		//Wood
		this.addShapelessRecipe(new ItemStack(OPWeapons.OPW_Wood,1,0), new Object[] {new ItemStack(OPWeapons.OPWLogBlocks,1,0)});
		this.addShapelessRecipe(new ItemStack(OPWeapons.OPW_Wood,1,1), new Object[] {new ItemStack(OPWeapons.OPWLogBlocks,1,1)});
		//Stairs
		this.addRecipe(new ItemStack(OPWeapons.DemonStairs,1), new Object [] {"w  ","ww ","www" , 'w', new ItemStack(OPWeapons.OPW_Wood,1,0)});
		this.addRecipe(new ItemStack(OPWeapons.FrostStairs,1), new Object [] {"w  ","ww ","www" , 'w', new ItemStack(OPWeapons.OPW_Wood,1,1)});
		
		
	//Vanilla 	
		
		//Diamond Block to Item
		this.addShapelessRecipe(new ItemStack(Items.diamond,9), new Object [] {Blocks.diamond_block});
		//Item to block
		this.addRecipe(new ItemStack(Blocks.diamond_block), new Object [] {"ddd","ddd","ddd", 'd', Items.diamond});	
		//Emerald Block to Item
		this.addShapelessRecipe(new ItemStack(Items.emerald,9), new Object [] {Blocks.emerald_block});
		//Item to block
		this.addRecipe(new ItemStack(Blocks.emerald_block), new Object [] {"ddd","ddd","ddd", 'd', Items.emerald});	
		//Iron Block to Item
		this.addShapelessRecipe(new ItemStack(Items.iron_ingot,9), new Object [] {Blocks.iron_block});
		//Item to block
		this.addRecipe(new ItemStack(Blocks.iron_block), new Object [] {"ddd","ddd","ddd", 'd', Items.iron_ingot});	
		//Coal to Coal block
		this.addRecipe(new ItemStack(Blocks.coal_block), new Object [] {"ccc","ccc","ccc",'c', Items.coal});
		//Coal Block to Coal
		this.addShapelessRecipe(new ItemStack(Items.coal, 9), new Object [] {Blocks.coal_block});	
		//Charcoal to Coal block
		this.addRecipe(new ItemStack(Blocks.coal_block), new Object [] {"ccc","ccc","ccc",'c', new ItemStack(Items.coal, 1, 1)});	
		//Wool to string
		this.addShapelessRecipe(new ItemStack(Items.string,4), new Object [] {Blocks.wool});
		//String to Wool
		this.addRecipe(new ItemStack(Blocks.wool), new Object[] {"ss","ss",'s', Items.string});
		//Flint and Steel
		this.addShapelessRecipe(new ItemStack(Items.flint_and_steel), new ItemStack(Items.flint), new ItemStack(Items.iron_ingot));
		
		
	//EXPLOITS	
		//Blaze Rod exploit
		this.addRecipe(new ItemStack(Items.blaze_rod,2), new Object [] {"bbb","bbb","bbb",'b', Items.blaze_powder});	
		//Rotten Flesh to Zombie Head
		this.addRecipe(new ItemStack(Items.skull,1,2), new Object [] {"rrr","rrr","rrr",'r', Items.rotten_flesh});	
		//Synthetic Gold
		this.addRecipe(new ItemStack(OPWeapons.syntheticGold,1), new Object[] {"ppp","pip","ppp",'p',OPWeapons.goldParticle, 'i',Items.iron_ingot});
		//Gold
		this.addRecipe(new ItemStack(Items.gold_ingot,64), new Object[] {"sss","sis","sss",'s',OPWeapons.syntheticGold,'i',Items.iron_ingot});
		
		
		
		
		
        
    		Collections.sort(this.recipes, new opcraftingstationrecipesorter(this));
    }

    public opcraftingstationShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
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

        opcraftingstationShapedRecipes shapedrecipes = new opcraftingstationShapedRecipes(j, k, aitemstack, par1ItemStack);
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
        return  this.recipes;
    }

}