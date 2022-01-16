package xyot.solar;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Solar implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("modid");

	public static final Block SOLAR_PANEL = new Block(
			FabricBlockSettings.of(Material.STONE).strength(1.5f, 6f).sounds(BlockSoundGroup.STONE).requiresTool());

	public static final Block ELECTRIC_FURNACE = new Block(
			FabricBlockSettings.of(Material.STONE).strength(1.5f, 6f).sounds(BlockSoundGroup.STONE).requiresTool());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		// Solar panel init
		Registry.register(Registry.BLOCK, new Identifier("xyot", "solar_panel"), SOLAR_PANEL);
		Registry.register(Registry.ITEM, new Identifier("xyot", "solar_panel"),
				new BlockItem(SOLAR_PANEL, new Item.Settings().group(ItemGroup.REDSTONE)));

		// Electric Furnace init
		Registry.register(Registry.BLOCK, new Identifier("xyot", "electric_furnace"), ELECTRIC_FURNACE);
		Registry.register(Registry.ITEM, new Identifier("xyot", "electric_furnace"),
				new BlockItem(ELECTRIC_FURNACE, new Item.Settings().group(ItemGroup.REDSTONE)));
	}
}
