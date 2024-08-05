package org.abos.mc.gs;

import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import org.abos.mc.gs.client.gui.GnomeHouseTier1Screen;
import org.abos.mc.gs.client.gui.GnomeHouseTier2Screen;
import org.abos.mc.gs.client.gui.GnomeHouseTier3Screen;
import org.abos.mc.gs.registry.GsBlockEntityTypes;
import org.abos.mc.gs.registry.GsBlocks;
import org.abos.mc.gs.registry.GsFeatures;
import org.abos.mc.gs.registry.GsItems;
import org.abos.mc.gs.registry.GsLootTables;
import org.abos.mc.gs.registry.GsMenuTypes;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(GnomeSupremacy.MODID)
public class GnomeSupremacy {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gnome_supremacy";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the MODID namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    //    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
//    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
//            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    // Creates a creative tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_MODE_TABS.register(MODID, () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + MODID)) //The language key for the title of the CreativeModeTab
            .icon(Items.RED_MUSHROOM_BLOCK::getDefaultInstance)
            .displayItems((parameters, output) -> { // for own tabs, this method is preferred over the event
                output.accept(GsItems.GNOME_HOUSE_TIER1.get());
                output.accept(GsItems.GNOME_HOUSE_TIER2.get());
                output.accept(GsItems.GNOME_HOUSE_TIER3.get());
                output.accept(GsItems.PINK_BONNET.get());
                output.accept(GsItems.PINK_BONNET_STEM_BLOCK.get());
                output.accept(GsItems.PINK_BONNET_BLOCK.get());
                output.accept(GsItems.LAPIS_DECEIVER.get());
                output.accept(GsItems.LAPIS_DECEIVER_STEM_BLOCK.get());
                output.accept(GsItems.LAPIS_DECEIVER_BLOCK.get());
                output.accept(GsItems.MOREL.get());
                output.accept(GsItems.MOREL_BLOCK.get());
                output.accept(GsItems.VIERTOUW_MUSHROOM.get());
                output.accept(GsItems.VIERTOUW_MUSHROOM_BLOCK.get());
                output.accept(GsItems.PINK_VIERTOUW_MUSHROOM_BLOCK.get());
                output.accept(GsItems.TURKEY_TAIL.get());
                output.accept(GsItems.CHICKEN_OF_THE_WOODS.get());
                output.accept(GsItems.INFUSED_STONE.get());
                output.accept(GsItems.INFUSED_STONE_STAIRS.get());
                output.accept(GsItems.INFUSED_STONE_SLAB.get());
                output.accept(GsItems.INFUSED_STONE_WALL.get());
                output.accept(GsItems.POLISHED_INFUSED_STONE.get());
                output.accept(GsItems.POLISHED_INFUSED_STONE_STAIRS.get());
                output.accept(GsItems.POLISHED_INFUSED_STONE_SLAB.get());
                output.accept(GsItems.POLISHED_INFUSED_STONE_WALL.get());
                output.accept(GsItems.CHISELED_INFUSED_STONE.get());
                output.accept(GsItems.CHISELED_INFUSED_STONE_STAIRS.get());
                output.accept(GsItems.CHISELED_INFUSED_STONE_SLAB.get());
                output.accept(GsItems.CHISELED_INFUSED_STONE_WALL.get());
                output.accept(GsItems.MITHRALIUM_STONE.get());
                output.accept(GsItems.MITHRALIUM_STONE_STAIRS.get());
                output.accept(GsItems.MITHRALIUM_STONE_SLAB.get());
                output.accept(GsItems.MITHRALIUM_STONE_WALL.get());
                output.accept(GsItems.POLISHED_MITHRALIUM_STONE.get());
                output.accept(GsItems.POLISHED_MITHRALIUM_STONE_STAIRS.get());
                output.accept(GsItems.POLISHED_MITHRALIUM_STONE_SLAB.get());
                output.accept(GsItems.POLISHED_MITHRALIUM_STONE_WALL.get());
                output.accept(GsItems.MITHRALIUM_PILLAR.get());
                output.accept(GsItems.GNOME_TELEPORTER.get());
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public GnomeSupremacy(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        GsFeatures.REGISTER.register(modEventBus);
        GsBlocks.REGISTER.register(modEventBus);
        GsBlockEntityTypes.REGISTER.register(modEventBus);
        GsItems.REGISTER.register(modEventBus);
        GsMenuTypes.REGISTER.register(modEventBus);
        GsLootTables.class.getName(); // for static initialization only

        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class to respond directly to events.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, GsConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
        pot.addPlant(GsBlocks.PINK_BONNET.getId(), GsBlocks.POTTED_PINK_BONNET);
        pot.addPlant(GsBlocks.LAPIS_DECEIVER.getId(), GsBlocks.POTTED_LAPIS_DECEIVER);
        pot.addPlant(GsBlocks.MOREL.getId(), GsBlocks.POTTED_MOREL);
        pot.addPlant(GsBlocks.VIERTOUW_MUSHROOM.getId(), GsBlocks.POTTED_VIERTOUW_MUSHROOM);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(EXAMPLE_BLOCK_ITEM);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Nothing needed
    }

    @SubscribeEvent
    public void addWandererTrades(WandererTradesEvent event) {
        event.getGenericTrades().add(new VillagerTrades.ItemsForEmeralds(GsItems.PINK_BONNET.get(), 1, 1,12, 1));
        event.getGenericTrades().add(new VillagerTrades.ItemsForEmeralds(GsItems.LAPIS_DECEIVER.get(), 1, 1,12, 1));
        event.getGenericTrades().add(new VillagerTrades.ItemsForEmeralds(GsItems.MOREL.get(), 1, 1,12, 1));
        event.getGenericTrades().add(new VillagerTrades.ItemsForEmeralds(GsItems.VIERTOUW_MUSHROOM.get(), 1, 1,12, 1));
        event.getGenericTrades().add(new VillagerTrades.ItemsForEmeralds(GsItems.TURKEY_TAIL.get(), 1, 1,12, 1));
        event.getGenericTrades().add(new VillagerTrades.ItemsForEmeralds(GsItems.CHICKEN_OF_THE_WOODS.get(), 1, 1,12, 1));
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }

        @SubscribeEvent
        private static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(GsMenuTypes.GNOME_HOUSE_TIER1.get(), GnomeHouseTier1Screen::new);
            event.register(GsMenuTypes.GNOME_HOUSE_TIER2.get(), GnomeHouseTier2Screen::new);
            event.register(GsMenuTypes.GNOME_HOUSE_TIER3.get(), GnomeHouseTier3Screen::new);
        }

        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
//            event.registerBlockEntityRenderer(GsBlockEntityTypes.GNOME_HOUSE.get(), GnomeHouseRenderer::new);
        }
    }
}
