package bwm.core.init;

import com.mrcrayfish.guns.item.AmmoItem;
import com.mrcrayfish.guns.item.GunItem;

import bwm.WeaponsMod;
import bwm.util.ItemTiers;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			WeaponsMod.MOD_ID);
	
	public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot",
			() -> new Item(new Item.Properties().group(WeaponsMod.material)));

	public static final RegistryObject<Item> ALUMINIUM_NUGGET = ITEMS.register("aluminium_nugget",
			() -> new Item(new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
			() -> new Item(new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
			() -> new Item(new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate",
			() -> new Item(new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<Item> IRON_COAL_MIX = ITEMS.register("iron_coal_mix",
			() -> new Item(new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<Item> POLYMER_MIX = ITEMS.register("polymer_mix",
			() -> new Item(new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<Item> POLYMER_BAR = ITEMS.register("polymer_bar",
			() -> new Item(new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<Item> SHARPENING_KIT = ITEMS.register("sharpening_kit",
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	
	//Block Items
	public static final RegistryObject<BlockItem> BAUXITE_ORE = ITEMS.register("bauxite_ore", 
			() -> new BlockItem(BlockInit.BAUXITE_ORE.get(), new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<BlockItem> ALUMINIUM_BLOCK = ITEMS.register("aluminium_block", 
			() -> new BlockItem(BlockInit.ALUMINIUM_BLOCK.get(), new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<BlockItem> STEEL_BLOCK = ITEMS.register("steel_block", 
			() -> new BlockItem(BlockInit.STEEL_BLOCK.get(), new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<BlockItem> POLYMER_BLOCK = ITEMS.register("polymer_block", 
			() -> new BlockItem(BlockInit.POLYMER_BLOCK.get(), new Item.Properties().group(WeaponsMod.material)));
	
	//Sword Items
	public static final RegistryObject<SwordItem> ALUMINIUM_SWORD = ITEMS.register("aluminium_sword", 
			() -> new SwordItem(ItemTiers.ALUMINIUM, 0, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", 
			() -> new SwordItem(ItemTiers.STEEL, 0, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<SwordItem> SHARPENED_ALUMINIUM_SWORD = ITEMS.register("sharpened_aluminium_sword", 
			() -> new SwordItem(ItemTiers.SHARPENED_ALUMINIUM, 0, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<SwordItem> SHARPENED_STEEL_SWORD = ITEMS.register("sharpened_steel_sword", 
			() -> new SwordItem(ItemTiers.SHARPENED_STEEL, 0, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<SwordItem> SHARPENED_IRON_SWORD = ITEMS.register("sharpened_iron_sword", 
			() -> new SwordItem(ItemTiers.SHARPENED_IRON, 0, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<SwordItem> SHARPENED_DIAMOND_SWORD = ITEMS.register("sharpened_diamond_sword", 
			() -> new SwordItem(ItemTiers.SHARPENED_DIAMOND, 0, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<SwordItem> SHARPENED_NETHERITE_SWORD = ITEMS.register("sharpened_netherite_sword", 
			() -> new SwordItem(ItemTiers.SHARPENED_NETHERITE, 0, -2.4F, new Item.Properties().group(ItemGroup.COMBAT)));
	
	//Gun Items
	public static final RegistryObject<GunItem> BIG_IRON = ITEMS.register("big_iron", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	public static final RegistryObject<GunItem> GLOCK_17 = ITEMS.register("glock_17", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	//Bullet Items
	public static final RegistryObject<Item> AMMO762X39 = ITEMS.register("762x39", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
	public static final RegistryObject<Item> AMMO9X19 = ITEMS.register("9mm_parabellum", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
	
}