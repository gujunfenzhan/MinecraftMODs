package com.mhxks.morecoal.block;

import com.mhxks.morecoal.init.ModCreativeTabLoader;
import com.mhxks.morecoal.init.ModItemLoader;
import com.mhxks.morecoal.item.ModFuelHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockGoldCoal
extends Block
implements ModFuelHandler{
    public BlockGoldCoal() {
        super(Material.ROCK);
        this.setCreativeTab(ModCreativeTabLoader.MORE_COAL);
    }
    @Override
    public int getBurnTime() {
        return ((ModFuelHandler) ModItemLoader.GOLD_COAL).getBurnTime()*9;
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
        tooltip.add(TextFormatting.DARK_RED+ I18n.format("morecoal.desc.1")+this.getBurnTime()/200);
        super.addInformation(stack, player, tooltip, advanced);
    }
}
