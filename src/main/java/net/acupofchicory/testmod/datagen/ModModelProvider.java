package net.acupofchicory.testmod.datagen;

import net.acupofchicory.testmod.block.ModBlocks;
import net.acupofchicory.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    // БЛОКИ
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BORAX_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BORAX_DEEPLSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COKE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool steelPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK_PLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STEEL_BLOCK_PLATE_REINFORCED );
    // ДВЕРИ ЛЮКИ
        blockStateModelGenerator.registerDoor(ModBlocks.STEEL_DOOR );
        blockStateModelGenerator.registerTrapdoor(ModBlocks.STEEL_TRAPDOOR );
    // РАЗНОЕ
    steelPool.stairs(ModBlocks.STEEL_STAIRS);
    steelPool.fence(ModBlocks.STEEL_FENCE);
    steelPool.slab(ModBlocks.STEEL_SLAB);
    steelPool.button(ModBlocks.STEEL_BUTTON);
    // блок энтити механизмы
        blockStateModelGenerator.registerSimpleState(ModBlocks.STEEL_SMELTER );

    // энергия
     //    blockStateModelGenerator.registerSimpleState(ModBlocks.ENERGY_STORAGE);
        //blockStateModelGenerator.registerItemModel(ModItems.ENERGY_STORAGE_ITEM);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    // ПРЕДМЕТЫ
        itemModelGenerator.register(ModItems.COKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_COMPOUND, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEEL_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BORAX, Models.GENERATED);

        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TEST_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STEEL_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SHOVEl, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STEEL_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.INDUSTRIAL_BREAKFAST, Models.GENERATED);
    }
}
