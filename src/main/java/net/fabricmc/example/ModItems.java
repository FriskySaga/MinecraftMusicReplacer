package net.fabricmc.example;

// fabricmc imports
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

// minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems extends Items {
    public static final Item MUSICAL_ROCK =
            registerItem("musical_rock",
                         new Item(new FabricItemSettings().group(ModItemGroup.MUSICAL)));

    public static final Item MUSICAL_BOOTS =
            registerItem("musical_boots",
                         new MusicalBoots());

    protected static Item registerItem(String name, Item item) {
        Identifier id = new Identifier(ExampleMod.MOD_ID, name);
        return Registry.register(Registry.ITEM, id, item);
    }

    public static void register() {}
}
