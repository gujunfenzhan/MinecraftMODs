package com.mhxks.morecoal.client.render;

import com.mhxks.morecoal.MoreCoalMain;
import com.mhxks.morecoal.entity.EntityFire;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

import javax.annotation.Nullable;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;

public class RenderFire
extends Render<EntityFire> {
    private static final ResourceLocation EXPERIENCE_ORB_TEXTURES = new ResourceLocation(MoreCoalMain.MODID,"textures/entity/entity_fire.png");
    public RenderFire(RenderManager renderManager) {
        super(renderManager);
    }
    public int render = 0;
    @Override
    public void doRender(EntityFire entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (!this.renderOutlines) {
            render++;
            int index = render/4%4+1;

            GlStateManager.pushMatrix();
            GlStateManager.translate((float)x, (float)y, (float)z);
            GlStateManager.scale(0.1F,0.1F,0.1F);
            GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
            GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * -this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(180,1,0,0);
            this.bindEntityTexture(entity);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            glEnable(GL_BLEND);
            glBlendFunc(GL_SRC_ALPHA,GL_ONE_MINUS_SRC_ALPHA);
            //glDisable(GL_CULL_FACE);
            glDisable(GL_LIGHTING);
            bufferbuilder.begin(GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_TEX);
            //index 1-4

            bufferbuilder.pos(-1, 1, 0).tex(0, index/4.0F).endVertex();
            bufferbuilder.pos(1, 1, 0).tex(1, index/4.0F).endVertex();
            bufferbuilder.pos(-1, -1, 0).tex(0, (index-1)/4.0F).endVertex();
            bufferbuilder.pos(1, -1, 0).tex(1, (index-1)/4.0F).endVertex();
            tessellator.draw();
            glDisable(GL_BLEND);
            glEnable(GL_LIGHTING);
            //glDisable(GL_CULL_FACE);
            GlStateManager.popMatrix();

            super.doRender(entity, x, y, z, entityYaw, partialTicks);
        }
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityFire entity) {
        return EXPERIENCE_ORB_TEXTURES;
    }
}
