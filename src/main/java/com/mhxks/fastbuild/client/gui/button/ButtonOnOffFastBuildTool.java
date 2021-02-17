package com.mhxks.fastbuild.client.gui.button;

import com.mhxks.fastbuild.item.ItemFastBuildTool;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ButtonOnOffFastBuildTool
extends GuiButton {
    public boolean isOn = false;
    public String offString = "";
    public ButtonOnOffFastBuildTool(int buttonId, int x, int y, String buttonText,String offText) {
        super(buttonId, x, y,40,20, buttonText);
        EntityPlayerSP entityPlayerSP = FMLClientHandler.instance().getClientPlayerEntity();
        ItemStack itemStack = entityPlayerSP.getHeldItemMainhand();
        NBTTagCompound nbtTagCompound = ItemFastBuildTool.getTagNBT(itemStack);
        this.isOn = nbtTagCompound.getBoolean("cube_fast_build");
        this.offString = offText;
    }
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
    {
        if (this.visible)
        {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (packedFGColour != 0)
            {
                j = packedFGColour;
            }
            else
            if (!this.enabled)
            {
                j = 10526880;
            }
            else if (this.hovered)
            {
                j = 16777120;
            }
            if(isOn) {
                this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
            }else{
                this.drawCenteredString(fontrenderer, this.offString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
            }
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY) {
        super.mouseReleased(mouseX, mouseY);
        this.isOn = !isOn;
        EntityPlayerSP entityPlayerSP = FMLClientHandler.instance().getClientPlayerEntity();
        ItemStack itemStack = entityPlayerSP.getHeldItemMainhand();
        NBTTagCompound nbtTagCompound = ItemFastBuildTool.getTagNBT(itemStack);
        nbtTagCompound.setBoolean("cube_fast_build",isOn);
        itemStack.setTagCompound(nbtTagCompound);
    }

    @Override
    protected void mouseDragged(Minecraft mc, int mouseX, int mouseY) {
        super.mouseDragged(mc, mouseX, mouseY);
    }

    @Override
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        return super.mousePressed(mc, mouseX, mouseY);
    }
}
