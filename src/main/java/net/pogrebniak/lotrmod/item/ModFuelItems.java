package net.pogrebniak.lotrmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModFuelItems extends Item {
    protected int burnTime = 1;

    public ModFuelItems(Properties pProperties, int burnTime) {
        super(pProperties);
        this.burnTime = burnTime;
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext,
                                List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
    }
}
