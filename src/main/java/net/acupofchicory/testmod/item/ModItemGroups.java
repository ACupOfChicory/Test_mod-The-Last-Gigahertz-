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
                        entries.add(ModItems.STEEL_INGOT);
                        entries.add(ModBlocks.STEEL_BLOCK);
                        entries.add(ModItems.COKE);
                        entries.add(ModBlocks.COKE_BLOCK);




                    }).build());
    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for" + TestMod.MOD_ID);
    }

}
