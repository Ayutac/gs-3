package org.abos.mc.gs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.registry.GsItems;

import java.util.concurrent.CompletableFuture;

public class GsItemTagsProvider extends ItemTagsProvider {
    public GsItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, provider.contentsGetter(), GnomeSupremacyMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.STAIRS).add(
                GsItems.INFUSED_STONE_STAIRS.get(),
                GsItems.MITHRALIUM_STONE_STAIRS.get()
        );
        tag(ItemTags.SLABS).add(
                GsItems.INFUSED_STONE_SLAB.get(),
                GsItems.MITHRALIUM_STONE_SLAB.get()
        );
        tag(ItemTags.WALLS).add(
                GsItems.INFUSED_STONE_WALL.get(),
                GsItems.MITHRALIUM_STONE_WALL.get()
        );
    }
}
