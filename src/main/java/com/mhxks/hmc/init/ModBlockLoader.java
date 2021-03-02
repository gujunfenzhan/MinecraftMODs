package com.mhxks.hmc.init;

import com.mhxks.hmc.block.BlockHarvesterMachine;
import com.mhxks.hmc.block.BlockLivestockMachine;
import com.mhxks.hmc.block.BlockMachine;
import net.minecraft.block.Block;

public interface ModBlockLoader {
    public Block HARVESTER_MACHINE = new BlockHarvesterMachine().setRegistryName("harvester_machine").setUnlocalizedName("harvesterMachine");
    public Block LIVESTOCK_MACHINE = new BlockLivestockMachine().setRegistryName("livestock_machine").setUnlocalizedName("livestockMachine");
    public Block MACHINE = new BlockMachine().setRegistryName("machine").setUnlocalizedName("machine");
}
