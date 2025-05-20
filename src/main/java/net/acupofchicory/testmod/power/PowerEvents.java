package net.acupofchicory.testmod.power;

// Файл: PowerEvents.java
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;

public class PowerEvents {
    public static void register() {
        // Тик энергосистемы
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            PowerSystem.getNodeManager().tick();
        });

        // События чанков
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            PowerSystem.getNodeManager().onChunkLoad(chunk.getPos());
        });

        ServerChunkEvents.CHUNK_UNLOAD.register((world, chunk) -> {
            PowerSystem.getNodeManager().onChunkUnload(chunk.getPos());
        });
    }
}
