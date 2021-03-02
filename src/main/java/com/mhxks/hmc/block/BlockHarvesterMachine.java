package com.mhxks.hmc.block;
import com.mhxks.hmc.HMCMain;
import com.mhxks.hmc.entity.tileentity.TileentityHarvesterMachine;
import com.mhxks.hmc.init.ModGuiLoader;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockHarvesterMachine
extends HMCBlock {
    public BlockHarvesterMachine() {
        super();

    }
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof TileentityHarvesterMachine) {
                TileentityHarvesterMachine machine = (TileentityHarvesterMachine)tileEntity;
                machine.setOpenGui(true);
                playerIn.openGui(HMCMain.INSTANCE, ModGuiLoader.HARVESTER_MACHINE, worldIn, pos.getX(),pos.getY(),pos.getZ());
            }
        }
        return true;
    }
    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileentityHarvesterMachine();
    }
}
