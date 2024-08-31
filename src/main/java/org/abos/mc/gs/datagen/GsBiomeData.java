package org.abos.mc.gs.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.abos.mc.gs.registry.GsBiomes;
import org.abos.mc.gs.registry.GsPlacedFeatures;

public final class GsBiomeData {

    private GsBiomeData() {
        // No instantiation
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        context.register(GsBiomes.ENORMOUS_BIRCH_FOREST, enormousBirchForest(context));
        context.register(GsBiomes.ENORMOUS_DARK_OAK_FOREST, enormousDarkOakForest(context));
        context.register(GsBiomes.ENORMOUS_OAK_FOREST, enormousOakForest(context));
        context.register(GsBiomes.ENORMOUS_TAIGA, enormousTaiga(context));
        context.register(GsBiomes.MUSHROOM_FIELDS, mushroomFields(context));
    }

    public static Biome enormousBirchForest(BootstrapContext<Biome> context) {
        final Biome.BiomeBuilder builder = new Biome.BiomeBuilder();
        builder.downfall(0.6f);
        builder.temperature(0.6f);
        builder.hasPrecipitation(true);
        final BiomeSpecialEffects.Builder effectBuilder = new BiomeSpecialEffects.Builder();
        effectBuilder.skyColor(8037887);
        effectBuilder.fogColor(12638463);
        effectBuilder.waterColor(4159204);
        effectBuilder.waterFogColor(329011);
        effectBuilder.ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CAVE, 6000, 8, 2.0));
        effectBuilder.backgroundMusic(new Music(SoundEvents.MUSIC_BIOME_FOREST, 12_000, 24_000, false));
        builder.specialEffects(effectBuilder.build());
        final BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        addCommonFeatures(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FOREST_FLOWERS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GsPlacedFeatures.ENORMOUS_BIRCH);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_DEFAULT);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_FOREST);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_NORMAL);
        builder.generationSettings(genBuilder.build());
        MobSpawnSettings.Builder monBuilder = new MobSpawnSettings.Builder();
        addCommonMobs(monBuilder);
        builder.mobSpawnSettings(monBuilder.build());
        return builder.build();
    }

    public static Biome enormousDarkOakForest(BootstrapContext<Biome> context) {
        final Biome.BiomeBuilder builder = new Biome.BiomeBuilder();
        builder.downfall(0.8f);
        builder.temperature(0.7f);
        builder.hasPrecipitation(true);
        final BiomeSpecialEffects.Builder effectBuilder = new BiomeSpecialEffects.Builder();
        effectBuilder.skyColor(7972607);
        effectBuilder.fogColor(12638463);
        effectBuilder.waterColor(4159204);
        effectBuilder.waterFogColor(329011);
        effectBuilder.grassColorModifier(BiomeSpecialEffects.GrassColorModifier.DARK_FOREST);
        effectBuilder.ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CAVE, 6000, 8, 2.0));
        effectBuilder.backgroundMusic(new Music(SoundEvents.MUSIC_BIOME_FOREST, 12_000, 24_000, false));
        builder.specialEffects(effectBuilder.build());
        final BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        addCommonFeatures(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FOREST_FLOWERS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.DARK_FOREST_VEGETATION);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_DEFAULT);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_FOREST);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_NORMAL);
        builder.generationSettings(genBuilder.build());
        MobSpawnSettings.Builder monBuilder = new MobSpawnSettings.Builder();
        addCommonMobs(monBuilder);
        builder.mobSpawnSettings(monBuilder.build());
        return builder.build();
    }

    public static Biome enormousOakForest(BootstrapContext<Biome> context) {
        final Biome.BiomeBuilder builder = new Biome.BiomeBuilder();
        builder.downfall(0.8f);
        builder.temperature(0.7f);
        builder.hasPrecipitation(true);
        final BiomeSpecialEffects.Builder effectBuilder = new BiomeSpecialEffects.Builder();
        effectBuilder.skyColor(7972607);
        effectBuilder.fogColor(12638463);
        effectBuilder.waterColor(4159204);
        effectBuilder.waterFogColor(329011);
        effectBuilder.grassColorModifier(BiomeSpecialEffects.GrassColorModifier.DARK_FOREST);
        effectBuilder.ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CAVE, 6000, 8, 2.0));
        effectBuilder.backgroundMusic(new Music(SoundEvents.MUSIC_BIOME_FOREST, 12_000, 24_000, false));
        builder.specialEffects(effectBuilder.build());
        final BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        addCommonFeatures(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FOREST_FLOWERS);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GsPlacedFeatures.ENORMOUS_OAK);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_DEFAULT);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_FOREST);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_NORMAL);
        builder.generationSettings(genBuilder.build());
        MobSpawnSettings.Builder monBuilder = new MobSpawnSettings.Builder();
        addCommonMobs(monBuilder);
        builder.mobSpawnSettings(monBuilder.build());
        return builder.build();
    }

    public static Biome enormousTaiga(BootstrapContext<Biome> context) {
        final Biome.BiomeBuilder builder = new Biome.BiomeBuilder();
        builder.downfall(0.8f);
        builder.temperature(0.25f);
        builder.hasPrecipitation(true);
        final BiomeSpecialEffects.Builder effectBuilder = new BiomeSpecialEffects.Builder();
        effectBuilder.skyColor(8233983);
        effectBuilder.fogColor(12638463);
        effectBuilder.waterColor(4159204);
        effectBuilder.waterFogColor(329011);
        effectBuilder.ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CAVE, 6000, 8, 2.0));
        builder.specialEffects(effectBuilder.build());
        final BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        addCommonFeatures(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_LARGE_FERN);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GsPlacedFeatures.ENORMOUS_SPRUCE);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_DEFAULT);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_TAIGA_2);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_TAIGA);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_TAIGA);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_BERRY_COMMON);
        builder.generationSettings(genBuilder.build());
        MobSpawnSettings.Builder monBuilder = new MobSpawnSettings.Builder();
        addCommonMobs(monBuilder);
        builder.mobSpawnSettings(monBuilder.build());
        return builder.build();
    }

    public static Biome mushroomFields(BootstrapContext<Biome> context) {
        final Biome.BiomeBuilder builder = new Biome.BiomeBuilder();
        builder.downfall(1.0f);
        builder.temperature(0.9f);
        builder.hasPrecipitation(true);
        final BiomeSpecialEffects.Builder effectBuilder = new BiomeSpecialEffects.Builder();
        effectBuilder.skyColor(7842047);
        effectBuilder.fogColor(12638463);
        effectBuilder.waterColor(4159204);
        effectBuilder.waterFogColor(329011);
        effectBuilder.ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_CAVE, 6000, 8, 2.0));
        builder.specialEffects(effectBuilder.build());
        final BiomeGenerationSettings.Builder genBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        addCommonFeatures(genBuilder);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.MUSHROOM_ISLAND_VEGETATION);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_TAIGA);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_TAIGA);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GsPlacedFeatures.HUGE_PINK_BONNET);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GsPlacedFeatures.HUGE_LAPIS_DECEIVER);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GsPlacedFeatures.HUGE_MOREL);
        genBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, GsPlacedFeatures.HUGE_VIERTOUW_MUSHROOM);
        builder.generationSettings(genBuilder.build());
        MobSpawnSettings.Builder monBuilder = new MobSpawnSettings.Builder();
        addCommonMobs(monBuilder);
        builder.mobSpawnSettings(monBuilder.build());
        return builder.build();
    }

    public static void addCommonFeatures(BiomeGenerationSettings.Builder builder) {
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_GRAVEL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_SAND);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_GRAVEL);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CavePlacements.UNDERWATER_MAGMA);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CavePlacements.GLOW_LICHEN);
        builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        builder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, MiscOverworldPlacements.FREEZE_TOP_LAYER);
    }

    public static void addCommonMobs(MobSpawnSettings.Builder builder) {
        builder.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.BAT, 10, 8, 8));
        builder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 10, 4, 6));
    }

}
