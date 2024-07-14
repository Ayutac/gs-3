package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.GsBlocks;

public class GsLanguageProvider extends LanguageProvider {
    public GsLanguageProvider(PackOutput output) {
        super(output, GnomeSupremacyMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(GsBlocks.INFUSED_STONE, "Infused Stone");
        addBlock(GsBlocks.MITHRALIUM_STONE, "Mithralium Stone");
        add("itemGroup.gnome_supremacy", "Gnome Supremacy");
    }
}
