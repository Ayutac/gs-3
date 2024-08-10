package org.abos.mc.gs.block.entity.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import org.abos.mc.gs.registry.GsBlocks;
import org.abos.mc.gs.registry.GsMenuTypes;
import org.abos.mc.gs.registry.GsTags;

public class GnomeHouseTier2Menu extends AbstractGnomeHouseMenu {
    public GnomeHouseTier2Menu(int containerId, Inventory playerInv) {
        super(GsMenuTypes.GNOME_HOUSE_TIER2.get(), containerId, playerInv);
    }

    public GnomeHouseTier2Menu(int containerId, Inventory playerInv, IItemHandler dataInventory, ContainerData data, ContainerLevelAccess access) {
        super(GsMenuTypes.GNOME_HOUSE_TIER2.get(), containerId, playerInv, dataInventory, data, access);
    }

    @Override
    public boolean stillValid(Player player) {
        return AbstractContainerMenu.stillValid(this.access, player, GsBlocks.GNOME_HOUSE_TIER2.get());
    }

    @Override
    protected boolean checkFoodTag(ItemStack stack) {
        return stack.is(GsTags.GNOME_TIER2_FOOD);
    }
}
