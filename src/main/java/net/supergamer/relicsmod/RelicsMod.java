package net.supergamer.relicsmod;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.supergamer.relicsmod.Items.ModItems;
import net.supergamer.relicsmod.util.ModLootableModifiers;
import net.supergamer.relicsmod.util.RelicRandoms;
import org.apache.logging.log4j.core.jmx.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

import static com.mojang.brigadier.builder.LiteralArgumentBuilder.literal;
import static com.mojang.brigadier.builder.RequiredArgumentBuilder.argument;

public class RelicsMod implements ModInitializer {

	public static final String MOD_ID = "relicsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting mod " + MOD_ID + "...");

		ServerPlayerEvents.COPY_FROM.register((original, cloned, alive) -> {
			Collection<StatusEffectInstance> oldstatusEffects = original.getStatusEffects();

			for (StatusEffectInstance effect : oldstatusEffects) {
				StatusEffect oldEffect = effect.getEffectType(); // Get the name of the effect
				int oldEffectAmplifier = effect.getAmplifier(); // Amplifier starts from 0, so add 1 to get the level


				cloned.addStatusEffect(new StatusEffectInstance(oldEffect, -1, oldEffectAmplifier, false,
						false, true));

				if (RelicRandoms.GoodEffects.contains(oldEffect)) {
					cloned.removeStatusEffect(effect.getEffectType());
					oldstatusEffects = original.getStatusEffects();
				}

			}
		});


		ModItems.registerModItems();
		ModLootableModifiers.modifyLootTables();
	}
}