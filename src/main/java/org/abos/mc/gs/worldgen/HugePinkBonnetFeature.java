package org.abos.mc.gs.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugePinkBonnetFeature extends GsAbstractHugeMushroomFeature {
    public HugePinkBonnetFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected void makeCap(LevelAccessor world, RandomSource rng, BlockPos blockPos, int height, BlockPos.MutableBlockPos mutablePos, HugeMushroomFeatureConfiguration config) {
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
                            .setValue(HugeMushroomBlock.WEST, x == -1);
                }
                setBlockMaybe(world, blockPos, mutablePos, blockState, x, height, z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, x, height - 1, 2 * z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 1, z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 2, 2 * z);
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, false)
                            .setValue(HugeMushroomBlock.NORTH, z == -1)
                            .setValue(HugeMushroomBlock.EAST, x == 1)
                            .setValue(HugeMushroomBlock.SOUTH, z == 1)
                            .setValue(HugeMushroomBlock.WEST, x == -1);
                }
                setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 3, 2 * z);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, false)
                        .setValue(HugeMushroomBlock.WEST, x == -1);
            }
            setBlockMaybe(world, blockPos, mutablePos, blockState, x, height, 0);
            setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 1, 0);
            for (int y : new int[]{2,3}) {
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, y == 2)
                            .setValue(HugeMushroomBlock.NORTH, true)
                            .setValue(HugeMushroomBlock.EAST, x == 1)
                            .setValue(HugeMushroomBlock.SOUTH, true)
                            .setValue(HugeMushroomBlock.WEST, x == -1);
                }
                setBlockMaybe(world, blockPos, mutablePos, blockState, 3 * x, height - y, 0);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, false)
                        .setValue(HugeMushroomBlock.WEST, x == -1);
            }
            setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 2, 1);
            setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 3, 1);
            setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 2, -1);
            setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 3, -1);
        }
        for (int z : directions) {
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, false);
            }
            setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height, z);
            setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height - 1, 2 * z);
            for (int y : new int[]{2,3}) {
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, y == 2)
                            .setValue(HugeMushroomBlock.NORTH, z == -1)
                            .setValue(HugeMushroomBlock.EAST, true)
                            .setValue(HugeMushroomBlock.SOUTH, z == 1)
                            .setValue(HugeMushroomBlock.WEST, true);
                }
                setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height - y, 3 * z);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, false);
            }
            setBlockMaybe(world, blockPos, mutablePos, blockState, 1, height - 2, 2 * z);
            setBlockMaybe(world, blockPos, mutablePos, blockState, 1, height - 3, 2 * z);
            setBlockMaybe(world, blockPos, mutablePos, blockState, -1, height - 2, 2 * z);
            setBlockMaybe(world, blockPos, mutablePos, blockState, -1, height - 3, 2 * z);
        }
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false);
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height - 1, -1);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 1, height - 1, -1);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 1, height - 1, 0);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 1, height - 1, 1);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height - 1, 1);
        setBlockMaybe(world, blockPos, mutablePos, blockState, -1, height - 1, 1);
        setBlockMaybe(world, blockPos, mutablePos, blockState, -1, height - 1, 0);
        setBlockMaybe(world, blockPos, mutablePos, blockState, -1, height - 1, -1);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height - 2, -2);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 2, height - 2, 0);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height - 2, 2);
        setBlockMaybe(world, blockPos, mutablePos, blockState, -2, height - 2, 0);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false);
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height, 0);
    }
}
