package net.acupofchicory.testmod.power;

import java.util.HashSet;
import java.util.Set;

public class PowerNetwork {
    private final int id;
    private final Set<PowerNode> providers = new HashSet<>();
    private final Set<PowerNode> consumers = new HashSet<>();
    private long lastTotalAvailable = 0;
    private long lastTotalDemand = 0;
    boolean cacheValid = false;
    private long lastTick = 0;

    public PowerNetwork(int id) {
        this.id = id;
    }

    public void addNode(PowerNode node) {
        if (node.isProvider()) {
            providers.add(node);
            cacheValid = false;
        }
        if (node.isConsumer()) {
            consumers.add(node);
            cacheValid = false;
        }
        node.setNetwork(this);
    }

    public void removeNode(PowerNode node) {
        if (providers.remove(node) || consumers.remove(node)) {
            cacheValid = false;
        }
        node.setNetwork(null);
    }

    public void clear() {
        providers.forEach(node -> node.setNetwork(null));
        consumers.forEach(node -> node.setNetwork(null));
        providers.clear();
        consumers.clear();
    }

    public void updateCache() {
        lastTotalAvailable = 0;
        lastTotalDemand = 0;

        for (PowerNode provider : providers) {
            lastTotalAvailable += provider.getEnergyAmount();
        }

        for (PowerNode consumer : consumers) {
            lastTotalDemand += consumer.getEnergyCapacity() - consumer.getEnergyAmount();
        }

        cacheValid = true;
    }

    public void tick() {
        long currentTick = System.currentTimeMillis();
        if (currentTick - lastTick < 50) return; // Не чаще чем раз в 50 мс
        lastTick = currentTick;

        if (providers.isEmpty() || consumers.isEmpty()) return;

        if (!cacheValid) {
            updateCache();
        }

        long totalTransfer = Math.min(lastTotalAvailable, lastTotalDemand);
        if (totalTransfer <= 0) return;

        double providerRatio = totalTransfer / (double) lastTotalAvailable;
        double consumerRatio = totalTransfer / (double) lastTotalDemand;

        // Применяем изменения
        for (PowerNode provider : providers) {
            long toExtract = (long) (provider.getEnergyAmount() * providerRatio);
            provider.setEnergyAmount(provider.getEnergyAmount() - toExtract);
        }

        for (PowerNode consumer : consumers) {
            long capacity = consumer.getEnergyCapacity() - consumer.getEnergyAmount();
            long toAdd = (long) (capacity * consumerRatio);
            consumer.setEnergyAmount(consumer.getEnergyAmount() + toAdd);
        }

        cacheValid = false; // Данные изменились, кэш невалиден
    }
}