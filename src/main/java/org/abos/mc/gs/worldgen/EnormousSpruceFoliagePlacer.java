package org.abos.mc.gs.worldgen;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.abos.mc.gs.registry.GsFoliagePlacers;
import org.abos.mc.gs.registry.GsTrunkPlacers;

public class EnormousSpruceFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<EnormousSpruceFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((p_68664_) -> {
        return foliagePlacerParts(p_68664_).apply(p_68664_, EnormousSpruceFoliagePlacer::new);
    });

    public EnormousSpruceFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return GsFoliagePlacers.ENORMOUS_SPRUCE_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos blockpos = attachment.pos();
        int i = 0;

        for(int j = blockpos.getY() - foliageHeight + offset; j <= blockpos.getY() + offset; ++j) {
            int k = blockpos.getY() - j;
            int l = foliageRadius + attachment.radiusOffset() + Mth.floor((float)k / (float)foliageHeight * 3.5F);
            int i1;
            if (k > 0 && l == i && (j & 1) == 0) {
                i1 = l + 1;
            } else {
                i1 = l;
            }

            this.placeLeavesRow(level, blockSetter, random, config, new BlockPos(blockpos.getX(), j, blockpos.getZ()), i1, 0, attachment.doubleTrunk());
            i = l;
        }
        this.placeLeavesRow(level, blockSetter, random, config, new BlockPos(blockpos.getX(), blockpos.getY()+offset+1, blockpos.getZ()), 1, 0, attachment.doubleTrunk());
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration configuration) {
        return height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return localX + localZ >= 7 || localX * localX + localZ * localZ > range * range;
    }
}
