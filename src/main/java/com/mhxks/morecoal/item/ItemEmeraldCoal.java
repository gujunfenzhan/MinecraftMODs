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

public class ItemEmeraldCoal
extends Item
implements ModFuelHandler{
    public ItemEmeraldCoal() {
        this.setCreativeTab(ModCreativeTabLoader.MORE_COAL);
    }

    @Override
    public int getBurnTime() {
        return 200*256;
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_RED+I18n.format("morecoal.desc.1")+this.getBurnTime()/200);
        tooltip.add(TextFormatting.DARK_PURPLE+I18n.format(this.getUnlocalizedName()+".desc.1"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
