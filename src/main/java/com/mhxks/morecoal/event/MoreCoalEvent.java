package com.mhxks.morecoal.event;
import com.mhxks.morecoal.MoreCoalMain;
import com.mhxks.morecoal.init.ModItemLoader;
import com.mhxks.morecoal.item.ModFuelHandler;
import com.mhxks.morecoal.particle.BlueFire;
import com.mhxks.morecoal.particle.FireFracture;
import com.mhxks.morecoal.particle.SevenColorsFire;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.util.List;

public class MoreCoalEvent {

    @SubscribeEvent
    public void AnvilUpdate(AnvilUpdateEvent event){
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        if((left.getItem() instanceof ItemTool||left.getItem() instanceof ItemSword)&&right.getItem()==ModItemLoader.DYE4_COAL){
            event.setMaterialCost(4);
            event.setCost(2);
            if(right.getCount()>=4) {
                event.setOutput(left.copy());
            }
        }
    }

    @SubscribeEvent
    public void onAnvilRepair(AnvilRepairEvent event){
        ItemStack left = event.getItemInput();
        ItemStack right = event.getIngredientInput();
        if((left.getItem() instanceof ItemTool||left.getItem() instanceof ItemSword)&&right.getItem()==ModItemLoader.DYE4_COAL){
            EnchantmentHelper.addRandomEnchantment(MoreCoalMain.random,event.getItemResult(),15,true);
        }
    }
    @SubscribeEvent
    public void TexturestitcherEventPre(TextureStitchEvent.Pre e) {
        e.getMap().registerSprite(SevenColorsFire.TEXTURES);
        e.getMap().registerSprite(FireFracture.TEXTURES);
        e.getMap().registerSprite(BlueFire.TEXTURES);
    }
}
