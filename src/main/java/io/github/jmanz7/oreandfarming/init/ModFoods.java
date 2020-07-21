package io.github.jmanz7.oreandfarming.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;


public final class ModFoods
{
    public static final Food POISONOUS_APPLE = new Food.Builder().hunger(6).saturation(2.4F / 8).effect(() -> new EffectInstance(Effects.POISON, 5 * 20), 0.6F).build();
    public static final Food STEEL_APPLE = new Food.Builder().hunger(4).saturation(9.6F / 8).effect(() -> new EffectInstance(Effects.RESISTANCE, 60 * 20, 2), 1.0F).effect(() -> new EffectInstance(Effects.HASTE, 60 * 20), 1.0F).setAlwaysEdible().build();
    public static final Food DIAMOND_APPLE = new Food.Builder().hunger(4).saturation(9.6F / 8).effect(() -> new EffectInstance(Effects.ABSORPTION, (int)(2.5 * 60 * 20), 1), 1.0F).effect(() -> new EffectInstance(Effects.REGENERATION,  10 * 20), 1.0F).setAlwaysEdible().build();
    public static final Food ENCHANTED_DIAMOND_APPLE = new Food.Builder().hunger(4).saturation(9.6F / 8).effect(() -> new EffectInstance(Effects.ABSORPTION, 5 * 60 * 20, 5), 1.0F).effect(() -> new EffectInstance(Effects.REGENERATION,  30 * 20, 1), 1.0F).effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE,  10 * 60 * 20), 1.0F).effect(() -> new EffectInstance(Effects.RESISTANCE,  10 * 60 * 20, 1), 1.0F).effect(() -> new EffectInstance(Effects.HASTE, 5 * 60 * 20), 1.0F).setAlwaysEdible().build();
}
