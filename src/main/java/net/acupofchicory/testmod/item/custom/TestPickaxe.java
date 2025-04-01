package net.acupofchicory.testmod.item.custom;

import net.acupofchicory.testmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import javax.lang.model.element.VariableElement;

public class TestPickaxe extends Item {
    public TestPickaxe(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {


        BlockPos positionClicked = context.getBlockPos();
        World world = context.getWorld();
        // world.breakBlock(positionClicked, true);
        if (!world.isClient) {
        for(int y = 1; y >= -1; y = y - 1){
            for(int z = 1; z >= -1; z = z - 1){
                for(int x = 1; x >= -1; x = x - 1){
                    world.breakBlock(positionClicked.add(y, z, x), true);
                }
            }
        }
        }


        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
//        if (!world.isClient) {
//            createHole(world, positionClicked);
//        }
        return ActionResult.SUCCESS;
    }
    private void createHole(World world, BlockPos center) {
        int radius = 100;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {

                    double distance = Math.sqrt(x * x + y * y + z * z);

                    if (distance <= radius) { // Only remove blocks inside the sphere
                        BlockPos targetPos = center.add(x, y, z);

                        // Stops from removing bedrock
                        if (!world.getBlockState(targetPos).isOf(net.minecraft.block.Blocks.BEDROCK)) {
                            world.setBlockState(targetPos, net.minecraft.block.Blocks.AIR.getDefaultState());
                        }

                        // Places fire
                        if (world.getBlockState(targetPos.down()).isSolidBlock(world, targetPos.down()) && world.random.nextFloat() < 0.05) {
                            world.setBlockState(targetPos, net.minecraft.block.Blocks.FIRE.getDefaultState());
                        }
                    }
                }
            }
        }
    }
}

