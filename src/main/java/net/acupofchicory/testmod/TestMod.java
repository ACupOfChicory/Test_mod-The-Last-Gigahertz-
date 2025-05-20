package net.acupofchicory.testmod;

import com.google.common.eventbus.EventBus;
//import net.acupofchicory.testmod.block.ModBlockEntities;
import net.acupofchicory.testmod.block.ModBlocks;
//import net.acupofchicory.testmod.block.entity.ModBlockEntities;
//import net.acupofchicory.testmod.blocks.EnergyStorageBlockEntity;
//import net.acupofchicory.testmod.blocks.PowerCableBlockEntity;
import net.acupofchicory.testmod.item.ModItemGroups;
import net.acupofchicory.testmod.item.ModItems;
import net.acupofchicory.testmod.power.PowerEvents;
import net.acupofchicory.testmod.power.PowerSystem;
import net.acupofchicory.testmod.power.WorldEventHandlers;
import net.acupofchicory.testmod.screen.ModScreenHandlers;
import net.acupofchicory.testmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
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
		WorldEventHandlers.register();
		PowerSystem.initialize();
		PowerEvents.register();
		WorldEventHandlers.register();

		net.acupofchicory.testmod.block.entity.ModBlockEntities.registerBlockEntities();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		ModScreenHandlers.registerScreenHandlers();



	}
}