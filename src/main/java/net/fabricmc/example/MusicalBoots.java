package net.fabricmc.example;

// minecraft imports
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class MusicalBoots extends ArmorItem {
    public MusicalBoots() {
        super(ModArmorMaterials.MUSICAL, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.MUSICAL));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
