package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class Anduril extends SwordItem {
    public Anduril(Tier pTier, Properties pProperties) {
    super(pTier, pProperties.stacksTo(1));
        pProperties.durability(10000);
        pProperties.rarity(Items.ENCHANTED_GOLDEN_APPLE.getDefaultInstance().getRarity());
}

@Override
public boolean isFoil(ItemStack stack) {
    return true;
}

@Override
public void inventoryTick (ItemStack stack, Level level, Entity entity, int slot, boolean selected) {

    if (!level.isClientSide && entity instanceof Player player) {
        ItemStack mainhandItem = player.getMainHandItem();

        if (mainhandItem.getItem() instanceof Anduril) {
            applyConstantEffectsAnduril(player);

        }
    }
    super.inventoryTick(stack, level, entity, slot, selected);
}

private void applyConstantEffectsAnduril(LivingEntity entity){
    entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 3, false, false, false));
    entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 220, 0, false, false, false));
    entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 1, false, false, false));
    entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 1, false, false, false));
    entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 220, 0, false, false, false));



}


}

