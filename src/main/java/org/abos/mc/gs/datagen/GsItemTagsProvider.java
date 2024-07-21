package org.abos.mc.gs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.abos.mc.gs.GnomeSupremacy;
import org.abos.mc.gs.registry.GsItems;
import org.abos.mc.gs.registry.GsTags;

import java.util.concurrent.CompletableFuture;

public class GsItemTagsProvider extends ItemTagsProvider {
    public GsItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, provider.contentsGetter(), GnomeSupremacy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.STAIRS).add(
                GsItems.INFUSED_STONE_STAIRS.get(),
                GsItems.POLISHED_INFUSED_STONE_STAIRS.get(),
                GsItems.CHISELED_INFUSED_STONE_STAIRS.get(),
                GsItems.MITHRALIUM_STONE_STAIRS.get(),
                GsItems.POLISHED_MITHRALIUM_STONE_STAIRS.get()
        );
        tag(ItemTags.SLABS).add(
                GsItems.INFUSED_STONE_SLAB.get(),
                GsItems.POLISHED_INFUSED_STONE_SLAB.get(),
                GsItems.CHISELED_INFUSED_STONE_SLAB.get(),
                GsItems.MITHRALIUM_STONE_SLAB.get(),
                GsItems.POLISHED_MITHRALIUM_STONE_SLAB.get()
        );
        tag(ItemTags.WALLS).add(
                GsItems.INFUSED_STONE_WALL.get(),
                GsItems.POLISHED_INFUSED_STONE_WALL.get(),
                GsItems.CHISELED_INFUSED_STONE_WALL.get(),
                GsItems.MITHRALIUM_STONE_WALL.get(),
                GsItems.POLISHED_MITHRALIUM_STONE_WALL.get()
        );
        tag(GsTags.GNOME_TOOLS).add(
                Items.IRON_PICKAXE,
                Items.IRON_SHOVEL,
                //Items.FISHING_ROD,
                Items.IRON_AXE,
                Items.SHEARS,
                Items.IRON_SWORD,
                Items.BRUSH,
                Items.TRIDENT,
                Items.LEAD,
                Items.IRON_HOE//,
                //Items.WRITABLE_BOOK
        );
        tag(GsTags.GNOME_TIER1_FOOD).add(Items.COOKED_PORKCHOP);
        tag(GsTags.GNOME_TIER2_FOOD).add(Items.COOKED_BEEF);
        tag(GsTags.GNOME_TIER3_FOOD).add(Items.GOLDEN_CARROT);
    }
}
