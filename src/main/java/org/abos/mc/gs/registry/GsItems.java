package org.abos.mc.gs.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;

public interface GsItems {
    // Create a Deferred Register to hold Items which will all be registered under the MODID namespace
    DeferredRegister.Items REGISTER = DeferredRegister.createItems(GnomeSupremacy.MODID);

    DeferredItem<BlockItem> GNOME_HOUSE_TIER1 = registerBlockItem(GsBlocks.GNOME_HOUSE_TIER1);
    DeferredItem<BlockItem> GNOME_HOUSE_TIER2 = registerBlockItem(GsBlocks.GNOME_HOUSE_TIER2);
    DeferredItem<BlockItem> GNOME_HOUSE_TIER3 = registerBlockItem(GsBlocks.GNOME_HOUSE_TIER3);
    DeferredItem<BlockItem> PINK_BONNET = registerBlockItem(GsBlocks.PINK_BONNET);
    DeferredItem<BlockItem> PINK_BONNET_STEM_BLOCK = registerBlockItem(GsBlocks.PINK_BONNET_STEM_BLOCK);
    DeferredItem<BlockItem> PINK_BONNET_BLOCK = registerBlockItem(GsBlocks.PINK_BONNET_BLOCK);
    DeferredItem<BlockItem> LAPIS_DECEIVER = registerBlockItem(GsBlocks.LAPIS_DECEIVER);
    DeferredItem<BlockItem> LAPIS_DECEIVER_STEM_BLOCK = registerBlockItem(GsBlocks.LAPIS_DECEIVER_STEM_BLOCK);
    DeferredItem<BlockItem> LAPIS_DECEIVER_BLOCK = registerBlockItem(GsBlocks.LAPIS_DECEIVER_BLOCK);
    DeferredItem<BlockItem> MOREL = registerBlockItem(GsBlocks.MOREL);
    DeferredItem<BlockItem> MOREL_BLOCK = registerBlockItem(GsBlocks.MOREL_BLOCK);
    DeferredItem<BlockItem> VIERTOUW_MUSHROOM = registerBlockItem(GsBlocks.VIERTOUW_MUSHROOM);
    DeferredItem<BlockItem> VIERTOUW_MUSHROOM_BLOCK = registerBlockItem(GsBlocks.VIERTOUW_MUSHROOM_BLOCK);
    DeferredItem<BlockItem> PINK_VIERTOUW_MUSHROOM_BLOCK = registerBlockItem(GsBlocks.PINK_VIERTOUW_MUSHROOM_BLOCK);
    DeferredItem<BlockItem> TURKEY_TAIL = registerBlockItem(GsBlocks.TURKEY_TAIL);
    DeferredItem<BlockItem> CHICKEN_OF_THE_WOODS = registerBlockItem(GsBlocks.CHICKEN_OF_THE_WOODS);
    DeferredItem<BlockItem> INFUSED_STONE = registerBlockItem(GsBlocks.INFUSED_STONE);
    DeferredItem<BlockItem> INFUSED_STONE_STAIRS = registerBlockItem(GsBlocks.INFUSED_STONE_STAIRS);
    DeferredItem<BlockItem> INFUSED_STONE_SLAB = registerBlockItem(GsBlocks.INFUSED_STONE_SLAB);
    DeferredItem<BlockItem> INFUSED_STONE_WALL = registerBlockItem(GsBlocks.INFUSED_STONE_WALL);
    DeferredItem<BlockItem> POLISHED_INFUSED_STONE = registerBlockItem(GsBlocks.POLISHED_INFUSED_STONE);
    DeferredItem<BlockItem> POLISHED_INFUSED_STONE_STAIRS = registerBlockItem(GsBlocks.POLISHED_INFUSED_STONE_STAIRS);
    DeferredItem<BlockItem> POLISHED_INFUSED_STONE_SLAB = registerBlockItem(GsBlocks.POLISHED_INFUSED_STONE_SLAB);
    DeferredItem<BlockItem> POLISHED_INFUSED_STONE_WALL = registerBlockItem(GsBlocks.POLISHED_INFUSED_STONE_WALL);
    DeferredItem<BlockItem> CHISELED_INFUSED_STONE = registerBlockItem(GsBlocks.TILED_INFUSED_STONE);
    DeferredItem<BlockItem> CHISELED_INFUSED_STONE_STAIRS = registerBlockItem(GsBlocks.TILED_INFUSED_STONE_STAIRS);
    DeferredItem<BlockItem> CHISELED_INFUSED_STONE_SLAB = registerBlockItem(GsBlocks.TILED_INFUSED_STONE_SLAB);
    DeferredItem<BlockItem> CHISELED_INFUSED_STONE_WALL = registerBlockItem(GsBlocks.TILED_INFUSED_STONE_WALL);
    DeferredItem<BlockItem> MITHRALIUM_STONE = registerBlockItem(GsBlocks.MITHRALIUM_STONE);
    DeferredItem<BlockItem> MITHRALIUM_STONE_STAIRS = registerBlockItem(GsBlocks.MITHRALIUM_STONE_STAIRS);
    DeferredItem<BlockItem> MITHRALIUM_STONE_SLAB = registerBlockItem(GsBlocks.MITHRALIUM_STONE_SLAB);
    DeferredItem<BlockItem> MITHRALIUM_STONE_WALL = registerBlockItem(GsBlocks.MITHRALIUM_STONE_WALL);
    DeferredItem<BlockItem> POLISHED_MITHRALIUM_STONE = registerBlockItem(GsBlocks.POLISHED_MITHRALIUM_STONE);
    DeferredItem<BlockItem> POLISHED_MITHRALIUM_STONE_STAIRS = registerBlockItem(GsBlocks.POLISHED_MITHRALIUM_STONE_STAIRS);
    DeferredItem<BlockItem> POLISHED_MITHRALIUM_STONE_SLAB = registerBlockItem(GsBlocks.POLISHED_MITHRALIUM_STONE_SLAB);
    DeferredItem<BlockItem> POLISHED_MITHRALIUM_STONE_WALL = registerBlockItem(GsBlocks.POLISHED_MITHRALIUM_STONE_WALL);
    DeferredItem<BlockItem> MITHRALIUM_PILLAR = registerBlockItem(GsBlocks.MITHRALIUM_PILLAR);
    DeferredItem<BlockItem> GNOME_TELEPORTER = registerBlockItem(GsBlocks.GNOME_TELEPORTER);

    static DeferredItem<BlockItem> registerBlockItem(DeferredBlock<? extends Block> blockRef) {
        return REGISTER.registerSimpleBlockItem(blockRef.getId().getPath(), blockRef);
    }
}
