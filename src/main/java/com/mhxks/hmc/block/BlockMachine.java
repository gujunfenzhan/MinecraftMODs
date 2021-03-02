package com.mhxks.hmc.block;

import com.mhxks.hmc.init.ModCreativeTabLoader;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMachine
extends Block {
    public BlockMachine() {
        super(Material.ROCK);
        this.setCreativeTab(ModCreativeTabLoader.HMC);
        this.setHarvestLevel("pickaxe",2);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

}
