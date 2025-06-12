package net.pogrebniak.lotrmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.pogrebniak.lotrmod.util.ModTags;

public class ModToolTiers {
    public static final Tier MITHRIL = new ForgeTier(2031, 6, 5f, 25,
            ModTags.Blocks.NEEDS_MITHRIL_TOOL, () -> Ingredient.of(ModItems.MITHRIL_INGOT.get()),
            ModTags.Blocks.INCORRECT_FOR_MITHRIL_TOOL);
}
