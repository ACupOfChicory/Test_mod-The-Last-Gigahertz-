package net.acupofchicory.testmod.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;


public class ModFoodComponents {
    public static final FoodComponent INDUSTRIAL_BREAKFAST = new FoodComponent.Builder().hunger(5).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 1f)
            .alwaysEdible()
            .build();


}
