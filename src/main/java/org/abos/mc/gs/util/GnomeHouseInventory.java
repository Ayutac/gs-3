package org.abos.mc.gs.util;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.abos.mc.gs.registry.GsTags;

public class GnomeHouseInventory extends ItemStackHandler {

    public static final int FOOD_SLOT = 0;
    public static final int TOOL_SLOT = 1;

    private final TagKey<Item> foodTag;

    public GnomeHouseInventory(TagKey<Item> foodTag) {
        super(2);
        this.foodTag = foodTag;
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        if (slot == FOOD_SLOT) {
            return stack.is(foodTag);
        }
        else if (slot == TOOL_SLOT) {
            return stack.is(GsTags.GNOME_TOOLS);
        }
        return false;
    }

    @Override
    public int getSlotLimit(int slot) {
        if (slot == TOOL_SLOT) {
            return 1;
        }
        return super.getSlotLimit(slot);
    }
}
