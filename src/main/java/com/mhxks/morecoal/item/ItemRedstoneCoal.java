package com.mhxks.morecoal.item;

import com.mhxks.morecoal.entity.EntityRedstoneCoal;
import com.mhxks.morecoal.init.ModCreativeTabLoader;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRedstoneCoal
extends Item
implements ModFuelHandler{
    public ItemRedstoneCoal() {
        this.setCreativeTab(ModCreativeTabLoader.MORE_COAL);
    }

    @Override
    public int getBurnTime() {
        return 200*16;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
            if(!playerIn.isCreative()){
                itemStack.shrink(1);
            }
            EntityRedstoneCoal entityRedstoneCoal = new EntityRedstoneCoal(worldIn, playerIn);
            entityRedstoneCoal.shoot(playerIn,playerIn.rotationPitch,playerIn.rotationYaw,0.0F,1.5F,1.0F);
            worldIn.spawnEntity(entityRedstoneCoal);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS,itemStack);
    }
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_RED+I18n.format("morecoal.desc.1")+this.getBurnTime()/200);
        tooltip.add(TextFormatting.DARK_PURPLE+I18n.format(this.getUnlocalizedName()+".desc.1"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
