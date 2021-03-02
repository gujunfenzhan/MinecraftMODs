package com.mhxks.we.init;

import com.mhxks.we.WorkbenchEnchantingMain;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCraftingLoader {
    private ResourceLocation group = new ResourceLocation(WorkbenchEnchantingMain.MODID);
    private static int id = 0;
    public ModCraftingLoader() {
       // GameRegistry.addShapelessRecipe(new ResourceLocation(WorkbenchEnchantingMain.MODID+":"+id),group,new ItemStack(Items.COAL),Ingredient.fromItems(Items.APPLE),Ingredient.fromItems(Items.APPLE));
        addWorkbenchEnchanting(Enchantments.THORNS,new ItemStack(Blocks.CACTUS));//棘刺
        addWorkbenchEnchanting(Enchantments.PROTECTION,new ItemStack(Items.IRON_INGOT));//防御
        addWorkbenchEnchanting(Enchantments.FIRE_PROTECTION,new ItemStack(Items.BLAZE_ROD));//火焰防御
        addWorkbenchEnchanting(Enchantments.FEATHER_FALLING,new ItemStack(Items.FEATHER));//摔伤减半
        addWorkbenchEnchanting(Enchantments.BLAST_PROTECTION,new ItemStack(Items.GUNPOWDER));//爆炸保护
        addWorkbenchEnchanting(Enchantments.PROJECTILE_PROTECTION,new ItemStack(Items.SHIELD));//远程攻击防御
        addWorkbenchEnchanting(Enchantments.RESPIRATION,new ItemStack(Items.FISH));//水下呼吸
        addWorkbenchEnchanting(Enchantments.AQUA_AFFINITY,new ItemStack(Items.WATER_BUCKET));//水下挖掘
        addWorkbenchEnchanting(Enchantments.DEPTH_STRIDER,new ItemStack(Items.BOAT));//水上速跑
        addWorkbenchEnchanting(Enchantments.SHARPNESS,new ItemStack(Items.DIAMOND));//锋利
        addWorkbenchEnchanting(Enchantments.SMITE,new ItemStack(Items.ROTTEN_FLESH));//亡灵杀手
        addWorkbenchEnchanting(Enchantments.BANE_OF_ARTHROPODS,new ItemStack(Items.SPIDER_EYE));//截肢杀手
        addWorkbenchEnchanting(Enchantments.KNOCKBACK,new ItemStack(Blocks.PISTON));//击退
        addWorkbenchEnchanting(Enchantments.FIRE_ASPECT,new ItemStack(Items.LAVA_BUCKET));//火焰附加
        addWorkbenchEnchanting(Enchantments.LOOTING,new ItemStack(Items.GOLD_INGOT));//掉落物翻倍
        addWorkbenchEnchanting(Enchantments.EFFICIENCY,new ItemStack(Items.REDSTONE));//挖掘效率
        addWorkbenchEnchanting(Enchantments.SILK_TOUCH,new ItemStack(Blocks.STONE));//精准采集
        addWorkbenchEnchanting(Enchantments.UNBREAKING,new ItemStack(Items.EMERALD));//不毁
        addWorkbenchEnchanting(Enchantments.FORTUNE,new ItemStack(Blocks.DIAMOND_ORE));//时运
        addWorkbenchEnchanting(Enchantments.LUCK_OF_THE_SEA,new ItemStack(Items.FISHING_ROD));//更快的钓鱼
        addWorkbenchEnchanting(Enchantments.LURE,new ItemStack(Items.BREAD));//诱饵
        addWorkbenchEnchanting(Enchantments.POWER,new ItemStack(Items.GOLDEN_SWORD));//力量
        addWorkbenchEnchanting(Enchantments.PUNCH,new ItemStack(Blocks.STICKY_PISTON));//弓击退
        addWorkbenchEnchanting(Enchantments.FLAME,new ItemStack(Items.BLAZE_POWDER));//弓附火
        addWorkbenchEnchanting(Enchantments.INFINITY,new ItemStack(Items.ARROW));//无限弓
        addWorkbenchEnchanting(Enchantments.MENDING,new ItemStack(Blocks.GOLD_BLOCK));//经验修补
        addWorkbenchEnchanting(Enchantments.VANISHING_CURSE,new ItemStack(Blocks.STAINED_GLASS_PANE,1,8));//消失诅咒
        addWorkbenchEnchanting(Enchantments.BINDING_CURSE,new ItemStack(Blocks.IRON_BARS));//绑定诅咒
        //addWorkbenchEnchanting(Enchantments.SWEEPING,new ItemStack(Items.DYE,1,15));//横扫之刃
        addWorkbenchEnchanting(Enchantments.FROST_WALKER,new ItemStack(Blocks.ICE));//冰霜行者
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
                objects[i1] = new ItemStack(Items.DYE,1,4);
                //items[i1] = Ingredient.fromStacks(new ItemStack(Items.DYE,1,4));

            }
            objects[i] = itemStack;
            objects[i+1] = Items.BOOK;
            ItemEnchantedBook itemEnchantedBook = Items.ENCHANTED_BOOK;
            ItemStack fumoshu = itemEnchantedBook.getEnchantedItemStack(new EnchantmentData(enchantment,i));
            //创建一个附魔书，给他添加等级     输出一个附魔书   需要仙人掌，书
            GameRegistry.addShapelessRecipe(fumoshu,objects);
        }

    }
}
