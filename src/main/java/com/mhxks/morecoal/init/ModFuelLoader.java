package com.mhxks.morecoal.init;

import com.mhxks.morecoal.item.ModFuelHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFuelLoader {

    public ModFuelLoader() {
        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel) {
                Item item = fuel.getItem();
                if(item instanceof ModFuelHandler){
                    return ((ModFuelHandler) item).getBurnTime();
                }
                if(item instanceof ItemBlock){
                    ItemBlock itemBlock = (ItemBlock)item;
                    Block block = itemBlock.getBlock();
                    if(block instanceof ModFuelHandler){
                        return ((ModFuelHandler) block).getBurnTime();
                    }
                }
                return 0;
            }
        });
    }

}
