package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.pogrebniak.lotrmod.item.ModFuelItems;

import java.util.List;

public class DvarvenCoal extends ModFuelItems {

    public DvarvenCoal(Properties pProperties) {
        super(pProperties, 20000);
        burnTime = 20000;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext,
                                List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.lotrmod.dwarven_coal.tooltip"));
    }
}
