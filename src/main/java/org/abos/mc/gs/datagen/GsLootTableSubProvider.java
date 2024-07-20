package org.abos.mc.gs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.abos.mc.gs.registry.GsLootTables;

import java.util.function.BiConsumer;

public class GsLootTableSubProvider implements LootTableSubProvider {
    protected GsLootTableSubProvider(HolderLookup.Provider lookupProvider) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(
                GsLootTables.OVERWORLD_MINER1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.COAL).setWeight(55))
                        .add(LootItem.lootTableItem(Items.RAW_COPPER).setWeight(25))
                        .add(LootItem.lootTableItem(Items.RAW_IRON).setWeight(15))
                        .add(LootItem.lootTableItem(Items.FLINT).setWeight(5))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_MINER2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.COAL).setWeight(10))
                        .add(LootItem.lootTableItem(Items.RAW_COPPER).setWeight(20))
                        .add(LootItem.lootTableItem(Items.RAW_IRON).setWeight(20))
                        .add(LootItem.lootTableItem(Items.RAW_GOLD).setWeight(15))
                        .add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(30))
                        .add(LootItem.lootTableItem(Items.FLINT).setWeight(3))
                        .add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(2))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_MINER3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.COAL).setWeight(3))
                        .add(LootItem.lootTableItem(Items.RAW_COPPER).setWeight(15))
                        .add(LootItem.lootTableItem(Items.RAW_IRON).setWeight(15))
                        .add(LootItem.lootTableItem(Items.RAW_GOLD).setWeight(10))
                        .add(LootItem.lootTableItem(Items.LAPIS_LAZULI).setWeight(20))
                        .add(LootItem.lootTableItem(Items.FLINT).setWeight(2))
                        .add(LootItem.lootTableItem(Items.AMETHYST_SHARD).setWeight(4))
                        .add(LootItem.lootTableItem(Items.REDSTONE).setWeight(15))
                        .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(8))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(4))
                        .add(LootItem.lootTableItem(Items.OBSIDIAN).setWeight(4))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_EXCAVATOR1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.DIRT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.SAND).setWeight(5))
                        .add(LootItem.lootTableItem(Items.COBBLESTONE).setWeight(65))
                        .add(LootItem.lootTableItem(Items.ANDESITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.DIORITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GRANITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GRAVEL).setWeight(5))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_EXCAVATOR2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.DIRT).setWeight(5))
                        .add(LootItem.lootTableItem(Items.SAND).setWeight(5))
                        .add(LootItem.lootTableItem(Items.COBBLESTONE).setWeight(45))
                        .add(LootItem.lootTableItem(Items.ANDESITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.DIORITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GRANITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GRAVEL).setWeight(5))
                        .add(LootItem.lootTableItem(Items.CLAY).setWeight(3))
                        .add(LootItem.lootTableItem(Items.MOSS_BLOCK).setWeight(3))
                        .add(LootItem.lootTableItem(Items.BIG_DRIPLEAF).setWeight(1))
                        .add(LootItem.lootTableItem(Items.AZALEA).setWeight(1))
                        .add(LootItem.lootTableItem(Items.FLOWERING_AZALEA).setWeight(1))
                        .add(LootItem.lootTableItem(Items.GLOW_BERRIES).setWeight(1))
                        .add(LootItem.lootTableItem(Items.DRIPSTONE_BLOCK).setWeight(3))
                        .add(LootItem.lootTableItem(Items.POINTED_DRIPSTONE).setWeight(2))
                        .add(LootItem.lootTableItem(Items.COBBLED_DEEPSLATE).setWeight(8))
                        .add(LootItem.lootTableItem(Items.TUFF).setWeight(2))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_EXCAVATOR3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.DIRT).setWeight(5))
                        .add(LootItem.lootTableItem(Items.SAND).setWeight(5))
                        .add(LootItem.lootTableItem(Items.COBBLESTONE).setWeight(15))
                        .add(LootItem.lootTableItem(Items.ANDESITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.DIORITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GRANITE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GRAVEL).setWeight(5))
                        .add(LootItem.lootTableItem(Items.CLAY).setWeight(3))
                        .add(LootItem.lootTableItem(Items.MOSS_BLOCK).setWeight(3))
                        .add(LootItem.lootTableItem(Items.BIG_DRIPLEAF).setWeight(1))
                        .add(LootItem.lootTableItem(Items.AZALEA).setWeight(1))
                        .add(LootItem.lootTableItem(Items.FLOWERING_AZALEA).setWeight(1))
                        .add(LootItem.lootTableItem(Items.GLOW_BERRIES).setWeight(1))
                        .add(LootItem.lootTableItem(Items.DRIPSTONE_BLOCK).setWeight(3))
                        .add(LootItem.lootTableItem(Items.POINTED_DRIPSTONE).setWeight(2))
                        .add(LootItem.lootTableItem(Items.COBBLED_DEEPSLATE).setWeight(25))
                        .add(LootItem.lootTableItem(Items.TUFF).setWeight(5))
                        .add(LootItem.lootTableItem(Items.SCULK).setWeight(5))
                        .add(LootItem.lootTableItem(Items.SMOOTH_BASALT).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CALCITE).setWeight(2))
                        .add(LootItem.lootTableItem(Items.AMETHYST_BLOCK).setWeight(1))
                )
        );
        // TODO fisher
        biConsumer.accept(
                GsLootTables.OVERWORLD_LUMBERJACK1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.OAK_LOG).setWeight(49))
                        .add(LootItem.lootTableItem(Items.BIRCH_LOG).setWeight(49))
                        .add(LootItem.lootTableItem(Items.OAK_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BIRCH_SAPLING).setWeight(1))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_LUMBERJACK2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.OAK_LOG).setWeight(24))
                        .add(LootItem.lootTableItem(Items.BIRCH_LOG).setWeight(24))
                        .add(LootItem.lootTableItem(Items.ACACIA_LOG).setWeight(24))
                        .add(LootItem.lootTableItem(Items.DARK_OAK_LOG).setWeight(24))
                        .add(LootItem.lootTableItem(Items.SPRUCE_LOG).setWeight(24))
                        .add(LootItem.lootTableItem(Items.OAK_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BIRCH_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ACACIA_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.DARK_OAK_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SPRUCE_SAPLING).setWeight(1))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_LUMBERJACK3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.OAK_LOG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.BIRCH_LOG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.ACACIA_LOG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.DARK_OAK_LOG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.SPRUCE_LOG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.JUNGLE_LOG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.MANGROVE_LOG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.CHERRY_LOG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.OAK_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BIRCH_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ACACIA_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.DARK_OAK_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SPRUCE_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.JUNGLE_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MANGROVE_PROPAGULE).setWeight(1))
                        .add(LootItem.lootTableItem(Items.CHERRY_SAPLING).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BAMBOO).setWeight(10))
                        .add(LootItem.lootTableItem(Items.VINE).setWeight(2))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_SHEPHERD1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.MUTTON).setWeight(20))
                        .add(LootItem.lootTableItem(Items.WHITE_WOOL).setWeight(40))
                        .add(LootItem.lootTableItem(Items.LIGHT_GRAY_WOOL).setWeight(40))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_SHEPHERD2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.MUTTON).setWeight(10))
                        .add(LootItem.lootTableItem(Items.WHITE_WOOL).setWeight(15))
                        .add(LootItem.lootTableItem(Items.LIGHT_GRAY_WOOL).setWeight(15))
                        .add(LootItem.lootTableItem(Items.GRAY_WOOL).setWeight(15))
                        .add(LootItem.lootTableItem(Items.BLACK_WOOL).setWeight(15))
                        .add(LootItem.lootTableItem(Items.BROWN_WOOL).setWeight(15))
                        .add(LootItem.lootTableItem(Items.PINK_WOOL).setWeight(15))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_SHEPHERD3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.MUTTON).setWeight(4))
                        .add(LootItem.lootTableItem(Items.WHITE_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.LIGHT_GRAY_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.GRAY_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.BLACK_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.BROWN_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.RED_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.ORANGE_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.YELLOW_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.LIME_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.GREEN_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.PURPLE_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.BLUE_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.LIGHT_BLUE_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.MAGENTA_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.CYAN_WOOL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.PINK_WOOL).setWeight(6))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_MONSTER_HUNTER1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(40))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(40))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(20))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_MONSTER_HUNTER2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(35))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(35))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(10))
                        .add(LootItem.lootTableItem(Items.SPIDER_EYE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GUNPOWDER).setWeight(8))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL).setWeight(5))
                        .add(LootItem.lootTableItem(Items.ENDER_PEARL).setWeight(2))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_MONSTER_HUNTER3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(25))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(25))
                        .add(LootItem.lootTableItem(Items.STRING).setWeight(8))
                        .add(LootItem.lootTableItem(Items.SPIDER_EYE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.GUNPOWDER).setWeight(10))
                        .add(LootItem.lootTableItem(Items.SLIME_BALL).setWeight(9))
                        .add(LootItem.lootTableItem(Items.ENDER_PEARL).setWeight(9))
                        .add(LootItem.lootTableItem(Items.PHANTOM_MEMBRANE).setWeight(9))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_ARCHAEOLOGIST1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.BRICK).setWeight(20))
                        .add(LootItem.lootTableItem(Items.CRACKED_STONE_BRICKS).setWeight(18))
                        .add(LootItem.lootTableItem(Items.MOSSY_STONE_BRICKS).setWeight(18))
                        .add(LootItem.lootTableItem(Items.DAMAGED_ANVIL).setWeight(6))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(20))
                        .add(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(18))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_ARCHAEOLOGIST2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.BRICK).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ANGLER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ARCHER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ARMS_UP_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BLADE_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BREWER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BURN_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.DANGER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.EXPLORER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.FLOW_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.FRIEND_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.GUSTER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.HEART_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.HEARTBREAK_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.HOWL_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MINER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MOURNER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.PLENTY_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.PRIZE_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SCRAPE_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SHEAF_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SHELTER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SKULL_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SNORT_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.CRACKED_STONE_BRICKS).setWeight(8))
                        .add(LootItem.lootTableItem(Items.MOSSY_STONE_BRICKS).setWeight(8))
                        .add(LootItem.lootTableItem(Items.DAMAGED_ANVIL).setWeight(4))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(15))
                        .add(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(10))
                        .add(LootItem.lootTableItem(Items.CHARCOAL).setWeight(10))
                        .add(LootItem.lootTableItem(Items.TNT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.GOLD_NUGGET).setWeight(10))
                        .add(LootItem.lootTableItem(Items.BONE_BLOCK).setWeight(5))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_ARCHAEOLOGIST3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.BRICK).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ANGLER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ARCHER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ARMS_UP_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BLADE_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BREWER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BURN_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.DANGER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.EXPLORER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.FLOW_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.FRIEND_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.GUSTER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.HEART_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.HEARTBREAK_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.HOWL_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MINER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.MOURNER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.PLENTY_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.PRIZE_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SCRAPE_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SHEAF_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SHELTER_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SKULL_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.SNORT_POTTERY_SHERD).setWeight(1))
                        .add(LootItem.lootTableItem(Items.CRACKED_STONE_BRICKS).setWeight(6))
                        .add(LootItem.lootTableItem(Items.MOSSY_STONE_BRICKS).setWeight(6))
                        .add(LootItem.lootTableItem(Items.DAMAGED_ANVIL).setWeight(1))
                        .add(LootItem.lootTableItem(Items.BONE).setWeight(10))
                        .add(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(10))
                        .add(LootItem.lootTableItem(Items.CHARCOAL).setWeight(9))
                        .add(LootItem.lootTableItem(Items.TNT).setWeight(9))
                        .add(LootItem.lootTableItem(Items.GOLD_NUGGET).setWeight(10))
                        .add(LootItem.lootTableItem(Items.BONE_BLOCK).setWeight(5))
                        .add(LootItem.lootTableItem(Items.SKELETON_SKULL).setWeight(3))
                        .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(6))
                        .add(LootItem.lootTableItem(Items.EMERALD).setWeight(10))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_DEEP_SEA_DRIVER1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(40))
                        .add(LootItem.lootTableItem(Items.KELP).setWeight(40))
                        .add(LootItem.lootTableItem(Items.GLOW_INK_SAC).setWeight(20))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_DEEP_SEA_DRIVER2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(25))
                        .add(LootItem.lootTableItem(Items.KELP).setWeight(25))
                        .add(LootItem.lootTableItem(Items.GLOW_INK_SAC).setWeight(15))
                        .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.PRISMARINE_SHARD).setWeight(15))
                        .add(LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS).setWeight(10))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_DEEP_SEA_DRIVER3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.ROTTEN_FLESH).setWeight(15))
                        .add(LootItem.lootTableItem(Items.KELP).setWeight(15))
                        .add(LootItem.lootTableItem(Items.GLOW_INK_SAC).setWeight(10))
                        .add(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.PRISMARINE_SHARD).setWeight(20))
                        .add(LootItem.lootTableItem(Items.PRISMARINE_CRYSTALS).setWeight(15))
                        .add(LootItem.lootTableItem(Items.WET_SPONGE).setWeight(10))
                        .add(LootItem.lootTableItem(Items.HEART_OF_THE_SEA).setWeight(4))
                        .add(LootItem.lootTableItem(Items.TRIDENT).setWeight(1))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_RANCHER1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.PORKCHOP).setWeight(40))
                        .add(LootItem.lootTableItem(Items.CHICKEN).setWeight(30))
                        .add(LootItem.lootTableItem(Items.FEATHER).setWeight(20))
                        .add(LootItem.lootTableItem(Items.EGG).setWeight(10))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_RANCHER1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.PORKCHOP).setWeight(40))
                        .add(LootItem.lootTableItem(Items.CHICKEN).setWeight(30))
                        .add(LootItem.lootTableItem(Items.FEATHER).setWeight(20))
                        .add(LootItem.lootTableItem(Items.EGG).setWeight(10))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_RANCHER2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.PORKCHOP).setWeight(20))
                        .add(LootItem.lootTableItem(Items.CHICKEN).setWeight(15))
                        .add(LootItem.lootTableItem(Items.FEATHER).setWeight(10))
                        .add(LootItem.lootTableItem(Items.EGG).setWeight(5))
                        .add(LootItem.lootTableItem(Items.BEEF).setWeight(25))
                        .add(LootItem.lootTableItem(Items.LEATHER).setWeight(25))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_RANCHER3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.PORKCHOP).setWeight(10))
                        .add(LootItem.lootTableItem(Items.CHICKEN).setWeight(8))
                        .add(LootItem.lootTableItem(Items.FEATHER).setWeight(5))
                        .add(LootItem.lootTableItem(Items.EGG).setWeight(2))
                        .add(LootItem.lootTableItem(Items.BEEF).setWeight(25))
                        .add(LootItem.lootTableItem(Items.LEATHER).setWeight(35))
                        .add(LootItem.lootTableItem(Items.RABBIT).setWeight(8))
                        .add(LootItem.lootTableItem(Items.RABBIT_HIDE).setWeight(5))
                        .add(LootItem.lootTableItem(Items.RABBIT_FOOT).setWeight(2))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_FARMER1,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.WHEAT).setWeight(20))
                        .add(LootItem.lootTableItem(Items.CARROT).setWeight(20))
                        .add(LootItem.lootTableItem(Items.POTATO).setWeight(20))
                        .add(LootItem.lootTableItem(Items.BEETROOT).setWeight(20))
                        .add(LootItem.lootTableItem(Items.BONE_MEAL).setWeight(10))
                        .add(LootItem.lootTableItem(Items.DIRT).setWeight(10))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_FARMER2,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.WHEAT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.CARROT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.POTATO).setWeight(10))
                        .add(LootItem.lootTableItem(Items.BEETROOT).setWeight(10))
                        .add(LootItem.lootTableItem(Items.BONE_MEAL).setWeight(5))
                        .add(LootItem.lootTableItem(Items.DIRT).setWeight(5))
                        .add(LootItem.lootTableItem(Items.MELON).setWeight(15))
                        .add(LootItem.lootTableItem(Items.PUMPKIN).setWeight(15))
                        .add(LootItem.lootTableItem(Items.COCOA_BEANS).setWeight(10))
                        .add(LootItem.lootTableItem(Items.CACTUS).setWeight(5))
                        .add(LootItem.lootTableItem(Items.COARSE_DIRT).setWeight(5))
                )
        );
        biConsumer.accept(
                GsLootTables.OVERWORLD_FARMER3,
                LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                        .add(LootItem.lootTableItem(Items.WHEAT).setWeight(6))
                        .add(LootItem.lootTableItem(Items.CARROT).setWeight(6))
                        .add(LootItem.lootTableItem(Items.POTATO).setWeight(6))
                        .add(LootItem.lootTableItem(Items.BEETROOT).setWeight(6))
                        .add(LootItem.lootTableItem(Items.BONE_MEAL).setWeight(5))
                        .add(LootItem.lootTableItem(Items.DIRT).setWeight(3))
                        .add(LootItem.lootTableItem(Items.MELON).setWeight(6))
                        .add(LootItem.lootTableItem(Items.PUMPKIN).setWeight(6))
                        .add(LootItem.lootTableItem(Items.COCOA_BEANS).setWeight(6))
                        .add(LootItem.lootTableItem(Items.CACTUS).setWeight(5))
                        .add(LootItem.lootTableItem(Items.COARSE_DIRT).setWeight(3))
                        .add(LootItem.lootTableItem(Items.BROWN_MUSHROOM).setWeight(6))
                        .add(LootItem.lootTableItem(Items.RED_MUSHROOM).setWeight(6))
                        .add(LootItem.lootTableItem(Items.SWEET_BERRIES).setWeight(6))
                        .add(LootItem.lootTableItem(Items.GLOW_BERRIES).setWeight(6))
                        .add(LootItem.lootTableItem(Items.HONEY_BLOCK).setWeight(4))
                        .add(LootItem.lootTableItem(Items.HONEYCOMB).setWeight(6))
                        .add(LootItem.lootTableItem(Items.HONEYCOMB).setWeight(6))
                        .add(LootItem.lootTableItem(Items.BEEHIVE).setWeight(1))
                        .add(LootItem.lootTableItem(Items.ROOTED_DIRT).setWeight(3))
                )
        );
        // TODO scientist
    }
}