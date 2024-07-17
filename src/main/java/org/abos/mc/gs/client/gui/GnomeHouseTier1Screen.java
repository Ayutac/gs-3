package org.abos.mc.gs.client.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier1Menu;

public class GnomeHouseTier1Screen extends AbstractGnomeHouseScreen<GnomeHouseTier1Menu> {
    public GnomeHouseTier1Screen(GnomeHouseTier1Menu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }
}
