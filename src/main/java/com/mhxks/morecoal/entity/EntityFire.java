package com.mhxks.morecoal.entity;

import com.mhxks.morecoal.particle.FireFracture;
import com.mhxks.morecoal.particle.SevenColorsFire;
import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import scala.Int;

import java.util.List;
import java.util.Random;

public class EntityFire
extends Entity {
    public EntityFire(World worldIn) {
        super(worldIn);
        this.noClip = true;
    }
    public EntityFire(World worldIn,double x,double y,double z) {
        this(worldIn);
        this.setPositionAndUpdate(x,y,z);
    }
    @Override
    protected void entityInit() {

    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        AxisAlignedBB AABB = new AxisAlignedBB(this.posX-0.2F,this.posY-0.2F,this.posZ-0.2F,this.posX+0.2F,this.posY+0.2F,this.posZ+0.2F);
        List<EntityMob> entityList = world.getEntitiesWithinAABB(EntityMob.class,AABB);
        for (EntityMob entityMob : entityList) {
            //world.createExplosion(this,this.posX,this.posY,this.posZ,3,true);
            entityMob.attackEntityFrom(new DamageSource(DamageSource.MAGIC.damageType),2.0F);
            entityMob.motionX = (entityMob.posX-this.posX)/2;
            entityMob.motionY = 0.2F;
            entityMob.motionZ = (entityMob.posZ-this.posZ)/2;
            //Minecraft.getMinecraft().effectRenderer.addEffect(new SevenColorsFire(world,this.posX,this.posY,this.posZ,0,0,0));
            dead();
            return;
        }
        AxisAlignedBB AABB2 = AABB.grow(5);
        entityList = world.getEntitiesWithinAABB(EntityMob.class,AABB2);
        float d = Float.MAX_VALUE;
        EntityMob entityMob = null;
        int size = 0;
        for (EntityMob mob : entityList) {
            if(!mob.isDead) {
                size++;
                float dSq = this.getDistance(mob);
                if (dSq < d) {
                    d = dSq;
                    entityMob = mob;
                }
            }
        }
        if(size<=0){
            dead();
            return;
        }

        if(entityMob!=null){
            double d1 = (entityMob.posX - this.posX) / 8.0D;
            double d2 = (entityMob.posY + (double)entityMob.getEyeHeight() / 2.0D - this.posY) / 8.0D;
            double d3 = (entityMob.posZ - this.posZ) / 8.0D;
            //d4 实体到实体间的距离
            //double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
            //距离大于2.0就不移动了
            //double d5 = 5.0D - d4;
                //this.motionX += d1 / d4 * d5 * 0.01D;
                //this.motionY += d2 / d4 * d5 * 0.01D;
                //this.motionZ += d3 / d4 * d5 * 0.01D;
                //this.motionX += d4/5.0F*d1*2D;
                //this.motionY += d4/5.0F*d2*2D;
                //this.motionZ += d4/5.0F*d3*2D;
                //this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                double maxNu = Math.max(Math.abs(d1),Math.max(Math.abs(d2),Math.abs(d3)));
                double n = 1/maxNu;
                this.motionX = d1*n*0.2;
                this.motionY = d2*n*0.2;
                this.motionZ = d3*n*0.2;
                //this.setEntityBoundingBox(this.getEntityBoundingBox().offset(motionX,motionY,motionZ));
                //this.resetPositionToBB();
                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);

        }

        /*
            world.createExplosion(this, this.posX, this.posY, this.posZ, 5, true);
            this.setDead();
            if (entityLiving == null || entityLiving.isDead) {
                world.createExplosion(null, this.posX, this.posY, this.posZ, 5, true);
                this.setDead();
            }*/
        }


    public void dead(){
        Random random = world.rand;
        for (int i = 0; i < 40; i++) {
            boolean xb = random.nextBoolean();
            boolean yb = random.nextBoolean();
            boolean zb = random.nextBoolean();
            Minecraft.getMinecraft().effectRenderer.addEffect(new FireFracture(world,posX,posY,posZ, (xb?1:-1)*random.nextFloat()/6,(yb?1:-1)*random.nextFloat()/6,(zb?1:-1)*random.nextFloat()/6));
        }

        this.setDead();
        this.world.removeEntity(this);
    }
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }
    protected boolean canTriggerWalking()
    {
        return false;
    }
    public boolean canBeAttackedWithItem()
    {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
}
