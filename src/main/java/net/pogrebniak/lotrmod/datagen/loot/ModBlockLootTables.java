package net.pogrebniak.lotrmod.datagen.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.pogrebniak.lotrmod.block.ModBlocks;
import net.pogrebniak.lotrmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), (HolderLookup.Provider) LootContextParamSets.BLOCK);
    }

    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MITHRIL_INGOT_BLOCK.get());
        this.dropSelf(ModBlocks.MITHRIL_RAW_BLOCK.get());
        this.dropSelf(ModBlocks.MITHRIL_BAR_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.MITHRIL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.MITHRIL_ORE.get(), ModItems.MITHRIL_RAW.get()));
        this.add(ModBlocks.MITHRIL_ORE_NETHER.get(),
                block -> createCopperLikeOreDrops(ModBlocks.MITHRIL_ORE.get(), ModItems.MITHRIL_RAW.get()));
        this.add(ModBlocks.MITHRIL_ORE_DEEPSLATE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.MITHRIL_ORE.get(), ModItems.MITHRIL_RAW.get()));
        this.add(ModBlocks.MITHRIL_ORE_END_STONE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.MITHRIL_ORE.get(), ModItems.MITHRIL_RAW.get()));

        dropSelf(ModBlocks.MITHRIL_STAIRS.get());
        this.add(ModBlocks.MITHRIL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MITHRIL_SLAB.get()));


        dropSelf(ModBlocks.MITHRIL_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.MITHRIL_BUTTON.get());
        dropSelf(ModBlocks.MITHRIL_FENCE.get());
        dropSelf(ModBlocks.MITHRIL_FENCE_GATE.get());
        dropSelf(ModBlocks.MITHRIL_WALL.get());
        dropSelf(ModBlocks.MITHRIL_TRAPDOOR.get());

        this.add(ModBlocks.MITHRIL_DOOR.get(),
                block -> createDoorTable(ModBlocks.MITHRIL_DOOR.get()));

        dropSelf(ModBlocks.MITHRIL_LAMP.get());


    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item ) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
