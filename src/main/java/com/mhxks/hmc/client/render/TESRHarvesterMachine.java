package com.mhxks.hmc.client.render;

import com.mhxks.hmc.HMCMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import static org.lwjgl.opengl.GL11.*;

public class TESRHarvesterMachine
extends TileEntitySpecialRenderer {
    public static ResourceLocation TEXTURE = new ResourceLocation(HMCMain.MODID, "textures/gui/range.png");
    public Tessellator tessellator = Tessellator.getInstance();
    public BufferBuilder bufferBuilder = tessellator.getBuffer();
    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240F, 240F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
        glDisable(GL_CULL_FACE);
        glDisable(GL_LIGHTING);
        bufferBuilder.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_TEX);
        glTranslated(x,y,z);
        bufferBuilder.pos(-5,0.7,6).tex(0,1).endVertex();
        bufferBuilder.pos(6,0.7,6).tex(1,1).endVertex();
        bufferBuilder.pos(-5,0.3,6).tex(0,0).endVertex();
        bufferBuilder.pos(6,0.3,6).tex(1,0).endVertex();
        tessellator.draw();

        bufferBuilder.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_TEX);
        //glTranslated(x,y,z);
        bufferBuilder.pos(-5,0.7,-5).tex(0,1).endVertex();
        bufferBuilder.pos(6,0.7,-5).tex(1,1).endVertex();
        bufferBuilder.pos(-5,0.3,-5).tex(0,0).endVertex();
        bufferBuilder.pos(6,0.3,-5).tex(1,0).endVertex();
        tessellator.draw();
        bufferBuilder.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(6,0.7,-5).tex(0,1).endVertex();
        bufferBuilder.pos(6,0.7,6).tex(1,1).endVertex();
        bufferBuilder.pos(6,0.3,-5).tex(0,0).endVertex();
        bufferBuilder.pos(6,0.3,6).tex(1,0).endVertex();
        tessellator.draw();
        bufferBuilder.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_TEX);
        bufferBuilder.pos(-5,0.7,-5).tex(0,1).endVertex();
        bufferBuilder.pos(-5,0.7,6).tex(1,1).endVertex();
        bufferBuilder.pos(-5,0.3,-5).tex(0,0).endVertex();
        bufferBuilder.pos(-5,0.3,6).tex(1,0).endVertex();
        tessellator.draw();
        glDisable(GL_BLEND);
        glEnable(GL_LIGHTING);
        glDisable(GL_CULL_FACE);
        GlStateManager.popMatrix();

        super.render(te, x, y, z, partialTicks, destroyStage, alpha);
    }
    public void renderRange(){

    }
}
