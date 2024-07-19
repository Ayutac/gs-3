package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier1Menu;
import org.abos.mc.gs.registry.GsBlockEntityTypes;
import org.abos.mc.gs.registry.GsTags;
import org.abos.mc.gs.util.GnomeHouseInventory;

public class GnomeHouseTier1BlockEntity extends AbstractGnomeHouseBlockEntity {
    public GnomeHouseTier1BlockEntity(BlockPos pos, BlockState blockState) {
        super(GsBlockEntityTypes.GNOME_HOUSE_TIER1.get(), pos, blockState, "container.gnome_house_tier1");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        if (level == null) {
            return null;
        }
        return new GnomeHouseTier1Menu(containerId, playerInv, items, ContainerLevelAccess.create(level, worldPosition));
    }

    @Override
    protected GnomeHouseInventory createItemHandler() {
        return new GnomeHouseInventory(GsTags.GNOME_TIER1_FOOD);
    }
}
