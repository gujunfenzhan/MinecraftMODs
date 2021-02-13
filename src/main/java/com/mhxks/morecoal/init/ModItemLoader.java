package com.mhxks.morecoal.init;

import com.mhxks.morecoal.item.*;
import net.minecraft.item.Item;

public interface ModItemLoader {
    Item IROM_COAL = new ItemIronCoal().setRegistryName("iron_coal").setUnlocalizedName("ironCoal");
    Item GOLD_COAL = new ItemGoldCoal().setRegistryName("gold_coal").setUnlocalizedName("goldCoal");
    Item DIAMOND_COAL = new ItemDiamondCoal().setRegistryName("diamond_coal").setUnlocalizedName("diamondCoal");
    Item EMERALD_COAL = new ItemEmeraldCoal().setRegistryName("emerald_coal").setUnlocalizedName("emeraldCoal");
    Item REDSTONE_COAL = new ItemRedstoneCoal().setRegistryName("redstone_coal").setUnlocalizedName("redstoneCoal");
    Item DYE4_COAL = new ItemDye4Coal().setRegistryName("dye4_coal").setUnlocalizedName("dye4Coal");
}
