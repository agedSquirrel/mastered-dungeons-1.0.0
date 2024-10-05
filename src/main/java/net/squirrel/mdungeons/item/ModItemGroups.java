package net.squirrel.mdungeons.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.squirrel.mdungeons.MasteredDungeons;
import net.squirrel.mdungeons.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup MODDED_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MasteredDungeons.MOD_ID, "modded_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.REINFORCED_LEATHER))
                    .displayName(Text.translatable("itemgroup.mdungeons.modded_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.REINFORCED_LEATHER);
                        entries.add(ModItems.GOLDEN_STEW);

                        entries.add(ModItems.DEEPCOAL);

                        entries.add(ModBlocks.COMPACT_TUFF);

                    })
                    .build());

    public static void registerModItemGroups() {
        MasteredDungeons.LOGGER.info("Registering Mod Item Groups for " + MasteredDungeons.MOD_ID);
    }


}
