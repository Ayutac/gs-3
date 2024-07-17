package org.abos.mc.gs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.block.entity.GnomeHouseTier1BlockEntity;
import org.jetbrains.annotations.Nullable;

public class GnomeHouseTier1Block extends AbstractGnomeHouseBlock {
    public static final MapCodec<GnomeHouseTier1Block> CODEC = simpleCodec(GnomeHouseTier1Block::new);

    public GnomeHouseTier1Block(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GnomeHouseTier1BlockEntity(blockPos, blockState);
    }
}
