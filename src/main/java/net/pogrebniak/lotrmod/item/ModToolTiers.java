package net.pogrebniak.lotrmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.pogrebniak.lotrmod.util.ModTags;

public class ModToolTiers {
    public static final Tier MITHRIL = new ForgeTier(2031, 6, 5f, 25,
            ModTags.Blocks.NEEDS_MITHRIL_TOOL, () -> Ingredient.of(ModItems.MITHRIL_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_MITHRIL_TOOL);

    public static final Tier SILVER = new ForgeTier(600, 3, 2f, 15,
            ModTags.Blocks.NEEDS_SILVER_TOOL, () -> Ingredient.of(ModItems.SILVER_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_SILVER_TOOL);

    public static final Tier LEGENDARY = new ForgeTier(10000, 9, 10f, 35,
            ModTags.Blocks.NEEDS_LEGENDARY_TOOL, () -> Ingredient.of(ModItems.MITHRIL_BAR.get()),
            ModTags.Blocks.INCORRECT_FOR_LEGENDARY_TOOL);
}
