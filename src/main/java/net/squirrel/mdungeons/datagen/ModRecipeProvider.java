package net.squirrel.mdungeons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.squirrel.mdungeons.MasteredDungeons;
import net.squirrel.mdungeons.block.ModBlocks;
import net.squirrel.mdungeons.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> DEEPCOAL_SMELTABLES = List.of(
                ModBlocks.DEEPCOAL_ORE, ModBlocks.DENSE_DEEPCOAL_ORE
        );

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COMPACT_TUFF /* , count: 4 */)
                        .pattern("TTT")
                        .pattern("TTT")
                        .pattern("TTT")
                        .input('T', Blocks.TUFF)
                        .criterion(hasItem(Blocks.TUFF), conditionsFromItem(Blocks.TUFF))
                        .offerTo(exporter, Identifier.of(MasteredDungeons.MOD_ID, "compact_tuff_from_tuff"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLDEN_STEW)
                        .input(Items.REDSTONE)
                        .input(Items.SPIDER_EYE)
                        .input(Items.GOLD_BLOCK)
                        .input(Items.GOLDEN_CARROT)
                        .input(Items.GOLDEN_APPLE)
                        .input(Items.GOLDEN_APPLE)
                        .input(Items.BOWL)
                        .criterion(hasItem(Items.GOLDEN_APPLE), conditionsFromItem(Items.GOLDEN_APPLE))
                        .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.REINFORCED_LEATHER, 2)
                .input(Items.IRON_INGOT)
                .input(Items.LEATHER)
                .input(Items.LEATHER)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter);


        offerSmelting(exporter, DEEPCOAL_SMELTABLES, RecipeCategory.MISC, ModItems.DEEPCOAL, 5f, 800, "deepcoal");
        offerBlasting(exporter, DEEPCOAL_SMELTABLES, RecipeCategory.MISC, ModItems.DEEPCOAL, 12f, 400, "deepcoal");

        // offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.TUFF, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPACT_TUFF);

    }
}
