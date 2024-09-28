package net.pogrebniak.lotrmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ModFoodItems extends Item {
    protected int nutrition = 1;

    public ModFoodItems(Properties pProperties, int nutrition) {
        super(pProperties);
        this.nutrition = nutrition;
    }

    public int getNutrition() {
        return this.nutrition;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext,
                                List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
    }
}
