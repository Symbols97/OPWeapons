package com.Symbols97.OPWeapons.datagen.server;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.items.init.OPWItems;
import com.Symbols97.OPWeapons.util.OPWTags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;

public class OPWItemTagsProvider extends ItemTagsProvider {

	public OPWItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
		super(generator, blocks, OPWeapons.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		
		tag(OPWTags.Items.IS_TIER1).add(OPWItems.op_sword.get());
		tag(OPWTags.Items.IS_TIER1).add(OPWItems.op_axe.get());
		tag(OPWTags.Items.IS_TIER1).add(OPWItems.op_pickaxe.get());
		tag(OPWTags.Items.IS_TIER1).add(OPWItems.op_shovel.get());
		tag(OPWTags.Items.IS_TIER1).add(OPWItems.op_hoe.get());
		
		tag(OPWTags.Items.IS_TIER2).add(OPWItems.op_bow.get());
		tag(OPWTags.Items.IS_TIER2).add(OPWItems.lapiz_arrow.get());
		tag(OPWTags.Items.IS_TIER2).add(OPWItems.fire_sword.get());
		tag(OPWTags.Items.IS_TIER2).add(OPWItems.ice_sword.get());
		
		tag(OPWTags.Items.IS_TIER3).add(OPWItems.demon_slayer.get());
		tag(OPWTags.Items.IS_TIER3).add(OPWItems.frost_slayer.get());
		tag(OPWTags.Items.IS_TIER3).add(OPWItems.op_club.get());
		
		tag(OPWTags.Items.IS_TIER4).add(OPWItems.demon_hammer.get());
		tag(OPWTags.Items.IS_TIER4).add(OPWItems.frost_axe.get());
		
		
		tag(OPWTags.Items.IS_OPFURNACEFUEL).add(Items.COPPER_INGOT);
		tag(OPWTags.Items.IS_OPFURNACEFUEL).add(Items.IRON_INGOT);
		tag(OPWTags.Items.IS_OPFURNACEFUEL).add(Items.COPPER_BLOCK);
		tag(OPWTags.Items.IS_OPFURNACEFUEL).add(Items.LAVA_BUCKET);
		tag(OPWTags.Items.IS_OPFURNACEFUEL).add(Items.IRON_BLOCK);
		tag(OPWTags.Items.IS_OPFURNACEFUEL).add(OPWItems.ultimate_nether_star.get());
		tag(OPWTags.Items.IS_OPFURNACEFUEL).add(OPWItems.op_vial.get());
		
		
		tag(OPWTags.Items.IS_DEMONFURNACEFUEL).add(Items.COPPER_INGOT);
		tag(OPWTags.Items.IS_DEMONFURNACEFUEL).add(Items.IRON_INGOT);
		tag(OPWTags.Items.IS_DEMONFURNACEFUEL).add(Items.COPPER_BLOCK);
		tag(OPWTags.Items.IS_DEMONFURNACEFUEL).add(Items.LAVA_BUCKET);
		tag(OPWTags.Items.IS_DEMONFURNACEFUEL).add(Items.IRON_BLOCK);
		tag(OPWTags.Items.IS_DEMONFURNACEFUEL).add(OPWItems.ultimate_nether_star.get());
		tag(OPWTags.Items.IS_DEMONFURNACEFUEL).add(OPWItems.demon_vial.get());
		
		
		
		tag(OPWTags.Items.IS_FCFUEL).add(Items.SNOWBALL);
		tag(OPWTags.Items.IS_FCFUEL).add(Items.SNOW_BLOCK);
		tag(OPWTags.Items.IS_FCFUEL).add(Items.ICE);
		tag(OPWTags.Items.IS_FCFUEL).add(Items.PACKED_ICE);
		tag(OPWTags.Items.IS_FCFUEL).add(OPWItems.ultimate_nether_star.get());
		tag(OPWTags.Items.IS_FCFUEL).add(OPWItems.frost_vial.get());
		
		tag(OPWTags.Items.STEEL).add(OPWItems.steel_ingot.get());
	}

}
