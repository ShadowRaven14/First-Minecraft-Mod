package net.pogrebniak.firstmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.firstmod.FirstMateuszBartekMod;
import net.pogrebniak.firstmod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMateuszBartekMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LOTR_TAB = CREATIVE_MODE_TABS.register("test_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MITHRIL_INGOT.get()))
                    .title(Component.translatable("creativetab.lotr_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MITHRIL_RAW.get());
                        pOutput.accept(ModItems.MITHRIL_INGOT.get());

                        pOutput.accept(ModBlocks.MITHRIL_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_RAW_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_BAR_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
