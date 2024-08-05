package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.registry.GsBlocks;

import java.util.function.Supplier;

public class GsBlockStateProvider extends BlockStateProvider {

    private static final String BLOCK = "block/";

    public GsBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GnomeSupremacy.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        crossBlock(GsBlocks.PINK_BONNET);
        flowerPotBlock(GsBlocks.POTTED_PINK_BONNET, GsBlocks.PINK_BONNET);
        crossBlock(GsBlocks.LAPIS_DECEIVER);
        flowerPotBlock(GsBlocks.POTTED_LAPIS_DECEIVER, GsBlocks.LAPIS_DECEIVER);
        crossBlock(GsBlocks.MOREL);
        flowerPotBlock(GsBlocks.POTTED_MOREL, GsBlocks.MOREL);
        crossBlock(GsBlocks.VIERTOUW_MUSHROOM);
        flowerPotBlock(GsBlocks.POTTED_VIERTOUW_MUSHROOM, GsBlocks.VIERTOUW_MUSHROOM);
        // huge mushroom blocks are evil and have to be done by hand
        simpleBlock(GsBlocks.INFUSED_STONE.get());
        stairsBlock(GsBlocks.INFUSED_STONE_STAIRS.get(), blockLoc(GsBlocks.INFUSED_STONE));
        slabBlock(GsBlocks.INFUSED_STONE_SLAB.get(), blockLoc(GsBlocks.INFUSED_STONE), blockLoc(GsBlocks.INFUSED_STONE));
        wallBlock(GsBlocks.INFUSED_STONE_WALL.get(), blockLoc(GsBlocks.INFUSED_STONE));
        simpleBlock(GsBlocks.POLISHED_INFUSED_STONE.get());
        stairsBlock(GsBlocks.POLISHED_INFUSED_STONE_STAIRS.get(), blockLoc(GsBlocks.POLISHED_INFUSED_STONE));
        slabBlock(GsBlocks.POLISHED_INFUSED_STONE_SLAB.get(), blockLoc(GsBlocks.POLISHED_INFUSED_STONE), blockLoc(GsBlocks.POLISHED_INFUSED_STONE));
        wallBlock(GsBlocks.POLISHED_INFUSED_STONE_WALL.get(), blockLoc(GsBlocks.POLISHED_INFUSED_STONE));
        simpleBlock(GsBlocks.TILED_INFUSED_STONE.get());
        stairsBlock(GsBlocks.TILED_INFUSED_STONE_STAIRS.get(), blockLoc(GsBlocks.TILED_INFUSED_STONE));
        slabBlock(GsBlocks.TILED_INFUSED_STONE_SLAB.get(), blockLoc(GsBlocks.TILED_INFUSED_STONE), blockLoc(GsBlocks.TILED_INFUSED_STONE));
        wallBlock(GsBlocks.TILED_INFUSED_STONE_WALL.get(), blockLoc(GsBlocks.TILED_INFUSED_STONE));
        simpleBlock(GsBlocks.MITHRALIUM_STONE.get());
        stairsBlock(GsBlocks.MITHRALIUM_STONE_STAIRS.get(), blockLoc(GsBlocks.MITHRALIUM_STONE));
        slabBlock(GsBlocks.MITHRALIUM_STONE_SLAB.get(), blockLoc(GsBlocks.MITHRALIUM_STONE), blockLoc(GsBlocks.MITHRALIUM_STONE));
        wallBlock(GsBlocks.MITHRALIUM_STONE_WALL.get(), blockLoc(GsBlocks.MITHRALIUM_STONE));
        simpleBlock(GsBlocks.POLISHED_MITHRALIUM_STONE.get());
        stairsBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_STAIRS.get(), blockLoc(GsBlocks.POLISHED_MITHRALIUM_STONE));
        slabBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_SLAB.get(), blockLoc(GsBlocks.POLISHED_MITHRALIUM_STONE), blockLoc(GsBlocks.POLISHED_MITHRALIUM_STONE));
        wallBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_WALL.get(), blockLoc(GsBlocks.POLISHED_MITHRALIUM_STONE));
        logBlock(GsBlocks.MITHRALIUM_PILLAR.get());
        simpleBlock(GsBlocks.GNOME_TELEPORTER.get());
    }

    private ResourceLocation blockLoc(DeferredBlock<Block> blockRef) {
        return modLoc(BLOCK + blockRef.getId().getPath());
    }

    private void crossBlock(DeferredBlock<? extends Block> blockRef) {
        simpleBlock(blockRef.get(), models().cross(blockRef.getId().getPath(), blockTexture(blockRef.get())).renderType("cutout"));
    }

    private void flowerPotBlock(DeferredBlock<? extends Block> pot, Supplier<? extends Block> plant) {
        simpleBlock(pot.get(), models().withExistingParent(pot.getId().getPath(), "block/flower_pot_cross").texture("plant", blockTexture(plant.get())).renderType("cutout"));
    }
}
