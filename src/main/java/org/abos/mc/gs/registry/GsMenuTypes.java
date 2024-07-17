package org.abos.mc.gs.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier1Menu;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier2Menu;
import org.abos.mc.gs.block.entity.container.GnomeHouseTier3Menu;

public interface GsMenuTypes {
    DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.MENU, GnomeSupremacy.MODID);

    DeferredHolder<MenuType<?>, ? extends MenuType<GnomeHouseTier1Menu>> GNOME_HOUSE_TIER1 = REGISTER.register("gnome_house_tier1",
            () -> new MenuType<>(GnomeHouseTier1Menu::new, FeatureFlags.DEFAULT_FLAGS));
    DeferredHolder<MenuType<?>, ? extends MenuType<GnomeHouseTier2Menu>> GNOME_HOUSE_TIER2 = REGISTER.register("gnome_house_tier2",
            () -> new MenuType<>(GnomeHouseTier2Menu::new, FeatureFlags.DEFAULT_FLAGS));
    DeferredHolder<MenuType<?>, ? extends MenuType<GnomeHouseTier3Menu>> GNOME_HOUSE_TIER3 = REGISTER.register("gnome_house_tier3",
            () -> new MenuType<>(GnomeHouseTier3Menu::new, FeatureFlags.DEFAULT_FLAGS));

}
