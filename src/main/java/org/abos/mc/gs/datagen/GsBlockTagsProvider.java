package org.abos.mc.gs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.registry.GsBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GsBlockTagsProvider extends BlockTagsProvider {
    public GsBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GnomeSupremacyMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                GsBlocks.INFUSED_STONE.get(),
                GsBlocks.INFUSED_STONE_STAIRS.get(),
                GsBlocks.INFUSED_STONE_SLAB.get(),
                GsBlocks.INFUSED_STONE_WALL.get(),
                GsBlocks.MITHRALIUM_STONE.get(),
                GsBlocks.MITHRALIUM_STONE_STAIRS.get(),
                GsBlocks.MITHRALIUM_STONE_SLAB.get(),
                GsBlocks.MITHRALIUM_STONE_WALL.get()
        );
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                GsBlocks.GNOME_HOUSE_TIER1.get(),
                GsBlocks.PINK_BONNET.get(),
                GsBlocks.PINK_BONNET_BLOCK.get(),
                GsBlocks.LAPIS_DECEIVER.get(),
                GsBlocks.LAPIS_DECEIVER_BLOCK.get(),
                GsBlocks.MOREL.get(),
                GsBlocks.MOREL_BLOCK.get()
        );
        tag(BlockTags.STAIRS).add(
                GsBlocks.INFUSED_STONE_STAIRS.get(),
                GsBlocks.MITHRALIUM_STONE_STAIRS.get()
        );
        tag(BlockTags.SLABS).add(
                GsBlocks.INFUSED_STONE_SLAB.get(),
                GsBlocks.MITHRALIUM_STONE_SLAB.get()
        );
        tag(BlockTags.WALLS).add(
                GsBlocks.INFUSED_STONE_WALL.get(),
                GsBlocks.MITHRALIUM_STONE_WALL.get()
        );
    }
}
