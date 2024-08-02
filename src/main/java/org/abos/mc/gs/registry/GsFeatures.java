package org.abos.mc.gs.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.worldgen.HugePinkBonnetFeature;

public interface GsFeatures {

    DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.FEATURE, GnomeSupremacy.MODID);

    DeferredHolder<Feature<?>, HugePinkBonnetFeature> HUGE_PINK_BONNET = REGISTER.register("huge_pink_bonnet", () -> new HugePinkBonnetFeature(HugeMushroomFeatureConfiguration.CODEC));

}
