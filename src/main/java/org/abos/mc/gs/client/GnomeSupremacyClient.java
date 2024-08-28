package org.abos.mc.gs.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import org.abos.mc.gs.GnomeSupremacy;

@Mod(value = GnomeSupremacy.MODID, dist = Dist.CLIENT)
public class GnomeSupremacyClient {

    public GnomeSupremacyClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

}
