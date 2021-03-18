package bwm.core.init;

import bwm.WeaponsMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class is where all of the mod's sounds are registered
 * Author: Bomb787
 */
public class SoundInit {
	
	/*
     * This creates a Deferred Register where all of the sounds will be registered
     * This is called and added to the event bus in the main mod file.
     */
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WeaponsMod.MOD_ID);
	
	public static final RegistryObject<SoundEvent> BOOM = register("item.trashcan.boom");
	
	public static final RegistryObject<SoundEvent> LAUGH = register("item.trashcan.reload");
	
	public static final RegistryObject<SoundEvent> GAUSS_FIRE = register("item.gauss_rifle.fire");
	
	public static final RegistryObject<SoundEvent> AKM_FIRE = register("item.akm.fire");
	
	public static final RegistryObject<SoundEvent> AK_74_FIRE = register("item.ak_74.fire");
	
	public static final RegistryObject<SoundEvent> GLOCK_FIRE = register("item.glock.fire");
	
	public static final RegistryObject<SoundEvent> M4A1_FIRE = register("item.m4a1.fire");
	
	public static final RegistryObject<SoundEvent> HK417_FIRE = register("item.hk417.fire");
	
	//Method to help us register sounds
	private static RegistryObject<SoundEvent> register(String key) {
		
        return SOUNDS.register(key, () -> new SoundEvent(new ResourceLocation(WeaponsMod.MOD_ID, key)));
        
    }
	
}
