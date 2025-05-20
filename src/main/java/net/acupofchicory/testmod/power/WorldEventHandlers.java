package net.acupofchicory.testmod.power;


import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;

public class WorldEventHandlers {
    public static void register() {
        ServerWorldEvents.LOAD.register((server, world) -> {
            PowerSystem.onWorldLoad(world);
        });

        ServerWorldEvents.UNLOAD.register((server, world) -> {
            PowerSystem.onWorldUnload(world);
        });
    }
}
