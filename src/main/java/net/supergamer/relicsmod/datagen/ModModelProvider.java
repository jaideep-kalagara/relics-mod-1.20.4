package net.supergamer.relicsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.supergamer.relicsmod.Items.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COMMON_RELIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCOMMON_RELIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.RARE_RELIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.EPIC_RELIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEGENDARY_RELIC, Models.GENERATED);
    }
}
