package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.abos.mc.gs.block.entity.container.GnomeHouseMenu;
import org.abos.mc.gs.registry.GsBlockEntityTypes;
import org.jetbrains.annotations.Nullable;

public class GnomeHouseBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, StackedContentsCompatible {

    private static final int[] SLOTS = new int[] {0, 1};

    protected ItemStackHandler items;

    public GnomeHouseBlockEntity(BlockPos pos, BlockState blockState) {
        super(GsBlockEntityTypes.GNOME_HOUSE.get(), pos, blockState);
        this.items = new ItemStackHandler(SLOTS.length);
    }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        return SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
        return false;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.gnome_house");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        final NonNullList<ItemStack> result = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        for (int i = 0; i < items.getSlots(); i++) {
            result.set(i, items.getStackInSlot(i));
        }
        return result;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        if (items.size() != this.items.getSlots()) {
            return;
        }
        for (int i = 0; i < this.items.getSlots(); i++) {
            this.items.setStackInSlot(i, items.get(i));
        }
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory playerInv) {
        return new GnomeHouseMenu(containerId, playerInv);
    }

    @Override
    public int getContainerSize() {
        return items.getSlots();
    }

    @Override
    public void fillStackedContents(StackedContents stackedContents) {
        for (int i = 0; i < items.getSlots(); i++) {
            stackedContents.accountStack(items.getStackInSlot(i));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("items", items.serializeNBT(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        items.deserializeNBT(registries, (CompoundTag)tag.get("items"));
    }
}
