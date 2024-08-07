package org.abos.mc.gs.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsBiomes {
    ResourceKey<Biome> ENORMOUS_BIRCH_FOREST = register("enormous_birch_forest");
    ResourceKey<Biome> ENORMOUS_DARK_OAK_FOREST = register("enormous_dark_oak_forest");
    ResourceKey<Biome> ENORMOUS_OAK_FOREST = register("enormous_oak_forest");
    ResourceKey<Biome> ENORMOUS_TAIGA_FOREST = register("enormous_taiga_forest");
    ResourceKey<Biome> MUSHROOM_FIELDS = register("mushroom_fields");

    static ResourceKey<Biome> register(String id) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, id));
    }
}
