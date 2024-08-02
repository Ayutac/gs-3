package org.abos.mc.gs.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsConfiguredFeatures {

    ResourceKey<ConfiguredFeature<?, ?>> HUGE_PINK_BONNET = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "huge_pink_bonnet"));
}
