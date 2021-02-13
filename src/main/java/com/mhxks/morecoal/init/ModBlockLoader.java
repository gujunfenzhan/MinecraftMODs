package com.mhxks.morecoal.init;

import com.mhxks.morecoal.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public interface ModBlockLoader {
    Block IRON_COAL = new BlockIronCoal().setRegistryName("iron_coal_block").setUnlocalizedName("ironCoalBlock");
    Block GOLD_COAL = new BlockGoldCoal().setRegistryName("gold_coal_block").setUnlocalizedName("goldCoalBlock");
    Block DIAMOND_COAL = new BlockDiamondCoal().setRegistryName("diamond_coal_block").setUnlocalizedName("diamondCoalBlock");
    Block EMERALD_COAL = new BlockEmeraldCoal().setRegistryName("emerald_coal_block").setUnlocalizedName("emeraldCoalBlock");
    Block REDSTONE_COAL = new BlockRedstoneCoal().setRegistryName("redstone_coal_block").setUnlocalizedName("redstoneCoalBlock");
    Block DYE4_COAL = new BlockDye4Coal().setRegistryName("dye4_coal_block").setUnlocalizedName("dye4CoalBlock");


    //ItemBlock IRON_COAL

}
