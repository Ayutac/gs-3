package org.abos.mc.gs.client.gui;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier1Menu;
import org.abos.mc.gs.util.TagCache;

import java.util.List;

public class GnomeHouseTier1Screen extends AbstractGnomeHouseScreen<GnomeHouseTier1Menu> {
    public GnomeHouseTier1Screen(GnomeHouseTier1Menu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected List<Holder<Item>> getFood() {
        return TagCache.getGnomeFoodTier1();
    }
}
