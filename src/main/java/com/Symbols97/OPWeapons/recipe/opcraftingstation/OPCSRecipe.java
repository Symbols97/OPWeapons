package com.Symbols97.OPWeapons.recipe.opcraftingstation;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jetbrains.annotations.Nullable;

import com.Symbols97.OPWeapons.OPWeapons;
import com.Symbols97.OPWeapons.screen.opcraftingstation.OPCraftingStationMenu;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class OPCSRecipe implements Recipe<CraftingContainer> {

	public final int width;
	public final int height;
	public final NonNullList<Ingredient> recipeItems;
	final ItemStack result;
	private final ResourceLocation id;
	final String group;

	public OPCSRecipe(ResourceLocation id, String group, int width, int height,
			NonNullList<Ingredient> items, ItemStack result) {
		this.id = id;
		this.group = group;
		this.width = width;
		this.height = height;
		this.recipeItems = items;
		this.result = result;
	}

	@Override
	public boolean canCraftInDimensions(int p_44161_, int p_44162_) {
		return true;
	}

	public boolean matches(CraftingContainer container, Level level) {
		for (int i = 0; i <= container.getWidth() - this.width; ++i) {
			for (int j = 0; j <= container.getHeight() - this.height; ++j) {
				if (this.matches(container, i, j, true)) {
					return true;
				}

				if (this.matches(container, i, j, false)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean matches(CraftingContainer container, int intX, int intY, boolean bool) {
		for (int i = 0; i < container.getWidth(); ++i) {
			for (int j = 0; j < container.getHeight(); ++j) {
				int k = i - intX;
				int l = j - intY;
				Ingredient ingredient = Ingredient.EMPTY;
				if (k >= 0 && l >= 0 && k < this.width && l < this.height) {
					if (bool) {
						ingredient = this.recipeItems.get(this.width - k - 1 + l * this.width);
					} else {
						ingredient = this.recipeItems.get(k + l * this.width);
					}
				}

				if (!ingredient.test(container.getItem(i + j * container.getWidth()))) {
					return false;
				}
			}
		}

		return true;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(CraftingContainer container) {
		return this.getResultItem().copy();
	}

	@Override
	public ItemStack getResultItem() {
		return result.copy();
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public String getGroup() {
		return this.group;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	public static class Type implements RecipeType<OPCSRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "opcraftingstation";
	}

	static NonNullList<Ingredient> dissolvePattern(String[] name, Map<String, Ingredient> map, int intX,
			int intY) {
		NonNullList<Ingredient> nonnulllist = NonNullList.withSize(intX * intY, Ingredient.EMPTY);
		Set<String> set = Sets.newHashSet(map.keySet());
		set.remove(" ");

		for (int i = 0; i < name.length; ++i) {
			for (int j = 0; j < name[i].length(); ++j) {
				String s = name[i].substring(j, j + 1);
				Ingredient ingredient = map.get(s);
				if (ingredient == null) {
					throw new JsonSyntaxException(
							"Pattern references symbol '" + s + "' but it's not defined in the key");
				}

				set.remove(s);
				nonnulllist.set(j + intX * i, ingredient);
			}
		}

		if (!set.isEmpty()) {
			throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + set);
		} else {
			return nonnulllist;
		}
	}

	@VisibleForTesting
	static String[] shrink(String... name) {
		int i = Integer.MAX_VALUE;
		int j = 0;
		int k = 0;
		int l = 0;

		for (int i1 = 0; i1 < name.length; ++i1) {
			String s = name[i1];
			i = Math.min(i, firstNonSpace(s));
			int j1 = lastNonSpace(s);
			j = Math.max(j, j1);
			if (j1 < 0) {
				if (k == i1) {
					++k;
				}

				++l;
			} else {
				l = 0;
			}
		}

		if (name.length == l) {
			return new String[0];
		} else {
			String[] astring = new String[name.length - l - k];

			for (int k1 = 0; k1 < astring.length; ++k1) {
				astring[k1] = name[k1 + k].substring(i, j + 1);
			}

			return astring;
		}
	}

	@Override
	public boolean isIncomplete() {
		NonNullList<Ingredient> nonnulllist = this.getIngredients();
		return nonnulllist.isEmpty() || nonnulllist.stream().filter((p_151277_) -> {
			return !p_151277_.isEmpty();
		}).anyMatch((p_151273_) -> {
			return net.minecraftforge.common.ForgeHooks.hasNoElements(p_151273_);
		});
	}

	private static int firstNonSpace(String name) {
		int i;
		for (i = 0; i < name.length() && name.charAt(i) == ' '; ++i) {
		}

		return i;
	}

	private static int lastNonSpace(String name) {
		int i;
		for (i = name.length() - 1; i >= 0 && name.charAt(i) == ' '; --i) {
		}

		return i;
	}

	static String[] patternFromJson(JsonArray array) {
		String[] astring = new String[array.size()];
		if (astring.length > OPCraftingStationMenu.height) {
			throw new JsonSyntaxException(
					"Invalid pattern: too many rows, " + OPCraftingStationMenu.height + " is maximum");
		} else if (astring.length == 0) {
			throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
		} else {
			for (int i = 0; i < astring.length; ++i) {
				String s = GsonHelper.convertToString(array.get(i), "pattern[" + i + "]");
				if (s.length() > OPCraftingStationMenu.width) {
					throw new JsonSyntaxException(
							"Invalid pattern: too many columns, " + OPCraftingStationMenu.width + " is maximum");
				}

				if (i > 0 && astring[0].length() != s.length()) {
					throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
				}

				astring[i] = s;
			}

			return astring;
		}
	}

	static Map<String, Ingredient> keyFromJson(JsonObject object) {
		Map<String, Ingredient> map = Maps.newHashMap();

		for (Entry<String, JsonElement> entry : object.entrySet()) {
			if (entry.getKey().length() != 1) {
				throw new JsonSyntaxException("Invalid key entry: '" + (String) entry.getKey()
						+ "' is an invalid symbol (must be 1 character only).");
			}

			if (" ".equals(entry.getKey())) {
				throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
			}

			map.put(entry.getKey(), Ingredient.fromJson(entry.getValue()));
		}

		map.put(" ", Ingredient.EMPTY);
		return map;
	}

	public static ItemStack itemStackFromJson(JsonObject object) {
		return net.minecraftforge.common.crafting.CraftingHelper.getItemStack(object, true, true);
	}

	@SuppressWarnings("deprecation")
	public static Item itemFromJson(JsonObject object) {
		String s = GsonHelper.getAsString(object, "item");
		Item item = Registry.ITEM.getOptional(new ResourceLocation(s)).orElseThrow(() -> {
			return new JsonSyntaxException("Unknown item '" + s + "'");
		});
		if (item == Items.AIR) {
			throw new JsonSyntaxException("Invalid item: " + s);
		} else {
			return item;
		}
	}

	public static class Serializer implements RecipeSerializer<OPCSRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation(OPWeapons.MOD_ID, "opcraftingstation");

		@Override
		public OPCSRecipe fromJson(ResourceLocation id, JsonObject json) {
			String s = GsonHelper.getAsString(json, "group", "");
			Map<String, Ingredient> ingredientMap = OPCSRecipe
					.keyFromJson(GsonHelper.getAsJsonObject(json, "key"));
			String[] patternArray = OPCSRecipe
					.shrink(patternFromJson(GsonHelper.getAsJsonArray(json, "pattern")));
			int i = patternArray[0].length();
			int j = patternArray.length;
			NonNullList<Ingredient> dissolvePattern = OPCSRecipe.dissolvePattern(patternArray, ingredientMap, i, j);
			ItemStack output = OPCSRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));

			return new OPCSRecipe(id, s, i, j, dissolvePattern, output);
		}

		@Override
		public OPCSRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			int i = buf.readVarInt();
			int j = buf.readVarInt();
			String s = buf.readUtf();
			NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i * j, Ingredient.EMPTY);

			for (int k = 0; k < nonnulllist.size(); ++k) {
				nonnulllist.set(k, Ingredient.fromNetwork(buf));
			}

			ItemStack itemstack = buf.readItem();
			return new OPCSRecipe(id, s, i, j, nonnulllist, itemstack);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, OPCSRecipe recipe) {
			buf.writeVarInt(recipe.width);
			buf.writeVarInt(recipe.height);
			buf.writeUtf(recipe.group);

			for (Ingredient ingredient : recipe.recipeItems) {
				ingredient.toNetwork(buf);
			}

			buf.writeItem(recipe.result);
		}

		@Override
		public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
			return INSTANCE;
		}

		@Nullable
		@Override
		public ResourceLocation getRegistryName() {
			return ID;
		}

		@Override
		public Class<RecipeSerializer<?>> getRegistryType() {
			return Serializer.castClass(RecipeSerializer.class);
		}

		@SuppressWarnings("unchecked") // Need this wrapper, because generics
		private static <G> Class<G> castClass(Class<?> cls) {
			return (Class<G>) cls;
		}
		
	
	}
}