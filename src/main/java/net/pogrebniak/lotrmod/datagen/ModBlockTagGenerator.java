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
                        ModBlocks.MITHRIL_BAR_BLOCK.get(),
                        ModBlocks.MITHRIL_ORE.get(),
                        ModBlocks.MITHRIL_ORE_DEEPSLATE.get(),
                        ModBlocks.MITHRIL_ORE_NETHER.get(),
                        ModBlocks.MITHRIL_ORE_END_STONE.get(),
                        ModBlocks.MITHRIL_LAMP.get(),

                        ModBlocks.MITHRIL_SLAB.get(),
                        ModBlocks.MITHRIL_STAIRS.get(),

                        ModBlocks.MITHRIL_DOOR.get(),
                        ModBlocks.MITHRIL_TRAPDOOR.get(),

                        ModBlocks.MITHRIL_FENCE_GATE.get(),
                        ModBlocks.MITHRIL_FENCE.get(),
                        ModBlocks.MITHRIL_WALL.get(),

                        ModBlocks.MITHRIL_PRESSURE_PLATE.get(),
                        ModBlocks.MITHRIL_BUTTON.get(),

                        //SIlver
                        ModBlocks.SILVER_INGOT_BLOCK.get(),
                        ModBlocks.SILVER_RAW_BLOCK.get(),
                        ModBlocks.SILVER_ORE.get());
                        //ModBlocks.SILVER_ORE_DEEPSLATE.get(),
                        //ModBlocks.SILVER_ORE_NETHER.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_INGOT_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_BAR_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE_DEEPSLATE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE_END_STONE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_ORE_NETHER.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_RAW_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_LAMP.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_SLAB.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_STAIRS.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_BUTTON.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_PRESSURE_PLATE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_FENCE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_FENCE_GATE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_WALL.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_DOOR.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MITHRIL_TRAPDOOR.get());
        //SILVER
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SILVER_INGOT_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SILVER_RAW_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SILVER_ORE.get());





        tag(BlockTags.FENCES).add(ModBlocks.MITHRIL_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.MITHRIL_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.MITHRIL_WALL.get());

        tag(ModTags.Blocks.NEEDS_MITHRIL_TOOL)
                .add(ModBlocks.MITHRIL_BAR_BLOCK.get())
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_MITHRIL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_MITHRIL_TOOL);






    }
}
