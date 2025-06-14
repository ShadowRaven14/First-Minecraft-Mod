package net.pogrebniak.lotrmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.item.ModItems;
import net.pogrebniak.lotrmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, LotrMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.MITHRIL_INGOT.get())
                .add(ModItems.MITHRIL_RAW.get())
                .add(ModItems.SILVER_INGOT.get())
                .add(ModItems.SILVER_RAW.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MITHRIL_HELMET.get())
                .add(ModItems.MITHRIL_CHESTPLATE.get())
                .add(ModItems.MITHRIL_LEGGINGS.get())
                .add(ModItems.MITHRIL_BOOTS.get())

                .add(ModItems.SILVER_HELMET.get())
                .add(ModItems.SILVER_CHESTPLATE.get())
                .add(ModItems.SILVER_LEGGINGS.get())
                .add(ModItems.SILVER_BOOTS.get());

                //.add(ModItems.SAURON_HELMET.get())
                //.add(ModItems.SAURON_CHESTPLATE.get())
                //.add(ModItems.SAURON_LEGGINGS.get())
                //.add(ModItems.SAURON_BOOTS.get());




    }
}
