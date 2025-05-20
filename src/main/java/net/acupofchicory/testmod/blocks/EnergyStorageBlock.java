package net.acupofchicory.testmod.blocks;

// EnergyStorageBlock.java


import net.acupofchicory.testmod.power.PowerSystem;
import net.acupofchicory.testmod.power.StorageNode;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

//public class EnergyStorageBlock extends BlockWithEntity {
//    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
//    private final int capacity;
//
//    public EnergyStorageBlock(Settings settings, int capacity) {
//        super(settings);
//        this.capacity = capacity;
//        this.setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
//    }
//
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(FACING);
//    }
//
//    @Nullable
//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
//    }
//
//    @Override
//    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
//        super.onPlaced(world, pos, state, placer, itemStack);
//        if (!world.isClient) {
//            PowerSystem.getNodeManager().addNode(pos, new StorageNode(pos, capacity));
//        }
//    }
//
//    @Override
//    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
//        if (!state.isOf(newState.getBlock())) {
//            if (!world.isClient) {
//                PowerSystem.getNodeManager().removeNode(pos);
//            }
//            super.onStateReplaced(state, world, pos, newState, moved);
//        }
//    }
//
//    @Nullable
//    @Override
//    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
//        return new EnergyStorageBlockEntity(pos, state, capacity);
//    }
//
//    @Override
//    public BlockRenderType getRenderType(BlockState state) {
//        return BlockRenderType.MODEL;
//    }
//    public int getCapacity() {
//        return capacity;
//    }
//}
