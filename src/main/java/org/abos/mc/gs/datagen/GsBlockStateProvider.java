package org.abos.mc.gs.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.GsBlocks;

public class GsBlockStateProvider extends BlockStateProvider {
    public GsBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GnomeSupremacyMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(GsBlocks.INFUSED_STONE.get());
        simpleBlock(GsBlocks.MITHRALIUM_STONE.get());
    }
}
