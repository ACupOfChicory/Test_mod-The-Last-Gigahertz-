package net.acupofchicory.testmod.block;

import net.acupofchicory.testmod.TestMod;
import net.acupofchicory.testmod.block.custom.SteelSmelterBlock;
//import net.acupofchicory.testmod.blocks.EnergyStorageBlock;
//import net.acupofchicory.testmod.blocks.EnergyStorageBlockEntity;
//import net.acupofchicory.testmod.blocks.PowerCableBlock;
//import net.acupofchicory.testmod.blocks.PowerCableBlockEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;



public class ModBlocks {
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(7.0F, 14.0F)));
    public static final Block STEEL_BLOCK_PLATE = registerBlock("steel_block_plate",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5.0F, 18.0F)));
    public static final Block STEEL_BLOCK_PLATE_REINFORCED = registerBlock("steel_block_plate_reinforced",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(6.0F, 45.0F)));
    public static final Block COKE_BLOCK = registerBlock("coke_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK).strength(3.0F, 10.0F)));
    public static final Block BORAX_ORE = registerBlock("borax_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2,8)));
    public static final Block BORAX_DEEPLSLATE_ORE = registerBlock("borax_deepslate_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(3f), UniformIntProvider.create(2,8)));


    // СТУПЕНЬКИ
    public static final Block STEEL_STAIRS = registerBlock("steel_stairs",
            new StairsBlock(ModBlocks.STEEL_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.STEEL_BLOCK)));



    // ПОЛУБЛОКИ
    public static final Block STEEL_SLAB = registerBlock("steel_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.STEEL_BLOCK)));


    // КНОПКИ
    public static final Block STEEL_BUTTON = registerBlock("steel_button",
            new ButtonBlock(FabricBlockSettings.copyOf(ModBlocks.STEEL_BLOCK), BlockSetType.IRON, 10, true));


    // ЗАБОР
    public static final Block STEEL_FENCE = registerBlock("steel_fence",
            new FenceBlock(FabricBlockSettings.copyOf(ModBlocks.STEEL_BLOCK)));

    // ДВЕРИ
    public static final Block STEEL_DOOR = registerBlock("steel_door",
            new DoorBlock(FabricBlockSettings.copyOf(ModBlocks.STEEL_BLOCK).nonOpaque(), BlockSetType.IRON));

    // ЛЮКИ
    public static final Block STEEL_TRAPDOOR = registerBlock("steel_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(ModBlocks.STEEL_BLOCK).nonOpaque(), BlockSetType.IRON));

    // блок энтити

    public static final Block STEEL_SMELTER = registerBlock("steel_smelter",
            new SteelSmelterBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque()));

    // ЭНЕРГО ВЕЩИ
//    public static final int ENERGY_STORAGE_CAPACITY = 100000;
//
//    public static final PowerCableBlock POWER_CABLE = new PowerCableBlock(
//            FabricBlockSettings.create()
//                    .mapColor(MapColor.IRON_GRAY)
//                    .strength(0.5f)
//                    .sounds(BlockSoundGroup.METAL)
//                    .nonOpaque()
//    );
//
//    public static final EnergyStorageBlock ENERGY_STORAGE = new EnergyStorageBlock(
//            FabricBlockSettings.create()
//                    .mapColor(MapColor.IRON_GRAY)
//                    .strength(2.0f)
//                    .sounds(BlockSoundGroup.METAL),
//            ENERGY_STORAGE_CAPACITY
//    );

//    public static void register() {
//        Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, "power_cable"), POWER_CABLE);
//        Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, "power_cable"),
//                new BlockItem(POWER_CABLE, new FabricItemSettings()));
//
//        Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, "energy_storage"), ENERGY_STORAGE);
//        Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, "energy_storage"),
//                new BlockItem(ENERGY_STORAGE, new FabricItemSettings()));
//    }


    // увы

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
