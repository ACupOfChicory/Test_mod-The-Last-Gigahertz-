package net.acupofchicory.testmod.power;

import net.minecraft.util.math.BlockPos;

public abstract class PowerNode {
    protected BlockPos pos;
    protected PowerNetwork network;
    protected long lastEnergyAmount;
    protected boolean energyChanged = true;

    public PowerNode(BlockPos pos) {
        this.pos = pos;
    }

    public abstract boolean isProvider();
    public abstract boolean isConsumer();
    public abstract long getEnergyAmount();
    public abstract long getEnergyCapacity();

    public void setEnergyAmount(long amount) {
        if (amount != lastEnergyAmount) {
            lastEnergyAmount = amount;
            energyChanged = true;
            if (network != null) {
                network.cacheValid = false;
            }
        }
    }

    public boolean canConnect(PowerNode other) {
        // Базовая реализация - все узлы могут соединяться
        return true;
    }

    public void setNetwork(PowerNetwork network) {
        if (this.network != network) {
            if (this.network != null) {
                this.network.cacheValid = false;
            }
            this.network = network;
        }
    }

    public PowerNetwork getNetwork() {
        return network;
    }

    public BlockPos getPos() {
        return pos;
    }
}