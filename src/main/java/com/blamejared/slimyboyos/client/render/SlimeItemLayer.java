package com.blamejared.slimyboyos.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class SlimeItemLayer<T extends Entity> extends LayerRenderer<T, SlimeModel<T>> {
    
    public SlimeItemLayer(IEntityRenderer<T, SlimeModel<T>> p_i50923_1_) {
        super(p_i50923_1_);
    }
    
    public void render(MatrixStack stack, IRenderTypeBuffer type, int p_225628_3_, T entity, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        if(!entity.isInvisible() && entity.getPersistentData().contains("AbsorbedItem") && entity.isAlive()) {
            stack.push();
            stack.rotate(Vector3f.XP.rotationDegrees(180));
            stack.translate(0, -1, 0);
            stack.rotate(Vector3f.XP.rotationDegrees(90));
            float angle = entity.rotationYaw;
            stack.rotate(Vector3f.ZN.rotationDegrees(angle));
            stack.translate(0, -(2 * 0.0626), 0);
            stack.translate(0, 0, -0.0626 / 4);
            stack.rotate(Vector3f.YP.rotationDegrees(90));
            Minecraft.getInstance().getItemRenderer().renderItem(ItemStack.read(entity.getPersistentData().getCompound("AbsorbedItem")), ItemCameraTransforms.TransformType.GROUND, p_225628_3_, OverlayTexture.NO_OVERLAY, stack, type);
            stack.pop();
        }
    }
}