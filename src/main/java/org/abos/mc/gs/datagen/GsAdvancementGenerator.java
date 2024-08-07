package org.abos.mc.gs.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.registry.GsBiomes;
import org.abos.mc.gs.registry.GsBlocks;
import org.abos.mc.gs.registry.GsDimensions;

import java.util.function.Consumer;

public class GsAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
        final AdvancementHolder mushroom = Advancement.Builder.advancement()
                .display(Items.RED_MUSHROOM_BLOCK,
                        Component.translatable("advancements.gnome_supremacy.mushroom.title"),
                        Component.translatable("advancements.gnome_supremacy.mushroom.description"),
                        ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "textures/block/pink_viertouw_mushroom_block.png"),
                        AdvancementType.TASK,
                        true, false, false)
                .addCriterion("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(Items.RED_MUSHROOM_BLOCK))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "mushroom"), existingFileHelper);
        final AdvancementHolder gnomeHouseTier1 = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_HOUSE_TIER1,
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier1.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier1.description"),
                        null,
                        AdvancementType.TASK,
                        true, false, false)
                .parent(mushroom)
                .addCriterion("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(GsBlocks.GNOME_HOUSE_TIER1))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_house_tier1"), existingFileHelper);
        final AdvancementHolder gnomeHouseTier2 = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_HOUSE_TIER2,
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier2.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier2.description"),
                        null,
                        AdvancementType.TASK,
                        true, false, false)
                .parent(gnomeHouseTier1)
                .addCriterion("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(GsBlocks.GNOME_HOUSE_TIER2))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_house_tier2"), existingFileHelper);
        final AdvancementHolder gnomeHouseTier3 = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_HOUSE_TIER3,
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier3.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier3.description"),
                        null,
                        AdvancementType.GOAL,
                        true, false, false)
                .parent(gnomeHouseTier2)
                .addCriterion("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(GsBlocks.GNOME_HOUSE_TIER3))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_house_tier3"), existingFileHelper);
        final AdvancementHolder gnomeDimension = Advancement.Builder.advancement()
                .display(Items.ENDER_PEARL,
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension.description"),
                        null,
                        AdvancementType.TASK,
                        true, false, false)
                .parent(gnomeHouseTier1)
                .addCriterion("entered_dimension", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(GsDimensions.GNOME_DIMENSION))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_dimension"), existingFileHelper);
        final AdvancementHolder gnomeDimensionBack = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_TELEPORTER,
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension_back.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension_back.description"),
                        null,
                        AdvancementType.GOAL,
                        true, false, false)
                .parent(gnomeDimension)
                .addCriterion("entered_dimension", ChangeDimensionTrigger.TriggerInstance.changedDimension(GsDimensions.GNOME_DIMENSION, Level.OVERWORLD))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_dimension_back"), existingFileHelper);
        final var biomeGetter = provider.lookupOrThrow(Registries.BIOME);
        final AdvancementHolder gnomeDimensionBiomes = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_TELEPORTER,
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension_biomes.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension_biomes.description"),
                        null,
                        AdvancementType.GOAL,
                        true, false, false)
                .parent(gnomeDimension)
                .addCriterion("entered_birch", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeGetter.getOrThrow(GsBiomes.ENORMOUS_BIRCH_FOREST))))
                .addCriterion("entered_dark_oak", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeGetter.getOrThrow(GsBiomes.ENORMOUS_DARK_OAK_FOREST))))
                .addCriterion("entered_oak", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeGetter.getOrThrow(GsBiomes.ENORMOUS_OAK_FOREST))))
                .addCriterion("entered_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeGetter.getOrThrow(GsBiomes.ENORMOUS_TAIGA_FOREST))))
                .addCriterion("entered_mushroom_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeGetter.getOrThrow(GsBiomes.MUSHROOM_FIELDS))))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_dimension_biomes"), existingFileHelper);
    }
}
