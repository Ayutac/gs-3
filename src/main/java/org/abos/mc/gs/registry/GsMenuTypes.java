package org.abos.mc.gs.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.block.entity.container.GnomeHouseMenu;

public interface GsMenuTypes {
    DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(BuiltInRegistries.MENU, GnomeSupremacy.MODID);

    DeferredHolder<MenuType<?>, ? extends MenuType<GnomeHouseMenu>> GNOME_HOUSE = REGISTER.register("gnome_house_menu",
            () -> new MenuType<>(GnomeHouseMenu::new, FeatureFlags.DEFAULT_FLAGS));

}
