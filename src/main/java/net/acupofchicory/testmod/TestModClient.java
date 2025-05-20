package net.acupofchicory.testmod;

import net.acupofchicory.testmod.block.ModBlocks;
import net.acupofchicory.testmod.screen.ModScreenHandlers;
import net.acupofchicory.testmod.screen.SteelSmeltingScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STEEL_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STEEL_TRAPDOOR, RenderLayer.getCutout());


        HandledScreens.register(ModScreenHandlers.STEEL_SMELTING_SCREEN_HANDLER, SteelSmeltingScreen::new);
    }
}
