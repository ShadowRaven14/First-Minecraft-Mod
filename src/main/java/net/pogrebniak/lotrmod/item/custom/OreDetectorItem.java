package net.pogrebniak.lotrmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.pogrebniak.lotrmod.block.ModBlocks;

public class OreDetectorItem extends MetalDetectorItem {
    public OreDetectorItem(Properties pProperties)  {
        super(pProperties);
    }

    @Override
    public boolean isValuableBlock(BlockState state) {
        return  state.is(Blocks.EMERALD_ORE)
                || state.is(Blocks.DEEPSLATE_EMERALD_ORE)
                || state.is(Blocks.DIAMOND_ORE)
                || state.is(Blocks.DEEPSLATE_DIAMOND_ORE)
                || state.is(ModBlocks.MITHRIL_ORE.get())
                || state.is(ModBlocks.MITHRIL_ORE_DEEPSLATE.get());
    }
}
