package bwm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mrcrayfish.guns.client.render.gun.ModelOverrides;

import bwm.client.render.gun.model.AK103Model;
import bwm.client.render.gun.model.AK74Model;
import bwm.client.render.gun.model.GaussRifleModel;
import bwm.client.render.gun.model.Glock17Model;
import bwm.client.render.gun.model.TestGunModel;
import bwm.core.init.BlockInit;
import bwm.core.init.ItemInit;
import bwm.core.init.SoundInit;
import bwm.itemgroups.BulletItemGroup;
import bwm.itemgroups.GunItemGroup;
import bwm.itemgroups.MaterialItemGroup;
import bwm.world.OreGeneration;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is the main mod class, this is where we make sure everything is registered and the mod runs correctly.
 * Make sure to add "@Mod("xxx"), replace xxx with your mod id.
 * Author: Bomb787
 */
@Mod("bwm")
public class WeaponsMod {
	
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "bwm";
	
	//Creative Tabs
	public static final ItemGroup material = new MaterialItemGroup();
	//public static final ItemGroup pattern = new PatternItemGroup();
	//public static final ItemGroup part = new PartItemGroup();
	public static final ItemGroup gun = new GunItemGroup();
	public static final ItemGroup bullet = new BulletItemGroup();
	
	public WeaponsMod() {
		
		//This is where we add the config for the mod.
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WeaponsConfig.commonSpec);
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		//Registers all of the Deferred Registers from our init classes.
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		SoundInit.SOUNDS.register(bus);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
		bus.addListener(this::onClientSetup);
		
	}
	
	//This is the common setup event, it doesn't do much.
	private void setup(final FMLCommonSetupEvent event) {
		
		System.out.println("Bomb's Weapon Mod Preinit, if you're reading this then I hope you're having a nice day :)");
		
	}
	
	//This is the client setup event.
	private void onClientSetup(FMLClientSetupEvent event) {
		
		//Register all of our models.
		ModelOverrides.register(ItemInit.GLOCK_17.get(), new Glock17Model());
		ModelOverrides.register(ItemInit.GAUSS_RIFLE.get(), new GaussRifleModel());
		ModelOverrides.register(ItemInit.AK_74.get(), new AK74Model());
		ModelOverrides.register(ItemInit.AK_103.get(), new AK103Model());
		ModelOverrides.register(ItemInit.TEST_GUN.get(), new TestGunModel());
        
    }
	
}
