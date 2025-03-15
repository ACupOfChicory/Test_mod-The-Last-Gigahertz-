package net.acupofchicory.testmod.block;

import net.acupofchicory.testmod.TestMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    // новые блоки (да, вот эта длинная дичь
    //чтобы добавить блок нужно еще скопировать
    // и поменять blockstates, models/block, models/item и textures/block
    // увы
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(7.0F, 17.0F)));
    public static final Block STEEL_BLOCK_PLATE = registerBlock("steel_block_plate",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5.0F, 18.0F)));
    public static final Block STEEL_BLOCK_PLATE_REINFORCED = registerBlock("steel_block_plate_reinforced",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6.0F, 20.0F)));
    public static final Block COKE_BLOCK = registerBlock("coke_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).strength(3.0F, 10.0F)));
    public static final Block BORAX_ORE = registerBlock("borax_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2,8)));
    public static final Block BORAX_DEEPLSLATE_ORE = registerBlock("borax_deepslate_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(3f), UniformIntProvider.create(2,8)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block ) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks for " + TestMod.MOD_ID);


    }
}
