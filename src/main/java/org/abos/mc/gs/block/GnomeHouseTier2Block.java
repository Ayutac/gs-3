package org.abos.mc.gs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.block.entity.AbstractGnomeHouseBlockEntity;
import org.abos.mc.gs.block.entity.GnomeHouseTier2BlockEntity;
import org.abos.mc.gs.registry.GsBlockEntityTypes;
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

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == GsBlockEntityTypes.GNOME_HOUSE_TIER2.get() ? AbstractGnomeHouseBlockEntity::tick : null;
    }
}
