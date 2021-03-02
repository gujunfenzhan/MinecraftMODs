package com.mhxks.morecoal.common;
import com.mhxks.morecoal.MoreCoalMain;
import com.mhxks.morecoal.entity.EntityFire;
import com.mhxks.morecoal.init.ModBlockLoader;
import com.mhxks.morecoal.init.ModCraftingLoader;
import com.mhxks.morecoal.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public static void registerItems() {
        GameRegistry.register(ModItemLoader.IROM_COAL);
        GameRegistry.register(ModItemLoader.GOLD_COAL);
        GameRegistry.register(ModItemLoader.DIAMOND_COAL);
        GameRegistry.register(ModItemLoader.EMERALD_COAL);
        GameRegistry.register(ModItemLoader.REDSTONE_COAL);
        GameRegistry.register(ModItemLoader.DYE4_COAL);

        registerItemBlock(ModBlockLoader.IRON_COAL);
        registerItemBlock( ModBlockLoader.GOLD_COAL);
        registerItemBlock(ModBlockLoader.DIAMOND_COAL);
        registerItemBlock( ModBlockLoader.EMERALD_COAL);
        registerItemBlock( ModBlockLoader.REDSTONE_COAL);
        registerItemBlock( ModBlockLoader.DYE4_COAL);
        //registerItemBlock(reg,ModBlockLoader.SEVEN_COLOR_TORCH);
        GameRegistry.register(new ItemBlock(ModBlockLoader.SEVEN_COLOR_TORCH){
            @Override
            public String getItemStackDisplayName(ItemStack stack) {
                return TextFormatting.DARK_PURPLE+super.getItemStackDisplayName(stack);
            }
        }.setRegistryName(ModBlockLoader.SEVEN_COLOR_TORCH.getRegistryName()));
    }

    public static void registerBlocks() {
        GameRegistry.register(ModBlockLoader.IRON_COAL);
        GameRegistry.register(ModBlockLoader.GOLD_COAL);
        GameRegistry.register(ModBlockLoader.DIAMOND_COAL);
        GameRegistry.register(ModBlockLoader.EMERALD_COAL);
        GameRegistry.register(ModBlockLoader.REDSTONE_COAL);
        GameRegistry.register(ModBlockLoader.DYE4_COAL);
        GameRegistry.register(ModBlockLoader.SEVEN_COLOR_TORCH);

    }
    public static void registerItemBlock( Block block) {
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
