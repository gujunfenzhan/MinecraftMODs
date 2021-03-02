package com.mhxks.morecoal.item;

import com.mhxks.morecoal.init.ModCreativeTabLoader;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemGoldCoal
extends ItemFood
implements ModFuelHandler{
    public ItemGoldCoal() {
        super(5, false);
        this.setCreativeTab(ModCreativeTabLoader.MORE_COAL);
    }

    @Override
    public int getBurnTime() {
        return 200*48;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if(!worldIn.isRemote){
            player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 100, 1));//生命恢复
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 2000, 0));//抗性提升
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 2000, 0));//防火
            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 800, 3));//伤害吸收
        }
        super.onFoodEaten(stack, worldIn, player);
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.DARK_RED+I18n.format("morecoal.desc.1")+this.getBurnTime()/200);
        tooltip.add(TextFormatting.DARK_PURPLE+I18n.format(this.getUnlocalizedName()+".desc.1"));
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
