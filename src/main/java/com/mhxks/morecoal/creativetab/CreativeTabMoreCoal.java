package com.mhxks.morecoal.creativetab;

import com.mhxks.morecoal.init.ModItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabMoreCoal
extends CreativeTabs {
    public CreativeTabMoreCoal() {
        super("more_coal");

    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItemLoader.IROM_COAL);
    }
}
