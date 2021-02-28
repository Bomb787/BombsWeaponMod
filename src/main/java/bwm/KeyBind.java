package bwm;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBind {
	
	public static final KeyBinding FIREMODE = new KeyBinding("key.bombguns.firemode", GLFW.GLFW_KEY_B, "key.categories.bombguns");
	
	public static void register(IEventBus bus) {
		
		ClientRegistry.registerKeyBinding(FIREMODE);
		
	}

}
