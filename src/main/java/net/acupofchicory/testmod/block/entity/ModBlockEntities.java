package net.acupofchicory.testmod.block.entity;

import net.acupofchicory.testmod.TestMod;
import net.acupofchicory.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<SteelSmelterBlockEntity> STEEL_SMELTER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(TestMod.MOD_ID, "steel_smelter_be"),
                    FabricBlockEntityTypeBuilder.create(SteelSmelterBlockEntity::new,
                            ModBlocks.STEEL_SMELTER).build());

    public static void registerBlockEntities() {
      TestMod.LOGGER.info("Registering Block Entites for " + TestMod.MOD_ID);
    }
}
