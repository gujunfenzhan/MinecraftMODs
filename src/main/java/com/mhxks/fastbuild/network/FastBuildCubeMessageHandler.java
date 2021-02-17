package com.mhxks.fastbuild.network;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class FastBuildCubeMessageHandler
implements IMessageHandler<FastBuildCubeMessage, IMessage> {
    @Override
    public IMessage onMessage(FastBuildCubeMessage message, MessageContext ctx) {
        int dim = message.dimension;
        int startX = message.startX;
        int startY = message.startY;
        int startZ = message.startZ;
        int endX = message.endX;
        int endY = message.endY;
        int endZ = message.endZ;
        boolean isHollow = message.isHollow;
        WorldServer[] worldServers = Minecraft.getMinecraft().getIntegratedServer().getServer().worlds;
        for (WorldServer worldServer : worldServers) {
            if(worldServer.provider.getDimension()==dim) {
                genBlock(worldServer,dim,startX,startY,startZ,endX,endY,endZ,isHollow, message.itemStack);
            }
        }
        return null;
    }
    public static void genBlock(World world, int dim, int startX, int startY, int startZ, int endX, int endY, int endZ, boolean isHollow, ItemStack itemStack){
                int meta = itemStack.getMetadata();
                for (int i = Integer.min(startX, endX); i <= Integer.max(startX, endX); i++) {
                    for (int i1 = Integer.min(startY,endY); i1 <= Integer.max(startY, endY); i1++) {
                        for (int i2 = Integer.min(startZ,endZ); i2 <= Integer.max(startZ, endZ); i2++) {
                            BlockPos pos = new BlockPos(i, i1, i2);
                            if(isHollow){

                                if((pos.getX()==startX||pos.getX()==endX||pos.getY()==startY||pos.getY()==endY||pos.getZ()==startZ||pos.getZ()==endZ)){
                                    //world.setBlockState(pos, Blocks.WOOL.getDefaultState(), 0);
                                    //world.setBlockState(pos,Blocks.WOOL.)
                                    Block block =  Block.getBlockFromItem(itemStack.getItem());
                                    IBlockState iBlockState =block.getStateFromMeta(meta);
                                        world.setBlockState(pos,iBlockState,0);
                                }
                            }else {
                                Block block =  Block.getBlockFromItem(itemStack.getItem());
                                IBlockState iBlockState =block.getStateFromMeta(meta);
                                    world.setBlockState(pos,iBlockState,0);
                            }
                        }
                    }
        }
    }
}
