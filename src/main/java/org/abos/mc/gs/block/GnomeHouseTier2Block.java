package org.abos.mc.gs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.BaseEntityBlock;

public class GnomeHouseTier2Block extends AbstractGnomeHouseBlock {
    public static final MapCodec<GnomeHouseTier2Block> CODEC = simpleCodec(GnomeHouseTier2Block::new);

    public GnomeHouseTier2Block(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}
