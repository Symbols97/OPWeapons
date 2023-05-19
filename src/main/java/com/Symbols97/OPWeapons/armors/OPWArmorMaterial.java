package com.Symbols97.OPWeapons.armors;

import java.util.function.Supplier;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.items.init.OPWItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

 
@SuppressWarnings("deprecation")
public enum OPWArmorMaterial implements ArmorMaterial {
	//String Name, Durability mult, How Much each armor protects (hp) , Enchant Value, Toughness , KnockBack Resistance
	OP("op", 750, new int[] { 10,10,10,10 }, 400, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> {
		return Ingredient.of(OPWItems.op_gem.get());
	}),
	LOST("lost", 100, new int[] { 10,10,10,10 }, 0, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> {
		return Ingredient.of(OPWItems.op_gem.get());
	}),
	DEMON("demon", 2500, new int[] { 10,10,10,10 }, 0, SoundEvents.ARMOR_EQUIP_DIAMOND, 100.0F, 20.0F, () -> {
		return Ingredient.of();
	}),
	DEMON_SHADED("demon_shaded", 2500, new int[] { 10,10,10,10 }, 0, SoundEvents.ARMOR_EQUIP_DIAMOND, 100.0F, 20.0F, () -> {
		return Ingredient.of();
	}),
	FROST("frost", 2500, new int[] { 10,10,10,10 }, 0, SoundEvents.ARMOR_EQUIP_DIAMOND, 100.0F, 20.0F, () -> {
		return Ingredient.of();
	}),
	REAPER("reaper", 5000, new int[] { 10,10,10,10 }, 0, SoundEvents.ARMOR_EQUIP_DIAMOND, 200.0F, 40.0F, () -> {
		return Ingredient.of();
	});

	private static final int[] HEALTH_PER_SLOT = new int[] { 10, 10, 10, 10 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;

	private OPWArmorMaterial(String p_40474_, int p_40475_, int[] p_40476_, int p_40477_, SoundEvent p_40478_, float p_40479_, float p_40480_, Supplier<Ingredient> p_40481_) {
	      this.name = p_40474_;
	      this.durabilityMultiplier = p_40475_;
	      this.slotProtections = p_40476_;
	      this.enchantmentValue = p_40477_;
	      this.sound = p_40478_;
	      this.toughness = p_40479_;
	      this.knockbackResistance = p_40480_;
	      this.repairIngredient = new LazyLoadedValue<>(p_40481_);
	   }

	public int getDurabilityForSlot(EquipmentSlot p_40484_) {
		return HEALTH_PER_SLOT[p_40484_.getIndex()] * this.durabilityMultiplier;
	}

	public int getDefenseForSlot(EquipmentSlot p_40487_) {
		return this.slotProtections[p_40487_.getIndex()];
	}

	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	public SoundEvent getEquipSound() {
		return this.sound;
	}

	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	public String getName() {
		return OPWeapons.MOD_ID + ":" + this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}