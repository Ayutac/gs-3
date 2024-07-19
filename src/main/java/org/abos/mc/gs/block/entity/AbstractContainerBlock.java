package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Nameable;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;

public abstract class AbstractContainerBlock extends BlockEntity implements IItemHandlerModifiable, WorldlyContainer, MenuProvider, Nameable, StackedContentsCompatible {

    protected final ItemStackHandler items;

    public AbstractContainerBlock(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        items = createItemHandler();
    }

    protected abstract ItemStackHandler createItemHandler();

    @Override
    public int getContainerSize() {
        return getSlots();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < items.getSlots(); i++) {
            if (!items.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int slotIndex) {
        return getStackInSlot(slotIndex);
    }

    @Override
    public ItemStack removeItem(int slotIndex, int amount) {
        return extractItem(slotIndex, amount, false);
    }

    @Override
    public ItemStack removeItemNoUpdate(int slotIndex) {
        return extractItem(slotIndex, 1, true);
    }

    @Override
    public void setItem(int slotIndex, ItemStack itemStack) {
        setStackInSlot(slotIndex, itemStack);
    }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < items.getSlots(); i++) {
            setStackInSlot(i, ItemStack.EMPTY);
        }
        setChanged();
    }

    @Override
    public Component getDisplayName() {
        return Nameable.super.getDisplayName();
    }

    @Override
    public void fillStackedContents(StackedContents stackedContents) {
        for (int i = 0; i < items.getSlots(); i++) {
            stackedContents.accountStack(items.getStackInSlot(i));
        }
        setChanged();
    }

    @Override
    public int getSlots() {
        return items.getSlots();
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex) {
        return items.getStackInSlot(slotIndex);
    }

    @Override
    public ItemStack insertItem(int slotIndex, ItemStack itemStack, boolean simulate) {
        var result =  items.insertItem(slotIndex, itemStack, simulate);
        if (!simulate) {
            setChanged();
        }
        return result;
    }

    @Override
    public ItemStack extractItem(int slotIndex, int amount, boolean simulate) {
        var result =  items.extractItem(slotIndex, amount, simulate);
        if (!simulate) {
            setChanged();
        }
        return result;
    }

    @Override
    public int getSlotLimit(int slotIndex) {
        return items.getSlotLimit(slotIndex);
    }

    @Override
    public boolean isItemValid(int slotIndex, ItemStack itemStack) {
        return items.isItemValid(slotIndex, itemStack);
    }

    @Override
    public void setStackInSlot(int slotIndex, ItemStack itemStack) {
        items.setStackInSlot(slotIndex, itemStack);
        setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        var nbt = items.serializeNBT(registries);
        tag.put("items", nbt);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        var nbt = (CompoundTag)tag.get("items");
        items.deserializeNBT(registries, nbt);
    }
}
