package org.abos.mc.gs.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacyMod;
import org.abos.mc.gs.block.entity.GnomeHouseBlockEntity;

public interface GsBlockEntityTypes {
    DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, GnomeSupremacyMod.MODID);

    DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<GnomeHouseBlockEntity>> GNOME_HOUSE = REGISTER.register("gnome_house",
            () -> BlockEntityType.Builder.of(GnomeHouseBlockEntity::new, GsBlocks.GNOME_HOUSE_TIER1.get()).build(null));

}
