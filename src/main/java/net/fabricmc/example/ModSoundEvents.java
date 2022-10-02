package net.fabricmc.example;

// minecraft imports
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents extends SoundEvents {
    public static final SoundEvent BLEACH = registerSoundEvent("bleach");

    protected static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ExampleMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void register() {}
}
