package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.registry.GsBlocks;
import org.abos.mc.gs.registry.GsItems;

public class GsItemModelProvider extends ItemModelProvider {

    public GsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GnomeSupremacy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(GsItems.GNOME_HOUSE_TIER1);
        withExistingParent(GsItems.GNOME_HOUSE_TIER2);
        withExistingParent(GsItems.GNOME_HOUSE_TIER3);
        itemGenerated(GsItems.PINK_BONNET);
        itemGenerated(GsItems.LAPIS_DECEIVER);
        itemGenerated(GsItems.MOREL);
        itemGenerated(GsItems.VIERTOUW_MUSHROOM);
        itemGenerated(GsItems.TURKEY_TAIL);
        itemGenerated(GsItems.CHICKEN_OF_THE_WOODS);
        // mushroom blocks are evil and have to be done by hand
        withExistingParent(GsItems.INFUSED_STONE);
        withExistingParent(GsItems.INFUSED_STONE_STAIRS);
        withExistingParent(GsItems.INFUSED_STONE_SLAB);
        wallInventory(GsItems.INFUSED_STONE_WALL, GsBlocks.INFUSED_STONE);
        withExistingParent(GsItems.POLISHED_INFUSED_STONE);
        withExistingParent(GsItems.POLISHED_INFUSED_STONE_STAIRS);
        withExistingParent(GsItems.POLISHED_INFUSED_STONE_SLAB);
        wallInventory(GsItems.POLISHED_INFUSED_STONE_WALL, GsBlocks.POLISHED_INFUSED_STONE);
        withExistingParent(GsItems.CHISELED_INFUSED_STONE);
        withExistingParent(GsItems.CHISELED_INFUSED_STONE_STAIRS);
        withExistingParent(GsItems.CHISELED_INFUSED_STONE_SLAB);
        wallInventory(GsItems.CHISELED_INFUSED_STONE_WALL, GsBlocks.CHISELED_INFUSED_STONE);
        withExistingParent(GsItems.MITHRALIUM_STONE);
        withExistingParent(GsItems.MITHRALIUM_STONE_STAIRS);
        withExistingParent(GsItems.MITHRALIUM_STONE_SLAB);
        wallInventory(GsItems.MITHRALIUM_STONE_WALL, GsBlocks.MITHRALIUM_STONE);
        withExistingParent(GsItems.POLISHED_MITHRALIUM_STONE);
        withExistingParent(GsItems.POLISHED_MITHRALIUM_STONE_STAIRS);
        withExistingParent(GsItems.POLISHED_MITHRALIUM_STONE_SLAB);
        wallInventory(GsItems.POLISHED_MITHRALIUM_STONE_WALL, GsBlocks.POLISHED_MITHRALIUM_STONE);
    }

    private void withExistingParent(DeferredItem<BlockItem> itemRef) {
        withExistingParent(itemRef.getRegisteredName(), modLoc("block/" + itemRef.getId().getPath()));
    }

    private void wallInventory(DeferredItem<BlockItem> wallRef, DeferredBlock<Block> blockRef) {
        wallInventory(wallRef.getRegisteredName(), modLoc("block/" + blockRef.getId().getPath()));
    }

    private void itemGenerated(DeferredItem<? extends Item> item) {
        singleTexture(item.getId().getPath(), ResourceLocation.withDefaultNamespace("item/generated"),
                "layer0", modLoc("block/" + item.getId().getPath()));
    }

}
