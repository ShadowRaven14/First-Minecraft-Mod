package net.pogrebniak.lotrmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.item.custom.DetectorCrystal;
import net.pogrebniak.lotrmod.item.custom.DvarvenCoal;
import net.pogrebniak.lotrmod.item.custom.Lembas;
import net.pogrebniak.lotrmod.item.custom.DetectorMetal;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LotrMod.MOD_ID);

    public static final RegistryObject<Item> MITHRIL_RAW = ITEMS.register("mithril_raw",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRIL_BAR = ITEMS.register("mithril_bar",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENERGY_CIRCUIT_INGOT = ITEMS.register("energy_circuit_ingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DETECTOR_METAL = ITEMS.register("detector_metal",
            ()-> new DetectorMetal(new Item.Properties().durability(200)));

    public static final RegistryObject<Item> DETECTOR_CRYSTAL = ITEMS.register("detector_crystal",
            ()-> new DetectorCrystal(new Item.Properties().durability(400)));

    public static final RegistryObject<Item> LEMBAS = ITEMS.register("lembas",
            ()-> new Lembas(new Item.Properties().food(Lembas.LEMBAS)));

    public static final RegistryObject<Item> DWARVEN_COAL = ITEMS.register("dwarven_coal",
            ()-> new DvarvenCoal(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
