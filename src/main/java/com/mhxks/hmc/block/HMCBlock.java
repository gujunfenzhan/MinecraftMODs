package com.mhxks.hmc.block;

import com.mhxks.hmc.HMCMain;
import com.mhxks.hmc.entity.tileentity.TileentityHarvesterMachine;
import com.mhxks.hmc.init.ModCreativeTabLoader;
import com.mhxks.hmc.init.ModGuiLoader;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public abstract  class HMCBlock
extends BlockContainer {
    public HMCBlock() {
        super(Material.ROCK);
        this.setCreativeTab(ModCreativeTabLoader.HMC);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, 0));
        this.setHarvestLevel("pickaxe",2);
        this.setHardness(3.0F);
        this.setResistance(5.0F);
    }

    public static final PropertyInteger FACING = PropertyInteger.create("facing",0,3);
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
                                ItemStack stack) {
        EnumFacing facing = placer.getHorizontalFacing().getOpposite();
        if(facing== EnumFacing.NORTH) {
            worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(FACING, 0));
        }else if(facing==EnumFacing.SOUTH) {
            worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(FACING, 1));
        }else if(facing==EnumFacing.WEST) {
            worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(FACING, 2));
        }else if(facing==EnumFacing.EAST) {
            worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(FACING, 3));
        }else
            super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
    @Override
    public abstract boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ);
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING);
    }
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.blockState.getBaseState().withProperty(FACING, meta);
    }
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Nullable
    @Override
    public abstract TileEntity createNewTileEntity(World worldIn, int meta);
}
