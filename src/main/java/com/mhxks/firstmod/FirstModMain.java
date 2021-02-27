package com.mhxks.firstmod;

import com.mhxks.firstmod.common.CommonProxy;
import com.mhxks.firstmod.init.ModFluidLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FirstModMain.MODID,name = FirstModMain.MODNAME,version = FirstModMain.VERSION)
public class FirstModMain {
    //serverSide是写服务代理的class路径，clientSide同理
    //PROXY必须写在注解的后面
    @SidedProxy(serverSide = "com.mhxks.firstmod.common.CommonProxy",clientSide = "com.mhxks.firstmod.client.ClientProxy")
    public static CommonProxy PROXY;
    //模组的id
    public static final String MODID = "firstmod";
    //模组名字
    public static final String MODNAME = "MyFirstMod";
    //模组版本
    public static final String VERSION = "1.0.0";
    @Mod.Instance
    public static FirstModMain INSTANCE;
    /*模组在被加载的时候是顺序执行下面的三个方法，其中FMLPreInitializationEvent是最先被执行的
    FMLInitializationEvent其次
    FMLPostInitializationEvent最后
     */
    static{
        FluidRegistry.enableUniversalBucket();
    }
    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event){
        INSTANCE = this;
        //注册客户代理与服务代理
        MinecraftForge.EVENT_BUS.register(PROXY);
        new ModFluidLoader(event);

        //主要注册物品，方块，生物等等
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
    }
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event){
        //主要注册合成表
    }
}
