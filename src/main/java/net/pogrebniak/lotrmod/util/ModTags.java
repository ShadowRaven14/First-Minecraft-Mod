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
        public static TagKey<Block> DETECTOR_METAL_VALUABLES = tag("detector_metal_valuables");
        public static TagKey<Block> DETECTOR_CRYSTAL_VALUABLES = tag("detector_crystal_valuables");

        private static TagKey<Block> tag (String name) {
            return BlockTags.create(ResourceLocation.tryBuild(LotrMod.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag (String name) {
            return ItemTags.create(ResourceLocation.tryBuild(LotrMod.MOD_ID, name));
        }
    }
}
