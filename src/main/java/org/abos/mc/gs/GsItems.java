package org.abos.mc.gs;

import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface GsItems {
    // Create a Deferred Register to hold Items which will all be registered under the MODID namespace
    DeferredRegister.Items ITEMS = DeferredRegister.createItems(GnomeSupremacyMod.MODID);

    DeferredItem<BlockItem> INFUSED_STONE = ITEMS.registerSimpleBlockItem(GsBlocks.INFUSED_STONE.getId().getPath(), GsBlocks.INFUSED_STONE);
    DeferredItem<BlockItem> MITHRALIUM_STONE = ITEMS.registerSimpleBlockItem(GsBlocks.MITHRALIUM_STONE.getId().getPath(), GsBlocks.MITHRALIUM_STONE);
}
