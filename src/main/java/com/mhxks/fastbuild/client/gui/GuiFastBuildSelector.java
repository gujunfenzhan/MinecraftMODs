package com.mhxks.fastbuild.client.gui;

import com.mhxks.fastbuild.ModFastBuild;
import com.mhxks.fastbuild.item.ItemFastBuildTool;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiFastBuildSelector
extends GuiScreen {
    public static final ResourceLocation TEXTURES_PATH = new ResourceLocation(ModFastBuild.MODID,"textures/gui/gui_fast_build_selector.png");
    public GuiScreenFastBuildTool par;
    public EntityPlayer entityPlayer;
    public int offsetX;
    public int offsetY;
    public int xSize;
    public int ySize;
    public ItemStack itemStack;
    public GuiFastBuildSelector(GuiScreenFastBuildTool par, EntityPlayer entityPlayer,ItemStack itemStack) {
        this.par = par;
        this.entityPlayer = entityPlayer;
        this.xSize=176;
        this.ySize=88;
        offsetX = (this.width-this.xSize)/2;
        offsetY = (this.height-this.ySize)/2;
        this.itemStack = itemStack;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        offsetX = (this.width-this.xSize)/2;
        offsetY = (this.height-this.ySize)/2;
        this.drawDefaultBackground();
        GlStateManager.enableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES_PATH);
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
        InventoryPlayer inventory = entityPlayer.inventory;
        int a = 0;
        int y = -9;
        GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();

        for (ItemStack itemStack : inventory.mainInventory) {

            if(a%9==0) {
                y+=18;
                a=0;
            }
            this.itemRender.renderItemAndEffectIntoGUI(itemStack,offsetX+a*18+9,offsetY+y);
            a++;
        }
        GlStateManager.popMatrix();
    }

    @Override
    public void initGui() {
        super.initGui();
        offsetX = (this.width-this.xSize)/2;
        offsetY = (this.height-this.ySize)/2;

    }


    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

    }
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    @Override
    public void updateScreen()
    {
        super.updateScreen();
        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead)
        {
            this.mc.player.closeScreen();
        }
    }
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == 1 || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.displayGuiScreen(par);
        }
        super.keyTyped(typedChar, keyCode);

    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        int x = mouseX-9-offsetX;
        int y = mouseY-9-offsetY;
        if(x>0&&x<18*9&&y>0&&y<18*4){
            int xIndex = x/18;
            int yIndex = y/18;
            int index = yIndex*9+xIndex;
            ItemStack itemStack = entityPlayer.inventory.mainInventory.get(index).copy();
            if(itemStack.getItem() instanceof ItemBlock|| itemStack.getItem()== Items.AIR){
                itemStack.setCount(1);
                NBTTagCompound nbtTagCompound = ItemFastBuildTool.getTagNBT(this.itemStack);
                nbtTagCompound.setTag("item_selector",itemStack.serializeNBT());
                this.itemStack.setTagCompound(nbtTagCompound);
                this.mc.displayGuiScreen(par);
            }

        }
    }
}
