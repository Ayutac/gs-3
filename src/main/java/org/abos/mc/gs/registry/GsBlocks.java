package org.abos.mc.gs.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
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
import org.abos.mc.gs.block.GnomeTeleporterBlock;
import org.abos.mc.gs.block.GroundMushroomBlock;
import org.abos.mc.gs.block.TreeMushroomBlock;
import org.abos.mc.gs.util.Util;

public interface GsBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the MODID namespace
    DeferredRegister.Blocks REGISTER = DeferredRegister.createBlocks(GnomeSupremacy.MODID);

    // TODO sko update map colors for all blocks
    DeferredBlock<Block> GNOME_HOUSE_TIER1 = REGISTER.registerBlock("gnome_house_tier1", GnomeHouseTier1Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).noOcclusion().lightLevel(state -> 5));
    DeferredBlock<Block> GNOME_HOUSE_TIER2 = REGISTER.registerBlock("gnome_house_tier2", GnomeHouseTier2Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).noOcclusion().lightLevel(state -> 10));
    DeferredBlock<Block> GNOME_HOUSE_TIER3 = REGISTER.registerBlock("gnome_house_tier3", GnomeHouseTier3Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE).noOcclusion().lightLevel(state -> 15));
    DeferredBlock<GroundMushroomBlock> PINK_BONNET = REGISTER.registerBlock("pink_bonnet", props -> new GroundMushroomBlock(GsConfiguredFeatures.HUGE_PINK_BONNET, Util.createSymmetricalShape(0.25, 0.0, 13d/16), props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<FlowerPotBlock> POTTED_PINK_BONNET = REGISTER.registerBlock("potted_pink_bonnet", props -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, PINK_BONNET, props), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> PINK_BONNET_STEM_BLOCK = REGISTER.registerBlock("pink_bonnet_stem_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM));
    DeferredBlock<HugeMushroomBlock> PINK_BONNET_BLOCK = REGISTER.registerBlock("pink_bonnet_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<GroundMushroomBlock> LAPIS_DECEIVER = REGISTER.registerBlock("lapis_deceiver", props -> new GroundMushroomBlock(GsConfiguredFeatures.HUGE_LAPIS_DECEIVER, Util.createSymmetricalShape(5d/16, 0.0, 1.0), props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<FlowerPotBlock> POTTED_LAPIS_DECEIVER = REGISTER.registerBlock("potted_lapis_deceiver", props -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, LAPIS_DECEIVER, props), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> LAPIS_DECEIVER_BLOCK = REGISTER.registerBlock("lapis_deceiver_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<HugeMushroomBlock> LAPIS_DECEIVER_STEM_BLOCK = REGISTER.registerBlock("lapis_deceiver_stem_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM));
    DeferredBlock<GroundMushroomBlock> MOREL = REGISTER.registerBlock("morel", props -> new GroundMushroomBlock(GsConfiguredFeatures.HUGE_MOREL, Util.createSymmetricalShape(0.25, 0.0, 11d/16), props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> MOREL_BLOCK = REGISTER.registerBlock("morel_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<FlowerPotBlock> POTTED_MOREL = REGISTER.registerBlock("potted_morel", props -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, MOREL, props), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM));
    DeferredBlock<GroundMushroomBlock> VIERTOUW_MUSHROOM = REGISTER.registerBlock("viertouw_mushroom", props -> new GroundMushroomBlock(GsConfiguredFeatures.HUGE_VIERTOUW_MUSHROOM, Util.createSymmetricalShape(1d/16, 0.0, 15d/16), props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<HugeMushroomBlock> VIERTOUW_MUSHROOM_BLOCK = REGISTER.registerBlock("viertouw_mushroom_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<HugeMushroomBlock> PINK_VIERTOUW_MUSHROOM_BLOCK = REGISTER.registerBlock("pink_viertouw_mushroom_block", HugeMushroomBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM_BLOCK));
    DeferredBlock<FlowerPotBlock> POTTED_VIERTOUW_MUSHROOM = REGISTER.registerBlock("potted_viertouw_mushroom", props -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, VIERTOUW_MUSHROOM, props), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_BROWN_MUSHROOM));
    DeferredBlock<TreeMushroomBlock> TURKEY_TAIL = REGISTER.registerBlock("turkey_tail", props -> new TreeMushroomBlock(Util.createFaceShapeMap(1d/16, 0.2, 0.45, 15d/16, 7d/16, 1.0), props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<TreeMushroomBlock> CHICKEN_OF_THE_WOODS = REGISTER.registerBlock("chicken_of_the_woods", props -> new TreeMushroomBlock(Util.createFaceShapeMap(1d/16, 0.65, 0.5, 15d/16, 14d/16, 1.0), props), BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM));
    DeferredBlock<Block> INFUSED_STONE = REGISTER.registerSimpleBlock("infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> INFUSED_STONE_STAIRS = REGISTER.registerBlock("infused_stone_stairs", props -> new StairBlock(INFUSED_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> INFUSED_STONE_SLAB = REGISTER.registerBlock("infused_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> INFUSED_STONE_WALL = REGISTER.registerBlock("infused_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> POLISHED_INFUSED_STONE = REGISTER.registerSimpleBlock("polished_infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> POLISHED_INFUSED_STONE_STAIRS = REGISTER.registerBlock("polished_infused_stone_stairs", props -> new StairBlock(POLISHED_INFUSED_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> POLISHED_INFUSED_STONE_SLAB = REGISTER.registerBlock("polished_infused_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> POLISHED_INFUSED_STONE_WALL = REGISTER.registerBlock("polished_infused_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> TILED_INFUSED_STONE = REGISTER.registerSimpleBlock("tiled_infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> TILED_INFUSED_STONE_STAIRS = REGISTER.registerBlock("tiled_infused_stone_stairs", props -> new StairBlock(TILED_INFUSED_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> TILED_INFUSED_STONE_SLAB = REGISTER.registerBlock("tiled_infused_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> TILED_INFUSED_STONE_WALL = REGISTER.registerBlock("tiled_infused_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> MITHRALIUM_STONE = REGISTER.registerSimpleBlock("mithralium_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> MITHRALIUM_STONE_STAIRS = REGISTER.registerBlock("mithralium_stone_stairs", props -> new StairBlock(MITHRALIUM_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> MITHRALIUM_STONE_SLAB = REGISTER.registerBlock("mithralium_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> MITHRALIUM_STONE_WALL = REGISTER.registerBlock("mithralium_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<Block> POLISHED_MITHRALIUM_STONE = REGISTER.registerSimpleBlock("polished_mithralium_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<StairBlock> POLISHED_MITHRALIUM_STONE_STAIRS = REGISTER.registerBlock("polished_mithralium_stone_stairs", props -> new StairBlock(POLISHED_MITHRALIUM_STONE.get().defaultBlockState(), props), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS));
    DeferredBlock<SlabBlock> POLISHED_MITHRALIUM_STONE_SLAB = REGISTER.registerBlock("polished_mithralium_stone_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB));
    DeferredBlock<WallBlock> POLISHED_MITHRALIUM_STONE_WALL = REGISTER.registerBlock("polished_mithralium_stone_wall", WallBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL));
    DeferredBlock<RotatedPillarBlock> MITHRALIUM_PILLAR = REGISTER.registerBlock("mithralium_pillar", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICKS));
    DeferredBlock<Block> GNOME_TELEPORTER = REGISTER.registerBlock("gnome_teleporter", GnomeTeleporterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.REINFORCED_DEEPSLATE));

}
