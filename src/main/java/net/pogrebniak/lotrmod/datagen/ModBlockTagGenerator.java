package net.pogrebniak.lotrmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.ModBlocks;
import net.pogrebniak.lotrmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LotrMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.DETECTOR_METAL_VALUABLES)
                .add(ModBlocks.MITHRIL_ORE.get()).addTag(Tags.Blocks.ORES);
        this.tag(ModTags.Blocks.DETECTOR_CRYSTAL_VALUABLES)
                .add(ModBlocks.MITHRIL_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MITHRIL_ORE.get(),
                        ModBlocks.MITHRIL_RAW_BLOCK.get(),
                        ModBlocks.MITHRIL_INGOT_BLOCK.get(),
                        ModBlocks.MITHRIL_INGOT_BLOCK.get(),
                        ModBlocks.MITHRIL_ORE.get(),
                        ModBlocks.MITHRIL_ORE_DEEPSLATE.get(),
                        ModBlocks.MITHRIL_ORE_NETHER.get(),
                        ModBlocks.MITHRIL_ORE_END_STONE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_INGOT_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_BAR_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE_DEEPSLATE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE_END_STONE.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE_NETHER.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_RAW_BLOCK.get());






    }
}
