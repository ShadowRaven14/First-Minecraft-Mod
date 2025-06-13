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

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LotrMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LOTR_TAB = CREATIVE_MODE_TABS.register("test_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MITHRIL_INGOT.get()))
                    .title(Component.translatable("creativetab.lotr_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        //MITHRIL
                        pOutput.accept(ModItems.MITHRIL_RAW.get());
                        pOutput.accept(ModItems.MITHRIL_INGOT.get());
                        pOutput.accept(ModItems.MITHRIL_BAR.get());

                        pOutput.accept(ModItems.MITHRIL_SWORD.get());
                        pOutput.accept(ModItems.MITHRIL_SHOVEL.get());
                        pOutput.accept(ModItems.MITHRIL_AXE.get());
                        pOutput.accept(ModItems.MITHRIL_PICKAXE.get());
                        pOutput.accept(ModItems.MITHRIL_HOE.get());

                        pOutput.accept(ModBlocks.MITHRIL_RAW_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_INGOT_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_BAR_BLOCK.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE_DEEPSLATE.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE_END_STONE.get());
                        pOutput.accept(ModBlocks.MITHRIL_ORE_NETHER.get());

                        //SILVER
                        pOutput.accept(ModBlocks.SILVER_INGOT_BLOCK.get());
                        pOutput.accept(ModBlocks.SILVER_RAW_BLOCK.get());
                        pOutput.accept(ModBlocks.SILVER_ORE.get());
                        pOutput.accept(ModItems.SILVER_RAW.get());
                        pOutput.accept(ModItems.SILVER_INGOT.get());



                        //ELVEN
                        pOutput.accept(ModBlocks.MITHRIL_LAMP.get());
                        pOutput.accept(ModBlocks.MITHRIL_DOOR.get());
                        pOutput.accept(ModBlocks.MITHRIL_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.MITHRIL_FENCE.get());
                        pOutput.accept(ModBlocks.MITHRIL_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.MITHRIL_WALL.get());
                        pOutput.accept(ModBlocks.MITHRIL_STAIRS.get());
                        pOutput.accept(ModBlocks.MITHRIL_SLAB.get());
                        pOutput.accept(ModBlocks.MITHRIL_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.MITHRIL_BUTTON.get());

                        //RINGS
                        pOutput.accept(ModItems.THE_ONE_RING.get());

                        //LEGENDARY
                        pOutput.accept(ModItems.SAURON_MACE.get());
                        pOutput.accept(ModItems.CHISEL.get());
                        pOutput.accept(ModItems.DETECTOR_METAL.get());
                        pOutput.accept(ModItems.DETECTOR_CRYSTAL.get());
                        pOutput.accept(ModItems.HORN_OF_COURAGE.get());

                        //FOOD
                        pOutput.accept(ModItems.LEMBAS.get());

                        //OTHER
                        pOutput.accept(ModItems.DWARVEN_COAL.get());
                        pOutput.accept(ModItems.ENERGY_CIRCUIT_INGOT.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        //ARMOR
                        pOutput.accept(ModItems.MITHRIL_HELMET.get());
                        pOutput.accept(ModItems.MITHRIL_CHESTPLATE.get());
                        pOutput.accept(ModItems.MITHRIL_LEGGINGS.get());
                        pOutput.accept(ModItems.MITHRIL_BOOTS.get());

                        pOutput.accept(ModItems.SILVER_HELMET.get());
                        pOutput.accept(ModItems.SILVER_CHESTPLATE.get());
                        pOutput.accept(ModItems.SILVER_LEGGINGS.get());
                        pOutput.accept(ModItems.SILVER_BOOTS.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
