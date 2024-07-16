package org.abos.mc.gs.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.BaseEntityBlock;

public class GnomeHouseTier1Block extends AbstractGnomeHouseBlock {
    public static final MapCodec<GnomeHouseTier1Block> CODEC = simpleCodec(GnomeHouseTier1Block::new);

    public GnomeHouseTier1Block(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}
