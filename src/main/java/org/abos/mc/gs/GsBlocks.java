package org.abos.mc.gs;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface GsBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the MODID namespace
    DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GnomeSupremacyMod.MODID);

    DeferredBlock<Block> INFUSED_STONE = BLOCKS.registerSimpleBlock("infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    DeferredBlock<StairBlock> INFUSED_STONE_STAIRS = BLOCKS.registerBlock("infused_stone_stairs", props -> new StairBlock(INFUSED_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> INFUSED_STONE_SLAB = BLOCKS.registerBlock("infused_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> INFUSED_STONE_WALL = BLOCKS.registerBlock("infused_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> MITHRALIUM_STONE = BLOCKS.registerSimpleBlock("mithralium_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> MITHRALIUM_STONE_STAIRS = BLOCKS.registerBlock("mithralium_stone_stairs", props -> new StairBlock(MITHRALIUM_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> MITHRALIUM_STONE_SLAB = BLOCKS.registerBlock("mithralium_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> MITHRALIUM_STONE_WALL = BLOCKS.registerBlock("mithralium_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
}
