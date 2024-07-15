package net.eddy0820.harmoniouscompats.core.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFoodValues
{
    public static final FoodProperties MISO_SOUP_WITH_BAMBOO_SPROUTS = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 4800, 0), 1.0F)
            .build();

    public static final FoodProperties CAVERN_EXPLORER_STEW = new FoodProperties.Builder()
            .nutrition(10)
            .saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 4800, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 4800, 0), 1.0F)
            .build();
}
