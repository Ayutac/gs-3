package org.abos.mc.gs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.BaseEntityBlock;

public class GnomeHouseTier3Block extends AbstractGnomeHouseBlock {
    public static final MapCodec<GnomeHouseTier3Block> CODEC = simpleCodec(GnomeHouseTier3Block::new);

    public GnomeHouseTier3Block(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}
