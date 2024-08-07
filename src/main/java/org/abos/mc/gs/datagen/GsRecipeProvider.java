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
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.registry.GsItems;

import java.util.concurrent.CompletableFuture;

public final class GsRecipeProvider extends RecipeProvider {

    private static final String STONECUTTER_STR = "_from_stonecutter";
    private static final String STONECUTTER_VIA_STR = STONECUTTER_STR + "_via_";

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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GsItems.GNOME_HOUSE_TIER2)
                .pattern("EGE")
                .pattern("PHP")
                .pattern("NNN")
                .define('E', Items.EMERALD_BLOCK)
                .define('G', Items.GOLD_BLOCK)
                .define('H', GsItems.GNOME_HOUSE_TIER1)
                .define('N', Items.NETHER_BRICKS)
                .define('P', Items.SEA_LANTERN)
                .unlockedBy("has_house", InventoryChangeTrigger.TriggerInstance.hasItems(GsItems.GNOME_HOUSE_TIER1))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GsItems.GNOME_HOUSE_TIER3)
                .pattern("DND")
                .pattern("EHE")
                .pattern("PPP")
                .define('D', Items.DIAMOND_BLOCK)
                .define('E', Items.END_ROD)
                .define('H', GsItems.GNOME_HOUSE_TIER2)
                .define('N', Items.NETHERITE_INGOT)
                .define('P', Items.PURPUR_BLOCK)
                .unlockedBy("has_house", InventoryChangeTrigger.TriggerInstance.hasItems(GsItems.GNOME_HOUSE_TIER2))
                .save(output);
        stairs(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_STAIRS, output);
        stairsSc(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_STAIRS, output);
        slab(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_SLAB, output);
        slabSc(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_SLAB, output);
        wall(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_WALL, output);
        wallSc(GsItems.INFUSED_STONE, GsItems.INFUSED_STONE_WALL, output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GsItems.POLISHED_INFUSED_STONE)
                .pattern("XX")
                .pattern("XX")
                .define('X', GsItems.INFUSED_STONE)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(GsItems.INFUSED_STONE))
                .save(output);
        blockScVia(GsItems.INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE, output);
        stairs(GsItems.POLISHED_INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_STAIRS, output);
        stairsSc(GsItems.POLISHED_INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_STAIRS, output);
        stairsScVia(GsItems.INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_STAIRS, output);
        slab(GsItems.POLISHED_INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_SLAB, output);
        slabSc(GsItems.POLISHED_INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_SLAB, output);
        slabScVia(GsItems.INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_SLAB, output);
        wall(GsItems.POLISHED_INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_WALL, output);
        wallSc(GsItems.POLISHED_INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_WALL, output);
        wallScVia(GsItems.INFUSED_STONE, GsItems.POLISHED_INFUSED_STONE_WALL, output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GsItems.CHISELED_INFUSED_STONE)
                .pattern("X")
                .pattern("X")
                .define('X', GsItems.POLISHED_INFUSED_STONE_SLAB)
                .unlockedBy("has_slab", InventoryChangeTrigger.TriggerInstance.hasItems(GsItems.POLISHED_INFUSED_STONE))
                .save(output);
        blockScVia(GsItems.INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE, output);
        blockScVia(GsItems.POLISHED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE, output);
        stairs(GsItems.CHISELED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_STAIRS, output);
        stairsSc(GsItems.CHISELED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_STAIRS, output);
        stairsScVia(GsItems.INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_STAIRS, output);
        stairsScVia(GsItems.POLISHED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_STAIRS, output);
        slab(GsItems.CHISELED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_SLAB, output);
        slabSc(GsItems.CHISELED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_SLAB, output);
        slabScVia(GsItems.INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_SLAB, output);
        slabScVia(GsItems.POLISHED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_SLAB, output);
        wall(GsItems.CHISELED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_WALL, output);
        wallSc(GsItems.CHISELED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_WALL, output);
        wallScVia(GsItems.INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_WALL, output);
        wallScVia(GsItems.POLISHED_INFUSED_STONE, GsItems.CHISELED_INFUSED_STONE_WALL, output);
        stairs(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_STAIRS, output);
        stairsSc(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_STAIRS, output);
        slab(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_SLAB, output);
        slabSc(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_SLAB, output);
        wall(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_WALL, output);
        wallSc(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_STONE_WALL, output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GsItems.POLISHED_MITHRALIUM_STONE)
                .pattern("XX")
                .pattern("XX")
                .define('X', GsItems.MITHRALIUM_STONE)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(GsItems.MITHRALIUM_STONE))
                .save(output);
        blockScVia(GsItems.MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE, output);
        stairs(GsItems.POLISHED_MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_STAIRS, output);
        stairsSc(GsItems.POLISHED_MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_STAIRS, output);
        stairsScVia(GsItems.MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_STAIRS, output);
        slab(GsItems.POLISHED_MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_SLAB, output);
        slabSc(GsItems.POLISHED_MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_SLAB, output);
        slabScVia(GsItems.MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_SLAB, output);
        wall(GsItems.POLISHED_MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_WALL, output);
        wallSc(GsItems.POLISHED_MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_WALL, output);
        wallScVia(GsItems.MITHRALIUM_STONE, GsItems.POLISHED_MITHRALIUM_STONE_WALL, output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, GsItems.MITHRALIUM_PILLAR)
                .pattern("X")
                .pattern("X")
                .define('X', GsItems.MITHRALIUM_STONE_SLAB)
                .unlockedBy("has_slab", InventoryChangeTrigger.TriggerInstance.hasItems(GsItems.MITHRALIUM_STONE_SLAB))
                .save(output);
        blockScVia(GsItems.MITHRALIUM_STONE, GsItems.MITHRALIUM_PILLAR, output);
    }

    private void blockScVia(DeferredItem<? extends Item> input, DeferredItem<? extends Item> result, RecipeOutput output) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, result.getId().getPath() + STONECUTTER_VIA_STR + input.getId().getPath()));
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
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, result.getId().getPath() + STONECUTTER_STR));
    }

    private void stairsScVia(DeferredItem<? extends Item> input, DeferredItem<? extends Item> result, RecipeOutput output) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, result.getId().getPath() + STONECUTTER_VIA_STR + input.getId().getPath()));
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
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, result.getId().getPath() + STONECUTTER_STR));
    }

    private void slabScVia(DeferredItem<? extends Item> input, DeferredItem<? extends Item> result, RecipeOutput output) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result, 2)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, result.getId().getPath() + STONECUTTER_VIA_STR + input.getId().getPath()));
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
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, result.getId().getPath() + STONECUTTER_STR));
    }

    private void wallScVia(DeferredItem<? extends Item> input, DeferredItem<? extends Item> result, RecipeOutput output) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), RecipeCategory.BUILDING_BLOCKS, result)
                .unlockedBy("has_stone", InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(output, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, result.getId().getPath() + STONECUTTER_VIA_STR + input.getId().getPath()));
    }
}
