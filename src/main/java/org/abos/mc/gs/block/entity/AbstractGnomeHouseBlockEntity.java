package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.abos.mc.gs.util.GnomeHouseInventory;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGnomeHouseBlockEntity extends AbstractContainerBlock {

    protected static final int[] SLOTS = new int[] {0, 1};

    // TODO sko make this configurable
    protected static final int tickDelta = 20;

    protected String titleKey;

    protected int tickCounter = 0;

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

    public static void tick(Level level, BlockPos pos, BlockState state, BlockEntity blockEntity) {
        if (blockEntity instanceof AbstractGnomeHouseBlockEntity houseEntity) {
            if (++houseEntity.tickCounter % tickDelta != 0) {
                return;
            }
            // food condition
            // TODO sko change this to fuel
            if (houseEntity.getStackInSlot(GnomeHouseInventory.FOOD_SLOT).isEmpty()) {
                return;
            }
            // tool condition
            ItemStack toolStack = houseEntity.getStackInSlot(GnomeHouseInventory.TOOL_SLOT);
            if (toolStack.isEmpty()) {
                return;
            }
            // item result

            // TODO sko implement loottable
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.DIAMOND));
        }
    }

}
