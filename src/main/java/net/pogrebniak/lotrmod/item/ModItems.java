package net.pogrebniak.lotrmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.item.custom.FuelItem;
import net.pogrebniak.lotrmod.item.custom.MetalDetectorItem;
import net.pogrebniak.lotrmod.item.custom.ModFoods;
import net.pogrebniak.lotrmod.item.custom.OreDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LotrMod.MOD_ID);

    public static final RegistryObject<Item> MITHRIL_RAW = ITEMS.register("mithril_raw",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRIL_INGOT = ITEMS.register("mithril_ingot",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MITHRIL_BAR = ITEMS.register("mithril_bar",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(200)));

    public static final RegistryObject<Item> ORE_DETECTOR = ITEMS.register("ore_detector",
            ()-> new OreDetectorItem(new Item.Properties().durability(400)));

    public static final RegistryObject<Item> LEMBAS = ITEMS.register("lembas",
            ()-> new Item(new Item.Properties().food(ModFoods.LEMBAS)));

    public static final RegistryObject<Item> DWARVEN_COAL = ITEMS.register("dwarven_coal",
            ()-> new FuelItem(new Item.Properties(), 20000));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
