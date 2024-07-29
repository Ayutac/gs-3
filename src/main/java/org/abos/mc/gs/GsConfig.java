package org.abos.mc.gs;

import java.util.Set;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = GnomeSupremacy.MODID, bus = EventBusSubscriber.Bus.MOD)
public class GsConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

//    private static final ModConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
//            .comment("Whether to log the dirt block on common setup")
//            .define("logDirtBlock", true);

    public static final ModConfigSpec.IntValue GNOME_DROP_TICKS = BUILDER
            .comment("Duration between Gnome drops in ticks")
            .defineInRange("gnomeDropTicks", 20*30, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue GNOME_FOOD_WORK = BUILDER
            .comment("How many drops a Gnome gives for one food item")
            .defineInRange("gnomeFoodWork", 8, 1, Integer.MAX_VALUE);

//    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
//            .comment("What you want the introduction message to be for the magic number")
//            .define("magicNumberIntroduction", "The magic number is... ");

//    // a list of strings that are treated as resource locations for items
//    private static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
//            .comment("A list of items to log on common setup.")
//            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), GsConfig::validateItemName);

    static final ModConfigSpec SPEC = BUILDER.build();

//    public static boolean logDirtBlock;
//    public static int magicNumber;
//    public static String magicNumberIntroduction;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
//        logDirtBlock = LOG_DIRT_BLOCK.get();
//        magicNumber = MAGIC_NUMBER.get();
//        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // convert the list of strings into a set of items
//        items = ITEM_STRINGS.get().stream()
//                .map(itemName -> BuiltInRegistries.ITEM.get(ResourceLocation.parse(itemName)))
//                .collect(Collectors.toSet());
    }
}
