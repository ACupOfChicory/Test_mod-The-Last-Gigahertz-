package net.acupofchicory.testmod.power;

// StorageNode.java

import net.minecraft.util.math.BlockPos;

// StorageNode.java


import net.minecraft.util.math.BlockPos;

public class StorageNode extends PowerNode {
    private long energy;
    private final long capacity;

    public StorageNode(BlockPos pos, long capacity) {
        super(pos);
        this.capacity = capacity;
    }

    @Override
    public boolean isProvider() {
        return energy > 0;
    }

    @Override
    public boolean isConsumer() {
        return energy < capacity;
    }

    @Override
    public long getEnergyAmount() {
        return energy;
    }

    @Override
    public long getEnergyCapacity() {
        return capacity;
    }

    @Override
    public void setEnergyAmount(long amount) {
        this.energy = Math.max(0, Math.min(amount, capacity));
    }

    public long getCapacity() {
        return capacity;
    }
}