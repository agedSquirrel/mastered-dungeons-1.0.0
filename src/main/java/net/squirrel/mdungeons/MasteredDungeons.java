package net.squirrel.mdungeons;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.squirrel.mdungeons.block.ModBlocks;
import net.squirrel.mdungeons.item.ModItemGroups;
import net.squirrel.mdungeons.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasteredDungeons implements ModInitializer {
	public static final String MOD_ID = "mdungeons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerModItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.DEEPCOAL, 800000);
	}
}