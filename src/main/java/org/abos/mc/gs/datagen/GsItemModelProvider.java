package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.GsItems;

public class GsItemModelProvider extends ItemModelProvider {

    public GsItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GnomeSupremacyMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(GsItems.INFUSED_STONE.getRegisteredName(), blockLoc(GsItems.INFUSED_STONE));
        withExistingParent(GsItems.MITHRALIUM_STONE.getRegisteredName(), blockLoc(GsItems.MITHRALIUM_STONE));
    }

    protected ResourceLocation blockLoc(DeferredItem<BlockItem> itemRef) {
        return modLoc("block/" + itemRef.getId().getPath());
    }
}
