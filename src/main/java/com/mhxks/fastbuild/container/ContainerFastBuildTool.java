package com.mhxks.fastbuild.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerFastBuildTool
extends Container {

    public ContainerFastBuildTool(EntityPlayer player) {

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
