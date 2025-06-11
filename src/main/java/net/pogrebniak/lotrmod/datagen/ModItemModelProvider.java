package net.pogrebniak.lotrmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.ModBlocks;
import net.pogrebniak.lotrmod.item.ModItems;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;
import static net.minecraft.resources.ResourceLocation.withDefaultNamespace;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LotrMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.MITHRIL_RAW.get());
        basicItem(ModItems.MITHRIL_INGOT.get());
        basicItem(ModItems.MITHRIL_BAR.get());

        basicItem(ModItems.DETECTOR_CRYSTAL.get());
        basicItem(ModItems.DETECTOR_METAL.get());

        basicItem(ModItems.DWARVEN_COAL.get());

        basicItem(ModItems.LEMBAS.get());

        basicItem(ModItems.ENERGY_CIRCUIT_INGOT.get());

        basicItem(ModItems.THE_ONE_RING.get());

        buttonItem(ModBlocks.MITHRIL_BUTTON, ModBlocks.MITHRIL_INGOT_BLOCK);
        fenceItem(ModBlocks.MITHRIL_FENCE, ModBlocks.MITHRIL_INGOT_BLOCK);
        wallItem(ModBlocks.MITHRIL_WALL, ModBlocks.MITHRIL_INGOT_BLOCK);

        simpleBlockItem(ModBlocks.MITHRIL_DOOR);

    }


    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}

