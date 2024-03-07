package net.supergamer.relicsmod.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Arrays;
import java.util.List;

public class RelicRandoms {

    public static final  List<StatusEffect> BadEffects = Arrays.asList(StatusEffects.HUNGER, StatusEffects.WEAKNESS, StatusEffects.BLINDNESS, StatusEffects.SLOWNESS);
    public static final List<StatusEffect> GoodEffects = Arrays.asList(StatusEffects.JUMP_BOOST, StatusEffects.HASTE, StatusEffects.HEALTH_BOOST, StatusEffects.STRENGTH);
}
