package com.mhxks.firstmod.fluid;

import com.mhxks.firstmod.FirstModMain;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidDichlorvos
extends Fluid {
    public FluidDichlorvos(String fluidName, ResourceLocation still, ResourceLocation flowing) {
        super(fluidName, still, flowing);
        this.setDensity(13600);
        this.setViscosity(750);
        this.setLuminosity(0);
        this.setTemperature(300);

    }

}
