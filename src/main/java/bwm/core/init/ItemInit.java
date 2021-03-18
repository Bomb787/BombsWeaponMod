package bwm.core.init;

import com.mrcrayfish.guns.item.AmmoItem;
import com.mrcrayfish.guns.item.GunItem;
import bwm.geo.TestGunRenderer;

import bwm.WeaponsMod;
import bwm.geo.TestGunItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class is where all of the mod's items are registered
 * Author: Bomb787
 */
public class ItemInit {
	
	/*
     * This creates a Deferred Register where all of the items will be registered
     * This is called and added to the event bus in the main mod file.
     */
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			WeaponsMod.MOD_ID);
	
	public static final RegistryObject<TestGunItem> TEST_GUN = ITEMS.register("geotest",
			() -> new TestGunItem(new Item.Properties().group(WeaponsMod.material).setISTER(() -> TestGunRenderer::new)));
	
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
	
	//Block Items
	public static final RegistryObject<BlockItem> BAUXITE_ORE = ITEMS.register("bauxite_ore", 
			() -> new BlockItem(BlockInit.BAUXITE_ORE.get(), new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<BlockItem> ALUMINIUM_BLOCK = ITEMS.register("aluminium_block", 
			() -> new BlockItem(BlockInit.ALUMINIUM_BLOCK.get(), new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<BlockItem> STEEL_BLOCK = ITEMS.register("steel_block", 
			() -> new BlockItem(BlockInit.STEEL_BLOCK.get(), new Item.Properties().group(WeaponsMod.material)));
	
	public static final RegistryObject<BlockItem> POLYMER_BLOCK = ITEMS.register("polymer_block", 
			() -> new BlockItem(BlockInit.POLYMER_BLOCK.get(), new Item.Properties().group(WeaponsMod.material)));
	
	//Gun Items
	public static final RegistryObject<GunItem> BIG_IRON = ITEMS.register("big_iron", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	public static final RegistryObject<GunItem> GLOCK_17 = ITEMS.register("glock_17", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	public static final RegistryObject<GunItem> TRASHCAN = ITEMS.register("trashcan", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	public static final RegistryObject<GunItem> AK_74 = ITEMS.register("ak_74", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	public static final RegistryObject<GunItem> AK_103 = ITEMS.register("ak_103", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	public static final RegistryObject<GunItem> GAUSS_RIFLE = ITEMS.register("gauss_rifle", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	public static final RegistryObject<GunItem> HK417 = ITEMS.register("hk417", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	public static final RegistryObject<GunItem> M4A1 = ITEMS.register("m4a1", () -> new GunItem(new Item.Properties().maxStackSize(1).group(WeaponsMod.gun)));
	
	//Bullet Items
	public static final RegistryObject<Item> AMMO762X39 = ITEMS.register("762x39", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
	public static final RegistryObject<Item> AMMO9X19 = ITEMS.register("9mm_parabellum", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
	public static final RegistryObject<Item> GARBAGE = ITEMS.register("garbage", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
	public static final RegistryObject<Item> AMMO545X39 = ITEMS.register("545x39", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
	public static final RegistryObject<Item> REDSTONE_BULLET = ITEMS.register("redstone_bullet", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
	public static final RegistryObject<Item> AMMO762x51 = ITEMS.register("762x51", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
	public static final RegistryObject<Item> AMMO556x45 = ITEMS.register("556x45", () -> new AmmoItem(new Item.Properties().group(WeaponsMod.bullet)));
	
}
