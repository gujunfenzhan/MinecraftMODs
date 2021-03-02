package com.mhxks.hmc.entity.tileentity;


import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class TileentityLivestockMachine
extends HMCMachine
implements ITickable {
    @Override
    public void update() {

        World world = this.world;
        if(this.world != null && !this.world.isRemote){
            int tick = this.world.getMinecraftServer().getTickCounter() % 40 + 1;
            if(tick==20) {
                AxisAlignedBB AABB = new AxisAlignedBB(pos.getX()-5,pos.getY(),pos.getZ()-5,pos.getX()+5,pos.getY(),pos.getZ()+5);
                //剪羊毛
                receWoodToChest(AABB);
                receEggToChest(AABB);
            }
        }

    }

    public void receWoodToChest(AxisAlignedBB AABB){
        List<EntitySheep> entitySheep = this.world.getEntitiesWithinAABB(EntitySheep.class,AABB);
        for (EntitySheep sheep : entitySheep) {
            if( !sheep.getSheared() && !sheep.isChild()) {
                sheep.setSheared(true);
                int i = 1 + this.world.rand.nextInt(3);
                List<IInventory> chestList = getAllChest();
                ItemStack itemStack = new ItemStack(Item.getItemFromBlock(Blocks.WOOL), i, sheep.getFleeceColor().getMetadata());

                for (IInventory iInventory : chestList) {
                    if(iInventory!=null){
                        itemStack =  putStackInInventoryAllSlots(iInventory, itemStack);
                    }
                }

                if(!itemStack.isEmpty()){
                    dropItem(itemStack);
                }
            }
        }


    }

    public void receEggToChest(AxisAlignedBB AABB){
        List<EntityItem> entityItemList = this.world.getEntitiesWithinAABB(EntityItem.class,AABB);
        for (EntityItem entityItem : entityItemList) {
            ItemStack itemStack = entityItem.getEntityItem();
            if(itemStack.getItem() instanceof ItemEgg){
                List<IInventory> chestList = getAllChest();
                for (IInventory iInventory : chestList) {
                    if(iInventory!=null){
                        itemStack = putStackInInventoryAllSlots(iInventory,itemStack);
                    }
                }
                if(!itemStack.isEmpty()){
                    for (int i = 0; i < itemStack.getCount(); i++) {
                        if (this.world.rand.nextInt(100) < 20) {
                            EntityChicken entitychicken = new EntityChicken(this.world);
                            entitychicken.setGrowingAge(-24000);
                            entitychicken.setLocationAndAngles(pos.getX(), pos.getY()+1, pos.getZ(), 0, 0.0F);
                            this.world.spawnEntity(entitychicken);
                        }
                    }
                    entityItem.setDead();
                }else{
                    entityItem.setDead();
                }
            }
        }
    }




/*
    @Override
    public void update() {
        //剪羊毛
        if(!this.world.isRemote){










            //范围5*5
            AxisAlignedBB AABB = new AxisAlignedBB(this.pos).grow(5,0,5);
            List<EntityAnimal> entityAnimals = world.getEntitiesWithinAABB(EntityAnimal.class,AABB);
            for (EntityAnimal aanimal : entityAnimals) {
                if(aanimal instanceof EntitySheep){
                    EntitySheep entitySheep = (EntitySheep) aanimal;
                    if( !entitySheep.getSheared() && !entitySheep.isChild()) {

                        entitySheep.setSheared(true);
                        int i = 1 + this.world.rand.nextInt(3);
                        List<IInventory> chestList = getAllChest();
                        for (int j = 0; j < i; ++j) {
                            ItemStack itemStack = new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, entitySheep.getFleeceColor().getMetadata());
                            for (IInventory iInventory : chestList) {
                                if(iInventory!=null) {
                                    putStackInInventoryAllSlots(iInventory, itemStack);
                                }
                            }
                            dropItem(itemStack);
                        }
                    }
                }
            }
            List<EntityItem> itemList = world.getEntitiesWithinAABB(EntityItem.class,AABB);
            for (EntityItem entityItem : itemList) {
                ItemStack itemStack = entityItem.getItem();
                if(itemStack.getItem()== Items.EGG){
                    List<IInventory> chestList = getAllChest();
                    //循环把鸡蛋放在箱子里
                    for (IInventory iInventory : chestList) {
                        if(iInventory!=null){
                            itemStack = putStackInInventoryAllSlots(iInventory, itemStack);
                        }
                    }
                    //多余的鸡蛋丢了
                    //dropItem(itemStack);
                        if(!itemStack.isEmpty()){
                            for (int i = 0; i < itemStack.getCount(); i++) {
                                if (this.world.rand.nextInt(100) < 20) {
                                    EntityChicken entitychicken = new EntityChicken(this.world);
                                    entitychicken.setGrowingAge(-24000);
                                    entitychicken.setLocationAndAngles(pos.getX(), pos.getY()+1, pos.getZ(), 0, 0.0F);
                                    this.world.spawnEntity(entitychicken);
                                }
                            }
                            itemStack.setCount(0);
                        }

                }

            }
        }
    }*/
@Override
public AxisAlignedBB getRenderBoundingBox() {
    AxisAlignedBB AABB = super.getRenderBoundingBox();
    return new AxisAlignedBB(AABB.minX-4,AABB.minY,AABB.minZ-4,AABB.maxX+4,AABB.maxY,AABB.maxZ+4);
}
}
