package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Optional;

public class MusicDiscGaletaer extends Item {
    private static String playingMusicForBiome = "";

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

        final BlockPos playerPos = entity.getSteppingPos();

        Optional<RegistryKey<Biome>> biomeKey = world.getBiomeAccess().getBiome(playerPos).getKey();

        if (biomeKey.isPresent()) {
            final String currentBiome = biomeKey.get().getValue().toString().split(":")[1];

            if (!currentBiome.equals(playingMusicForBiome)) {
                playingMusicForBiome = currentBiome;
                ExampleMod.LOGGER.info("Playing music for biome: " + playingMusicForBiome);
                world.playSound(playerPos.getX(), playerPos.getY(), playerPos.getZ(),
                                ModSoundEvents.BLEACH, SoundCategory.MUSIC,
                                1f, 1f, false);
            }
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
