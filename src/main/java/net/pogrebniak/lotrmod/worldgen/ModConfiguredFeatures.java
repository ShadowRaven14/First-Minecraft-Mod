package net.pogrebniak.lotrmod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MITHRIL_ORE_KEY = registerKey("mithril_ore");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MITHRIL_ORE_DEEPSLATE_KEY = registerKey("mithril_ore_deepslate");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_MITHRIL_ORE_KEY = registerKey("mithril_ore_nether");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_MITHRIL_ORE_KEY = registerKey("mithril_ore_end_stone");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SILVER_ORE_KEY = registerKey("silver_ore_nether");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILVER_ORE_KEY = registerKey("silver_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldMithrilOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.MITHRIL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.MITHRIL_ORE_DEEPSLATE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.SILVER_ORE_DEEPSLATE.get().defaultBlockState()));

        register(context, OVERWORLD_MITHRIL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMithrilOres, 10));
        register(context, NETHER_MITHRIL_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.MITHRIL_ORE_NETHER.get().defaultBlockState(), 6));
        register(context, END_MITHRIL_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.MITHRIL_ORE_END_STONE.get().defaultBlockState(), 6));

        register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSilverOres, 10));
        register(context, NETHER_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.SILVER_ORE_NETHER.get().defaultBlockState(), 10));
        //register(context, END_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSilverOres, 4));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


