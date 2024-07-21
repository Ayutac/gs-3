# Modpack Use
So you want Gnome Supremacy in your modpack? Great! Here are some pointers that might help.

## Gnomes
### Food
Gnome housings are separated into three tiers (tier 1 = hut, tier 2 = house, tier 3 = villa), and each tier requires different food.
These foods are designed to be more difficult to acquire, and you can set them by overwriting the item tags `gnome_supremacy:gnome_tier1_food`, `gnome_supremacy:gnome_tier2_food` and `gnome_supremacy:gnome_tier3_food`.

### Tools and Loot
Possible tools to trigger different loot tables are given by the item tag `gnome_supremacy:gnome_tools`.
* If you remove a tool from this tag, you don't *need* to remove the corresponding loot tables.
* If you add a tool to this tag, you *must* add the corresponding loot tables or the game might crash.

For example, if you add a loot table for your custom item `my_mod:my_item` you need loot tables under `gnome_supremacy:gnome/my_mod/my_item/overworld/tier1`, `gnome_supremacy:gnome/my_mod/my_item/overworld/tier2` and `gnome_supremacy:gnome/my_mod/my_item/overworld/tier3`.

## Tree Mushrooms
The block tag `gnome_supremacy:tree_mushroom_plantable_on` defines where tree mushrooms can be planted on.