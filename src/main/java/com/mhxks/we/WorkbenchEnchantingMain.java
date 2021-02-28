package com.mhxks.we;

import com.mhxks.we.init.ModCraftingLoader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

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
}
