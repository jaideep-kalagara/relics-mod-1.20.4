package net.supergamer.relicsmod.Items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.supergamer.relicsmod.Items.custom.relics.*;
import net.supergamer.relicsmod.RelicsMod;

public class ModItems {


    public static Item RARE_RELIC = registerItems(new Identifier(RelicsMod.MOD_ID, "rare_relic"),
            new RareRelicItem(new FabricItemSettings()));

    public static Item COMMON_RELIC = registerItems(new Identifier(RelicsMod.MOD_ID, "common_relic"),
            new CommonRelicItem(new FabricItemSettings()));

    public static Item UNCOMMON_RELIC = registerItems(new Identifier(RelicsMod.MOD_ID, "uncommon_relic"),
            new UncommonRelicItem(new FabricItemSettings()));

    public static Item EPIC_RELIC = registerItems(new Identifier(RelicsMod.MOD_ID, "epic_relic"),
            new EpicRelicItem(new FabricItemSettings()));

    public static Item LEGENDARY_RELIC = registerItems(new Identifier(RelicsMod.MOD_ID, "legendary_relic"),
            new LegendaryRelicItem(new FabricItemSettings()));

    public static Item registerItems(Identifier name, Item item) {
        return Registry.register(Registries.ITEM, name, item);
    }

    public static void registerModItems() {
        RelicsMod.LOGGER.info("Registering items for mod " + RelicsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(COMMON_RELIC);
            content.add(UNCOMMON_RELIC);
            content.add(RARE_RELIC);
            content.add(EPIC_RELIC);
            content.add(LEGENDARY_RELIC);
        });
    }
}
