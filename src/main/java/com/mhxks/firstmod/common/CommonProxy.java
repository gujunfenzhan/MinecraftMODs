package com.mhxks.firstmod.common;

import com.mhxks.firstmod.init.ModBlockLoader;
import com.mhxks.firstmod.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> reg) {
        reg.getRegistry().register(ModItemLoader.FUNNY_FRUIT);
        registerItemBlock(reg, ModBlockLoader.IRON_COAL);
        //注册物品
    }


    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> reg) {
        reg.getRegistry().register(ModBlockLoader.IRON_COAL);
        reg.getRegistry().register(ModBlockLoader.FLUID_DICHLORVOS);
        reg.getRegistry().register(ModBlockLoader.FLUID_ICE_BLACK_TEA);
        //注册方块
    }
    //注册方块在物品下的状态
    public void registerItemBlock(RegistryEvent.Register<Item> reg, Block block) {
        reg.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
