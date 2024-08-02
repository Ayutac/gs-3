package org.abos.mc.gs.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.AbstractHugeMushroomFeature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

public abstract class GsAbstractHugeMushroomFeature extends AbstractHugeMushroomFeature {
    public GsAbstractHugeMushroomFeature(Codec<HugeMushroomFeatureConfiguration> codec) {
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

    public boolean hasDirectionalProperties(BlockState blockState) {
        return blockState.hasProperty(HugeMushroomBlock.WEST) && blockState.hasProperty(HugeMushroomBlock.EAST) && blockState.hasProperty(HugeMushroomBlock.NORTH) && blockState.hasProperty(HugeMushroomBlock.SOUTH) && blockState.hasProperty(HugeMushroomBlock.UP);
    }

    protected void setBlockMaybe(LevelAccessor world, BlockPos blockPos, BlockPos.MutableBlockPos mutableBlockPos, BlockState blockState, int offsetX, int offsetY, int offsetZ) {
        mutableBlockPos.setWithOffset(blockPos, offsetX, offsetY, offsetZ);
        if (!world.getBlockState(mutableBlockPos).isSolidRender(world, mutableBlockPos)) {
            setBlock(world, mutableBlockPos, blockState);
        }
    }
}
