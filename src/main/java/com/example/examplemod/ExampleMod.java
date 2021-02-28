package com.example.examplemod;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL11.glPushMatrix;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final ResourceLocation TEXTURE_PATH = new ResourceLocation(MODID,"textures/render/magic_circle.png");

    @EventHandler
    public void pre(FMLPreInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this);

    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());




    }


    @EventHandler
    public void post(FMLPostInitializationEvent event){

    }
    //@SubscribeEvent
    public void onPlayerRender(RenderWorldLastEvent event){

        Tessellator tessellator = Tessellator.instance;
        TextureManager manager = Minecraft.getMinecraft().renderEngine;
        glPushMatrix();
        glTranslated(0,-1.6,0);
        glRotated(((int)System.currentTimeMillis()%360000)/100D, 0, 1, 0);
        //glRotatef(event.partialTicks/20*360, 0, 1, 0);
        //glRotated(entityYaw, 0,1, 0);
        EntityClientPlayerMP playerController = Minecraft.getMinecraft().thePlayer;
        double x = playerController.posX;
        double y = playerController.posY;
        double z = playerController.posZ;
        //glTranslated(x, y, z);

        glDisable(GL_CULL_FACE);
        glDisable(GL_LIGHTING);
        //glRotated(player.rotationYaw,0, 1, 0);
        manager.bindTexture(TEXTURE_PATH);
        tessellator.startDrawingQuads();


        //glBegin(GL_QUADS);
        //glVertex2f(0, 0);
        //glVertex2f(0, 1);
        //glVertex2f(1, 1);
        //glVertex2f(1, 0);
        //glEnd();
        //buffer.begin(GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        //buffer.pos(5, 0, 5).tex(0, 0).endVertex();
        //buffer.pos(5, 0, -5).tex(0, 1).endVertex();
        //buffer.pos(-5, 0, -5).tex(1, 1).endVertex();
        //buffer.pos(-5, 0, 5).tex(1, 0).endVertex();
        tessellator.addVertexWithUV(-2.5,0,-2.5,0,0);
        tessellator.addVertexWithUV(2.5,0,-2.5,0,1);
        tessellator.addVertexWithUV(2.5,0,2.5,1,1);
        tessellator.addVertexWithUV(-2.5,0,2.5,1,0);
        tessellator.draw();

        glEnable(GL_CULL_FACE);
        //glEnable(GL_LIGHTING);
        //glClear(GL_COLOR_BUFFER_BIT);
        glPopMatrix();


    }
}
