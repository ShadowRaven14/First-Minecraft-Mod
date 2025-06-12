package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class GandalfStaff extends SwordItem {
    public GandalfStaff(Tier pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1));
        pProperties.durability(10000);
        pProperties.rarity(Items.ENCHANTED_GOLDEN_APPLE.getDefaultInstance().getRarity());
        //pProperties.attributes(getPlayerPOVHitResult());
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public void inventoryTick (ItemStack stack, Level level, Entity entity, int slot, boolean selected) {

        if (!level.isClientSide && entity instanceof Player player) {
            ItemStack mainhandItem = player.getMainHandItem();
            ItemStack offhandItem = player.getOffhandItem();

            if (mainhandItem.getItem() instanceof GandalfStaff) {
                applyConstantEffectsStaff(player);
            }
        }
        super.inventoryTick(stack, level, entity, slot, selected);
    }

    private void applyConstantEffectsStaff(LivingEntity entity) {
    }


}


