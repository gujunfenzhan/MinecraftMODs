package com.mhxks.fastbuild.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class FastBuildCubeMessage
implements IMessage {
    public int dimension;
    public int startX;
    public int startY;
    public int startZ;
    public int endX;
    public int endY;
    public int endZ;
    public boolean isHollow;
    public ItemStack itemStack;
    public FastBuildCubeMessage() {
    }

    public FastBuildCubeMessage(int dimension, int startX, int startY, int startZ, int endX, int endY, int endZ, boolean isHollow, ItemStack itemStack) {
        this.dimension = dimension;
        this.startX = startX;
        this.startY = startY;
        this.startZ = startZ;
        this.endX = endX;
        this.endY = endY;
        this.endZ = endZ;
        this.isHollow = isHollow;
        this.itemStack = itemStack;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        PacketBuffer pb = new PacketBuffer(buf);
        startX = pb.readInt();
        startY = pb.readInt();
        startZ = pb.readInt();
        endX = pb.readInt();
        endY = pb.readInt();
        endZ = pb.readInt();
        isHollow = pb.readBoolean();
        dimension = pb.readInt();
        try {
            this.itemStack = pb.readItemStack();
        }catch (Exception e){
            this.itemStack = ItemStack.EMPTY.copy();
        }

    }

    @Override
    public void toBytes(ByteBuf buf) {
        PacketBuffer pb = new PacketBuffer(buf);
        pb.writeInt(startX);
        pb.writeInt(startY);
        pb.writeInt(startZ);
        pb.writeInt(endX);
        pb.writeInt(endY);
        pb.writeInt(endZ);
        pb.writeBoolean(isHollow);
        pb.writeInt(dimension);
        pb.writeItemStack(itemStack);
    }
}
