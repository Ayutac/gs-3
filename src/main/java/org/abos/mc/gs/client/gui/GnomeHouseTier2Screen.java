package org.abos.mc.gs.client.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier2Menu;

public class GnomeHouseTier2Screen extends AbstractGnomeHouseScreen<GnomeHouseTier2Menu> {
    public GnomeHouseTier2Screen(GnomeHouseTier2Menu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }
}
