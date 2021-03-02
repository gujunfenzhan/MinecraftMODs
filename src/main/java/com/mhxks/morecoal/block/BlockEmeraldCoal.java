package com.mhxks.morecoal.block;

import com.mhxks.morecoal.init.ModCreativeTabLoader;
import com.mhxks.morecoal.init.ModItemLoader;
import com.mhxks.morecoal.item.ModFuelHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BlockEmeraldCoal
extends Block implements ModFuelHandler{
    public BlockEmeraldCoal() {
        super(Material.ROCK);
        this.setCreativeTab(ModCreativeTabLoader.MORE_COAL);
    }
    @Override
    public int getBurnTime() {
        return ((ModFuelHandler) ModItemLoader.EMERALD_COAL).getBurnTime()*9;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.DARK_RED+ I18n.format("morecoal.desc.1")+this.getBurnTime()/200);
        super.addInformation(stack, player, tooltip, advanced);
    }
}
