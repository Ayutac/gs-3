package org.abos.mc.gs.registry;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.block.GnomeHouseTier1Block;
import org.abos.mc.gs.block.GnomeHouseTier2Block;
import org.abos.mc.gs.block.GnomeHouseTier3Block;
import org.abos.mc.gs.block.TreeMushroomBlock;
import org.abos.mc.gs.util.Util;

public interface GsBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the MODID namespace
    DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(GnomeSupremacy.MODID);

    // TODO sko update map colors for all blocks
    // TODO sko update hitboxes for mushrooms
    DeferredBlock<Block> GNOME_HOUSE_TIER1 = REGISTER.registerBlock("gnome_house_tier1", GnomeHouseTier1Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).lightLevel(state -> 5));
    DeferredBlock<Block> GNOME_HOUSE_TIER2 = REGISTER.registerBlock("gnome_house_tier2", GnomeHouseTier2Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).lightLevel(state -> 10));
    DeferredBlock<Block> GNOME_HOUSE_TIER3 = REGISTER.registerBlock("gnome_house_tier3", GnomeHouseTier3Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).lightLevel(state -> 15));
    // TODO sko change huge mushroom this one is growing into
    DeferredBlock<MushroomBlock> PINK_BONNET = REGISTER.registerBlock("pink_bonnet", props -> new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> PINK_BONNET_STEM_BLOCK = REGISTER.registerBlock("pink_bonnet_stem_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM));
    DeferredBlock<HugeMushroomBlock> PINK_BONNET_BLOCK = REGISTER.registerBlock("pink_bonnet_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    // TODO sko change huge mushroom this one is growing into
    DeferredBlock<MushroomBlock> LAPIS_DECEIVER = REGISTER.registerBlock("lapis_deceiver", props -> new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> LAPIS_DECEIVER_BLOCK = REGISTER.registerBlock("lapis_deceiver_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<HugeMushroomBlock> LAPIS_DECEIVER_STEM_BLOCK = REGISTER.registerBlock("lapis_deceiver_stem_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM));
    // TODO sko change huge mushroom this one is growing into
    DeferredBlock<MushroomBlock> MOREL = REGISTER.registerBlock("morel", props -> new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> MOREL_BLOCK = REGISTER.registerBlock("morel_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    // TODO sko change huge mushroom this one is growing into
    DeferredBlock<MushroomBlock> VIERTOUW_MUSHROOM = REGISTER.registerBlock("viertouw_mushroom", props -> new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> VIERTOUW_MUSHROOM_BLOCK = REGISTER.registerBlock("viertouw_mushroom_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<HugeMushroomBlock> PINK_VIERTOUW_MUSHROOM_BLOCK = REGISTER.registerBlock("pink_viertouw_mushroom_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<TreeMushroomBlock> TURKEY_TAIL = REGISTER.registerBlock("turkey_tail", props -> new TreeMushroomBlock(Util.createFaceShapeMap(0.1, 0.2, 0.45, 0.9, 0.45, 1.0), props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<TreeMushroomBlock> CHICKEN_OF_THE_WOODS = REGISTER.registerBlock("chicken_of_the_woods", props -> new TreeMushroomBlock(Util.createFaceShapeMap(0.1, 0.65, 0.5, 0.9, 0.9, 1.0), props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<Block> INFUSED_STONE = REGISTER.registerSimpleBlock("infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> INFUSED_STONE_STAIRS = REGISTER.registerBlock("infused_stone_stairs", props -> new StairBlock(INFUSED_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> INFUSED_STONE_SLAB = REGISTER.registerBlock("infused_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> INFUSED_STONE_WALL = REGISTER.registerBlock("infused_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> POLISHED_INFUSED_STONE = REGISTER.registerSimpleBlock("polished_infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> POLISHED_INFUSED_STONE_STAIRS = REGISTER.registerBlock("polished_infused_stone_stairs", props -> new StairBlock(POLISHED_INFUSED_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> POLISHED_INFUSED_STONE_SLAB = REGISTER.registerBlock("polished_infused_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> POLISHED_INFUSED_STONE_WALL = REGISTER.registerBlock("polished_infused_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> CHISELED_INFUSED_STONE = REGISTER.registerSimpleBlock("chiseled_infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> CHISELED_INFUSED_STONE_STAIRS = REGISTER.registerBlock("chiseled_infused_stone_stairs", props -> new StairBlock(CHISELED_INFUSED_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> CHISELED_INFUSED_STONE_SLAB = REGISTER.registerBlock("chiseled_infused_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> CHISELED_INFUSED_STONE_WALL = REGISTER.registerBlock("chiseled_infused_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> MITHRALIUM_STONE = REGISTER.registerSimpleBlock("mithralium_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> MITHRALIUM_STONE_STAIRS = REGISTER.registerBlock("mithralium_stone_stairs", props -> new StairBlock(MITHRALIUM_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> MITHRALIUM_STONE_SLAB = REGISTER.registerBlock("mithralium_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> MITHRALIUM_STONE_WALL = REGISTER.registerBlock("mithralium_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> POLISHED_MITHRALIUM_STONE = REGISTER.registerSimpleBlock("polished_mithralium_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> POLISHED_MITHRALIUM_STONE_STAIRS = REGISTER.registerBlock("polished_mithralium_stone_stairs", props -> new StairBlock(POLISHED_MITHRALIUM_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> POLISHED_MITHRALIUM_STONE_SLAB = REGISTER.registerBlock("polished_mithralium_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> POLISHED_MITHRALIUM_STONE_WALL = REGISTER.registerBlock("polished_mithralium_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> TILED_MITHRALIUM_STONE = REGISTER.registerSimpleBlock("tiled_mithralium_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> TILED_MITHRALIUM_STONE_STAIRS = REGISTER.registerBlock("tiled_mithralium_stone_stairs", props -> new StairBlock(TILED_MITHRALIUM_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> TILED_MITHRALIUM_STONE_SLAB = REGISTER.registerBlock("tiled_mithralium_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> TILED_MITHRALIUM_STONE_WALL = REGISTER.registerBlock("tiled_mithralium_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));

}
