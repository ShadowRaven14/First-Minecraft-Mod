package net.pogrebniak.lotrmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.pogrebniak.lotrmod.LotrMod;
import net.pogrebniak.lotrmod.block.ModBlocks;
import net.pogrebniak.lotrmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> MITHRIL_SMELTABLES = List.of(ModItems.MITHRIL_RAW.get(),
                ModBlocks.MITHRIL_ORE.get(),ModBlocks.MITHRIL_ORE_NETHER.get(),ModBlocks.MITHRIL_ORE_DEEPSLATE.get(),
                ModBlocks.MITHRIL_ORE_END_STONE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MITHRIL_INGOT_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MITHRIL_INGOT.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MITHRIL_INGOT.get(), 9)
                .requires(ModBlocks.MITHRIL_INGOT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MITHRIL_INGOT_BLOCK.get()), has(ModBlocks.MITHRIL_INGOT_BLOCK.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MITHRIL_RAW_BLOCK.get())
                .pattern("XXX")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', ModItems.MITHRIL_RAW.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_RAW.get()), has(ModItems.MITHRIL_RAW.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MITHRIL_RAW.get(), 9)
                .requires(ModBlocks.MITHRIL_RAW_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MITHRIL_RAW_BLOCK.get()), has(ModBlocks.MITHRIL_RAW_BLOCK.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MITHRIL_BAR_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.MITHRIL_BAR.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_BAR.get()), has(ModItems.MITHRIL_BAR.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MITHRIL_BAR.get(), 9)
                .requires(ModBlocks.MITHRIL_BAR_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.MITHRIL_BAR_BLOCK.get()), has(ModBlocks.MITHRIL_BAR_BLOCK.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.LEMBAS.get())
                .pattern("AAA")
                .pattern("HEH")
                .pattern("WDW")
                .define('A', Items.MILK_BUCKET)
                .define('H', Items.HONEY_BOTTLE)
                .define('E', Items.EGG)
                .define('W', Items.WHEAT)
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DWARVEN_COAL.get())
                .pattern("CCC")
                .pattern("CLC")
                .pattern("CCC")
                .define('C', Items.COAL)
                .define('L', Items.LAVA_BUCKET)
                .unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE,  ModItems.ENERGY_CIRCUIT_INGOT.get())
                .pattern("RR")
                .pattern("QG")
                .define('R', Items.REDSTONE_BLOCK)
                .define('Q', Items.COPPER_INGOT)
                .define('G', Items.GOLD_NUGGET)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,  ModItems.MITHRIL_BAR.get())
                .pattern("IUI")
                .pattern("UPU")
                .pattern("IUI")
                .define('I', ModItems.SILVER_INGOT.get())
                .define('U', Items.GOLD_INGOT)
                .define('P', ModItems.MITHRIL_INGOT.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput, "mithril_from_crafting");


        oreBlasting(pRecipeOutput, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT.get(), 1.5f, 100, "mithril");
        oreSmelting(pRecipeOutput, MITHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MITHRIL_INGOT.get(), 1.5f, 150, "mithril");
        //MITHRIL TOOLS
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,  ModItems.MITHRIL_SWORD.get())
                .pattern("M")
                .pattern("M")
                .pattern("I")
                .define('I', Items.STICK)
                .define('M', ModItems.MITHRIL_INGOT.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,  ModItems.MITHRIL_PICKAXE.get())
                .pattern("MMM")
                .pattern(" I ")
                .pattern(" I ")
                .define('I', Items.STICK)
                .define('M', ModItems.MITHRIL_INGOT.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,  ModItems.MITHRIL_SHOVEL.get())
                .pattern("M")
                .pattern("I")
                .pattern("I")
                .define('I', Items.STICK)
                .define('M', ModItems.MITHRIL_INGOT.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,  ModItems.MITHRIL_AXE.get())
                .pattern("MM")
                .pattern("MI")
                .pattern(" I")
                .define('I', Items.STICK)
                .define('M', ModItems.MITHRIL_INGOT.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,  ModItems.MITHRIL_HOE.get())
                .pattern("MM")
                .pattern(" I")
                .pattern(" I")
                .define('I', Items.STICK)
                .define('M', ModItems.MITHRIL_INGOT.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);
        //rings
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT,  ModItems.THE_ONE_RING.get())
                .pattern("OOO")
                .pattern("OVO")
                .pattern("OOO")
                .define('O', Items.GOLD_BLOCK)
                .define('V', ModBlocks.MITHRIL_BAR_BLOCK.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_BAR.get()), has(ModItems.MITHRIL_BAR.get())).save(pRecipeOutput);

        //legendary item
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,  ModItems.SAURON_MACE.get())
                .pattern("MTM")
                .pattern("MIM")
                .pattern(" I ")
                .define('I', Items.STICK)
                .define('M', ModItems.MITHRIL_BAR.get())
                .define('T', ModBlocks.MITHRIL_BAR_BLOCK.get())
                .unlockedBy(getHasName(ModItems.MITHRIL_BAR.get()), has(ModItems.MITHRIL_BAR.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,  ModItems.DETECTOR_CRYSTAL.get())
                .pattern("E")
                .pattern("R")
                .pattern("P")
                .define('E', ModItems.DETECTOR_METAL.get())
                .define('R', Items.REDSTONE_BLOCK)
                .define('P', ModItems.MITHRIL_INGOT.get())
                .unlockedBy(getHasName(ModItems.DETECTOR_METAL.get()), has(ModItems.DETECTOR_METAL.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,  ModItems.DETECTOR_METAL.get())
                .pattern("S")
                .pattern("K")
                .pattern("Z")
                .define('S', Items.STICK)
                .define('K', ModItems.ENERGY_CIRCUIT_INGOT.get())
                .define('Z', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(ModItems.ENERGY_CIRCUIT_INGOT.get()), has(ModItems.ENERGY_CIRCUIT_INGOT.get())).save(pRecipeOutput);

        //Blocks
        stairBuilder(ModBlocks.MITHRIL_STAIRS.get(), Ingredient.of(ModItems.MITHRIL_INGOT.get())).group("mithril")
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MITHRIL_SLAB.get(), ModItems.MITHRIL_INGOT.get());

        fenceBuilder(ModBlocks.MITHRIL_FENCE.get(), Ingredient.of(ModItems.MITHRIL_INGOT.get())).group("mithril")
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        fenceGateBuilder(ModBlocks.MITHRIL_FENCE_GATE.get(), Ingredient.of(ModItems.MITHRIL_INGOT.get())).group("mithril")
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MITHRIL_WALL.get(), ModItems.MITHRIL_INGOT.get());

        doorBuilder(ModBlocks.MITHRIL_DOOR.get(), Ingredient.of(ModItems.MITHRIL_INGOT.get())).group("mithril")
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);

        doorBuilder(ModBlocks.MITHRIL_TRAPDOOR.get(), Ingredient.of(ModItems.MITHRIL_INGOT.get())).group("mithril")
                .unlockedBy(getHasName(ModItems.MITHRIL_INGOT.get()), has(ModItems.MITHRIL_INGOT.get())).save(pRecipeOutput);



        //SILVER
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_INGOT_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.SILVER_INGOT.get())
                .unlockedBy(getHasName(ModItems.SILVER_INGOT.get()), has(ModItems.SILVER_INGOT.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_INGOT.get(), 9)
                .requires(ModBlocks.SILVER_INGOT_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_INGOT_BLOCK.get()), has(ModBlocks.SILVER_INGOT_BLOCK.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_RAW_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.SILVER_RAW.get())
                .unlockedBy(getHasName(ModItems.SILVER_RAW.get()), has(ModItems.SILVER_RAW.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILVER_RAW.get(), 9)
                .requires(ModBlocks.SILVER_RAW_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SILVER_RAW_BLOCK.get()), has(ModBlocks.SILVER_RAW_BLOCK.get()))
                .save(pRecipeOutput);


    }



    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory,
                pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new,
                pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory,
                                                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer, pRecipeFactory).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pRecipeOutput, LotrMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));

        }
    }
}
