package net.supergamer.relicsmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.supergamer.relicsmod.Items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Objects;

public class RelicsMod implements ModInitializer {

	public static final String MOD_ID = "relicsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting mod " + MOD_ID + "...");

		ServerPlayerEvents.COPY_FROM.register((original, cloned, alive) -> {
			Collection<StatusEffectInstance> oldstatusEffects = original.getStatusEffects();
			LOGGER.info(oldstatusEffects.toString());

			for (StatusEffectInstance effect : oldstatusEffects) {
				StatusEffect oldEffect = effect.getEffectType(); // Get the name of the effect
				int oldEffectAmplifier = effect.getAmplifier(); // Amplifier starts from 0, so add 1 to get the level
				if (!cloned.getWorld().isClient()) {
					     cloned.addStatusEffect(new StatusEffectInstance(oldEffect, -1, oldEffectAmplifier));
				}
			}
		});

		ModItems.registerModItems();
	}
}