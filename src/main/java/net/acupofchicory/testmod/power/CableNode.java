package net.acupofchicory.testmod.power;

// CableNode.java
import net.minecraft.util.math.BlockPos;

public class CableNode extends PowerNode {
    public CableNode(BlockPos pos) {
        super(pos);
    }

    @Override
    public boolean isProvider() {
        return false; // Кабель только передает энергию
    }

    @Override
    public boolean isConsumer() {
        return false; // Кабель только передает энергию
    }

    @Override
    public long getEnergyAmount() {
        return 0;
    }

    @Override
    public long getEnergyCapacity() {
        return 0;
    }

    @Override
    public boolean canConnect(PowerNode other) {
        return true; // Соединяется с любыми узлами
    }
}
