package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.pogrebniak.lotrmod.item.ModFoodItems;

import java.util.ArrayList;
import java.util.List;

public class Lembas extends ModFoodItems {
    public static final FoodProperties LEMBAS = new FoodProperties.Builder().nutrition(10).fast()
            .saturationModifier(1.0f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400),
                    0.5f).build();

    public Lembas(Properties pProperties) {
        super(pProperties, 12);
        nutrition = 12;
        LEMBAS.canAlwaysEat();
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext,
                                List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.lotrmod.lembas.tooltip"));
    }
}
