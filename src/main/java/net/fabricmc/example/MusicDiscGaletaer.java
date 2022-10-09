package net.fabricmc.example;

// minecraft imports
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

// java imports
import java.util.Optional;

public class MusicDiscGaletaer extends Item {
    public MusicDiscGaletaer() {
        super(new FabricItemSettings().group(ModItemGroup.MUSICAL));
    }

    /**
     * Called on both the client and the server every tick if the item is in the player's inventory.
     *
     * This method is called on both the logical client and logical server, so take caution
     * when overriding this method. The logical side can be checked using {@link World#isClient}.
     *
     * @param stack
     * @param world
     * @param entity The entity holding the item; usually a player
     * @param slot
     * @param selected Whether the item is in the selected hotbar slot
     */
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        Optional<RegistryKey<Biome>> biomeKey = world.getBiomeAccess().getBiome(entity.getSteppingPos()).getKey();
        if (biomeKey.isPresent())
        {
            ExampleMod.LOGGER.info("Biome Value: " + biomeKey.get().getValue().toString());
        }
    }

    /**
     * This item is fireproof to enable custom background music in hostile environments.
     *
     * @return Always true
     */
    @Override
    public boolean isFireproof() {
        return true;
    }
}
