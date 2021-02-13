package com.mhxks.morecoal.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityRedstoneCoal
extends EntityThrowable {
    public EntityRedstoneCoal(World worldIn)
    {
        super(worldIn);
    }

    public EntityRedstoneCoal(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityRedstoneCoal(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(this.world!=null&&!this.world.isRemote){
            this.world.createExplosion(null,this.posX,this.posY,this.posZ,4.0F,true);
            this.setDead();
        }
    }
}
