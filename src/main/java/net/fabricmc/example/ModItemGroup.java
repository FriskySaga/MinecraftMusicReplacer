package net.fabricmc.example;

// fabricmc imports
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

// minecraft imports
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup MUSICAL = FabricItemGroupBuilder.build(
            new Identifier(ExampleMod.MOD_ID, "musical"),
            () -> new ItemStack(ModItems.MUSICAL_ROCK));
}