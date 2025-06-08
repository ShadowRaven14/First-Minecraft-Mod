package net.pogrebniak.lotrmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.item.ModItems;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;
import static net.minecraft.resources.ResourceLocation.withDefaultNamespace;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LotrMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.MITHRIL_RAW);
        simpleItem(ModItems.MITHRIL_INGOT);
        simpleItem(ModItems.MITHRIL_BAR);

        simpleItem(ModItems.DETECTOR_CRYSTAL);
        simpleItem(ModItems.DETECTOR_METAL);

        simpleItem(ModItems.DWARVEN_COAL);

        simpleItem(ModItems.LEMBAS);

        simpleItem(ModItems.ENERGY_CIRCUIT_INGOT);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                withDefaultNamespace("item/generated")).texture("layer0",
                fromNamespaceAndPath(LotrMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
