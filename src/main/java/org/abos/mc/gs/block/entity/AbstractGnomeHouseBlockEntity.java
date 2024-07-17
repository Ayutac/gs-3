package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGnomeHouseBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer, StackedContentsCompatible {

    private static final int[] SLOTS = new int[] {0, 1};

    protected ItemStackHandler items;
    protected String titleKey;

    protected AbstractGnomeHouseBlockEntity(BlockEntityType<? extends AbstractGnomeHouseBlockEntity> bet, BlockPos pos, BlockState blockState, String titleKey) {
        super(bet, pos, blockState);
        this.items = new ItemStackHandler(SLOTS.length);
        this.titleKey = titleKey;
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
        return Component.translatable(titleKey);
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
