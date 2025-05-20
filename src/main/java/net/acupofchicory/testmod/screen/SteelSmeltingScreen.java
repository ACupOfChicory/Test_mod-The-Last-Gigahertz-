package net.acupofchicory.testmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.acupofchicory.testmod.TestMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SteelSmeltingScreen extends HandledScreen<SteelSmeltingScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(TestMod.MOD_ID, "textures/gui/steel_smelter_gui.png");

    public SteelSmeltingScreen(SteelSmeltingScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // можно поменять расположения названия блока и инвенторя игрока,   titleY = 1000; playerInventoryTitleY = 1000;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionProgram);
        RenderSystem.setShaderColor(1f,1f,1f,1f);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int x = (width- backgroundWidth) / 2;
        int y = (height- backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0 , 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 73, y + 35, 176, 15, 32, handler.getScaledProgress());
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
