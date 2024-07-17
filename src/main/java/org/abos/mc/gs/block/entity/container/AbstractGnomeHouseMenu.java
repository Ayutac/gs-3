package org.abos.mc.gs.block.entity.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.abos.mc.gs.registry.GsMenuTypes;

public abstract class AbstractGnomeHouseMenu extends AbstractContainerMenu {

    protected ContainerLevelAccess access;

    // client constructor
    protected AbstractGnomeHouseMenu(int containerId, Inventory playerInv) {
        this(containerId, playerInv, new ItemStackHandler(2), ContainerLevelAccess.NULL);
    }

    // server constructor
    protected AbstractGnomeHouseMenu(int containerId, Inventory playerInv, IItemHandler dataInventory, ContainerLevelAccess access) {
        super(GsMenuTypes.GNOME_HOUSE_TIER1.get(), containerId);
        this.access = access;
        int k;
        // container
        this.addSlot(new SlotItemHandler(dataInventory, 0, 62, 35));
        this.addSlot(new SlotItemHandler(dataInventory, 1, 98, 35));
        // inventory
        for(k = 0; k < 3; ++k) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInv, j + k * 9 + 9, 8 + j * 18, 84 + k * 18));
            }
        }
        // hotbar
        for(k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int quickMovedSlotIndex) {
        return ItemStack.EMPTY; // TODO sko implement
    }
}
