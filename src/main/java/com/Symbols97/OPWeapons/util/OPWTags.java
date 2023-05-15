package com.Symbols97.OPWeapons.util;


import com.Symbols97.OPWeapons.OPWeapons;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class OPWTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_OP_TOOL = tag("needs_op_tool");
        
        public static final TagKey<Block> NEEDS_LOST_TOOL = tag("needs_lost_tool");

      
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(OPWeapons.MOD_ID, name));
        }

//        private static TagKey<Block> forgeTag(String name) {
//            return BlockTags.create(new ResourceLocation("forge", name));
//        }
    }

    public static class Items {

    	
    	public static final TagKey<Item> IS_TIER1 = tag("is_tier1");
    	public static final TagKey<Item> IS_TIER2 = tag("is_tier2");
    	public static final TagKey<Item> IS_TIER3 = tag("is_tier3");
    	public static final TagKey<Item> IS_TIER4 = tag("is_tier4");
    	
    	
    	public static final TagKey<Item> IS_OPFURNACEFUEL = tag("is_opfurnacefuel");
    	public static final TagKey<Item> IS_DEMONFURNACEFUEL = tag("is_demonfurnacefuel");
    	public static final TagKey<Item> IS_FCFUEL = tag("is_fcfuel");
    	
    	public static final TagKey<Item> STEEL = forgeTag("ingots/steel");
    	
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(OPWeapons.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}