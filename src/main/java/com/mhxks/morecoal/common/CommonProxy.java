package com.mhxks.morecoal.common;
import com.mhxks.morecoal.init.ModBlockLoader;
import com.mhxks.morecoal.init.ModCraftingLoader;
import com.mhxks.morecoal.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy {
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> reg) {
        reg.getRegistry().register(ModItemLoader.IROM_COAL);
        reg.getRegistry().register(ModItemLoader.GOLD_COAL);
        reg.getRegistry().register(ModItemLoader.DIAMOND_COAL);
        reg.getRegistry().register(ModItemLoader.EMERALD_COAL);
        reg.getRegistry().register(ModItemLoader.REDSTONE_COAL);
        reg.getRegistry().register(ModItemLoader.DYE4_COAL);

        registerItemBlock(reg, ModBlockLoader.IRON_COAL);
        registerItemBlock(reg, ModBlockLoader.GOLD_COAL);
        registerItemBlock(reg, ModBlockLoader.DIAMOND_COAL);
        registerItemBlock(reg, ModBlockLoader.EMERALD_COAL);
        registerItemBlock(reg, ModBlockLoader.REDSTONE_COAL);
        registerItemBlock(reg, ModBlockLoader.DYE4_COAL);


    }


    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> reg) {
        reg.getRegistry().register(ModBlockLoader.IRON_COAL);
        reg.getRegistry().register(ModBlockLoader.GOLD_COAL);
        reg.getRegistry().register(ModBlockLoader.DIAMOND_COAL);
        reg.getRegistry().register(ModBlockLoader.EMERALD_COAL);
        reg.getRegistry().register(ModBlockLoader.REDSTONE_COAL);
        reg.getRegistry().register(ModBlockLoader.DYE4_COAL);

    }
    public void registerItemBlock(RegistryEvent.Register<Item> reg, Block block) {
        reg.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
