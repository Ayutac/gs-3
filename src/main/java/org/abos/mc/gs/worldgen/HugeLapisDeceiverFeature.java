package org.abos.mc.gs.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugeLapisDeceiverFeature extends GsAbstractHugeMushroomFeature {
    public HugeLapisDeceiverFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected int getTreeHeight(RandomSource random) {
        return super.getTreeHeight(random) + 4;
    }

    @Override
    protected void placeTrunk(LevelAccessor world, RandomSource rng, BlockPos blockPos, HugeMushroomFeatureConfiguration config, int maxHeight, BlockPos.MutableBlockPos mutablePos) {
        super.placeTrunk(world, rng, blockPos, config, maxHeight, mutablePos);
        BlockState blockState = config.stemProvider.getState(rng, blockPos);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false);
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, 0, 0);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, true)
                    .setValue(HugeMushroomBlock.EAST, true)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, true);
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, 0, -1);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, true)
                    .setValue(HugeMushroomBlock.EAST, true)
                    .setValue(HugeMushroomBlock.SOUTH, true)
                    .setValue(HugeMushroomBlock.WEST, false);
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, 1, 0, 0);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, true)
                    .setValue(HugeMushroomBlock.SOUTH, true)
                    .setValue(HugeMushroomBlock.WEST, true);
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, 0, 1);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, true)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, true)
                    .setValue(HugeMushroomBlock.WEST, true);
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, -1, 0, 0);
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
                setBlockMaybe(world, blockPos, mutablePos, blockState, 3 * x, height - 1, 3 * z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, 4 * x, height - 2, 2 * z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 2, 4 * z);
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, false)
                            .setValue(HugeMushroomBlock.NORTH, z == -1)
                            .setValue(HugeMushroomBlock.EAST, x == 1)
                            .setValue(HugeMushroomBlock.SOUTH, z == 1)
                            .setValue(HugeMushroomBlock.WEST, x == -1);
                }
                setBlockMaybe(world, blockPos, mutablePos, blockState, 3 * x, height - 2, 3 * z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, 3 * x, height - 3, 3 * z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, 4 * x, height - 3, 2 * z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 3, 4 * z);
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
            for (int z = -2; z <= 2; z++) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, 3 * x, height - 1, z);
            }
            for (int z = -1; z <= 1; z++) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, 4 * x, height - 2, z);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, false)
                        .setValue(HugeMushroomBlock.WEST, x == -1);
            }
            for (int z = -1; z <= 1; z++) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, 4 * x, height - 3, z);
            }
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
            for (int x = -2; x <= 2; x++) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, x, height - 1, 3 * z);
            }
            for (int x = -1; x <= 1; x++) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, x, height - 2, 4 * z);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, false);
            }
            for (int x = -1; x <= 1; x++) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, x, height - 3, 4 * z);
            }
        }
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false);
        }
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                if (x == 0 && z == 0) {
                    continue;
                }
                setBlockMaybe(world, blockPos, mutablePos, blockState, x, height - 1, z);
            }
        }
        for (int z = -3; z <= 3; z++) {
            for (int x : directions) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 2, z);
            }
            if (z == -3 || z == 3) {
                continue;
            }
            for (int x : directions) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, 3 * x, height - 2, z);
            }
        }
        for (int x = -1; x <= 1; x++) {
            for (int z : directions) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, x, height - 2, 2 * z);
                setBlockMaybe(world, blockPos, mutablePos, blockState, x, height - 2, 3 * z);
            }
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, 3, height - 3, -2);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 2, height - 3, -3);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 3, height - 3, 2);
        setBlockMaybe(world, blockPos, mutablePos, blockState, 2, height - 3, 3);
        setBlockMaybe(world, blockPos, mutablePos, blockState, -3, height - 3, 2);
        setBlockMaybe(world, blockPos, mutablePos, blockState, -2, height - 3, 3);
        setBlockMaybe(world, blockPos, mutablePos, blockState, -3, height - 3, -2);
        setBlockMaybe(world, blockPos, mutablePos, blockState, -2, height - 3, -3);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false);
        }
        setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height, 0);
        for (int x : directions) {
            for (int z = -2; z <=2; z++) {
                setBlockMaybe(world, blockPos, mutablePos, blockState, 2 * x, height - 1, z);
            }
        }
        for (int z : directions) {
            setBlockMaybe(world, blockPos, mutablePos, blockState, -1, height - 1, 2 * z);
            setBlockMaybe(world, blockPos, mutablePos, blockState, 0, height - 1, 2 * z);
            setBlockMaybe(world, blockPos, mutablePos, blockState, 1, height - 1, 2 * z);
        }
    }
}
