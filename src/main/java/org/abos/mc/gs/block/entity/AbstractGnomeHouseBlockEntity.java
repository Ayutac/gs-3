package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGnomeHouseBlockEntity extends AbstractContainerBlock {

    protected static final int[] SLOTS = new int[] {0, 1};

    protected String titleKey;

    protected AbstractGnomeHouseBlockEntity(BlockEntityType<? extends AbstractGnomeHouseBlockEntity> bet, BlockPos pos, BlockState blockState, String titleKey) {
        super(bet, pos, blockState);
        this.titleKey = titleKey;
    }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        return SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction) {
        return false;
    }

    @Override
    public Component getName() {
        return Component.translatable(titleKey);
    }
}
