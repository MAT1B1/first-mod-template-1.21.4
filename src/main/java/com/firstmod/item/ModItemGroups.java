package com.firstmod.item;

import com.firstmod.FirstMod;
import com.firstmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import javax.swing.*;

public class ModItemGroups {

    public static final ItemGroup CURSED_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FirstMod.MOD_ID, "cursed_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CURSED_SOUL))
                    .displayName(Text.translatable("itemgroup.firstmod.cursed_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CURSED_SOUL);
                        entries.add(ModItems.MALEDITHE);
                        entries.add(ModBlocks.MALEDITHE_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        FirstMod.LOGGER.info("Registering a mod item group for " + FirstMod.MOD_ID);
    }
}
