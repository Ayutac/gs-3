package org.abos.mc.gs.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.block.entity.container.GnomeHouseMenu;

public class GnomeHouseScreen extends AbstractContainerScreen<GnomeHouseMenu> {
    private static final ResourceLocation CONTAINER_LOCATION = ResourceLocation.fromNamespaceAndPath(GnomeSupremacyMod.MODID, "textures/gui/container/gnome_house.png");
    public GnomeHouseScreen(GnomeHouseMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(CONTAINER_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }
}
