package org.abos.mc.gs.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsPlacedFeatures {

    ResourceKey<PlacedFeature> ENORMOUS_BIRCH = register("enormous_birch");
    ResourceKey<PlacedFeature> ENORMOUS_DARK_OAK = register("enormous_dark_oak");
    ResourceKey<PlacedFeature> ENORMOUS_OAK = register("enormous_oak");
    ResourceKey<PlacedFeature> ENORMOUS_SPRUCE = register("enormous_spruce");
    ResourceKey<PlacedFeature> HUGE_PINK_BONNET = register("huge_pink_bonnet");
    ResourceKey<PlacedFeature> HUGE_LAPIS_DECEIVER = register("huge_lapis_deceiver");
    ResourceKey<PlacedFeature> HUGE_MOREL = register("huge_morel");
    ResourceKey<PlacedFeature> HUGE_VIERTOUW_MUSHROOM = register("huge_viertouw_mushroom");
    ResourceKey<PlacedFeature> ORE_COARSE_DIRT = register("ore_coarse_dirt");
    ResourceKey<PlacedFeature> ORE_ROOTED_DIRT = register("ore_rooted_dirt");
    ResourceKey<PlacedFeature> ORE_INFUSED_STONE = register("ore_infused_stone");
    ResourceKey<PlacedFeature> ORE_MITHRALIUM_STONE = register("ore_mithralium_stone");

    static ResourceKey<PlacedFeature> register(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, id));
    }
}
