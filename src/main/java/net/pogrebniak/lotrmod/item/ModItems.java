package net.pogrebniak.lotrmod.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.item.custom.*;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LotrMod.MOD_ID);

    //MITHRIL
    public static final RegistryObject<Item> MITHRIL_RAW = ITEMS.register("mithril_raw",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRIL_BAR = ITEMS.register("mithril_bar",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRIL_SWORD = ITEMS.register("mithril_sword",
            () -> new SwordItem(ModToolTiers.MITHRIL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.MITHRIL, 3, -2.4f))));

    public static final RegistryObject<Item> MITHRIL_PICKAXE = ITEMS.register("mithril_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MITHRIL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.MITHRIL, 1, -2.8f))));

    public static final RegistryObject<Item> MITHRIL_SHOVEL = ITEMS.register("mithril_shovel",
            () -> new ShovelItem(ModToolTiers.MITHRIL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.MITHRIL, 1.5f, -3.0f))));

    public static final RegistryObject<Item> MITHRIL_AXE = ITEMS.register("mithril_axe",
            () -> new AxeItem(ModToolTiers.MITHRIL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.MITHRIL, 6, -3.2f))));

    public static final RegistryObject<Item> MITHRIL_HOE = ITEMS.register("mithril_hoe",
            () -> new HoeItem(ModToolTiers.MITHRIL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.MITHRIL, 0, -3.0f))));

    //RINGS
    public static final RegistryObject<Item> THE_ONE_RING = ITEMS.register("ring_sauron",
            ()-> new TheOneRing(new Item.Properties().fireResistant()));

    //LEGENDARY
    public static final RegistryObject<Item> SAURON_MACE = ITEMS.register("legendary_sauron_mace",
            () -> new SauronMace(ModToolTiers.MITHRIL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.MITHRIL, 6, -2.4f))));

    public static final RegistryObject<Item> HORN_OF_COURAGE = ITEMS.register("legendary_horn_of_courage",
            ()-> new HornOfCourage(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("legendary_chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)
                    .rarity(Items.GOLDEN_APPLE.getDefaultInstance().getRarity())));

    public static final RegistryObject<Item> DETECTOR_METAL = ITEMS.register("detector_metal",
            ()-> new DetectorMetal(new Item.Properties().durability(200)
                    .rarity(Items.GOLDEN_APPLE.getDefaultInstance().getRarity())));

    public static final RegistryObject<Item> DETECTOR_CRYSTAL = ITEMS.register("detector_crystal",
            ()-> new DetectorCrystal(new Item.Properties().durability(400)
                    .rarity(Items.GOLDEN_APPLE.getDefaultInstance().getRarity())));

    //FOOD
    public static final RegistryObject<Item> LEMBAS = ITEMS.register("food_lembas",
            ()-> new Lembas(new Item.Properties().food(Lembas.LEMBAS)));

    //OTHER
    public static final RegistryObject<Item> ENERGY_CIRCUIT_INGOT = ITEMS.register("energy_circuit_ingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DWARVEN_COAL = ITEMS.register("dwarven_coal",
            ()-> new DvarvenCoal(new Item.Properties()));

    //REGISTER
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
