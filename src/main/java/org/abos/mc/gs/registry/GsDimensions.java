package org.abos.mc.gs.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsDimensions {

    ResourceKey<Level> GNOME_DIMENSION = register("gnome_dimension");

    static ResourceKey<Level> register(String id) {
        return ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, id));
    }

}
