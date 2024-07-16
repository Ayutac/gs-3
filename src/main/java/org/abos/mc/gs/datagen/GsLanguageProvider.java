package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.registry.GsBlocks;

public class GsLanguageProvider extends LanguageProvider {
    public GsLanguageProvider(PackOutput output) {
        super(output, GnomeSupremacyMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(GsBlocks.GNOME_HOUSE_TIER1, "Gnome Hut");
        addBlock(GsBlocks.PINK_BONNET, "Pink Bonnet");
        addBlock(GsBlocks.PINK_BONNET_BLOCK, "Pink Bonnet Block");
        addBlock(GsBlocks.LAPIS_DECEIVER, "Lapis Deceiver");
        addBlock(GsBlocks.LAPIS_DECEIVER_BLOCK, "Lapis Deceiver Block");
        addBlock(GsBlocks.MOREL, "Morel");
        addBlock(GsBlocks.MOREL_BLOCK, "Morel Block");
        addBlock(GsBlocks.INFUSED_STONE, "Infused Stone");
        addBlock(GsBlocks.INFUSED_STONE_STAIRS, "Infused Stone Stairs");
        addBlock(GsBlocks.INFUSED_STONE_SLAB, "Infused Stone Slab");
        addBlock(GsBlocks.INFUSED_STONE_WALL, "Infused Stone Wall");
        addBlock(GsBlocks.MITHRALIUM_STONE, "Mithralium Stone");
        addBlock(GsBlocks.MITHRALIUM_STONE_STAIRS, "Mithralium Stone Stairs");
        addBlock(GsBlocks.MITHRALIUM_STONE_SLAB, "Mithralium Stone Slab");
        addBlock(GsBlocks.MITHRALIUM_STONE_WALL, "Mithralium Stone Wall");
        add("itemGroup.gnome_supremacy", "Gnome Supremacy");
        add("container.gnome_house", "Gnome Housing");
    }
}
