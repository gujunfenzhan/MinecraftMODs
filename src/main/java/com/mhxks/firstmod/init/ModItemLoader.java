package com.mhxks.firstmod.init;

import com.mhxks.firstmod.item.ItemDichlorvosBucket;
import com.mhxks.firstmod.item.ItemFunnyFruit;
import net.minecraft.item.Item;
import net.minecraftforge.common.ForgeVersion;

public class ModItemLoader {
    //setRegistryName设置物品的注册名，setUnlocalizedName注册物品的汉化名
    public static Item FUNNY_FRUIT = new ItemFunnyFruit().setRegistryName("funny_fruit").setUnlocalizedName("funnyFruit");

}
