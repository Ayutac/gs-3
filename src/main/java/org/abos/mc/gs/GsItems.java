package org.abos.mc.gs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface GsItems {
    // Create a Deferred Register to hold Items which will all be registered under the MODID namespace
    DeferredRegister.Items ITEMS = DeferredRegister.createItems(GnomeSupremacyMod.MODID);

    DeferredItem<BlockItem> PINK_BONNET_BLOCK = registerBlockItem(GsBlocks.PINK_BONNET_BLOCK);
    DeferredItem<BlockItem> LAPIS_DECEIVER_BLOCK = registerBlockItem(GsBlocks.LAPIS_DECEIVER_BLOCK);
    DeferredItem<BlockItem> INFUSED_STONE = registerBlockItem(GsBlocks.INFUSED_STONE);
    DeferredItem<BlockItem> INFUSED_STONE_STAIRS = registerBlockItem(GsBlocks.INFUSED_STONE_STAIRS);
    DeferredItem<BlockItem> INFUSED_STONE_SLAB = registerBlockItem(GsBlocks.INFUSED_STONE_SLAB);
    DeferredItem<BlockItem> INFUSED_STONE_WALL = registerBlockItem(GsBlocks.INFUSED_STONE_WALL);
    DeferredItem<BlockItem> MITHRALIUM_STONE = registerBlockItem(GsBlocks.MITHRALIUM_STONE);
    DeferredItem<BlockItem> MITHRALIUM_STONE_STAIRS = registerBlockItem(GsBlocks.MITHRALIUM_STONE_STAIRS);
    DeferredItem<BlockItem> MITHRALIUM_STONE_SLAB = registerBlockItem(GsBlocks.MITHRALIUM_STONE_SLAB);
    DeferredItem<BlockItem> MITHRALIUM_STONE_WALL = registerBlockItem(GsBlocks.MITHRALIUM_STONE_WALL);

    static DeferredItem<BlockItem> registerBlockItem(DeferredBlock<? extends Block> blockRef) {
        return ITEMS.registerSimpleBlockItem(blockRef.getId().getPath(), blockRef);
    }
}
