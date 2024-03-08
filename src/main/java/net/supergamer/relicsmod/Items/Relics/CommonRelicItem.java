package net.supergamer.relicsmod.Items.Relics;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.supergamer.relicsmod.util.RelicRandoms;

import java.util.Random;

public class CommonRelicItem extends Item {
    public CommonRelicItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {

            Random random = new Random();


            // Give bad effect to the player :(
            if (!random.nextBoolean()) {
                RelicRandoms.giveBadStatusEffect(user, 1);
            } else {
                RelicRandoms.giveGoodStatusEffect(user, 1);
            }


        }
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
}
