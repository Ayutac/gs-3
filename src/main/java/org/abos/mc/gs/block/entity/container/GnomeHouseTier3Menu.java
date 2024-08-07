package org.abos.mc.gs.block.entity.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.neoforged.neoforge.items.IItemHandler;
import org.abos.mc.gs.registry.GsBlocks;

public class GnomeHouseTier3Menu extends AbstractGnomeHouseMenu {
    public GnomeHouseTier3Menu(int containerId, Inventory playerInv) {
        super(containerId, playerInv);
    }

    public GnomeHouseTier3Menu(int containerId, Inventory playerInv, IItemHandler dataInventory, ContainerData data, ContainerLevelAccess access) {
        super(containerId, playerInv, dataInventory, data, access);
    }

    @Override
    public boolean stillValid(Player player) {
        return AbstractContainerMenu.stillValid(this.access, player, GsBlocks.GNOME_HOUSE_TIER3.get());
    }
}
