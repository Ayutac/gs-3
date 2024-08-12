package org.abos.mc.gs.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.block.entity.container.AbstractGnomeHouseMenu;
import org.abos.mc.gs.registry.GsTags;
import org.abos.mc.gs.util.TagCache;

import java.util.List;

public abstract class AbstractGnomeHouseScreen<M extends AbstractGnomeHouseMenu> extends AbstractContainerScreen<M> {

    private static final ResourceLocation CONTAINER_LOCATION = ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "textures/gui/container/gnome_house.png");
    private static final ResourceLocation ANIMATION_LOCATION = ResourceLocation.fromNamespaceAndPath(GnomeSupremacy.MODID, "textures/gui/gnome_house_animation.png");

    protected AbstractGnomeHouseScreen(M menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(CONTAINER_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
        final double progress = menu.getTickProgress();
        final int frame = menu.hasFood() && menu.hasTool() ? (int)Math.floor(14 * progress) : 0;
        guiGraphics.blit(ANIMATION_LOCATION, i + 55, j + 55, 0, 15 * frame, 66, 15, 66, 210);
        List<Holder<Item>> foodList = getFood();
        final Holder<Item> food = foodList.get((int)Math.floor(foodList.size() * progress));
        guiGraphics.renderFakeItem(new ItemStack(food), i + 62, j + 17);
        List<Holder<Item>> toolList = TagCache.getGnomeTools();
        final Holder<Item> tool = toolList.get((int)Math.floor(toolList.size() * progress));
        guiGraphics.renderFakeItem(new ItemStack(tool), i + 98, j + 17);
    }

    protected abstract List<Holder<Item>> getFood();
}
