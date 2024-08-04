package org.abos.mc.gs.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import org.abos.mc.gs.registry.GsBlocks;

public class HugeViertouwMushroomFeature extends GsAbstractHugeMushroomFeature {
    public HugeViertouwMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected int getTreeHeight(RandomSource random) {
        return super.getTreeHeight(random)+6;
    }

    @Override
    public boolean hasDirectionalProperties(BlockState blockState) {
        return super.hasDirectionalProperties(blockState) && blockState.hasProperty(HugeMushroomBlock.DOWN);
    }

    @Override
    protected void makeCap(LevelAccessor world, RandomSource rng, BlockPos blockPos, int height, BlockPos.MutableBlockPos mutableBlockPos, HugeMushroomFeatureConfiguration config) {
        BlockState blockState = config.capProvider.getState(rng, blockPos);
        // negative Z is North
        // positive X is East
        final int[] directions = new int[]{-1,1};
        for (int x : directions) {
            for (int z : directions) {
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, true)
                            .setValue(HugeMushroomBlock.NORTH, z == -1)
                            .setValue(HugeMushroomBlock.EAST, x == 1)
                            .setValue(HugeMushroomBlock.SOUTH, z == 1)
                            .setValue(HugeMushroomBlock.WEST, x == -1)
                            .setValue(HugeMushroomBlock.DOWN, false);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height + 2, z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height + 1, 3 * z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 3 * x, height + 1, z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height, 2 * z);
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, false)
                            .setValue(HugeMushroomBlock.NORTH, z == -1)
                            .setValue(HugeMushroomBlock.EAST, x == 1)
                            .setValue(HugeMushroomBlock.SOUTH, z == 1)
                            .setValue(HugeMushroomBlock.WEST, x == -1)
                            .setValue(HugeMushroomBlock.DOWN, false);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height, 3 * z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 3 * x, height, z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height - 1, 3 * z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 3 * x, height - 1, z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 1, 2 * z);
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, true)
                            .setValue(HugeMushroomBlock.NORTH, true)
                            .setValue(HugeMushroomBlock.EAST, true)
                            .setValue(HugeMushroomBlock.SOUTH, true)
                            .setValue(HugeMushroomBlock.WEST, true)
                            .setValue(HugeMushroomBlock.DOWN, false);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 6 * x, height - 2, 0);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 2, 6 * z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 5 * x, height - 4, 0);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 4, 5 * z);
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, false)
                            .setValue(HugeMushroomBlock.NORTH, true)
                            .setValue(HugeMushroomBlock.EAST, true)
                            .setValue(HugeMushroomBlock.SOUTH, true)
                            .setValue(HugeMushroomBlock.WEST, true)
                            .setValue(HugeMushroomBlock.DOWN, true);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 6 * x, height - 3, 0);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 3, 6 * z);
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, false)
                            .setValue(HugeMushroomBlock.NORTH, true)
                            .setValue(HugeMushroomBlock.EAST, true)
                            .setValue(HugeMushroomBlock.SOUTH, true)
                            .setValue(HugeMushroomBlock.WEST, true)
                            .setValue(HugeMushroomBlock.DOWN, false);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 5 * x, height - 5, 0);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 5, 5 * x);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 5 * x, height - 6, 0);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 6, 5 * x);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, false)
                        .setValue(HugeMushroomBlock.WEST, x == -1)
                        .setValue(HugeMushroomBlock.DOWN, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height + 2, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 3 * x, height + 1, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height + 1, 2);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height + 1, -2);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, false)
                        .setValue(HugeMushroomBlock.WEST, x == -1)
                        .setValue(HugeMushroomBlock.DOWN, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 3 * x, height, 0);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, true)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, true)
                        .setValue(HugeMushroomBlock.WEST, x == -1)
                        .setValue(HugeMushroomBlock.DOWN, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 6 * x, height - 7, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 7 * x, height - 8, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 8 * x, height - 9, 0);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, true)
                        .setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, true)
                        .setValue(HugeMushroomBlock.WEST, false)
                        .setValue(HugeMushroomBlock.DOWN, true);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 4 * x, height - 1, 0);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, true)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, true)
                        .setValue(HugeMushroomBlock.WEST, x == -1)
                        .setValue(HugeMushroomBlock.DOWN, true);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 5 * x, height - 1, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height - 9, 7);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height - 9, -7);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, true)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, true)
                        .setValue(HugeMushroomBlock.WEST, x == -1)
                        .setValue(HugeMushroomBlock.DOWN, true);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -5 * x, height - 7, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -6 * x, height - 9, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -7 * x, height - 10, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 8 * x, height - 10, 0);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, true)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, true)
                        .setValue(HugeMushroomBlock.WEST, x == -1)
                        .setValue(HugeMushroomBlock.DOWN, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -6 * x, height - 8, 0);
        }
        for (int z : directions) {
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, false)
                        .setValue(HugeMushroomBlock.DOWN, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height + 2, z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height + 1, 3 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2, height + 1, z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -2, height + 1, z);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, false)
                        .setValue(HugeMushroomBlock.DOWN, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height, 3 * z);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, true)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, true)
                        .setValue(HugeMushroomBlock.DOWN, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 7, 6 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 8, 7 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 9, 8 * z);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.EAST, true)
                        .setValue(HugeMushroomBlock.SOUTH, false)
                        .setValue(HugeMushroomBlock.WEST, true)
                        .setValue(HugeMushroomBlock.DOWN, true);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 1, 4 * z);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, true)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, true)
                        .setValue(HugeMushroomBlock.DOWN, true);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 1, 5 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 7, height - 9, z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -7, height - 9, z);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, true)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, true)
                        .setValue(HugeMushroomBlock.DOWN, true);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 7, -5 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 9, -6 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 10, -7 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 10, 8 * z);
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, true)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, true)
                        .setValue(HugeMushroomBlock.DOWN, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 8, -6 * z);
        }
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false)
                    .setValue(HugeMushroomBlock.DOWN, false);
        }
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height + 1, z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height, z);
            }
        }
        for (int x : directions) {
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height, -1);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height, 1);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 1, -1);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 1, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 1, 1);
        }
        for (int z : directions) {
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height, 2 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height, 2 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height, 2 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height - 1, 2 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 1, 2 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height - 1, 2 * z);
        }
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height - 1, 1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height - 1, -1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height - 1, 1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height - 1, -1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 1, -3);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 3, height - 1, 0);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 1, 3);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -3, height - 1, 0);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 9, -7);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 7, height - 9, 0);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 9, 7);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -7, height - 9, 0);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false)
                    .setValue(HugeMushroomBlock.DOWN, false);
        }
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height + 2, 0);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height + 1, -2);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2, height + 1, 0);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height + 1, 2);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -2, height + 1, 0);
        // do the pink bonds
        blockState = GsBlocks.PINK_VIERTOUW_MUSHROOM_BLOCK.get().defaultBlockState();
        for (int x : directions) {
            for (int z : directions) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, true)
                        .setValue(HugeMushroomBlock.EAST, true)
                        .setValue(HugeMushroomBlock.SOUTH, true)
                        .setValue(HugeMushroomBlock.WEST, true)
                        .setValue(HugeMushroomBlock.DOWN, false);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 4 * x, height - 1, z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height - 1, 4 * z);
            }
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, true)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, true)
                    .setValue(HugeMushroomBlock.DOWN, true);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 4 * x, height, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 4 * x, height - 2, 0);
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, x == 1)
                    .setValue(HugeMushroomBlock.EAST, true)
                    .setValue(HugeMushroomBlock.SOUTH, x == -1)
                    .setValue(HugeMushroomBlock.WEST, true)
                    .setValue(HugeMushroomBlock.DOWN, false);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 4 * x, height, -x);
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, x == -1)
                    .setValue(HugeMushroomBlock.EAST, true)
                    .setValue(HugeMushroomBlock.SOUTH, x == 1)
                    .setValue(HugeMushroomBlock.WEST, true)
                    .setValue(HugeMushroomBlock.DOWN, false);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 4 * x, height, x);
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, x == 1)
                    .setValue(HugeMushroomBlock.EAST, true)
                    .setValue(HugeMushroomBlock.SOUTH, x == -1)
                    .setValue(HugeMushroomBlock.WEST, true)
                    .setValue(HugeMushroomBlock.DOWN, true);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 4 * x, height - 2, -x);
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, x == -1)
                    .setValue(HugeMushroomBlock.EAST, true)
                    .setValue(HugeMushroomBlock.SOUTH, x == 1)
                    .setValue(HugeMushroomBlock.WEST, true)
                    .setValue(HugeMushroomBlock.DOWN, true);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 4 * x, height - 2, x);
        }
        for (int z : directions) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, true)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, true)
                    .setValue(HugeMushroomBlock.WEST, false)
                    .setValue(HugeMushroomBlock.DOWN, true);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height, 4 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 2, 4 * z);
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, true)
                    .setValue(HugeMushroomBlock.EAST, z == -1)
                    .setValue(HugeMushroomBlock.SOUTH, true)
                    .setValue(HugeMushroomBlock.WEST, z == 1)
                    .setValue(HugeMushroomBlock.DOWN, false);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -z, height, 4 * z);
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, true)
                    .setValue(HugeMushroomBlock.EAST, z == 1)
                    .setValue(HugeMushroomBlock.SOUTH, true)
                    .setValue(HugeMushroomBlock.WEST, z == -1)
                    .setValue(HugeMushroomBlock.DOWN, false);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, z, height, 4 * z);
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, true)
                    .setValue(HugeMushroomBlock.EAST, z == -1)
                    .setValue(HugeMushroomBlock.SOUTH, true)
                    .setValue(HugeMushroomBlock.WEST, z == 1)
                    .setValue(HugeMushroomBlock.DOWN, true);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -z, height - 2, 4 * z);
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, true)
                    .setValue(HugeMushroomBlock.EAST, z == 1)
                    .setValue(HugeMushroomBlock.SOUTH, true)
                    .setValue(HugeMushroomBlock.WEST, z == -1)
                    .setValue(HugeMushroomBlock.DOWN, true);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, z, height - 2, 4 * z);
        }

    }
}
