package bwm.util;

import java.util.function.Supplier;

import bwm.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ItemTiers implements IItemTier{
	
	//Mining level, durability, mining speed, damage - 1, enchantability, repair material
	
	ALUMINIUM(1, 192, 5.0F, 4.0F, 7, () -> {
		
		return Ingredient.fromItems(ItemInit.ALUMINIUM_INGOT.get());
	
	}),
	
	STEEL(2, 1024, 7.0F, 6.0F, 16, () -> {
		
		return Ingredient.fromItems(ItemInit.STEEL_INGOT.get());
		
	}),
	
	SHARPENED_NETHERITE(5, 1792, 10.0F, 10.0F, 12, () -> {
		
		return null;
		
	}),
	
	SHARPENED_DIAMOND(4, 1280, 9.0F, 9.0F, 7, () -> {
		
		return null;
		
	}),

	SHARPENED_IRON(3, 192, 7.0F, 8.0F, 11, () -> {
	
		return null;
	
	}),
	
	SHARPENED_STEEL(3, 768, 8.0F, 9.0F, 13, () -> {
		
		return null;
		
	}),
	
	SHARPENED_ALUMINIUM(2, 128, 6.0F, 7.0F, 4, () -> {
		
		return null;
		
	});
	
	private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;
    
	
	ItemTiers(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
		
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
		
	}

	@Override
	public int getMaxUses() {
		
		return maxUses;
		
	}

	@Override
	public float getEfficiency() {
		
		return efficiency;
		
	}

	@Override
	public float getAttackDamage() {
		
		return attackDamage;
		
	}

	@Override
	public int getHarvestLevel() {
		
		return harvestLevel;
		
	}

	@Override
	public int getEnchantability() {
		
		return enchantability;
		
	}

	@Override
	public Ingredient getRepairMaterial() {
		
		return repairMaterial.get();
		
	}
	
	

}
