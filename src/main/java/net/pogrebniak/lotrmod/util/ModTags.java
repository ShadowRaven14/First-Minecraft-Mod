package net.pogrebniak.lotrmod.util;

import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.pogrebniak.lotrmod.LotrMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_MITHRIL_TOOL = createTag("needs_mithril_tool");
        public static  final TagKey<Block> INCORRECT_FOR_MITHRIL_TOOL = createTag("incorrect_for_mithril_tool");
        public static final TagKey<Block> NEEDS_SILVER_TOOL = createTag("needs_silver_tool");
        public static  final TagKey<Block> INCORRECT_FOR_SILVER_TOOL = createTag("incorrect_for_silver_tool");
        public static final TagKey<Block> NEEDS_LEGENDARY_TOOL = createTag("needs_silver_tool");
        public static  final TagKey<Block> INCORRECT_FOR_LEGENDARY_TOOL = createTag("incorrect_for_silver_tool");
        public static TagKey<Block> DETECTOR_METAL_VALUABLES = createTag("detector_metal_valuables");
        public static TagKey<Block> DETECTOR_CRYSTAL_VALUABLES = createTag("detector_crystal_valuables");

        private static TagKey<Block> createTag (String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        private static TagKey<Item> createTag (String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID, name));
        }
    }
}
