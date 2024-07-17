package org.abos.mc.gs.block.entity.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.neoforged.neoforge.items.IItemHandler;
import org.abos.mc.gs.registry.GsBlocks;

public class GnomeHouseTier2Menu extends AbstractGnomeHouseMenu {
    public GnomeHouseTier2Menu(int containerId, Inventory playerInv) {
        super(containerId, playerInv);
    }

    public GnomeHouseTier2Menu(int containerId, Inventory playerInv, IItemHandler dataInventory, ContainerLevelAccess access) {
        super(containerId, playerInv, dataInventory, access);
    }

    @Override
    public boolean stillValid(Player player) {
        return AbstractContainerMenu.stillValid(this.access, player, GsBlocks.GNOME_HOUSE_TIER2.get());
    }
}
