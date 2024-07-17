package org.abos.mc.gs.client.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier3Menu;

public class GnomeHouseTier3Screen extends AbstractGnomeHouseScreen<GnomeHouseTier3Menu> {
    public GnomeHouseTier3Screen(GnomeHouseTier3Menu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }
}
