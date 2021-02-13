package com.mhxks.hmc.client.gui;

import com.mhxks.hmc.HMCMain;
import com.mhxks.hmc.container.HarvesterMachineContainer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class HarvesterMachineGui
extends GuiContainer {
    public static final ResourceLocation TEXTURES_PATH = new ResourceLocation(HMCMain.MODID,"textures/gui/harvester_machine.png");;
    private HarvesterMachineContainer inventory;
    public HarvesterMachineGui(HarvesterMachineContainer inventorySlotsIn) {
        super(inventorySlotsIn);
        this.xSize=176;
        this.ySize=156;
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
        String tile = I18n.format("harvesterMachine.1.desc");
        this.fontRenderer.drawString(tile, (this.xSize - this.fontRenderer.getStringWidth(tile)) / 2, 10, 0x404040);
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }


}
