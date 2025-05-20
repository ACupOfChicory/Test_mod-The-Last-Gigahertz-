package net.acupofchicory.testmod.blocks;

// EnergyStorageBlockEntity.java
//import net.acupofchicory.testmod.block.ModBlockEntities;
import net.acupofchicory.testmod.power.StorageNode;
//import net.acupofchicory.testmod.block.ModBlockEntities;
import net.acupofchicory.testmod.power.PowerSystem;
import net.acupofchicory.testmod.power.StorageNode;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

//public class EnergyStorageBlockEntity extends BlockEntity {
//    private final StorageNode node;
//
//
//    public EnergyStorageBlockEntity(BlockPos pos, BlockState state, int capacity) {
//        super(ModBlockEntities.ENERGY_STORAGE, pos, state);
//        this.node = new StorageNode(pos, capacity);
//    }
//
//    public static void tick(World world, BlockPos pos, BlockState state, EnergyStorageBlockEntity blockEntity) {
//        if (!world.isClient) {
//            blockEntity.markDirty();
//            // Синхронизация с клиентом
//            world.updateListeners(pos, state, state, Block.NOTIFY_LISTENERS);
//        }
//    }
//
//    public StorageNode getNode() {
//        return node;
//    }
//
//    @Override
//    public void readNbt(NbtCompound nbt) {
//        super.readNbt(nbt);
//        node.setEnergyAmount(nbt.getLong("Energy"));
//    }
//
//    @Override
//    protected void writeNbt(NbtCompound nbt) {
//        super.writeNbt(nbt);
//        nbt.putLong("Energy", node.getEnergyAmount());
//    }
//
//    @Nullable
//    @Override
//    public Packet<ClientPlayPacketListener> toUpdatePacket() {
//        return BlockEntityUpdateS2CPacket.create(this);
//    }
//
//    @Override
//    public NbtCompound toInitialChunkDataNbt() {
//        return createNbt();
//    }
//}