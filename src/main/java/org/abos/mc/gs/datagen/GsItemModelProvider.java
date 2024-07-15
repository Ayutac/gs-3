package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.GsBlocks;
import org.abos.mc.gs.GsItems;

public class GsItemModelProvider extends ItemModelProvider {

    public GsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GnomeSupremacyMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(GsItems.INFUSED_STONE);
        withExistingParent(GsItems.INFUSED_STONE_STAIRS);
        withExistingParent(GsItems.INFUSED_STONE_SLAB);
        wallInventory(GsItems.INFUSED_STONE_WALL, GsBlocks.INFUSED_STONE);
        withExistingParent(GsItems.MITHRALIUM_STONE);
        withExistingParent(GsItems.MITHRALIUM_STONE_STAIRS);
        withExistingParent(GsItems.MITHRALIUM_STONE_SLAB);
        wallInventory(GsItems.MITHRALIUM_STONE_WALL, GsBlocks.MITHRALIUM_STONE);
    }

    protected void withExistingParent(DeferredItem<BlockItem> itemRef) {
        withExistingParent(itemRef.getRegisteredName(), modLoc("block/" + itemRef.getId().getPath()));
    }

    protected void wallInventory(DeferredItem<BlockItem> wallRef, DeferredBlock<Block> blockRef) {
        wallInventory(wallRef.getRegisteredName(), modLoc("block/" + blockRef.getId().getPath()));
    }

}
