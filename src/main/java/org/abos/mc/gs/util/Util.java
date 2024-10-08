package org.abos.mc.gs.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.EnumMap;
import java.util.Map;

public final class Util {

    private Util() {
        /* No instantiation */
    }

    public static Map<Direction, VoxelShape> createFaceShapeMap(double minXNorth, double minYNorth, double minZNorth, double maxXNorth, double maxYNorth, double maxZNorth) {
        Map<Direction, VoxelShape> result = new EnumMap<>(Direction.class);
        result.put(Direction.NORTH, Shapes.create(minXNorth, minYNorth, minZNorth, maxXNorth, maxYNorth, maxZNorth));
        result.put(Direction.EAST, Shapes.create(1.0-maxZNorth, minYNorth, minXNorth, 1.0-minZNorth, maxYNorth, maxXNorth));
        result.put(Direction.SOUTH, Shapes.create(1.0-maxXNorth, minYNorth, 1.0-maxZNorth, 1.0-minXNorth, maxYNorth, 1.0-minZNorth));
        result.put(Direction.WEST, Shapes.create(minZNorth, minYNorth, 1.0-maxXNorth, maxZNorth, maxYNorth, 1.0-minXNorth));
        return result;
    }

    public static VoxelShape createSymmetricalShape(double minXZ, double minY, double maxY) {
        return Shapes.create(minXZ, minY, minXZ, 1.0-minXZ, maxY, 1.0-minXZ);
    }

    public static BlockPos teleportationGoalIntoGnomeDimension(BlockPos start, LevelAccessor gnomeDim) {
        BlockPos.MutableBlockPos result = new BlockPos.MutableBlockPos(4 * start.getX(), gnomeDim.getMaxBuildHeight(), 4 * start.getZ());
        while (gnomeDim.getBlockState(result).isAir()) {
            result.setY(result.getY() - 1);
        }
        result.setY(result.getY() + 1);
        return new BlockPos(result.getX(), result.getY(), result.getZ());
    }

    public static BlockPos teleportationGoalIntoVanillaDimension(BlockPos start, LevelAccessor vanillaDim) {
        BlockPos.MutableBlockPos result = new BlockPos.MutableBlockPos(start.getX() / 4, vanillaDim.getMaxBuildHeight(), start.getZ() / 4);
        while (vanillaDim.getBlockState(result).isAir()) {
            result.setY(result.getY() - 1);
        }
        result.setY(result.getY() + 1);
        return new BlockPos(result.getX(), result.getY(), result.getZ());
    }

}
