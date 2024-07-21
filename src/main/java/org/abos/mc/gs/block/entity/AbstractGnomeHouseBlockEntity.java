package org.abos.mc.gs.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.util.GnomeHouseInventory;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractGnomeHouseBlockEntity extends AbstractContainerBlock {

    protected static final int[] SLOTS = new int[] {0, 1};

    // TODO sko make this configurable
    protected static final int tickDelta = 20*30; // 30 seconds

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
            if (!(level instanceof ServerLevel) || level.dimension() != Level.OVERWORLD) {
                return;
            }
            // food condition
            // TODO sko change this to fuel
            if (houseEntity.getStackInSlot(GnomeHouseInventory.FOOD_SLOT).isEmpty()) {
                return;
            }
            // tool condition
            final ItemStack toolStack = houseEntity.getStackInSlot(GnomeHouseInventory.TOOL_SLOT);
            if (toolStack.isEmpty()) {
                return;
            }
            final String toolId = BuiltInRegistries.ITEM.getKey(toolStack.getItem()).toString().replace(':','/');
            // tier
            final String tier = houseEntity instanceof GnomeHouseTier3BlockEntity ? "tier3" : (houseEntity instanceof GnomeHouseTier2BlockEntity ? "tier2" : "tier1");
            // item result
            final LootTable lootTable = level.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "gnome/" + toolId + "/overworld/" + tier)));
            final LootParams lootParams = new LootParams.Builder((ServerLevel)level)
                    .withParameter(LootContextParams.ORIGIN, pos.getBottomCenter())
                    .withParameter(LootContextParams.BLOCK_ENTITY, houseEntity)
                    .create(LootContextParamSets.CHEST);
            final NonNullList<ItemStack> loot = NonNullList.copyOf(lootTable.getRandomItems(lootParams));
            // search for container below
            final BlockEntity be = level.getBlockEntity(pos.below());
            if (be instanceof Container container) {
                for (ItemStack itemStack : loot) {
                    for (int i = 0; i < container.getContainerSize(); i++) {
                        if (container.canPlaceItem(i, itemStack)) {
                            ItemStack containerStack = container.getItem(i);
                            if (containerStack.isEmpty()) {
                                containerStack = itemStack;
                            }
                            else {
                                containerStack.setCount(containerStack.getCount() + itemStack.getCount());
                            }
                            container.setItem(i, containerStack);
                            break;
                        }
                    }
                }
            }
//            else if (be instanceof IItemHandlerModifiable handler) {
//                for (ItemStack itemStack : loot) {
//                    for (int i = 0; i < handler.getSlots(); i++) {
//                        if (handler.isItemValid(i, itemStack)) {
//                            handler.insertItem(i, itemStack, false);
//                            break;
//                        }
//                    }
//                }
//            }
            else {
                Containers.dropContents(level, pos, loot);
            }
        }
    }

}
