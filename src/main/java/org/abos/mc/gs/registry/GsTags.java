package org.abos.mc.gs.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsTags {

    TagKey<Item> GNOME_TOOLS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome_tools"));

}
