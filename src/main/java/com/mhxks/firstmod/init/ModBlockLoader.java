package com.mhxks.firstmod.init;

import com.mhxks.firstmod.block.BlockFluidDichlorvos;
import com.mhxks.firstmod.block.BlockFluidIceBlackTea;
import com.mhxks.firstmod.block.BlockIronCoal;
import net.minecraft.block.Block;

public class ModBlockLoader {
    public static Block IRON_COAL = new BlockIronCoal().setRegistryName("iron_coal_block").setUnlocalizedName("ironCoalBlock");
    public static Block FLUID_DICHLORVOS = new BlockFluidDichlorvos().setRegistryName("dichlorvos_fluid").setUnlocalizedName("dichlorvosFluid");
    public static Block FLUID_ICE_BLACK_TEA = new BlockFluidIceBlackTea().setRegistryName("ice_black_tea_fluid").setUnlocalizedName("iceBlackTeaFluid");
}
