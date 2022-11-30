package de.zonlykroks.customnpcs.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class MechanicEntity extends MerchantEntity implements IAnimatable {

    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public MechanicEntity(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.npc.idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.world.isClient && !this.offers.isEmpty()) {
            this.beginTradeWith(player);
        }

        return ActionResult.success(this.world.isClient);
    }

    private void beginTradeWith(PlayerEntity customer) {
        this.setCustomer(customer);
        this.sendOffers(customer, this.getDisplayName(), 0);
    }

    @Override
    protected void afterUsing(TradeOffer offer) {
        int i = 3 + this.random.nextInt(4);
        if (offer.shouldRewardPlayerExperience()) {
            this.world.spawnEntity(new ExperienceOrbEntity(this.world, this.getX(), this.getY() + 0.5, this.getZ(), i));
        }
    }

    @Override
    protected void fillRecipes() {
        TradeOfferList tradeOffers = new TradeOfferList();

        tradeOffers.add(new TradeOffer(Items.SALMON.getDefaultStack(),Items.DIRT.getDefaultStack(),Integer.MAX_VALUE,0,0));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        throw new UnsupportedOperationException("Trader Entity cant have children!");
    }
}
