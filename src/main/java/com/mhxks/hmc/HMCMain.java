package com.mhxks.hmc;

import com.mhxks.hmc.client.ClientProxy;
import com.mhxks.hmc.common.CommonProxy;
import com.mhxks.hmc.init.ModGuiLoader;
import com.mhxks.hmc.init.ModTileEntityLoader;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = HMCMain.MODID,name = HMCMain.MODNAME,version = HMCMain.VERSION)
public class HMCMain {
    @SidedProxy(serverSide = "com.mhxks.hmc.common.CommonProxy",clientSide = "com.mhxks.hmc.client.ClientProxy")
    public static CommonProxy PROXY;
    public static final String MODID = "hmc";
    public static final String MODNAME = "HMC";
    public static final String VERSION = "1.0.0";
    @Mod.Instance
    public static HMCMain INSTANCE;
    private static SimpleNetworkWrapper NETWORK;
    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event){
        INSTANCE = this;
        MinecraftForge.EVENT_BUS.register(PROXY);
        CommonProxy.registerBlocks();
        CommonProxy.registerItems();
        ClientProxy.registerModels();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        new ModTileEntityLoader();
        new ModGuiLoader();
    }
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event){

    }
}
