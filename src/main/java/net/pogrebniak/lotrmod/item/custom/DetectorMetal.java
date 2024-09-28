package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;

public class DetectorMetal extends Item {
    protected int durability = 1;

    public DetectorMetal(Properties pProperties)  {
        super(pProperties);
        durability = 200;
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i<= positionClicked.getY()+64; i++)
            {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));
                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("No valuables Found!"));
            }
        }
        var handUsed = pContext.getHand() ==
                InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), handUsed);

        return InteractionResult.SUCCESS;
    }

    public void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        Random rand = new Random();
        int r = rand.nextInt(10);
        player.sendSystemMessage(Component.literal("Found "
                + I18n.get(block.getDescriptionId()) + " at about "
                + (int)(player.getY() - blockPos.getY() + r) + " blocks below you"));
    }

    public boolean isValuableBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.COPPER_ORE) || state.is(Blocks.GOLD_ORE);
        //return state.is(ModTags.Blocks.DETECTOR_METAL_VALUABLES);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext,
                                List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("tooltip.lotrmod.detector_metal.tooltip"));
    }
}
