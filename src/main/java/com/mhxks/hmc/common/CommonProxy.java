package com.mhxks.hmc.common;

import com.mhxks.hmc.init.ModBlockLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
public class CommonProxy {
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> reg) {
        registerItemBlock(reg, ModBlockLoader.HARVESTER_MACHINE);
        registerItemBlock(reg,ModBlockLoader.LIVESTOCK_MACHINE);
        registerItemBlock(reg,ModBlockLoader.MACHINE);

    }


    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> reg) {
        reg.getRegistry().register(ModBlockLoader.HARVESTER_MACHINE);
        reg.getRegistry().register(ModBlockLoader.LIVESTOCK_MACHINE);
        reg.getRegistry().register(ModBlockLoader.MACHINE);
    }
    public void registerItemBlock(RegistryEvent.Register<Item> reg, Block block) {
        reg.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

}
