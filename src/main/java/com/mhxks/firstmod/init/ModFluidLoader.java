package com.mhxks.firstmod.init;

import com.mhxks.firstmod.FirstModMain;
import com.mhxks.firstmod.fluid.FluidDichlorvos;
import com.mhxks.firstmod.fluid.FluidIceBlackTea;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ModFluidLoader {
    public ModFluidLoader(FMLPreInitializationEvent event) {
        registerFluid(DICHLORVOS,event);
        registerFluid(ICE_BLACK_TEA,event);


    }
    public void registerFluid(Fluid fluid,FMLPreInitializationEvent event){
        //FluidRegistry.addBucketForFluid(fluid);
        FluidRegistry.registerFluid(fluid);
    }
    public static Fluid DICHLORVOS = new FluidDichlorvos("dichlorvos_fluid",new ResourceLocation(FirstModMain.MODID,"fluid/dichlorvos_fluid_still"),new ResourceLocation(FirstModMain.MODID,"fluid/dichlorvos_fluid_flow")).setUnlocalizedName("dichlorvosFluid");
    public static Fluid ICE_BLACK_TEA = new FluidIceBlackTea("ice_black_tea_fluid",new ResourceLocation(FirstModMain.MODID,"fluid/ice_black_tea_fluid_still"),new ResourceLocation(FirstModMain.MODID,"fluid/ice_black_tea_fluid_flow")).setUnlocalizedName("IceBlackTeaFluid");
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        //registerFluidRender((BlockFluidBase) ModBlockLoader.FLUID_DICHLORVOS, "dichlorvos_fluid");
        //registerFluidRender((BlockFluidBase)ModBlockLoader.FLUID_ICE_BLACK_TEA,"ice_black_tea_fluid");
        registerFluidRender((BlockFluidBase) ModBlockLoader.FLUID_DICHLORVOS, "dichlorvos_fluid");
        registerFluidRender((BlockFluidBase)ModBlockLoader.FLUID_ICE_BLACK_TEA,"ice_black_tea_fluid");
    }
    @SideOnly(Side.CLIENT)
    public static void registerFluid(BlockFluidBase block,String stateName){
        ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
                return new ModelResourceLocation(new ResourceLocation(FirstModMain.MODID, "fluid"), stateName);
            }
        });
    }
    @SideOnly(Side.CLIENT)
    public static void registerFluidRender(BlockFluidBase blockFluid, String blockStateName)
    {

        String location = FirstModMain.MODID + ":" + blockStateName;
        Item itemFluid = Item.getItemFromBlock(blockFluid);
        ModelBakery.registerItemVariants(itemFluid);
        ModelResourceLocation resourceLocation = new ModelResourceLocation(location, "fluid");
        ModelLoader.setCustomMeshDefinition(itemFluid, new ItemMeshDefinition()
        {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return resourceLocation;
            }
        });
        ModelLoader.setCustomStateMapper(blockFluid, new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return resourceLocation;
            }
        });
    }


}
