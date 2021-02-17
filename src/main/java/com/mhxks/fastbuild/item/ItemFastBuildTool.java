package com.mhxks.fastbuild.item;

import com.mhxks.fastbuild.ModFastBuild;
import com.mhxks.fastbuild.client.gui.GuiScreenFastBuildTool;
import com.mhxks.fastbuild.init.ModGuiLoader;
import com.mhxks.hmc.HMCMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiVideoSettings;
import net.minecraft.client.gui.advancements.GuiScreenAdvancements;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ItemFastBuildTool
extends Item {
    public ItemFastBuildTool() {
        this.setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) {
        NBTTagCompound nbtTagCompound = getTagNBT(stack);

        nbtTagCompound.setInteger("startX",pos.getX());
        nbtTagCompound.setInteger("startY",pos.getY());
        nbtTagCompound.setInteger("startZ",pos.getZ());
        stack.setTagCompound(nbtTagCompound);
        if(world.isRemote) {
            player.sendMessage(new TextComponentString(I18n.format("pos.fastbuild.desc.1" + pos.getX() + " " + pos.getY() + " " + pos.getZ())));
        }
        return false;
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(player.isCreative()){
            ItemStack itemStack = player.getHeldItem(hand);
            NBTTagCompound nbtTagCompound = getTagNBT(itemStack);
            nbtTagCompound.setInteger("endX",pos.getX());
            nbtTagCompound.setInteger("endY",pos.getY());
            nbtTagCompound.setInteger("endZ",pos.getZ());
            itemStack.setTagCompound(nbtTagCompound);
            if(worldIn.isRemote) {
                player.sendMessage(new TextComponentString(I18n.format("pos.fastbuild.desc.2" + pos.getX() + " " + pos.getY() + " " + pos.getZ())));
            }
        }
        return EnumActionResult.SUCCESS;
    }

    public static NBTTagCompound getTagNBT(ItemStack itemStack){
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound();
        if(nbtTagCompound==null){
            nbtTagCompound = new NBTTagCompound();
        }
        return nbtTagCompound;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemStack = playerIn.getHeldItem(handIn);
        //playerIn.openGui(ModFastBuild.INSTANCE, ModGuiLoader.FAST_BUILD_TOOL, worldIn,0,0,0);
        if(worldIn.isRemote) {
            Minecraft mc = Minecraft.getMinecraft();
           // GuiIngameMenu guiIngameMenu = new GuiIngameMenu();
            //GuiOptions guiOptions = new GuiOptions(guiIngameMenu,mc.gameSettings);
            //mc.displayGuiScreen(new GuiVideoSettings(guiOptions,mc.gameSettings));
            mc.displayGuiScreen(new GuiScreenFastBuildTool(itemStack,worldIn,playerIn));
            //System.out.println(worldIn.provider.getDimension());
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS,itemStack);
    }
}
