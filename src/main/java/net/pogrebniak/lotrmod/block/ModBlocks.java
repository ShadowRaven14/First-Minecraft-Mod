package net.pogrebniak.lotrmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.custom.MithrilLamp;
import net.pogrebniak.lotrmod.block.custom.SoundBlock;
import net.pogrebniak.lotrmod.item.ModItems;

import java.util.function.Supplier;

import static net.minecraft.world.item.Items.registerBlock;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LotrMod.MOD_ID);

    //MITHRIL
    public static final RegistryObject<Block> MITHRIL_BAR_BLOCK = registerBlock("mithril_bar_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST).lightLevel(state -> 12)));

    public static final RegistryObject<Block> MITHRIL_INGOT_BLOCK = registerBlock("mithril_ingot_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST).lightLevel(state -> 9)));

    public static final RegistryObject<Block> MITHRIL_RAW_BLOCK = registerBlock("mithril_raw_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST).lightLevel(state -> 6)));

    public static final RegistryObject<Block> MITHRIL_ORE = registerBlock("mithril_ore",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops()
                    .sound(SoundType.STONE).lightLevel(state -> 6)));

    public static final RegistryObject<Block> MITHRIL_ORE_DEEPSLATE = registerBlock("mithril_ore_deepslate",
            () -> new DropExperienceBlock(UniformInt.of(3, 7),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE).requiresCorrectToolForDrops()
                                .sound(SoundType.DEEPSLATE).lightLevel(state -> 6)));

    public static final RegistryObject<Block> MITHRIL_ORE_END_STONE = registerBlock("mithril_ore_end_stone",
            () -> new DropExperienceBlock(UniformInt.of(3, 8),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops()
                                .sound(SoundType.STONE).lightLevel(state -> 6)));

    public static final RegistryObject<Block> MITHRIL_ORE_NETHER = registerBlock("mithril_ore_nether",
            () -> new DropExperienceBlock(UniformInt.of(3, 7),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops()
                                .sound(SoundType.NETHERRACK).lightLevel(state -> 9)));

    //ELVEN
    public static final RegistryObject<StairBlock> MITHRIL_STAIRS = registerBlock("mithril_stairs",
            () -> new StairBlock(ModBlocks.MITHRIL_INGOT_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<SlabBlock> MITHRIL_SLAB = registerBlock("mithril_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> MITHRIL_PRESSURE_PLATE = registerBlock("mithril_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<ButtonBlock> MITHRIL_BUTTON = registerBlock("mithril_button",
            () -> new ButtonBlock(BlockSetType.IRON, 1, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> MITHRIL_FENCE = registerBlock("mithril_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<FenceGateBlock> MITHRIL_FENCE_GATE = registerBlock("mithril_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<WallBlock> MITHRIL_WALL = registerBlock("mithril_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> MITHRIL_DOOR = registerBlock("mithril_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<TrapDoorBlock> MITHRIL_TRAPDOOR = registerBlock("mithril_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f)
                            .requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> MITHRIL_LAMP = registerBlock("mithril_lamp",
            () -> new MithrilLamp(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(MithrilLamp.CLICKED) ? 15 : 0)));

    //OTHER
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST).lightLevel(state -> 9)));


    //REGISTER
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryObjectItem(name, toReturn);
        return toReturn;
    }

    //REGISTER
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
    private static <T extends Block>RegistryObject<Item> registryObjectItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
