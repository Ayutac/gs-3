package org.abos.mc.gs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.abos.mc.gs.GnomeSupremacyMod;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = GnomeSupremacyMod.MODID)
public class GsDatagenHandler {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeClient(), new GsLanguageProvider(output));
        generator.addProvider(event.includeClient(), new GsBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new GsItemModelProvider(output, existingFileHelper));
        final BlockTagsProvider gsBlockTagProvider = new GsBlockTagsProvider(output, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), gsBlockTagProvider);
        generator.addProvider(event.includeServer(), new GsItemTagsProvider(output, lookupProvider, gsBlockTagProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new GsRecipeProvider(output, lookupProvider));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(GsBlockLootSubProvider::new, LootContextParamSets.BLOCK)
        ), lookupProvider));
    }
}
