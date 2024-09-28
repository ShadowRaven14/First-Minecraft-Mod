package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.pogrebniak.lotrmod.block.ModBlocks;

import java.util.List;

public class DetectorCrystal extends DetectorMetal {

    public DetectorCrystal(Properties pProperties)  {
        super(pProperties);
        durability = 400;
    }

    @Override
    public boolean isValuableBlock(BlockState state) {
        return  state.is(Blocks.EMERALD_ORE)
                || state.is(Blocks.DEEPSLATE_EMERALD_ORE)
                || state.is(Blocks.DIAMOND_ORE)
                || state.is(Blocks.DEEPSLATE_DIAMOND_ORE)
                || state.is(ModBlocks.MITHRIL_ORE.get())
                || state.is(ModBlocks.MITHRIL_ORE_DEEPSLATE.get());
        //return state.is(ModTags.Blocks.DETECTOR_CRYSTAL_VALUABLES);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext,
                                List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.lotrmod.detector_crystal.tooltip"));
    }
}
