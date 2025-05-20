package net.acupofchicory.testmod.datagen;

import net.acupofchicory.testmod.block.ModBlocks;
import net.acupofchicory.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

import static net.acupofchicory.testmod.item.ModItems.*;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> BORAX_SMELTABLES = List.of(
            ModBlocks.BORAX_ORE, ModBlocks.BORAX_DEEPLSLATE_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, BORAX_SMELTABLES, RecipeCategory.MISC, ModItems. BORAX,
                0.7f, 200, "coke");
        offerBlasting(exporter, BORAX_SMELTABLES, RecipeCategory.MISC, ModItems. BORAX,
                0.7f, 100, "coke");
        offerBlasting(exporter, List.of(STEEL_COMPOUND), RecipeCategory.MISC, STEEL_INGOT,
                0.7f, 100, "coke");
        offerBlasting(exporter, List.of(Items.COAL), RecipeCategory.MISC, COKE,
                0.7f, 200, "coke");
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.BUILDING_BLOCKS, ModItems.COKE,
                RecipeCategory.DECORATIONS, ModBlocks.COKE_BLOCK);
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.BUILDING_BLOCKS, STEEL_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.STEEL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STEEL_COMPOUND, 8)
                .pattern("SSS")
                .pattern("CCC")
                .pattern("SSS")
                .input('S', Items.IRON_INGOT)
                .input('C', ModItems.COKE)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .criterion(hasItem(ModItems.COKE), conditionsFromItem(ModItems.COKE))
                .offerTo(exporter, new Identifier("test-mod", getRecipeName(ModItems.STEEL_COMPOUND)));


//        createDoorRecipe(ModBlocks.STEEL_DOOR, Ingredient.ofItems(STEEL_INGOT));

    }
}
