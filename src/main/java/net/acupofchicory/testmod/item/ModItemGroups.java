package net.acupofchicory.testmod.item;

import net.acupofchicory.testmod.TestMod;
import net.acupofchicory.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TEST_MOD = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "coke"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.coke"))
                    .icon(() -> new ItemStack(ModItems.STEEL_INGOT))
                    .entries((displayContext, entries) -> {
                        // сюда добавлять кастом предметы в вкладку
                        entries.add(ModBlocks.BORAX_ORE);
                        entries.add(ModBlocks.BORAX_DEEPLSLATE_ORE);
                        entries.add(ModItems.BORAX);
                        entries.add(ModItems.STEEL_COMPOUND);
                        entries.add(ModItems.STEEL_NUGGET);
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModBlocks.STEEL_BLOCK_PLATE);
                        entries.add(ModBlocks.STEEL_BLOCK_PLATE_REINFORCED);
                        entries.add(ModItems.COKE);
                        entries.add(ModBlocks.COKE_BLOCK);


                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.TEST_PICKAXE);
                        entries.add(ModItems.STEEL_PICKAXE);
                        entries.add(ModItems.STEEL_HAMMER);
                        entries.add(ModItems.STEEL_AXE);
                        entries.add(ModItems.STEEL_SHOVEl);
                        entries.add(ModItems.STEEL_SWORD);
                        entries.add(ModItems.STEEL_HOE);

                        entries.add(ModItems.INDUSTRIAL_BREAKFAST);

                        entries.add(ModBlocks.STEEL_FENCE);
                        entries.add(ModBlocks.STEEL_STAIRS);
                        entries.add(ModBlocks.STEEL_SLAB);
                        entries.add(ModBlocks.STEEL_DOOR);
                        entries.add(ModBlocks.STEEL_TRAPDOOR);
                        entries.add(ModBlocks.STEEL_BUTTON);
                        // блок энтити
                        entries.add(ModBlocks.STEEL_SMELTER);



                    }).build());
    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for" + TestMod.MOD_ID);
    }

}
