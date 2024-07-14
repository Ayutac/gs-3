package org.abos.mc.gs;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface GsBlocks {
    // Create a Deferred Register to hold Blocks which will all be registered under the MODID namespace
    DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GnomeSupremacyMod.MODID);

    DeferredBlock<Block> INFUSED_STONE = BLOCKS.registerSimpleBlock("infused_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    DeferredBlock<Block> MITHRALIUM_STONE = BLOCKS.registerSimpleBlock("mithralium_stone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
}
