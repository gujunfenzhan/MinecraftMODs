package com.mhxks.firstmod.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidIceBlackTea
extends Fluid {
    public FluidIceBlackTea(String fluidName, ResourceLocation still, ResourceLocation flowing) {
        super(fluidName, still, flowing);
        this.setDensity(13600);
        this.setViscosity(750);
        this.setLuminosity(0);
        this.setTemperature(300);

    }

}
