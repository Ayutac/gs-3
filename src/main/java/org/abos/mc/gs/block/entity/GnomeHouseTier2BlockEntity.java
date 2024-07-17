package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier2Menu;
import org.abos.mc.gs.registry.GsBlockEntityTypes;

public class GnomeHouseTier2BlockEntity extends AbstractGnomeHouseBlockEntity {
    public GnomeHouseTier2BlockEntity(BlockPos pos, BlockState blockState) {
        super(GsBlockEntityTypes.GNOME_HOUSE_TIER2.get(), pos, blockState, "container.gnome_house_tier2");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory playerInv) {
        if (level == null) {
            return null;
        }
        return new GnomeHouseTier2Menu(containerId, playerInv, items, ContainerLevelAccess.create(level, worldPosition));
    }
}
