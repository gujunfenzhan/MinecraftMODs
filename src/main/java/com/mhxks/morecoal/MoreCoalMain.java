package com.mhxks.morecoal;
import com.mhxks.morecoal.common.CommonProxy;
import com.mhxks.morecoal.event.MoreCoalEvent;
import com.mhxks.morecoal.init.ModCraftingLoader;
import com.mhxks.morecoal.init.ModEntityRenderLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import java.util.Random;

@Mod(modid = MoreCoalMain.MODID,name = MoreCoalMain.MODNAME,version = MoreCoalMain.VERSION)
public class MoreCoalMain {
    @SidedProxy(serverSide = "com.mhxks.morecoal.common.CommonProxy",clientSide = "com.mhxks.morecoal.client.ClientProxy")
    public static CommonProxy PROXY;
    public static final String MODID = "morecoal";
    public static final String MODNAME = "MoreCoal";
    public static final String VERSION = "1.0.0";
    @Mod.Instance
    public static MoreCoalMain INSTANCE;
    public static Random random = new Random();
    private static SimpleNetworkWrapper NETWORK;

    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event){
        INSTANCE = this;
        MinecraftForge.EVENT_BUS.register(PROXY);
        MinecraftForge.EVENT_BUS.register(new MoreCoalEvent());

        new ModEntityRenderLoader();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event){
        new ModCraftingLoader();
    }
}
