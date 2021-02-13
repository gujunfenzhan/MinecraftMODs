package com.mhxks.morecoal.item;

import com.mhxks.morecoal.init.ModCreativeTabLoader;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemIronCoal
extends Item
implements ModFuelHandler {
    public ItemIronCoal() {
        this.setCreativeTab(ModCreativeTabLoader.MORE_COAL);
    }

    @Override
    public int getBurnTime() {
        return 200*32;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_RED+I18n.format("morecoal.desc.1")+this.getBurnTime()/200);
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
