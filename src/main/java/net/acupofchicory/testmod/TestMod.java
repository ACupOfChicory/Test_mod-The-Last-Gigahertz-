package net.acupofchicory.testmod;

import net.acupofchicory.testmod.block.ModBlocks;
import net.acupofchicory.testmod.item.ModItemGroups;
import net.acupofchicory.testmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "test-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		// регистрируем какуето дичь
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FuelRegistry.INSTANCE.add(ModItems.COKE,3200);
		FuelRegistry.INSTANCE.add(ModBlocks.COKE_BLOCK,32000);
	}
}