package org.abos.mc.gs.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.abos.mc.gs.registry.GsBlocks;
import org.abos.mc.gs.registry.GsItems;

import java.util.Set;

public class GsBlockLootSubProvider extends BlockLootSubProvider {
    protected GsBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
    }

    @Override
    protected void generate() {
        dropSelf(GsBlocks.GNOME_HOUSE_TIER1.get());
        dropSelf(GsBlocks.GNOME_HOUSE_TIER2.get());
        dropSelf(GsBlocks.GNOME_HOUSE_TIER3.get());
        dropSelf(GsBlocks.PINK_BONNET.get());
        dropWhenSilkTouch(GsBlocks.PINK_BONNET_STEM_BLOCK.get());
        dropMushroom(GsBlocks.PINK_BONNET_BLOCK, GsItems.PINK_BONNET);
        dropSelf(GsBlocks.LAPIS_DECEIVER.get());
        dropWhenSilkTouch(GsBlocks.LAPIS_DECEIVER_STEM_BLOCK.get());
        dropMushroom(GsBlocks.LAPIS_DECEIVER_BLOCK, GsItems.LAPIS_DECEIVER);
        dropSelf(GsBlocks.MOREL.get());
        dropMushroom(GsBlocks.MOREL_BLOCK, GsItems.MOREL);
        dropSelf(GsBlocks.VIERTOUW_MUSHROOM.get());
        dropMushroom(GsBlocks.VIERTOUW_MUSHROOM_BLOCK, GsItems.VIERTOUW_MUSHROOM);
        dropMushroom(GsBlocks.PINK_VIERTOUW_MUSHROOM_BLOCK, GsItems.VIERTOUW_MUSHROOM);
        dropSelf(GsBlocks.TURKEY_TAIL.get());
        dropSelf(GsBlocks.CHICKEN_OF_THE_WOODS.get());
        dropSelf(GsBlocks.INFUSED_STONE.get());
        dropSelf(GsBlocks.INFUSED_STONE_STAIRS.get());
        dropSelf(GsBlocks.INFUSED_STONE_SLAB.get());
        dropSelf(GsBlocks.INFUSED_STONE_WALL.get());
        dropSelf(GsBlocks.POLISHED_INFUSED_STONE.get());
        dropSelf(GsBlocks.POLISHED_INFUSED_STONE_STAIRS.get());
        dropSelf(GsBlocks.POLISHED_INFUSED_STONE_SLAB.get());
        dropSelf(GsBlocks.POLISHED_INFUSED_STONE_WALL.get());
        dropSelf(GsBlocks.MITHRALIUM_STONE.get());
        dropSelf(GsBlocks.MITHRALIUM_STONE_STAIRS.get());
        dropSelf(GsBlocks.MITHRALIUM_STONE_SLAB.get());
        dropSelf(GsBlocks.MITHRALIUM_STONE_WALL.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GsBlocks.REGISTER.getEntries()
                .stream()
                .map(Holder::value)
                .toList();
    }

    private void dropMushroom(DeferredBlock<HugeMushroomBlock> blockRef, ItemLike drop) {
        add(blockRef.get(), createMushroomBlockDrop(blockRef.get(), drop));
    }
}
