package net.acupofchicory.testmod.blocks;

// PowerCableBlockEntity.java

// import net.acupofchicory.testmod.block.ModBlockEntities;
import net.acupofchicory.testmod.power.CableNode;
import net.acupofchicory.testmod.power.PowerSystem;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//public class PowerCableBlockEntity extends BlockEntity {
//    private CableNode node;
//
//    public PowerCableBlockEntity(BlockPos pos, BlockState state) {
//        super(ModBlockEntities.POWER_CABLE, pos, state);
//    }
//
//    public static void tick(World world, BlockPos pos, BlockState state, PowerCableBlockEntity blockEntity) {
//        if (!world.isClient && blockEntity.node == null) {
//            blockEntity.node = new CableNode(pos);
//            PowerSystem.getNodeManager().addNode(pos, blockEntity.node);
//        }
//    }
//
//    @Override
//    public void readNbt(NbtCompound nbt) {
//        super.readNbt(nbt);
//        // Загрузка данных при загрузке чанка
//    }
//
//    @Override
//    protected void writeNbt(NbtCompound nbt) {
//        super.writeNbt(nbt);
//        // Сохранение данных при выгрузке чанка
//    }
//}
