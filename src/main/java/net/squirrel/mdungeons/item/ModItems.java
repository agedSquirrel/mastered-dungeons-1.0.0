package net.squirrel.mdungeons.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.squirrel.mdungeons.MasteredDungeons;

import java.util.List;

public class ModItems {

    public static final Item REINFORCED_LEATHER = registerItem("reinforced_leather", new Item(new Item.Settings()));

    public static final Item DEEPCOAL = registerItem("deepcoal", new Item(new Item.Settings()));

    public static final Item GOLDEN_STEW = registerItem("golden_stew", new Item(new Item.Settings().food(ModFoodComponents.GOLDEN_STEW)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {tooltip.add(Text.translatable("tooltip.mdungeons.golden_soup.shift_down"));}
            else {tooltip.add(Text.translatable("tooltip.mdungeons.golden_soup"));}
            super.appendTooltip(stack, context, tooltip, type);}
    });


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MasteredDungeons.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MasteredDungeons.LOGGER.info("registering mod items for " + MasteredDungeons.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(REINFORCED_LEATHER);
        });
    }
}
