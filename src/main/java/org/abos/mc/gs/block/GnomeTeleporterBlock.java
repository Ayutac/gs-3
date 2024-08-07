package org.abos.mc.gs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.registry.GsDimensions;
import org.abos.mc.gs.util.Util;

public class GnomeTeleporterBlock extends Block {

    public GnomeTeleporterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (level.dimension() == GsDimensions.GNOME_DIMENSION && entity instanceof ServerPlayer player) {
            ServerLevel overworld = level.getServer().getLevel(Level.OVERWORLD);
            BlockPos targetPos = Util.teleportationGoalIntoVanillaDimension(pos, overworld);
            player.teleportTo(overworld, targetPos.getX(), targetPos.getY(), targetPos.getZ(), player.getXRot(), player.getYRot());
        }
        else {
            super.stepOn(level, pos, state, entity);
        }
    }
}
