package net.pogrebniak.lotrmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.ModBlocks;
import net.pogrebniak.lotrmod.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
        }
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LotrMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {

        //MITHRIL
        basicItem(ModItems.MITHRIL_RAW.get());
        basicItem(ModItems.MITHRIL_INGOT.get());
        basicItem(ModItems.MITHRIL_BAR.get());

        handleItem(ModItems.MITHRIL_SHOVEL);
        handleItem(ModItems.MITHRIL_PICKAXE);
        handleItem(ModItems.MITHRIL_AXE);
        handleItem(ModItems.MITHRIL_HOE);
        handleItem(ModItems.MITHRIL_SWORD);

        //SILVER
        basicItem(ModItems.SILVER_INGOT.get());
        basicItem(ModItems.SILVER_RAW.get());
        handleItem(ModItems.SILVER_SWORD);
        handleItem(ModItems.SILVER_PICKAXE);
        handleItem(ModItems.SILVER_AXE);
        handleItem(ModItems.SILVER_HOE);
        handleItem(ModItems.SILVER_SHOVEL);


        //ELVEN
        buttonItem(ModBlocks.MITHRIL_BUTTON, ModBlocks.MITHRIL_INGOT_BLOCK);
        fenceItem(ModBlocks.MITHRIL_FENCE, ModBlocks.MITHRIL_INGOT_BLOCK);
        wallItem(ModBlocks.MITHRIL_WALL, ModBlocks.MITHRIL_INGOT_BLOCK);
        simpleBlockItem(ModBlocks.MITHRIL_DOOR);

        //RINGS
        basicItem(ModItems.THE_ONE_RING.get());

        //LEGENDARY
        handleItem(ModItems.SAURON_MACE);
        handleItem(ModItems.ANDURIL);


        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.DETECTOR_CRYSTAL.get());
        basicItem(ModItems.DETECTOR_METAL.get());
        basicItem(ModItems.HORN_OF_COURAGE.get());
        //FOOD
        basicItem(ModItems.LEMBAS.get());

        //OTHER
        basicItem(ModItems.DWARVEN_COAL.get());
        basicItem(ModItems.ENERGY_CIRCUIT_INGOT.get());

        //ARMOR
        trimmedArmorItem(ModItems.MITHRIL_HELMET);
        trimmedArmorItem(ModItems.MITHRIL_CHESTPLATE);
        trimmedArmorItem(ModItems.MITHRIL_LEGGINGS);
        trimmedArmorItem(ModItems.MITHRIL_BOOTS);

        trimmedArmorItem(ModItems.SILVER_HELMET);
        trimmedArmorItem(ModItems.SILVER_CHESTPLATE);
        trimmedArmorItem(ModItems.SILVER_LEGGINGS);
        trimmedArmorItem(ModItems.SILVER_BOOTS);

        //ItemModelBuilder andurilBuilder = getBuilder("legendary_anduril")
                //.parent(getExistingFile(mcLoc("item/generated")))
                //.texture("layer0", modLoc("item/legendary_anduril"));

        //withOverrides(andurilBuilder, "lotrmod:custom_property", 1f, "item/legendary_anduril_layer");

    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = LotrMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder withOverrides(ItemModelBuilder builder, String predicate, float value, String overrideModelPath) {
        builder.override()
                .predicate(ResourceLocation.parse(predicate), value)
                .model(getExistingFile(modLoc(overrideModelPath)))
                .end();
        return builder;
    }


    private ItemModelBuilder handleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(LotrMod.MOD_ID,"item/" + item.getId().getPath()));
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