package com.mhxks.fastbuild.client;

import com.mhxks.fastbuild.common.CommonProxy;
import com.mhxks.fastbuild.init.ModItemLoader;
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
        registerItemModel(ModItemLoader.FAST_BUILD_TOOL);
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
