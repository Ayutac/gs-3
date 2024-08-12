package org.abos.mc.gs.client.gui;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier3Menu;
import org.abos.mc.gs.util.TagCache;

import java.util.List;

public class GnomeHouseTier3Screen extends AbstractGnomeHouseScreen<GnomeHouseTier3Menu> {
    public GnomeHouseTier3Screen(GnomeHouseTier3Menu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected List<Holder<Item>> getFood() {
        return TagCache.getGnomeFoodTier3();
    }
}
