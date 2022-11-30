package de.zonlykroks.customnpcs.client;

import de.zonlykroks.customnpcs.CustomNPCs;
import de.zonlykroks.customnpcs.entity.render.MechanicEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class CustomNPCsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(CustomNPCs.MECHANIC_TRADER_TYPE, MechanicEntityRenderer::new);
    }
}
