package com.mhxks.morecoal.event;
import com.mhxks.morecoal.MoreCoalMain;
import com.mhxks.morecoal.init.ModItemLoader;
import com.mhxks.morecoal.item.ModFuelHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.List;

public class MoreCoalEvent {
    @SubscribeEvent
    public void onItemBurn(FurnaceFuelBurnTimeEvent event){
        ItemStack itemStack = event.getItemStack();
        if(itemStack.getItem() instanceof ModFuelHandler){
            ModFuelHandler modFuelHandler = (ModFuelHandler) itemStack.getItem();
            event.setBurnTime(modFuelHandler.getBurnTime());

        }
        if(itemStack.getItem() instanceof ItemBlock){
            ItemBlock itemBlock = (ItemBlock)itemStack.getItem();
            Block block = itemBlock.getBlock();
            if(block instanceof ModFuelHandler){
                ModFuelHandler modFuelHandler = (ModFuelHandler) block;
                event.setBurnTime(modFuelHandler.getBurnTime());
            }
        }
    }

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


}
