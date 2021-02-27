package com.mhxks.morecoal.init;

import com.mhxks.morecoal.MoreCoalMain;
import com.mhxks.morecoal.entity.tileentity.TileEntitySevenColorTorch;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntityLoader {
    public ModTileEntityLoader(){
        GameRegistry.registerTileEntity(TileEntitySevenColorTorch.class,new ResourceLocation(MoreCoalMain.MODID,"seven_color_torch"));
    }
}
