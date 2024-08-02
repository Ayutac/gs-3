package org.abos.mc.gs.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public class HugePinkBonnetFeature extends AbstractHugeMushroomFeature {
    public HugePinkBonnetFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
        super(codec);
    }

    // copied from HugeRedMushroomFeature
    @Override
    protected int getTreeRadiusForHeight(int p_65977_, int p_65978_, int p_65979_, int p_65980_) {
        int i = 0;
        if (p_65980_ < p_65978_ && p_65980_ >= p_65978_ - 3) {
            i = p_65979_;
        } else if (p_65980_ == p_65978_) {
            i = p_65979_;
        }

        return i;
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
                            .setValue(HugeMushroomBlock.WEST, x == -1);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height, z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height - 1, 2 * z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 1, z);
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 2, 2 * z);
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, false)
                            .setValue(HugeMushroomBlock.NORTH, z == -1)
                            .setValue(HugeMushroomBlock.EAST, x == 1)
                            .setValue(HugeMushroomBlock.SOUTH, z == 1)
                            .setValue(HugeMushroomBlock.WEST, x == -1);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 3, 2 * z);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, true)
                        .setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, false)
                        .setValue(HugeMushroomBlock.WEST, x == -1);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, x, height, 0);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 1, 0);
            for (int y : new int[]{2,3}) {
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, y == 2)
                            .setValue(HugeMushroomBlock.NORTH, true)
                            .setValue(HugeMushroomBlock.EAST, x == 1)
                            .setValue(HugeMushroomBlock.SOUTH, true)
                            .setValue(HugeMushroomBlock.WEST, x == -1);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 3 * x, height - y, 0);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, false)
                        .setValue(HugeMushroomBlock.EAST, x == 1)
                        .setValue(HugeMushroomBlock.SOUTH, false)
                        .setValue(HugeMushroomBlock.WEST, x == -1);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 2, 1);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 3, 1);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 2, -1);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2 * x, height - 3, -1);
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
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height, z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 1, 2 * z);
            for (int y : new int[]{2,3}) {
                if (hasDirectionalProperties(blockState)) {
                    blockState = blockState
                            .setValue(HugeMushroomBlock.UP, y == 2)
                            .setValue(HugeMushroomBlock.NORTH, z == -1)
                            .setValue(HugeMushroomBlock.EAST, true)
                            .setValue(HugeMushroomBlock.SOUTH, z == 1)
                            .setValue(HugeMushroomBlock.WEST, true);
                }
                setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - y, 3 * z);
            }
            if (hasDirectionalProperties(blockState)) {
                blockState = blockState
                        .setValue(HugeMushroomBlock.UP, false)
                        .setValue(HugeMushroomBlock.NORTH, z == -1)
                        .setValue(HugeMushroomBlock.EAST, false)
                        .setValue(HugeMushroomBlock.SOUTH, z == 1)
                        .setValue(HugeMushroomBlock.WEST, false);
            }
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height - 2, 2 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height - 3, 2 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height - 2, 2 * z);
            setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height - 3, 2 * z);
        }
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, false)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false);
        }
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 1, -1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height - 1, -1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height - 1, 0);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 1, height - 1, 1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 1, 1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height - 1, 1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height - 1, 0);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -1, height - 1, -1);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 2, -2);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 2, height - 2, 0);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height - 2, 2);
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, -2, height - 2, 0);
        if (hasDirectionalProperties(blockState)) {
            blockState = blockState
                    .setValue(HugeMushroomBlock.UP, true)
                    .setValue(HugeMushroomBlock.NORTH, false)
                    .setValue(HugeMushroomBlock.EAST, false)
                    .setValue(HugeMushroomBlock.SOUTH, false)
                    .setValue(HugeMushroomBlock.WEST, false);
        }
        setBlockMaybe(world, blockPos, mutableBlockPos, blockState, 0, height, 0);
    }

    public static boolean hasDirectionalProperties(BlockState blockState) {
        return blockState.hasProperty(HugeMushroomBlock.WEST) && blockState.hasProperty(HugeMushroomBlock.EAST) && blockState.hasProperty(HugeMushroomBlock.NORTH) && blockState.hasProperty(HugeMushroomBlock.SOUTH) && blockState.hasProperty(HugeMushroomBlock.UP);
    }

    protected void setBlockMaybe(LevelAccessor world, BlockPos blockPos, BlockPos.MutableBlockPos mutableBlockPos, BlockState blockState, int offsetX, int offsetY, int offsetZ) {
        mutableBlockPos.setWithOffset(blockPos, offsetX, offsetY, offsetZ);
        if (!world.getBlockState(mutableBlockPos).isSolidRender(world, mutableBlockPos)) {
            setBlock(world, mutableBlockPos, blockState);
        }
    }
}
