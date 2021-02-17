package com.mhxks.fastbuild.init;

import com.mhxks.fastbuild.ModFastBuild;
import com.mhxks.fastbuild.network.FastBuildCubeMessage;
import com.mhxks.fastbuild.network.FastBuildCubeMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.relauncher.Side;

public class ModNetworkLoader {
    public static int NEXT = 0;
    public ModNetworkLoader() {
        registerServerNetwork(new FastBuildCubeMessageHandler(), FastBuildCubeMessage.class);

    }
    public <REQ extends IMessage,REPLY extends IMessage> void registerServerNetwork(IMessageHandler<REQ,REPLY> handler, Class<REQ> imessage) {
        ModFastBuild.getNetwork().registerMessage(handler, imessage, NEXT, Side.SERVER);
        NEXT++;
    }
    public <REQ extends IMessage,REPLY extends IMessage> void registerClientNetwork(IMessageHandler<REQ,REPLY> handler, Class<REQ> imessage) {
        ModFastBuild.getNetwork().registerMessage(handler, imessage, NEXT,Side.CLIENT);
        NEXT++;
    }
}
