package net.acupofchicory.testmod.screen;

import net.acupofchicory.testmod.TestMod;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<SteelSmeltingScreenHandler> STEEL_SMELTING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(TestMod.MOD_ID, "steel_smelting"),
                    new ExtendedScreenHandlerType<>(SteelSmeltingScreenHandler::new));

    public static void registerScreenHandlers() {
        TestMod.LOGGER.info("Registering Screen Handlers for " + TestMod.MOD_ID);
    }
}
