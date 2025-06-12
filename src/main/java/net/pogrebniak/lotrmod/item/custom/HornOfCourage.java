package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class HornOfCourage extends Item {
    public HornOfCourage(Properties pProperties) {
        super(pProperties.stacksTo(1));
        pProperties.rarity(Items.ENCHANTED_GOLDEN_APPLE.getDefaultInstance().getRarity());
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            if (!player.getCooldowns().isOnCooldown(this)) {

                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
                player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 3));

                player.getCooldowns().addCooldown(this, 400);

                player.sendSystemMessage(Component.literal("§6You blow the Horn of Courage!"));

            } else {
                player.sendSystemMessage(Component.literal("§7The horn needs time to recover..."));
            }
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }



//    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");
//
//    @Override
//    public boolean isFoil(ItemStack stack) {
//        return true;
//    }
//
//    @Override
//    public boolean useOnRelease(ItemStack pStack) {
//        return super.useOnRelease(pStack);
//    }
//    @Override
//    public void inventoryTick(ItemStack stack, Level level,
//                              Entity entity, int slot, boolean selected) {
//       if (!level.isClientSide && entity instanceof Player player) {
//            itemstack useOnRelease = PlayerInteractEvent(applyConstantEffectsHorn(player));
//
//            if (useOnRelease instanceof HornOfCourage ) {
//              applyConstantEffectsHorn(player);
//            }
//
//        }
//        super.inventoryTick(stack, level, entity, slot, selected);
//    }
//
//    private ItemStack applyConstantEffectsHorn(LivingEntity entity) {
//        //entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 220, 0, false, false, false));
//        entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false, false));
//        entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 220, 4, false, false, false));
//        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 220, 0, false, false, false));
//        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 220, 0, false, false, false));
//        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 220, 0, false, false, false));
//        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 220, 0, false, false, false));
//        return null;
//    }
}
