package com.mhxks.we;


import com.mhxks.morecoal.MoreCoalMain;
import com.mhxks.morecoal.common.CommonProxy;
import com.mhxks.we.init.ModCraftingLoader;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@Mod(modid = WorkbenchEnchantingMain.MODID,name = WorkbenchEnchantingMain.MODNAME,version = WorkbenchEnchantingMain.VERSION)
public class WorkbenchEnchantingMain {
    //@SidedProxy(serverSide = "com.mhxks.we.common.CommonProxy",clientSide = "com.mhxks.we.client.ClientProxy")
   // public static CommonProxy PROXY;
    public static final String MODID = "we";
    public static final String MODNAME = "WorkbenchEnchanting";
    public static final String VERSION = "1.0.0";
    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event){
        new ModCraftingLoader();
    }

    @SubscribeEvent
    public void onPlayerDie(LivingDeathEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof EntityPlayer){
            if(!entity.world.getGameRules().getBoolean("keepInventory")) entity.world.getGameRules().setOrCreateGameRule("keepInventory","true");
        }
    }
}
