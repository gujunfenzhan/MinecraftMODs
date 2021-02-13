package com.mhxks.morecoal.item;

import com.google.common.collect.Multimap;
import com.mhxks.morecoal.init.ModCreativeTabLoader;
import com.mhxks.morecoal.init.ModItemLoader;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDiamondCoal
extends Item
implements ModFuelHandler{
    private int attackDamage = 4;
    public ItemDiamondCoal() {
        this.setCreativeTab(ModCreativeTabLoader.MORE_COAL);
    }

    @Override
    public int getBurnTime() {
        return 200*80;
    }
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {

        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2D, 0));
        }

        return multimap;
    }


    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if(this.isInCreativeTab(tab)){
            ItemStack itemStack = new ItemStack(this);
            itemStack.addEnchantment(Enchantments.LOOTING,1);;
            items.add(itemStack);
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_RED+I18n.format("morecoal.desc.1")+this.getBurnTime()/200);
        tooltip.add(TextFormatting.DARK_PURPLE+I18n.format(this.getUnlocalizedName()+".desc.1"));
        tooltip.add(TextFormatting.DARK_PURPLE+I18n.format(this.getUnlocalizedName()+".desc.2"));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
