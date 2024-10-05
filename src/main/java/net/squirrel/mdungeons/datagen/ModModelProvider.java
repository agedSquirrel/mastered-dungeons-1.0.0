package net.squirrel.mdungeons.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.squirrel.mdungeons.block.ModBlocks;
import net.squirrel.mdungeons.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COMPACT_TUFF);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPCOAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DENSE_DEEPCOAL_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.DEEPCOAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_LEATHER, Models.GENERATED);

    }
}
