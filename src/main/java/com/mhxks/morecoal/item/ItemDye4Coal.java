package com.mhxks.morecoal.item;

import com.mhxks.morecoal.init.ModCreativeTabLoader;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDye4Coal
extends Item
implements ModFuelHandler{
    public ItemDye4Coal() {
        this.setCreativeTab(ModCreativeTabLoader.MORE_COAL);
    }

    @Override
    public int getBurnTime() {
        return 200*16;
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.DARK_RED+I18n.format("morecoal.desc.1")+this.getBurnTime()/200);
        tooltip.add(TextFormatting.DARK_PURPLE+I18n.format(this.getUnlocalizedName()+".desc.1"));
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
