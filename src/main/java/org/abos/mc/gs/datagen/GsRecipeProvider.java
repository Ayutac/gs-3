package org.abos.mc.gs.datagen;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredItem;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.registry.GsItems;

import java.util.concurrent.CompletableFuture;

public class GsRecipeProvider extends RecipeProvider {

    private static final String STONECUTTER_STR = "_from_stonecutter";

    public GsRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GsItems.GNOME_HOUSE_TIER1)
                .pattern("MMM")
                .pattern("WLW")
                .pattern("WWW")
                .define('L', Items.LANTERN)
                .define('M', Items.RED_MUSHROOM_BLOCK)
                .define('W', Items.STRIPPED_SPRUCE_WOOD)
                .unlockedBy("has_mushroom", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_MUSHROOM_BLOCK))
                .save(output);
        stairs(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_STAIRS, output);
        stairsSc(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_STAIRS, output);
        slab(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_SLAB, output);
        slabSc(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_SLAB, output);
        wall(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_WALL, output);
        wallSc(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_WALL, output);
        stairs(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_STAIRS, output);
        stairsSc(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_STAIRS, output);
        slab(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_SLAB, output);
        slabSc(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_SLAB, output);
        wall(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_WALL, output);
        wallSc(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_WALL, output);
    }

    private void stairs(ItemLike input, ItemLike result, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .define('X', input)
                .unlockedBy("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output);
    }

    private void stairsSc(ItemLike input, DeferredItem<? extends Item> result, RecipeOutput output) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacyMod.MODID, result.getId().getPath() + STONECUTTER_STR));
    }

    private void slab(ItemLike input, ItemLike result, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                .pattern("XXX")
                .define('X', input)
                .unlockedBy("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output);
    }

    private void slabSc(ItemLike input, DeferredItem<? extends Item> result, RecipeOutput output) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result, 2)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacyMod.MODID, result.getId().getPath() + STONECUTTER_STR));
    }

    private void wall(ItemLike input, ItemLike result, RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result, 6)
                .pattern("XXX")
                .pattern("XXX")
                .define('X', input)
                .unlockedBy("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output);
    }

    private void wallSc(ItemLike input, DeferredItem<? extends Item> result, RecipeOutput output) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacyMod.MODID, result.getId().getPath() + STONECUTTER_STR));
    }
}
