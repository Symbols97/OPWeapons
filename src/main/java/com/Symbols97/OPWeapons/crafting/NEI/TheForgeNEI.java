package com.Symbols97.OPWeapons.crafting.NEI;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.Symbols97.OPWeapons.crafting.TheForge.theforgeShapedRecipes;
import com.Symbols97.OPWeapons.crafting.TheForge.theforgecraftingmanager;
import com.Symbols97.OPWeapons.gui.GUITheForge;

import codechicken.core.ReflectionManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.RecipeInfo;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class TheForgeNEI extends TemplateRecipeHandler
{
    public class CachedShapedRecipe extends CachedRecipe
    {
        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;

        public CachedShapedRecipe(int width, int height, Object[] items, ItemStack out) {
        	result = new PositionedStack(out, 119, 23);
            ingredients = new ArrayList<PositionedStack>();
            setIngredients(width, height, items);
        }

        public CachedShapedRecipe(theforgeShapedRecipes irecipe) {
            this(irecipe.recipeWidth, irecipe.recipeHeight, irecipe.recipeItems, irecipe.getRecipeOutput());
        }

        /**
         * @param width
         * @param height
         * @param items  an ItemStack[] or ItemStack[][]
         */
        public void setIngredients(int width, int height, Object[] items) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (items[y * width + x] == null)
                        continue;

                    PositionedStack stack = new PositionedStack(items[y * width + x], 25 + x * 18, 6 + y * 18, false);
                    stack.setMaxSize(1);
                    ingredients.add(stack);
                }
            }
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 20, ingredients);
        }

        public PositionedStack getResult() {
            return result;
        }

        public void computeVisuals() {
            for (PositionedStack p : ingredients)
                p.generatePermutations();
        }
    }

    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(84, 23, 24, 18), "crafting"));
    }

    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GUITheForge.class;
    }

    @Override
    public String getRecipeName() {
        return "The Forge";
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals("crafting") && getClass() == TheForgeNEI.class) {
            for (IRecipe irecipe : (List<IRecipe>) theforgecraftingmanager.getInstance().getRecipeList()) {
                CachedShapedRecipe recipe = null;
                if (irecipe instanceof theforgeShapedRecipes)
                    recipe = new CachedShapedRecipe((theforgeShapedRecipes) irecipe);
                else if (irecipe instanceof ShapedOreRecipe)
                    recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);

                if (recipe == null)
                    continue;

                recipe.computeVisuals();
                arecipes.add(recipe);
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        for (IRecipe irecipe : (List<IRecipe>) theforgecraftingmanager.getInstance().getRecipeList()) {
            if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
                CachedShapedRecipe recipe = null;
                if (irecipe instanceof theforgeShapedRecipes)
                    recipe = new CachedShapedRecipe((theforgeShapedRecipes) irecipe);
                else if (irecipe instanceof ShapedOreRecipe)
                    recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);

                if (recipe == null)
                    continue;

                recipe.computeVisuals();
                arecipes.add(recipe);
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        for (IRecipe irecipe : (List<IRecipe>) theforgecraftingmanager.getInstance().getRecipeList()) {
            CachedShapedRecipe recipe = null;
            if (irecipe instanceof theforgeShapedRecipes)
                recipe = new CachedShapedRecipe((theforgeShapedRecipes) irecipe);
            else if (irecipe instanceof ShapedOreRecipe)
                recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);

            if (recipe == null || !recipe.contains(recipe.ingredients, ingredient.getItem()))
                continue;

            recipe.computeVisuals();
            if (recipe.contains(recipe.ingredients, ingredient)) {
                recipe.setIngredientPermutation(recipe.ingredients, ingredient);
                arecipes.add(recipe);
            }
        }
    }

    public CachedShapedRecipe forgeShapedRecipe(ShapedOreRecipe recipe) {
        int width;
        int height;
        try {
            width = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, recipe, 4);
            height = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, recipe, 5);
        } catch (Exception e) {
            NEIClientConfig.logger.error("Error loading recipe", e);
            return null;
        }

        Object[] items = recipe.getInput();
        for (Object item : items)
            if (item instanceof List && ((List<?>) item).isEmpty())//ore handler, no ores
                return null;

        return new CachedShapedRecipe(width, height, items, recipe.getRecipeOutput());
    }

    @Override
    public String getGuiTexture() {
        return "opweapons:textures/gui/NEI_GUI/theforgegui.png";
    }
    
    public void drawBackground(int recipe) {
    	GL11.glColor4f(1, 1, 1, 1);
    	Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(getGuiTexture()));
    	drawTexturedModalRect(-5, -11, 0, 0, 176, 77);
    	
    }
    
    protected float zLevel;
    public void drawTexturedModalRect(int p_73729_1_, int p_73729_2_, int p_73729_3_, int p_73729_4_, int p_73729_5_, int p_73729_6_)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(p_73729_1_ + 0), (double)(p_73729_2_ + p_73729_6_), (double)this.zLevel, (double)((float)(p_73729_3_ + 0) * f), (double)((float)(p_73729_4_ + p_73729_6_) * f1));
        tessellator.addVertexWithUV((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + p_73729_6_), (double)this.zLevel, (double)((float)(p_73729_3_ + p_73729_5_) * f), (double)((float)(p_73729_4_ + p_73729_6_) * f1));
        tessellator.addVertexWithUV((double)(p_73729_1_ + p_73729_5_), (double)(p_73729_2_ + 0), (double)this.zLevel, (double)((float)(p_73729_3_ + p_73729_5_) * f), (double)((float)(p_73729_4_ + 0) * f1));
        tessellator.addVertexWithUV((double)(p_73729_1_ + 0), (double)(p_73729_2_ + 0), (double)this.zLevel, (double)((float)(p_73729_3_ + 0) * f), (double)((float)(p_73729_4_ + 0) * f1));
        tessellator.draw();
    }
    
    public int recipiesPerPage() {
    	return 2;
    }

    @Override
    public String getOverlayIdentifier() {
        return "crafting";
    }

    public boolean hasOverlay(GuiContainer gui, Container container, int recipe) {
        return super.hasOverlay(gui, container, recipe) ||
                isRecipe2x2(recipe) && RecipeInfo.hasDefaultOverlay(gui, "crafting2x2");
    }

    @Override
    public IRecipeOverlayRenderer getOverlayRenderer(GuiContainer gui, int recipe) {
        IRecipeOverlayRenderer renderer = super.getOverlayRenderer(gui, recipe);
        if (renderer != null)
            return renderer;

        IStackPositioner positioner = RecipeInfo.getStackPositioner(gui, "crafting2x2");
        if (positioner == null)
            return null;
        return new DefaultOverlayRenderer(getIngredientStacks(recipe), positioner);
    }

    @Override
    public IOverlayHandler getOverlayHandler(GuiContainer gui, int recipe) {
        IOverlayHandler handler = super.getOverlayHandler(gui, recipe);
        if (handler != null)
            return handler;

        return RecipeInfo.getOverlayHandler(gui, "crafting2x2");
    }

    public boolean isRecipe2x2(int recipe) {
        for (PositionedStack stack : getIngredientStacks(recipe))
            if (stack.relx > 43 || stack.rely > 24)
                return false;

        return true;
    }
}