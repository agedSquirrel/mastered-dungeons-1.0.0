package net.squirrel.mdungeons.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.squirrel.mdungeons.MasteredDungeons;


public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MasteredDungeons.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> GOLDEN_FOOD = createTag("golden_food");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MasteredDungeons.MOD_ID, name));
        }
    }
}
