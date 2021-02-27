package com.mhxks.morecoal.entity.tileentity;

import com.mhxks.morecoal.block.BlockSevenColorTorch;
import com.mhxks.morecoal.entity.EntityFire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class TileEntitySevenColorTorch
extends TileEntity implements ITickable {
    public int speed = 2;
    @Override
    public void update() {
        if(!world.isRemote){
            int tick = this.world.getMinecraftServer().getTickCounter() % 8 + 1;
            if(tick==8) {
                AxisAlignedBB AABB = new AxisAlignedBB(this.pos).grow(5);
                List<EntityFire> entityFireList = world.getEntitiesWithinAABB(EntityFire.class, AABB);
                int size = 0;
                for (EntityFire entityFire : entityFireList) {
                    if (!entityFire.isDead) {
                        size++;
                    }
                }

                List<EntityMob> entityMobList = world.getEntitiesWithinAABB(EntityMob.class, AABB);
                if (entityMobList.size() > 0) {
                    if(world.getBlockState(pos).getValue(BlockSevenColorTorch.FACING).getOpposite()== EnumFacing.DOWN){
                        EntityFire entityFire = new EntityFire(world, pos.getX() + 0.5F, pos.getY() + 0.7F, pos.getZ() + 0.5F);
                        world.spawnEntity(entityFire);
                    }else {
                        EntityFire entityFire = new EntityFire(world, pos.getX() + 0.5F, pos.getY() + 0.9F, pos.getZ() + 0.5F);
                        world.spawnEntity(entityFire);
                    }

                }
            }
            for(int y = -1;y<=1;y++){
                for (int i = -5; i <= 5; i++) {
                    for (int i2 = -5; i2 <= 5; i2++) {
                        BlockPos tiPos = new BlockPos(pos.getX() + i, pos.getY()+y, pos.getZ() + i2);
                        IBlockState iBlockState = world.getBlockState(tiPos);
                        Block block = iBlockState.getBlock();
                        for (int i1 = 0; i1 < speed; i1++) {
                            block.updateTick(world, tiPos, iBlockState, world.rand);
                        }

                        TileEntity tileEntity = world.getTileEntity(tiPos);
                        if (tileEntity != null && tileEntity instanceof ITickable&&!(tileEntity instanceof TileEntitySevenColorTorch)) {
                            for (int i1 = 0; i1 < speed; i1++) {
                                ((ITickable) tileEntity).update();
                            }
                            ((ITickable) tileEntity).update();
                        }

                    }
                }
            }
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("accelerateSpeed",speed);
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.speed = compound.getInteger("accelerateSpeed");
    }

    public int addSpeed(){
        this.speed+=2;
        if(speed>8)speed = 2;
        this.markDirty();
        return speed;
    }
}
