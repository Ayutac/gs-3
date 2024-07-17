package org.abos.mc.gs.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.block.entity.GnomeHouseTier1BlockEntity;
import org.abos.mc.gs.block.entity.GnomeHouseTier2BlockEntity;
import org.abos.mc.gs.block.entity.GnomeHouseTier3BlockEntity;

public interface GsBlockEntityTypes {
    DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, GnomeSupremacy.MODID);

    DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<GnomeHouseTier1BlockEntity>> GNOME_HOUSE_TIER1 = REGISTER.register("gnome_house_tier1",
            () -> BlockEntityType.Builder.of(GnomeHouseTier1BlockEntity::new, GsBlocks.GNOME_HOUSE_TIER1.get()).build(null));
    DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<GnomeHouseTier2BlockEntity>> GNOME_HOUSE_TIER2 = REGISTER.register("gnome_house_tier2",
            () -> BlockEntityType.Builder.of(GnomeHouseTier2BlockEntity::new, GsBlocks.GNOME_HOUSE_TIER2.get()).build(null));
    DeferredHolder<BlockEntityType<?>, ? extends BlockEntityType<GnomeHouseTier3BlockEntity>> GNOME_HOUSE_TIER3 = REGISTER.register("gnome_house_tier3",
            () -> BlockEntityType.Builder.of(GnomeHouseTier3BlockEntity::new, GsBlocks.GNOME_HOUSE_TIER3.get()).build(null));

}
