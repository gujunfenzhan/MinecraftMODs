package com.mhxks.morecoal.client;
import com.mhxks.morecoal.common.CommonProxy;
import com.mhxks.morecoal.init.ModBlockLoader;
import com.mhxks.morecoal.init.ModEntityRenderLoader;
import com.mhxks.morecoal.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy
extends CommonProxy {
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        registerItemModel(ModItemLoader.IROM_COAL);
        registerItemModel(ModItemLoader.GOLD_COAL);
        registerItemModel(ModItemLoader.DIAMOND_COAL);
        registerItemModel(ModItemLoader.EMERALD_COAL);
        registerItemModel(ModItemLoader.REDSTONE_COAL);
        registerItemModel(ModItemLoader.DYE4_COAL);

        registerBlockModel(ModBlockLoader.IRON_COAL);
        registerBlockModel(ModBlockLoader.GOLD_COAL);
        registerBlockModel(ModBlockLoader.DIAMOND_COAL);
        registerBlockModel(ModBlockLoader.EMERALD_COAL);
        registerBlockModel(ModBlockLoader.REDSTONE_COAL);
        registerBlockModel(ModBlockLoader.DYE4_COAL);
        registerBlockModel(ModBlockLoader.SEVEN_COLOR_TORCH);

    }
    public void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item,0,new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }
    public void registerBlockModel(Block block) {
        registerItemModel(Item.getItemFromBlock(block));
    }

    @SubscribeEvent
    public void render(RenderGameOverlayEvent e){

    }
}
