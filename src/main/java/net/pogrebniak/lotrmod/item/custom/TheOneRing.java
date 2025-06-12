package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class TheOneRing extends Item {
    public TheOneRing(Properties pProperties) {
        super(pProperties.stacksTo(1));
        pProperties.rarity(Items.ENCHANTED_GOLDEN_APPLE.getDefaultInstance().getRarity());
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level,
                              Entity entity, int slot, boolean selected) {
        if (!level.isClientSide && entity instanceof Player player) {
            ItemStack offhandItem = player.getOffhandItem();

            if (offhandItem.getItem() instanceof TheOneRing) {
                applyConstantEffectsRing(player);
            }

        }
        super.inventoryTick(stack, level, entity, slot, selected);
    }

    private void applyConstantEffectsRing(LivingEntity entity) {
        //entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 220, 0, false, false, false));
        entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false, false));
        entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 220, 4, false, false, false));
        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 0, false, false, false));
        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 0, false, false, false));
        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 0, false, false, false));
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0, false, false, false));
    }
}
