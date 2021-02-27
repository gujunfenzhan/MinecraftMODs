package com.mhxks.fastbuild;
import com.mhxks.fastbuild.common.CommonProxy;
import com.mhxks.fastbuild.event.PlayerEvent;
import com.mhxks.fastbuild.init.ModGuiLoader;
import com.mhxks.fastbuild.init.ModNetworkLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = ModFastBuild.MODID,name = ModFastBuild.MODNAME,version = ModFastBuild.VERSION)
public class ModFastBuild {
    @SidedProxy(serverSide = "com.mhxks.fastbuild.common.CommonProxy",clientSide = "com.mhxks.fastbuild.client.ClientProxy")
    public static CommonProxy PROXY;
    public static final String MODID = "fastbuild";
    public static final String MODNAME = "FastBuild";
    public static final String VERSION = "1.0.0";

    @Mod.Instance
    public static ModFastBuild INSTANCE;
    private static SimpleNetworkWrapper NETWORK;
    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event){
        INSTANCE = this;
        MinecraftForge.EVENT_BUS.register(PROXY);
        NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        new ModGuiLoader();
        new ModNetworkLoader();
        MinecraftForge.EVENT_BUS.register(new PlayerEvent());
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event){

    }
    public static SimpleNetworkWrapper getNetwork() {
        return NETWORK;
    }
}
