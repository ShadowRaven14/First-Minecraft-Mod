package net.pogrebniak.firstmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.firstmod.FirstMateuszBartekMod;
import net.pogrebniak.firstmod.item.ModItems;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstMateuszBartekMod.MOD_ID);

    public static final RegistryObject<Block> MITHRIL_BLOCK = registerBlock("mithril_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> MITHRIL_RAW_BLOCK = registerBlock("mithril_raw_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> MITHRIL_BAR_BLOCK = registerBlock("mithril_bar_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS).sound(SoundType.HEAVY_CORE)));




    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryObjectItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registryObjectItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
