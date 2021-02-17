package com.mhxks.fastbuild.client.gui;

import com.mhxks.fastbuild.ModFastBuild;
import com.mhxks.fastbuild.client.gui.button.ButtonOnOffFastBuildTool;
import com.mhxks.fastbuild.client.gui.button.GuiTextFieldFastBuildTool;
import com.mhxks.fastbuild.item.ItemFastBuildTool;
import com.mhxks.fastbuild.network.FastBuildCubeMessage;
import com.mhxks.fastbuild.network.FastBuildCubeMessageHandler;
import net.minecraft.block.Block;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import scala.Int;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiScreenFastBuildTool
extends GuiScreen {
    protected String screenTitle = "";
    public int xSize;
    public int ySize;
    public GuiListExtended guiOptionsRowList;
    public GuiTextField cube_startx;
    public GuiTextField cube_startY;
    public GuiTextField cube_startZ;
    public GuiTextField cube_endX;
    public GuiTextField cube_endY;
    public GuiTextField cube_endZ;
    public int offsetX;
    public int offsetY;
    public ItemStack itemStack;
    public World world;
    public List<GuiTextField> postionGuiTextField = new ArrayList<>();
    public GuiButton cube_Hollow;
    public EntityPlayer entityPlayer;

    public GuiScreenFastBuildTool(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        this.xSize=214;
        this.ySize=210;
        offsetX = (this.width-this.xSize)/2;
        offsetY = (this.height-this.ySize)/2;
        this.itemStack = itemStack;
        this.world = world;
        this.entityPlayer = entityPlayer;
    }

    public static final ResourceLocation TEXTURES_PATH = new ResourceLocation(ModFastBuild.MODID,"textures/gui/gui_fast_build_tool.png");
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        GlStateManager.enableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES_PATH);
        offsetX = (this.width-this.xSize)/2;
        offsetY = (this.height-this.ySize)/2;
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, offsetY+10, 16777215);
        this.drawCenteredString(this.fontRenderer, "第一点", this.width / 2-80, offsetY+25, 16777215);
        this.drawCenteredString(this.fontRenderer, "第二点", this.width / 2-80, offsetY+40, 16777215);
        this.drawCenteredString(this.fontRenderer, "立方体", this.width / 2-80, offsetY+60, 16777215);
        //this.guiOptionsRowList.drawScreen(mouseX,mouseY,partialTicks);
        for (GuiTextField guiTextField : postionGuiTextField) {
            guiTextField.drawTextBox();
        }
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        if(itemStack!=null){
            nbtTagCompound = itemStack.getTagCompound();

        }
        ItemStack itemStack = new ItemStack(nbtTagCompound.getCompoundTag("item_selector"));
        GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        this.itemRender.renderItemAndEffectIntoGUI(itemStack,this.width/2+70,offsetY+35);
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        super.initGui();
        offsetX = (this.width-this.xSize)/2;
        offsetY = (this.height-this.ySize)/2;
        this.screenTitle = I18n.format("options.videoTitle");
        this.buttonList.clear();
        this.postionGuiTextField.clear();
        this.buttonList.add(new GuiButton(200, this.width / 2 - 75, this.height - 50,150,20, I18n.format("gui.done")));
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        if(itemStack!=null){
            nbtTagCompound = itemStack.getTagCompound();

        }

        //this.buttonList.add(new GuiButton(1,this.width/2-20,this.height-200,50,20,"预览:开"));
        cube_Hollow = new ButtonOnOffFastBuildTool(101,this.width/2-60,offsetY+55,"空心:开","空心:关");
        this.buttonList.add(cube_Hollow);
        this.buttonList.add(new ButtonOnOffFastBuildTool(102,this.width/2-10,offsetY+55,"预览:开","预览:关"));
        this.buttonList.add(new GuiButton(103,this.width/2+40,offsetY+55,40,20,"建造"));
        this.buttonList.add(new GuiButton(104,this.width/2+55,offsetY+10,45,20,"物品选择 "));


        this.cube_startx = new GuiTextFieldFastBuildTool(2,this.fontRenderer,this.width/2-60,offsetY+25,30,10);
        this.cube_startx.setCanLoseFocus(true);
        this.cube_startx.setText(String.valueOf(nbtTagCompound.getInteger("startX")));
        postionGuiTextField.add(cube_startx);
        this.cube_startY = new GuiTextFieldFastBuildTool(3,this.fontRenderer,this.width/2-20,offsetY+25,30,10);
        this.cube_startY.setCanLoseFocus(true);
        this.cube_startY.setText(String.valueOf(nbtTagCompound.getInteger("startY")));
        postionGuiTextField.add(cube_startY);
        this.cube_startZ = new GuiTextFieldFastBuildTool(3,this.fontRenderer,this.width/2+20,offsetY+25,30,10);
        this.cube_startZ.setCanLoseFocus(true);
        this.cube_startZ.setText(String.valueOf(nbtTagCompound.getInteger("startZ")));
        postionGuiTextField.add(cube_startZ);
        this.cube_endX = new GuiTextFieldFastBuildTool(4,this.fontRenderer,this.width/2-60,offsetY+40,30,10);
        this.cube_endX.setCanLoseFocus(true);
        this.cube_endX.setText(String.valueOf(nbtTagCompound.getInteger("endX")));
        postionGuiTextField.add(cube_endX);
        this.cube_endY = new GuiTextFieldFastBuildTool(5,this.fontRenderer,this.width/2-20,offsetY+40,30,10);
        this.cube_endY.setCanLoseFocus(true);
        this.cube_endY.setText(String.valueOf(nbtTagCompound.getInteger("endY")));
        postionGuiTextField.add(cube_endY);
        this.cube_endZ = new GuiTextFieldFastBuildTool(6,this.fontRenderer,this.width/2+20,offsetY+40,30,10);
        this.cube_endZ.setCanLoseFocus(true);
        this.cube_endZ.setText(String.valueOf(nbtTagCompound.getInteger("endZ")));
        postionGuiTextField.add(cube_endZ);



    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button.enabled){
            if(button.id==200){
                FMLClientHandler.instance().getClientPlayerEntity().closeScreen();
            }if(button.id==103){
                if(world!=null) {
                    int dim = world.provider.getDimension();
                    NBTTagCompound nbtTagCompound = ItemFastBuildTool.getTagNBT(itemStack);
                    boolean isHollow = ((ButtonOnOffFastBuildTool)cube_Hollow).isOn;
                    try {
                        int startX = Integer.parseInt(cube_startx.getText());
                        int startY = Integer.parseInt(cube_startY.getText());
                        int startZ = Integer.parseInt(cube_startZ.getText());
                        int endX = Integer.parseInt(cube_endX.getText());
                        int endY = Integer.parseInt(cube_endY.getText());
                        int endZ = Integer.parseInt(cube_endZ.getText());
                        if(startX==endX&&startY==endY&&startZ==endZ){
                            entityPlayer.sendMessage(new TextComponentString("请重新选择两点"));
                        }else {
                            NBTTagCompound nbtTagCompound1 = ItemFastBuildTool.getTagNBT(this.itemStack);
                            ItemStack itemStack = new ItemStack(nbtTagCompound.getCompoundTag("item_selector"));
                            ModFastBuild.getNetwork().sendToServer(new FastBuildCubeMessage(dim, startX, startY, startZ, endX, endY, endZ, isHollow,itemStack));
                            FastBuildCubeMessageHandler.genBlock(world,dim,startX,startY,startZ,endX,endY,endZ,isHollow,itemStack);
                        }
                    }catch (Exception e){
                        entityPlayer.sendMessage(new TextComponentString("参数有误"));
                    }

                }
                entityPlayer.closeScreen();
            }else if(button.id==104){
                this.mc.displayGuiScreen(new GuiFastBuildSelector(this,entityPlayer,itemStack));
            }
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    @Override
    public void updateScreen()
    {
        super.updateScreen();
        for (GuiTextField guiTextField : postionGuiTextField) {
            guiTextField.updateCursorCounter();
        }
        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead)
        {
            this.mc.player.closeScreen();
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == 1 || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.player.closeScreen();
        }
        for (GuiTextField guiTextField : postionGuiTextField) {
            guiTextField.textboxKeyTyped(typedChar,keyCode);
        }
        super.keyTyped(typedChar, keyCode);

    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for (GuiTextField guiTextField : postionGuiTextField) {
            guiTextField.mouseClicked(mouseX,mouseY,mouseButton);
        }
    }

}
