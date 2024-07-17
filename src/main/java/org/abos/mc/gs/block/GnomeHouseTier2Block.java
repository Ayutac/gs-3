package org.abos.mc.gs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.block.entity.GnomeHouseTier2BlockEntity;
import org.jetbrains.annotations.Nullable;

public class GnomeHouseTier2Block extends AbstractGnomeHouseBlock {
    public static final MapCodec<GnomeHouseTier2Block> CODEC = simpleCodec(GnomeHouseTier2Block::new);

    public GnomeHouseTier2Block(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GnomeHouseTier2BlockEntity(blockPos, blockState);
    }
}
