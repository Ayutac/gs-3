package org.abos.mc.gs.worldgen;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.abos.mc.gs.registry.GsTrunkPlacers;

import java.util.List;
import java.util.function.BiConsumer;

public class EnormousTrunkPlacer extends TrunkPlacer {
    // copied from GiantTrunkPlacer
    public static final MapCodec<EnormousTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((p_70189_) -> trunkPlacerParts(p_70189_).apply(p_70189_, EnormousTrunkPlacer::new));

    public EnormousTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return GsTrunkPlacers.ENORMOUS_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource rng, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        BlockPos blockPos = pos.below();
        setDirtAt(level, blockSetter, rng, blockPos, config);
        setDirtAt(level, blockSetter, rng, blockPos.east(), config);
        setDirtAt(level, blockSetter, rng, blockPos.south().east(), config);
        setDirtAt(level, blockSetter, rng, blockPos.south(), config);
        setDirtAt(level, blockSetter, rng, blockPos.south().west(), config);
        setDirtAt(level, blockSetter, rng, blockPos.west(), config);
        setDirtAt(level, blockSetter, rng, blockPos.north().west(), config);
        setDirtAt(level, blockSetter, rng, blockPos.north(), config);
        setDirtAt(level, blockSetter, rng, blockPos.north().east(), config);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int i = 0; i < freeTreeHeight; ++i) {
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, 0, i, 0);
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, 1, i, 0);
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, 1, i, 1);
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, 0, i, 1);
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, -1, i, 1);
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, -1, i, 0);
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, -1, i, -1);
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, 0, i, -1);
            this.placeLogIfFreeWithOffset(level, blockSetter, rng, blockpos$mutableblockpos, config, pos, 1, i, -1);
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(freeTreeHeight), 0, true));
    }

    private void placeLogIfFreeWithOffset(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, BlockPos.MutableBlockPos pos, TreeConfiguration config, BlockPos offsetPos, int offsetX, int offsetY, int offsetZ) {
        pos.setWithOffset(offsetPos, offsetX, offsetY, offsetZ);
        this.placeLogIfFree(level, blockSetter, random, pos, config);
    }
}
