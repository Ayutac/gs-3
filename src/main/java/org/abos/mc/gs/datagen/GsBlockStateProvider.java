package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.GsBlocks;

public class GsBlockStateProvider extends BlockStateProvider {
    public GsBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GnomeSupremacyMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(GsBlocks.INFUSED_STONE.get());
        stairsBlock(GsBlocks.INFUSED_STONE_STAIRS.get(), blockLoc(GsBlocks.INFUSED_STONE));
        slabBlock(GsBlocks.INFUSED_STONE_SLAB.get(), blockLoc(GsBlocks.INFUSED_STONE), blockLoc(GsBlocks.INFUSED_STONE));
        simpleBlock(GsBlocks.MITHRALIUM_STONE.get());
        stairsBlock(GsBlocks.MITHRALIUM_STONE_STAIRS.get(), blockLoc(GsBlocks.MITHRALIUM_STONE));
        slabBlock(GsBlocks.MITHRALIUM_STONE_SLAB.get(), blockLoc(GsBlocks.MITHRALIUM_STONE), blockLoc(GsBlocks.MITHRALIUM_STONE));
    }

    protected ResourceLocation blockLoc(DeferredBlock<Block> blockRef) {
        return modLoc("block/" + blockRef.getId().getPath());
    }
}
