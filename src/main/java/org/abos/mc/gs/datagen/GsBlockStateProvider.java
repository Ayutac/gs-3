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
        orientableBlock(GsBlocks.GNOME_HOUSE_TIER1);
        orientableBlock(GsBlocks.GNOME_HOUSE_TIER2);
        orientableBlock(GsBlocks.GNOME_HOUSE_TIER3);
        crossBlock(GsBlocks.PINK_BONNET);
        crossBlock(GsBlocks.LAPIS_DECEIVER);
        crossBlock(GsBlocks.MOREL);
        crossBlock(GsBlocks.VIERTOUW_MUSHROOM);
        // huge mushroom blocks are evil and have to be done by hand
        simpleBlock(GsBlocks.INFUSED_STONE.get());
        stairsBlock(GsBlocks.INFUSED_STONE_STAIRS.get(), blockLoc(GsBlocks.INFUSED_STONE));
        slabBlock(GsBlocks.INFUSED_STONE_SLAB.get(), blockLoc(GsBlocks.INFUSED_STONE), blockLoc(GsBlocks.INFUSED_STONE));
        wallBlock(GsBlocks.INFUSED_STONE_WALL.get(), blockLoc(GsBlocks.INFUSED_STONE));
        simpleBlock(GsBlocks.POLISHED_INFUSED_STONE.get());
        stairsBlock(GsBlocks.POLISHED_INFUSED_STONE_STAIRS.get(), blockLoc(GsBlocks.POLISHED_INFUSED_STONE));
        slabBlock(GsBlocks.POLISHED_INFUSED_STONE_SLAB.get(), blockLoc(GsBlocks.POLISHED_INFUSED_STONE), blockLoc(GsBlocks.POLISHED_INFUSED_STONE));
        wallBlock(GsBlocks.POLISHED_INFUSED_STONE_WALL.get(), blockLoc(GsBlocks.POLISHED_INFUSED_STONE));
        simpleBlock(GsBlocks.CHISELED_INFUSED_STONE.get());
        stairsBlock(GsBlocks.CHISELED_INFUSED_STONE_STAIRS.get(), blockLoc(GsBlocks.CHISELED_INFUSED_STONE));
        slabBlock(GsBlocks.CHISELED_INFUSED_STONE_SLAB.get(), blockLoc(GsBlocks.CHISELED_INFUSED_STONE), blockLoc(GsBlocks.CHISELED_INFUSED_STONE));
        wallBlock(GsBlocks.CHISELED_INFUSED_STONE_WALL.get(), blockLoc(GsBlocks.CHISELED_INFUSED_STONE));
        simpleBlock(GsBlocks.MITHRALIUM_STONE.get());
        stairsBlock(GsBlocks.MITHRALIUM_STONE_STAIRS.get(), blockLoc(GsBlocks.MITHRALIUM_STONE));
        slabBlock(GsBlocks.MITHRALIUM_STONE_SLAB.get(), blockLoc(GsBlocks.MITHRALIUM_STONE), blockLoc(GsBlocks.MITHRALIUM_STONE));
        wallBlock(GsBlocks.MITHRALIUM_STONE_WALL.get(), blockLoc(GsBlocks.MITHRALIUM_STONE));
        simpleBlock(GsBlocks.POLISHED_MITHRALIUM_STONE.get());
        stairsBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_STAIRS.get(), blockLoc(GsBlocks.POLISHED_MITHRALIUM_STONE));
        slabBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_SLAB.get(), blockLoc(GsBlocks.POLISHED_MITHRALIUM_STONE), blockLoc(GsBlocks.POLISHED_MITHRALIUM_STONE));
        wallBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_WALL.get(), blockLoc(GsBlocks.POLISHED_MITHRALIUM_STONE));
    }

    private ResourceLocation blockLoc(DeferredBlock<Block> blockRef) {
        return modLoc(BLOCK + blockRef.getId().getPath());
    }

    private void orientableBlock(DeferredBlock<? extends Block> blockRef) {
        horizontalBlock(blockRef.get(), models().orientableWithBottom(blockRef.getId().toString(),
                modLoc(BLOCK + blockRef.getId().getPath() + "_side"),
                modLoc(BLOCK + blockRef.getId().getPath() + "_front"),
                modLoc(BLOCK + blockRef.getId().getPath() + "_bottom"),
                modLoc(BLOCK + blockRef.getId().getPath() + "_top")));
    }

    private void crossBlock(DeferredBlock<? extends Block> blockRef) {
        simpleBlock(blockRef.get(), models().cross(blockRef.getId().getPath(), blockTexture(blockRef.get())).renderType("cutout"));
    }

    // TODO sko use this
    private void flowerPotBlock(DeferredBlock<? extends Block> pot, Supplier<? extends Block> plant) {
        simpleBlock(pot.get(), models().withExistingParent(pot.getId().getPath(), "block/flower_pot_cross").texture("plant", blockTexture(plant.get())).renderType("cutout"));
    }

    /*private void mushroomBlock(DeferredBlock<HugeMushroomBlock> blockRef) {
        ResourceLocation outside = ResourceLocation.fromNamespaceAndPath(GnomeSupremacyMod.MODID, "block/" + blockRef.getId().getPath());
        ResourceLocation inside = ResourceLocation.withDefaultNamespace("block/mushroom_block_inside");
        MultiPartGenerator.multiPart(blockRef.get())
                .with(Condition.condition().term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, outside))
                .with(Condition.condition().term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, outside).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .with(Condition.condition().term(BlockStateProperties.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, outside).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, true))
                .with(Condition.condition().term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, outside).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .with(Condition.condition().term(BlockStateProperties.UP, true), Variant.variant().with(VariantProperties.MODEL, outside).with(VariantProperties.X_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, true))
                .with(Condition.condition().term(BlockStateProperties.DOWN, true), Variant.variant().with(VariantProperties.MODEL, outside).with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, true))
                .with(Condition.condition().term(BlockStateProperties.NORTH, false), Variant.variant().with(VariantProperties.MODEL, inside))
                .with(Condition.condition().term(BlockStateProperties.EAST, false), Variant.variant().with(VariantProperties.MODEL, inside).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, false))
                .with(Condition.condition().term(BlockStateProperties.SOUTH, false), Variant.variant().with(VariantProperties.MODEL, inside).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180).with(VariantProperties.UV_LOCK, false))
                .with(Condition.condition().term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, inside).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, false))
                .with(Condition.condition().term(BlockStateProperties.UP, false), Variant.variant().with(VariantProperties.MODEL, inside).with(VariantProperties.X_ROT, VariantProperties.Rotation.R270).with(VariantProperties.UV_LOCK, false))
                .with(Condition.condition().term(BlockStateProperties.DOWN, false), Variant.variant().with(VariantProperties.MODEL, inside).with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.UV_LOCK, false));

    }*/
}
