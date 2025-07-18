package net.acupofchicory.testmod.item;

import net.acupofchicory.testmod.TestMod;
import net.acupofchicory.testmod.item.custom.HammerItem;
import net.acupofchicory.testmod.item.custom.MetalDetectorItem;
import net.acupofchicory.testmod.item.custom.TestPickaxe;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // новые предметы
    public static final Item COKE = registerItem("coke", new Item(new FabricItemSettings()));
    public static final Item STEEL_INGOT = registerItem("steel_ingot", new Item(new FabricItemSettings()));
    public static final Item STEEL_NUGGET = registerItem("steel_nugget", new Item(new FabricItemSettings()));
    public static final Item STEEL_COMPOUND = registerItem("steel_compound", new Item(new FabricItemSettings()));
    public static final Item BORAX = registerItem("borax", new Item(new FabricItemSettings()));


    public static final Item INDUSTRIAL_BREAKFAST = registerItem("industrial_breakfast", new Item(new FabricItemSettings().food(ModFoodComponents.INDUSTRIAL_BREAKFAST)));


    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(256)));
    public static final Item TEST_PICKAXE = registerItem("test_pickaxe",
            new TestPickaxe(new FabricItemSettings().maxDamage(256)));

    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe",
            new PickaxeItem(ModToolMaterial.STEEL, 4, -1.4f, new FabricItemSettings()));
    public static final Item STEEL_HAMMER = registerItem("steel_hammer",
            new HammerItem(8, -2.8f, ModToolMaterial.STEEL, new FabricItemSettings()));
    public static final Item STEEL_AXE = registerItem("steel_axe",
            new AxeItem(ModToolMaterial.STEEL, 9f, -2.8f, new FabricItemSettings()));
    public static final Item STEEL_SHOVEl = registerItem("steel_shovel",
            new ShovelItem(ModToolMaterial.STEEL, 4f, -2f, new FabricItemSettings()));
    public static final Item STEEL_SWORD = registerItem("steel_sword",
            new SwordItem(ModToolMaterial.STEEL, 8, -2.4f, new FabricItemSettings()));
    public static final Item STEEL_HOE = registerItem("steel_hoe",
            new HoeItem(ModToolMaterial.STEEL, 4, -2.6f, new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        // новые предметы в вкладку
        // entries.add(COKE);
        // entries.add(STEEL_INGOT);
    }

    private static Item registerItem(String name, Item item ) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);

    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " +  TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
