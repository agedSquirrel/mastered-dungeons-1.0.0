package net.squirrel.mdungeons.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
   public static final FoodComponent GOLDEN_STEW = new FoodComponent.Builder()
           .alwaysEdible().nutrition(6).saturationModifier(1f)
           .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1200, 1), 1f)
           .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 10), 0.5f)
           .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 3), 0.2f)
           .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 3), 0.2f)
           .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 0), 1f)
           .build();
}
