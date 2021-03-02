package com.mhxks.hmc.common;

import com.mhxks.hmc.init.ModBlockLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public static void registerItems() {
        registerItemBlock(ModBlockLoader.HARVESTER_MACHINE);
        registerItemBlock(ModBlockLoader.LIVESTOCK_MACHINE);
        registerItemBlock(ModBlockLoader.MACHINE);

    }

    public static void registerBlocks() {
        GameRegistry.register(ModBlockLoader.HARVESTER_MACHINE);
        GameRegistry.register(ModBlockLoader.LIVESTOCK_MACHINE);
        GameRegistry.register(ModBlockLoader.MACHINE);
    }
    public static void registerItemBlock(Block block) {
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

}
