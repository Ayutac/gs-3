package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier3Menu;
import org.abos.mc.gs.registry.GsBlockEntityTypes;
import org.abos.mc.gs.registry.GsTags;
import org.abos.mc.gs.util.GnomeHouseInventory;

public class GnomeHouseTier3BlockEntity extends AbstractGnomeHouseBlockEntity {
    public GnomeHouseTier3BlockEntity(BlockPos pos, BlockState blockState) {
        super(GsBlockEntityTypes.GNOME_HOUSE_TIER3.get(), pos, blockState, "container.gnome_house_tier3");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        if (level == null) {
            return null;
        }
        return new GnomeHouseTier3Menu(containerId, playerInv, items, data, ContainerLevelAccess.create(level, worldPosition));
    }

    @Override
    protected GnomeHouseInventory createItemHandler() {
        return new GnomeHouseInventory(GsTags.GNOME_TIER3_FOOD);
    }
}
