package com.mhxks.fastbuild.init;
import com.mhxks.fastbuild.ModFastBuild;
import com.mhxks.fastbuild.client.gui.GuiFastBuildTool;
import com.mhxks.fastbuild.container.ContainerFastBuildTool;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ModGuiLoader
implements IGuiHandler {
        public static final int FAST_BUILD_TOOL = 1;
    public ModGuiLoader() {
        NetworkRegistry.INSTANCE.registerGuiHandler(ModFastBuild.INSTANCE,this);
    }
        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case FAST_BUILD_TOOL:
                return new ContainerFastBuildTool(player);
            default:
                return null;
        }

    }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case FAST_BUILD_TOOL:
                return new GuiFastBuildTool(new ContainerFastBuildTool(player));
            default:
                return null;
        }

    }
    }
