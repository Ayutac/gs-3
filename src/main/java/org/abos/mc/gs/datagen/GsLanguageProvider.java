package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.registry.GsBlocks;

public class GsLanguageProvider extends LanguageProvider {
    public GsLanguageProvider(PackOutput output) {
        super(output, GnomeSupremacy.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(GsBlocks.GNOME_HOUSE_TIER1, "Gnome Hut");
        add("container.gnome_house_tier1", "Gnome Hut");
        addBlock(GsBlocks.GNOME_HOUSE_TIER2, "Gnome House");
        add("container.gnome_house_tier2", "Gnome House");
        addBlock(GsBlocks.GNOME_HOUSE_TIER3, "Gnome Villa");
        add("container.gnome_house_tier3", "Gnome Villa");
        addBlock(GsBlocks.PINK_BONNET, "Pink Bonnet");
        addBlock(GsBlocks.POTTED_PINK_BONNET, "Potted Pink Bonnet");
        addBlock(GsBlocks.PINK_BONNET_STEM_BLOCK, "Pink Bonnet Stem Block");
        addBlock(GsBlocks.PINK_BONNET_BLOCK, "Pink Bonnet Block");
        addBlock(GsBlocks.LAPIS_DECEIVER, "Lapis Deceiver");
        addBlock(GsBlocks.POTTED_LAPIS_DECEIVER, "Potted Lapis Deceiver");
        addBlock(GsBlocks.LAPIS_DECEIVER_STEM_BLOCK, "Lapis Deceiver Stem Block");
        addBlock(GsBlocks.LAPIS_DECEIVER_BLOCK, "Lapis Deceiver Block");
        addBlock(GsBlocks.MOREL, "Morel");
        addBlock(GsBlocks.POTTED_MOREL, "Potted Morel");
        addBlock(GsBlocks.MOREL_BLOCK, "Morel Block");
        addBlock(GsBlocks.VIERTOUW_MUSHROOM, "Viertouw Mushroom");
        addBlock(GsBlocks.POTTED_VIERTOUW_MUSHROOM, "Potted Viertouw Mushroom");
        addBlock(GsBlocks.VIERTOUW_MUSHROOM_BLOCK, "Viertouw Mushroom Block");
        addBlock(GsBlocks.PINK_VIERTOUW_MUSHROOM_BLOCK, "Pink Viertouw Mushroom Block");
        addBlock(GsBlocks.TURKEY_TAIL, "Turkey Tail");
        addBlock(GsBlocks.CHICKEN_OF_THE_WOODS, "Chicken of the Woods");
        addBlock(GsBlocks.INFUSED_STONE, "Infused Stone");
        addBlock(GsBlocks.INFUSED_STONE_STAIRS, "Infused Stone Stairs");
        addBlock(GsBlocks.INFUSED_STONE_SLAB, "Infused Stone Slab");
        addBlock(GsBlocks.INFUSED_STONE_WALL, "Infused Stone Wall");
        addBlock(GsBlocks.POLISHED_INFUSED_STONE, "Polished Infused Stone");
        addBlock(GsBlocks.POLISHED_INFUSED_STONE_STAIRS, "Polished Infused Stone Stairs");
        addBlock(GsBlocks.POLISHED_INFUSED_STONE_SLAB, "Polished Infused Stone Slab");
        addBlock(GsBlocks.POLISHED_INFUSED_STONE_WALL, "Polished Infused Stone Wall");
        addBlock(GsBlocks.TILED_INFUSED_STONE, "Tiled Infused Stone");
        addBlock(GsBlocks.TILED_INFUSED_STONE_STAIRS, "Tiled Infused Stone Stairs");
        addBlock(GsBlocks.TILED_INFUSED_STONE_SLAB, "Tiled Infused Stone Slab");
        addBlock(GsBlocks.TILED_INFUSED_STONE_WALL, "Tiled Infused Stone Wall");
        addBlock(GsBlocks.MITHRALIUM_STONE, "Mithralium Stone");
        addBlock(GsBlocks.MITHRALIUM_STONE_STAIRS, "Mithralium Stone Stairs");
        addBlock(GsBlocks.MITHRALIUM_STONE_SLAB, "Mithralium Stone Slab");
        addBlock(GsBlocks.MITHRALIUM_STONE_WALL, "Mithralium Stone Wall");
        addBlock(GsBlocks.POLISHED_MITHRALIUM_STONE, "Polished Mithralium Stone");
        addBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_STAIRS, "Polished Mithralium Stone Stairs");
        addBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_SLAB, "Polished Mithralium Stone Slab");
        addBlock(GsBlocks.POLISHED_MITHRALIUM_STONE_WALL, "Polished Mithralium Stone Wall");
        addBlock(GsBlocks.MITHRALIUM_PILLAR, "Mithralium Pillar");
        addBlock(GsBlocks.GNOME_TELEPORTER, "Gnome Teleporter");
        add("itemGroup.gnome_supremacy", "Gnome Supremacy");
    }
}
