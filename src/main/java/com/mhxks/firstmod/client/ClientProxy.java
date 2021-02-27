package com.mhxks.firstmod.client;

import com.mhxks.firstmod.common.CommonProxy;
import com.mhxks.firstmod.init.ModBlockLoader;
import com.mhxks.firstmod.init.ModFluidLoader;
import com.mhxks.firstmod.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class ClientProxy
extends CommonProxy {
    //注意需要继承CommonProxy，很多新手都会忘写这个
    //注册物品和方块的模型
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {

        registerItemModel(ModItemLoader.FUNNY_FRUIT);
        registerBlockModel(ModBlockLoader.IRON_COAL);
        ModFluidLoader.registerRenders();
    }
    @SubscribeEvent
    public void registerTextures(TextureStitchEvent event){
        TextureMap textureMap = event.getMap();
        textureMap.registerSprite(ModFluidLoader.DICHLORVOS.getFlowing());
        textureMap.registerSprite(ModFluidLoader.DICHLORVOS.getStill());
        textureMap.registerSprite(ModFluidLoader.ICE_BLACK_TEA.getFlowing());
        textureMap.registerSprite(ModFluidLoader.ICE_BLACK_TEA.getStill());

    }
    public void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item,0,new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }
    public void registerBlockModel(Block block) {
        registerItemModel(Item.getItemFromBlock(block));
    }

}
