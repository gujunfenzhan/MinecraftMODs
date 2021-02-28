package com.mhxks.we.init;

import com.mhxks.we.WorkbenchEnchantingMain;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class ModCraftingLoader {

    private static int id = 0;
    public ModCraftingLoader() {
        // GameRegistry.addShapelessRecipe(new ResourceLocation(WorkbenchEnchantingMain.MODID+":"+id),group,new ItemStack(Items.COAL),Ingredient.fromItems(Items.APPLE),Ingredient.fromItems(Items.APPLE));

        addWorkbenchEnchanting(Enchantment.thorns,new ItemStack(Blocks.cactus));//棘刺
        addWorkbenchEnchanting(Enchantment.protection,new ItemStack(Items.iron_ingot));//防御
        addWorkbenchEnchanting(Enchantment.fireProtection,new ItemStack(Items.blaze_rod));//火焰防御
        addWorkbenchEnchanting(Enchantment.featherFalling,new ItemStack(Items.feather));//摔伤减半
        addWorkbenchEnchanting(Enchantment.blastProtection,new ItemStack(Items.gunpowder));//爆炸保护
        addWorkbenchEnchanting(Enchantment.projectileProtection,new ItemStack(Items.wooden_door));//远程攻击防御
        addWorkbenchEnchanting(Enchantment.respiration,new ItemStack(Items.fish));//水下呼吸
        addWorkbenchEnchanting(Enchantment.aquaAffinity,new ItemStack(Items.water_bucket));//水下挖掘
        //addWorkbenchEnchanting(Enchantment.st,new ItemStack(Items.BOAT));//水上速跑
        addWorkbenchEnchanting(Enchantment.sharpness,new ItemStack(Items.diamond));//锋利
        addWorkbenchEnchanting(Enchantment.smite,new ItemStack(Items.rotten_flesh));//亡灵杀手
        addWorkbenchEnchanting(Enchantment.baneOfArthropods,new ItemStack(Items.spider_eye));//截肢杀手
        addWorkbenchEnchanting(Enchantment.knockback,new ItemStack(Blocks.piston));//击退
        addWorkbenchEnchanting(Enchantment.fireAspect,new ItemStack(Items.lava_bucket));//火焰附加
        addWorkbenchEnchanting(Enchantment.looting,new ItemStack(Items.gold_ingot));//掉落物翻倍
        addWorkbenchEnchanting(Enchantment.efficiency,new ItemStack(Items.redstone));//挖掘效率
        addWorkbenchEnchanting(Enchantment.silkTouch,new ItemStack(Blocks.stone));//精准采集
        addWorkbenchEnchanting(Enchantment.unbreaking,new ItemStack(Items.emerald));//不毁
        addWorkbenchEnchanting(Enchantment.fortune,new ItemStack(Blocks.diamond_ore));//时运
        addWorkbenchEnchanting(Enchantment.field_151370_z,new ItemStack(Items.fishing_rod));//更快的钓鱼
        addWorkbenchEnchanting(Enchantment.field_151369_A,new ItemStack(Items.bread));//诱饵
        addWorkbenchEnchanting(Enchantment.power,new ItemStack(Items.golden_sword));//力量
        addWorkbenchEnchanting(Enchantment.punch,new ItemStack(Blocks.sticky_piston));//弓击退
        addWorkbenchEnchanting(Enchantment.flame,new ItemStack(Items.blaze_powder));//弓附火
        addWorkbenchEnchanting(Enchantment.infinity,new ItemStack(Items.arrow));//无限弓
        //addWorkbenchEnchanting(Enchantment.,new ItemStack(Blocks.GOLD_BLOCK));//经验修补
        //addWorkbenchEnchanting(Enchantment.,new ItemStack(Blocks.STAINED_GLASS_PANE,1,8));//消失诅咒
        //addWorkbenchEnchanting(Enchantment.BINDING_CURSE,new ItemStack(Blocks.IRON_BARS));//绑定诅咒
        //addWorkbenchEnchanting(Enchantment.,new ItemStack(Items.DYE,1,15));//横扫之刃
       // addWorkbenchEnchanting(Enchantment.,new ItemStack(Blocks.ICE));//冰霜行者
    }
    private static int getId(){
        return id++;
    }

    public void addWorkbenchEnchanting(Enchantment enchantment, ItemStack itemStack){
        int maxlevel = enchantment.getMaxLevel();//获取附魔的最高等级
        if(maxlevel>7)maxlevel = 7;
        for (int i =1; i <=maxlevel; i++) {//循环添加这个合成表
            //创建一个青金石数组,数组的长度决定需要多少个青金石
            Object[] objects = new Object[i+2];
            //Ingredient[] items = new Ingredient[i+2];//最后要加书和仙人掌
            for (int i1 = 0; i1 < i; i1++) {
                //items[i1] = new ItemStack(Items.DYE,1,4);//青金石的特殊值是4
                objects[i1] = new ItemStack(Items.dye,1,4);
                //items[i1] = Ingredient.fromStacks(new ItemStack(Items.DYE,1,4));

            }
            objects[i] = itemStack;
            objects[i+1] = Items.book;
            ItemEnchantedBook itemEnchantedBook = Items.enchanted_book;
            ItemStack fumoshu = itemEnchantedBook.getEnchantedItemStack(new EnchantmentData(enchantment,i));
            //创建一个附魔书，给他添加等级     输出一个附魔书   需要仙人掌，书
            GameRegistry.addShapelessRecipe(fumoshu,objects);
        }

    }
}
