package org.abos.mc.gs.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.worldgen.EnormousTrunkPlacer;

public interface GsTrunkPlacers {

    DeferredRegister<TrunkPlacerType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, GnomeSupremacy.MODID);

    DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<EnormousTrunkPlacer>> ENORMOUS_TRUNK_PLACER = REGISTER.register("enormous_trunk_placer", () -> new TrunkPlacerType<>(EnormousTrunkPlacer.CODEC));

}
