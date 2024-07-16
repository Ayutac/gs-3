package org.abos.mc.gs.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import org.abos.mc.gs.block.entity.GnomeHouseBlockEntity;

public class GnomeHouseRenderer implements BlockEntityRenderer<GnomeHouseBlockEntity> {
    public GnomeHouseRenderer(BlockEntityRendererProvider.Context ctx) {
        // Nothing to do
    }

    @Override
    public void render(GnomeHouseBlockEntity gnomeHouseBlockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int combinedLightIn, int combinedOverlayIn) {
        // Nothing to do?
    }
}
