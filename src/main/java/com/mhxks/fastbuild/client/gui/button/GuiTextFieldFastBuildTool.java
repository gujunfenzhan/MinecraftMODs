package com.mhxks.fastbuild.client.gui.button;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

public class GuiTextFieldFastBuildTool
extends GuiTextField {
    public GuiTextFieldFastBuildTool(int componentId, FontRenderer fontrendererObj, int x, int y, int par5Width, int par6Height) {
        super(componentId, fontrendererObj, x, y, par5Width, par6Height);
    }

    @Override
    public boolean textboxKeyTyped(char typedChar, int keyCode) {
        //2-11 12
        if((keyCode>=2&&keyCode<=12)||keyCode==14){
            return super.textboxKeyTyped(typedChar, keyCode);
        }
        return false;
    }
}
