package com.mhxks.firstmod.block;

import com.mhxks.firstmod.init.ModFluidLoader;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidDichlorvos
extends BlockFluidClassic {
    public BlockFluidDichlorvos() {
        super(ModFluidLoader.DICHLORVOS, Material.WATER);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if(!worldIn.isRemote){
                int tick = worldIn.getMinecraftServer().getTickCounter() % 10 + 1;
                if(tick==10) {
                    if(entityIn instanceof EntityLiving){
                        EntityLiving entityLiving = (EntityLiving)entityIn;
                        entityLiving.addPotionEffect(new PotionEffect(MobEffects.POISON, 20 * 20, 3));
                        entityIn.attackEntityFrom(new DamageSource("byDichlorvos").setDamageBypassesArmor(), 2.0F);
                    }
                }

        }
        super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
    }
}
