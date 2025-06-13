package net.pogrebniak.lotrmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.ModBlocks;
import net.pogrebniak.lotrmod.block.custom.MithrilLamp;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LotrMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //MITHRIL
        blockWithItem(ModBlocks.MITHRIL_INGOT_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_BAR_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_RAW_BLOCK);
        //SILVER
        blockWithItem(ModBlocks.SILVER_RAW_BLOCK);
        blockWithItem(ModBlocks.SILVER_INGOT_BLOCK);
        //ORES
        blockWithItem(ModBlocks.SILVER_ORE);
//        blockWithItem(ModBlocks.SILVER_ORE_DEEPSLATE);
//        blockWithItem(ModBlocks.SILVER_ORE_NETHER);

        blockWithItem(ModBlocks.MITHRIL_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.MITHRIL_ORE_END_STONE);
        blockWithItem(ModBlocks.MITHRIL_ORE);
        blockWithItem(ModBlocks.MITHRIL_ORE_NETHER);

        stairsBlock(ModBlocks.MITHRIL_STAIRS.get(), blockTexture(ModBlocks.MITHRIL_INGOT_BLOCK.get()));
        slabBlock(ModBlocks.MITHRIL_SLAB.get(), blockTexture(ModBlocks.MITHRIL_INGOT_BLOCK.get()), blockTexture(ModBlocks.MITHRIL_INGOT_BLOCK.get()));
        pressurePlateBlock(ModBlocks.MITHRIL_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MITHRIL_INGOT_BLOCK.get()));
        buttonBlock(ModBlocks.MITHRIL_BUTTON.get(), blockTexture(ModBlocks.MITHRIL_INGOT_BLOCK.get()));
        wallBlock(ModBlocks.MITHRIL_WALL.get(), blockTexture(ModBlocks.MITHRIL_INGOT_BLOCK.get()));
        fenceGateBlock(ModBlocks.MITHRIL_FENCE_GATE.get(), blockTexture(ModBlocks.MITHRIL_INGOT_BLOCK.get()));
        fenceBlock(ModBlocks.MITHRIL_FENCE.get(), blockTexture(ModBlocks.MITHRIL_INGOT_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.MITHRIL_DOOR.get(), modLoc("block/mithril_door_bottom"), modLoc("block/mithril_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.MITHRIL_TRAPDOOR.get(), modLoc("block/mithril_trapdoor"), true, "cutout");

        blockItem(ModBlocks.MITHRIL_SLAB);
        blockItem(ModBlocks.MITHRIL_STAIRS);
        blockItem(ModBlocks.MITHRIL_WALL);
        blockItem(ModBlocks.MITHRIL_FENCE_GATE);
        blockItem(ModBlocks.MITHRIL_FENCE);
        blockItem(ModBlocks.MITHRIL_DOOR);
        blockItem(ModBlocks.MITHRIL_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.MITHRIL_PRESSURE_PLATE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.MITHRIL_LAMP.get()).forAllStates(state -> {
            if(state.getValue(MithrilLamp.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("mithril_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID, "block/" + "mithril_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("mithril_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID, "block/" + "mithril_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.MITHRIL_LAMP.get(), models().cubeAll("mithril_lamp_on",
                ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID, "block/" + "mithril_lamp_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                LotrMod.MOD_ID + ":block/"
                        + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(
                LotrMod.MOD_ID + ":block/"
                        + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
