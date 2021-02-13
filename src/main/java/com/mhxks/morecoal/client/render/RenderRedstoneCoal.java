package com.mhxks.morecoal.client.render;

import com.mhxks.morecoal.entity.EntityRedstoneCoal;
import com.mhxks.morecoal.init.ModItemLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;

public class RenderRedstoneCoal
extends RenderSnowball<EntityRedstoneCoal> {
    public RenderRedstoneCoal(RenderManager renderManagerIn) {
        super(renderManagerIn, ModItemLoader.REDSTONE_COAL, Minecraft.getMinecraft().getRenderItem());
    }
}
