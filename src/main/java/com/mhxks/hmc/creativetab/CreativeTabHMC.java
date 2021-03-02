package com.mhxks.hmc.creativetab;

import com.mhxks.hmc.init.ModBlockLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabHMC
extends CreativeTabs {
    public CreativeTabHMC() {
        super("hmc");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModBlockLoader.HARVESTER_MACHINE);
    }
}
