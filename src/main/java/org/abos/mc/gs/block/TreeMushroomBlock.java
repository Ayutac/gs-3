package org.abos.mc.gs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class TreeMushroomBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    protected Map<Direction, VoxelShape> shapes;

    public TreeMushroomBlock(Map<Direction, VoxelShape> shapes, Properties properties) {
        super(properties);
        this.shapes = shapes;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapes.getOrDefault(state.getValue(FACING), super.getShape(state, level, pos, context));
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return switch (state.getValue(FACING)) {
            case NORTH -> level.getBlockState(pos.south()).is(BlockTags.LOGS);
            case EAST -> level.getBlockState(pos.west()).is(BlockTags.LOGS);
            case SOUTH -> level.getBlockState(pos.north()).is(BlockTags.LOGS);
            case WEST -> level.getBlockState(pos.east()).is(BlockTags.LOGS);
            default -> false;
        };
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (!canSurvive(state, level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
}
