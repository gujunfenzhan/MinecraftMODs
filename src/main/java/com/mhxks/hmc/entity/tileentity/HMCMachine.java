package com.mhxks.hmc.entity.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class HMCMachine
extends TileEntity
{
    protected boolean isOpenGui;
    public ItemStackHandler items = new ItemStackHandler(1);

    public IInventory getNearChest(){
        IInventory iInventory = getInventoryAtPosition(this.world,this.pos.up());
        if(iInventory!=null){
            return iInventory;
        }
        iInventory = getInventoryAtPosition(this.world,this.pos.down());
        if(iInventory!=null){
            return iInventory;
        }
        iInventory = getInventoryAtPosition(this.world,this.pos.east());
        if(iInventory!=null){
            return iInventory;
        }
        iInventory = getInventoryAtPosition(this.world,this.pos.south());
        if(iInventory!=null){
            return iInventory;
        }
        iInventory = getInventoryAtPosition(this.world,this.pos.north());
        if(iInventory!=null){
            return iInventory;
        }
        iInventory = getInventoryAtPosition(this.world,this.pos.west());
        if(iInventory!=null){
            return iInventory;
        }
        return null;

    }

    public IInventory getInventoryAtPosition(World worldIn, BlockPos pos)
    {
        IInventory iinventory = null;
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        BlockPos blockpos = new BlockPos(i, j, k);
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(blockpos);
        Block block = state.getBlock();

        if (block.hasTileEntity(state))
        {
            TileEntity tileentity = worldIn.getTileEntity(blockpos);

            if (tileentity instanceof IInventory)
            {
                iinventory = (IInventory)tileentity;

                if (iinventory instanceof TileEntityChest && block instanceof BlockChest)
                {
                    iinventory = ((BlockChest)block).getContainer(worldIn, blockpos, true);
                }
            }
        }

        if (iinventory == null)
        {
            return null;
        }

        return iinventory;
    }

    private ItemStack insertStack(IInventory destination, ItemStack stack, int index)
    {
        ItemStack itemstack = destination.getStackInSlot(index);

        if (canInsertItemInSlot(destination, stack, index))
        {

            if (itemstack.isEmpty())
            {
                destination.setInventorySlotContents(index, stack);
                stack = ItemStack.EMPTY;
            }
            else if (canCombine(itemstack, stack))
            {
                int i = stack.getMaxStackSize() - itemstack.getCount();
                int j = Math.min(stack.getCount(), i);
                stack.shrink(j);
                itemstack.grow(j);
            }
        }

        return stack;
    }
    private boolean canInsertItemInSlot(IInventory inventoryIn, ItemStack stack, int index)
    {
        ItemStack stack1 = inventoryIn.getStackInSlot(index);
        return stack1.isEmpty()||canCombine(stack1,stack);
    }

    private boolean canCombine(ItemStack stack1, ItemStack stack2)
    {
        if (stack1.getItem() != stack2.getItem())
        {
            return false;
        }
        else if (stack1.getMetadata() != stack2.getMetadata())
        {
            return false;
        }
        else if (stack1.getCount() > stack1.getMaxStackSize())
        {
            return false;
        }
        else
        {
            return ItemStack.areItemStackTagsEqual(stack1, stack2);
        }
    }

    public ItemStack putStackInInventoryAllSlots(IInventory destination, ItemStack stack)
    {
        int i = destination.getSizeInventory();

        for (int j = 0; j < i && !stack.isEmpty(); ++j)
        {
            stack = insertStack(destination, stack, j);
        }

        return stack;
    }
    public List<IInventory> getAllChest(){
        List<IInventory> list = new ArrayList<>();
        IInventory iInventory = getInventoryAtPosition(this.world,this.pos.up());
        if(iInventory!=null){
            list.add(iInventory);
        }
        IInventory iInventory2 = getInventoryAtPosition(this.world,this.pos.down());
        if(iInventory!=null){
            list.add(iInventory2);
        }
        IInventory iInventory3 = getInventoryAtPosition(this.world,this.pos.east());
        if(iInventory!=null){
            list.add(iInventory3);
        }
        IInventory iInventory4 = getInventoryAtPosition(this.world,this.pos.south());
        if(iInventory!=null){
            list.add(iInventory4);
        }
        IInventory iInventory5 = getInventoryAtPosition(this.world,this.pos.north());
        if(iInventory!=null){
            list.add(iInventory5);
        }
        IInventory iInventory6 = getInventoryAtPosition(this.world,this.pos.west());
        if(iInventory!=null){
            list.add(iInventory6);
        }
        return list;
    }
    public void setOpenGui(boolean isOpenGui) {
        this.isOpenGui = isOpenGui;
        this.markDirty();
    }

    public boolean isOpenGui() {
        return isOpenGui;
    }
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        items.deserializeNBT(nbt.getCompoundTag("items"));
        super.readFromNBT(nbt);
    }
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.setTag("items",items.serializeNBT());
        return super.writeToNBT(nbt);
    }
    public void dropItem(ItemStack stack){
        if(!stack.isEmpty()){
            this.world.spawnEntity(new EntityItem(world,pos.getX(),pos.getY(),pos.getZ(),stack));
        }
    }
}
