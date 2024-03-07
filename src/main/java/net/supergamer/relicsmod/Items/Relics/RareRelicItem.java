package net.supergamer.relicsmod.Items.Relics;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.supergamer.relicsmod.util.RelicRandoms;

import java.util.Random;

public class RareRelicItem extends Item {
    public RareRelicItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            Random random = new Random();


            // Give bad effect to the player :(
            if (!random.nextBoolean()) {
                int randomIndex = random.nextInt(RelicRandoms.BadEffects.size());

                StatusEffect randomItem = RelicRandoms.BadEffects.get(randomIndex);
                user.addStatusEffect(new StatusEffectInstance(randomItem, -1, 2));

            } else {
                // Give good effect to the player :)
                int randomIndex = random.nextInt(RelicRandoms.GoodEffects.size());

                StatusEffect randomItem = RelicRandoms.GoodEffects.get(randomIndex);
                user.addStatusEffect(new StatusEffectInstance(randomItem, -1, 2));


            }


        }
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
}
