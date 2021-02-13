package com.mhxks.morecoal.init;

import com.mhxks.morecoal.MoreCoalMain;
import com.mhxks.morecoal.entity.EntityRedstoneCoal;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntityLoader {
    private static int nextID = 0;
    public ModEntityLoader() {
        registerEntity(EntityRedstoneCoal.class,"RedstoneCoal",64,10,true);
    }
    public void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
                               int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(new ResourceLocation(MoreCoalMain.MODID,name), entityClass, name, nextID++, MoreCoalMain.INSTANCE, trackingRange, updateFrequency,
                sendsVelocityUpdates);
    }
}
