package com.mhxks.morecoal.init;


import com.mhxks.morecoal.MoreCoalMain;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.UUID;

public class ModCraftingLoader {
    public static ResourceLocation group = new ResourceLocation(MoreCoalMain.MODID);
    private static int craftID = 0;
    public ModCraftingLoader() {

        ItemStack stack = new ItemStack(ModItemLoader.DIAMOND_COAL);
        stack.addEnchantment(Enchantments.LOOTING,1);
        //添加无序合成  煤炭+钻石=煤炭钻石
        GameRegistry.addShapelessRecipe(getCraftRes(),group,stack,Ingredient.fromItem(Items.COAL),Ingredient.fromItem(Items.DIAMOND));
        //GameRegistry.addShapedRecipe(ModItemLoader.DIAMOND_COAL.getRegistryName(),group,stack,'A',Items.DIAMOND,'B',Items.COAL);
        //铁
        registerMaterialCoal(Items.IRON_INGOT,ModItemLoader.IROM_COAL);
        //金
        registerMaterialCoal(Items.GOLD_INGOT,ModItemLoader.GOLD_COAL);
        //绿宝石
        registerMaterialCoal(Items.EMERALD,ModItemLoader.EMERALD_COAL);
        //红石
        registerMaterialCoal(Items.REDSTONE,ModItemLoader.REDSTONE_COAL);
        //青金石
       registerTowItemStackToItem(new ItemStack(Items.COAL),new ItemStack(Items.DYE,1,4),ModItemLoader.DYE4_COAL);
        //铁->铁块
        registerNightItemToBlock(ModItemLoader.IROM_COAL, Item.getItemFromBlock(ModBlockLoader.IRON_COAL));
        //金
        registerNightItemToBlock(ModItemLoader.GOLD_COAL, Item.getItemFromBlock(ModBlockLoader.GOLD_COAL));
        //绿宝石
        registerNightItemToBlock(ModItemLoader.EMERALD_COAL, Item.getItemFromBlock(ModBlockLoader.EMERALD_COAL));
        //红石
        registerNightItemToBlock(ModItemLoader.REDSTONE_COAL, Item.getItemFromBlock(ModBlockLoader.REDSTONE_COAL));
        //青金石
        registerNightItemToBlock(ModItemLoader.DYE4_COAL, Item.getItemFromBlock(ModBlockLoader.DYE4_COAL));

        //钻石
        GameRegistry.addShapedRecipe(getCraftRes(),group,new ItemStack(ModBlockLoader.DIAMOND_COAL),"###","###","###",'#',ModItemLoader.DIAMOND_COAL);
        ItemStack stack2 = stack.copy();
        stack2.grow(8);
        GameRegistry.addShapelessRecipe(getCraftRes(),group,stack2,Ingredient.fromStacks(new ItemStack(ModBlockLoader.DIAMOND_COAL)));

        GameRegistry.addShapedRecipe(getCraftRes(),group,new ItemStack(ModBlockLoader.SEVEN_COLOR_TORCH)
                ,"abc","def","ghg"
                ,'a',ModItemLoader.IROM_COAL
                ,'b',ModItemLoader.GOLD_COAL
                ,'c',ModItemLoader.DIAMOND_COAL
                ,'d',ModItemLoader.EMERALD_COAL
                ,'e',ModItemLoader.REDSTONE_COAL
                ,'f',ModItemLoader.DYE4_COAL
                ,'h',Items.STICK
                ,'g',Blocks.LAPIS_BLOCK);

    }
    public void registerMaterialCoal(Item material,Item result){
        registerTowItemToItem(material,Items.COAL,result);
    }


    public void registerTowItemToItem(Item material,Item material2,Item result){

        GameRegistry.addShapelessRecipe(getCraftRes(),group,new ItemStack(result),Ingredient.fromItem(material),Ingredient.fromItem(material2));
    }
    public void registerTowItemStackToItem(ItemStack material,ItemStack material2,Item result){

        GameRegistry.addShapelessRecipe(getCraftRes(),group,new ItemStack(result),Ingredient.fromStacks(material),Ingredient.fromStacks(material2));
    }

    public void registerNightItemToBlock(Item item,Item out){
        //item 物品
        //out 方块
        GameRegistry.addShapedRecipe(getCraftRes(),group,new ItemStack(out),"###","###","###",'#',item);
        GameRegistry.addShapelessRecipe(getCraftRes(),group,new ItemStack(item,9),Ingredient.fromItems(out));
}
    public int getCraftID(){
        return craftID++;
    }
    public ResourceLocation getCraftRes(){
        ResourceLocation resourceLocation = new ResourceLocation(MoreCoalMain.MODID,MoreCoalMain.MODID+getCraftID());
        return resourceLocation;
    }
}
