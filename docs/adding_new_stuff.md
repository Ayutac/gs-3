# How to add stuff

## Huge Mushroom Blocks
1. Add to `GsBlocks`
2. Add to `GsItems`
3. Add to creative menu in `GnomeSupremacy`
4. Add to `GsBlockLootSubProvider`
5. Add to `GsBlockTagsProvider`
6. Add to `GsLanguageProvider`
7. Add texture
8. Add blockstates, block model and item model manually (copy-paste)
9. Run datagen

## Small Mushrooms
1. Add to `GsBlocks` (and mind the `ConfiguredFeature`)
2. Add to `GsItems`
3. Add to creative menu in `GnomeSupremacy`
4. Add to `GsBlockLootSubProvider`
5. Add to `GsBlockStateProvider`
6. Add to `GsBlockTagsProvider`
7. Add to `GsItemModelProvider`
8. Add to `GsLanguageProvider`
9. Add texture (under blocks, not items)
10. Run datagen

## Mushroom feature
1. Add to `GsConfiguredFeatures`
2. Add to `GsFeatures` (that is the feature *type*)
3. Maybe update which small mushroom grows into it in `GsBlocks`
4. Implement Feature (type) in `worldgen` package
5. Add JSON to `configured_feature`