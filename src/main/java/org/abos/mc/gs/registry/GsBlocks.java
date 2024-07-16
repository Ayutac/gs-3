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
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.block.GnomeHouseTier1Block;

public interface GsBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the MODID namespace
    DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(GnomeSupremacyMod.MODID);

    // TODO sko update map colors for all blocks
    DeferredBlock<Block> GNOME_HOUSE_TIER1 = REGISTER.registerBlock("gnome_house_tier1", GnomeHouseTier1Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE));
    // TODO sko change huge mushroom this one is growing into
    DeferredBlock<MushroomBlock> PINK_BONNET = REGISTER.registerBlock("pink_bonnet", props -> new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> PINK_BONNET_BLOCK = REGISTER.registerBlock("pink_bonnet_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    // TODO sko change huge mushroom this one is growing into
    DeferredBlock<MushroomBlock> LAPIS_DECEIVER = REGISTER.registerBlock("lapis_deceiver", props -> new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> LAPIS_DECEIVER_BLOCK = REGISTER.registerBlock("lapis_deceiver_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    // TODO sko change huge mushroom this one is growing into
    DeferredBlock<MushroomBlock> MOREL = REGISTER.registerBlock("morel", props -> new MushroomBlock(TreeFeatures.HUGE_BROWN_MUSHROOM, props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> MOREL_BLOCK = REGISTER.registerBlock("morel_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<Block> INFUSED_STONE = REGISTER.registerSimpleBlock("infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> INFUSED_STONE_STAIRS = REGISTER.registerBlock("infused_stone_stairs", props -> new StairBlock(INFUSED_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> INFUSED_STONE_SLAB = REGISTER.registerBlock("infused_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> INFUSED_STONE_WALL = REGISTER.registerBlock("infused_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> MITHRALIUM_STONE = REGISTER.registerSimpleBlock("mithralium_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> MITHRALIUM_STONE_STAIRS = REGISTER.registerBlock("mithralium_stone_stairs", props -> new StairBlock(MITHRALIUM_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> MITHRALIUM_STONE_SLAB = REGISTER.registerBlock("mithralium_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> MITHRALIUM_STONE_WALL = REGISTER.registerBlock("mithralium_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
}
