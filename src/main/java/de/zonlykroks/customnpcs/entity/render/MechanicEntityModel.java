package de.zonlykroks.customnpcs.entity.render;

import de.zonlykroks.customnpcs.entity.MechanicEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MechanicEntityModel extends AnimatedGeoModel<MechanicEntity> {


    @Override
    public Identifier getAnimationResource(MechanicEntity entity) {
        return new Identifier("customnpcs", "/animations/trader.animation.json");
    }

    @Override
    public Identifier getModelResource(MechanicEntity entity) {
        return new Identifier("customnpcs", "/geo/mechanic.geo.json");
    }

    @Override
    public Identifier getTextureResource(MechanicEntity entity) {
        return new Identifier("customnpcs", "/textures/entity/mechanic.png");
    }

    /*
    @Override
	public ResourceLocation getModelLocation(WolvesPupEntity object) {
		return new ResourceLocation(WolvesNPupsExpansion.MOD_ID, "geo/pup.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(WolvesPupEntity object) {
		return new ResourceLocation(WolvesNPupsExpansion.MOD_ID, "textures/entity/pup/pup.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(WolvesPupEntity animatable) {
		return new ResourceLocation(WolvesNPupsExpansion.MOD_ID, "animations/pup.animation.json");
	}
     */
}
