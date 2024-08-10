package org.abos.mc.gs.block.entity.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.abos.mc.gs.block.entity.AbstractGnomeHouseBlockEntity;
import org.abos.mc.gs.registry.GsTags;
import org.abos.mc.gs.util.GnomeHouseInventory;

public abstract class AbstractGnomeHouseMenu extends AbstractContainerMenu {

    protected ContainerLevelAccess access;
    protected ContainerData data;

    // client constructor
    protected AbstractGnomeHouseMenu(MenuType<?> menuType, int containerId, Inventory playerInv) {
        this(menuType, containerId, playerInv, new ItemStackHandler(2), new SimpleContainerData(3), ContainerLevelAccess.NULL);
    }

    // server constructor
    protected AbstractGnomeHouseMenu(MenuType<?> menuType, int containerId, Inventory playerInv, IItemHandler dataInventory, ContainerData data, ContainerLevelAccess access) {
        super(menuType, containerId);
        this.access = access;
        this.data = data;
        this.addDataSlots(data);
        int k;
        // container
        this.addSlot(new SlotItemHandler(dataInventory, 0, 62, 35));
        this.addSlot(new SlotItemHandler(dataInventory, 1, 98, 35));
        // inventory
        for (k = 0; k < 3; ++k) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInv, j + k * 9 + 9, 8 + j * 18, 84 + k * 18));
            }
        }
        // hotbar
        for (k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }

    public double getTickProgress() {
        return (data.get(0) % AbstractGnomeHouseBlockEntity.TICK_DELTA) / (double) AbstractGnomeHouseBlockEntity.TICK_DELTA;
    }

    public boolean hasFood() {
        return data.get(2) != 0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int quickMovedSlotIndex) {
        ItemStack stackToMove = getSlot(quickMovedSlotIndex).getItem();
        if (quickMovedSlotIndex == GnomeHouseInventory.FOOD_SLOT || quickMovedSlotIndex == GnomeHouseInventory.TOOL_SLOT) {
            int targetSlotIndex = getNextMatchingSlot(stackToMove, 0);
            int transferredItems = 0;
            while (targetSlotIndex != -1 && stackToMove.getCount() != 0) {
                final ItemStack targetStack = getSlot(targetSlotIndex).getItem();
                final int itemSpace = targetStack.getMaxStackSize() - targetStack.getCount();
                final int transferredItemsThisStack = Math.min(itemSpace, stackToMove.getCount());
                targetStack.setCount(targetStack.getCount() + transferredItemsThisStack);
                stackToMove.setCount(stackToMove.getCount() - transferredItemsThisStack);
                transferredItems += transferredItemsThisStack;
                targetSlotIndex = getNextMatchingSlot(stackToMove, targetSlotIndex+1);
            }
            if (stackToMove.getCount() != 0) {
                targetSlotIndex = getNextFreeSlot();
                if (targetSlotIndex != -1) {
                    getSlot(targetSlotIndex).set(stackToMove);
                    getSlot(quickMovedSlotIndex).set(new ItemStack(Items.AIR));
                    transferredItems += stackToMove.getCount();
                }
            }
            return new ItemStack(stackToMove.getItem(), transferredItems);
        }
        if (checkFoodTag(stackToMove)) {
            final ItemStack targetStack = getSlot(GnomeHouseInventory.FOOD_SLOT).getItem();
            if (targetStack.is(stackToMove.getItem())) {
                final int itemSpace = targetStack.getMaxStackSize() - targetStack.getCount();
                final int transferredItems = Math.min(itemSpace, stackToMove.getCount());
                targetStack.setCount(targetStack.getCount() + transferredItems);
                stackToMove.setCount(stackToMove.getCount() - transferredItems);
                return new ItemStack(stackToMove.getItem(), transferredItems);
            }
            if (targetStack.isEmpty()) {
                getSlot(GnomeHouseInventory.FOOD_SLOT).set(stackToMove);
                getSlot(quickMovedSlotIndex).set(new ItemStack(Items.AIR));
                return stackToMove;
            }
            // we allow falling through here because a food might also be a tool
        }
        if (stackToMove.is(GsTags.GNOME_TOOLS)) {
            final ItemStack targetStack = getSlot(GnomeHouseInventory.TOOL_SLOT).getItem();
            if (targetStack.isEmpty()) {
                getSlot(GnomeHouseInventory.TOOL_SLOT).set(new ItemStack(stackToMove.getItem()));
                stackToMove.setCount(stackToMove.getCount() - 1);
                return new ItemStack(stackToMove.getItem());
            }
        }
        return ItemStack.EMPTY;
    }

    /**
     * Returns the next player inventory slot that matches the item stack and is NOT full
     * OR -1 if there is no such stack.
     */
    protected int getNextMatchingSlot(final ItemStack matcher, final int skip) {
        if (skip < 0) {
            throw new IllegalArgumentException("Skip cannot be negative!");
        }
        final int inventorySkip;
        if (skip < 9) {
            // we walk through the hotbar backwards
            for (int i = 37 - skip; i > 28; i--) {
                final ItemStack targetStack = getSlot(i).getItem();
                if (targetStack.is(matcher.getItem()) && targetStack.getCount() < targetStack.getMaxStackSize()) {
                    return i;
                }
            }
            inventorySkip = 0;
        }
        else {
            inventorySkip = skip - 9;
        }
        // we walk through the inventory forwards
        for (int i = inventorySkip + 2; i < 29; i++) {
            final ItemStack targetStack = getSlot(i).getItem();
            if (targetStack.is(matcher.getItem()) && targetStack.getCount() < targetStack.getMaxStackSize()) {
                return i;
            }
        }
        return -1;
    }

    protected int getNextFreeSlot() {
        // we walk through the hotbar backwards
        for (int i = 37; i > 28; i--) {
            if (getSlot(i).getItem().isEmpty()) {
                return i;
            }
        }
        // we walk through the inventory forwards
        for (int i = 2; i < 29; i++) {
            if (getSlot(i).getItem().isEmpty()) {
                return i;
            }
        }
        return -1;
    }

    protected abstract boolean checkFoodTag(ItemStack stack);

}
