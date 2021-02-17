package com.mhxks.fastbuild.client.gui;

import com.mhxks.fastbuild.ModFastBuild;
import com.mhxks.fastbuild.container.ContainerFastBuildTool;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

public class GuiFastBuildTool
extends GuiContainer {
    public static final ResourceLocation TEXTURES_PATH = new ResourceLocation(ModFastBuild.MODID,"textures/gui/gui_fast_build_tool.png");
    private ContainerFastBuildTool inventory;
    public GuiFastBuildTool(ContainerFastBuildTool inventorySlotsIn) {
        super(inventorySlotsIn);
        this.xSize=214;
        this.ySize=210;
        this.inventory = inventorySlotsIn;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES_PATH);
        int offsetX = (this.width-this.xSize)/2,offsetY = (this.height-this.ySize)/2;
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tile = I18n.format("gui_fast_build_tool.1.desc");
        this.fontRenderer.drawString(tile, (this.xSize - this.fontRenderer.getStringWidth(tile)) / 2, 10, 0x404040);
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @Override
    public void initGui() {

        super.initGui();
    }
}
