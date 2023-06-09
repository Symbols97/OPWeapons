package com.Symbols97.OPWeapons.recipe.opfurnace;

import com.Symbols97.OPWeapons.OPWeapons;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class OPFurnaceRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public OPFurnaceRecipe(ResourceLocation id, ItemStack output,
                                   NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
    	if(pLevel.isClientSide()) {
    		return false;
    	}
        return recipeItems.get(0).test(pContainer.getItem(0));
    }

    @Override
	public NonNullList<Ingredient> getIngredients() {
		// TODO Auto-generated method stub
		return recipeItems;
	}

    
    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
    	return this.getResultItem().copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<OPFurnaceRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "op_furnace";
    }

    public static class Serializer implements RecipeSerializer<OPFurnaceRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(OPWeapons.MOD_ID,"op_furnace");

        @Override
        public OPFurnaceRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new OPFurnaceRecipe(id, output, inputs);
        }

        @Override
        public OPFurnaceRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new OPFurnaceRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, OPFurnaceRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }

//        @Override
//        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
//            return INSTANCE;
//        }
//
//        @Nullable
//        @Override
//        public ResourceLocation getRegistryName() {
//            return ID;
//        }
//
//        @Override
//        public Class<RecipeSerializer<?>> getRegistryType() {
//            return Serializer.castClass(RecipeSerializer.class);
//        }

//      @SuppressWarnings("unchecked") // Need this wrapper, because generics
//      private static <G> Class<G> castClass(Class<?> cls) {
//          return (Class<G>)cls;
//      }

    }
}
