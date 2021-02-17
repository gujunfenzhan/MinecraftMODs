package com.mhxks.fastbuild.common;
import com.mhxks.fastbuild.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> reg) {
        reg.getRegistry().register(ModItemLoader.FAST_BUILD_TOOL);
    }


    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> reg) {

    }
    public void registerItemBlock(RegistryEvent.Register<Item> reg, Block block) {
        reg.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
