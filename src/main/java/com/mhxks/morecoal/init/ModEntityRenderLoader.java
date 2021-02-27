package com.mhxks.morecoal.init;

import com.mhxks.morecoal.client.render.RenderFire;
import com.mhxks.morecoal.client.render.RenderRedstoneCoal;
import com.mhxks.morecoal.entity.EntityFire;
import com.mhxks.morecoal.entity.EntityRedstoneCoal;
import com.mhxks.morecoal.entity.EntityRenderFactory;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntityRenderLoader {
    public ModEntityRenderLoader() {
        registerRenders();
        registerEntityRender(EntityFire.class, RenderFire.class);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerEntityRender(EntityRedstoneCoal.class, RenderRedstoneCoal.class);
    }

    @SideOnly(Side.CLIENT)
    private static <T extends Entity> void registerEntityRender(Class<T> entityClass, Class<? extends Render<T>> render)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<T>(render));
    }
}
