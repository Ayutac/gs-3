package org.abos.mc.gs.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsConfiguredFeatures {

    ResourceKey<ConfiguredFeature<?, ?>> HUGE_PINK_BONNET = register("huge_pink_bonnet");
    ResourceKey<ConfiguredFeature<?, ?>> HUGE_PINK_BONNET_PATCH = register("huge_pink_bonnet_patch");
    ResourceKey<ConfiguredFeature<?, ?>> HUGE_LAPIS_DECEIVER = register("huge_lapis_deceiver");
    ResourceKey<ConfiguredFeature<?, ?>> HUGE_LAPIS_DECEIVER_PATCH = register("huge_lapis_deceiver_patch");
    ResourceKey<ConfiguredFeature<?, ?>> HUGE_MOREL = register("huge_morel");
    ResourceKey<ConfiguredFeature<?, ?>> HUGE_MOREL_PATCH = register("huge_morel_patch");
    ResourceKey<ConfiguredFeature<?, ?>> HUGE_VIERTOUW_MUSHROOM = register("huge_viertouw_mushroom");
    ResourceKey<ConfiguredFeature<?, ?>> HUGE_VIERTOUW_MUSHROOM_PATCH = register("huge_viertouw_mushroom_patch");

    static ResourceKey<ConfiguredFeature<?, ?>> register(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, id));
    }

}
