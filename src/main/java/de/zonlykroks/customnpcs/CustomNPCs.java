package de.zonlykroks.customnpcs;

import de.zonlykroks.customnpcs.entity.MechanicEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class CustomNPCs implements ModInitializer {


    public static final EntityType<MechanicEntity> MECHANIC_TRADER_TYPE = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("customnpcs", "trader"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MechanicEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(MECHANIC_TRADER_TYPE, MechanicEntity.createMobAttributes());

        Item dollarItem = new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC));

        FuelRegistry.INSTANCE.add(dollarItem,5);

        Registry.register(Registry.ITEM, new Identifier("customnpcs", "dollar"), dollarItem);
    }
}
