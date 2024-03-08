package net.supergamer.relicsmod.util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RelicRandoms {

    public static final  List<StatusEffect> BadEffects = Arrays.asList(StatusEffects.HUNGER, StatusEffects.WEAKNESS, StatusEffects.BLINDNESS, StatusEffects.SLOWNESS);
    public static final List<StatusEffect> GoodEffects = Arrays.asList(StatusEffects.JUMP_BOOST, StatusEffects.HASTE, StatusEffects.HEALTH_BOOST, StatusEffects.STRENGTH);

    public static void giveBadStatusEffect(PlayerEntity user, int level) {
        Random random = new Random();
        int randomIndex = random.nextInt(BadEffects.size());

        StatusEffect randomItem = BadEffects.get(randomIndex);
        user.addStatusEffect(new StatusEffectInstance(randomItem, -1, level - 1));
    }

    public static void giveGoodStatusEffect(PlayerEntity user, int level) {
        Random random = new Random();
        int randomIndex = random.nextInt(GoodEffects.size());

        StatusEffect randomItem = GoodEffects.get(randomIndex);
        user.addStatusEffect(new StatusEffectInstance(randomItem, -1, level - 1));
    }
}
