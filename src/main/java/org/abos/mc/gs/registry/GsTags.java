package org.abos.mc.gs.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsTags {

    TagKey<Item> GNOME_TOOLS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_tools"));
    TagKey<Item> GNOME_TIER1_FOOD = ItemTags.create(ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_tier1_food"));
    TagKey<Item> GNOME_TIER2_FOOD = ItemTags.create(ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_tier2_food"));
    TagKey<Item> GNOME_TIER3_FOOD = ItemTags.create(ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_tier3_food"));
    TagKey<Block> TREE_MUSHROOM_PLANTABLE_ON = BlockTags.create(ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "tree_mushroom_plantable_on"));

}
