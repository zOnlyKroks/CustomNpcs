package de.zonlykroks.customnpcs.entity.render;

import de.zonlykroks.customnpcs.entity.MechanicEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MechanicEntityRenderer extends GeoEntityRenderer<MechanicEntity> {


    public MechanicEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new MechanicEntityModel());
    }

    @Override
    public RenderLayer getRenderType(MechanicEntity animatable, float partialTick, MatrixStack poseStack, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, int packedLight, Identifier texture) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}
