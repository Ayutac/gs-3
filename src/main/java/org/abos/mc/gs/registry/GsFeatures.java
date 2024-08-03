package org.abos.mc.gs.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.worldgen.HugeLapisDeceiverFeature;
import org.abos.mc.gs.worldgen.HugeMorelFeature;
import org.abos.mc.gs.worldgen.HugePinkBonnetFeature;
import org.abos.mc.gs.worldgen.HugeViertouwMushroomFeature;

public interface GsFeatures {

    DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.FEATURE, GnomeSupremacy.MODID);

    DeferredHolder<Feature<?>, HugePinkBonnetFeature> HUGE_PINK_BONNET = REGISTER.register("huge_pink_bonnet", () -> new HugePinkBonnetFeature(HugeMushroomFeatureConfiguration.CODEC));
    DeferredHolder<Feature<?>, HugeLapisDeceiverFeature> HUGE_LAPIS_DECEIVER = REGISTER.register("huge_lapis_deceiver", () -> new HugeLapisDeceiverFeature(HugeMushroomFeatureConfiguration.CODEC));
    DeferredHolder<Feature<?>, HugeMorelFeature> HUGE_MOREL = REGISTER.register("huge_morel", () -> new HugeMorelFeature(HugeMushroomFeatureConfiguration.CODEC));
    DeferredHolder<Feature<?>, HugeViertouwMushroomFeature> HUGE_VIERTOUW_MUSHROOM = REGISTER.register("huge_viertouw_mushroom", () -> new HugeViertouwMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));

}
