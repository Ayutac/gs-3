package org.abos.mc.gs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.block.entity.GnomeHouseTier3BlockEntity;
import org.jetbrains.annotations.Nullable;

public class GnomeHouseTier3Block extends AbstractGnomeHouseBlock {
    public static final MapCodec<GnomeHouseTier3Block> CODEC = simpleCodec(GnomeHouseTier3Block::new);

    public GnomeHouseTier3Block(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GnomeHouseTier3BlockEntity(blockPos, blockState);
    }
}
