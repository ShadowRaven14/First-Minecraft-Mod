package net.pogrebniak.lotrmod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.pogrebniak.lotrmod.LotrMod;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MITHRIL_ORE_PLACED_KEY = registerKey("mithirl_ore_placed");
    public static final ResourceKey<PlacedFeature> MITHRIL_ORE_NETHER_PLACED_KEY = registerKey("mithirl_ore_nether_placed");
    public static final ResourceKey<PlacedFeature> MITHRIL_ORE_END_STONE_PLACED_KEY = registerKey("mithirl_ore_end_stone_placed");

    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_NETHER_PLACED_KEY = registerKey("mithirl_ore_nether_placed");
    //public static final ResourceKey<PlacedFeature> SILVER_ORE_END_STONE_PLACED_KEY = registerKey("mithirl_ore_end_stone_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context,MITHRIL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MITHRIL_ORE_KEY),
                ModOrePlacement.rareOrePlacement(100, HeightRangePlacement.uniform(VerticalAnchor.absolute(12), VerticalAnchor.absolute(12))));
        register(context,MITHRIL_ORE_NETHER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_MITHRIL_ORE_KEY),
                ModOrePlacement.rareOrePlacement(100, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(60))));
        register(context,MITHRIL_ORE_END_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_MITHRIL_ORE_KEY),
                ModOrePlacement.rareOrePlacement(100, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))));

        register(context,SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(1000))));
        register(context,SILVER_ORE_NETHER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(80))));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

