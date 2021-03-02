package com.mhxks.hmc.entity.tileentity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
public class TileentityHarvesterMachine
extends HMCMachine
implements ITickable{
    public static final int range = 5;
    public SlotItemHandler slot1 = new SlotItemHandler(items, 0,  83, 30) {
        @Override
        public boolean isItemValid(@Nonnull ItemStack stack) {
            Item item = stack.getItem();
            return item instanceof ItemSeeds ||item instanceof ItemSeedFood;
        }
    };


    @Override
    public void update() {

        //自动收货小麦
        World world = this.world;

        //服务端运行
        if(this.world != null && !this.world.isRemote) {
            int tick = this.world.getMinecraftServer().getTickCounter() % 40 + 1;
            if(tick==20){
            BlockPos pos = this.getPos();
            //
            for (int i = 0; i < range * 2 + 1; i++) {

                for (int i1 = 0; i1 < range * 2 + 1; i1++) {
                    int x = pos.getX() - range + i;
                    int y = pos.getZ() - range + i1;
                    BlockPos cropPos = new BlockPos(x, pos.getY(), y);
                    IBlockState iBlockState = world.getBlockState(cropPos);
                    Block block = iBlockState.getBlock();
                    boolean flag = false;
                    if (block == Blocks.MELON_BLOCK || block == Blocks.REEDS || block == Blocks.CACTUS) {
                        flag = true;
                    }
                    if (block == Blocks.MELON_BLOCK) {
                        receCropToChest(cropPos, 0);
                    } else if (iBlockState.getBlock() instanceof BlockCrops || flag) {
                        if (flag) {
                            receCropToChest(cropPos.up(), 1);
                        } else {
                            BlockCrops blockCrops = (BlockCrops) iBlockState.getBlock();
                            if (blockCrops.isMaxAge(iBlockState)) {
                                receCropToChest(cropPos, 0);
                            }
                        }
                    }
                    //种植
                    if (block == Blocks.AIR) {
                        IBlockState landblockstate = world.getBlockState(cropPos.down());
                        if (landblockstate.getBlock() == Blocks.FARMLAND) {
                            ItemStack stack = getSeed();
                            if (stack != null && stack.getItem() instanceof ItemSeeds) {
                                ItemSeeds itemSeeds = (ItemSeeds) stack.getItem();
                                world.setBlockState(cropPos, itemSeeds.getPlant(null, null));
                                stack.shrink(1);
                            } else if (stack != null && stack.getItem() instanceof ItemSeedFood) {
                                ItemSeedFood itemSeeds = (ItemSeedFood) stack.getItem();
                                world.setBlockState(cropPos, itemSeeds.getPlant(null, null));
                                stack.shrink(1);
                            }
                        }
                    }
                }
            }
        }
        }
    }

    public void receCropToChest(BlockPos cropPos,int grow){
        world.destroyBlock(cropPos, true);
        AxisAlignedBB AABB = new AxisAlignedBB(cropPos.getX(),cropPos.getY(),cropPos.getZ(),cropPos.getX()+1,cropPos.getY()+1+grow,cropPos.getZ()+1);

        List<EntityItem> itemList = world.getEntitiesWithinAABB(EntityItem.class, AABB);
        for (EntityItem entityItem : itemList) {
            IInventory iInventory = getNearChest();
            if (iInventory == null) {
                world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), entityItem.getEntityItem()));
            } else {
                //把物品放进箱子里
                ItemStack stack = putStackInInventoryAllSlots(iInventory, entityItem.getEntityItem());
                if (!stack.isEmpty()) {
                    world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack));
                }
            }
            entityItem.setDead();
        }
    }

    public ItemStack getSeed(){
        List<IInventory> list = getAllChest();
        for (IInventory iInventory1 : list) {
            if(iInventory1==null)return null;
            for (int i = 0; i < iInventory1.getSizeInventory(); i++) {

                ItemStack itemStack = iInventory1.getStackInSlot(i);
                Item item = itemStack.getItem();
                if(item instanceof ItemSeeds||item instanceof ItemSeedFood){
                    if(slot1.getHasStack()){
                        if(item==slot1.getStack().getItem()){
                            return itemStack;
                        }else{
                            continue;
                        }
                    }else {
                        return itemStack;
                    }
                }
            }
        }

        return null;
    }
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        AxisAlignedBB AABB = super.getRenderBoundingBox();
        return new AxisAlignedBB(AABB.minX-4,AABB.minY,AABB.minZ-4,AABB.maxX+4,AABB.maxY,AABB.maxZ+4);
    }

}
