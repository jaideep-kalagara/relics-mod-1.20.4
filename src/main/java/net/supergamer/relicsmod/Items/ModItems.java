package net.supergamer.relicsmod.Items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.supergamer.relicsmod.Items.Relics.RareRelicItem;
import net.supergamer.relicsmod.RelicsMod;

public class ModItems {


    public static Item RARE_RELIC = registerItems(new Identifier(RelicsMod.MOD_ID, "rare_relic"),
            new RareRelicItem(new FabricItemSettings().maxDamage(1)));

    public static Item registerItems(Identifier name, Item item) {
        return Registry.register(Registries.ITEM, name, item);
    }

    public static void registerModItems() {
        RelicsMod.LOGGER.info("Registering items for mod " + RelicsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(RARE_RELIC);
        });
    }
}
