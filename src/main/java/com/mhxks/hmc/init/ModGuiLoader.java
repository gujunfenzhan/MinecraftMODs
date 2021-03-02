package com.mhxks.hmc.init;

import com.mhxks.hmc.HMCMain;
import com.mhxks.hmc.client.gui.HarvesterMachineGui;
import com.mhxks.hmc.container.HarvesterMachineContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ModGuiLoader
implements IGuiHandler {
    public static final int HARVESTER_MACHINE = 1;
    public ModGuiLoader() {
        NetworkRegistry.INSTANCE.registerGuiHandler(HMCMain.INSTANCE,this);
    }
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case HARVESTER_MACHINE:
                return new HarvesterMachineContainer(world.getTileEntity(new BlockPos(x, y, z)),player);
            default:
                return null;
        }

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case HARVESTER_MACHINE:
                return new HarvesterMachineGui(new HarvesterMachineContainer(world.getTileEntity(new BlockPos(x, y, z)),player));
            default:
                return null;
        }

    }
}
