package com.mhxks.fastbuild.event;

import com.mhxks.fastbuild.init.ModItemLoader;
import com.mhxks.fastbuild.item.ItemFastBuildTool;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerEvent {
    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent event){
        EntityPlayerSP entityPlayerSP = FMLClientHandler.instance().getClientPlayerEntity();
        double x = entityPlayerSP.posX;
        double y = entityPlayerSP.posY;
        double z = entityPlayerSP.posZ;
        ItemStack itemStack = entityPlayerSP.getHeldItemMainhand();
        if(itemStack.getItem()== ModItemLoader.FAST_BUILD_TOOL){
            NBTTagCompound nbtTagCompound = ItemFastBuildTool.getTagNBT(itemStack);
            int startX = nbtTagCompound.getInteger("startX");
            int startY = nbtTagCompound.getInteger("startY");
            int startZ = nbtTagCompound.getInteger("startZ");
            int endX = nbtTagCompound.getInteger("endX");
            int endY = nbtTagCompound.getInteger("endY");
            int endZ = nbtTagCompound.getInteger("endZ");
            boolean isOn = nbtTagCompound.getBoolean("cube_fast_build");
            if(isOn){
                System.out.println("xuanran");
            }
        }
    }
}
