package net.fabricmc.example;

// minecraft imports
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MusicalBoots extends ArmorItem {
    public MusicalBoots() {
        super(ModArmorMaterials.MUSICAL, EquipmentSlot.FEET, new FabricItemSettings().group(ModItemGroup.MUSICAL));
    }
}
