package net.acupofchicory.testmod.blocks;

// PowerCableBlock.java

import net.acupofchicory.testmod.power.PowerSystem;
import net.acupofchicory.testmod.power.CableNode;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

//public class PowerCableBlock extends BlockWithEntity {
//    // Свойства для визуального соединения с соседями
//    public static final BooleanProperty NORTH = Properties.NORTH;
//    public static final BooleanProperty EAST = Properties.EAST;
//    public static final BooleanProperty SOUTH = Properties.SOUTH;
//    public static final BooleanProperty WEST = Properties.WEST;
//    public static final BooleanProperty UP = Properties.UP;
//    public static final BooleanProperty DOWN = Properties.DOWN;
//
//    public PowerCableBlock(Settings settings) {
//        super(settings);
//        this.setDefaultState(getDefaultState()
//                .with(NORTH, false)
//                .with(EAST, false)
//                .with(SOUTH, false)
//                .with(WEST, false)
//                .with(UP, false)
//                .with(DOWN, false));
//    }
//
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
//    }
//
//    @Nullable
//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        return updateConnections(this.getDefaultState(), ctx.getWorld(), ctx.getBlockPos());
//    }
//
//    // Обновление соединений с соседями
//    private BlockState updateConnections(BlockState state, World world, BlockPos pos) {
//        return state
//                .with(NORTH, canConnect(world, pos, Direction.NORTH))
//                .with(EAST, canConnect(world, pos, Direction.EAST))
//                .with(SOUTH, canConnect(world, pos, Direction.SOUTH))
//                .with(WEST, canConnect(world, pos, Direction.WEST))
//                .with(UP, canConnect(world, pos, Direction.UP))
//                .with(DOWN, canConnect(world, pos, Direction.DOWN));
//    }
//
//    private boolean canConnect(World world, BlockPos pos, Direction direction) {
//        BlockPos neighborPos = pos.offset(direction);
//        BlockState neighborState = world.getBlockState(neighborPos);
//        // Проверяем, можно ли соединиться с соседним блоком
//        return neighborState.getBlock() instanceof PowerCableBlock ||
//                neighborState.getBlock() instanceof EnergyStorageBlock;
//    }
//
//    @Override
//    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
//        super.onPlaced(world, pos, state, placer, itemStack);
//        if (!world.isClient) {
//            PowerSystem.getNodeManager().addNode(pos, new CableNode(pos));
//            updateNeighbors(world, pos);
//        }
//    }
//
//    @Override
//    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
//        if (!state.isOf(oldState.getBlock())) {
//            world.updateNeighbors(pos, this);
//        }
//    }
//
//    @Override
//    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
//        if (!state.isOf(newState.getBlock())) {
//            super.onStateReplaced(state, world, pos, newState, moved);
//            if (!world.isClient) {
//                PowerSystem.getNodeManager().removeNode(pos);
//                updateNeighbors(world, pos);
//            }
//        }
//    }
//
//    private void updateNeighbors(World world, BlockPos pos) {
//        world.updateNeighborsAlways(pos, this);
//        for (Direction direction : Direction.values()) {
//            world.updateNeighborsAlways(pos.offset(direction), this);
//        }
//    }
//
//    @Nullable
//    @Override
//    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
//        return new PowerCableBlockEntity(pos, state);
//    }
//
//    @Override
//    public BlockRenderType getRenderType(BlockState state) {
//        return BlockRenderType.MODEL;
//    }
//}
