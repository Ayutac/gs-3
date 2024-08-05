package org.abos.mc.gs.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsPlacedFeatures {

    ResourceKey<PlacedFeature> HUGE_PINK_BONNET = register("huge_pink_bonnet");
    ResourceKey<PlacedFeature> HUGE_LAPIS_DECEIVER = register("huge_lapis_deceiver");
    ResourceKey<PlacedFeature> HUGE_MOREL = register("huge_morel");
    ResourceKey<PlacedFeature> HUGE_VIERTOUW_MUSHROOM = register("huge_viertouw_mushroom");

    static ResourceKey<PlacedFeature> register(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, id));
    }
}
