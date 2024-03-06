package net.supergamer.relicsmod;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RelicsMod implements ModInitializer {

	public static final String MOD_ID = "relicsmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting mod " + MOD_ID + "...");

	}
}