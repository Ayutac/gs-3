package org.abos.mc.gs.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.abos.mc.gs.GnomeSupremacy;
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
        final AdvancementHolder gnome_house_tier1 = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_HOUSE_TIER1,
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier1.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier1.description"),
                        null,
                        AdvancementType.TASK,
                        true, false, false)
                .parent(mushroom)
                .addCriterion("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(GsBlocks.GNOME_HOUSE_TIER1))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_house_tier1"), existingFileHelper);
        final AdvancementHolder gnome_house_tier2 = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_HOUSE_TIER2,
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier2.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier2.description"),
                        null,
                        AdvancementType.TASK,
                        true, false, false)
                .parent(gnome_house_tier1)
                .addCriterion("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(GsBlocks.GNOME_HOUSE_TIER2))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_house_tier2"), existingFileHelper);
        final AdvancementHolder gnome_house_tier3 = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_HOUSE_TIER3,
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier3.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_house_tier3.description"),
                        null,
                        AdvancementType.GOAL,
                        true, false, false)
                .parent(gnome_house_tier2)
                .addCriterion("has_block", InventoryChangeTrigger.TriggerInstance.hasItems(GsBlocks.GNOME_HOUSE_TIER3))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_house_tier3"), existingFileHelper);
        final AdvancementHolder gnome_dimension = Advancement.Builder.advancement()
                .display(Items.ENDER_PEARL,
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension.description"),
                        null,
                        AdvancementType.TASK,
                        true, false, false)
                .parent(gnome_house_tier1)
                .addCriterion("entered_dimension", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(GsDimensions.GNOME_DIMENSION))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_dimension"), existingFileHelper);
        final AdvancementHolder gnome_dimension_back = Advancement.Builder.advancement()
                .display(GsBlocks.GNOME_TELEPORTER,
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension_back.title"),
                        Component.translatable("advancements.gnome_supremacy.gnome_dimension_back.description"),
                        null,
                        AdvancementType.GOAL,
                        true, false, false)
                .parent(gnome_dimension)
                .addCriterion("entered_dimension", ChangeDimensionTrigger.TriggerInstance.changedDimension(GsDimensions.GNOME_DIMENSION, Level.OVERWORLD))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_dimension_back"), existingFileHelper);
    }
}
