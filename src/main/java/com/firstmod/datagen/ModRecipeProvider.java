package com.firstmod.datagen;

import com.firstmod.block.ModBlocks;
import com.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MALEDITHE_BLOCK, ModItems.MALEDITHE);

                createShapeless(RecipeCategory.MISC, ModItems.CURSED_SOUL)
                        .input(ModBlocks.MALEDITHE_BLOCK)
                        .criterion(hasItem(ModBlocks.MALEDITHE_BLOCK), conditionsFromItem(ModItems.CURSED_SOUL))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
