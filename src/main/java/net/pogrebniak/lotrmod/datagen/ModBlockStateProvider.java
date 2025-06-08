package net.pogrebniak.lotrmod.datagen;

import com.jcraft.jorbis.Block;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LotrMod.MOD_ID,exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MITHRIL_INGOT_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_BAR_BLOCK);
        blockWithItem(ModBlocks.MITHRIL_RAW_BLOCK);

        blockWithItem(ModBlocks.MITHRIL_ORE_DEEPSLATE);
        blockWithItem(ModBlocks.MITHRIL_ORE_END_STONE);
        blockWithItem(ModBlocks.MITHRIL_ORE);
        blockWithItem(ModBlocks.MITHRIL_ORE_NETHER);

        blockWithItem(ModBlocks.SOUND_BLOCK);

    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
