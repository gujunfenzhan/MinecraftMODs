package com.mhxks.hmc.init;

import com.mhxks.hmc.HMCMain;
import com.mhxks.hmc.entity.tileentity.TileentityHarvesterMachine;
import com.mhxks.hmc.entity.tileentity.TileentityLivestockMachine;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntityLoader {
    public ModTileEntityLoader() {
        GameRegistry.registerTileEntity(TileentityHarvesterMachine.class,new ResourceLocation(HMCMain.MODID, "harvester"));
        GameRegistry.registerTileEntity(TileentityLivestockMachine.class,new ResourceLocation(HMCMain.MODNAME,"livestock"));
    }
}
