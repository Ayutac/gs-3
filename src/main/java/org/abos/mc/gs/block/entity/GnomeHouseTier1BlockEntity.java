package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier1Menu;
import org.abos.mc.gs.registry.GsBlockEntityTypes;

public class GnomeHouseTier1BlockEntity extends AbstractGnomeHouseBlockEntity {
    public GnomeHouseTier1BlockEntity(BlockPos pos, BlockState blockState) {
        super(GsBlockEntityTypes.GNOME_HOUSE_TIER1.get(), pos, blockState, "container.gnome_house_tier1");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory playerInv) {
        if (level == null) {
            return null;
        }
        return new GnomeHouseTier1Menu(containerId, playerInv, items, ContainerLevelAccess.create(level, worldPosition));
    }
}
