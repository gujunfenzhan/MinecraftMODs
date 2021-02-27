package com.mhxks.fastbuild;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;
//这是coremod，动态修改熔炉的源码
/*
在开发环境下需要添加启动参数
-Dfml.coreMods.load=com.mhxks.fastbuild.ExamplePlugin
如果希望在打包的时候coremod被打包进去的话需要在build.gradle加进如下
jar {
    manifest {
        attributes([
                "FMLCorePlugin": "com.mhxks.fastbuild.ExamplePlugin",
                "FMLCorePluginContainsFMLMod": true
        ])
    }
}
 */
@IFMLLoadingPlugin.Name("ExampleCoreMod")
public class ExamplePlugin
implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        //需要返回一个IClassTransformer
        return new String[]{"com.mhxks.fastbuild.ClassTransformer"};
    }
    //其他可以返回null，可填可不填
    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
