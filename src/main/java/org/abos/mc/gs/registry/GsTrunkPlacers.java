package org.abos.mc.gs.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.worldgen.EnormousTrunkPlacer;

public interface GsTrunkPlacers {

    TrunkPlacerType<EnormousTrunkPlacer> ENORMOUS_TRUNK_PLACER = register("enormous_trunk_placer", EnormousTrunkPlacer.CODEC);

    static <P extends TrunkPlacer> TrunkPlacerType<P> register(String name, MapCodec<P> codec) {
        return Registry.register(BuiltInRegistries.TRUNK_PLACER_TYPE, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, name), new TrunkPlacerType<>(codec));
    }

}
