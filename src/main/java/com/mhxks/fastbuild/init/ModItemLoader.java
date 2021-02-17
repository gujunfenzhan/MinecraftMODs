package com.mhxks.fastbuild.init;

import com.mhxks.fastbuild.item.ItemFastBuildTool;
import net.minecraft.item.Item;

public interface ModItemLoader {
    Item FAST_BUILD_TOOL = new ItemFastBuildTool().setRegistryName("fast_build_tool").setUnlocalizedName("fastBuildTool");
}
