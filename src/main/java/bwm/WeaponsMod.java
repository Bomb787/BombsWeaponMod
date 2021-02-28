package bwm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mrcrayfish.guns.client.render.gun.ModelOverrides;

import bwm.client.ClientHandler;
import bwm.client.render.gun.model.Glock17Model;
import bwm.core.init.BlockInit;
import bwm.core.init.ItemInit;
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
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, WeaponsConfig.commonSpec);
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		
		MinecraftForge.EVENT_BUS.register(this);
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
		bus.addListener(this::onClientSetup);
		
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		
		System.out.println("Bomb's Weapon Mod Preinit, if you're reading this then I hope you're having a nice day :)");
		
	}
	
	private void onClientSetup(FMLClientSetupEvent event) {
		
		ModelOverrides.register(ItemInit.GLOCK_17.get(), new Glock17Model());
        
    }
	
}