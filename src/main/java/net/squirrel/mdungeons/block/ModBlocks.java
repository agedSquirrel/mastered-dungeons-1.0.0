package net.squirrel.mdungeons.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.squirrel.mdungeons.MasteredDungeons;

public class ModBlocks {

    public static final Block COMPACT_TUFF = registerBlock("compact_tuff",
            new Block(AbstractBlock.Settings.create().strength(8f)
                    .requiresTool().sounds(BlockSoundGroup.TUFF).burnable().hardness(10f)));
    public static final Block DEEPCOAL_ORE = registerBlock("deepcoal_ore",
            new Block(AbstractBlock.Settings.create().strength(6f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE).burnable().hardness(6f)));
    public static final Block DENSE_DEEPCOAL_ORE = registerBlock("dense_deepcoal_ore",
            new Block(AbstractBlock.Settings.create().strength(7f)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE).slipperiness(0.9f).hardness(8f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MasteredDungeons.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MasteredDungeons.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        MasteredDungeons.LOGGER.info("Registering Mod Blocks for " + MasteredDungeons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.COMPACT_TUFF);
            entries.add(ModBlocks.DEEPCOAL_ORE);
            entries.add(ModBlocks.DENSE_DEEPCOAL_ORE);
        });
    }



}
