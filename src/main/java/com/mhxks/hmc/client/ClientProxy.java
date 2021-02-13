package com.mhxks.hmc.client;

import com.mhxks.hmc.client.render.TESRHarvesterMachine;
import com.mhxks.hmc.common.CommonProxy;
import com.mhxks.hmc.entity.tileentity.TileentityHarvesterMachine;
import com.mhxks.hmc.entity.tileentity.TileentityLivestockMachine;
import com.mhxks.hmc.init.ModBlockLoader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy
extends CommonProxy {
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        registerBlockModel(ModBlockLoader.HARVESTER_MACHINE);
        registerBlockModel(ModBlockLoader.LIVESTOCK_MACHINE);
        registerBlockModel(ModBlockLoader.MACHINE);
        ClientRegistry.bindTileEntitySpecialRenderer(TileentityHarvesterMachine.class,new TESRHarvesterMachine());
        ClientRegistry.bindTileEntitySpecialRenderer(TileentityLivestockMachine.class,new TESRHarvesterMachine());
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
