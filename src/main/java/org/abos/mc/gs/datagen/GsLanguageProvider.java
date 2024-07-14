package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.abos.mc.gs.GnomeSupremacyMod;

public class GsLanguageProvider extends LanguageProvider {
    public GsLanguageProvider(PackOutput output) {
        super(output, GnomeSupremacyMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(GnomeSupremacyMod.INFUSED_STONE_BLOCK, "Infused Stone");
        addBlock(GnomeSupremacyMod.MITHRALIUM_STONE_BLOCK, "Mithralium Stone");
        add("itemGroup.gnome_supremacy", "Gnome Supremacy");
    }
}
