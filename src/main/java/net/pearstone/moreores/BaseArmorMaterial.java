package net.pearstone.moreores;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public class BaseArmorMaterial implements ArmorMaterial {

    private final int enchantAbility;
    private final int[] durability, damageReduction;
    private final float knockbackResistance, toughness;
    private final String name;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairMaterial;

    public BaseArmorMaterial(int enchantAbility, int[] durability, int[] damageReduction, float knockbackResistance, float toughness, String name,
                             SoundEvent equipSound, Supplier<Ingredient> repairMaterial) {
        this.enchantAbility = enchantAbility;
        this.durability = durability;
        this.damageReduction = damageReduction;
        this.knockbackResistance = knockbackResistance;
        this.toughness = toughness;
        this.name = name;
        this.equipSound = equipSound;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return this.durability[slot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.damageReduction[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantAbility;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
