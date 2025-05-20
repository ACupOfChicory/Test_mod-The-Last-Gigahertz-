package net.acupofchicory.testmod.power;


import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

/**
 * Главный управляющий класс энергетической системы мода
 */
public class PowerSystem {
    private static final NodeManager nodeManager = new NodeManager();
    private static boolean initialized = false;

    /**
     * Инициализация энергосистемы
     */
    public static void initialize() {
        if (initialized) return;

        // Здесь можно добавить предварительную настройку
        initialized = true;
    }

    /**
     * Получить менеджер узлов
     */
    public static NodeManager getNodeManager() {
        return nodeManager;
    }

    /**
     * Обработчик загрузки мира
     */
    public static void onWorldLoad(ServerWorld world) {
        // При необходимости можно добавить загрузку сохраненных данных
    }

    /**
     * Обработчик выгрузки мира
     */
    public static void onWorldUnload(ServerWorld world) {
        // При необходимости можно добавить сохранение данных
    }

    /**
     * Проверка, работает ли система на серверной стороне
     */
    public static boolean isServerSide(World world) {
        return !world.isClient();
    }

    /**
     * Получить уникальный ID для новой сети
     */
    public static int getNewNetworkId() {
        return nodeManager.getNewNetworkId();
    }

    /**
     * Отладочная информация (для команд/debug)
     */
    public static String getDebugInfo() {
        return String.format("Nodes: %d, Networks: %d",
                nodeManager.getNodeCount(),
                nodeManager.getNetworkCount());
    }
}
