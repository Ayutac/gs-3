package org.abos.mc.gs.util;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import org.abos.mc.gs.registry.GsTags;

import java.util.List;

public final class TagCache {

    private static List<Holder<Item>> gnomeTools = null;
    private static List<Holder<Item>> gnomeFoodTier1 = null;
    private static List<Holder<Item>> gnomeFoodTier2 = null;
    private static List<Holder<Item>> gnomeFoodTier3 = null;

    public static List<Holder<Item>> getGnomeTools() {
        if (gnomeTools == null) {
            gnomeTools = List.copyOf(BuiltInRegistries.ITEM.getOrCreateTag(GsTags.GNOME_TOOLS).stream().toList());
        }
        return gnomeTools;
    }

    public static List<Holder<Item>> getGnomeFoodTier1() {
        if (gnomeFoodTier1 == null) {
            gnomeFoodTier1 = List.copyOf(BuiltInRegistries.ITEM.getOrCreateTag(GsTags.GNOME_TIER1_FOOD).stream().toList());
        }
        return gnomeFoodTier1;
    }

    public static List<Holder<Item>> getGnomeFoodTier2() {
        if (gnomeFoodTier2 == null) {
            gnomeFoodTier2 = List.copyOf(BuiltInRegistries.ITEM.getOrCreateTag(GsTags.GNOME_TIER2_FOOD).stream().toList());
        }
        return gnomeFoodTier2;
    }

    public static List<Holder<Item>> getGnomeFoodTier3() {
        if (gnomeFoodTier3 == null) {
            gnomeFoodTier3 = List.copyOf(BuiltInRegistries.ITEM.getOrCreateTag(GsTags.GNOME_TIER3_FOOD).stream().toList());
        }
        return gnomeFoodTier3;
    }

    public static void invalidate() {
        gnomeTools = null;
        gnomeFoodTier1 = null;
        gnomeFoodTier2 = null;
        gnomeFoodTier3 = null;
    }

}
