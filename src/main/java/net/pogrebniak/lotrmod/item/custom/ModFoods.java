package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties LEMBAS = new FoodProperties.Builder().nutrition(10).fast()
            .saturationModifier(1.0f).effect(new MobEffectInstance(MobEffects.SATURATION, 200),
                    0.5f).build();
}
