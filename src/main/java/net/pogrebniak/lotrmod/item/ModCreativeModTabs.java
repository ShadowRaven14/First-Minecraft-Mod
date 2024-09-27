package net.pogrebniak.lotrmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.ModBlocks;
import net.pogrebniak.lotrmod.item.custom.ModFoods;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LotrMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LOTR_TAB = CREATIVE_MODE_TABS.register("test_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MITHRIL_INGOT.get()))
                    .title(Component.translatable("creativetab.lotr_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MITHRIL_RAW.get());
                        pOutput.accept(ModItems.MITHRIL_INGOT.get());
                        pOutput.accept(ModItems.MITHRIL_BAR.get());
                        pOutput.accept(ModBlocks.MITHRIL_RAW_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_INGOT_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_BAR_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE_DEEPSLATE.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE_END_STONE.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE_NETHER.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.ORE_DETECTOR.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModItems.LEMBAS.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
