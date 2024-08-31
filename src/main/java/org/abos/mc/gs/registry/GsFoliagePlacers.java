package org.abos.mc.gs.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.worldgen.EnormousSpruceFoliagePlacer;

public interface GsFoliagePlacers {

    DeferredRegister<FoliagePlacerType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, GnomeSupremacy.MODID);

    DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<EnormousSpruceFoliagePlacer>> ENORMOUS_SPRUCE_FOLIAGE_PLACER = REGISTER.register("enormous_spruce_foliage_placer", () -> new FoliagePlacerType<>(EnormousSpruceFoliagePlacer.CODEC));

}
