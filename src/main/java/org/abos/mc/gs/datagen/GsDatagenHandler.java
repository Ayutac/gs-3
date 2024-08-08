package org.abos.mc.gs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.abos.mc.gs.GnomeSupremacy;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = GnomeSupremacy.MODID)
public class GsDatagenHandler {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();
        final PackOutput output = generator.getPackOutput();
        final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        final CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeClient(), new GsLanguageProvider(output));
        generator.addProvider(event.includeClient(), new GsBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new GsItemModelProvider(output, existingFileHelper));
        final BlockTagsProvider gsBlockTagProvider = new GsBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), gsBlockTagProvider);
        generator.addProvider(event.includeServer(), new GsItemTagsProvider(output, lookupProvider, gsBlockTagProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new GsRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(GsBlockLootSubProvider::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(GsLootTableSubProvider::new, LootContextParamSets.CHEST)
        ), lookupProvider));
        RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder()
                .add(Registries.BIOME, GsBiomeData::bootstrap);
        DatapackBuiltinEntriesProvider dataPackProvider = generator.addProvider(event.includeServer(),
                new DatapackBuiltinEntriesProvider(output, lookupProvider, registrySetBuilder, Set.of(GnomeSupremacy.MODID)));
        CompletableFuture<HolderLookup.Provider> worldgenProvider = dataPackProvider.getRegistryProvider();
        generator.addProvider(event.includeServer(), new AdvancementProvider(output, worldgenProvider, existingFileHelper, List.of(
                new GsAdvancementGenerator()
        )));
    }

}
